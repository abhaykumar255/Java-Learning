/**
 * StreamOperations.java - Intermediate and Terminal Stream Operations
 * 
 * Learning Objectives:
 * - Master all intermediate stream operations (filter, map, sorted, etc.)
 * - Learn terminal operations (collect, reduce, forEach, etc.)
 * - Understand lazy evaluation and stream pipeline optimization
 * - Practice method chaining and fluent API usage
 * - Apply streams to solve real-world data processing problems
 */

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamOperations {
    
    public static void main(String[] args) {
        
        System.out.println("=== Stream Operations - Intermediate and Terminal ===\n");
        
        // ========== INTERMEDIATE OPERATIONS ==========
        
        System.out.println("=== Intermediate Operations ===");
        demonstrateIntermediateOperations();
        
        // ========== TERMINAL OPERATIONS ==========
        
        System.out.println("\n=== Terminal Operations ===");
        demonstrateTerminalOperations();
        
        // ========== COMPLEX STREAM PIPELINES ==========
        
        System.out.println("\n=== Complex Stream Pipelines ===");
        demonstrateComplexPipelines();
        
        // ========== PERFORMANCE CONSIDERATIONS ==========
        
        System.out.println("\n=== Performance Considerations ===");
        demonstratePerformanceConsiderations();
    }
    
    /**
     * Demonstrate intermediate operations
     */
    public static void demonstrateIntermediateOperations() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original words: " + words);
        System.out.println("Original numbers: " + numbers);
        System.out.println();
        
        // FILTER - select elements based on predicate
        System.out.println("=== Filter Operation ===");
        List<String> longWords = words.stream()
            .filter(word -> word.length() > 5)
            .collect(Collectors.toList());
        System.out.println("Words longer than 5 chars: " + longWords);
        
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println();
        
        // MAP - transform elements
        System.out.println("=== Map Operation ===");
        List<String> upperCaseWords = words.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase words: " + upperCaseWords);
        
        List<Integer> squares = numbers.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
        System.out.println();
        
        // FLATMAP - flatten nested structures
        System.out.println("=== FlatMap Operation ===");
        List<List<String>> nestedWords = Arrays.asList(
            Arrays.asList("hello", "world"),
            Arrays.asList("java", "streams"),
            Arrays.asList("flat", "map")
        );
        
        List<String> flattenedWords = nestedWords.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("Nested: " + nestedWords);
        System.out.println("Flattened: " + flattenedWords);
        
        // FlatMap with strings to characters
        List<String> charLists = words.stream()
            .flatMap(word -> word.chars().mapToObj(c -> String.valueOf((char) c)))
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("All unique characters: " + charLists);
        System.out.println();
        
        // DISTINCT - remove duplicates
        System.out.println("=== Distinct Operation ===");
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbersWithDuplicates.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println("With duplicates: " + numbersWithDuplicates);
        System.out.println("Unique numbers: " + uniqueNumbers);
        System.out.println();
        
        // SORTED - sort elements
        System.out.println("=== Sorted Operation ===");
        List<String> sortedWords = words.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Alphabetically sorted: " + sortedWords);
        
        List<String> sortedByLength = words.stream()
            .sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
            .collect(Collectors.toList());
        System.out.println("Sorted by length then alphabetically: " + sortedByLength);
        System.out.println();
        
        // LIMIT and SKIP
        System.out.println("=== Limit and Skip Operations ===");
        List<Integer> first5 = numbers.stream()
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("First 5 numbers: " + first5);
        
        List<Integer> skip5Take3 = numbers.stream()
            .skip(5)
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Skip 5, take 3: " + skip5Take3);
        System.out.println();
        
        // PEEK - debug/side effects
        System.out.println("=== Peek Operation (for debugging) ===");
        List<Integer> processedNumbers = numbers.stream()
            .filter(n -> n > 5)
            .peek(n -> System.out.println("After filter: " + n))
            .map(n -> n * 2)
            .peek(n -> System.out.println("After map: " + n))
            .collect(Collectors.toList());
        System.out.println("Final result: " + processedNumbers);
    }
    
    /**
     * Demonstrate terminal operations
     */
    public static void demonstrateTerminalOperations() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        System.out.println("Working with numbers: " + numbers);
        System.out.println("Working with words: " + words);
        System.out.println();
        
        // COLLECT - most versatile terminal operation
        System.out.println("=== Collect Operations ===");
        
        // Collect to different collections
        List<Integer> evenList = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Even numbers (List): " + evenList);
        
        Set<Integer> evenSet = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toSet());
        System.out.println("Even numbers (Set): " + evenSet);
        
        // Collect to Map
        Map<String, Integer> wordLengths = words.stream()
            .collect(Collectors.toMap(
                word -> word,           // key mapper
                String::length          // value mapper
            ));
        System.out.println("Word lengths map: " + wordLengths);
        
        // Grouping
        Map<Integer, List<String>> wordsByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Words grouped by length: " + wordsByLength);
        
        // Partitioning
        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
            .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even/Odd partition: " + evenOddPartition);
        System.out.println();
        
        // REDUCE - combine elements
        System.out.println("=== Reduce Operations ===");
        
        // Sum using reduce
        Optional<Integer> sum = numbers.stream()
            .reduce(Integer::sum);
        System.out.println("Sum using reduce: " + sum.orElse(0));
        
        // Sum with identity
        Integer sumWithIdentity = numbers.stream()
            .reduce(0, Integer::sum);
        System.out.println("Sum with identity: " + sumWithIdentity);
        
        // Product
        Integer product = numbers.stream()
            .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
        
        // Concatenate strings
        String concatenated = words.stream()
            .reduce("", (a, b) -> a + b);
        System.out.println("Concatenated words: " + concatenated);
        
        String joinedWithComma = words.stream()
            .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);
        System.out.println("Joined with comma: " + joinedWithComma);
        System.out.println();
        
        // FOREACH - side effects
        System.out.println("=== ForEach Operation ===");
        System.out.print("Printing squares: ");
        numbers.stream()
            .map(n -> n * n)
            .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println();
        
        // MATCHING operations
        System.out.println("=== Matching Operations ===");
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        
        System.out.println("Any even number: " + anyEven);
        System.out.println("All positive: " + allPositive);
        System.out.println("None negative: " + noneNegative);
        System.out.println();
        
        // FINDING operations
        System.out.println("=== Finding Operations ===");
        Optional<Integer> firstEven = numbers.stream()
            .filter(n -> n % 2 == 0)
            .findFirst();
        System.out.println("First even number: " + firstEven.orElse(-1));
        
        Optional<String> anyLongWord = words.stream()
            .filter(word -> word.length() > 5)
            .findAny();
        System.out.println("Any long word: " + anyLongWord.orElse("none"));
        System.out.println();
        
        // COUNT operation
        System.out.println("=== Count Operation ===");
        long evenCount = numbers.stream()
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("Count of even numbers: " + evenCount);
        
        long longWordCount = words.stream()
            .filter(word -> word.length() > 4)
            .count();
        System.out.println("Count of long words: " + longWordCount);
    }
    
    /**
     * Demonstrate complex stream pipelines
     */
    public static void demonstrateComplexPipelines() {
        // Sample data: list of employees
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 75000, 28),
            new Employee("Bob", "Marketing", 65000, 32),
            new Employee("Charlie", "Engineering", 85000, 35),
            new Employee("Diana", "HR", 60000, 29),
            new Employee("Eve", "Engineering", 90000, 31),
            new Employee("Frank", "Marketing", 70000, 27)
        );
        
        System.out.println("Employee data processing examples:");
        System.out.println("Employees: " + employees.size() + " total");
        System.out.println();
        
        // Complex pipeline 1: High-paid engineers
        System.out.println("=== High-paid Engineers ===");
        List<String> highPaidEngineers = employees.stream()
            .filter(emp -> "Engineering".equals(emp.getDepartment()))
            .filter(emp -> emp.getSalary() > 80000)
            .map(Employee::getName)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("High-paid engineers: " + highPaidEngineers);
        System.out.println();
        
        // Complex pipeline 2: Department statistics
        System.out.println("=== Department Statistics ===");
        Map<String, DoubleSummaryStatistics> deptStats = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.summarizingDouble(Employee::getSalary)
            ));
        
        deptStats.forEach((dept, stats) -> {
            System.out.printf("%s: Avg=%.0f, Min=%.0f, Max=%.0f, Count=%d\n",
                dept, stats.getAverage(), stats.getMin(), stats.getMax(), stats.getCount());
        });
        System.out.println();
        
        // Complex pipeline 3: Top earners by department
        System.out.println("=== Top Earner by Department ===");
        Map<String, Optional<Employee>> topEarners = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
            ));
        
        topEarners.forEach((dept, emp) -> {
            if (emp.isPresent()) {
                System.out.printf("%s: %s ($%.0f)\n", 
                    dept, emp.get().getName(), emp.get().getSalary());
            }
        });
        System.out.println();
        
        // Complex pipeline 4: Young high earners
        System.out.println("=== Young High Earners (Age < 30, Salary > 70k) ===");
        String youngHighEarners = employees.stream()
            .filter(emp -> emp.getAge() < 30)
            .filter(emp -> emp.getSalary() > 70000)
            .map(emp -> emp.getName() + " (" + emp.getAge() + ")")
            .collect(Collectors.joining(", "));
        System.out.println("Young high earners: " + youngHighEarners);
    }
    
    /**
     * Demonstrate performance considerations
     */
    public static void demonstratePerformanceConsiderations() {
        System.out.println("Stream performance considerations:");
        System.out.println();
        
        // Short-circuiting operations
        System.out.println("=== Short-circuiting Operations ===");
        List<Integer> largeList = IntStream.range(1, 1000000)
            .boxed()
            .collect(Collectors.toList());
        
        long startTime = System.nanoTime();
        boolean found = largeList.stream()
            .anyMatch(n -> n > 500000);
        long endTime = System.nanoTime();
        
        System.out.println("Found number > 500000: " + found);
        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000 + " ms");
        System.out.println("Short-circuiting stopped early, didn't process entire list");
        System.out.println();
        
        // Lazy evaluation demonstration
        System.out.println("=== Lazy Evaluation ===");
        System.out.println("Creating stream with intermediate operations...");
        
        Stream<Integer> lazyStream = Arrays.asList(1, 2, 3, 4, 5).stream()
            .filter(n -> {
                System.out.println("Filtering: " + n);
                return n > 2;
            })
            .map(n -> {
                System.out.println("Mapping: " + n);
                return n * 2;
            });
        
        System.out.println("Stream created, but no processing yet!");
        System.out.println("Now calling terminal operation...");
        
        List<Integer> result = lazyStream.collect(Collectors.toList());
        System.out.println("Result: " + result);
        System.out.println();
        
        // Order of operations matters
        System.out.println("=== Order of Operations Matters ===");
        List<String> testWords = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        
        // Inefficient: map then filter
        long count1 = testWords.stream()
            .map(String::toUpperCase)  // Applied to all elements
            .filter(word -> word.length() > 5)
            .count();
        
        // Efficient: filter then map
        long count2 = testWords.stream()
            .filter(word -> word.length() > 5)  // Reduces elements first
            .map(String::toUpperCase)
            .count();
        
        System.out.println("Both approaches give same result: " + count1 + " = " + count2);
        System.out.println("But filter-then-map is more efficient!");
        
        System.out.println("\n=== Stream Operations completed! ===");
    }
    
    // Helper class for complex pipeline examples
    static class Employee {
        private final String name;
        private final String department;
        private final double salary;
        private final int age;
        
        public Employee(String name, String department, double salary, int age) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }
        
        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        public int getAge() { return age; }
        
        @Override
        public String toString() {
            return String.format("%s (%s, $%.0f, %d)", name, department, salary, age);
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Intermediate Operations (return Stream):
 *    - filter(): select elements based on predicate
 *    - map(): transform elements one-to-one
 *    - flatMap(): flatten nested structures
 *    - distinct(): remove duplicates
 *    - sorted(): sort elements
 *    - limit()/skip(): control stream size
 *    - peek(): debug/side effects
 * 
 * 2. Terminal Operations (return result):
 *    - collect(): most versatile, converts to collections
 *    - reduce(): combine elements into single result
 *    - forEach(): side effects for each element
 *    - anyMatch()/allMatch()/noneMatch(): boolean tests
 *    - findFirst()/findAny(): find elements
 *    - count(): count elements
 * 
 * 3. Performance Tips:
 *    - Use short-circuiting operations when possible
 *    - Order operations efficiently (filter before map)
 *    - Understand lazy evaluation
 *    - Consider parallel streams for large datasets
 * 
 * 4. Best Practices:
 *    - Chain operations for readability
 *    - Use method references when possible
 *    - Avoid side effects in intermediate operations
 *    - Use appropriate collectors for terminal operations
 * 
 * 5. Common Patterns:
 *    - Filter-Map-Collect: data transformation
 *    - GroupingBy: categorizing data
 *    - Reduce: aggregating values
 *    - FlatMap: working with nested structures
 */
