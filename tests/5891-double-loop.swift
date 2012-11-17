

#include <builtins.swift>
#include <string.swift>
#include <io.swift>

main
{
  int A[][];

  int rows = 10;
  int columns = 10;
  foreach i in [0:rows-1]
  {
    A[i][0] = 0;
  }
  foreach i in [0:rows-1]
  {
    foreach j in [0:columns-1]
    {
      A[i][j+1] = 1;
    }
  }

  print_square_array(A, rows, columns);
}

print_square_array(int A[][], int rows, int cols) {
  foreach i in [0:rows-1] {
    string row_str;
    for (row_str = "", int j = 0; j < cols;
                j = j + 1, row_str=next_row_str) {
      string next_row_str = sprintf("%s %0.4f", row_str, A[i][j]);
    }
    printf("row %i: %s", i, row_str);
  }
}
