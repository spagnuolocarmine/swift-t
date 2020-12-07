/*
 * Copyright 2013-2015 University of Chicago and Argonne National Laboratory
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
 * rbtree-bp.h
 *
 *  Created on: May 29, 2015
 *      Author: Tim Armstrong
 *
 * Red-black tree with binary keys and pointer values.
 *
 * The implementation will copy keys for internal use and
 * may allocate additional memory per key.
 */

#ifndef RBTREE_BP_H
#define RBTREE_BP_H

#include <stddef.h>

#include "binkeys.h"

#define RBTREE_KEY_T binkey_packed_t
#define RBTREE_VAL_T void*
#define RBTREE_TYPENAME rbtree_bp
#define RBTREE_PFX rbtree_bp_

#include "rbtree-template.h"

#endif

