/**
 * ArraySorting.java - Sorting Algorithms for Arrays
 * 
 * Learning Objectives:
 * - Understand different sorting algorithms and their characteristics
 * - Implement Bubble Sort, Selection Sort, and Insertion Sort
 * - Learn Merge Sort and Quick Sort (divide and conquer)
 * - Compare time and space complexities of sorting algorithms
 * - Use built-in Arrays.sort() method effectively
 */

import java.util.Arrays;
import java.util.Random;

public class ArraySorting {
    
    public static void main(String[] args) {
        
        System.out.println("=== Array Sorting Algorithms ===\n");
        
        // ========== BUBBLE SORT ==========
        
        System.out.println("=== Bubble Sort ===");
        
        int[] bubbleArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(bubbleArray));
        
        bubbleSort(bubbleArray.clone());
        
        // ========== SELECTION SORT ==========
        
        System.out.println("\n=== Selection Sort ===");
        
        int[] selectionArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(selectionArray));
        
        selectionSort(selectionArray.clone());
        
        // ========== INSERTION SORT ==========
        
        System.out.println("\n=== Insertion Sort ===");
        
        int[] insertionArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(insertionArray));
        
        insertionSort(insertionArray.clone());
        
        // ========== MERGE SORT ==========
        
        System.out.println("\n=== Merge Sort ===");
        
        int[] mergeArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(mergeArray));
        
        int[] mergeSorted = mergeArray.clone();
        mergeSort(mergeSorted, 0, mergeSorted.length - 1);
        System.out.println("Merge sorted: " + Arrays.toString(mergeSorted));
        
        // ========== QUICK SORT ==========
        
        System.out.println("\n=== Quick Sort ===");
        
        int[] quickArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(quickArray));
        
        int[] quickSorted = quickArray.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("Quick sorted: " + Arrays.toString(quickSorted));
        
        // ========== BUILT-IN SORTING ==========
        
        System.out.println("\n=== Built-in Arrays.sort() ===");
        
        int[] builtInArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(builtInArray));
        
        Arrays.sort(builtInArray);
        System.out.println("Arrays.sort() result: " + Arrays.toString(builtInArray));
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("\n=== Performance Comparison ===");
        performanceComparison();
        
        // ========== SORTING VARIATIONS ==========
        
        System.out.println("\n=== Sorting Variations ===");
        sortingVariations();
        
        System.out.println("\n=== Array Sorting lesson completed! ===");
    }
    
    /**
     * Bubble Sort Algorithm
     * Time Complexity: O(n²) average and worst case, O(n) best case
     * Space Complexity: O(1)
     * 
     * How it works:
     * - Compare adjacent elements and swap if they're in wrong order
     * - Repeat until no more swaps are needed
     * - Largest elements "bubble up" to the end
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        System.out.println("Bubble Sort steps:");
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr));
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                System.out.println("Array sorted early at pass " + (i + 1));
                break;
            }
        }
        
        System.out.println("Final sorted array: " + Arrays.toString(arr));
    }
    
    /**
     * Selection Sort Algorithm
     * Time Complexity: O(n²) for all cases
     * Space Complexity: O(1)
     * 
     * How it works:
     * - Find the minimum element and place it at the beginning
     * - Find the second minimum and place it at second position
     * - Continue until array is sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("Selection Sort steps:");
        
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in remaining unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap the found minimum element with first element
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(arr) + 
                             " (min: " + arr[i] + " at position " + i + ")");
        }
        
        System.out.println("Final sorted array: " + Arrays.toString(arr));
    }
    
    /**
     * Insertion Sort Algorithm
     * Time Complexity: O(n²) average and worst case, O(n) best case
     * Space Complexity: O(1)
     * 
     * How it works:
     * - Build sorted array one element at a time
     * - Take each element and insert it in correct position in sorted portion
     * - Like sorting playing cards in your hand
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("Insertion Sort steps:");
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            arr[j + 1] = key;
            
            System.out.println("Pass " + i + ": " + Arrays.toString(arr) + 
                             " (inserted: " + key + ")");
        }
        
        System.out.println("Final sorted array: " + Arrays.toString(arr));
    }
    
    /**
     * Merge Sort Algorithm (Divide and Conquer)
     * Time Complexity: O(n log n) for all cases
     * Space Complexity: O(n)
     * 
     * How it works:
     * - Divide array into two halves
     * - Recursively sort both halves
     * - Merge the sorted halves
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Helper method to merge two sorted subarrays
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    /**
     * Quick Sort Algorithm (Divide and Conquer)
     * Time Complexity: O(n log n) average case, O(n²) worst case
     * Space Complexity: O(log n) average case
     * 
     * How it works:
     * - Choose a pivot element
     * - Partition array so elements smaller than pivot are on left, larger on right
     * - Recursively sort left and right subarrays
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * Helper method to partition array for quick sort
     */
    public static int partition(int[] arr, int low, int high) {
        // Choose rightmost element as pivot
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                
                // Swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap pivot with element at i+1
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    /**
     * Performance comparison of different sorting algorithms
     */
    public static void performanceComparison() {
        System.out.println("Sorting Algorithm Comparison:");
        System.out.println("┌─────────────────┬─────────────┬─────────────┬─────────────┬─────────────┬─────────┐");
        System.out.println("│ Algorithm       │ Best Case   │ Average Case│ Worst Case  │ Space       │ Stable  │");
        System.out.println("├─────────────────┼─────────────┼─────────────┼─────────────┼─────────────┼─────────┤");
        System.out.println("│ Bubble Sort     │ O(n)        │ O(n²)       │ O(n²)       │ O(1)        │ Yes     │");
        System.out.println("│ Selection Sort  │ O(n²)       │ O(n²)       │ O(n²)       │ O(1)        │ No      │");
        System.out.println("│ Insertion Sort  │ O(n)        │ O(n²)       │ O(n²)       │ O(1)        │ Yes     │");
        System.out.println("│ Merge Sort      │ O(n log n)  │ O(n log n)  │ O(n log n)  │ O(n)        │ Yes     │");
        System.out.println("│ Quick Sort      │ O(n log n)  │ O(n log n)  │ O(n²)       │ O(log n)    │ No      │");
        System.out.println("│ Heap Sort       │ O(n log n)  │ O(n log n)  │ O(n log n)  │ O(1)        │ No      │");
        System.out.println("└─────────────────┴─────────────┴─────────────┴─────────────┴─────────────┴─────────┘");
        
        System.out.println("\nWhen to use which algorithm:");
        System.out.println("• Bubble Sort: Educational purposes, very small datasets");
        System.out.println("• Selection Sort: Small datasets, memory is limited");
        System.out.println("• Insertion Sort: Small datasets, nearly sorted data");
        System.out.println("• Merge Sort: Stable sort needed, guaranteed O(n log n)");
        System.out.println("• Quick Sort: General purpose, average case performance");
        System.out.println("• Arrays.sort(): Production code (uses optimized algorithms)");
    }
    
    /**
     * Demonstrates various sorting scenarios and optimizations
     */
    public static void sortingVariations() {
        
        // Sorting in descending order
        int[] descArray = {5, 2, 8, 1, 9, 3};
        System.out.println("Original: " + Arrays.toString(descArray));
        
        // Sort in descending order using Arrays.sort() with custom comparator
        Integer[] descBoxed = Arrays.stream(descArray).boxed().toArray(Integer[]::new);
        Arrays.sort(descBoxed, (a, b) -> b - a);
        System.out.println("Descending: " + Arrays.toString(descBoxed));
        
        // Sorting strings
        String[] names = {"Charlie", "Alice", "Bob", "Diana"};
        System.out.println("Original names: " + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("Sorted names: " + Arrays.toString(names));
        
        // Case-insensitive string sorting
        String[] mixedCase = {"charlie", "Alice", "BOB", "diana"};
        System.out.println("Mixed case: " + Arrays.toString(mixedCase));
        Arrays.sort(mixedCase, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive sort: " + Arrays.toString(mixedCase));
        
        // Partial array sorting
        int[] partialArray = {9, 5, 2, 8, 1, 7, 3, 6, 4};
        System.out.println("Original: " + Arrays.toString(partialArray));
        Arrays.sort(partialArray, 2, 6); // Sort elements from index 2 to 5
        System.out.println("Partial sort (index 2-5): " + Arrays.toString(partialArray));
        
        // Performance test with larger array
        System.out.println("\nPerformance test with 1000 elements:");
        int[] largeArray = generateRandomArray(1000);
        
        long startTime = System.nanoTime();
        Arrays.sort(largeArray.clone());
        long endTime = System.nanoTime();
        
        System.out.println("Arrays.sort() time: " + (endTime - startTime) / 1000000.0 + " ms");
    }
    
    /**
     * Utility method to generate random array for testing
     */
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Different sorting algorithms have different time/space complexities
 * 2. Choose algorithm based on data size, memory constraints, and stability needs
 * 3. Simple algorithms (bubble, selection, insertion) are O(n²) but easy to understand
 * 4. Advanced algorithms (merge, quick) are O(n log n) and more efficient for large data
 * 5. Arrays.sort() uses optimized algorithms and should be used in production
 * 
 * Algorithm Selection Guide:
 * - Small arrays (< 50): Insertion sort
 * - General purpose: Quick sort or Arrays.sort()
 * - Stability required: Merge sort
 * - Memory constrained: Heap sort
 * - Nearly sorted data: Insertion sort
 * 
 * Stability in Sorting:
 * - Stable: Maintains relative order of equal elements
 * - Unstable: May change relative order of equal elements
 * - Important when sorting objects with multiple fields
 * 
 * Optimization Tips:
 * - Use Arrays.sort() for production code
 * - Consider data characteristics (size, order, duplicates)
 * - For objects, implement Comparable or use Comparator
 * - Profile performance with actual data
 */
