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

/*
 * tcl-r.c
 *
 *  Created on: May 22, 2013
 *      Author: wozniak
 *
 *  Tcl extension calling into R interpreter
 */

#include "config.h"

#include <stdio.h>

#include <tcl.h>

#if HAVE_R==1
#include "rinside-adapter.h"
#endif

#include "src/tcl/util.h"

#include "tcl-r.h"

#if HAVE_R==1

static char* r_result_exception = "__EXCEPTION__";

#define EXCEPTION(ee)                                               \
  do {                                                              \
    result = Tcl_NewStringObj(r_result_exception, -1);              \
    if (ee) {                                                       \
      return turbine_user_errorv(interp, "User error in R");        \
    } else {                                                        \
      result = Tcl_NewStringObj(r_result_exception, -1);            \
    }                                                               \
  } while(0);

static int
R_Eval_Cmd(ClientData cdata, Tcl_Interp *interp,
           int objc, Tcl_Obj* const objv[])
{
  TCL_ARGS(4);
  int exceptions_are_errors;
  int rc = Tcl_GetBooleanFromObj(interp, objv[1], &exceptions_are_errors);
  TCL_CHECK_MSG(rc,
                "R: argument exceptions_are_errors should be boolean!");
  // A chunk of R code that does not return anything:
  char* code = Tcl_GetString(objv[2]);
  // A chunk of R code that returns a string to Swift:
  char* expr = Tcl_GetString(objv[3]);

  Tcl_Obj* result;

  // The string result from R: Default is empty string
  char* s = "";
  int   length = 0;
  bool  empty = true;

  bool status;
  status = use_rinside_void(code);
  if (!status) EXCEPTION(exceptions_are_errors);

  if (strlen(expr) > 0)
  {
    empty = false;
    status = use_rinside_expr(expr, &s, &length);
  }

  if (status)
  {
    result = Tcl_NewStringObj(s, length);
    if (!empty) free(s);
  }
  else
    EXCEPTION(exceptions_are_errors);
  Tcl_SetObjResult(interp, result);
  return TCL_OK;
}

#else // R disabled

static int
R_Eval_Cmd(ClientData cdata, Tcl_Interp *interp,
           int objc, Tcl_Obj *const objv[])
{
  turbine_tcl_condition_failed(interp, objv[0],
                       "Turbine not compiled with R support");
  return TCL_ERROR;
}

#endif

/**
   Shorten create-command lines.  r:: namespace is prepended
 */
#define COMMAND(tcl_function, c_function) \
    Tcl_CreateObjCommand(interp, "r::" tcl_function, c_function, \
                         NULL, NULL);
/**
   Called when Tcl loads this extension
 */
int
Tclr_Init(Tcl_Interp *interp)
{
  if (Tcl_InitStubs(interp, TCL_VERSION, 0) == NULL)
    return TCL_ERROR;

  if (Tcl_PkgProvide(interp, "r", "0.1") == TCL_ERROR)
    return TCL_ERROR;

  return TCL_OK;
}

void
tcl_r_init(Tcl_Interp* interp)
{
  COMMAND("eval", R_Eval_Cmd);
}
