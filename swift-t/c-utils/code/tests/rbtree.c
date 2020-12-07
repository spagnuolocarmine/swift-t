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
 * rbtree.c
 *
 *  Created on: Oct 26, 2012
 *      Author: wozniak
 */

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#include "src/c-utils-tests.h"
#include "src/rbtree.h"
#include "src/tools.h"

static void
pop_all(struct rbtree* T)
{
  long k;
  void* v;
  int size = T->size;
  int pops = 0;
  while (true)
  {
    bool b = rbtree_pop(T, &k, &v);
    if (!b) { printf("POPPED NULL\n"); break; }
    printf("popped: %li=%s\n\n", k, (char*) v);
    printf("STABLE:\n");
    rbtree_print(T);
    pops++;
  }
  ASSERT_TRUE(pops == size);
}

static bool
test_cb(struct rbtree_node* node, void* user_data)
{
  printf("node: %li %s\n", node->key, (char*) node->data);
  return false;
}

static bool
empty_cb(struct rbtree_node* node, void* user_data)
{
  printf("node: %li %s\n", node->key, (char*) node->data);
  return true;
}

static bool
test_empty_iterator()
{

  struct rbtree T;
  rbtree_init(&T);
  bool found = rbtree_iterator(&T, empty_cb, NULL);
  if (found)
  {
    fprintf(stderr, "Found something in empty tree\n");
    exit(1);
  }
  fprintf(stderr, "Empty iterator did nothing\n");
  return true;
}

int
main()
{
  struct rbtree T;
  rbtree_init(&T);

  // TEST 1:

  rbtree_add(&T, 12, "hello");
  rbtree_add(&T, 8,  "hello");
  rbtree_add(&T, 9,  "hello");
  rbtree_add(&T, 10, "hello");
  rbtree_add(&T, 7,  "hello");
  rbtree_add(&T, 15, "hello");
  rbtree_add(&T, 14, "hello");
  rbtree_add(&T, 13, "hello");
  rbtree_print(&T);

  printf("\nITERATOR...\n");
  rbtree_iterator(&T, test_cb, NULL);

  printf("\nREMOVING...\n");

  void* data;
  rbtree_remove(&T, 12, &data);
  printf("remove ok.\n");
  rbtree_print(&T);

  pop_all(&T);

  printf("\n--\n\n");

 // TEST 2: in-order insertion

  for (long i = 1; i <= 20; i++)
  {
    rbtree_add(&T, i, "hello");
    rbtree_print(&T);
  }

  pop_all(&T);

  // TEST 3: random insertion / in-order deletion

  int n = 100;
  long A[n];
  for (int i = 0; i < n; i++)
    A[i] = i;
  shuffle(A, n);
  for (int i = 0; i < n; i++)
    rbtree_add(&T, A[i], NULL);

  printf("COMPLETE TREE:\n");
  rbtree_print(&T);
  printf("\n");

  pop_all(&T);

  // TEST 4: random insertion / random deletion

  printf("\nRANDOM INSERTION - RANDOM DELETION\n\n");
  shuffle(A, n);
  print_longs(A, n);
  printf("\n");
  for (int i = 0; i < n; i++)
    rbtree_add(&T, A[i], NULL);
  shuffle(A, n);
  print_longs(A, n);
  printf("\n");
  for (int i = 0; i < n; i++)
  {
    int64_t key = A[i];
    printf("removing: %li (size %i root %"PRId64")\n",
            key, T.size, T.root->key);
    struct rbtree_node *n = rbtree_search_node(&T, key);
    printf("found node %p: key %li\n", n, n->key);
    ASSERT_TRUE(n->key == key);
    bool b = rbtree_remove(&T, key, NULL);
    ASSERT_TRUE(b);
    rbtree_print(&T);
  }

  // TEST 5: moves

  int m = 8;
  int moves = 2;
  ASSERT_TRUE(moves < m/2);

  long B[m];
  for (int i = 0; i < m; i++)
    B[i] = i;

  long tmp[m];
  memcpy(tmp, B, m*sizeof(long));
  shuffle(tmp, m);

  // sources
  long S[moves];
  // dests
  long D[moves];
  for (int i = 0; i < moves; i++)
  {
    S[i] = tmp[i];
    D[i] = tmp[m-i-1];
  }

  printf("B:\n");
  print_longs(B, m);
  printf("\n");
  printf("S:\n");
  print_longs(S, moves);
  printf("\n");
  printf("D:\n");
  print_longs(D, moves);
  printf("\n");

  // add all data
  printf("ADDING...\n");
  for (int i = 0; i < m; i++)
    rbtree_add(&T, B[i], NULL);
  rbtree_print(&T);

  // remove all dests (make space for moves)
  printf("REMOVING DESTS...\n");
  for (int i = 0; i < moves; i++)
    rbtree_remove(&T, D[i], NULL);
  rbtree_print(&T);

  printf("MOVING...\n");
  // do each move
  for (int i = 0; i < moves; i++)
  {
    printf("moving: %li to %li\n", S[i], D[i]);
    rbtree_move(&T, S[i], D[i]);
    printf("move done.\n");
    rbtree_print(&T);
  }

  rbtree_clear(&T);

  printf("SIZE: %i\n", T.size);

  test_empty_iterator();

  // TEST - range search
  printf("RANGE SEARCH\n");

  int MAX_RANGE = 100;
  // Add odds only so there are gaps
  for (int i = 1; i < MAX_RANGE; i += 2)
  {
    rbtree_add(&T, i, (void*)(long)i);

    for (int j = 0; j < MAX_RANGE; j++)
    {
      struct rbtree_node *n = rbtree_search_range(&T, j);
      if (j <= i)
      {
        // Should return exact match or one after
        int exp_key = j + (1 - j % 2);
        ASSERT_TRUE_MSG(n->key == exp_key, "Expected lookup of %i to be"
                                  "%i after adding %i", j, exp_key, i);
        for (int k = exp_key + 2; k <= i; k += 2)
        {
          struct rbtree_node *nn = rbtree_next_node(n);

          ASSERT_TRUE_MSG(nn->key == k, "Expected %"PRId64" == %i", nn->key, k);
          ASSERT_TRUE_MSG((long)nn->data == k, "Expected %li == %i", (long)nn->data, k);

          // Check prev node works
          ASSERT_TRUE(rbtree_prev_node(nn) == n);

          n = nn;
        }

        // Should be at last valid node
        ASSERT_TRUE(rbtree_next_node(n) == NULL);
      }
      else
      {
        ASSERT_TRUE_MSG(rbtree_search_range(&T, j) == NULL,
                    "Expected lookup of %i to be NULL", j);
      }
    }

    // Check that searching past last always returns NULL
    ASSERT_TRUE_MSG(rbtree_search_range(&T, i + 1) == NULL,
                    "Expected lookup of %i to be NULL", i + 1);
  }

  // Check that we get all duplicates
  int DUPES_OF_2 = 10;
  for (int i = 0; i < DUPES_OF_2; i++)
  {
    rbtree_add(&T, 2, NULL);
  }
  int found_dupes = 0;
  struct rbtree_node *node = rbtree_search_range(&T, 2);
  while (node != NULL && node->key == 2)
  {
    found_dupes++;
    node = rbtree_next_node(node);
  }
  ASSERT_TRUE_MSG(found_dupes == DUPES_OF_2, "Expected %i == %i",
                  DUPES_OF_2, found_dupes);

  rbtree_clear(&T);

  /*
    Regression test for duplicates.
    Root should be 1
    Left and right subtree should have many zeroes and twos
    Additional one should be deep in a subtree
   */
  rbtree_add(&T, 1, NULL);
  for (int i = 0; i < 100; i++)
  {
    rbtree_add(&T, 0, NULL);
    rbtree_add(&T, 2, NULL);
  }
  rbtree_add(&T, 1, NULL);

  printf("RANGE SEARCH REGRESSION 1\n");
  found_dupes = 0;
  node = rbtree_search_range(&T, 1);
  while (node != NULL && node->key == 1)
  {
    printf("Found %p %"PRId64"\n", node, node->key);
    found_dupes++;
    node = rbtree_next_node(node);
  }
  ASSERT_TRUE_MSG(found_dupes == 2, "Expected %i == %i",
                  2, found_dupes);

  printf("DONE\n");
  return 0;
}
