/*
 * Copyright 2013 University of Chicago and Argonne National Laboratory
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

/**
 * turbine.c
 *
 *  Created on: May 4, 2011
 *      Author: wozniak
 *
 * TD means Turbine Datum, which is a variable id stored in ADLB
 * TR means TRansform, the in-memory record from a rule
 * */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>

#include <stdint.h>
#include <inttypes.h>

#include <adlb.h>

#include <c-utils.h>
#include <log.h>
#include <table.h>
#include <table_bp.h>
#include <table_lp.h>
#include <tools.h>

#include "turbine.h"

typedef enum
{
  /** Waiting for inputs */
  TRANSFORM_WAITING,
  /** Inputs ready */
  TRANSFORM_READY,
  /** Application level has received this TR as ready */
  TRANSFORM_RETURNED
} transform_status;

/**
   In-memory structure resulting from Turbine rule statement
 */
typedef struct
{
  /** Name for human debugging */
  char* name;

  /** Task to release when inputs are ready */
  xlb_work_unit *work;

  /** Number of input tds */
  int input_tds;
  /** Array of input TDs */
  turbine_datum_id* input_td_list;

  /** Number of input TD/subscript pairs */
  int input_td_subs;
  /** Array of input TD/subscript pairs */
  td_sub_pair* input_td_sub_list;

  /** Closed inputs - bit vector for both tds and td/sub pairs */
  unsigned char *closed_inputs;
  /** Index of next subscribed input (starts at 0 in input_td list,
      continues into input_td_sub_list) */
  int blocker;
  transform_status status;
} transform;

MPI_Comm turbine_task_comm = MPI_COMM_NULL;

static size_t bitfield_size(int inputs);

// Check if input closed
static inline bool input_td_closed(transform *T, int i);
static inline void mark_input_td_closed(transform *T, int i);
static inline bool input_td_sub_closed(transform *T, int i);
static inline void mark_input_td_sub_closed(transform *T, int i);

// Update transforms after close
static turbine_code
turbine_close_update(struct list_l *blocked, turbine_datum_id id,
     adlb_subscript sub, xlb_work_unit ***ready, int *ready_count);

// Finalize engine
static void turbine_engine_finalize(void);

/**
   Has turbine_init() been called successfully?
*/
static bool initialized = false;

/** Has turbine_engine_init() been called? */
bool turbine_engine_initialized = false;

/**
   Waiting transforms
   Map from transform id to transform
 */
struct table_lp transforms_waiting;

/**
   TD inputs blocking their transforms
   Map from TD ID to list of transforms
 */
struct table_lp td_blockers;

/**
   ID/subscript pairs blocking transforms
   Map from ID/subscript pair to list of transforms
 */
struct table_bp td_sub_blockers;

/**
  TDs to which this engine has subscribed, used to avoid
  subscribing multiple times
 */
struct table_lp td_subscribed;

/**
  TD/subscript pairs to which engine is subscribed.  Key is created using
   write_id_sub_key function
 */
struct table_bp td_sub_subscribed;

// Maximum length of buffer required for key
#define ID_SUB_KEY_MAX (ADLB_DATA_SUBSCRIPT_MAX + 30)

// Return size of buffer to use for id/subscript pair.
// Zero-length buffer if no subscript
// TODO: use other adlb code for this
static inline size_t
id_sub_key_buflen(const void *subscript, size_t length)
{
  if (subscript == NULL)
    return 0;
  size_t res = (sizeof(turbine_datum_id) + length);
  assert(res <= ID_SUB_KEY_MAX);
  return res;
}

static inline size_t
write_id_sub_key(char *buf, turbine_datum_id id,
                 const void *subscript, size_t length)
{
  assert(subscript != NULL);
  memcpy(buf, &id, sizeof(id));
  memcpy(&buf[sizeof(id)], subscript, length);
  return id_sub_key_buflen(subscript, length);
}

static inline adlb_subscript sub_convert(turbine_subscript sub)
{
  adlb_subscript asub = { .key = sub.key, .length = sub.length };
  return asub;
}

#define turbine_check(code) if (code != TURBINE_SUCCESS) return code;

#define turbine_check_verbose(code) \
    turbine_check_verbose_impl(code, __FILE__, __LINE__)

#define turbine_check_verbose_impl(code, file, line)    \
  { if (code != TURBINE_SUCCESS)                        \
    {                                                   \
      char output[TURBINE_CODE_STRING_MAX];             \
      turbine_code_tostring(output, code);              \
      printf("turbine error: %s\n", output);            \
      printf("\t at: %s:%i\n", file, line);             \
      return code;                                      \
    }                                                   \
  }

#define turbine_condition(condition, code, format, args...) \
  { if (! (condition))                                      \
    {                                                       \
       printf(format, ## args);                             \
       return code;                                         \
    }}

/**
   This is a separate function so we can set a function breakpoint
 */
static void
gdb_sleep(int* t, int i)
{
  sleep(1);
  DEBUG_TURBINE("gdb_check: %i %i\n", *t, i);
}

/**
   Allows user to launch Turbine in a loop until a debugger attaches
 */
static void
gdb_check(int rank)
{
  int gdb_rank;
  char* s = getenv("GDB_RANK");
  if (s != NULL &&
      strlen(s) > 0)
  {
    int c = sscanf(s, "%i", &gdb_rank);
    if (c != 1)
    {
      printf("Invalid GDB_RANK: %s\n", s);
      exit(1);
    }
    if (gdb_rank == rank)
    {
      pid_t pid = getpid();
      printf("Waiting for gdb: rank: %i pid: %i\n", rank, pid);
      int t = 0;
      int i = 0;
      while (!t)
        gdb_sleep(&t, i++);
    }
  }
}

turbine_code
turbine_init(int amserver, int rank, int size)
{
  gdb_check(rank);

  if (!amserver)
    return TURBINE_SUCCESS;

  initialized = true;

  return TURBINE_SUCCESS;
}

turbine_code
turbine_engine_init()
{
  if (!initialized)
    return TURBINE_ERROR_UNINITIALIZED;

  // Initialize tables to size that will probably not need to be
  // expanded, but is not excessively large
  const int table_init_capacity = 65536;

  bool result;
  result = table_lp_init(&transforms_waiting, table_init_capacity); 
  if (!result)
    return TURBINE_ERROR_OOM;

  result = table_lp_init(&td_blockers, table_init_capacity); 
  if (!result)
    return TURBINE_ERROR_OOM;
  
  result = table_bp_init(&td_sub_blockers, table_init_capacity); 
  if (!result)
    return TURBINE_ERROR_OOM;

  result = table_lp_init(&td_subscribed, table_init_capacity); 
  if (!result)
    return TURBINE_ERROR_OOM;

  result = table_bp_init(&td_sub_subscribed, table_init_capacity); 
  if (!result)
    return TURBINE_ERROR_OOM;

  turbine_engine_initialized = true;
  return TURBINE_SUCCESS;
}

static inline turbine_code
transform_create(const char* name,
             int input_tds, const turbine_datum_id* input_td_list,
             int input_td_subs, const td_sub_pair* input_td_sub_list,
             xlb_work_unit *work, transform** result)
{
  assert(name);
  assert(work);
  assert(input_tds >= 0);
  assert(input_tds == 0 || input_td_list != NULL);
  assert(input_td_subs >= 0);
  assert(input_td_subs == 0 || input_td_sub_list != NULL);

  transform* T = malloc(sizeof(transform));

  T->name = strdup(name);
  T->work = work;
  T->blocker = 0;
  T->input_tds = input_tds;
  T->input_td_subs = input_td_subs;

  if (input_tds > 0)
  {
    size_t sz = (size_t)input_tds*sizeof(turbine_datum_id);
    T->input_td_list = malloc(sz);

    if (! T->input_td_list)
      return TURBINE_ERROR_OOM;

    memcpy(T->input_td_list, input_td_list, sz);
  }
  else
  {
    T->input_td_list = NULL;
  }

  if (input_td_subs > 0)
  {
    size_t sz = (size_t)input_td_subs* sizeof(td_sub_pair);
    T->input_td_sub_list = malloc(sz);

    if (! T->input_td_sub_list)
      return TURBINE_ERROR_OOM;

    memcpy(T->input_td_sub_list, input_td_sub_list, sz);
  }
  else
  {
    T->input_td_sub_list = NULL;
  }

  int total_inputs = input_tds + input_td_subs;
  if (total_inputs > 0)
  {
    size_t sz = bitfield_size(total_inputs)* sizeof(unsigned char);
    T->closed_inputs = malloc(sz);

    if (! T->closed_inputs)
      return TURBINE_ERROR_OOM;

    memset(T->closed_inputs, 0, sz);
  }
  else
  {
    T->closed_inputs = NULL;
  }


  T->status = TRANSFORM_WAITING;

  *result = T;
  return TURBINE_SUCCESS;
}

static inline void
transform_free(transform* T)
{
  free(T->name);
  if (T->work)
    work_unit_free(T->work);
  if (T->input_td_list)
    free(T->input_td_list);
  if (T->input_td_sub_list)
  {
    for (int i = 0; i < T->input_td_subs; i++)
    {
      // free subscript strings
      free(T->input_td_sub_list[i].subscript.key);
    }
    free(T->input_td_sub_list);
  }
  if (T->closed_inputs)
    free(T->closed_inputs);
  free(T);
}


/**
 * Return true if subscribed, false if data already set
 */
static inline turbine_code
subscribe(adlb_datum_id id, turbine_subscript subscript, bool *result)
{
  turbine_condition(id != ADLB_DATA_ID_NULL, TURBINE_ERROR_INVALID,
                    "Null ID provided to rule");

  // if subscript provided, use key
  size_t id_sub_keylen = id_sub_key_buflen(subscript.key, subscript.length);
  char id_sub_key[id_sub_keylen];
  if (subscript.key != NULL)
  {
    write_id_sub_key(id_sub_key, id, subscript.key, subscript.length);
    void *tmp;
    if (table_bp_search(&td_sub_subscribed, id_sub_key, id_sub_keylen,
                        &tmp))
    {
      // TODO: support binary subscript
      DEBUG_TURBINE("Already subscribed: <%"PRId64">[\"%.*s\"]",
                      id, (int)subscript.length, subscript.key);
      *result = true;
      return TURBINE_SUCCESS;
    }
  }
  else
  {
    if (table_lp_contains(&td_subscribed, id)) {
      // Already subscribed
      *result = true;
      return TURBINE_SUCCESS;
    }
  }

  // TODO:
  // If datum is local, subscribe directly
  // Otherwise send subscribe sync message
  int subscribed;
  adlb_code rc = ADLB_Subscribe(id, sub_convert(subscript), &subscribed);
  
  if (rc == (int)ADLB_DATA_ERROR_NOT_FOUND) {
    // Handle case where read_refcount == 0 and write_refcount == 0
    //      => datum was freed and we're good to go
    subscribed = 0;
  } else if (rc != ADLB_SUCCESS) {
    if (subscript.key != NULL)
    {
      log_printf("ADLB_Subscribe on <%ld>[\"%s\"] failed with code: %d\n",
                 id, subscript, rc);
    }
    else
    {
      log_printf("ADLB_Subscribe on <%ld> failed with code: %d\n", id, rc);
    }
    return rc; // Turbine codes are same as ADLB data codes
  }

  DEBUG_TURBINE("ADLB_Subscribe: %i", subscribed);

  if (subscribed != 0) {
    // Record it was subscribed
    if (subscript.key != NULL)
      table_bp_add(&td_sub_subscribed, id_sub_key, id_sub_keylen, (void*)1);
    else
      table_lp_add(&td_subscribed, id, (void*)1);
  }
  *result = subscribed != 0;
  return TURBINE_SUCCESS;
}

static int transform_tostring(char* output,
                              transform* transform);

#ifdef ENABLE_DEBUG_TURBINE
#define DEBUG_TURBINE_RULE(transform, id) {         \
    char tmp[1024];                                     \
    transform_tostring(tmp, transform);                 \
    DEBUG_TURBINE("rule: %s {%"PRId64"}", tmp, id);     \
  }
#else
#define DEBUG_TURBINE_RULE(transform, id)
#endif

static inline turbine_code progress(transform* T, bool* subscribed);
static inline turbine_code rule_inputs(transform* T);

turbine_code
turbine_rule(const char* name,
              int input_tds,
              const turbine_datum_id* input_td_list,
              int input_td_subs,
              const td_sub_pair* input_td_sub_list,
              xlb_work_unit *work, bool *ready)
{
  turbine_code tc;
  xlb_work_unit_id id = work->id;

  if (!turbine_engine_initialized)
    return TURBINE_ERROR_UNINITIALIZED;
  transform* T = NULL;
  tc = transform_create(name, input_tds, input_td_list,
                       input_td_subs, input_td_sub_list, work, &T);

  turbine_check(tc);

  tc = rule_inputs(T);
  turbine_check(tc);

  bool subscribed;
  tc = progress(T, &subscribed);
  if (tc != TURBINE_SUCCESS)
  {
    DEBUG_TURBINE("turbine_rule failed:\n");
    DEBUG_TURBINE_RULE(T, id);
    return tc;
  }

  DEBUG_TURBINE_RULE(T, id);

  if (subscribed)
  {
    DEBUG_TURBINE("waiting: {%"PRId64"}", id);
    assert(T != NULL);
    table_lp_add(&transforms_waiting, id, T);
    *ready = false;
  }
  else
  {
    DEBUG_TURBINE("ready: {%"PRId64"}", id);
    *ready = true;
  }

  return TURBINE_SUCCESS;
}

static inline turbine_code add_rule_blocker(turbine_datum_id id,
                                            xlb_work_unit_id transform);

static inline turbine_code add_rule_blocker_sub(void *id_sub_key,
        size_t id_sub_keylen, xlb_work_unit_id transform);
/**
   Record that this transform is blocked by its inputs.  Do not yet
   subscribe to any inputs
*/
static inline turbine_code
rule_inputs(transform* T)
{
  for (int i = 0; i < T->input_tds; i++)
  {
    turbine_datum_id id = T->input_td_list[i];
    // TODO: we might add duplicate list entries if id appears multiple
    //       times. This is currently handled upon removal from list
    turbine_code code = add_rule_blocker(id, T->work->id);
    turbine_check_verbose(code);
  }

  for (int i = 0; i < T->input_td_subs; i++)
  {
    td_sub_pair *td_sub = &T->input_td_sub_list[i];
    size_t id_sub_keylen = id_sub_key_buflen(td_sub->subscript.key,
                                             td_sub->subscript.length);
    char id_sub_key[id_sub_keylen];
    assert(td_sub->subscript.key != NULL);
    write_id_sub_key(id_sub_key, td_sub->td, td_sub->subscript.key,
                     td_sub->subscript.length);
    // TODO: we might add duplicate list entries if id appears multiple
    //      times. This is currently handled upon removal from list
    turbine_code code = add_rule_blocker_sub(id_sub_key, id_sub_keylen,
                                             T->work->id);
    turbine_check_verbose(code);
  }
  return TURBINE_SUCCESS;
}


/**
   Declare a new data id
   @param result return the new blocked list here
 */
static inline turbine_code
add_rule_blocker(turbine_datum_id id, xlb_work_unit_id transform)
{
  assert(initialized);
  DEBUG_TURBINE("add_rule_blocker for {%"PRId64"}: <%"PRId64">",
                transform, id);
  struct list_l* blocked;
  table_lp_search(&td_blockers, id, (void**)&blocked);
  if (blocked == NULL)
  {
    blocked = list_l_create();
    table_lp_add(&td_blockers, id, blocked);
  }
  list_l_add(blocked, transform);
  return TURBINE_SUCCESS;
}

/*
  Same as add_rule_blocker, but with subscript.
 */
static inline turbine_code add_rule_blocker_sub(void *id_sub_key,
        size_t id_sub_keylen, xlb_work_unit_id transform)
{
  assert(initialized);
  DEBUG_TURBINE("add_rule_blocker_sub for {%"PRId64"}", transform);
  struct list_l* blocked;
  bool found = table_bp_search(&td_sub_blockers, id_sub_key,
                         id_sub_keylen, (void**)&blocked);
  if (!found)
  {
    blocked = list_l_create();
    table_bp_add(&td_sub_blockers, id_sub_key, id_sub_keylen, blocked);
  }
  list_l_add(blocked, transform);
  return TURBINE_SUCCESS;
}

turbine_code
turbine_close(turbine_datum_id id, xlb_work_unit ***ready, int *ready_count)
{
  DEBUG_TURBINE("turbine_close(<%"PRId64">)", id);
  // Record no longer subscribed
  void *tmp;
  bool was_subscribed = table_lp_remove(&td_subscribed, id, &tmp);
  assert(was_subscribed);

  // Remove from table transforms that this td was blocking
  // Will need to free list later
  struct list_l* L;
  bool found = table_lp_remove(&td_blockers, id, (void**)&L);
  if (!found)
    // We don't have any rules that block on this td
    return TURBINE_SUCCESS;

  DEBUG_TURBINE("%i blocked", L->size);
  return turbine_close_update(L, id, ADLB_NO_SUB, ready, ready_count);
}

turbine_code turbine_sub_close(turbine_datum_id id, adlb_subscript sub,
                            xlb_work_unit ***ready, int *ready_count)
{
  DEBUG_TURBINE("turbine_sub_close(<%"PRId64">[\"%.*s\"])", id,
                (int)sub.length, (const char*)sub.key);
  size_t key_len = id_sub_key_buflen(sub.key, sub.length);
  char key[key_len];
  write_id_sub_key(key, id, sub.key, sub.length);
  
  // Record no longer subscribed
  void *tmp;
  bool was_subscribed = table_bp_remove(&td_sub_subscribed, key,
                                        key_len, &tmp);
  assert(was_subscribed);

  struct list_l* L;
  
  bool found = table_bp_remove(&td_sub_blockers, key, key_len, (void**)&L);
  if (!found)
    // We don't have any rules that block on this td
    return TURBINE_SUCCESS;

  return turbine_close_update(L, id, sub, ready, ready_count);
}

/*
  Update transforms after having one of blockers removed.
  blocked: list of transforms with blocker remoed
  id: id of data
  sub: optional subscript
  ready/ready_count: list of any work units made ready by this change,
      with ownership passed to caller
 */
static turbine_code
turbine_close_update(struct list_l *blocked, turbine_datum_id id,
         adlb_subscript sub, xlb_work_unit ***ready, int *ready_count)
{
  int ready_size = 0; // malloced size
  int ready_count_tmp = 0;
  xlb_work_unit **ready_tmp = NULL;

  // Try to make progress on those transforms
  for (struct list_l_item* item = blocked->head; item; item = item->next)
  {
    xlb_work_unit_id transform_id = item->data;
    transform* T;
    
    bool found = table_lp_search(&transforms_waiting, transform_id,
                                 (void**)&T);
    if (!found)
      continue;
 
    // update closed vector
    if (!adlb_has_sub(sub))
    {
      DEBUG_TURBINE("Update {%"PRId64"} for close: <%"PRId64">", T->work->id, id);
      for (int i = T->blocker; i < T->input_tds; i++) {
        if (T->input_td_list[i] == id) {
          mark_input_td_closed(T, i);
        }
      }
    }
    else
    {
      DEBUG_TURBINE("Update {%"PRId64"} for subscript close: <%"PRId64">",
                    T->work->id, id);
      // Check to see which ones remain to be checked
      int first_td_sub;
      if (T->blocker >= T->input_tds)
        first_td_sub = T->blocker - T->input_tds;
      else
        first_td_sub = 0;

      for (int i = first_td_sub; i < T->input_td_subs; i++)
      {
        td_sub_pair *input_tdsub = &T->input_td_sub_list[i];
        turbine_subscript *input_sub = &input_tdsub->subscript;
        if (input_tdsub->td == id && input_sub->length == sub.length 
            && memcmp(input_sub->key, sub.key, sub.length) == 0)
        {
          mark_input_td_sub_closed(T, i);
        }
      }
    }

    bool subscribed;
    turbine_code tc = progress(T, &subscribed);
    if (tc != TURBINE_SUCCESS)
      return tc;

    if (!subscribed)
    {
      DEBUG_TURBINE("ready: {%"PRId64"}", transform_id);
      if (ready_size <= ready_count_tmp)
      {
        if (ready_size == 0)
        {
          ready_size = 16;
        } else {
          ready_size *= 2;
        }
        ready_tmp = realloc(ready_tmp, sizeof(ready_tmp[0]) *
                                     (size_t) ready_size);
        if (!ready_tmp)
          return TURBINE_ERROR_OOM;
      }
      ready_tmp[ready_count_tmp++] = T->work;
      T->work = NULL; // Don't free work
    }
  }


  list_l_free(blocked); // No longer need list

  *ready = ready_tmp;
  *ready_count = ready_count_tmp;
  return TURBINE_SUCCESS;
}

/**
 * Make progress on transform. Provided is a list of
 * ids that are closed.  We contact server to check
 * status of any IDs not in list.
 */
static inline turbine_code
progress(transform* T, bool* subscribed)
{
  *subscribed = false;

  // first check TDs to see if all are ready
  for (; T->blocker < T->input_tds; T->blocker++)
  {
    if (!input_td_closed(T, T->blocker))
    {
      // Contact server to check if available
      turbine_datum_id td = T->input_td_list[T->blocker];
      turbine_code tc = subscribe(td, TURBINE_NO_SUB, subscribed);
      if (tc != TURBINE_SUCCESS) {
        return tc;
      }
      if (*subscribed) {
        // Need to block on this id
        return TURBINE_SUCCESS;
      }
    }
  }

  // now, make progress on any ID/subscript pairs
  int total_inputs = T->input_tds  + T->input_td_subs;
  for (; T->blocker < total_inputs; T->blocker++)
  {
    int td_sub_ix = T->blocker - T->input_tds;
    if (!input_td_sub_closed(T, td_sub_ix))
    {
      // Contact server to check if available
      td_sub_pair ts = T->input_td_sub_list[td_sub_ix];
      turbine_code tc = subscribe(ts.td, ts.subscript, subscribed);
      if (tc != TURBINE_SUCCESS) {
        return tc;
      }
      if (*subscribed) {
        // Need to block on this id
        return TURBINE_SUCCESS;
      }
    }
  }

  // Ready to run
  *subscribed = false;
  return TURBINE_SUCCESS;
}

/**
   @param output Should point to good storage for output,
   at least TURBINE_CODE_STRING_MAX chars
   @return Number of characters written
*/
int
turbine_code_tostring(char* output, turbine_code code)
{
  int result = -1;
  switch (code)
  {
    case TURBINE_SUCCESS:
      result = sprintf(output, "TURBINE_SUCCESS");
      break;
    case TURBINE_ERROR_OOM:
      result = sprintf(output, "TURBINE_ERROR_OOM");
      break;
    case TURBINE_ERROR_DOUBLE_DECLARE:
      result = sprintf(output, "TURBINE_ERROR_DOUBLE_DECLARE");
      break;
    case TURBINE_ERROR_DOUBLE_WRITE:
      result = sprintf(output, "TURBINE_ERROR_DOUBLE_WRITE");
      break;
    case TURBINE_ERROR_UNSET:
      result = sprintf(output, "TURBINE_ERROR_UNSET");
      break;
    case TURBINE_ERROR_NOT_FOUND:
      result = sprintf(output, "TURBINE_ERROR_NOT_FOUND");
      break;
    case TURBINE_ERROR_NUMBER_FORMAT:
      result = sprintf(output, "TURBINE_ERROR_NUMBER_FORMAT");
      break;
    case TURBINE_ERROR_INVALID:
      result = sprintf(output, "TURBINE_ERROR_INVALID");
      break;
    case TURBINE_ERROR_NULL:
      result = sprintf(output, "TURBINE_ERROR_NULL");
      break;
    case TURBINE_ERROR_UNKNOWN:
      result = sprintf(output, "TURBINE_ERROR_UNKNOWN");
      break;
    case TURBINE_ERROR_TYPE:
      result = sprintf(output, "TURBINE_ERROR_TYPE");
      break;
    case TURBINE_ERROR_STORAGE:
      result = sprintf(output, "TURBINE_ERROR_STORAGE");
      break;
    case TURBINE_ERROR_UNINITIALIZED:
      result = sprintf(output, "TURBINE_ERROR_UNINITIALIZED");
      break;
    default:
      sprintf(output, "<could not convert code %d to string>", code);
      break;
  }
  return result;
}

static int
transform_tostring(char* output, transform* t)
{
  int result = 0;
  char* p = output;

  append(p, "%s ", t->name);
  append(p, "(");
  bool first = true;
  for (int i = 0; i < t->input_tds; i++)
  {
    if (first)
    {
      first = false;
    }
    else
    {
      append(p, " ");
    }
    // Highlight the blocking variable
    bool blocking = (i == t->blocker);
    if (blocking)
      append(p, "/");
    append(p, "%"PRId64"", t->input_td_list[i]);
    if (blocking)
      append(p, "/");
  }
  for (int i = 0; i < t->input_td_subs; i++)
  {
    if (first)
      first = false;
    else
      append(p, " ");

    // Highlight the blocking variable
    bool blocking = (i + t->input_tds == t->blocker);
    td_sub_pair ts = t->input_td_sub_list[i];
    if (blocking)
      append(p, "/");
    // TODO: support binary subscript
    append(p, "%"PRId64"[\"%.*s\"]", ts.td, (int)ts.subscript.length,
           ts.subscript.key);
    if (blocking)
      append(p, "/");
  }
  append(p, ")");

  result = (int)(p - output);
  return result;
}

static inline bool
input_td_closed(transform *T, int i)
{
  assert(i >= 0);
  unsigned char field = T->closed_inputs[(unsigned int)i / 8];
  return (field >> ((unsigned int)i % 8)) & 0x1;
}

static inline bool
input_td_sub_closed(transform *T, int i)
{
  // closed_inputs had pairs come after tds
  return input_td_closed(T, i + T->input_tds);
}

// Extract bit from closed_inputs
static inline void
mark_input_td_closed(transform *T, int i)
{
  assert(i >= 0);
  unsigned char mask = (unsigned char) (0x1 << ((unsigned int)i % 8));
  T->closed_inputs[i / 8] |= mask;
}

static inline void
mark_input_td_sub_closed(transform *T, int i)
{
  mark_input_td_closed(T, i + T->input_tds);
}

static size_t
bitfield_size(int inputs) {
  if (inputs <= 0)
    return 0;
  // Round up to nearest multiple of 8
  return (size_t)(inputs - 1) / 8 + 1;
}

static void
info_waiting()
{
  printf("WAITING TRANSFORMS: %i\n", transforms_waiting.size);
  char buffer[1024];
  TABLE_LP_FOREACH(&transforms_waiting, item)
  {
    transform* t = item->data;
    char id_string[24];
    sprintf(id_string, "{%"PRId64"}", t->work->id);
    int c = sprintf(buffer, "%10s ", id_string);
    transform_tostring(buffer+c, t);
    printf("TRANSFORM: %s\n", buffer);
  }
}

// Callbacks to free data
static void tbl_free_transform_cb(xlb_work_unit_id key, void *T);
static void tbl_free_blockers_cb(turbine_datum_id key, void *L);
static void tbl_free_sub_blockers_cb(const void *key, size_t key_len, void *L);

void
turbine_finalize(void)
{
  turbine_engine_finalize();
}


static void turbine_engine_finalize(void)
{
  if (!turbine_engine_initialized)
    return;

  // First report any problems we find
  if (transforms_waiting.size != 0)
    info_waiting();

  // Now we're done reporting, free everything
  table_lp_free_callback(&transforms_waiting, false, tbl_free_transform_cb);
  table_lp_free_callback(&td_blockers, false, tbl_free_blockers_cb);
  table_bp_free_callback(&td_sub_blockers, false, tbl_free_sub_blockers_cb);

  // Entries in td_subscribed and td_sub_subscribed are not pointers and don't
  // need to be freed
  table_lp_free_callback(&td_subscribed, false, NULL);
  table_bp_free_callback(&td_sub_subscribed, false, NULL);

}

static void tbl_free_transform_cb(xlb_work_unit_id key, void *T)
{
  transform_free((transform*)T);
}

static void tbl_free_blockers_cb(turbine_datum_id key, void *L)
{
  list_l_free((struct list_l*)L);
}

static void tbl_free_sub_blockers_cb(const void *key, size_t key_len, void *L)
{
  list_l_free((struct list_l*)L);
}
