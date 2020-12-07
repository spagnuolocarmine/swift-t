/*
 * Copyright 2014 University of Chicago and Argonne National Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
#include "src/turbine/executors/coaster_executor.h"

#include "src/turbine/executors/exec_interface.h"

#include "src/tcl/util.h"
#include "src/turbine/turbine-checks.h"
#include "src/util/debug.h"

#include <assert.h>
#include <limits.h>
#include <unistd.h>

#include <table_lp.h>

/* Check coaster_rc, if failed print message and return return code. */
#define COASTER_CHECK(crc, err_rc) {                                  \
  coaster_rc __crc = (crc);                                           \
  turbine_condition(__crc == COASTER_SUCCESS, (err_rc),               \
        "Error in Coaster execution: %s (%s)",                        \
        coaster_last_err_info(), coaster_rc_string(__crc)); }

#define COASTER_CHECK_GOTO(crc, err_rc, var, label) {                 \
  coaster_rc __crc = (crc);                                           \
  turbine_cond_goto(__crc == COASTER_SUCCESS, (err_rc),               \
        var, label,                                                   \
        "Error in Coaster execution: %s (%s)",                        \
        coaster_last_err_info(), coaster_rc_string(__crc)); }

#define COASTER_DEFAULT_SERVICE_URL "127.0.0.1:53001"
/*
  Default is nearest power-of-two to Swift/K default of 201
  Tuning depends on multiple potential factors:
  - We want the coaster service queue full and resources busy,
    to maximise throughput
  - In the case of multiple coaster clients, we don't want one "greedy"
    client taking all the work and causing imbalance.
  - Furthermore, if the clients can be connected to different services in
    future, we want to avoid imbalance even more.
  - There is some memory/CPU overhead associated with managing many jobs
 */
#define COASTER_DEFAULT_MAX_PARALLELISM 256

/* Settings keys */
#define COASTER_SETTING_SERVICE_URL "coasterServiceURL"
#define COASTER_SETTING_JOB_MANAGER "jobManager"
#define COASTER_SETTING_SLOTS "maxParallelTasks"

/*
  Coaster context info, e.g. configuration that remains constant
  over entire run.
 */
typedef struct {
  char *service_url;
  size_t service_url_len;
  char *default_job_manager;
  size_t default_job_manager_len;
  int total_slots;
  coaster_settings *settings;
} coaster_context;

/*
  Information about an active task.
 */
typedef struct {
  turbine_task_callbacks callbacks;
  coaster_job *job;
} coaster_active_task;

/*
  State of an executor
 */
typedef struct coaster_state {
  // Overall context
  coaster_context *context;

  // Actual Coaster client
  coaster_client *client;

  // Config ID for server
  coaster_config_id *config;

  // Information about slots available
  turbine_exec_slot_state slots;

  // List with coaster_active_task data.  Key is Coaster job ID.
  struct table_lp active_tasks;
} coaster_state;

#define ACTIVE_TASKS_INIT_CAPACITY 32

static turbine_exec_code
coaster_configure(turbine_context tcx, void **context,
    const char *config, size_t config_len);

static turbine_exec_code
coaster_start(turbine_context tcx, void *context, void **state);

static turbine_exec_code coaster_stop(turbine_context tcx, void *state);
static turbine_exec_code
coaster_cleanup_active(coaster_state *state);

static turbine_exec_code coaster_free(turbine_context tcx, void *context);

static turbine_exec_code
coaster_wait(turbine_context tcx, void *state,
    turbine_completed_task *completed, int *ncompleted);

static turbine_exec_code
coaster_poll(turbine_context tcx, void *state,
    turbine_completed_task *completed, int *ncompleted);

static turbine_exec_code
coaster_slots(turbine_context tcx, void *state,
    turbine_exec_slot_state *slots);

static turbine_exec_code
coaster_max_slots(turbine_context tcx, void *context, int *max);

static turbine_exec_code
check_completed(turbine_context tcx, coaster_state *state,
    turbine_completed_task *completed, int *ncompleted,
    bool wait_for_completion);

static turbine_exec_code
init_coaster_executor(turbine_executor *exec)
{
  exec->name = COASTER_EXECUTOR_NAME;

  exec->context = NULL;
  exec->state = NULL;
  exec->started = false;

  // Initialize all function pointers
  exec->configure = coaster_configure;
  exec->start = coaster_start;
  exec->stop = coaster_stop;
  exec->free = coaster_free;
  exec->wait = coaster_wait;
  exec->poll = coaster_poll;
  exec->slots = coaster_slots;
  exec->max_slots = coaster_max_slots;

  return TURBINE_EXEC_SUCCESS;
}

turbine_code
coaster_executor_register(void)
{
  turbine_exec_code ec;
  turbine_executor exec;
  ec = init_coaster_executor(&exec);
  TURBINE_EXEC_CHECK_MSG(ec, TURBINE_ERROR_EXTERNAL,
               "error initializing Coaster executor");

  ec = turbine_add_async_exec(exec);
  TURBINE_EXEC_CHECK_MSG(ec, TURBINE_ERROR_EXTERNAL,
               "error registering Coaster executor with Turbine");

  return TURBINE_SUCCESS;
}

/*
  Remove setting from settings and copy to value.
  val: Set to value, or copy of default_val if not present.
       Caller is responsible for freeing.
  default_val: default value, can be NULL.
 */
static turbine_exec_code
extract_setting(coaster_settings *settings,
          const char *key, size_t key_len,
          char **val, size_t *val_len,
          const char *default_val, size_t default_val_len,
          bool remove)
{
  coaster_rc crc;

  const char *tmp_val;
  size_t tmp_val_len;

  crc = coaster_settings_get(settings, key, key_len,
                             &tmp_val, &tmp_val_len);
  COASTER_CHECK(crc, TURBINE_ERROR_INVALID);

  if (tmp_val == NULL)
  {
    tmp_val = default_val;
    tmp_val_len = default_val_len;
  }

  if (tmp_val == NULL)
  {
    *val = NULL;
    *val_len = 0;
  }
  else
  {
    *val = malloc(tmp_val_len + 1);
    EXEC_MALLOC_CHECK(*val);

    memcpy(*val, tmp_val, tmp_val_len);
    (*val)[tmp_val_len] = '\0';
    *val_len = tmp_val_len;
  }

  if (remove)
  {
    crc = coaster_settings_remove(settings, key, key_len);
    COASTER_CHECK(crc, TURBINE_ERROR_INVALID);
  }

  return TURBINE_EXEC_SUCCESS;
}


static turbine_exec_code
coaster_configure(turbine_context tcx, void **context,
    const char *config, size_t config_len)
{
  turbine_exec_code ec;

  coaster_context *cx = malloc(sizeof(coaster_context));
  EXEC_MALLOC_CHECK(cx);

  coaster_rc crc = coaster_settings_create(&cx->settings);
  COASTER_CHECK(crc, TURBINE_EXEC_OOM);

  crc = coaster_settings_parse(cx->settings, config, config_len, ',');
  // Better reporting for config errors
  turbine_condition(crc != COASTER_ERROR_INVALID, TURBINE_ERROR_INVALID,
      "Error parsing settings string: \"%.*s\"\n%s",
      (int)config_len, config, coaster_last_err_info());
  COASTER_CHECK(crc, TURBINE_EXEC_OOM);

#ifdef ENABLE_DEBUG_COASTER
  int count;
  const char **keys;
  size_t *key_lens;
  coaster_settings_keys(cx->settings, &keys, &key_lens, &count);
  DEBUG_COASTER("Coaster settings (%d key-value pairs:", count);
  for (int i = 0; i < count; i++) {
    const char *val;
    size_t val_len;
    coaster_settings_get(cx->settings, keys[i], key_lens[i],
          &val, &val_len);
    DEBUG_COASTER("Key: %.*s=%.*s", (int)key_lens[i], keys[i],
                  (int)val_len, val);
  }
  free(keys);
  free(key_lens);
#endif

  ec = extract_setting(cx->settings, COASTER_SETTING_SERVICE_URL,
      strlen(COASTER_SETTING_SERVICE_URL), &cx->service_url,
      &cx->service_url_len, COASTER_DEFAULT_SERVICE_URL,
      strlen(COASTER_DEFAULT_SERVICE_URL), true);
  EXEC_CHECK(ec);
  DEBUG_COASTER("Service URL: %.*s",
        (int)cx->service_url_len, cx->service_url);

  ec = extract_setting(cx->settings, COASTER_SETTING_JOB_MANAGER,
      strlen(COASTER_SETTING_JOB_MANAGER), &cx->default_job_manager,
      &cx->default_job_manager_len, NULL, 0, true);
  EXEC_CHECK(ec);

  DEBUG_COASTER("Default jobManager: %.*s",
        (int)cx->default_job_manager_len,
             cx->default_job_manager);

  cx->total_slots = COASTER_DEFAULT_MAX_PARALLELISM;
  const char *slots_str;
  size_t slots_str_len;
  crc = coaster_settings_get(cx->settings, COASTER_SETTING_SLOTS,
       strlen(COASTER_SETTING_SLOTS), &slots_str, &slots_str_len);
  COASTER_CHECK(crc, TURBINE_ERROR_INVALID);

  if (slots_str != NULL) {
    char *end;
    long slots_val = strtol(slots_str, &end, 10);
    turbine_condition(end != slots_str && end[0] == '\0',
        TURBINE_ERROR_INVALID, "%s value was not integer: \"%s\"",
        COASTER_SETTING_SLOTS, slots_str);

    turbine_condition(slots_val >= 1 && slots_val <= INT_MAX,
        TURBINE_ERROR_INVALID, "%s setting was not positive int value: "
        "%li", COASTER_SETTING_SLOTS, slots_val);

    cx->total_slots = (int)slots_val;
    // Don't pass job manager along with other settings
    crc = coaster_settings_remove(cx->settings,
        COASTER_SETTING_SLOTS, strlen(COASTER_SETTING_SLOTS));
    COASTER_CHECK(crc, TURBINE_ERROR_INVALID);
  }

  DEBUG_COASTER("Max slots: %i", cx->total_slots);

  *context = cx;
  return TURBINE_SUCCESS;
}

static turbine_exec_code
coaster_start(turbine_context tcx, void *context, void **state)
{
  assert(context != NULL);
  coaster_context *cx = context;
  coaster_state *s = malloc(sizeof(coaster_state));
  EXEC_MALLOC_CHECK(s);

  turbine_exec_code ec;
  bool started = false;
  bool active_tasks_init = false;

  s->context = cx;

  s->slots.used = 0;
  s->slots.total = cx->total_slots;

  active_tasks_init = table_lp_init(&s->active_tasks,
                         ACTIVE_TASKS_INIT_CAPACITY);
  turbine_cond_goto(active_tasks_init, TURBINE_EXEC_OOM, ec, error,
                    "Could not init coaster table")


  coaster_rc crc = coaster_client_start(cx->service_url,
                        cx->service_url_len, &s->client);
  COASTER_CHECK_GOTO(crc, TURBINE_EXEC_OTHER, ec, error);

  started = true;

  // Setup service config
  crc = coaster_apply_settings(s->client, cx->settings, &s->config);
  COASTER_CHECK_GOTO(crc, TURBINE_EXEC_OTHER, ec, error);

  *state = s;

  return TURBINE_EXEC_SUCCESS;

error:
  if (started)
  {
    coaster_stop(tcx, s);
  }
  else
  {
    // Just free - didn't start
    if (active_tasks_init)
    {
      table_lp_free_callback(&s->active_tasks, false, NULL);
    }
    free(s);
  }
  return ec;
}

static turbine_exec_code
coaster_stop(turbine_context tcx, void *state)
{
  coaster_state *s = state;

  coaster_rc crc = coaster_client_stop(s->client);
  COASTER_CHECK(crc, TURBINE_EXEC_OTHER);

  crc = coaster_config_id_free(s->config);
  COASTER_CHECK(crc, TURBINE_EXEC_OTHER);

  turbine_exec_code ec = coaster_cleanup_active(s);
  EXEC_CHECK(ec);

  free(s);
  return TURBINE_EXEC_SUCCESS;
}

/*
  Check any outstanding tasks at shutdown.
  Should be called after stopping coaster client and thread.
 */
static turbine_exec_code
coaster_cleanup_active(coaster_state *state)
{
  coaster_rc crc;

  TABLE_LP_FOREACH(&state->active_tasks, entry)
  {
    int64_t job_id = entry->key;
    coaster_active_task *task = entry->data;

    char *job_str;
    size_t job_str_len;
    crc = coaster_job_to_string(task->job, &job_str, &job_str_len);
    fprintf(stderr, "Coaster job %"PRId64" still running at shutdown: "
                    "%s\n", job_id, job_str);
    free(job_str);

    // Free coaster job now that client is shut down
    crc = coaster_job_free(task->job);
    COASTER_CHECK(crc, TURBINE_EXEC_OTHER);

    Tcl_Obj *cb = task->callbacks.success.code;
    if (cb != NULL)
    {
      Tcl_DecrRefCount(cb);
    }

    cb = task->callbacks.failure.code;
    if (cb != NULL)
    {
      Tcl_DecrRefCount(cb);
    }
    free(task);
  }

  // Free table memory
  table_lp_free_callback(&state->active_tasks, false, NULL);
  return TURBINE_EXEC_SUCCESS;
}

static turbine_exec_code
coaster_free(turbine_context tcx, void *context)
{
  coaster_context *cx = context;
  if (cx != NULL) {
    coaster_settings_free(cx->settings);
    free(cx->service_url);
    free(cx);
  }

  return TURBINE_EXEC_SUCCESS;
}

turbine_code
coaster_default_job_manager(const turbine_executor *exec,
       const char **job_manager, size_t *job_manager_len)
{
  assert(exec != NULL);
  coaster_state *s = exec->state;
  turbine_condition(s != NULL, TURBINE_ERROR_INVALID,
        "Invalid state for coaster executor");
  coaster_context *cx = s->context;
  turbine_condition(cx != NULL, TURBINE_ERROR_INVALID,
        "Invalid state for coaster executor");

  *job_manager = cx->default_job_manager;
  *job_manager_len = cx->default_job_manager_len;

  return TURBINE_EXEC_SUCCESS;
}

turbine_code
coaster_execute(Tcl_Interp *interp, const turbine_executor *exec,
                coaster_job *job, turbine_task_callbacks callbacks)
{
  coaster_rc crc;

  assert(exec != NULL);
  assert(job != NULL);
  coaster_state *s = exec->state;
  turbine_condition(s != NULL, TURBINE_ERROR_INVALID,
        "Invalid state for coaster executor");
  assert(s->slots.used < s->slots.total);
  s->slots.used++;

  crc = coaster_submit(s->client, s->config, job);
  COASTER_CHECK(crc, TURBINE_ERROR_EXTERNAL);

  DEBUG_TURBINE("COASTER: Launched job: %p\n", job);

  coaster_active_task *task;
  task = malloc(sizeof(*task));
  TURBINE_MALLOC_CHECK(task);

  task->job = job;
  task->callbacks = callbacks;

  int64_t job_id = coaster_job_get_id(job);

  bool ok = table_lp_add(&s->active_tasks, job_id, task);
  turbine_condition(ok, TURBINE_ERROR_OOM, "Could not add table entry");

  if (callbacks.success.code != NULL)
  {
    Tcl_IncrRefCount(callbacks.success.code);
  }

  if (callbacks.failure.code != NULL)
  {
    Tcl_IncrRefCount(callbacks.failure.code);
  }

  return TURBINE_SUCCESS;
}

static turbine_exec_code
check_completed(turbine_context tcx, coaster_state *state,
    turbine_completed_task *completed, int *ncompleted,
    bool wait_for_completion)
{
  coaster_rc crc;
  int tcl_rc;
  int completed_size = *ncompleted;
  assert(completed_size >= 1);
  int job_count = 0; // Number of completed jobs we returned

  while (job_count < completed_size)
  {
    const int tmp_jobs_size = 32;
    coaster_job *tmp_jobs[tmp_jobs_size];

    int maxleft = completed_size - job_count;
    int maxjobs = (maxleft < tmp_jobs_size) ? maxleft : tmp_jobs_size;

    int njobs;
    crc = coaster_check_jobs(state->client, wait_for_completion,
                             maxjobs, tmp_jobs, &njobs);
    COASTER_CHECK(crc, TURBINE_EXEC_OTHER);

    if (njobs > 0)
    {
      // Already got a job
      wait_for_completion = false;
    }

    for (int i = 0; i < njobs; i++)
    {
      coaster_job *job = tmp_jobs[i];
      int64_t job_id = coaster_job_get_id(job);

      coaster_active_task *task;
      table_lp_remove(&state->active_tasks, job_id, (void**)&task);
      EXEC_CONDITION(task != NULL, TURBINE_EXEC_OTHER,
                    "No matching entry for job id %"PRId64, job_id);

      coaster_job_status status;
      crc = coaster_job_get_status(job, &status);
      COASTER_CHECK(crc, TURBINE_EXEC_OTHER);

      turbine_completed_task *comp = &completed[job_count];

      comp->success = (status.code == COASTER_STATUS_COMPLETED);
      comp->callbacks = task->callbacks;

      comp->vars_len = 1;
      comp->vars = malloc(sizeof(comp->vars[0]) *
                          (size_t)comp->vars_len);
      EXEC_MALLOC_CHECK(comp->vars);

      // Dict with most recent job status info
      Tcl_Obj *result_dict = Tcl_NewDictObj();

      tcl_rc = Tcl_DictObjPut(tcx.interp, result_dict,
                        Tcl_NewConstString("timestamp"),
                        Tcl_NewWideIntObj(status.timestamp));
      EXEC_TCL_CHECK(tcl_rc, TURBINE_EXEC_OTHER);

      Tcl_Obj *msg_obj;
      if (status.message != NULL)
      {
        msg_obj = Tcl_NewStringObj(status.message,
                                   (int)status.message_len);
      }
      else
      {
        msg_obj = Tcl_NewConstString("");
      }

      tcl_rc = Tcl_DictObjPut(tcx.interp, result_dict,
                        Tcl_NewConstString("message"),
                        msg_obj);
      EXEC_TCL_CHECK(tcl_rc, TURBINE_EXEC_OTHER);

      tcl_rc = Tcl_DictObjPut(tcx.interp, result_dict,
                        Tcl_NewConstString("timestamp"),
                        Tcl_NewWideIntObj(status.timestamp));
      EXEC_TCL_CHECK(tcl_rc, TURBINE_EXEC_OTHER);

      if (!comp->success)
      {
        // Exception and status code info for error
        tcl_rc = Tcl_DictObjPut(tcx.interp, result_dict,
                          Tcl_NewConstString("status_code"),
                          Tcl_NewIntObj(status.code));
        EXEC_TCL_CHECK(tcl_rc, TURBINE_EXEC_OTHER);

        Tcl_Obj *exc_obj;
        if (status.exception != NULL)
        {
          exc_obj = Tcl_NewStringObj(status.exception,
                                     (int)status.exception_len);
        }
        else
        {
          exc_obj = Tcl_NewConstString("");
        }

        tcl_rc = Tcl_DictObjPut(tcx.interp, result_dict,
                          Tcl_NewConstString("message"),
                          exc_obj);
        EXEC_TCL_CHECK(tcl_rc, TURBINE_EXEC_OTHER);
      }
      job_count++;

      comp->vars[0].name = "coaster_task_result";
      comp->vars[0].free_name = false;
      comp->vars[0].val = result_dict;

      crc = coaster_job_free(job);
      COASTER_CHECK(crc, TURBINE_EXEC_OTHER);
      free(task); // Done with task
    }

    if (njobs < maxjobs)
    {
      // Exhausted current jobs
      break;
    }
  }
  *ncompleted = job_count;
  state->slots.used -= *ncompleted;

  return TURBINE_EXEC_SUCCESS;
}

/*
 * Must wait for at least one task to completed.
 * Assume that at least one task is in system
 */
static turbine_exec_code
coaster_wait(turbine_context tcx, void *state,
    turbine_completed_task *completed, int *ncompleted)
{
  coaster_state *s = state;

  EXEC_CONDITION(s->slots.used, TURBINE_EXEC_INVALID,
                "Cannot wait if no active coaster tasks");

  turbine_exec_code ec = check_completed(tcx, state, completed,
                                         ncompleted, true);
  EXEC_CHECK_MSG(ec, "error checking for completed tasks in Coaster "
                     "executor");

  return TURBINE_EXEC_SUCCESS;
}

static turbine_exec_code
coaster_poll(turbine_context tcx, void *state,
    turbine_completed_task *completed, int *ncompleted)
{
  coaster_state *s = state;
  if (s->slots.used > 0)
  {
    turbine_exec_code ec = check_completed(tcx, s,
                    completed, ncompleted, false);
    EXEC_CHECK_MSG(ec, "error checking for completed tasks in Coaster "
                       "executor");
  }
  else
  {
    *ncompleted = 0;
  }
  return TURBINE_EXEC_SUCCESS;
}

static turbine_exec_code
coaster_slots(turbine_context tcx, void *state,
    turbine_exec_slot_state *slots)
{
  *slots = ((coaster_state*)state)->slots;
  return TURBINE_EXEC_SUCCESS;
}

static turbine_exec_code
coaster_max_slots(turbine_context tcx, void *context, int *max) {
  assert(context != NULL);
  *max = ((coaster_context*)context)->total_slots;
  return TURBINE_EXEC_SUCCESS;
}
