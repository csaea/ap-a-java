# Boolean expressions — AP CS A reference
One-page mental model for tracing and writing conditionals.

## 1. Precedence ladder

Precedence determines **grouping**, not evaluation order. It tells you which operands attach to which operator — where Java inserts the implicit parentheses when you omit them. It does not tell you which expression runs first at runtime.

| # | Group   | Operators              | What it does |
|---|---------|------------------------|--------------|
| 1 | (Parens) | `( )`                 | Force grouping. Inner expression evaluates as a unit. |
| 2 | NOT     | `!`                    | Flips a boolean. |
| 3 | Math    | `* / %` then `+ -`     | Produces a number. |
| 4 | Compare | `< <= > >=` then `== !=` | Relational and equality. Produce booleans. |
| 5 | AND / OR     | `&&` then `\|\|`        | Combine booleans. Short-circuit. |

**Memory aid:** NOT → math → compare → AND → OR.

## 2. Short-circuit evaluation

Once grouping is settled, Java evaluates operands left-to-right and may stop early:

- `&&` — if the left operand is `false`, the right operand is never evaluated.
- `||` — if the left operand is `true`, the right operand is never evaluated.

**Example.** `a || b && c` parses as `a || (b && c)` because `&&` outranks `||`. At runtime, `a` is evaluated first; if `a` is `true`, the entire parenthesized group is skipped.

**Compile time vs runtime.** Precedence (Section 1) is resolved at compile time, when Java parses the source into a syntax tree. The grouping is fixed before the program ever runs. Short-circuit evaluation (Section 2) is a runtime behavior — it depends on the actual values produced as the expression executes.

## 3. Truth tables

A truth table enumerates every input combination for a boolean expression. Since each variable has two possible states (T or F), *n* variables produce 2ⁿ rows. Useful for verifying that two expressions are equivalent (their output columns match) and for tracing problems.

### Basic operators

| a | b | a && b | a \|\| b |
|---|---|--------|----------|
| T | T | T      | T        |
| T | F | F      | T        |
| F | T | F      | T        |
| F | F | F      | F        |

`&&` is `true` only when both operands are `true`. `||` is `true` whenever at least one operand is `true`.

### Compound expression

Verifying `!(a && b) ≡ !a || !b`:

| a | b | a && b | !(a && b) | !a | !b | !a \|\| !b |
|---|---|--------|-----------|----|----|------------|
| T | T | T      | F         | F  | F  | F          |
| T | F | F      | T         | F  | T  | T          |
| F | T | F      | T         | T  | F  | T          |
| F | F | F      | T         | T  | T  | T          |

The `!(a && b)` column and the `!a || !b` column match in every row. The two expressions are logically equivalent.

## 4. De Morgan's law

You can use de morgan's laws to simplify an expression. It isn't necessary, but does make problems in which you have to determine equivalent expressions easier to solve. 

```
!(a && b)  ≡  !a || !b
!(a || b)  ≡  !a && !b
```
> Distribute the `!`, then flip the operator. Forgetting the flip is the most-missed issue.

### Examples of equivalent expressions

```
!(x < 5)             ≡  x >= 5
!(x > 5)             ≡  x <= 5
!(x == 5)            ≡  x != 5

!(x > 0 && y <= 10)  ≡  x <= 0 || y > 10
!(x < 1 || x > 9)    ≡  x >= 1 && x <= 9
!(s != null && b)    ≡  s == null || !b
```

Read more about de Morgans laws [here](https://www.apcsexamprep.com/blogs/ap-csa-daily-practice/ap-csa-u2-c1-day-9-de-morgans-laws).

## 5. Traps the exam loves

- `!a == b` means `(!a) == b`. It does not mean `!(a == b)`.
- `x > 0 && < 10` is a syntax error — each side of `&&` needs a full boolean.
- Reversed null-guard `obj.method() && obj != null` throws error.
> Canonical pattern: `obj != null && obj.method()` — null-guard always goes first.

## 6. Tracing heuristic

Fully parenthesize the expression first using the ladder, *then* evaluate left to right. Forces precedence into a conscious step instead of a guess.

## Examples

### Example 1 — Equivalent expression 
Which expression is equivalent to `!(a < b && c >= d)`?

- A) `a > b && c <= d`
- B) `a >= b || c < d` ✓
- C) `a >= b && c < d`
- D) `a < b || c >= d`


---

### Example 2 — Short-circuit vs Precedence

Given:
```java
public boolean test() { count++; return true; }
```
With `count` initialized to 0, what is `count` after this line runs?
```java
if (test() || test() && !test()) { }
```

**Answer:** `count == 1`.

**Why:** `&&` binds tighter than `||`, so the expression parses as `test() || (test() && !test())`. But during runtime, the leftmost `test()` returns `true`, which short-circuits the entire `||`. The right operand — the whole parenthesized group — is never evaluated. Only one call occurs.

---

### Example 3 — Tracing with values

Given `int x = 4; int y = -2; boolean b = true;`, evaluate:
```java
b && x > y + 5 || !b
```

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

