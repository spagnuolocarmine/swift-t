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
  Internal definitions for data and related modules
 */

#ifndef __XLB_DATA_INTERNAL_H
#define __XLB_DATA_INTERNAL_H

#include "adlb-defs.h"
#include "adlb_types.h"
#include "checks.h"
#include "data.h"
#include <rbtree_bp.h>

/**
 * Set initial capacity to be fairly small since in practice most
 * containers are small.  Container will expand.
 */
#define CONTAINER_INIT_CAPACITY 32

/**
 * Size for temporary stack buffers.  Assume no recursive calls.
 * Should be small enough to avoid stack overflows
 */
#define XLB_STACK_BUFFER_LEN 4096

/**
   Status vector for ADLB data variables
 */
typedef struct {
  /** SET: Whether the value has been filled in */
  bool set : 1;
  /** PERMANENT: Whether garbage collection is disabled for data item */
  bool permanent : 1;
  /** RELEASE_WRITE_REFS: If true, release write refcount for any
      references in this datum when its write refcount goes to zero */
  bool release_write_refs : 1;
  /** SUBSCRIPT_NOTIFS: If true, at least one subscript subscription or
      reference for this datum. */
  bool subscript_notifs : 1;
} adlb_data_status;


static inline void xlb_data_init_status(adlb_data_status *s)
{
  memset(s, 0, sizeof(*s));
}
#define ADLB_DATA_INIT_STATUS \
  { .set = 0, .permanent = 0, .release_write_refs = 0}

typedef enum {
  LISTENER_NOTIF,
  LISTENER_REF,
} xlb_listener_tag;

typedef struct {
  int rank;
  int work_type;
} xlb_listener_notif;

typedef struct {
  adlb_datum_id id;
  adlb_refc acquire;
  int write_decr;
  size_t subscript_len;
  char subscript_data[];
} xlb_listener_reference;

/*
 * Rank listening for notification
 */
typedef struct {
  xlb_listener_tag tag;
  union {
    xlb_listener_notif notif; // Store small one inline
    xlb_listener_reference *ref; // Store larger one elsewhere
  };
} xlb_listener;

typedef struct
{
  adlb_datum_storage data;
  // TODO: would be ideal to store listener inline in entry,i.e rbtree_bb
  struct rbtree_bp listeners; // ordered map: subscript->xlb_listener
  int read_refcount; // Number of open read refs
  int write_refcount; // Number of open write refs
  adlb_data_type type;
  adlb_dsym symbol;
  adlb_data_status status;
} adlb_datum;


/// ADLB DATA MODULE CHECKS

#if ENABLE_LOG_DEBUG
// Include traceback
#define ADLB_DATA_CHECK_CODE(rc) \
  { adlb_data_code _rc = (rc);                              \
    if (_rc != ADLB_DATA_SUCCESS) {                         \
      printf("ADLB DATA CHECK FAILED: %s:%s:%i\n",          \
         __FUNCTION__, __FILE__, __LINE__);                 \
      return _rc;                                           \
  }}

// Check adlb_code, translate to dc
#define ADLB_DATA_CHECK_ADLB(ac, dc) \
  { adlb_code _ac = (ac);                              \
    if (_ac != ADLB_SUCCESS) {                         \
      printf("ADLB DATA CHECK FAILED: %s:%s:%i\n",     \
         __FUNCTION__, __FILE__, __LINE__);            \
      return dc;                                       \
  }}
#else // ENABLE_LOG_DEBUG
// Just return
#define ADLB_DATA_CHECK_CODE(rc) \
  { adlb_data_code _rc = (rc);                              \
    if (_rc != ADLB_DATA_SUCCESS) {                         \
      return _rc;                                           \
  }}

#define ADLB_DATA_CHECK_ADLB(ac, dc) \
  { adlb_code _ac = (ac);                              \
    if (_ac != ADLB_SUCCESS) {                         \
      return dc;                                       \
  }}

#endif // ENABLE_LOG_DEBUG

#define ADLB_DATA_CHECK_MALLOC(ptr) { \
  ADLB_CHECK_MSG_CODE((ptr) != NULL, ADLB_DATA_ERROR_OOM, "out of memory");  \
}

// Helper macro to create/resize an array.  Given NULL, realloc() allocates
// the initial array.  On error, return ADLB_DATA_ERROR_OOM
#define DATA_REALLOC(array, new_count) {                               \
  array = realloc((array), sizeof((array)[0]) * (new_count));          \
  ADLB_DATA_CHECK_MALLOC(array);                                            \
}

adlb_data_code
xlb_datum_lookup(adlb_datum_id id, adlb_datum **d);

/*
  Alternative, more flexible implementation of refcount
  that directly takes datum reference
 */
adlb_data_code
xlb_refc_incr(adlb_datum *d, adlb_datum_id id,
          adlb_refc change, xlb_refc_acquire acquire,
          bool defer_gc, bool *garbage_collected, adlb_notif_t *notifs);

/*
  Utility function to resize string buffer using realloc if needed
  to fit new data
  str: *str is a malloced character buffer.  This is modified if
       we reallocate the buffer
  curr_size: the current size in bytes of the buffer pointed to by *str
  pos: the index after the current last byte in the string (i.e. where
       the null terminating byte would go)
  needed: the amount which we want to append to the string
 */
// Check string buffer is big enough for needed chars + a terminating null byte
adlb_data_code
xlb_resize_str(char **str, size_t *curr_size, int pos, size_t needed);

// Maximum length of id/subscript string
#define ID_SUB_PAIR_MAX \
  (sizeof(adlb_datum_id) + ADLB_DATA_SUBSCRIPT_MAX + 1)

// Length of buffer for id+subscript.  Will be at most 8 bytes
// more than ADLB_SUBSCRIPT_MAX
__attribute__((always_inline))
static inline size_t xlb_id_sub_buflen(adlb_subscript sub)
{
  size_t size = (sizeof(adlb_datum_id) + sub.length);
  assert(size <= ID_SUB_PAIR_MAX);
  return size;
}

__attribute__((always_inline))
static inline size_t xlb_write_id_sub(char *buf, adlb_datum_id id,
                                  adlb_subscript sub)
{
  memcpy(buf, &id, sizeof(adlb_datum_id));
  memcpy(buf + sizeof(adlb_datum_id), sub.key, sub.length);
  return xlb_id_sub_buflen(sub);
}

// Extract id and sub from buffer.  Return internal pointer into buffer
__attribute__((always_inline))
static inline void xlb_read_id_sub(const char *buf, size_t buflen,
        adlb_datum_id *id, adlb_subscript *sub)
{
  assert(buflen >= sizeof(*id));
  memcpy(id, buf, sizeof(*id));
  sub->length = buflen - sizeof(*id);
  sub->key = &buf[sizeof(*id)];
}
#endif // __XLB_DATA_INTERNAL_H
