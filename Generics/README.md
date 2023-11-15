# Generics in Java 🔧

Generics provide type safety and eliminate the need for casting by allowing you to specify the exact type of objects that a class or method can work with.

## Topics Covered

### 1. **GenericsBasics.java** - Introduction to generics
- Understanding type safety
- Generic classes and interfaces
- Type parameters and naming conventions
- Benefits of using generics

### 2. **GenericMethods.java** - Generic methods and wildcards
- Creating generic methods
- Bounded type parameters
- Wildcard types (?, extends, super)
- Method overloading with generics

### 3. **GenericCollections.java** - Generics with collections
- Type-safe collections
- Generic List, Set, Map usage
- Avoiding ClassCastException
- Performance benefits

### 4. **AdvancedGenerics.java** - Advanced generic concepts
- Multiple type parameters
- Generic inheritance
- Type erasure understanding
- Generic restrictions and limitations

## Key Concepts

### **Why Use Generics?**
- **Type Safety**: Compile-time type checking
- **Elimination of Casts**: No need for explicit casting
- **Code Reusability**: Write once, use with different types
- **Performance**: No boxing/unboxing overhead

### **Generic Syntax**
- `<T>`: Type parameter (can be any name)
- `<T extends Class>`: Bounded type parameter
- `<? extends T>`: Upper bounded wildcard
- `<? super T>`: Lower bounded wildcard
- `<?>`: Unbounded wildcard

### **Common Type Parameter Names**
- `T`: Type
- `E`: Element (used by collections)
- `K`: Key
- `V`: Value
- `N`: Number

## Learning Path

1. Start with `GenericsBasics.java` to understand fundamentals
2. Learn method generics in `GenericMethods.java`
3. Practice with collections in `GenericCollections.java`
4. Master advanced concepts in `AdvancedGenerics.java`

## Important Notes

- Generics are compile-time feature (type erasure at runtime)
- Cannot create instances of generic types
- Cannot use primitives as type arguments
- Generic arrays have limitations
- Understand covariance and contravariance with wildcards

---
*Write once, type-safe everywhere! 🛡️*
