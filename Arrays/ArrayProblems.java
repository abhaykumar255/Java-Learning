/**
 * ArrayProblems.java - Common Array Problems and Solutions
 * 
 * Learning Objectives:
 * - Solve frequently asked array problems in interviews
 * - Practice different problem-solving techniques
 * - Understand time and space complexity optimization
 * - Learn common array manipulation patterns
 * - Master sliding window and two-pointer techniques
 */

import java.util.*;

public class ArrayProblems {
    
    public static void main(String[] args) {
        
        System.out.println("=== Common Array Problems and Solutions ===\n");
        
        // ========== TWO SUM PROBLEM ==========
        
        System.out.println("=== Problem 1: Two Sum ===");
        twoSumProblem();
        
        // ========== ARRAY ROTATION ==========
        
        System.out.println("\n=== Problem 2: Array Rotation ===");
        arrayRotationProblem();
        
        // ========== MISSING NUMBER ==========
        
        System.out.println("\n=== Problem 3: Find Missing Number ===");
        missingNumberProblem();
        
        // ========== DUPLICATE REMOVAL ==========
        
        System.out.println("\n=== Problem 4: Remove Duplicates ===");
        removeDuplicatesProblem();
        
        // ========== MAXIMUM SUBARRAY ==========
        
        System.out.println("\n=== Problem 5: Maximum Subarray Sum (Kadane's Algorithm) ===");
        maximumSubarrayProblem();
        
        // ========== SLIDING WINDOW PROBLEMS ==========
        
        System.out.println("\n=== Problem 6: Sliding Window Maximum ===");
        slidingWindowProblem();
        
        // ========== ARRAY INTERSECTION ==========
        
        System.out.println("\n=== Problem 7: Array Intersection ===");
        arrayIntersectionProblem();
        
        // ========== MOVE ZEROS ==========
        
        System.out.println("\n=== Problem 8: Move Zeros to End ===");
        moveZerosProblem();
        
        System.out.println("\n=== Array Problems lesson completed! ===");
    }
    
    /**
     * Problem 1: Two Sum
     * Given an array and target sum, find two numbers that add up to target
     */
    public static void twoSumProblem() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        // Solution 1: Brute Force - O(n²)
        int[] result1 = twoSumBruteForce(nums, target);
        System.out.println("Brute Force Solution: " + Arrays.toString(result1));
        
        // Solution 2: Hash Map - O(n)
        int[] result2 = twoSumHashMap(nums, target);
        System.out.println("Hash Map Solution: " + Arrays.toString(result2));
        
        // Solution 3: Two Pointers (for sorted array) - O(n)
        int[] sortedNums = {2, 7, 11, 15}; // Already sorted
        int[] result3 = twoSumTwoPointers(sortedNums, target);
        System.out.println("Two Pointers Solution: " + Arrays.toString(result3));
    }
    
    /**
     * Two Sum - Brute Force Approach
     * Time: O(n²), Space: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * Two Sum - Hash Map Approach
     * Time: O(n), Space: O(n)
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    
    /**
     * Two Sum - Two Pointers (for sorted array)
     * Time: O(n), Space: O(1)
     */
    public static int[] twoSumTwoPointers(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
    
    /**
     * Problem 2: Array Rotation
     * Rotate array to the right by k steps
     */
    public static void arrayRotationProblem() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Rotate right by " + k + " steps");
        
        // Solution 1: Using extra space
        int[] rotated1 = rotateArrayExtraSpace(nums.clone(), k);
        System.out.println("Extra Space Solution: " + Arrays.toString(rotated1));
        
        // Solution 2: In-place rotation using reversal
        int[] nums2 = nums.clone();
        rotateArrayInPlace(nums2, k);
        System.out.println("In-place Solution: " + Arrays.toString(nums2));
        
        // Left rotation example
        int[] nums3 = nums.clone();
        rotateArrayLeft(nums3, k);
        System.out.println("Left rotation by " + k + ": " + Arrays.toString(nums3));
    }
    
    /**
     * Rotate array using extra space
     * Time: O(n), Space: O(n)
     */
    public static int[] rotateArrayExtraSpace(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle k > n
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        return result;
    }
    
    /**
     * Rotate array in-place using reversal technique
     * Time: O(n), Space: O(1)
     */
    public static void rotateArrayInPlace(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, n - 1);
    }
    
    /**
     * Rotate array to the left
     */
    public static void rotateArrayLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    /**
     * Helper method to reverse array elements
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * Problem 3: Find Missing Number
     * Given array containing n distinct numbers from 0 to n, find missing number
     */
    public static void missingNumberProblem() {
        int[] nums = {3, 0, 1}; // Missing 2
        
        System.out.println("Array: " + Arrays.toString(nums));
        
        // Solution 1: Sum formula
        int missing1 = findMissingNumberSum(nums);
        System.out.println("Sum Formula Solution: " + missing1);
        
        // Solution 2: XOR approach
        int missing2 = findMissingNumberXOR(nums);
        System.out.println("XOR Solution: " + missing2);
        
        // Solution 3: Binary search (for sorted array)
        int[] sortedNums = {0, 1, 3, 4, 5}; // Missing 2
        System.out.println("Sorted array: " + Arrays.toString(sortedNums));
        int missing3 = findMissingNumberBinarySearch(sortedNums);
        System.out.println("Binary Search Solution: " + missing3);
    }
    
    /**
     * Find missing number using sum formula
     * Time: O(n), Space: O(1)
     */
    public static int findMissingNumberSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    /**
     * Find missing number using XOR
     * Time: O(n), Space: O(1)
     */
    public static int findMissingNumberXOR(int[] nums) {
        int xor = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        
        return xor;
    }
    
    /**
     * Find missing number using binary search (sorted array)
     * Time: O(log n), Space: O(1)
     */
    public static int findMissingNumberBinarySearch(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    /**
     * Problem 4: Remove Duplicates
     * Remove duplicates from sorted array in-place
     */
    public static void removeDuplicatesProblem() {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};
        
        System.out.println("Original array: " + Arrays.toString(nums));
        
        int newLength = removeDuplicates(nums);
        System.out.println("After removing duplicates: " + 
                          Arrays.toString(Arrays.copyOf(nums, newLength)));
        System.out.println("New length: " + newLength);
        
        // Remove duplicates from unsorted array
        int[] unsorted = {4, 2, 1, 2, 3, 4, 1};
        System.out.println("\nUnsorted array: " + Arrays.toString(unsorted));
        List<Integer> unique = removeDuplicatesUnsorted(unsorted);
        System.out.println("Unique elements: " + unique);
    }
    
    /**
     * Remove duplicates from sorted array
     * Time: O(n), Space: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int writeIndex = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        
        return writeIndex;
    }
    
    /**
     * Remove duplicates from unsorted array
     * Time: O(n), Space: O(n)
     */
    public static List<Integer> removeDuplicatesUnsorted(int[] nums) {
        Set<Integer> seen = new LinkedHashSet<>();
        
        for (int num : nums) {
            seen.add(num);
        }
        
        return new ArrayList<>(seen);
    }
    
    /**
     * Problem 5: Maximum Subarray Sum (Kadane's Algorithm)
     * Find contiguous subarray with largest sum
     */
    public static void maximumSubarrayProblem() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        System.out.println("Array: " + Arrays.toString(nums));
        
        int maxSum = maxSubarraySum(nums);
        System.out.println("Maximum subarray sum: " + maxSum);
        
        // Also find the actual subarray
        int[] subarray = maxSubarray(nums);
        System.out.println("Maximum subarray: " + Arrays.toString(subarray));
    }
    
    /**
     * Kadane's Algorithm for maximum subarray sum
     * Time: O(n), Space: O(1)
     */
    public static int maxSubarraySum(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    /**
     * Find the actual maximum subarray
     */
    public static int[] maxSubarray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0, tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                tempStart = i;
            } else {
                currentSum += nums[i];
            }
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        
        return Arrays.copyOfRange(nums, start, end + 1);
    }
    
    /**
     * Problem 6: Sliding Window Maximum
     * Find maximum in each sliding window of size k
     */
    public static void slidingWindowProblem() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Window size: " + k);
        
        int[] result = slidingWindowMaximum(nums, k);
        System.out.println("Sliding window maximums: " + Arrays.toString(result));
        
        // Also demonstrate sliding window sum
        int[] sums = slidingWindowSum(nums, k);
        System.out.println("Sliding window sums: " + Arrays.toString(sums));
    }
    
    /**
     * Sliding window maximum using deque
     * Time: O(n), Space: O(k)
     */
    public static int[] slidingWindowMaximum(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove elements outside current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove smaller elements from rear
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add to result if window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    /**
     * Sliding window sum
     * Time: O(n), Space: O(1)
     */
    public static int[] slidingWindowSum(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        
        // Calculate first window sum
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        result[0] = windowSum;
        
        // Slide the window
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            result[i - k + 1] = windowSum;
        }
        
        return result;
    }
    
    /**
     * Problem 7: Array Intersection
     * Find intersection of two arrays
     */
    public static void arrayIntersectionProblem() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        
        System.out.println("Array 1: " + Arrays.toString(nums1));
        System.out.println("Array 2: " + Arrays.toString(nums2));
        
        // Intersection (unique elements)
        int[] intersection = arrayIntersection(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(intersection));
        
        // Intersection with duplicates
        int[] intersectionII = arrayIntersectionII(nums1, nums2);
        System.out.println("Intersection with duplicates: " + Arrays.toString(intersectionII));
    }
    
    /**
     * Array intersection (unique elements)
     * Time: O(n + m), Space: O(min(n, m))
     */
    public static int[] arrayIntersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Array intersection with duplicates
     * Time: O(n + m), Space: O(min(n, m))
     */
    public static int[] arrayIntersectionII(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    /**
     * Problem 8: Move Zeros to End
     * Move all zeros to end while maintaining relative order
     */
    public static void moveZerosProblem() {
        int[] nums = {0, 1, 0, 3, 12};
        
        System.out.println("Original array: " + Arrays.toString(nums));
        
        moveZeros(nums);
        System.out.println("After moving zeros: " + Arrays.toString(nums));
        
        // Alternative approach
        int[] nums2 = {0, 1, 0, 3, 12};
        moveZerosAlternative(nums2);
        System.out.println("Alternative approach: " + Arrays.toString(nums2));
    }
    
    /**
     * Move zeros to end (two pointers)
     * Time: O(n), Space: O(1)
     */
    public static void moveZeros(int[] nums) {
        int writeIndex = 0;
        
        // Move all non-zero elements to front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        
        // Fill remaining positions with zeros
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
    
    /**
     * Move zeros to end (swap approach)
     * Time: O(n), Space: O(1)
     */
    public static void moveZerosAlternative(int[] nums) {
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Many array problems can be solved with multiple approaches
 * 2. Two pointers technique is very powerful for array problems
 * 3. Hash maps can reduce time complexity from O(n²) to O(n)
 * 4. Sliding window technique is useful for subarray problems
 * 5. In-place algorithms save space but may be more complex
 * 
 * Common Problem-Solving Patterns:
 * - Two Pointers: For sorted arrays, finding pairs
 * - Sliding Window: For subarray problems with fixed/variable size
 * - Hash Map: For frequency counting, lookups
 * - Kadane's Algorithm: For maximum subarray problems
 * - Binary Search: For sorted arrays, finding elements
 * 
 * Time Complexity Optimization:
 * - Brute Force: O(n²) → Hash Map: O(n)
 * - Nested Loops: O(n²) → Two Pointers: O(n)
 * - Linear Search: O(n) → Binary Search: O(log n)
 * 
 * Space Complexity Considerations:
 * - Extra space vs in-place algorithms
 * - Trade-offs between time and space
 * - When to use additional data structures
 */
