/**
 * SearchingAlgorithms.java - Comprehensive Searching Algorithms
 * 
 * Learning Objectives:
 * - Master different searching algorithms and their applications
 * - Understand time and space complexity of each algorithm
 * - Learn when to use which searching technique
 * - Practice implementation of various search algorithms
 * - Compare performance characteristics
 */

import java.util.*;

public class SearchingAlgorithms {
    
    public static void main(String[] args) {
        
        System.out.println("=== Searching Algorithms ===\n");
        
        // ========== LINEAR SEARCH ==========
        
        System.out.println("=== Linear Search ===");
        demonstrateLinearSearch();
        
        // ========== BINARY SEARCH ==========
        
        System.out.println("\n=== Binary Search ===");
        demonstrateBinarySearch();
        
        // ========== INTERPOLATION SEARCH ==========
        
        System.out.println("\n=== Interpolation Search ===");
        demonstrateInterpolationSearch();
        
        // ========== EXPONENTIAL SEARCH ==========
        
        System.out.println("\n=== Exponential Search ===");
        demonstrateExponentialSearch();
        
        // ========== SEARCH IN ROTATED ARRAY ==========
        
        System.out.println("\n=== Search in Rotated Sorted Array ===");
        demonstrateRotatedArraySearch();
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("\n=== Performance Comparison ===");
        compareSearchPerformance();
    }
    
    /**
     * Demonstrate linear search algorithm
     */
    public static void demonstrateLinearSearch() {
        System.out.println("Linear Search - checks each element sequentially");
        System.out.println("Time Complexity: O(n), Space Complexity: O(1)");
        System.out.println("Use when: array is unsorted, small datasets");
        System.out.println();
        
        int[] array = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50};
        int target = 22;
        
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Searching for: " + target);
        
        int result = linearSearch(array, target);
        if (result != -1) {
            System.out.println("Found at index: " + result);
        } else {
            System.out.println("Not found");
        }
        
        // Search for non-existent element
        int notFound = linearSearch(array, 99);
        System.out.println("Searching for 99: " + (notFound == -1 ? "Not found" : "Found at " + notFound));
    }
    
    /**
     * Linear Search Implementation
     * Time: O(n), Space: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }
    
    /**
     * Demonstrate binary search algorithm
     */
    public static void demonstrateBinarySearch() {
        System.out.println("Binary Search - divides search space in half each iteration");
        System.out.println("Time Complexity: O(log n), Space Complexity: O(1)");
        System.out.println("Requirement: array must be sorted");
        System.out.println();
        
        int[] sortedArray = {11, 12, 22, 25, 34, 50, 64, 76, 88, 90};
        int target = 25;
        
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        System.out.println("Searching for: " + target);
        
        // Iterative binary search
        int iterativeResult = binarySearchIterative(sortedArray, target);
        System.out.println("Iterative Binary Search: " + 
                          (iterativeResult != -1 ? "Found at index " + iterativeResult : "Not found"));
        
        // Recursive binary search
        int recursiveResult = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
        System.out.println("Recursive Binary Search: " + 
                          (recursiveResult != -1 ? "Found at index " + recursiveResult : "Not found"));
        
        // Demonstrate search process
        System.out.println("\nStep-by-step binary search for " + target + ":");
        binarySearchWithSteps(sortedArray, target);
    }
    
    /**
     * Binary Search - Iterative Implementation
     * Time: O(log n), Space: O(1)
     */
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        
        return -1; // Not found
    }
    
    /**
     * Binary Search - Recursive Implementation
     * Time: O(log n), Space: O(log n) due to recursion stack
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Binary search with step-by-step visualization
     */
    public static void binarySearchWithSteps(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int step = 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            System.out.printf("Step %d: left=%d, right=%d, mid=%d, arr[mid]=%d\n", 
                             step, left, right, mid, arr[mid]);
            
            if (arr[mid] == target) {
                System.out.println("Found target at index " + mid);
                return;
            } else if (arr[mid] < target) {
                System.out.println("Target is greater, search right half");
                left = mid + 1;
            } else {
                System.out.println("Target is smaller, search left half");
                right = mid - 1;
            }
            step++;
        }
        
        System.out.println("Target not found");
    }
    
    /**
     * Demonstrate interpolation search
     */
    public static void demonstrateInterpolationSearch() {
        System.out.println("Interpolation Search - estimates position based on value");
        System.out.println("Time Complexity: O(log log n) for uniform distribution, O(n) worst case");
        System.out.println("Best for: uniformly distributed sorted arrays");
        System.out.println();
        
        int[] uniformArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;
        
        System.out.println("Uniform Array: " + Arrays.toString(uniformArray));
        System.out.println("Searching for: " + target);
        
        int result = interpolationSearch(uniformArray, target);
        System.out.println("Interpolation Search: " + 
                          (result != -1 ? "Found at index " + result : "Not found"));
    }
    
    /**
     * Interpolation Search Implementation
     * Works best with uniformly distributed data
     */
    public static int interpolationSearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right && target >= arr[left] && target <= arr[right]) {
            // If array has only one element
            if (left == right) {
                return arr[left] == target ? left : -1;
            }
            
            // Estimate position using interpolation formula
            int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);
            
            if (arr[pos] == target) {
                return pos;
            } else if (arr[pos] < target) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * Demonstrate exponential search
     */
    public static void demonstrateExponentialSearch() {
        System.out.println("Exponential Search - finds range then applies binary search");
        System.out.println("Time Complexity: O(log n), Space Complexity: O(1)");
        System.out.println("Useful for: unbounded/infinite arrays");
        System.out.println();
        
        int[] array = {2, 3, 4, 10, 40, 50, 80, 100, 120, 150, 200, 300};
        int target = 100;
        
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Searching for: " + target);
        
        int result = exponentialSearch(array, target);
        System.out.println("Exponential Search: " + 
                          (result != -1 ? "Found at index " + result : "Not found"));
    }
    
    /**
     * Exponential Search Implementation
     * First finds range, then applies binary search
     */
    public static int exponentialSearch(int[] arr, int target) {
        // If target is at first position
        if (arr[0] == target) {
            return 0;
        }
        
        // Find range for binary search by repeated doubling
        int bound = 1;
        while (bound < arr.length && arr[bound] <= target) {
            bound *= 2;
        }
        
        // Apply binary search in the found range
        return binarySearchIterative(
            Arrays.copyOfRange(arr, bound / 2, Math.min(bound, arr.length)), 
            target
        ) + bound / 2;
    }
    
    /**
     * Demonstrate search in rotated sorted array
     */
    public static void demonstrateRotatedArraySearch() {
        System.out.println("Search in Rotated Sorted Array");
        System.out.println("Time Complexity: O(log n), Space Complexity: O(1)");
        System.out.println("Challenge: array is sorted but rotated at some pivot");
        System.out.println();
        
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        System.out.println("Rotated Array: " + Arrays.toString(rotatedArray));
        System.out.println("Searching for: " + target);
        
        int result = searchInRotatedArray(rotatedArray, target);
        System.out.println("Found at index: " + (result != -1 ? result : "Not found"));
        
        // Test with different targets
        int[] testTargets = {4, 6, 1, 3};
        for (int testTarget : testTargets) {
            int testResult = searchInRotatedArray(rotatedArray, testTarget);
            System.out.printf("Target %d: %s\n", testTarget, 
                             testResult != -1 ? "Found at index " + testResult : "Not found");
        }
    }
    
    /**
     * Search in Rotated Sorted Array
     * Modified binary search for rotated arrays
     */
    public static int searchInRotatedArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted
            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1; // Target is in left half
                } else {
                    left = mid + 1;  // Target is in right half
                }
            } else {
                // Right half is sorted
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;  // Target is in right half
                } else {
                    right = mid - 1; // Target is in left half
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Compare performance of different search algorithms
     */
    public static void compareSearchPerformance() {
        System.out.println("Performance Comparison Summary:");
        System.out.println();
        
        System.out.println("Algorithm           | Time Complexity | Space | Requirements");
        System.out.println("-------------------|-----------------|-------|-------------");
        System.out.println("Linear Search      | O(n)            | O(1)  | None");
        System.out.println("Binary Search      | O(log n)        | O(1)  | Sorted array");
        System.out.println("Interpolation      | O(log log n)*   | O(1)  | Uniform distribution");
        System.out.println("Exponential        | O(log n)        | O(1)  | Sorted, unbounded");
        System.out.println("Rotated Array      | O(log n)        | O(1)  | Rotated sorted");
        System.out.println();
        System.out.println("* Best case for uniform distribution, O(n) worst case");
        System.out.println();
        
        System.out.println("When to use each algorithm:");
        System.out.println("- Linear Search: Small arrays, unsorted data");
        System.out.println("- Binary Search: Large sorted arrays (most common)");
        System.out.println("- Interpolation: Large uniformly distributed sorted arrays");
        System.out.println("- Exponential: Unbounded/infinite sorted arrays");
        System.out.println("- Rotated Array: Sorted arrays that have been rotated");
        
        System.out.println("\n=== Searching Algorithms completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Algorithm Selection:
 *    - Linear: O(n) - use for unsorted or small arrays
 *    - Binary: O(log n) - use for sorted arrays (most efficient)
 *    - Interpolation: O(log log n) - use for uniform distribution
 *    - Exponential: O(log n) - use for unbounded sorted arrays
 * 
 * 2. Binary Search Variants:
 *    - Standard: sorted array
 *    - Rotated: sorted but rotated array
 *    - Lower/Upper bound: find insertion points
 * 
 * 3. Implementation Tips:
 *    - Use mid = left + (right - left) / 2 to avoid overflow
 *    - Be careful with boundary conditions
 *    - Consider iterative vs recursive based on space requirements
 * 
 * 4. Real-world Applications:
 *    - Database indexing
 *    - Finding elements in sorted collections
 *    - Range queries
 *    - Debugging and testing
 * 
 * 5. Performance Considerations:
 *    - Binary search is usually the best choice for sorted data
 *    - Linear search is simple and works for any data
 *    - Specialized algorithms for specific data patterns
 */
