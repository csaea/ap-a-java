
# Boolean expressions — AP CS A reference
One-page mental model for tracing and writing conditionals.

## 1. Precedence ladder

Precedence determines **grouping**, not evaluation order. It tells you which operands attach to which operator — where Java inserts the implicit parentheses when you omit them. It does not tell you which expression runs first at runtime.

| # | Group   | Operators              |
|---|---------|------------------------|
| 1 | (Parens) | `( )`                 |
| 2 | NOT     | `!`                    |
| 3 | Math    | `* / %` then `+ -`     |
| 4 | Compare | `< <= > >=` then `== !=` |
| 5 | AND     | `&&`                   |
| 6 | OR      | `\|\|`                 |

**Memory aid:** NOT → math → compare → AND → OR.

## 2. Short-circuit evaluation

Once grouping is settled, Java evaluates operands left-to-right and may stop early:

- `&&` — if the left operand is `false`, the right operand is never evaluated.
- `||` — if the left operand is `true`, the right operand is never evaluated.

**Example.** `a || b && c` parses as `a || (b && c)` because `&&` outranks `||`. At runtime, `a` is evaluated first; if `a` is `true`, the entire parenthesized group is skipped.

## 3. De Morgan's law

You can use de morgan's laws to simplify an expression. It isn't necessary, but does make problems easier to solve. 

```
!(a && b)  ≡  !a || !b
!(a || b)  ≡  !a && !b
```
> Distribute the `!`, then flip the operator. Forgetting the flip is the most-missed distractor.

Read more about de Morgans laws [here](https://www.apcsexamprep.com/blogs/ap-csa-daily-practice/ap-csa-u2-c1-day-9-de-morgans-laws).

## 4. Traps the exam loves

- `!a == b` means `(!a) == b`. It does not mean `!(a == b)`.
- `x > 0 && < 10` is a syntax error — each side of `&&` needs a full boolean.
- Reversed null-guard `obj.method() && obj != null` throws error.
> Canonical pattern: `obj != null && obj.method()` — null-guard always goes first.

## 5. Tracing heuristic

Fully parenthesize the expression first using the ladder, *then* evaluate left to right. Forces precedence into a conscious step instead of a guess.

## Examples

### Example 1 — Equivalent expression 
Which expression is equivalent to `!(a < b && c >= d)`?

- A) `a > b && c <= d`
- B) `a >= b || c < d` ✓
- C) `a >= b && c < d`
- D) `a < b || c >= d`

**Why:** The outer ! is true whenever the inner expression is false. An && is false whenever at least one side is false — so the whole thing is true when a < b fails, or c >= d fails, or both. "At least one fails" is an OR, with each side flipped to its opposite: a >= b || c < d.

**Using De Morgan's law:** Distribute the `!` (turns `&&` into `||`), then negate each relational: `<` becomes `>=`, `>=` becomes `<`. Choice B is the only one that flips both the operator and both comparisons.

---

### Example 2 — Short-circuit 

Given:
```java
public boolean test() { count++; return true; }
```
With `count` initialized to 0, what is `count` after this line runs?
```java
if (test() || test() && !test()) { }
```

**Answer:** `count == 1`.

**Why:** `&&` binds tighter than `||`, so the expression parses as `test() || (test() && !test())`. The leftmost `test()` returns `true`, which short-circuits the entire `||`. The right operand — the whole parenthesized group — is never evaluated. Only one call occurs.

---

### Example 3 — Tracing with values

Given `int x = 4; int y = -2; boolean b = true;`, evaluate:
```java
b && x > y + 5 || !b
```

**Answer:** `true`.

**Why:**  `b` is `true`, so `b && (x > y+5)` is `true && true` → `true`. Then `true || !b` → short-circuit → `true`. 

---

### Example 4 — Range check

Which expression is `true` exactly when `score` is between 70 and 89 inclusive?

- A) `score >= 70 || score <= 89`
- B) `score >= 70 && score <= 89` ✓
- C) `70 <= score <= 89`
- D) `score > 70 && score < 89`

**Why:** A is `true` for every integer (any number is either ≥ 70 or ≤ 89). C is a compile error — Java does not chain relational operators. D excludes the endpoints 70 and 89. Only B captures the closed interval.

---

### Example 5 — Null-guard ordering

Which expression safely returns `true` when `String s` begins with the letter `'A'`, and `false` otherwise (including when `s` is `null`)?

- A) `s.charAt(0) == 'A' && s != null`
- B) `s != null && s.charAt(0) == 'A'` ✓
- C) `s != null || s.charAt(0) == 'A'`
- D) `s.length() > 0 && s.charAt(0) == 'A'`

**Why:** A and D dereference `s` before checking for null, throwing `NullPointerException`. C uses `||`, which only short-circuits when the left is `true` — a `null` value passes the first check and still triggers `charAt` on the right. Only B guarantees the null check runs first and stops the chain when `s` is `null`.
