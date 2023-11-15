/**
 * StreamsBasics.java - Understanding Java Streams API Fundamentals
 * 
 * Learning Objectives:
 * - Understand what streams are and how they differ from collections
 * - Learn to create streams from various data sources
 * - Practice basic stream operations and method chaining
 * - Compare imperative vs functional programming approaches
 * - Master the stream pipeline concept
 */

import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class StreamsBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Java Streams API Basics ===\n");
        
        // ========== WHAT ARE STREAMS? ==========
        
        System.out.println("=== Understanding Streams ===");
        explainStreams();
        
        // ========== CREATING STREAMS ==========
        
        System.out.println("\n=== Creating Streams ===");
        demonstrateStreamCreation();
        
        // ========== BASIC OPERATIONS ==========
        
        System.out.println("\n=== Basic Stream Operations ===");
        demonstrateBasicOperations();
        
        // ========== IMPERATIVE VS FUNCTIONAL ==========
        
        System.out.println("\n=== Imperative vs Functional Approach ===");
        compareApproaches();
        
        // ========== STREAM PIPELINE ==========
        
        System.out.println("\n=== Stream Pipeline Concept ===");
        demonstrateStreamPipeline();
    }
    
    /**
     * Explain what streams are and their characteristics
     */
    public static void explainStreams() {
        System.out.println("What are Streams?");
        System.out.println("- Streams are NOT data structures (like collections)");
        System.out.println("- Streams are a VIEW of data that allows functional-style operations");
        System.out.println("- Streams support lazy evaluation (operations are deferred)");
        System.out.println("- Streams can only be consumed once");
        System.out.println("- Streams can be infinite");
        System.out.println();
        
        // Demonstrate stream characteristics
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");
        
        System.out.println("Original list: " + names);
        
        // Create a stream and perform operations
        Stream<String> nameStream = names.stream()
            .filter(name -> name.length() > 3)
            .map(String::toUpperCase);
        
        System.out.println("Stream created (no operations executed yet - lazy evaluation)");
        
        // Terminal operation triggers execution
        List<String> result = nameStream.collect(Collectors.toList());
        System.out.println("After terminal operation: " + result);
        System.out.println("Original list unchanged: " + names);
    }
    
    /**
     * Demonstrate different ways to create streams
     */
    public static void demonstrateStreamCreation() {
        System.out.println("Different ways to create streams:");
        
        // 1. From collections
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> fromList = numbers.stream();
        System.out.println("From List: " + fromList.collect(Collectors.toList()));
        
        // 2. From arrays
        String[] words = {"apple", "banana", "cherry"};
        Stream<String> fromArray = Arrays.stream(words);
        System.out.println("From Array: " + fromArray.collect(Collectors.toList()));
        
        // 3. Using Stream.of()
        Stream<String> fromOf = Stream.of("red", "green", "blue");
        System.out.println("Using Stream.of(): " + fromOf.collect(Collectors.toList()));
        
        // 4. Empty stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty stream count: " + emptyStream.count());
        
        // 5. Infinite streams
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        List<Integer> first10Even = infiniteStream.limit(10).collect(Collectors.toList());
        System.out.println("First 10 even numbers: " + first10Even);
        
        // 6. Random numbers
        Stream<Double> randomStream = Stream.generate(Math::random);
        List<Double> randomNumbers = randomStream.limit(5).collect(Collectors.toList());
        System.out.println("5 random numbers: " + randomNumbers);
        
        // 7. Range of numbers
        IntStream rangeStream = IntStream.range(1, 6);
        System.out.println("Range 1-5: " + rangeStream.boxed().collect(Collectors.toList()));
        
        // 8. From string characters
        String text = "Hello";
        IntStream charStream = text.chars();
        List<Character> chars = charStream.mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println("Characters from string: " + chars);
    }
    
    /**
     * Demonstrate basic stream operations
     */
    public static void demonstrateBasicOperations() {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");
        
        System.out.println("Original fruits: " + fruits);
        System.out.println();
        
        // FILTER - select elements based on condition
        System.out.println("=== Filter Operation ===");
        List<String> longFruits = fruits.stream()
            .filter(fruit -> fruit.length() > 5)
            .collect(Collectors.toList());
        System.out.println("Fruits with length > 5: " + longFruits);
        
        // MAP - transform each element
        System.out.println("\n=== Map Operation ===");
        List<String> upperCaseFruits = fruits.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase fruits: " + upperCaseFruits);
        
        List<Integer> fruitLengths = fruits.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println("Fruit lengths: " + fruitLengths);
        
        // SORTED - sort elements
        System.out.println("\n=== Sorted Operation ===");
        List<String> sortedFruits = fruits.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Sorted fruits: " + sortedFruits);
        
        List<String> sortedByLength = fruits.stream()
            .sorted(Comparator.comparing(String::length))
            .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);
        
        // DISTINCT - remove duplicates
        System.out.println("\n=== Distinct Operation ===");
        List<String> fruitsWithDuplicates = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        List<String> uniqueFruits = fruitsWithDuplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Original with duplicates: " + fruitsWithDuplicates);
        System.out.println("After distinct: " + uniqueFruits);
        
        // LIMIT and SKIP
        System.out.println("\n=== Limit and Skip Operations ===");
        List<String> first3Fruits = fruits.stream()
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("First 3 fruits: " + first3Fruits);
        
        List<String> skip2Fruits = fruits.stream()
            .skip(2)
            .collect(Collectors.toList());
        System.out.println("Skip first 2 fruits: " + skip2Fruits);
    }
    
    /**
     * Compare imperative vs functional programming approaches
     */
    public static void compareApproaches() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Task: Find sum of squares of even numbers");
        System.out.println("Numbers: " + numbers);
        System.out.println();
        
        // IMPERATIVE APPROACH (traditional)
        System.out.println("=== Imperative Approach ===");
        int sumImperative = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {           // filter even numbers
                int square = number * number; // square them
                sumImperative += square;      // sum them up
            }
        }
        System.out.println("Imperative result: " + sumImperative);
        
        // FUNCTIONAL APPROACH (using streams)
        System.out.println("\n=== Functional Approach ===");
        int sumFunctional = numbers.stream()
            .filter(n -> n % 2 == 0)    // filter even numbers
            .map(n -> n * n)            // square them
            .reduce(0, Integer::sum);   // sum them up
        System.out.println("Functional result: " + sumFunctional);
        
        System.out.println("\nBenefits of functional approach:");
        System.out.println("- More readable and expressive");
        System.out.println("- Less boilerplate code");
        System.out.println("- Easier to understand the intent");
        System.out.println("- Can be easily parallelized");
        System.out.println("- Immutable operations (no side effects)");
    }
    
    /**
     * Demonstrate stream pipeline concept
     */
    public static void demonstrateStreamPipeline() {
        System.out.println("Understanding Stream Pipeline:");
        System.out.println("Source → Intermediate Operations → Terminal Operation");
        System.out.println();
        
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "are", "awesome");
        
        System.out.println("Example pipeline:");
        System.out.println("words.stream()");
        System.out.println("  .filter(word -> word.length() > 4)    // Intermediate");
        System.out.println("  .map(String::toUpperCase)             // Intermediate");
        System.out.println("  .sorted()                             // Intermediate");
        System.out.println("  .collect(Collectors.toList());        // Terminal");
        System.out.println();
        
        List<String> result = words.stream()
            .filter(word -> word.length() > 4)    // Intermediate operation
            .map(String::toUpperCase)             // Intermediate operation
            .sorted()                             // Intermediate operation
            .collect(Collectors.toList());        // Terminal operation
        
        System.out.println("Original words: " + words);
        System.out.println("Pipeline result: " + result);
        System.out.println();
        
        // Demonstrate lazy evaluation
        System.out.println("=== Lazy Evaluation Demonstration ===");
        System.out.println("Creating stream with intermediate operations...");
        
        Stream<String> lazyStream = words.stream()
            .filter(word -> {
                System.out.println("Filtering: " + word);
                return word.length() > 4;
            })
            .map(word -> {
                System.out.println("Mapping: " + word);
                return word.toUpperCase();
            });
        
        System.out.println("Stream created, but no output yet (lazy evaluation)");
        System.out.println("Now calling terminal operation...");
        
        List<String> lazyResult = lazyStream.collect(Collectors.toList());
        System.out.println("Final result: " + lazyResult);
        
        System.out.println("\n=== Streams Basics completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Stream Characteristics:
 *    - Not a data structure, but a view of data
 *    - Lazy evaluation: operations deferred until terminal operation
 *    - One-time use: stream is consumed after terminal operation
 *    - Immutable: original data source is not modified
 * 
 * 2. Stream Creation:
 *    - From collections: list.stream()
 *    - From arrays: Arrays.stream(array)
 *    - Static methods: Stream.of(), Stream.empty()
 *    - Infinite streams: Stream.iterate(), Stream.generate()
 *    - Primitive streams: IntStream, LongStream, DoubleStream
 * 
 * 3. Operation Types:
 *    - Intermediate: return a stream (filter, map, sorted)
 *    - Terminal: produce a result (collect, reduce, forEach)
 *    - Short-circuiting: can terminate early (findFirst, anyMatch)
 * 
 * 4. Benefits:
 *    - More expressive and readable code
 *    - Functional programming paradigm
 *    - Easy parallelization
 *    - Reduced boilerplate code
 * 
 * 5. Stream Pipeline:
 *    - Source → Intermediate Operations → Terminal Operation
 *    - Lazy evaluation improves performance
 *    - Method chaining creates fluent API
 */
