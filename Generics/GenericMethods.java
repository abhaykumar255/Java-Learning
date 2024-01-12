/**
 * GenericMethods.java - Generic Methods and Wildcards
 * 
 * Learning Objectives:
 * - Learn to create and use generic methods
 * - Understand bounded type parameters and wildcards
 * - Master upper and lower bounded wildcards
 * - Practice generic method overloading and inheritance
 * - Apply generics in real-world scenarios
 */

import java.util.*;

public class GenericMethods {
    
    public static void main(String[] args) {
        
        System.out.println("=== Generic Methods and Wildcards ===\n");
        
        // ========== GENERIC METHODS ==========
        
        System.out.println("=== Generic Methods ===");
        demonstrateGenericMethods();
        
        // ========== BOUNDED TYPE PARAMETERS ==========
        
        System.out.println("\n=== Bounded Type Parameters ===");
        demonstrateBoundedTypes();
        
        // ========== WILDCARDS ==========
        
        System.out.println("\n=== Wildcards ===");
        demonstrateWildcards();
        
        // ========== PRACTICAL APPLICATIONS ==========
        
        System.out.println("\n=== Practical Applications ===");
        demonstratePracticalApplications();
    }
    
    /**
     * Demonstrate generic methods
     */
    public static void demonstrateGenericMethods() {
        System.out.println("Generic methods can work with different types:");
        System.out.println();
        
        // Generic method for swapping array elements
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swap: " + Arrays.toString(intArray));
        swap(intArray, 0, 4);
        System.out.println("After swap: " + Arrays.toString(intArray));
        
        String[] strArray = {"apple", "banana", "cherry"};
        System.out.println("Before swap: " + Arrays.toString(strArray));
        swap(strArray, 0, 2);
        System.out.println("After swap: " + Arrays.toString(strArray));
        System.out.println();
        
        // Generic method for finding maximum
        Integer max1 = findMax(10, 20, 5);
        String max2 = findMax("apple", "zebra", "banana");
        Double max3 = findMax(3.14, 2.71, 1.41);
        
        System.out.println("Max of integers: " + max1);
        System.out.println("Max of strings: " + max2);
        System.out.println("Max of doubles: " + max3);
        System.out.println();
        
        // Generic method for printing arrays
        printArray(intArray);
        printArray(strArray);
        printArray(new Double[]{1.1, 2.2, 3.3});
    }
    
    /**
     * Generic method to swap two elements in an array
     */
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /**
     * Generic method to find maximum of three comparable elements
     */
    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }
    
    /**
     * Generic method to print array elements
     */
    public static <T> void printArray(T[] array) {
        System.out.print("Array: ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    /**
     * Demonstrate bounded type parameters
     */
    public static void demonstrateBoundedTypes() {
        System.out.println("Bounded type parameters restrict the types that can be used:");
        System.out.println();
        
        // Numbers only - bounded by Number class
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4);
        
        double intSum = sumOfNumbers(intList);
        double doubleSum = sumOfNumbers(doubleList);
        
        System.out.println("Sum of integers: " + intSum);
        System.out.println("Sum of doubles: " + doubleSum);
        System.out.println();
        
        // Comparable types only
        List<String> words = Arrays.asList("banana", "apple", "cherry");
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5);
        
        String minWord = findMinimum(words);
        Integer minNumber = findMinimum(numbers);
        
        System.out.println("Minimum word: " + minWord);
        System.out.println("Minimum number: " + minNumber);
        System.out.println();
        
        // Multiple bounds
        List<ComparableNumber> compNumbers = Arrays.asList(
            new ComparableNumber(5), new ComparableNumber(2), new ComparableNumber(8)
        );
        ComparableNumber minCompNumber = findMinimumNumber(compNumbers);
        System.out.println("Minimum comparable number: " + minCompNumber.getValue());
    }
    
    /**
     * Generic method with upper bound - only Number and its subtypes
     */
    public static <T extends Number> double sumOfNumbers(List<T> numbers) {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    /**
     * Generic method with Comparable bound
     */
    public static <T extends Comparable<T>> T findMinimum(List<T> list) {
        if (list.isEmpty()) return null;
        
        T min = list.get(0);
        for (T element : list) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
    
    /**
     * Generic method with multiple bounds
     */
    public static <T extends Number & Comparable<T>> T findMinimumNumber(List<T> numbers) {
        if (numbers.isEmpty()) return null;
        
        T min = numbers.get(0);
        for (T number : numbers) {
            if (number.compareTo(min) < 0) {
                min = number;
            }
        }
        return min;
    }
    
    // Helper class for multiple bounds example
    static class ComparableNumber extends Number implements Comparable<ComparableNumber> {
        private final double value;
        
        public ComparableNumber(double value) {
            this.value = value;
        }
        
        public double getValue() { return value; }
        
        @Override
        public int compareTo(ComparableNumber other) {
            return Double.compare(this.value, other.value);
        }
        
        @Override
        public int intValue() { return (int) value; }
        @Override
        public long longValue() { return (long) value; }
        @Override
        public float floatValue() { return (float) value; }
        @Override
        public double doubleValue() { return value; }
    }
    
    /**
     * Demonstrate wildcards
     */
    public static void demonstrateWildcards() {
        System.out.println("Wildcards provide flexibility in generic type usage:");
        System.out.println();
        
        // Unbounded wildcard
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<String> strList = Arrays.asList("a", "b", "c");
        
        System.out.println("Unbounded wildcard (?):");
        printListSize(intList);
        printListSize(strList);
        System.out.println();
        
        // Upper bounded wildcard
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        
        System.out.println("Upper bounded wildcard (? extends Number):");
        double sum1 = calculateSum(integers);
        double sum2 = calculateSum(doubles);
        System.out.println("Sum of integers: " + sum1);
        System.out.println("Sum of doubles: " + sum2);
        System.out.println();
        
        // Lower bounded wildcard
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();
        
        System.out.println("Lower bounded wildcard (? super Integer):");
        addIntegers(numberList);
        addIntegers(objectList);
        System.out.println("Numbers added to Number list: " + numberList);
        System.out.println("Numbers added to Object list: " + objectList);
        System.out.println();
        
        // PECS principle demonstration
        demonstratePECS();
    }
    
    /**
     * Method using unbounded wildcard
     */
    public static void printListSize(List<?> list) {
        System.out.println("List size: " + list.size());
    }
    
    /**
     * Method using upper bounded wildcard (Producer)
     */
    public static double calculateSum(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
    
    /**
     * Method using lower bounded wildcard (Consumer)
     */
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }
    
    /**
     * Demonstrate PECS (Producer Extends, Consumer Super) principle
     */
    public static void demonstratePECS() {
        System.out.println("PECS Principle (Producer Extends, Consumer Super):");
        
        // Producer scenario - reading from collection
        List<Integer> intSource = Arrays.asList(1, 2, 3, 4, 5);
        List<Number> numberDest = new ArrayList<>();
        
        // Use extends for producer (source)
        copyElements(intSource, numberDest);
        System.out.println("Copied elements: " + numberDest);
        
        // Consumer scenario - writing to collection
        List<Object> objectDest = new ArrayList<>();
        
        // Use super for consumer (destination)
        addNumbers(objectDest);
        System.out.println("Added numbers: " + objectDest);
    }
    
    /**
     * PECS example - copy from producer to consumer
     */
    public static <T> void copyElements(List<? extends T> source, List<? super T> destination) {
        for (T element : source) {
            destination.add(element);
        }
    }
    
    /**
     * PECS example - add to consumer
     */
    public static void addNumbers(List<? super Number> list) {
        list.add(42);
        list.add(3.14);
        list.add(100L);
    }
    
    /**
     * Demonstrate practical applications
     */
    public static void demonstratePracticalApplications() {
        System.out.println("Practical applications of generic methods:");
        System.out.println();
        
        // Generic utility methods
        System.out.println("1. Generic utility methods:");
        List<String> words = Arrays.asList("hello", "world", "java", "generics");
        List<String> filtered = filter(words, s -> s.length() > 4);
        System.out.println("Words longer than 4 chars: " + filtered);
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> mapped = map(numbers, n -> "Number: " + n);
        System.out.println("Mapped numbers: " + mapped);
        System.out.println();
        
        // Generic data structures
        System.out.println("2. Generic data structures:");
        Pair<String, Integer> nameAge = new Pair<>("Alice", 25);
        Pair<Integer, String> idName = new Pair<>(101, "Bob");
        
        System.out.println("Name-Age pair: " + nameAge);
        System.out.println("ID-Name pair: " + idName);
        
        System.out.println("\n=== Generic Methods completed! ===");
    }
    
    /**
     * Generic filter method
     */
    public static <T> List<T> filter(List<T> list, java.util.function.Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
    
    /**
     * Generic map method
     */
    public static <T, R> List<R> map(List<T> list, java.util.function.Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(mapper.apply(element));
        }
        return result;
    }
    
    /**
     * Generic Pair class
     */
    static class Pair<T, U> {
        private final T first;
        private final U second;
        
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
        
        public T getFirst() { return first; }
        public U getSecond() { return second; }
        
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Generic Methods:
 *    - Syntax: <T> returnType methodName(parameters)
 *    - Type parameters are inferred from usage
 *    - Can have multiple type parameters
 *    - Independent of class generics
 * 
 * 2. Bounded Type Parameters:
 *    - Upper bound: <T extends SomeClass>
 *    - Multiple bounds: <T extends Class & Interface>
 *    - Enables calling methods on bounded types
 * 
 * 3. Wildcards:
 *    - Unbounded: List<?> (read-only operations)
 *    - Upper bounded: List<? extends T> (producer)
 *    - Lower bounded: List<? super T> (consumer)
 * 
 * 4. PECS Principle:
 *    - Producer Extends: use ? extends T for reading
 *    - Consumer Super: use ? super T for writing
 *    - Helps determine correct wildcard usage
 * 
 * 5. Best Practices:
 *    - Use bounded types when you need specific operations
 *    - Apply PECS for collection parameters
 *    - Prefer generic methods over raw types
 *    - Use wildcards for API flexibility
 */
