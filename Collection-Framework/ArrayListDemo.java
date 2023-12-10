/**
 * ArrayListDemo.java - Understanding ArrayList in Java Collection Framework
 * 
 * Learning Objectives:
 * - Understand ArrayList as a dynamic array implementation
 * - Learn ArrayList creation, initialization, and basic operations
 * - Practice adding, removing, and accessing elements
 * - Compare ArrayList with regular arrays
 * - Understand when to use ArrayList vs other collections
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    
    public static void main(String[] args) {
        
        System.out.println("=== ArrayList Demo - Java Collection Framework ===\n");
        
        // ========== ARRAYLIST CREATION AND INITIALIZATION ==========
        
        System.out.println("=== ArrayList Creation ===");
        
        // Method 1: Default constructor (initial capacity 10)
        ArrayList<String> fruits = new ArrayList<>();
        
        // Method 2: With initial capacity
        ArrayList<Integer> numbers = new ArrayList<>(20);
        
        // Method 3: From another collection
        List<String> colors = Arrays.asList("Red", "Green", "Blue");
        ArrayList<String> colorList = new ArrayList<>(colors);
        
        // Method 4: Using List interface (recommended)
        List<String> animals = new ArrayList<>();
        
        System.out.println("ArrayLists created successfully!");
        System.out.println("Initial fruits size: " + fruits.size());
        System.out.println("Initial numbers capacity: " + numbers.size());
        System.out.println("Colors from array: " + colorList);
        
        // ========== ADDING ELEMENTS ==========
        
        System.out.println("\n=== Adding Elements ===");
        
        // Adding elements to the end
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        
        System.out.println("After adding fruits: " + fruits);
        
        // Adding element at specific index
        fruits.add(1, "Grapes"); // Insert at index 1
        System.out.println("After inserting Grapes at index 1: " + fruits);
        
        // Adding multiple elements
        List<String> moreFruits = Arrays.asList("Pineapple", "Strawberry");
        fruits.addAll(moreFruits);
        System.out.println("After adding more fruits: " + fruits);
        
        // Adding collection at specific index
        fruits.addAll(2, Arrays.asList("Kiwi", "Papaya"));
        System.out.println("After inserting at index 2: " + fruits);
        
        // ========== ACCESSING ELEMENTS ==========
        
        System.out.println("\n=== Accessing Elements ===");
        
        // Get element by index
        String firstFruit = fruits.get(0);
        String lastFruit = fruits.get(fruits.size() - 1);
        
        System.out.println("First fruit: " + firstFruit);
        System.out.println("Last fruit: " + lastFruit);
        System.out.println("Fruit at index 3: " + fruits.get(3));
        
        // Check if element exists
        boolean hasApple = fruits.contains("Apple");
        boolean hasDurian = fruits.contains("Durian");
        
        System.out.println("Contains Apple: " + hasApple);
        System.out.println("Contains Durian: " + hasDurian);
        
        // Find index of element
        int appleIndex = fruits.indexOf("Apple");
        int grapeIndex = fruits.indexOf("Grapes");
        int notFoundIndex = fruits.indexOf("Durian");
        
        System.out.println("Index of Apple: " + appleIndex);
        System.out.println("Index of Grapes: " + grapeIndex);
        System.out.println("Index of Durian (not found): " + notFoundIndex);
        
        // ========== MODIFYING ELEMENTS ==========
        
        System.out.println("\n=== Modifying Elements ===");
        
        System.out.println("Before modification: " + fruits);
        
        // Replace element at specific index
        String oldFruit = fruits.set(0, "Green Apple");
        System.out.println("Replaced '" + oldFruit + "' with 'Green Apple'");
        System.out.println("After modification: " + fruits);
        
        // ========== REMOVING ELEMENTS ==========
        
        System.out.println("\n=== Removing Elements ===");
        
        System.out.println("Before removal: " + fruits);
        System.out.println("Size: " + fruits.size());
        
        // Remove by index
        String removedFruit = fruits.remove(1);
        System.out.println("Removed fruit at index 1: " + removedFruit);
        System.out.println("After removal by index: " + fruits);
        
        // Remove by object
        boolean removed = fruits.remove("Orange");
        System.out.println("Removed Orange: " + removed);
        System.out.println("After removal by object: " + fruits);
        
        // Remove multiple elements
        List<String> toRemove = Arrays.asList("Kiwi", "Papaya");
        fruits.removeAll(toRemove);
        System.out.println("After removing Kiwi and Papaya: " + fruits);
        
        // Remove elements that match condition (Java 8+)
        fruits.removeIf(fruit -> fruit.startsWith("P"));
        System.out.println("After removing fruits starting with 'P': " + fruits);
        
        // ========== ITERATION METHODS ==========
        
        System.out.println("\n=== Iteration Methods ===");
        
        // Recreate list for iteration examples
        List<String> iterationList = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry", "Date"));
        
        // Method 1: Traditional for loop
        System.out.println("Method 1 - Traditional for loop:");
        for (int i = 0; i < iterationList.size(); i++) {
            System.out.println("Index " + i + ": " + iterationList.get(i));
        }
        
        // Method 2: Enhanced for loop (for-each)
        System.out.println("\nMethod 2 - Enhanced for loop:");
        for (String fruit : iterationList) {
            System.out.println("Fruit: " + fruit);
        }
        
        // Method 3: Iterator
        System.out.println("\nMethod 3 - Iterator:");
        Iterator<String> iterator = iterationList.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Iterator fruit: " + fruit);
        }
        
        // Method 4: Java 8 Streams
        System.out.println("\nMethod 4 - Java 8 forEach:");
        iterationList.forEach(fruit -> System.out.println("Stream fruit: " + fruit));
        
        // ========== ARRAYLIST OPERATIONS ==========
        
        System.out.println("\n=== ArrayList Operations ===");
        
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        
        // Size and capacity
        System.out.println("Numbers list: " + numbersList);
        System.out.println("Size: " + numbersList.size());
        System.out.println("Is empty: " + numbersList.isEmpty());
        
        // Sorting
        List<String> unsortedFruits = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry", "Date"));
        System.out.println("Before sorting: " + unsortedFruits);
        Collections.sort(unsortedFruits);
        System.out.println("After sorting: " + unsortedFruits);
        
        // Reverse
        Collections.reverse(unsortedFruits);
        System.out.println("After reversing: " + unsortedFruits);
        
        // Shuffle
        Collections.shuffle(unsortedFruits);
        System.out.println("After shuffling: " + unsortedFruits);
        
        // ========== ARRAYLIST VS ARRAY COMPARISON ==========
        
        System.out.println("\n=== ArrayList vs Array Comparison ===");
        
        // Array - fixed size
        String[] arrayFruits = new String[3];
        arrayFruits[0] = "Apple";
        arrayFruits[1] = "Banana";
        arrayFruits[2] = "Orange";
        // arrayFruits[3] = "Mango"; // This would cause ArrayIndexOutOfBoundsException
        
        System.out.println("Array fruits: " + Arrays.toString(arrayFruits));
        System.out.println("Array length: " + arrayFruits.length);
        
        // ArrayList - dynamic size
        List<String> arrayListFruits = new ArrayList<>();
        arrayListFruits.add("Apple");
        arrayListFruits.add("Banana");
        arrayListFruits.add("Orange");
        arrayListFruits.add("Mango"); // No problem adding more elements
        arrayListFruits.add("Grapes");
        
        System.out.println("ArrayList fruits: " + arrayListFruits);
        System.out.println("ArrayList size: " + arrayListFruits.size());
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        
        // Example 1: Student grades management
        List<Double> grades = new ArrayList<>();
        grades.addAll(Arrays.asList(85.5, 92.0, 78.5, 96.0, 88.5));
        
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        
        System.out.println("Student grades: " + grades);
        System.out.println("Average grade: " + String.format("%.2f", average));
        
        // Find grades above average
        List<Double> aboveAverage = new ArrayList<>();
        for (double grade : grades) {
            if (grade > average) {
                aboveAverage.add(grade);
            }
        }
        System.out.println("Grades above average: " + aboveAverage);
        
        // Example 2: Shopping cart
        List<String> shoppingCart = new ArrayList<>();
        
        // Add items
        shoppingCart.add("Milk");
        shoppingCart.add("Bread");
        shoppingCart.add("Eggs");
        shoppingCart.add("Butter");
        
        System.out.println("\nShopping Cart: " + shoppingCart);
        
        // Remove item
        shoppingCart.remove("Bread");
        System.out.println("After removing Bread: " + shoppingCart);
        
        // Check if item exists before adding
        String newItem = "Milk";
        if (!shoppingCart.contains(newItem)) {
            shoppingCart.add(newItem);
            System.out.println("Added " + newItem + " to cart");
        } else {
            System.out.println(newItem + " already in cart");
        }
        
        // ========== PERFORMANCE CONSIDERATIONS ==========
        
        System.out.println("\n=== Performance Considerations ===");
        
        // Initial capacity matters for performance
        List<Integer> smallList = new ArrayList<>(); // Default capacity 10
        List<Integer> largeList = new ArrayList<>(1000); // Initial capacity 1000
        
        System.out.println("For large datasets, specify initial capacity to avoid resizing");
        System.out.println("ArrayList automatically resizes when needed, but it's expensive");
        
        // Trimming unused capacity
        List<String> trimExample = new ArrayList<>(100);
        trimExample.add("One");
        trimExample.add("Two");
        // After adding only 2 elements, we have 98 unused slots
        ((ArrayList<String>) trimExample).trimToSize(); // Reduce capacity to actual size
        
        System.out.println("Use trimToSize() to reduce memory usage after bulk operations");
        
        System.out.println("\n=== ArrayList Demo completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. ArrayList is a resizable array implementation of List interface
 * 2. Provides dynamic sizing - grows and shrinks as needed
 * 3. Maintains insertion order and allows duplicates
 * 4. Provides fast random access O(1) but slow insertion/deletion O(n)
 * 5. Not thread-safe - use Vector or Collections.synchronizedList() for thread safety
 * 
 * ArrayList vs Array:
 * - Array: Fixed size, primitive types allowed, faster access
 * - ArrayList: Dynamic size, only objects, more methods available
 * 
 * When to use ArrayList:
 * ✅ Need dynamic sizing
 * ✅ Frequent random access to elements
 * ✅ More reads than writes
 * ✅ Need Collection framework methods
 * 
 * When NOT to use ArrayList:
 * ❌ Frequent insertions/deletions in middle
 * ❌ Need thread safety (use Vector or synchronize)
 * ❌ Memory is very limited
 * ❌ Need primitive types (use arrays)
 * 
 * Performance Tips:
 * - Specify initial capacity if size is known
 * - Use trimToSize() after bulk operations
 * - Use ensureCapacity() before bulk additions
 * - Consider LinkedList for frequent insertions/deletions
 */
