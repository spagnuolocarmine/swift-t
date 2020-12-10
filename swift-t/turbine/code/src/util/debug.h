
// Header created by debug-auto.tcl at: Thu 10 Dec 2020 04:47:28 PM CET

#pragma once

void turbine_debug_init(void);

__attribute__ ((format (printf, 2, 3)))
void turbine_debug(const char* token, const char* format, ...);

void turbine_debug_finalize(void);

#include <stdbool.h>
#ifndef NDEBUG
extern bool turbine_debug_enabled;
#else
// compile-time constant for NDEBUG
static const bool turbine_debug_enabled = false;
#endif
// Macros for user token: CACHE

#ifndef NDEBUG
#define DEBUG_CACHE(format, args...)
#else
// noop for NDEBUG
#define DEBUG_CACHE(format, args...)
#endif

// Macros for user token: COASTER

#ifndef NDEBUG
#define DEBUG_COASTER(format, args...)
#else
// noop for NDEBUG
#define DEBUG_COASTER(format, args...)
#endif

// Macros for user token: TURBINE

#ifndef NDEBUG
#define DEBUG_TURBINE(format, args...)
#else
// noop for NDEBUG
#define DEBUG_TURBINE(format, args...)
#endif

// Macros for user token: EXECUTOR

#ifndef NDEBUG
#define DEBUG_EXECUTOR(format, args...)
#else
// noop for NDEBUG
#define DEBUG_EXECUTOR(format, args...)
#endif

// Macros for user token: ADLB

#ifndef NDEBUG
#define DEBUG_ADLB(format, args...)
#else
// noop for NDEBUG
#define DEBUG_ADLB(format, args...)
#endif

// Macros for user token: TCL_TURBINE

#ifndef NDEBUG
#define DEBUG_TCL_TURBINE(format, args...)
#else
// noop for NDEBUG
#define DEBUG_TCL_TURBINE(format, args...)
#endif

