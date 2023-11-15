/**
 * ArraySearching.java - Searching Algorithms for Arrays
 * 
 * Learning Objectives:
 * - Understand different searching techniques
 * - Implement Linear Search algorithm
 * - Implement Binary Search algorithm
 * - Compare time complexities of different searches
 * - Practice searching in different scenarios
 */

public class ArraySearching {
    
    public static void main(String[] args) {
        
        System.out.println("=== Array Searching Algorithms ===\n");
        
        // ========== LINEAR SEARCH ==========
        
        System.out.println("=== Linear Search ===");
        
        int[] numbers = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50};
        
        System.out.println("Array: ");
        printArray(numbers);
        
        // Search for existing element
        int target1 = 22;
        int result1 = linearSearch(numbers, target1);
        
        if (result1 != -1) {
            System.out.println("Linear Search: Element " + target1 + " found at index " + result1);
        } else {
            System.out.println("Linear Search: Element " + target1 + " not found");
        }
        
        // Search for non-existing element
        int target2 = 99;
        int result2 = linearSearch(numbers, target2);
        
        if (result2 != -1) {
            System.out.println("Linear Search: Element " + target2 + " found at index " + result2);
        } else {
            System.out.println("Linear Search: Element " + target2 + " not found");
        }
        
        // ========== BINARY SEARCH ==========
        
        System.out.println("\n=== Binary Search ===");
        
        // Binary search requires sorted array
        int[] sortedNumbers = {11, 12, 22, 25, 34, 50, 64, 76, 88, 90};
        
        System.out.println("Sorted Array: ");
        printArray(sortedNumbers);
        
        // Search for existing element
        int target3 = 25;
        int result3 = binarySearch(sortedNumbers, target3);
        
        if (result3 != -1) {
            System.out.println("Binary Search: Element " + target3 + " found at index " + result3);
        } else {
            System.out.println("Binary Search: Element " + target3 + " not found");
        }
        
        // Search for non-existing element
        int target4 = 99;
        int result4 = binarySearch(sortedNumbers, target4);
        
        if (result4 != -1) {
            System.out.println("Binary Search: Element " + target4 + " found at index " + result4);
        } else {
            System.out.println("Binary Search: Element " + target4 + " not found");
        }
        
        // ========== SEARCHING VARIATIONS ==========
        
        System.out.println("\n=== Search Variations ===");
        
        // Find all occurrences
        int[] duplicateArray = {1, 3, 5, 3, 7, 3, 9, 3, 2};
        System.out.println("Array with duplicates: ");
        printArray(duplicateArray);
        
        int searchValue = 3;
        int[] allIndices = findAllOccurrences(duplicateArray, searchValue);
        System.out.print("All occurrences of " + searchValue + " at indices: ");
        printArray(allIndices);
        
        // Find maximum and minimum
        int max = findMaximum(numbers);
        int min = findMinimum(numbers);
        System.out.println("Maximum element: " + max);
        System.out.println("Minimum element: " + min);
        
        // Find second largest
        int secondLargest = findSecondLargest(numbers);
        System.out.println("Second largest element: " + secondLargest);
        
        // ========== STRING SEARCHING ==========
        
        System.out.println("\n=== String Array Searching ===");
        
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Eve", "Frank"};
        System.out.println("Names array: ");
        printStringArray(names);
        
        String searchName = "Charlie";
        int nameIndex = linearSearchString(names, searchName);
        
        if (nameIndex != -1) {
            System.out.println("Name '" + searchName + "' found at index " + nameIndex);
        } else {
            System.out.println("Name '" + searchName + "' not found");
        }
        
        // Case-insensitive search
        String searchName2 = "charlie";
        int nameIndex2 = linearSearchStringIgnoreCase(names, searchName2);
        
        if (nameIndex2 != -1) {
            System.out.println("Name '" + searchName2 + "' found at index " + nameIndex2 + " (case-insensitive)");
        } else {
            System.out.println("Name '" + searchName2 + "' not found (case-insensitive)");
        }
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("\n=== Performance Comparison ===");
        performanceComparison();
        
        System.out.println("\n=== Array Searching lesson completed! ===");
    }
    
    /**
     * Linear Search Algorithm
     * Time Complexity: O(n) - checks each element one by one
     * Space Complexity: O(1) - uses constant extra space
     * 
     * @param arr - array to search in
     * @param target - element to search for
     * @return index of element if found, -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        // Start from first element and check each element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found the element, return its index
            }
        }
        return -1; // Element not found
    }
    
    /**
     * Binary Search Algorithm (Iterative)
     * Time Complexity: O(log n) - eliminates half elements in each step
     * Space Complexity: O(1) - uses constant extra space
     * 
     * Prerequisite: Array must be sorted
     * 
     * @param arr - sorted array to search in
     * @param target - element to search for
     * @return index of element if found, -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;                    // Start of search range
        int right = arr.length - 1;      // End of search range
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Find middle index (avoids overflow)
            
            if (arr[mid] == target) {
                return mid; // Found the element
            }
            
            if (arr[mid] < target) {
                left = mid + 1; // Target is in right half
            } else {
                right = mid - 1; // Target is in left half
            }
        }
        
        return -1; // Element not found
    }
    
    /**
     * Binary Search Algorithm (Recursive)
     * Demonstrates recursive approach to binary search
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: element not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid; // Found the element
        }
        
        if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search right half
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);  // Search left half
        }
    }
    
    /**
     * Find all occurrences of an element in array
     * @param arr - array to search in
     * @param target - element to find
     * @return array of indices where element is found
     */
    public static int[] findAllOccurrences(int[] arr, int target) {
        // First pass: count occurrences
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        
        // Create result array
        int[] indices = new int[count];
        int index = 0;
        
        // Second pass: collect indices
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indices[index++] = i;
            }
        }
        
        return indices;
    }
    
    /**
     * Find maximum element in array
     * @param arr - array to search
     * @return maximum element
     */
    public static int findMaximum(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Find minimum element in array
     * @param arr - array to search
     * @return minimum element
     */
    public static int findMinimum(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    /**
     * Find second largest element in array
     * @param arr - array to search
     * @return second largest element
     */
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found (all elements might be same)");
        }
        
        return secondLargest;
    }
    
    /**
     * Linear search for strings
     * @param arr - string array to search
     * @param target - string to find
     * @return index if found, -1 if not found
     */
    public static int linearSearchString(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Case-insensitive linear search for strings
     * @param arr - string array to search
     * @param target - string to find
     * @return index if found, -1 if not found
     */
    public static int linearSearchStringIgnoreCase(String[] arr, String target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Performance comparison between linear and binary search
     */
    public static void performanceComparison() {
        System.out.println("Search Algorithm Comparison:");
        System.out.println("┌─────────────────┬─────────────────┬─────────────────┬─────────────────┐");
        System.out.println("│ Algorithm       │ Time Complexity │ Space Complexity│ Prerequisites   │");
        System.out.println("├─────────────────┼─────────────────┼─────────────────┼─────────────────┤");
        System.out.println("│ Linear Search   │ O(n)            │ O(1)            │ None            │");
        System.out.println("│ Binary Search   │ O(log n)        │ O(1)            │ Sorted Array    │");
        System.out.println("└─────────────────┴─────────────────┴─────────────────┴─────────────────┘");
        
        System.out.println("\nWhen to use which:");
        System.out.println("• Linear Search: Small arrays, unsorted data, simple implementation");
        System.out.println("• Binary Search: Large sorted arrays, frequent searches, better performance");
        
        // Practical demonstration with larger array
        int[] largeArray = new int[1000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2; // Even numbers: 0, 2, 4, 6, ...
        }
        
        int searchTarget = 500;
        
        // Linear search steps
        int linearSteps = 0;
        for (int i = 0; i < largeArray.length; i++) {
            linearSteps++;
            if (largeArray[i] == searchTarget) {
                break;
            }
        }
        
        // Binary search steps (approximate)
        int binarySteps = (int) Math.ceil(Math.log(largeArray.length) / Math.log(2));
        
        System.out.println("\nFor array of size " + largeArray.length + ", searching for " + searchTarget + ":");
        System.out.println("Linear Search steps: " + linearSteps);
        System.out.println("Binary Search steps (max): " + binarySteps);
        System.out.println("Binary search is " + (linearSteps / binarySteps) + "x faster!");
    }
    
    /**
     * Utility method to print integer array
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Utility method to print string array
     */
    public static void printStringArray(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Linear Search: Simple but slow O(n), works on any array
 * 2. Binary Search: Fast O(log n) but requires sorted array
 * 3. Choose algorithm based on data size and whether it's sorted
 * 4. Binary search eliminates half the elements in each step
 * 5. Always consider prerequisites (sorted array for binary search)
 * 
 * Search Algorithm Selection Guide:
 * - Small arrays (< 100 elements): Linear search is fine
 * - Large arrays, unsorted: Linear search or sort first then binary
 * - Large arrays, already sorted: Binary search
 * - Frequent searches: Consider sorting once, then use binary search
 * 
 * Common Applications:
 * - Finding user in database
 * - Searching files in directory
 * - Looking up words in dictionary
 * - Finding products in inventory
 * 
 * Optimization Tips:
 * - For multiple searches, sort once and use binary search
 * - Consider using hash tables for O(1) average search time
 * - Use built-in Arrays.binarySearch() for production code
 */
