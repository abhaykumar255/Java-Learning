/**
 * LambdaBasics.java - Understanding Lambda Expressions Fundamentals
 * 
 * Learning Objectives:
 * - Understand what lambda expressions are and their syntax
 * - Learn to convert anonymous classes to lambda expressions
 * - Practice different lambda expression patterns
 * - Compare traditional vs lambda approaches
 * - Master the concept of functional interfaces
 */

import java.util.*;
import java.util.function.*;

// Custom functional interface for demonstration
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// Another functional interface
@FunctionalInterface
interface Greeting {
    void greet(String name);
}

// Functional interface with default method
@FunctionalInterface
interface MathOperation {
    double operate(double a, double b);
    
    // Default method doesn't count toward the "single abstract method" rule
    default void printResult(double result) {
        System.out.println("Result: " + result);
    }
}

public class LambdaBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Lambda Expressions Basics ===\n");
        
        // ========== WHAT ARE LAMBDA EXPRESSIONS? ==========
        
        System.out.println("=== Understanding Lambda Expressions ===");
        explainLambdas();
        
        // ========== LAMBDA SYNTAX ==========
        
        System.out.println("\n=== Lambda Syntax Variations ===");
        demonstrateLambdaSyntax();
        
        // ========== CONVERTING ANONYMOUS CLASSES ==========
        
        System.out.println("\n=== Converting Anonymous Classes to Lambdas ===");
        demonstrateAnonymousToLambda();
        
        // ========== FUNCTIONAL INTERFACES ==========
        
        System.out.println("\n=== Working with Functional Interfaces ===");
        demonstrateFunctionalInterfaces();
        
        // ========== METHOD REFERENCES ==========
        
        System.out.println("\n=== Method References ===");
        demonstrateMethodReferences();
    }
    
    /**
     * Explain what lambda expressions are
     */
    public static void explainLambdas() {
        System.out.println("Lambda expressions are:");
        System.out.println("- Anonymous functions (functions without a name)");
        System.out.println("- Concise way to represent single-method interfaces");
        System.out.println("- Enable functional programming in Java");
        System.out.println("- Reduce boilerplate code significantly");
        System.out.println();
        
        // Traditional approach with anonymous class
        Runnable traditionalRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Traditional anonymous class approach");
            }
        };
        
        // Lambda expression approach
        Runnable lambdaRunnable = () -> System.out.println("Lambda expression approach");
        
        System.out.println("Executing both approaches:");
        traditionalRunnable.run();
        lambdaRunnable.run();
        
        System.out.println("\nNotice how lambda is much more concise!");
    }
    
    /**
     * Demonstrate different lambda syntax variations
     */
    public static void demonstrateLambdaSyntax() {
        System.out.println("Lambda syntax variations:");
        System.out.println();
        
        // 1. No parameters
        Runnable noParams = () -> System.out.println("No parameters");
        System.out.println("1. No parameters: () -> expression");
        noParams.run();
        System.out.println();
        
        // 2. Single parameter (parentheses optional)
        Consumer<String> singleParam1 = (name) -> System.out.println("Hello, " + name);
        Consumer<String> singleParam2 = name -> System.out.println("Hi, " + name);
        System.out.println("2. Single parameter: (param) -> expression OR param -> expression");
        singleParam1.accept("Alice");
        singleParam2.accept("Bob");
        System.out.println();
        
        // 3. Multiple parameters
        BinaryOperator<Integer> multipleParams = (a, b) -> a + b;
        System.out.println("3. Multiple parameters: (param1, param2) -> expression");
        System.out.println("5 + 3 = " + multipleParams.apply(5, 3));
        System.out.println();
        
        // 4. Single expression
        Function<Integer, Integer> singleExpression = x -> x * x;
        System.out.println("4. Single expression: param -> expression");
        System.out.println("Square of 4: " + singleExpression.apply(4));
        System.out.println();
        
        // 5. Multiple statements (requires braces and return)
        Function<Integer, String> multipleStatements = x -> {
            int square = x * x;
            return "Square of " + x + " is " + square;
        };
        System.out.println("5. Multiple statements: param -> { statements; return value; }");
        System.out.println(multipleStatements.apply(5));
        System.out.println();
        
        // 6. Explicit type declaration (usually not needed)
        BinaryOperator<Integer> explicitTypes = (Integer a, Integer b) -> a * b;
        System.out.println("6. Explicit types: (Type param1, Type param2) -> expression");
        System.out.println("3 * 4 = " + explicitTypes.apply(3, 4));
    }
    
    /**
     * Demonstrate converting anonymous classes to lambda expressions
     */
    public static void demonstrateAnonymousToLambda() {
        System.out.println("Converting anonymous classes to lambdas:");
        System.out.println();
        
        // Example 1: Comparator
        System.out.println("Example 1: Comparator for sorting");
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Diana");
        System.out.println("Original list: " + names);
        
        // Traditional anonymous class
        List<String> sortedTraditional = new ArrayList<>(names);
        sortedTraditional.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println("Sorted (anonymous class): " + sortedTraditional);
        
        // Lambda expression
        List<String> sortedLambda = new ArrayList<>(names);
        sortedLambda.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted (lambda): " + sortedLambda);
        System.out.println();
        
        // Example 2: Custom functional interface
        System.out.println("Example 2: Custom Calculator interface");
        
        // Traditional anonymous class
        Calculator traditionalCalc = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        
        // Lambda expression
        Calculator lambdaCalc = (a, b) -> a + b;
        
        System.out.println("Traditional: 5 + 3 = " + traditionalCalc.calculate(5, 3));
        System.out.println("Lambda: 5 + 3 = " + lambdaCalc.calculate(5, 3));
        System.out.println();
        
        // Example 3: Event handling simulation
        System.out.println("Example 3: Event handling");
        
        // Traditional
        ActionListener traditionalListener = new ActionListener() {
            @Override
            public void actionPerformed(String action) {
                System.out.println("Traditional: Action performed - " + action);
            }
        };
        
        // Lambda
        ActionListener lambdaListener = action -> System.out.println("Lambda: Action performed - " + action);
        
        traditionalListener.actionPerformed("Button Click");
        lambdaListener.actionPerformed("Menu Select");
    }
    
    // Simple functional interface for event handling demo
    @FunctionalInterface
    interface ActionListener {
        void actionPerformed(String action);
    }
    
    /**
     * Demonstrate working with functional interfaces
     */
    public static void demonstrateFunctionalInterfaces() {
        System.out.println("Working with functional interfaces:");
        System.out.println();
        
        // Custom functional interfaces
        System.out.println("=== Custom Functional Interfaces ===");
        
        // Calculator interface
        Calculator addition = (a, b) -> a + b;
        Calculator multiplication = (a, b) -> a * b;
        Calculator subtraction = (a, b) -> a - b;
        
        System.out.println("Calculator operations:");
        System.out.println("10 + 5 = " + addition.calculate(10, 5));
        System.out.println("10 * 5 = " + multiplication.calculate(10, 5));
        System.out.println("10 - 5 = " + subtraction.calculate(10, 5));
        System.out.println();
        
        // Greeting interface
        Greeting simpleGreeting = name -> System.out.println("Hello, " + name + "!");
        Greeting formalGreeting = name -> System.out.println("Good day, Mr./Ms. " + name);
        
        System.out.println("Greeting variations:");
        simpleGreeting.greet("Alice");
        formalGreeting.greet("Smith");
        System.out.println();
        
        // MathOperation with default method
        MathOperation division = (a, b) -> a / b;
        double result = division.operate(15.0, 3.0);
        division.printResult(result); // Using default method
        System.out.println();
        
        // Built-in functional interfaces
        System.out.println("=== Built-in Functional Interfaces ===");
        
        // Predicate<T> - takes T, returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 7 even? " + isEven.test(7));
        
        // Function<T, R> - takes T, returns R
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Consumer<T> - takes T, returns void
        Consumer<String> printer = s -> System.out.println("Printing: " + s);
        printer.accept("Lambda message");
        
        // Supplier<T> - takes nothing, returns T
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Random number: " + randomSupplier.get());
    }
    
    /**
     * Demonstrate method references
     */
    public static void demonstrateMethodReferences() {
        System.out.println("Method references - even more concise than lambdas:");
        System.out.println();
        
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("Original list: " + words);
        
        // 1. Static method reference
        System.out.println("\n1. Static method reference:");
        System.out.println("Lambda: s -> Integer.parseInt(s)");
        System.out.println("Method ref: Integer::parseInt");
        
        List<String> numbers = Arrays.asList("1", "2", "3", "4");
        List<Integer> parsed = numbers.stream()
            .map(Integer::parseInt) // Method reference to static method
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Parsed numbers: " + parsed);
        
        // 2. Instance method reference
        System.out.println("\n2. Instance method reference:");
        System.out.println("Lambda: s -> s.toUpperCase()");
        System.out.println("Method ref: String::toUpperCase");
        
        List<String> upperCase = words.stream()
            .map(String::toUpperCase) // Method reference to instance method
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Uppercase: " + upperCase);
        
        // 3. Constructor reference
        System.out.println("\n3. Constructor reference:");
        System.out.println("Lambda: () -> new ArrayList<>()");
        System.out.println("Method ref: ArrayList::new");
        
        List<String> newList = words.stream()
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("New list: " + newList);
        
        // 4. Bound method reference
        System.out.println("\n4. Bound method reference:");
        String prefix = "Item: ";
        Function<String, String> addPrefix = prefix::concat; // Bound to specific instance
        System.out.println(addPrefix.apply("Apple"));
        
        System.out.println("\n=== Lambda Basics completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Lambda Expression Syntax:
 *    - (parameters) -> expression
 *    - (parameters) -> { statements; }
 *    - Single parameter: parentheses optional
 *    - No parameters: () required
 * 
 * 2. Functional Interfaces:
 *    - Interface with exactly one abstract method
 *    - Can have default and static methods
 *    - @FunctionalInterface annotation recommended
 * 
 * 3. Built-in Functional Interfaces:
 *    - Predicate<T>: T -> boolean
 *    - Function<T,R>: T -> R
 *    - Consumer<T>: T -> void
 *    - Supplier<T>: () -> T
 * 
 * 4. Method References:
 *    - Static: ClassName::methodName
 *    - Instance: ClassName::methodName
 *    - Bound: object::methodName
 *    - Constructor: ClassName::new
 * 
 * 5. Benefits:
 *    - Concise code
 *    - Better readability
 *    - Functional programming support
 *    - Improved performance with streams
 */
