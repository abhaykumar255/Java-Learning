/**
 * GenericsBasics.java - Understanding Generic Programming Fundamentals
 * 
 * Learning Objectives:
 * - Understand what generics are and why they're important
 * - Learn to create generic classes and interfaces
 * - Practice type safety and eliminate casting
 * - Compare code with and without generics
 * - Master basic generic syntax and conventions
 */

import java.util.*;

/**
 * Generic class example - A simple container that can hold any type
 * T is a type parameter that will be replaced with actual type when used
 */
class Container<T> {
    private T item;
    
    // Constructor
    public Container(T item) {
        this.item = item;
    }
    
    // Getter method
    public T getItem() {
        return item;
    }
    
    // Setter method
    public void setItem(T item) {
        this.item = item;
    }
    
    // Method that works with the generic type
    public void displayInfo() {
        if (item != null) {
            System.out.println("Container holds: " + item + " (Type: " + item.getClass().getSimpleName() + ")");
        } else {
            System.out.println("Container is empty");
        }
    }
}

/**
 * Generic class with multiple type parameters
 */
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() { return key; }
    public V getValue() { return value; }
    
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    
    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }
}

/**
 * Generic interface example
 */
interface Comparable<T> {
    int compareTo(T other);
}

/**
 * Class implementing generic interface
 */
class Student implements Comparable<Student> {
    private String name;
    private int grade;
    
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade);
    }
    
    @Override
    public String toString() {
        return name + " (Grade: " + grade + ")";
    }
    
    public String getName() { return name; }
    public int getGrade() { return grade; }
}

public class GenericsBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Generics Basics - Type Safety and Reusability ===\n");
        
        // ========== PROBLEM WITHOUT GENERICS ==========
        
        System.out.println("=== Problem Without Generics ===");
        demonstrateProblemsWithoutGenerics();
        
        // ========== SOLUTION WITH GENERICS ==========
        
        System.out.println("\n=== Solution With Generics ===");
        demonstrateGenericSolution();
        
        // ========== GENERIC CLASSES ==========
        
        System.out.println("\n=== Generic Classes ===");
        demonstrateGenericClasses();
        
        // ========== MULTIPLE TYPE PARAMETERS ==========
        
        System.out.println("\n=== Multiple Type Parameters ===");
        demonstrateMultipleTypeParameters();
        
        // ========== GENERIC INTERFACES ==========
        
        System.out.println("\n=== Generic Interfaces ===");
        demonstrateGenericInterfaces();
        
        // ========== TYPE SAFETY BENEFITS ==========
        
        System.out.println("\n=== Type Safety Benefits ===");
        demonstrateTypeSafety();
    }
    
    /**
     * Demonstrate problems that occur without generics
     */
    public static void demonstrateProblemsWithoutGenerics() {
        System.out.println("Before Java 5 (without generics):");
        
        // Using raw ArrayList - no type safety
        ArrayList rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(42);
        rawList.add(3.14);
        
        System.out.println("Raw list contents: " + rawList);
        
        // Problem 1: Need to cast when retrieving
        String str = (String) rawList.get(0); // Explicit casting required
        System.out.println("First element (cast to String): " + str);
        
        // Problem 2: Runtime ClassCastException risk
        try {
            String wrongCast = (String) rawList.get(1); // This will fail!
        } catch (ClassCastException e) {
            System.out.println("❌ ClassCastException: " + e.getMessage());
        }
        
        // Problem 3: No compile-time type checking
        System.out.println("Problems: Casting required, runtime errors possible, no type safety");
    }
    
    /**
     * Demonstrate how generics solve these problems
     */
    public static void demonstrateGenericSolution() {
        System.out.println("With Java 5+ generics:");
        
        // Type-safe ArrayList
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        // stringList.add(42); // ❌ Compile-time error - won't compile!
        
        System.out.println("Generic list contents: " + stringList);
        
        // No casting needed
        String str = stringList.get(0); // No casting required!
        System.out.println("First element (no casting): " + str);
        
        // Type safety at compile time
        System.out.println("✅ Benefits: No casting, compile-time type safety, cleaner code");
    }
    
    /**
     * Demonstrate generic classes
     */
    public static void demonstrateGenericClasses() {
        System.out.println("Creating generic containers:");
        
        // Container for String
        Container<String> stringContainer = new Container<>("Hello Generics!");
        stringContainer.displayInfo();
        
        // Container for Integer
        Container<Integer> intContainer = new Container<>(42);
        intContainer.displayInfo();
        
        // Container for custom object
        Container<Student> studentContainer = new Container<>(new Student("Alice", 95));
        studentContainer.displayInfo();
        
        // Type safety in action
        String value = stringContainer.getItem(); // No casting needed
        System.out.println("Retrieved value: " + value);
        
        // The same class works with different types!
        System.out.println("✅ Same Container class works with String, Integer, and Student!");
    }
    
    /**
     * Demonstrate multiple type parameters
     */
    public static void demonstrateMultipleTypeParameters() {
        System.out.println("Using classes with multiple type parameters:");
        
        // Pair with String key and Integer value
        Pair<String, Integer> nameAge = new Pair<>("John", 25);
        System.out.println("Name-Age pair: " + nameAge);
        
        // Pair with Integer key and String value
        Pair<Integer, String> idName = new Pair<>(101, "Alice");
        System.out.println("ID-Name pair: " + idName);
        
        // Pair with custom objects
        Pair<Student, String> studentGrade = new Pair<>(
            new Student("Bob", 88), 
            "B+"
        );
        System.out.println("Student-Grade pair: " + studentGrade);
        
        // Type safety with multiple parameters
        String name = nameAge.getKey();    // String
        Integer age = nameAge.getValue();  // Integer
        System.out.println("Extracted: " + name + " is " + age + " years old");
    }
    
    /**
     * Demonstrate generic interfaces
     */
    public static void demonstrateGenericInterfaces() {
        System.out.println("Using generic interfaces:");
        
        // Create students
        Student student1 = new Student("Alice", 95);
        Student student2 = new Student("Bob", 87);
        Student student3 = new Student("Charlie", 92);
        
        // Using generic interface method
        int comparison = student1.compareTo(student2);
        System.out.println("Comparing " + student1 + " with " + student2 + ": " + comparison);
        
        // Sorting using generic interface
        List<Student> students = Arrays.asList(student1, student2, student3);
        System.out.println("Before sorting: " + students);
        
        Collections.sort(students); // Uses Comparable<Student> interface
        System.out.println("After sorting by grade: " + students);
    }
    
    /**
     * Demonstrate type safety benefits
     */
    public static void demonstrateTypeSafety() {
        System.out.println("Type safety in action:");
        
        // Generic method ensures type consistency
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("String list: " + strings);
        System.out.println("Integer list: " + numbers);
        
        // Each list maintains its type
        for (String fruit : strings) {
            System.out.println("Fruit: " + fruit.toUpperCase()); // String methods available
        }
        
        for (Integer num : numbers) {
            System.out.println("Number squared: " + (num * num)); // Integer operations available
        }
        
        // Compile-time error prevention
        System.out.println("\n✅ Generics prevent:");
        System.out.println("   - ClassCastException at runtime");
        System.out.println("   - Need for explicit casting");
        System.out.println("   - Mixing incompatible types");
        System.out.println("   - Type-related bugs");
        
        System.out.println("\n=== Generics Basics completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Generics provide compile-time type safety:
 *    - Catch type errors at compile time, not runtime
 *    - Eliminate ClassCastException risks
 *    - Make code more readable and maintainable
 * 
 * 2. Generic syntax:
 *    - <T> for single type parameter
 *    - <K, V> for multiple type parameters
 *    - Type parameters are placeholders for actual types
 * 
 * 3. Benefits of generics:
 *    - Type safety: Compile-time checking
 *    - Elimination of casts: No explicit casting needed
 *    - Code reusability: Same code works with different types
 *    - Performance: No boxing/unboxing overhead
 * 
 * 4. Generic classes and interfaces:
 *    - Can have one or more type parameters
 *    - Type parameters can be used throughout the class/interface
 *    - Implementing classes specify concrete types
 * 
 * 5. Naming conventions:
 *    - T: Type
 *    - E: Element
 *    - K: Key
 *    - V: Value
 *    - N: Number
 */
