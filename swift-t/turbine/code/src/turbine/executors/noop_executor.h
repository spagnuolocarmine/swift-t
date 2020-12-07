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

#ifndef __NOOP_EXECUTOR_H
#define __NOOP_EXECUTOR_H

#include "src/turbine/async_exec.h"
#include "src/turbine/turbine-defs.h"

// Registered name for noop executor
#define NOOP_EXECUTOR_NAME "NOOP"

turbine_code
noop_executor_register();

/*
  Execute a task
 */
turbine_code
noop_execute(Tcl_Interp *interp, const turbine_executor *exec,
             const void *work, int length,
             turbine_task_callbacks callbacks);

#endif //__NOOP_EXECUTOR_H
