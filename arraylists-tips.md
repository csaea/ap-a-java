# ArrayList — AP CS A reference
Mental model for declaring, traversing, and modifying ArrayLists.

## 1. Mental model
An `ArrayList` is a resizable list of *object references*. It is a class with methods that handle growth, insertion, and removal. 

```
ArrayList<String> list = new ArrayList<String>();
list.add("A");   list.add("B");   list.add("C");
```

```
    index   0     1     2
list  [   "A"  | "B"  | "C"  ]
```

> ArrayLists hold **objects only**, not primitives. `ArrayList<int>` is a compile error. Use `ArrayList<Integer>` and let autoboxing convert `int` ↔ `Integer` automatically.

## 2. Import and declaration
```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<String>();   // empty list of Strings
ArrayList<Integer> nums = new ArrayList<>();         // diamond — type inferred
```

Once the type inside `< >` is declared, every element must be that type.

## 3. The AP subset — six methods
The exam restricts ArrayList to these six methods. Anything else (`contains`, `indexOf`, `isEmpty`, `clear`) **not** on the Quick Reference will not appear in test code.

| Method | Returns | Purpose |
|---|---|---|
| `size()` | `int` | Number of elements |
| `add(E obj)` | `boolean` | Append to end |
| `add(int i, E obj)` | `void` | Insert at index `i`; shifts later elements right |
| `get(int i)` | `E` | Read element at index `i` |
| `set(int i, E obj)` | `E` | Replace element at `i`; returns the **old** value |
| `remove(int i)` | `E` | Delete element at `i`; returns the removed value; shifts later elements left |


## 4. Autoboxing
ArrayLists only work with objects. Fortunately, Java silently converts between `int` and `Integer` (and `double` ↔ `Double`).

```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(5);              // int 5 boxed to Integer
int x = nums.get(0);      // Integer unboxed to int
nums.set(0, nums.get(0) + 1);   // unbox, add, box back
```

Compare boxed values with `.equals()`, never `==`! `==` compares references and is unreliable for `Integer`.

## 5. Standard traversal — indexed for loop
```java
for (int i = 0; i < list.size(); i++) {
    // visit list.get(i)
}
```
Required whenever the body needs the index (e.g., to call `set` or `remove`), or when the list is being modified during traversal.

## 6. Enhanced for loop (for-each)
```java
for (String s : list) {
    // read s -- can't modify the list!
}
```
Read-only. Reassigning `s` does nothing to the list. Calling `list.add` or `list.remove` inside an enhanced for loop throws `ConcurrentModificationException` at runtime.

## 7. Comparing elements
Always use `.equals()` for objects. `==` checks whether two references point to the same object, which is rarely what an FRQ asks.

```java
if (list.get(i).equals("done")) { ... }    // correct
if (list.get(i) == "done")      { ... }    // unreliable
```

Numeric wrapper types follow the same rule: `nums.get(i).equals(5)` is safe; `nums.get(i) == 5` works by accident through unboxing but should not be relied on.

## 8. The removal trap — forward iteration skips elements
When `remove(i)` deletes an element, every element to its right shifts left by one. If `i` then increments, the loop **skips** the element that took the removed slot.

```java
// BUG -- removes "B" but skips "C"
ArrayList<String> list = new ArrayList<>(List.of("A", "B", "B", "C"));
for (int i = 0; i < list.size(); i++) {
    if (list.get(i).equals("B")) list.remove(i);
}
// result: ["A", "B", "C"]  -- one "B" remains
```

**Two standard fixes:**

*(a)* Decrement `i` after removing, so the next iteration revisits the same index:
```java
for (int i = 0; i < list.size(); i++) {
    if (list.get(i).equals("B")) {
        list.remove(i);
        i--;
    }
}
```

*(b)* Iterate **backward** — shifts happen to indices already visited, so nothing is skipped:
```java
for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i).equals("B")) list.remove(i);
}
```

Backward iteration is the cleaner pattern. Use it whenever a method removes elements during traversal.

## 9. Traps the exam loves
- Comparing elements with `==` instead of `.equals()`.
- Declaring `ArrayList<int>` — primitives are not allowed as generics.
- Writing `list.length` or `list.length()`. ArrayList uses `size()`.
- Using `list[i]` square-bracket syntax. ArrayList uses `get(i)` and `set(i, v)`.
- Confusing `add(i, v)` (insert, grows list) with `set(i, v)` (replace, size unchanged).
- Removing during forward iteration without adjusting `i`.
- Forgetting that `remove` and `set` return the element — discarding a return value that the rubric expects to be used or stored.

## 10. Tracing heuristic
Draw the list as a row of indexed boxes. After every `add`, `remove`, or `set`, redraw the list and update the index labels. Treat `size()` as the current number of boxes — it shrinks and grows as you trace.

## 11. Common FRQ patterns

**Counting matches** — accumulator outside the loop:
```java
int count = 0;
for (String s : list) {
    if (s.equals(target)) count++;
}
return count;
```

**Finding the first match** — return early:
```java
for (int i = 0; i < list.size(); i++) {
    if (list.get(i) > threshold) return i;
}
return -1;
```

**Filtering in place** — backward removal:
```java
for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i) < 0) list.remove(i);
}
```

**Building a result list** — declare empty, append in loop:
```java
ArrayList<Integer> evens = new ArrayList<>();
for (int n : nums) {
    if (n % 2 == 0) evens.add(n);
}
return evens;
```

## Examples

### Example 1 — `add` vs `set`
Starting from `list = ["A", "B", "C"]`, what does the list contain after this code?
```java
list.add(1, "X");
list.set(2, "Y");
```

- A) `["A", "X", "Y"]`
- B) `["A", "X", "Y", "C"]` ✓
- C) `["A", "X", "B", "Y"]`
- D) `["X", "A", "Y", "C"]`

**Why:** `add(1, "X")` inserts at index 1, shifting `"B"` and `"C"` right → `["A", "X", "B", "C"]`. Then `set(2, "Y")` replaces the element at index 2 (now `"B"`) with `"Y"` → `["A", "X", "Y", "C"]`. The trap is treating `set` as another insert (choice C) or losing track of the shift caused by `add`.

---

### Example 2 — The removal trap
What does `list` contain after this code runs?
```java
ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 2, 2, 3));
for (int i = 0; i < list.size(); i++) {
    if (list.get(i) == 2) list.remove(i);
}
```

- A) `[1, 3]`
- B) `[1, 2, 3]` ✓
- C) `[1, 2, 2, 3]`
- D) Runtime exception

**Why:** When index 1 (value 2) is removed, the next `2` shifts down into index 1. The loop then increments to index 2, skipping it. The pattern repeats: every other `2` is missed. To remove all matching elements during forward iteration, decrement `i` after removal, or — preferred — iterate backward.

---

### Example 3 — Backward iteration
Which loop correctly removes every negative value from `nums`?

- A) 
```java
for (int i = 0; i < nums.size(); i++)
    if (nums.get(i) < 0) nums.remove(i);
```
- B) 
```java
for (int n : nums)
    if (n < 0) nums.remove(n);
```
- C) 
```java
for (int i = nums.size() - 1; i >= 0; i--)
    if (nums.get(i) < 0) nums.remove(i);
```
✓
- D) 
```java
for (int i = 0; i <= nums.size(); i++)
    if (nums.get(i) < 0) nums.remove(i);
```

**Why:** A skips elements (the removal trap). B does two things wrong: it modifies a list during an enhanced for loop (throws `ConcurrentModificationException`), and `remove(n)` passes the *value* as an *index*. D has the wrong bound (`<=`) and would throw `ArrayIndexOutOfBoundsException` even before considering the skip bug. C walks from the end, so any shift caused by removal happens to indices that have already been processed.

---

### Example 4 — Counting with a condition
What does `countShortNames` return for `list = ["Al", "Bea", "Cy", "Dee"]`?
```java
public static int countShortNames(ArrayList<String> list) {
    int count = 0;
    for (String s : list) {
        if (s.length() <= 2) count++;
    }
    return count;
}
```

**Answer:** 2

**Why:** Enhanced for is correct here because the method only reads elements. `"Al"` (length 2) and `"Cy"` (length 2) both satisfy the condition. `"Bea"` and `"Dee"` (length 3) do not. The accumulator pattern — declare `count` before the loop, increment inside, return after — is the canonical FRQ shape for any "how many" question.

---

### Example 5 — `set` returns the old value
What is printed?
```java
ArrayList<String> list = new ArrayList<>(List.of("red", "green", "blue"));
String prev = list.set(1, "yellow");
System.out.println(prev + " " + list.get(1));
```

- A) `yellow yellow`
- B) `green green`
- C) `green yellow` ✓
- D) `yellow green`

**Why:** `set` replaces the element at index 1 and **returns the value that was there before**. `prev` holds the old value `"green"`. After the call, `list.get(1)` is `"yellow"`. The same return-the-old-value behavior applies to `remove`, which returns the deleted element — a detail FRQs sometimes require students to capture and use.