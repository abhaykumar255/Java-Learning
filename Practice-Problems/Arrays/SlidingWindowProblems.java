/**
 * SlidingWindowProblems.java - Practice Problems using Sliding Window Technique
 * 
 * Learning Objectives:
 * - Master sliding window technique for array/string problems
 * - Practice both fixed and variable size window problems
 * - Understand when to use sliding window approach
 * - Solve common interview questions efficiently
 * - Optimize time complexity from O(n²) to O(n)
 */

import java.util.*;

public class SlidingWindowProblems {
    
    public static void main(String[] args) {
        
        System.out.println("=== Sliding Window Practice Problems ===\n");
        
        // ========== FIXED SIZE WINDOW PROBLEMS ==========
        
        System.out.println("=== Fixed Size Window Problems ===");
        solveFixedWindowProblems();
        
        // ========== VARIABLE SIZE WINDOW PROBLEMS ==========
        
        System.out.println("\n=== Variable Size Window Problems ===");
        solveVariableWindowProblems();
        
        // ========== STRING SLIDING WINDOW PROBLEMS ==========
        
        System.out.println("\n=== String Sliding Window Problems ===");
        solveStringWindowProblems();
        
        // ========== ADVANCED SLIDING WINDOW PROBLEMS ==========
        
        System.out.println("\n=== Advanced Sliding Window Problems ===");
        solveAdvancedWindowProblems();
    }
    
    /**
     * Fixed size window problems
     */
    public static void solveFixedWindowProblems() {
        
        // Problem 1: Maximum sum of k consecutive elements
        System.out.println("Problem 1: Maximum sum of k consecutive elements");
        int[] arr1 = {2, 1, 5, 1, 3, 2, 7, 4, 6};
        int k1 = 3;
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("k = " + k1);
        
        int maxSum = maxSumOfKElements(arr1, k1);
        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
        
        // Problem 2: Average of all subarrays of size k
        System.out.println("Problem 2: Average of all subarrays of size k");
        int[] arr2 = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k2 = 5;
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("k = " + k2);
        
        double[] averages = findAverages(arr2, k2);
        System.out.println("Averages: " + Arrays.toString(averages));
        System.out.println();
        
        // Problem 3: Maximum of all subarrays of size k
        System.out.println("Problem 3: Maximum of all subarrays of size k");
        int[] arr3 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k3 = 3;
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("k = " + k3);
        
        int[] maxElements = maxInAllSubarrays(arr3, k3);
        System.out.println("Maximum elements: " + Arrays.toString(maxElements));
        System.out.println();
    }
    
    /**
     * Maximum sum of k consecutive elements
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
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    /**
     * Find averages of all subarrays of size k
     */
    public static double[] findAverages(int[] arr, int k) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        
        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        result[0] = windowSum / k;
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum - arr[i - k] + arr[i];
            result[i - k + 1] = windowSum / k;
        }
        
        return result;
    }
    
    /**
     * Maximum element in all subarrays of size k using deque
     */
    public static int[] maxInAllSubarrays(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // Store indices
        
        for (int i = 0; i < arr.length; i++) {
            // Remove indices outside current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
            // Remove indices of smaller elements
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add to result if window is complete
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    /**
     * Variable size window problems
     */
    public static void solveVariableWindowProblems() {
        
        // Problem 1: Smallest subarray with sum >= target
        System.out.println("Problem 1: Smallest subarray with sum >= target");
        int[] arr1 = {2, 1, 2, 4, 3, 1};
        int target1 = 7;
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Target: " + target1);
        
        int minLength = minSubArrayLen(target1, arr1);
        System.out.println("Minimum length: " + minLength);
        System.out.println();
        
        // Problem 2: Longest subarray with at most k distinct elements
        System.out.println("Problem 2: Longest subarray with at most k distinct elements");
        int[] arr2 = {1, 2, 1, 2, 3};
        int k2 = 2;
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("k = " + k2);
        
        int maxLength = longestSubarrayWithKDistinct(arr2, k2);
        System.out.println("Maximum length: " + maxLength);
        System.out.println();
        
        // Problem 3: Maximum sum subarray of size at most k
        System.out.println("Problem 3: Maximum sum subarray of size at most k");
        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 3;
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("k = " + k3);
        
        int maxSum = maxSumSubarrayOfSizeK(arr3, k3);
        System.out.println("Maximum sum: " + maxSum);
        System.out.println();
    }
    
    /**
     * Smallest subarray with sum >= target
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    /**
     * Longest subarray with at most k distinct elements
     */
    public static int longestSubarrayWithKDistinct(int[] arr, int k) {
        Map<Integer, Integer> elementCount = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < arr.length; right++) {
            elementCount.put(arr[right], elementCount.getOrDefault(arr[right], 0) + 1);
            
            while (elementCount.size() > k) {
                int leftElement = arr[left];
                elementCount.put(leftElement, elementCount.get(leftElement) - 1);
                if (elementCount.get(leftElement) == 0) {
                    elementCount.remove(leftElement);
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Maximum sum subarray of size at most k
     */
    public static int maxSumSubarrayOfSizeK(int[] arr, int k) {
        int maxSum = 0;
        
        for (int size = 1; size <= k; size++) {
            int windowSum = 0;
            
            // Calculate sum of first window of this size
            for (int i = 0; i < size; i++) {
                windowSum += arr[i];
            }
            maxSum = Math.max(maxSum, windowSum);
            
            // Slide window of this size
            for (int i = size; i < arr.length; i++) {
                windowSum = windowSum - arr[i - size] + arr[i];
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        
        return maxSum;
    }
    
    /**
     * String sliding window problems
     */
    public static void solveStringWindowProblems() {
        
        // Problem 1: Longest substring without repeating characters
        System.out.println("Problem 1: Longest substring without repeating characters");
        String s1 = "abcabcbb";
        System.out.println("String: " + s1);
        
        int length1 = lengthOfLongestSubstring(s1);
        System.out.println("Length: " + length1);
        System.out.println();
        
        // Problem 2: Minimum window substring
        System.out.println("Problem 2: Minimum window substring");
        String s2 = "ADOBECODEBANC";
        String t2 = "ABC";
        System.out.println("String: " + s2);
        System.out.println("Pattern: " + t2);
        
        String minWindow = minWindow(s2, t2);
        System.out.println("Minimum window: " + minWindow);
        System.out.println();
        
        // Problem 3: Longest substring with at most k distinct characters
        System.out.println("Problem 3: Longest substring with at most k distinct characters");
        String s3 = "eceba";
        int k3 = 2;
        System.out.println("String: " + s3);
        System.out.println("k = " + k3);
        
        int length3 = lengthOfLongestSubstringKDistinct(s3, k3);
        System.out.println("Length: " + length3);
        System.out.println();
    }
    
    /**
     * Longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Minimum window substring
     */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        int left = 0, right = 0, valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                
                char d = s.charAt(left);
                left++;
                
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
    
    /**
     * Longest substring with at most k distinct characters
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            
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
     * Advanced sliding window problems
     */
    public static void solveAdvancedWindowProblems() {
        System.out.println("Advanced problems combine sliding window with other techniques:");
        System.out.println("- Sliding window + two pointers");
        System.out.println("- Sliding window + hash map");
        System.out.println("- Sliding window + deque");
        System.out.println("- Sliding window + binary search");
        System.out.println();
        
        System.out.println("Practice these patterns to master sliding window technique!");
        System.out.println("Key insight: Expand window to find candidates, shrink to optimize");
        
        System.out.println("\n=== Sliding Window Problems completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Sliding Window Technique:
 *    - Optimizes O(n²) brute force to O(n)
 *    - Two types: fixed size and variable size
 *    - Use two pointers (left and right) to maintain window
 * 
 * 2. Fixed Size Window:
 *    - Window size is constant
 *    - Slide by removing left element and adding right element
 *    - Examples: max sum of k elements, averages
 * 
 * 3. Variable Size Window:
 *    - Window size changes based on condition
 *    - Expand window to find candidates
 *    - Shrink window to optimize result
 * 
 * 4. Common Patterns:
 *    - Use HashMap for character/element counting
 *    - Use Deque for maintaining max/min in window
 *    - Use Set for checking duplicates
 * 
 * 5. Problem Types:
 *    - Subarray/substring with specific sum/length
 *    - Finding max/min in all windows
 *    - String pattern matching
 *    - Distinct elements in window
 */
