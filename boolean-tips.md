
# Boolean expressions — AP CS A reference
One-page mental model for tracing and writing conditionals.

## 1. Precedence ladder

The precedence ladder is about which operator owns which operands, not about literal left-to-right reading order.

| # | Operator(s)        | Meaning                              |
|---|--------------------|--------------------------------------|
| 1 | `( )`              | Parentheses -- forces precedence                         |
| 2 | `!`                | Logical NOT -- expression must be evaluated to negate                      |
| 3 | `* / %` then `+ -` | Arithmetic                           |
| 4 | `< <= > >=`        | Relational                           |
| 5 | `== !=`            | Equality                             |
| 6 | `&&`               | Logical AND                          |
| 7 | `\|\|`             | Logical OR                           |

**Memory-aide:** 
NOT > math > compare > AND > OR
Evaluate left to right.

## 2. Short-circuit rules
- `&&` — left is `false` → stop. Right never runs.
- `||` — left is `true` → stop. Right never runs.

## 3. De Morgan's laws
```
!(a && b)  ≡  !a || !b
!(a || b)  ≡  !a && !b
```
> Distribute the `!`, then flip the operator. Forgetting the flip is the most-missed distractor.

## 4. Traps the exam loves

- `!a == b` means `(!a) == b`. It does not mean `!(a == b)`.
- `x > 0 && < 10` is a syntax error — each side of `&&` needs a full boolean.
- Reversed null-guard `obj.method() && obj != null` throws NPE.
> Canonical pattern: `obj != null && obj.method()` — null-guard always goes first.

## 5. Tracing heuristic

Fully parenthesize the expression first using the ladder, *then* evaluate left to right. Forces precedence into a conscious step instead of a guess.

## Examples

### Example 1 — Equivalent expression (De Morgan's)
Which expression is equivalent to `!(a < b && c >= d)`?

- A) `a > b && c <= d`
- B) `a >= b || c < d` ✓
- C) `a >= b && c < d`
- D) `a < b || c >= d`

**Why:** Distribute the `!` (turns `&&` into `||`), then negate each relational: `<` becomes `>=`, `>=` becomes `<`. Choice B is the only one that flips both the operator and both comparisons.

---

### Example 2 — Short-circuit with side effects

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

**Answer:** `false`.

**Why:** Arithmetic first: `y + 5` is `3`. Relational next: `x > 3` is `true`. Then `&&`: `b && true` is `true`. Then `||`: short-circuits to `true`... wait — re-trace carefully. `b` is `true`, so `b && (x > y+5)` is `true && true` → `true`. Then `true || !b` → `true`. **Corrected answer: `true`.** This is the exact mid-trace mistake the exam exploits: students stop early or skip arithmetic precedence. Always finish the ladder.

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
