
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

### Example 1 — Equivalent expression 
Which expression is equivalent to `!(a < b && c >= d)`?

- A) `a > b && c <= d`
- B) `a >= b || c < d` 
- C) `a >= b && c < d`
- D) `a < b || c >= d`


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

---

### Example 3 — Tracing with values

Given `int x = 4; int y = -2; boolean b = true;`, evaluate:
```java
b && x > y + 5 || !b
```

*

---

### Example 4 — Range check

Which expression is `true` exactly when `score` is between 70 and 89 inclusive?

- A) `score >= 70 || score <= 89`
- B) `score >= 70 && score <= 89` 
- C) `70 <= score <= 89`
- D) `score > 70 && score < 89`


---

### Example 5 — Null-guard ordering

Which expression safely returns `true` when `String s` begins with the letter `'A'`, and `false` otherwise (including when `s` is `null`)?

- A) `s.charAt(0) == 'A' && s != null`
- B) `s != null && s.charAt(0) == 'A'` 
- C) `s != null || s.charAt(0) == 'A'`
- D) `s.length() > 0 && s.charAt(0) == 'A'`


