# Lambda Expressions in Java 🔗

Lambda expressions, introduced in Java 8, provide a concise way to represent anonymous functions and enable functional programming in Java.

## Topics Covered

### 1. **LambdaBasics.java** - Introduction to lambda expressions
- Understanding lambda syntax
- Converting anonymous classes to lambdas
- Basic lambda expressions
- Benefits of using lambdas

### 2. **FunctionalInterfaces.java** - Working with functional interfaces
- Built-in functional interfaces (Predicate, Function, Consumer, Supplier)
- Creating custom functional interfaces
- Method references
- Lambda expressions with different interfaces

### 3. **LambdaWithCollections.java** - Lambdas with collections
- Using lambdas with streams
- Sorting with lambda expressions
- Filtering and mapping collections
- Reducing operations

### 4. **AdvancedLambdas.java** - Advanced lambda concepts
- Closure and variable capture
- Exception handling in lambdas
- Performance considerations
- Best practices and common pitfalls

## Key Concepts

### **Lambda Syntax**
```java
(parameters) -> expression
(parameters) -> { statements; }
```

### **Functional Interface**
- Interface with exactly one abstract method
- Can have default and static methods
- `@FunctionalInterface` annotation (optional but recommended)

### **Method References**
- `ClassName::staticMethod`
- `object::instanceMethod`
- `ClassName::instanceMethod`
- `ClassName::new` (constructor reference)

### **Benefits**
- More concise code
- Better readability
- Functional programming support
- Improved performance with streams

## Learning Path

1. Start with `LambdaBasics.java` to understand syntax
2. Learn functional interfaces in `FunctionalInterfaces.java`
3. Practice with collections in `LambdaWithCollections.java`
4. Master advanced concepts in `AdvancedLambdas.java`

## Important Notes

- Lambdas can only be used with functional interfaces
- Variables used in lambdas must be effectively final
- Lambdas enable functional programming paradigm in Java
- Method references can make code even more concise

---
*Express yourself functionally! 🎯*
