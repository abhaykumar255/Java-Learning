# Exception Handling in Java ⚠️

Exception handling is a powerful mechanism in Java that allows programs to handle runtime errors gracefully and continue execution.

## What are Exceptions?

Exceptions are runtime errors that disrupt the normal flow of program execution. Instead of crashing, Java allows us to "catch" and handle these errors.

## Exception Hierarchy

```
Throwable
├── Error (System-level errors, usually unrecoverable)
└── Exception
    ├── RuntimeException (Unchecked exceptions)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── IllegalArgumentException
    │   └── NumberFormatException
    └── Checked Exceptions
        ├── IOException
        ├── SQLException
        └── ClassNotFoundException
```

## Topics Covered

### 1. **ExceptionBasics.java** - Exception fundamentals
- What are exceptions and why they occur
- Common types of exceptions
- Exception hierarchy understanding
- Program flow with and without exception handling

### 2. **TryCatchFinally.java** - Exception handling blocks
- try-catch-finally syntax
- Multiple catch blocks
- Exception propagation
- Resource management with finally

### 3. **ThrowAndThrows.java** - Exception throwing
- throw keyword for manual exception throwing
- throws keyword for method declarations
- Checked vs unchecked exceptions
- Exception propagation chain

### 4. **CustomExceptions.java** - Creating custom exceptions
- Extending Exception class
- Creating meaningful custom exceptions
- Best practices for custom exceptions
- Real-world custom exception examples

### 5. **TryWithResources.java** - Automatic resource management
- try-with-resources syntax
- AutoCloseable interface
- Automatic resource cleanup
- Suppressed exceptions

### 6. **ExceptionBestPractices.java** - Best practices
- When to catch vs propagate exceptions
- Logging and error reporting
- Exception handling patterns
- Performance considerations

## Key Concepts

### Exception Types:

1. **Checked Exceptions**
   - Must be handled or declared
   - Compile-time checking
   - Examples: IOException, SQLException

2. **Unchecked Exceptions**
   - Runtime exceptions
   - No compile-time checking required
   - Examples: NullPointerException, ArrayIndexOutOfBoundsException

3. **Errors**
   - System-level problems
   - Usually unrecoverable
   - Examples: OutOfMemoryError, StackOverflowError

### Exception Handling Keywords:

- **try**: Block that might throw an exception
- **catch**: Block that handles specific exceptions
- **finally**: Block that always executes
- **throw**: Manually throw an exception
- **throws**: Declare exceptions a method might throw

## Exception Handling Flow

```
try {
    // Code that might throw exception
} catch (SpecificException e) {
    // Handle specific exception
} catch (Exception e) {
    // Handle any other exception
} finally {
    // Always executes (cleanup code)
}
```

## Best Practices

1. **Be Specific**: Catch specific exceptions rather than generic Exception
2. **Don't Ignore**: Never catch exceptions without handling them
3. **Log Properly**: Always log exception details for debugging
4. **Clean Up**: Use finally or try-with-resources for cleanup
5. **Fail Fast**: Validate inputs early to prevent exceptions
6. **Meaningful Messages**: Provide clear error messages

## Common Exceptions and Causes

| Exception | Common Cause | Prevention |
|-----------|--------------|------------|
| `NullPointerException` | Using null reference | Null checks |
| `ArrayIndexOutOfBoundsException` | Invalid array index | Bounds checking |
| `NumberFormatException` | Invalid string to number conversion | Input validation |
| `FileNotFoundException` | File doesn't exist | File existence check |
| `IllegalArgumentException` | Invalid method argument | Parameter validation |

## Learning Progression

1. Understand what exceptions are and why they occur
2. Master try-catch-finally blocks
3. Learn to throw and declare exceptions
4. Create custom exceptions for specific needs
5. Use try-with-resources for resource management
6. Apply best practices for robust error handling

---
*Good exception handling makes your programs robust and user-friendly!*
