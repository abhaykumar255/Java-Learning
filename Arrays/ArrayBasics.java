/**
 * ArrayBasics.java - Introduction to Arrays in Java
 * 
 * Learning Objectives:
 * - Understand what arrays are and why we need them
 * - Learn different ways to declare and initialize arrays
 * - Practice accessing and modifying array elements
 * - Understand array properties and limitations
 */

public class ArrayBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Array Basics in Java ===\n");
        
        // ========== WHY DO WE NEED ARRAYS? ==========
        
        // Without arrays - storing multiple student scores
        int student1Score = 85;
        int student2Score = 92;
        int student3Score = 78;
        int student4Score = 96;
        int student5Score = 88;
        
        System.out.println("Without arrays (tedious approach):");
        System.out.println("Student 1: " + student1Score);
        System.out.println("Student 2: " + student2Score);
        // ... imagine doing this for 100 students!
        
        // With arrays - much cleaner and scalable
        int[] studentScores = {85, 92, 78, 96, 88};
        System.out.println("\nWith arrays (efficient approach):");
        for (int i = 0; i < studentScores.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + studentScores[i]);
        }
        
        // ========== ARRAY DECLARATION METHODS ==========
        
        System.out.println("\n=== Array Declaration Methods ===");
        
        // Method 1: Declare then initialize
        int[] numbers1;                    // Declaration
        numbers1 = new int[5];            // Initialization with size 5
        
        // Method 2: Declare and initialize together
        int[] numbers2 = new int[5];      // Creates array of size 5 with default values (0)
        
        // Method 3: Declare and initialize with values
        int[] numbers3 = {10, 20, 30, 40, 50};  // Array literal
        
        // Method 4: Using new keyword with values
        int[] numbers4 = new int[]{15, 25, 35, 45, 55};
        
        // Alternative syntax (less common)
        int numbers5[] = new int[5];      // C-style declaration
        
        System.out.println("Arrays declared successfully!");
        
        // ========== ARRAY INITIALIZATION AND DEFAULT VALUES ==========
        
        System.out.println("\n=== Array Initialization ===");
        
        // Different data types and their default values
        int[] intArray = new int[3];           // Default: 0
        double[] doubleArray = new double[3];  // Default: 0.0
        boolean[] boolArray = new boolean[3];  // Default: false
        String[] stringArray = new String[3];  // Default: null
        
        System.out.println("Default values:");
        System.out.println("int array: " + intArray[0] + ", " + intArray[1] + ", " + intArray[2]);
        System.out.println("double array: " + doubleArray[0] + ", " + doubleArray[1] + ", " + doubleArray[2]);
        System.out.println("boolean array: " + boolArray[0] + ", " + boolArray[1] + ", " + boolArray[2]);
        System.out.println("String array: " + stringArray[0] + ", " + stringArray[1] + ", " + stringArray[2]);
        
        // ========== ACCESSING AND MODIFYING ARRAY ELEMENTS ==========
        
        System.out.println("\n=== Accessing and Modifying Elements ===");
        
        // Create an array of fruits
        String[] fruits = {"Apple", "Banana", "Orange", "Mango", "Grapes"};
        
        // Accessing elements using index (0-based indexing)
        System.out.println("First fruit: " + fruits[0]);      // Index 0
        System.out.println("Third fruit: " + fruits[2]);      // Index 2
        System.out.println("Last fruit: " + fruits[4]);       // Index 4
        
        // Alternative way to access last element
        System.out.println("Last fruit (using length): " + fruits[fruits.length - 1]);
        
        // Modifying array elements
        System.out.println("\nBefore modification: " + fruits[1]);
        fruits[1] = "Pineapple";  // Changing "Banana" to "Pineapple"
        System.out.println("After modification: " + fruits[1]);
        
        // ========== ARRAY LENGTH PROPERTY ==========
        
        System.out.println("\n=== Array Length Property ===");
        
        int[] ages = {25, 30, 22, 35, 28, 40};
        
        System.out.println("Array length: " + ages.length);
        System.out.println("Valid indices: 0 to " + (ages.length - 1));
        
        // Important: length is a property, not a method (no parentheses)
        // String.length() is a method, but array.length is a property
        
        // ========== ARRAY TRAVERSAL ==========
        
        System.out.println("\n=== Array Traversal Methods ===");
        
        int[] scores = {88, 92, 76, 95, 83, 90};
        
        // Method 1: Traditional for loop
        System.out.println("Method 1 - Traditional for loop:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Index " + i + ": " + scores[i]);
        }
        
        // Method 2: Enhanced for loop (for-each)
        System.out.println("\nMethod 2 - Enhanced for loop:");
        int index = 0;
        for (int score : scores) {
            System.out.println("Index " + index + ": " + score);
            index++;
        }
        
        // Method 3: While loop
        System.out.println("\nMethod 3 - While loop:");
        int i = 0;
        while (i < scores.length) {
            System.out.println("Index " + i + ": " + scores[i]);
            i++;
        }
        
        // ========== COMMON ARRAY OPERATIONS ==========
        
        System.out.println("\n=== Common Array Operations ===");
        
        int[] data = {12, 45, 23, 67, 34, 89, 56};
        
        // Finding sum of all elements
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        System.out.println("Sum of all elements: " + sum);
        
        // Finding average
        double average = (double) sum / data.length;
        System.out.println("Average: " + average);
        
        // Finding maximum element
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum element: " + max);
        
        // Finding minimum element
        int min = data[0];
        for (int num : data) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Minimum element: " + min);
        
        // ========== ARRAY LIMITATIONS ==========
        
        System.out.println("\n=== Array Limitations ===");
        
        int[] fixedArray = new int[5];
        System.out.println("Array size: " + fixedArray.length);
        
        // Arrays have fixed size - cannot be changed after creation
        // fixedArray[5] = 100;  // This would cause ArrayIndexOutOfBoundsException
        
        System.out.println("Remember: Arrays have fixed size and 0-based indexing!");
        
        System.out.println("\n=== Array Basics lesson completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Arrays store multiple elements of the same type
 * 2. Array indices start from 0 and go up to (length - 1)
 * 3. Arrays have fixed size once created
 * 4. Use array.length to get the size (no parentheses)
 * 5. Enhanced for loop is great when you don't need indices
 * 6. Always check array bounds to avoid exceptions
 * 7. Arrays are objects in Java (reference types)
 * 
 * Common Mistakes to Avoid:
 * - Accessing array[array.length] (should be array[array.length-1])
 * - Forgetting that arrays are 0-indexed
 * - Using array.length() instead of array.length
 */
