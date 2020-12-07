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
  Utilities for working with binary keys
 */

#ifndef __CUTILS_BINKEYS
#define __CUTILS_BINKEYS

#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include "jenkins-hash.h"

typedef struct {
  /* key_len == 0 and __key = TABLE_BP_INVALID_KEY indicates empty entry
   *.Entry entries are only used to mark empty hash table buckets. */

  /* We sometimes store key inline in pointer.  Use table_bp_get_key to
   * access the value of the key correctly */
  void* __key;
  size_t key_len;

} binkey_packed_t;

#define BINKEY_PACKED_INVALID ((void*)0x1)

/*
  returns: whether we store packed key inline in pointer
 */
static inline bool binkey_packed_inline(size_t key_len)
{
  return key_len <= sizeof(void*);
}

static inline bool binkey_packed_valid(const binkey_packed_t *key)
{
  return key->key_len > 0 || key->__key != BINKEY_PACKED_INVALID;
}

static inline const void *binkey_packed_get(const binkey_packed_t *key)
{
  if (binkey_packed_inline(key->key_len))
  {
    // Pointer itself holds data
    return &key->__key;
  }
  else
  {
    return key->__key;
  }
}

static inline size_t binkey_packed_len(const binkey_packed_t *key)
{
  return key->key_len;
}

static inline void binkey_packed_clear(binkey_packed_t *key)
{
  key->__key = BINKEY_PACKED_INVALID;
  key->key_len = 0;
}

static inline void binkey_packed_free(binkey_packed_t *key)
{
  if (!binkey_packed_inline(key->key_len))
    free(key->__key);
}

/*
  Set binkey, allocating memory if necessary
  Return false on malloc error
 */
static inline bool
binkey_packed_set(binkey_packed_t *key_repr, const void *key,
                  size_t key_len)
{
  if (binkey_packed_inline(key_len))
  {
    // Store inline
    // Initialize to avoid clash with invalid value
    key_repr->__key = 0;
    memcpy(&key_repr->__key, key, key_len);
  }
  else
  {
    key_repr->__key = malloc(key_len);
    if (key_repr->__key == NULL)
    {
      return false;
    }
    memcpy(key_repr->__key, key, key_len);
  }
  key_repr->key_len = key_len;

  return true;
}

/*
  Set, but don't copy
 */
static inline void
binkey_packed_set_unsafe(binkey_packed_t *key_repr, void *key,
                  size_t key_len)
{
  if (binkey_packed_inline(key_len))
  {
    // Store inline
    // Initialize to avoid clash with invalid value
    key_repr->__key = 0;
    memcpy(&key_repr->__key, key, key_len);
  }
  else
  {
    key_repr->__key = key;
  }
  key_repr->key_len = key_len;

}

static inline bool
binkey_packed_copy(binkey_packed_t *key_repr,
                   const binkey_packed_t *key_repr2)
{
  return binkey_packed_set(key_repr, binkey_packed_get(key_repr2),
                           binkey_packed_len(key_repr2));
}

/*
  Check if two binary keys are equal.
  Inline in header for performance
 */
static inline bool
binkey_eq(const void *key1, size_t key1_len, const void *key2, size_t key2_len)
{
  return key1_len == key2_len && memcmp(key1, key2, key1_len) == 0;
}

/*
  Check if first binary key is less than or equal to the second in
  lexical order.
  Inline in header for performance
 */
static inline bool
binkey_leq(const void *key1, size_t key1_len, const void *key2, size_t key2_len)
{
  size_t min_len = (key1_len < key2_len) ? key1_len : key2_len;
  int prefix_cmp = memcmp(key1, key2, min_len);
  if (prefix_cmp == 0)
  {
    // If same length, equal
    // If different length, shorter key is lesser
    return key1_len <= key2_len;
  }
  else
  {
    // Only true if less than
    return prefix_cmp < 0;
  }
}

static inline bool binkey_packed_eq(const binkey_packed_t *k1,
                               const binkey_packed_t *k2)
{
  return binkey_eq(binkey_packed_get(k1), binkey_packed_len(k1),
                   binkey_packed_get(k2), binkey_packed_len(k2));
}

static inline bool binkey_packed_leq(const binkey_packed_t *k1,
                               const binkey_packed_t *k2)
{
  return binkey_leq(binkey_packed_get(k1), binkey_packed_len(k1),
                   binkey_packed_get(k2), binkey_packed_len(k2));
}

/*
  Calculate hash for binary key
  Inline in header for performance
 */
static inline int
binkey_hash(const void* data, size_t length, int table_size)
{
  uint32_t p = bj_hashlittle(data, length, 0u);

  int ix = (int) (p % (uint32_t)table_size);
  return ix;
}

/*
  Print key in hex format a la printf.  Not very efficient, for debugging
 */
int binkey_printf(const void *key, size_t key_len);

/*
  Print key in hex format a la sprintf.  Not very efficient, for debugging
 */
int binkey_sprintf(char *str, const void *key, size_t key_len);

#endif // __CUTILS_BINKEYS
