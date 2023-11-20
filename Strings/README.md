# Strings in Java 📝

Strings are one of the most important and frequently used data types in Java programming.

## Topics Covered

### 1. **StringBasics.java** - String fundamentals
- String creation and initialization
- String immutability concept
- String pool and memory management
- Basic string operations

### 2. **StringMethods.java** - Essential string methods
- length(), charAt(), substring()
- indexOf(), contains(), startsWith(), endsWith()
- toUpperCase(), toLowerCase(), trim()
- replace(), split(), join()

### 3. **StringComparison.java** - Comparing strings
- equals() vs == operator
- equalsIgnoreCase(), compareTo()
- String comparison best practices
- Common pitfalls and solutions

### 4. **StringBuilder.java** - Mutable strings
- Why StringBuilder is needed
- StringBuilder vs String performance
- Common StringBuilder methods
- When to use StringBuilder

### 5. **StringProblems.java** - Common string problems
- Palindrome checking
- Anagram detection
- String reversal
- Character frequency counting
- Pattern matching

### 6. **RegularExpressions.java** - Pattern matching
- Basic regex patterns
- String validation using regex
- Pattern and Matcher classes
- Common regex examples

## Key Concepts

### String Characteristics:
- **Immutable** - Cannot be changed after creation
- **Reference type** - Stored in heap memory
- **String pool** - JVM optimization for string literals
- **Unicode support** - Can store any character

### Performance Considerations:
- String concatenation creates new objects
- Use StringBuilder for multiple concatenations
- String pool reduces memory usage
- Avoid unnecessary string operations in loops

## Important String Methods

| Method | Description | Example |
|--------|-------------|---------|
| `length()` | Returns string length | `"Hello".length()` → 5 |
| `charAt(i)` | Character at index i | `"Hello".charAt(1)` → 'e' |
| `substring(start, end)` | Extract substring | `"Hello".substring(1,4)` → "ell" |
| `indexOf(str)` | Find first occurrence | `"Hello".indexOf("ll")` → 2 |
| `equals(str)` | Compare strings | `"Hello".equals("hello")` → false |
| `toUpperCase()` | Convert to uppercase | `"hello".toUpperCase()` → "HELLO" |

## Learning Progression

1. Master string basics and immutability concept
2. Practice essential string methods
3. Understand string comparison properly
4. Learn StringBuilder for performance
5. Solve common string problems
6. Explore regular expressions for pattern matching

## Common Mistakes to Avoid

- Using `==` instead of `equals()` for string comparison
- Concatenating strings in loops without StringBuilder
- Not handling null strings properly
- Forgetting that strings are immutable

---
*Strings are everywhere in programming - master them well!*
