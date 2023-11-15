/**
 * ArrayAdvanced.java - Advanced Array Techniques and Algorithms
 * 
 * Learning Objectives:
 * - Master advanced array manipulation techniques
 * - Learn sliding window and two-pointer algorithms
 * - Practice array optimization techniques
 * - Understand space-time complexity trade-offs
 * - Implement efficient array-based algorithms
 */

import java.util.*;

public class ArrayAdvanced {
    
    public static void main(String[] args) {
        
        System.out.println("=== Advanced Array Techniques ===\n");
        
        // ========== TWO POINTER TECHNIQUE ==========
        
        System.out.println("=== Two Pointer Technique ===");
        demonstrateTwoPointers();
        
        // ========== SLIDING WINDOW TECHNIQUE ==========
        
        System.out.println("\n=== Sliding Window Technique ===");
        demonstrateSlidingWindow();
        
        // ========== PREFIX SUM TECHNIQUE ==========
        
        System.out.println("\n=== Prefix Sum Technique ===");
        demonstratePrefixSum();
        
        // ========== ARRAY MANIPULATION TRICKS ==========
        
        System.out.println("\n=== Array Manipulation Tricks ===");
        demonstrateManipulationTricks();
        
        // ========== SPACE OPTIMIZATION ==========
        
        System.out.println("\n=== Space Optimization Techniques ===");
        demonstrateSpaceOptimization();
    }
    
    /**
     * Demonstrate two-pointer technique
     * Useful for: sorted arrays, palindromes, pair finding
     */
    public static void demonstrateTwoPointers() {
        System.out.println("Two-pointer technique is useful for:");
        System.out.println("- Finding pairs in sorted arrays");
        System.out.println("- Palindrome checking");
        System.out.println("- Reversing arrays");
        System.out.println("- Removing duplicates");
        System.out.println();
        
        // Example 1: Find pair with target sum in sorted array
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 16;
        
        System.out.println("Example 1: Find pair with sum " + target);
        System.out.println("Array: " + Arrays.toString(sortedArray));
        
        int[] pair = findPairWithSum(sortedArray, target);
        if (pair != null) {
            System.out.printf("Found pair: %d + %d = %d\n", pair[0], pair[1], target);
        } else {
            System.out.println("No pair found");
        }
        System.out.println();
        
        // Example 2: Check if string is palindrome
        String text = "racecar";
        boolean isPalindrome = isPalindromeUsingTwoPointers(text);
        System.out.println("Example 2: Palindrome check");
        System.out.printf("'%s' is %s palindrome\n", text, isPalindrome ? "a" : "not a");
        System.out.println();
        
        // Example 3: Remove duplicates from sorted array
        int[] arrayWithDuplicates = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        System.out.println("Example 3: Remove duplicates");
        System.out.println("Original: " + Arrays.toString(arrayWithDuplicates));
        int newLength = removeDuplicates(arrayWithDuplicates);
        System.out.print("After removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(arrayWithDuplicates[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Find pair with target sum using two pointers
     * Time: O(n), Space: O(1)
     */
    public static int[] findPairWithSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            if (sum == target) {
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;  // Need larger sum, move left pointer right
            } else {
                right--; // Need smaller sum, move right pointer left
            }
        }
        
        return null; // No pair found
    }
    
    /**
     * Check palindrome using two pointers
     * Time: O(n), Space: O(1)
     */
    public static boolean isPalindromeUsingTwoPointers(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Remove duplicates from sorted array in-place
     * Time: O(n), Space: O(1)
     */
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        
        int writeIndex = 1; // Position to write next unique element
        
        for (int readIndex = 1; readIndex < arr.length; readIndex++) {
            if (arr[readIndex] != arr[readIndex - 1]) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
        }
        
        return writeIndex; // New length of array without duplicates
    }
    
    /**
     * Demonstrate sliding window technique
     * Useful for: subarray problems, string problems
     */
    public static void demonstrateSlidingWindow() {
        System.out.println("Sliding window technique is useful for:");
        System.out.println("- Finding maximum/minimum in subarrays");
        System.out.println("- Substring problems");
        System.out.println("- Fixed-size window problems");
        System.out.println("- Variable-size window problems");
        System.out.println();
        
        // Example 1: Maximum sum of k consecutive elements
        int[] array = {2, 1, 5, 1, 3, 2, 7, 4};
        int k = 3;
        
        System.out.println("Example 1: Maximum sum of " + k + " consecutive elements");
        System.out.println("Array: " + Arrays.toString(array));
        
        int maxSum = maxSumOfKElements(array, k);
        System.out.println("Maximum sum: " + maxSum);
        System.out.println();
        
        // Example 2: Longest substring with at most k distinct characters
        String str = "aabbcc";
        int maxDistinct = 2;
        
        System.out.println("Example 2: Longest substring with at most " + maxDistinct + " distinct chars");
        System.out.println("String: " + str);
        
        int longestLength = longestSubstringWithKDistinct(str, maxDistinct);
        System.out.println("Longest length: " + longestLength);
    }
    
    /**
     * Find maximum sum of k consecutive elements using sliding window
     * Time: O(n), Space: O(1)
     */
    public static int maxSumOfKElements(int[] arr, int k) {
        if (arr.length < k) return -1;
        
        // Calculate sum of first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        
        // Slide the window: remove first element, add next element
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    /**
     * Longest substring with at most k distinct characters
     * Time: O(n), Space: O(k)
     */
    public static int longestSubstringWithKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) return 0;
        
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
            // Shrink window if we have more than k distinct characters
            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Demonstrate prefix sum technique
     * Useful for: range sum queries, subarray problems
     */
    public static void demonstratePrefixSum() {
        System.out.println("Prefix sum technique is useful for:");
        System.out.println("- Range sum queries in O(1) time");
        System.out.println("- Subarray sum problems");
        System.out.println("- Equilibrium index problems");
        System.out.println();
        
        int[] array = {1, 3, 5, 7, 9, 11};
        System.out.println("Array: " + Arrays.toString(array));
        
        // Build prefix sum array
        int[] prefixSum = buildPrefixSum(array);
        System.out.println("Prefix sum: " + Arrays.toString(prefixSum));
        System.out.println();
        
        // Answer range queries efficiently
        System.out.println("Range sum queries:");
        int[][] queries = {{1, 3}, {2, 5}, {0, 2}};
        
        for (int[] query : queries) {
            int left = query[0], right = query[1];
            int sum = rangeSum(prefixSum, left, right);
            System.out.printf("Sum from index %d to %d: %d\n", left, right, sum);
        }
    }
    
    /**
     * Build prefix sum array
     * prefixSum[i] = sum of elements from index 0 to i
     */
    public static int[] buildPrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        
        return prefixSum;
    }
    
    /**
     * Get range sum using prefix sum array
     * Time: O(1), Space: O(1)
     */
    public static int rangeSum(int[] prefixSum, int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
    
    /**
     * Demonstrate array manipulation tricks
     */
    public static void demonstrateManipulationTricks() {
        System.out.println("Useful array manipulation tricks:");
        System.out.println();
        
        // Trick 1: Reverse array in-place
        int[] array1 = {1, 2, 3, 4, 5};
        System.out.println("Trick 1: Reverse array in-place");
        System.out.println("Before: " + Arrays.toString(array1));
        reverseArray(array1);
        System.out.println("After: " + Arrays.toString(array1));
        System.out.println();
        
        // Trick 2: Rotate array
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        int rotateBy = 3;
        System.out.println("Trick 2: Rotate array right by " + rotateBy);
        System.out.println("Before: " + Arrays.toString(array2));
        rotateArrayRight(array2, rotateBy);
        System.out.println("After: " + Arrays.toString(array2));
        System.out.println();
        
        // Trick 3: Find missing number using XOR
        int[] arrayWithMissing = {1, 2, 4, 5, 6}; // Missing 3
        System.out.println("Trick 3: Find missing number using XOR");
        System.out.println("Array: " + Arrays.toString(arrayWithMissing));
        int missing = findMissingNumberXOR(arrayWithMissing, 6);
        System.out.println("Missing number: " + missing);
    }
    
    /**
     * Reverse array in-place using two pointers
     */
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
    /**
     * Rotate array right by k positions using reversal
     */
    public static void rotateArrayRight(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle k > n
        
        // Reverse entire array
        reverse(arr, 0, n - 1);
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse remaining elements
        reverse(arr, k, n - 1);
    }
    
    /**
     * Helper method to reverse array segment
     */
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Find missing number using XOR property
     * XOR of all numbers 1 to n with XOR of given array
     */
    public static int findMissingNumberXOR(int[] arr, int n) {
        int xorAll = 0, xorArray = 0;
        
        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }
        
        // XOR all numbers in array
        for (int num : arr) {
            xorArray ^= num;
        }
        
        // Missing number is XOR of both
        return xorAll ^ xorArray;
    }
    
    /**
     * Demonstrate space optimization techniques
     */
    public static void demonstrateSpaceOptimization() {
        System.out.println("Space optimization techniques:");
        System.out.println("- Use array indices as hash keys");
        System.out.println("- Modify input array instead of creating new one");
        System.out.println("- Use bit manipulation for boolean arrays");
        System.out.println();
        
        // Example: Mark visited elements using array indices
        int[] array = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Find duplicates using array indices as markers:");
        System.out.println("Array: " + Arrays.toString(array));
        
        List<Integer> duplicates = findDuplicatesUsingIndices(array.clone());
        System.out.println("Duplicates: " + duplicates);
        
        System.out.println("\n=== Advanced Array Techniques completed! ===");
    }
    
    /**
     * Find duplicates using array indices as markers
     * Time: O(n), Space: O(1)
     */
    public static List<Integer> findDuplicatesUsingIndices(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1; // Convert to 0-based index
            
            if (arr[index] < 0) {
                // Already marked as visited, so it's a duplicate
                duplicates.add(Math.abs(arr[i]));
            } else {
                // Mark as visited by making it negative
                arr[index] = -arr[index];
            }
        }
        
        return duplicates;
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Two Pointer Technique:
 *    - Useful for sorted arrays and palindromes
 *    - Reduces time complexity from O(n²) to O(n)
 *    - Space complexity: O(1)
 * 
 * 2. Sliding Window Technique:
 *    - Fixed window: for problems with fixed subarray size
 *    - Variable window: for problems with dynamic constraints
 *    - Reduces time complexity for subarray problems
 * 
 * 3. Prefix Sum Technique:
 *    - Precompute cumulative sums for O(1) range queries
 *    - Trade space for time (O(n) space for O(1) queries)
 *    - Useful for multiple range sum queries
 * 
 * 4. Space Optimization:
 *    - Use input array for marking/storing results
 *    - Array indices as hash keys
 *    - Bit manipulation for boolean arrays
 * 
 * 5. Common Patterns:
 *    - In-place algorithms save space
 *    - XOR properties for finding missing/duplicate numbers
 *    - Reversal technique for array rotation
 */
