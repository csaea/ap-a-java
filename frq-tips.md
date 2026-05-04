## AP CSA FRQ Cheat Sheet

**Section II of the CS AP A Exam:** 4 FRQs · 90 min · ~22 min each · Java Quick Reference is provided

### The Four Questions (and what you'll coding)
1. **Methods & Control** (2 parts) —
- you'll be given classes, data, and helper methods to use. You'll write two methods to solve a logical problem stated within the question. You'll *control* the data with conditionals, loops, String method, etc.
2. **Class Writing** — constructor, method, instance variables
- you'll be given a description of an object: what data it tracks and what it should do. You'll write the class — private instance variables, a constructor that initializes them, and at least one method. You'll *encapsulate* the data and expose behavior through methods.
3. **ArrayList** — traverse / filter / modify
- you'll be given an existing class with an ArrayList field already declared, plus method specs. You'll write one method that walks the list. You'll *manipulate* elements with `.get()`, `.set()`, `.add()`, `.remove()`.
4. **2D Array** — nested loops
- you'll be given a grid (a 2D array of values or objects) and a method spec. You'll write a method that walks the grid with nested loops. You'll *navigate* by row and column to count, compare, or modify cells.

---

### How to Read the Prompt
- **Read twice.** First for the story, second for notes. Highlight everthing you might need.
- **The classes they give you** = your inventory of tools. Assume you will use every listed attribte/data and method they give you.
- `/* implementation not shown */` → **you'll probably need to call it. No need to rewrite it.**
- **Circle:** return type, parameters, provided method names, preconditions.

---

### When Stuck
- Write the **method signature** and a comment of intent — never leave blank.
- Code the **structure** (loop + if + return) before the details. Algorithm points reward correct sequence even with bugs.
- Move on at 22 minutes; return with fresh eyes.

---

### Distilling the Task: Pattern Triggers
| When you see... | Reach for... |
|---|---|
| A list, array, String, or ArrayList | a **loop** |
| "matches," "contains," "greater than," "is equal to" | an **`if`** |
| An object given to you | the **dot operator** (`obj.method()`) |
| Two related operations ("find and act") | a **helper method** |
| "How many...," "count," "total" | an **accumulator** (`int count = 0;` outside loop, `count++` inside) |
| "First / smallest / largest..." | a **tracker variable** initialized before the loop |
| "Build a string / list of..." | initialize **empty**, append in loop |
| Data that must persist between method calls | an **instance variable** |

---

### Iteration Techniques
- **Standard forward:** `for (int i = 0; i < arr.length; i++)`
- **Enhanced for** (read-only, no index needed): `for (String s : list)`
- **Backward** (when removing from an ArrayList): `for (int i = list.size() - 1; i >= 0; i--)`
- **2D row-major** (most common): outer = rows, inner = columns
  ```java
  for (int r = 0; r < arr.length; r++)
      for (int c = 0; c < arr[r].length; c++)
          // arr[r][c]
  ```
- **Dimensions:** `arr.length` = rows · `arr[r].length` = cols in row `r` (use this over `arr[0].length` — safer if rows vary)
- **Column-major** (walk columns first): swap the loops — outer is `c`, inner is `r`
- **Backward traversal:** start at `arr.length - 1` and decrement (e.g., gravity / falling problems)
- **Checking a neighbor** at `(r±1, c±1)` — guard the bounds first:
  ```java
  if (r >= 0 && r < arr.length && c >= 0 && c < arr[r].length)
  ```
- **Counting matches in the grid:** declare `count` *outside both loops*, increment inside
- **Don't assume square** — `rows == cols` only when the prompt says so

---

### Math & Logic Toolkit
- **Modulo `%`:**
  - Wrap-around: `(day + offset) % 7`
  - Parity: `n % 2 == 0` (even)
  - Divisibility: `a % b == 0`
  - Last digit: `n % 10`
- **Integer division** truncates: `5 / 2 == 2`. For ceiling division: `(a + b - 1) / b`.
- **Min / Max:** `Math.min(a, b)`, `Math.max(a, b)`. For min-of-many, initialize tracker to first element (or `Integer.MAX_VALUE`).
- **Random integer in [a, b]:** `(int)(Math.random() * (b - a + 1)) + a`
- **Compound conditions:** `&&` short-circuits — put cheap/safe checks first (e.g., `i < arr.length && arr[i] > 0`).

---

### Essential Java Syntax
**Strings**
- Comparison: `s1.equals(s2)` — never `==`
- One character: `s.substring(i, i+1)` (preferred — returns a String)
- Search: `s.indexOf("x")` returns -1 if absent
- Length: `s.length()`

**Arrays**
- Length: `arr.length` (no parens)
- Access: `arr[i]`, 2D: `arr[r][c]`
- 2D Dimensions: `arr.length` = rows, `arr[0].length` = cols

**ArrayList**
- Size: `list.size()`
- Read: `list.get(i)`
- Replace in place: `list.set(i, v)` — **not `add`**
- Insert / append: `list.add(v)` or `list.add(i, v)`
- Remove: `list.remove(i)`

**Class skeleton**
```java
public class Foo {

    // ---- INSTANCE variables (attributes/data): ONE copy PER object ----
    // Each new Foo object instance has its own x and name.
    private int x;
    private String name;

    // ---- STATIC variables: ONE copy shared by the whole class ----
    // Foo.count is the same value for every Foo object. 
    private static int count = 0;       // tracks total Foo objects ever made
    public static final int MAX = 100;  // constant — same for all

    // ---- constructor ----
    public Foo(int x, String name) {    // no return type, not even void
        this.x = x;                     // 'this.x' = THIS object's x
        this.name = name;
        count++;                        // shared counter — no 'this'
    }

    // ---- behaviors (methods) ----
    public int getX() {                 // accessor: RETURNS, doesn't print
        return x;                       // returns THIS object's x
    }

    public void rename(String newName) { // mutator: changes THIS object's state
        this.name = newName;
    }
}
```