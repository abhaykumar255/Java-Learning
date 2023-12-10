/**
 * HashMapDemo.java - Understanding HashMap in Java Collection Framework
 * 
 * Learning Objectives:
 * - Master HashMap creation, initialization, and operations
 * - Understand key-value pair storage and retrieval
 * - Learn HashMap iteration techniques and best practices
 * - Practice collision handling and performance optimization
 * - Compare HashMap with other Map implementations
 */

import java.util.*;

public class HashMapDemo {
    
    public static void main(String[] args) {
        
        System.out.println("=== HashMap Demo - Java Collection Framework ===\n");
        
        // ========== HASHMAP CREATION AND INITIALIZATION ==========
        
        System.out.println("=== HashMap Creation and Initialization ===");
        hashMapCreation();
        
        // ========== BASIC OPERATIONS ==========
        
        System.out.println("\n=== Basic HashMap Operations ===");
        basicOperations();
        
        // ========== ITERATION METHODS ==========
        
        System.out.println("\n=== HashMap Iteration Methods ===");
        iterationMethods();
        
        // ========== ADVANCED OPERATIONS ==========
        
        System.out.println("\n=== Advanced HashMap Operations ===");
        advancedOperations();
        
        // ========== PERFORMANCE AND COLLISION HANDLING ==========
        
        System.out.println("\n=== Performance and Collision Handling ===");
        performanceDemo();
        
        // ========== HASHMAP VARIATIONS ==========
        
        System.out.println("\n=== HashMap Variations ===");
        hashMapVariations();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        practicalExamples();
        
        System.out.println("\n=== HashMap Demo completed! ===");
    }
    
    /**
     * Demonstrates HashMap creation and initialization methods
     */
    public static void hashMapCreation() {
        
        // Method 1: Default constructor
        HashMap<String, Integer> map1 = new HashMap<>();
        System.out.println("Default HashMap created, initial capacity: 16, load factor: 0.75");
        
        // Method 2: With initial capacity
        HashMap<String, Integer> map2 = new HashMap<>(32);
        System.out.println("HashMap with initial capacity 32 created");
        
        // Method 3: With initial capacity and load factor
        HashMap<String, Integer> map3 = new HashMap<>(16, 0.8f);
        System.out.println("HashMap with capacity 16 and load factor 0.8 created");
        
        // Method 4: From another Map
        Map<String, Integer> sourceMap = new TreeMap<>();
        sourceMap.put("A", 1);
        sourceMap.put("B", 2);
        HashMap<String, Integer> map4 = new HashMap<>(sourceMap);
        System.out.println("HashMap from TreeMap: " + map4);
        
        // Method 5: Using Map interface (recommended)
        Map<String, Integer> map5 = new HashMap<>();
        System.out.println("HashMap using Map interface created");
        
        // Method 6: Initialization with values (Java 9+)
        Map<String, Integer> map6 = Map.of("One", 1, "Two", 2, "Three", 3);
        System.out.println("Immutable map with Map.of(): " + map6);
        
        // Method 7: Using double brace initialization (not recommended)
        Map<String, Integer> map7 = new HashMap<String, Integer>() {{
            put("X", 24);
            put("Y", 25);
            put("Z", 26);
        }};
        System.out.println("Double brace initialization: " + map7);
    }
    
    /**
     * Demonstrates basic HashMap operations
     */
    public static void basicOperations() {
        
        Map<String, String> countries = new HashMap<>();
        
        // Adding elements
        System.out.println("=== Adding Elements ===");
        countries.put("IN", "India");
        countries.put("US", "United States");
        countries.put("UK", "United Kingdom");
        countries.put("JP", "Japan");
        countries.put("DE", "Germany");
        
        System.out.println("Countries map: " + countries);
        System.out.println("Size: " + countries.size());
        
        // Accessing elements
        System.out.println("\n=== Accessing Elements ===");
        String country = countries.get("IN");
        System.out.println("Country with code 'IN': " + country);
        
        String defaultCountry = countries.getOrDefault("FR", "Unknown");
        System.out.println("Country with code 'FR' (with default): " + defaultCountry);
        
        // Checking existence
        System.out.println("\n=== Checking Existence ===");
        boolean hasUS = countries.containsKey("US");
        boolean hasIndia = countries.containsValue("India");
        System.out.println("Contains key 'US': " + hasUS);
        System.out.println("Contains value 'India': " + hasIndia);
        System.out.println("Is empty: " + countries.isEmpty());
        
        // Updating elements
        System.out.println("\n=== Updating Elements ===");
        String oldValue = countries.put("UK", "Great Britain");
        System.out.println("Updated UK, old value: " + oldValue);
        System.out.println("Updated map: " + countries);
        
        // putIfAbsent - only adds if key doesn't exist
        String result = countries.putIfAbsent("CA", "Canada");
        System.out.println("putIfAbsent CA: " + result + " (null means added)");
        
        result = countries.putIfAbsent("US", "America");
        System.out.println("putIfAbsent US: " + result + " (existing value returned)");
        
        // Removing elements
        System.out.println("\n=== Removing Elements ===");
        String removed = countries.remove("DE");
        System.out.println("Removed: " + removed);
        
        boolean removedConditional = countries.remove("JP", "Japan");
        System.out.println("Conditional remove JP-Japan: " + removedConditional);
        
        System.out.println("Final map: " + countries);
        System.out.println("Final size: " + countries.size());
    }
    
    /**
     * Demonstrates different HashMap iteration methods
     */
    public static void iterationMethods() {
        
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        scores.put("Diana", 88);
        scores.put("Eve", 91);
        
        System.out.println("Scores map: " + scores);
        
        // Method 1: Iterate over keys
        System.out.println("\n--- Method 1: Iterate over keys ---");
        for (String name : scores.keySet()) {
            System.out.println(name + ": " + scores.get(name));
        }
        
        // Method 2: Iterate over values
        System.out.println("\n--- Method 2: Iterate over values ---");
        for (Integer score : scores.values()) {
            System.out.println("Score: " + score);
        }
        
        // Method 3: Iterate over entries
        System.out.println("\n--- Method 3: Iterate over entries ---");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        // Method 4: Using Iterator
        System.out.println("\n--- Method 4: Using Iterator ---");
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        
        // Method 5: Java 8 forEach with lambda
        System.out.println("\n--- Method 5: Java 8 forEach ---");
        scores.forEach((name, score) -> {
            System.out.println(name + " scored " + score);
        });
        
        // Method 6: Java 8 Streams
        System.out.println("\n--- Method 6: Java 8 Streams ---");
        scores.entrySet().stream()
               .filter(entry -> entry.getValue() > 90)
               .forEach(entry -> System.out.println(entry.getKey() + " has high score: " + entry.getValue()));
    }
    
    /**
     * Demonstrates advanced HashMap operations
     */
    public static void advancedOperations() {
        
        Map<String, List<String>> studentCourses = new HashMap<>();
        
        // compute() - compute value for key
        System.out.println("=== compute() method ===");
        studentCourses.compute("Alice", (key, value) -> {
            if (value == null) {
                return new ArrayList<>(Arrays.asList("Math", "Physics"));
            } else {
                value.add("Chemistry");
                return value;
            }
        });
        System.out.println("After compute for Alice: " + studentCourses);
        
        // computeIfAbsent() - compute only if key is absent
        System.out.println("\n=== computeIfAbsent() method ===");
        studentCourses.computeIfAbsent("Bob", key -> new ArrayList<>(Arrays.asList("English", "History")));
        studentCourses.computeIfAbsent("Alice", key -> new ArrayList<>(Arrays.asList("Biology"))); // Won't execute
        System.out.println("After computeIfAbsent: " + studentCourses);
        
        // computeIfPresent() - compute only if key is present
        System.out.println("\n=== computeIfPresent() method ===");
        studentCourses.computeIfPresent("Bob", (key, value) -> {
            value.add("Geography");
            return value;
        });
        studentCourses.computeIfPresent("Charlie", (key, value) -> {
            value.add("Art"); // Won't execute as Charlie doesn't exist
            return value;
        });
        System.out.println("After computeIfPresent: " + studentCourses);
        
        // merge() - merge values
        System.out.println("\n=== merge() method ===");
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        
        for (String word : words) {
            wordCount.merge(word, 1, Integer::sum);
        }
        System.out.println("Word count using merge: " + wordCount);
        
        // replace() and replaceAll()
        System.out.println("\n=== replace() and replaceAll() methods ===");
        Map<String, String> colors = new HashMap<>();
        colors.put("R", "red");
        colors.put("G", "green");
        colors.put("B", "blue");
        
        System.out.println("Original colors: " + colors);
        
        colors.replace("R", "crimson");
        colors.replace("Y", "yellow"); // Won't add as Y doesn't exist
        System.out.println("After replace: " + colors);
        
        colors.replaceAll((key, value) -> value.toUpperCase());
        System.out.println("After replaceAll to uppercase: " + colors);
    }
    
    /**
     * Demonstrates HashMap performance characteristics and collision handling
     */
    public static void performanceDemo() {
        
        System.out.println("=== HashMap Performance Characteristics ===");
        
        // Demonstrate load factor impact
        System.out.println("\n--- Load Factor Impact ---");
        Map<Integer, String> lowLoadFactor = new HashMap<>(16, 0.5f);
        Map<Integer, String> highLoadFactor = new HashMap<>(16, 0.9f);
        
        // Add elements and measure performance
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            lowLoadFactor.put(i, "Value" + i);
        }
        long lowLoadTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            highLoadFactor.put(i, "Value" + i);
        }
        long highLoadTime = System.nanoTime() - startTime;
        
        System.out.println("Low load factor (0.5) time: " + lowLoadTime / 1000000.0 + " ms");
        System.out.println("High load factor (0.9) time: " + highLoadTime / 1000000.0 + " ms");
        
        // Demonstrate hash collision impact
        System.out.println("\n--- Hash Collision Demonstration ---");
        
        // Custom class with poor hash function
        class BadHashKey {
            private int value;
            
            public BadHashKey(int value) {
                this.value = value;
            }
            
            @Override
            public int hashCode() {
                return 1; // Terrible hash function - all objects have same hash
            }
            
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                BadHashKey that = (BadHashKey) obj;
                return value == that.value;
            }
            
            @Override
            public String toString() {
                return "BadHashKey{" + value + "}";
            }
        }
        
        Map<BadHashKey, String> badHashMap = new HashMap<>();
        Map<Integer, String> goodHashMap = new HashMap<>();
        
        // Measure performance with bad hash function
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            badHashMap.put(new BadHashKey(i), "Value" + i);
        }
        long badHashTime = System.nanoTime() - startTime;
        
        // Measure performance with good hash function
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            goodHashMap.put(i, "Value" + i);
        }
        long goodHashTime = System.nanoTime() - startTime;
        
        System.out.println("Bad hash function time: " + badHashTime / 1000000.0 + " ms");
        System.out.println("Good hash function time: " + goodHashTime / 1000000.0 + " ms");
        System.out.println("Performance ratio: " + (badHashTime / (double) goodHashTime) + "x slower");
    }
    
    /**
     * Demonstrates HashMap variations and alternatives
     */
    public static void hashMapVariations() {
        
        System.out.println("=== HashMap Variations ===");
        
        // LinkedHashMap - maintains insertion order
        System.out.println("\n--- LinkedHashMap (maintains insertion order) ---");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Third", 3);
        linkedHashMap.put("First", 1);
        linkedHashMap.put("Second", 2);
        System.out.println("LinkedHashMap: " + linkedHashMap);
        
        // TreeMap - sorted by keys
        System.out.println("\n--- TreeMap (sorted by keys) ---");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Third", 3);
        treeMap.put("First", 1);
        treeMap.put("Second", 2);
        System.out.println("TreeMap: " + treeMap);
        
        // ConcurrentHashMap - thread-safe
        System.out.println("\n--- ConcurrentHashMap (thread-safe) ---");
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        concurrentMap.put("C", 3);
        System.out.println("ConcurrentHashMap: " + concurrentMap);
        
        // Performance comparison
        System.out.println("\n--- Performance Comparison ---");
        int iterations = 100000;
        
        // HashMap
        Map<Integer, String> hashMap = new HashMap<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            hashMap.put(i, "Value" + i);
        }
        long hashMapTime = System.nanoTime() - startTime;
        
        // LinkedHashMap
        Map<Integer, String> linkedMap = new LinkedHashMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            linkedMap.put(i, "Value" + i);
        }
        long linkedMapTime = System.nanoTime() - startTime;
        
        // TreeMap
        Map<Integer, String> treeMapTest = new TreeMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            treeMapTest.put(i, "Value" + i);
        }
        long treeMapTime = System.nanoTime() - startTime;
        
        System.out.println("HashMap time: " + hashMapTime / 1000000.0 + " ms");
        System.out.println("LinkedHashMap time: " + linkedMapTime / 1000000.0 + " ms");
        System.out.println("TreeMap time: " + treeMapTime / 1000000.0 + " ms");
    }
    
    /**
     * Demonstrates practical HashMap usage examples
     */
    public static void practicalExamples() {
        
        // Example 1: Frequency counting
        System.out.println("=== Example 1: Character Frequency Counter ===");
        String text = "hello world";
        Map<Character, Integer> charFreq = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            if (c != ' ') { // Skip spaces
                charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            }
        }
        
        System.out.println("Character frequencies in '" + text + "':");
        charFreq.forEach((character, frequency) -> 
            System.out.println("'" + character + "': " + frequency));
        
        // Example 2: Caching/Memoization
        System.out.println("\n=== Example 2: Fibonacci with Memoization ===");
        Map<Integer, Long> fibCache = new HashMap<>();
        
        System.out.println("Fibonacci(10) = " + fibonacciMemo(10, fibCache));
        System.out.println("Fibonacci(20) = " + fibonacciMemo(20, fibCache));
        System.out.println("Cache size: " + fibCache.size());
        System.out.println("Cache contents: " + fibCache);
        
        // Example 3: Grouping data
        System.out.println("\n=== Example 3: Grouping Students by Grade ===");
        List<Student> students = Arrays.asList(
            new Student("Alice", 'A'),
            new Student("Bob", 'B'),
            new Student("Charlie", 'A'),
            new Student("Diana", 'C'),
            new Student("Eve", 'B')
        );
        
        Map<Character, List<Student>> studentsByGrade = new HashMap<>();
        for (Student student : students) {
            studentsByGrade.computeIfAbsent(student.getGrade(), k -> new ArrayList<>()).add(student);
        }
        
        studentsByGrade.forEach((grade, studentList) -> {
            System.out.println("Grade " + grade + ": " + studentList);
        });
        
        // Example 4: Configuration management
        System.out.println("\n=== Example 4: Configuration Management ===");
        Map<String, String> config = new HashMap<>();
        config.put("database.url", "jdbc:mysql://localhost:3306/mydb");
        config.put("database.username", "admin");
        config.put("database.password", "secret");
        config.put("app.name", "MyApplication");
        config.put("app.version", "1.0.0");
        
        System.out.println("Application Configuration:");
        config.entrySet().stream()
              .filter(entry -> entry.getKey().startsWith("app."))
              .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }
    
    /**
     * Helper method for Fibonacci with memoization
     */
    public static long fibonacciMemo(int n, Map<Integer, Long> cache) {
        if (n <= 1) return n;
        
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        long result = fibonacciMemo(n - 1, cache) + fibonacciMemo(n - 2, cache);
        cache.put(n, result);
        return result;
    }
    
    /**
     * Helper class for grouping example
     */
    static class Student {
        private String name;
        private char grade;
        
        public Student(String name, char grade) {
            this.name = name;
            this.grade = grade;
        }
        
        public String getName() { return name; }
        public char getGrade() { return grade; }
        
        @Override
        public String toString() {
            return name + "(" + grade + ")";
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. HashMap provides O(1) average time complexity for basic operations
 * 2. Uses hash table with separate chaining for collision resolution
 * 3. Load factor affects performance - default 0.75 is optimal for most cases
 * 4. Not thread-safe - use ConcurrentHashMap for concurrent access
 * 5. Allows one null key and multiple null values
 * 
 * HashMap vs Other Maps:
 * - HashMap: Fast, no ordering, not thread-safe
 * - LinkedHashMap: Maintains insertion order, slightly slower
 * - TreeMap: Sorted by keys, O(log n) operations
 * - ConcurrentHashMap: Thread-safe, good for concurrent access
 * 
 * Performance Factors:
 * - Hash function quality affects collision rate
 * - Load factor affects resize frequency
 * - Initial capacity should be set appropriately
 * - Avoid using mutable objects as keys
 * 
 * Best Practices:
 * - Use appropriate initial capacity and load factor
 * - Implement proper hashCode() and equals() for custom keys
 * - Use computeIfAbsent() for complex value initialization
 * - Prefer forEach() and streams for iteration
 * - Consider LinkedHashMap if insertion order matters
 * - Use ConcurrentHashMap for thread-safe operations
 * 
 * Common Use Cases:
 * - Caching and memoization
 * - Frequency counting
 * - Lookup tables and dictionaries
 * - Configuration management
 * - Grouping and categorization
 */
