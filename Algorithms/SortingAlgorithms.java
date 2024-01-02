/**
 * SortingAlgorithms.java - Implementation of Various Sorting Algorithms
 * 
 * Learning Objectives:
 * - Understand different sorting algorithm approaches
 * - Implement and compare sorting algorithms
 * - Analyze time and space complexities
 * - Learn when to use which sorting algorithm
 * - Practice algorithm optimization techniques
 */

import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {
    
    public static void main(String[] args) {
        
        System.out.println("=== Sorting Algorithms Implementation ===\n");
        
        // Test array for demonstrations
        int[] testArray = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 33};
        
        System.out.println("Original array: " + Arrays.toString(testArray));
        System.out.println();
        
        // ========== BUBBLE SORT ==========
        
        System.out.println("=== Bubble Sort ===");
        int[] bubbleArray = testArray.clone();
        long startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long endTime = System.nanoTime();
        System.out.println("Sorted: " + Arrays.toString(bubbleArray));
        System.out.println("Time: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // ========== SELECTION SORT ==========
        
        System.out.println("=== Selection Sort ===");
        int[] selectionArray = testArray.clone();
        startTime = System.nanoTime();
        selectionSort(selectionArray);
        endTime = System.nanoTime();
        System.out.println("Sorted: " + Arrays.toString(selectionArray));
        System.out.println("Time: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // ========== INSERTION SORT ==========
        
        System.out.println("=== Insertion Sort ===");
        int[] insertionArray = testArray.clone();
        startTime = System.nanoTime();
        insertionSort(insertionArray);
        endTime = System.nanoTime();
        System.out.println("Sorted: " + Arrays.toString(insertionArray));
        System.out.println("Time: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // ========== MERGE SORT ==========
        
        System.out.println("=== Merge Sort ===");
        int[] mergeArray = testArray.clone();
        startTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Sorted: " + Arrays.toString(mergeArray));
        System.out.println("Time: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // ========== QUICK SORT ==========
        
        System.out.println("=== Quick Sort ===");
        int[] quickArray = testArray.clone();
        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        System.out.println("Sorted: " + Arrays.toString(quickArray));
        System.out.println("Time: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // ========== HEAP SORT ==========
        
        System.out.println("=== Heap Sort ===");
        int[] heapArray = testArray.clone();
        startTime = System.nanoTime();
        heapSort(heapArray);
        endTime = System.nanoTime();
        System.out.println("Sorted: " + Arrays.toString(heapArray));
        System.out.println("Time: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("=== Performance Comparison ===");
        performanceComparison();
        
        // ========== ALGORITHM ANALYSIS ==========
        
        System.out.println("\n=== Algorithm Analysis ===");
        algorithmAnalysis();
        
        System.out.println("\n=== Sorting Algorithms lesson completed! ===");
    }
    
    /**
     * Bubble Sort - Simple comparison-based algorithm
     * Time Complexity: O(n²) average and worst case, O(n) best case
     * Space Complexity: O(1)
     * Stable: Yes
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Last i elements are already in place
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Selection Sort - Find minimum and place at beginning
     * Time Complexity: O(n²) for all cases
     * Space Complexity: O(1)
     * Stable: No
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in remaining array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap minimum element with first element
            if (minIndex != i) {
                swap(arr, minIndex, i);
            }
        }
    }
    
    /**
     * Insertion Sort - Build sorted array one element at a time
     * Time Complexity: O(n²) average and worst case, O(n) best case
     * Space Complexity: O(1)
     * Stable: Yes
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            
            arr[j + 1] = key;
        }
    }
    
    /**
     * Merge Sort - Divide and conquer algorithm
     * Time Complexity: O(n log n) for all cases
     * Space Complexity: O(n)
     * Stable: Yes
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find middle point
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
    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);
        
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
     * Quick Sort - Divide and conquer with partitioning
     * Time Complexity: O(n log n) average case, O(n²) worst case
     * Space Complexity: O(log n) average case
     * Stable: No
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
    private static int partition(int[] arr, int low, int high) {
        // Choose rightmost element as pivot
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Place pivot in correct position
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    /**
     * Heap Sort - Uses binary heap data structure
     * Time Complexity: O(n log n) for all cases
     * Space Complexity: O(1)
     * Stable: No
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);
            
            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    /**
     * Helper method to maintain heap property
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child
        
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    /**
     * Utility method to swap two elements in array
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Performance comparison of different sorting algorithms
     */
    public static void performanceComparison() {
        int[] sizes = {100, 1000, 5000};
        
        System.out.println("Performance Comparison (milliseconds):");
        System.out.println("┌─────────────────┬─────────┬─────────┬─────────┐");
        System.out.println("│ Algorithm       │ 100 els │ 1K els  │ 5K els  │");
        System.out.println("├─────────────────┼─────────┼─────────┼─────────┤");
        
        for (int size : sizes) {
            int[] testData = generateRandomArray(size);
            
            if (size == 100) {
                System.out.printf("│ Bubble Sort     │ %7.2f │", measureSortTime(() -> bubbleSort(testData.clone())));
            }
            if (size <= 1000) {
                System.out.printf(" %7.2f │", measureSortTime(() -> bubbleSort(testData.clone())));
            }
            if (size <= 5000) {
                System.out.printf(" %7.2f │%n", measureSortTime(() -> bubbleSort(testData.clone())));
            }
        }
        
        // Add more algorithms...
        System.out.println("│ Selection Sort  │   ...   │   ...   │   ...   │");
        System.out.println("│ Insertion Sort  │   ...   │   ...   │   ...   │");
        System.out.println("│ Merge Sort      │   ...   │   ...   │   ...   │");
        System.out.println("│ Quick Sort      │   ...   │   ...   │   ...   │");
        System.out.println("│ Heap Sort       │   ...   │   ...   │   ...   │");
        System.out.println("└─────────────────┴─────────┴─────────┴─────────┘");
        
        System.out.println("\nNote: Actual performance depends on hardware and data characteristics");
    }
    
    /**
     * Measures execution time of a sorting algorithm
     */
    private static double measureSortTime(Runnable sortMethod) {
        long startTime = System.nanoTime();
        sortMethod.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000.0; // Convert to milliseconds
    }
    
    /**
     * Generates random array for testing
     */
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
    
    /**
     * Comprehensive algorithm analysis
     */
    public static void algorithmAnalysis() {
        System.out.println("Sorting Algorithm Characteristics:");
        System.out.println();
        
        System.out.println("Time Complexity Summary:");
        System.out.println("┌─────────────────┬─────────────┬─────────────┬─────────────┐");
        System.out.println("│ Algorithm       │ Best Case   │ Average Case│ Worst Case  │");
        System.out.println("├─────────────────┼─────────────┼─────────────┼─────────────┤");
        System.out.println("│ Bubble Sort     │ O(n)        │ O(n²)       │ O(n²)       │");
        System.out.println("│ Selection Sort  │ O(n²)       │ O(n²)       │ O(n²)       │");
        System.out.println("│ Insertion Sort  │ O(n)        │ O(n²)       │ O(n²)       │");
        System.out.println("│ Merge Sort      │ O(n log n)  │ O(n log n)  │ O(n log n)  │");
        System.out.println("│ Quick Sort      │ O(n log n)  │ O(n log n)  │ O(n²)       │");
        System.out.println("│ Heap Sort       │ O(n log n)  │ O(n log n)  │ O(n log n)  │");
        System.out.println("└─────────────────┴─────────────┴─────────────┴─────────────┘");
        
        System.out.println("\nSpace Complexity and Stability:");
        System.out.println("┌─────────────────┬─────────────┬─────────┐");
        System.out.println("│ Algorithm       │ Space       │ Stable  │");
        System.out.println("├─────────────────┼─────────────┼─────────┤");
        System.out.println("│ Bubble Sort     │ O(1)        │ Yes     │");
        System.out.println("│ Selection Sort  │ O(1)        │ No      │");
        System.out.println("│ Insertion Sort  │ O(1)        │ Yes     │");
        System.out.println("│ Merge Sort      │ O(n)        │ Yes     │");
        System.out.println("│ Quick Sort      │ O(log n)    │ No      │");
        System.out.println("│ Heap Sort       │ O(1)        │ No      │");
        System.out.println("└─────────────────┴─────────────┴─────────┘");
        
        System.out.println("\nAlgorithm Selection Guide:");
        System.out.println("• Small arrays (< 50): Insertion Sort");
        System.out.println("• General purpose: Quick Sort or Merge Sort");
        System.out.println("• Stability required: Merge Sort");
        System.out.println("• Memory constrained: Heap Sort");
        System.out.println("• Nearly sorted data: Insertion Sort");
        System.out.println("• Guaranteed O(n log n): Merge Sort or Heap Sort");
        System.out.println("• Production code: Arrays.sort() (hybrid algorithms)");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Different sorting algorithms have different trade-offs
 * 2. Time complexity varies based on input characteristics
 * 3. Space complexity affects memory usage
 * 4. Stability preserves relative order of equal elements
 * 5. Choose algorithm based on specific requirements
 * 
 * Algorithm Categories:
 * - Simple sorts: Bubble, Selection, Insertion (O(n²))
 * - Efficient sorts: Merge, Quick, Heap (O(n log n))
 * - Specialized sorts: Counting, Radix, Bucket (linear time for specific data)
 * 
 * Practical Considerations:
 * - Input size and characteristics
 * - Memory constraints
 * - Stability requirements
 * - Implementation complexity
 * - Real-world performance vs theoretical complexity
 * 
 * Optimization Techniques:
 * - Hybrid algorithms (use different sorts for different sizes)
 * - Adaptive algorithms (perform better on partially sorted data)
 * - Parallel sorting for multi-core systems
 * - External sorting for data larger than memory
 */
