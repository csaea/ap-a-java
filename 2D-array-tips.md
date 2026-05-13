# 2D arrays — AP CS A reference
Mental model for declaring, traversing, and tracing rectangular arrays.

## 1. Mental model
A 2D array is an *array of arrays*. Each row is itself a 1D array, and the outer array holds references to those rows.

```
int[][] grid = new int[3][4];   // 3 rows, 4 columns
```

```
        col 0   col 1   col 2   col 3
row 0 [   0   |   0   |   0   |   0   ]
row 1 [   0   |   0   |   0   |   0   ]
row 2 [   0   |   0   |   0   |   0   ]
```

Access uses two brackets: `grid[row][col]`. Row always comes first.

## 2. Declaration and initialization
| Form | Meaning |
|---|---|
| `int[][] a = new int[3][4];` | 3 rows, 4 columns, all zeros |
| `int[][] a = {{1,2,3},{4,5,6}};` | 2 rows, 3 columns, values set |
| `String[][] s = new String[2][2];` | 2×2, all `null` |
| `a[1][2] = 9;` | Set row 1, column 2 to 9 |

## 3. Dimensions
- `arr.length` → number of **rows**
- `arr[0].length` → number of **columns** (length of row 0)
- `arr[r].length` → number of columns in row `r`

> AP CS A treats 2D arrays as rectangular. Every row has the same length, so `arr[0].length` is the column count.

## 4. Traversal — nested for loop (row-major)
```java
for (int r = 0; r < arr.length; r++) {
    for (int c = 0; c < arr[0].length; c++) {
        // visit arr[r][c]
    }
}
```
Visits row 0 left-to-right, then row 1, then row 2. This is the default order on the exam unless the question asks otherwise.

**Column-major** swaps the loops — outer over columns, inner over rows:
```java
for (int c = 0; c < arr[0].length; c++) {
    for (int r = 0; r < arr.length; r++) {
        // visit arr[r][c] <-- note this is the same accessor as row-major>
    }
}
```

## 5. Enhanced for loop (for-each)

> Remember, when using enchanced for-loops, you can only read the values, you can't modify anything. The outer variable is the row (a 1D array). The inner variable is each value in that row. 

```java
for (int[] row : arr) {
    for (int val : row) {
        // read val -- can't modify
    }
}
```

## 6. Checking neighbors
For any cell at `arr[r][c]`, the four cardinal neighbors are one step up, down, left, and right. Each access needs a bounds guard or it will throw `ArrayIndexOutOfBoundsException` at the edges.

```
              [r-1][c]
                 ↑
   [r][c-1] ← [r][c] → [r][c+1]
                 ↓
              [r+1][c]
```

| Direction | Cell | Guard |
|---|---|---|
| Up | `arr[r-1][c]` | `r > 0` |
| Down | `arr[r+1][c]` | `r < arr.length - 1` |
| Left | `arr[r][c-1]` | `c > 0` |
| Right | `arr[r][c+1]` | `c < arr[0].length - 1` |

**The combined access pattern** — guard with `&&` so short-circuit blocks the dereference at the edge:

**Counting valid neighbors** — the canonical FRQ pattern:

```java
public int countLargerNeighbors(int[][] a, int r, int c) {
    int count = 0;
    if (r > 0 && a[r-1][c] > a[r][c]) count++;
    if (r < a.length - 1 && a[r+1][c] > a[r][c]) count++;
    if (c > 0 && a[r][c-1] > a[r][c]) count++;
    if (c < a[0].length - 1 && a[r][c+1] > a[r][c]) count++;
    return count;
}
```

Each guard is independent; each `if` handles one direction. Aligning the four lines vertically makes missing or swapped guards easier to spot during a trace.

## 7. Traps the exam loves
- Swapping `arr.length` and `arr[0].length` — first is rows, second is columns.
- Writing `arr[c][r]` when row-then-column is required.
- Using enhanced for to assign: `val = 0;` does nothing to the array.
- Off-by-one: `r <= arr.length` throws `ArrayIndexOutOfBoundsException`. Always `<`, never `<=`.
- Assuming a "neighbor" exists. Before accessing `arr[r-1][c]` or `arr[r+1][c]`, bounds-check both indices.
- Forgetting that `String[][]` defaults to `null`, not `""`. Calling a method on an uninitialized cell throws NPE.

## 8. Tracing heuristic
Draw the grid as a table with row and column indices labeled. Walk the loops by hand, writing the `(r, c)` pair visited at each step. For output questions, write each printed value in the order the loops produce them.

## Examples

### Example 1 — Dimensions
Given:
```java
int[][] m = {{1, 2, 3, 4},
             {5, 6, 7, 8},
             {9, 10, 11, 12}};
```
What does `m.length + m[0].length` evaluate to?

- A) 7 ✓
- B) 12
- C) 8
- D) 6

**Why:** `m.length` is the number of rows (3). `m[0].length` is the length of the first row (4). Sum is 7. The total cell count would be `m.length * m[0].length` (12), which is a common distractor.

---

### Example 2 — Row-major output
What does this print?
```java
int[][] g = {{1, 2}, {3, 4}, {5, 6}};
for (int r = 0; r < g.length; r++) {
    for (int c = 0; c < g[0].length; c++) {
        System.out.print(g[r][c] + " ");
    }
}
```

**Answer:** `1 2 3 4 5 6`

**Why:** Outer loop fixes the row, inner loop walks across columns. Row 0 prints first (`1 2`), then row 1 (`3 4`), then row 2 (`5 6`). Swapping the loop order would print column-major: `1 3 5 2 4 6`.

---

### Example 3 — Enhanced for, attempted modification
After this code runs, what is `arr[0][0]`?
```java
int[][] arr = {{1, 2}, {3, 4}};
for (int[] row : arr) {
    for (int val : row) {
        val = 0;
    }
}
```

- A) 0
- B) 1 ✓
- C) Compile error
- D) Runtime exception

**Why:** `val` is a copy of each `int` in the row. Reassigning `val` does not change the array. The values in `arr` are untouched. To zero the array, use traditional indexed loops: `arr[r][c] = 0;`.

---

### Example 4 — Bounds-safe neighbor check
A method should return the value directly above `arr[r][c]`, or `-1` if `r` is in the top row. Which fragment is correct?

- A) `return arr[r-1][c];`
- B) `if (r - 1 >= 0) return arr[r-1][c]; else return -1;` ✓
- C) `if (arr[r-1][c] != null) return arr[r-1][c]; else return -1;`
- D) `if (r > arr.length) return arr[r-1][c]; else return -1;`

**Why:** A throws `ArrayIndexOutOfBoundsException` when `r == 0`. C dereferences before checking and crashes for the same reason — and `int` is not nullable. D has the comparison backwards and uses the wrong dimension. B is the standard guard: verify the index is in range *before* accessing the element. This is the short-circuit pattern from the boolean reference applied to arrays.

---

### Example 5 — Counting with a condition
What does `countEven` return for the array below?
```java
int[][] nums = {{2, 5, 8},
                {3, 4, 7},
                {6, 1, 9}};

public static int countEven(int[][] a) {
    int count = 0;
    for (int[] row : a) {
        for (int n : row) {
            if (n % 2 == 0) count++;
        }
    }
    return count;
}
```

**Answer:** 4

**Why:** Enhanced for is appropriate here because the method only reads values, never writes. Even values are 2, 8, 4, 6 — total 4. The structure (outer loop over rows, inner over values within a row) is the cleanest pattern for any "count / sum / find" operation on a 2D array, and matches the form College Board uses in FRQ rubrics.
