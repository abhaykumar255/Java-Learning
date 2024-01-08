/**
 * TwoSum.java - Two Sum Problem and Variations
 * 
 * Problem Statement:
 * Given an array of integers and a target sum, find two numbers that add up to the target.
 * Return the indices of the two numbers.
 * 
 * Difficulty: Easy ⭐
 * 
 * Learning Objectives:
 * - Practice array traversal and searching
 * - Understand hash map optimization techniques
 * - Learn multiple solution approaches
 * - Analyze time and space complexity trade-offs
 */

import java.util.*;

public class TwoSum {
    
    public static void main(String[] args) {
        
        System.out.println("=== Two Sum Problem and Variations ===\n");
        
        // Test cases
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        
        int[] nums3 = {3, 3};
        int target3 = 6;
        
        int[] nums4 = {1, 5, 3, 8, 2, 9, 4};
        int target4 = 10;
        
        // ========== BASIC TWO SUM ==========
        
        System.out.println("=== Basic Two Sum Problem ===");
        testTwoSumSolutions(nums1, target1);
        testTwoSumSolutions(nums2, target2);
        testTwoSumSolutions(nums3, target3);
        
        // ========== TWO SUM VARIATIONS ==========
        
        System.out.println("\n=== Two Sum Variations ===");
        twoSumVariations(nums4, target4);
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("\n=== Performance Comparison ===");
        performanceComparison();
        
        System.out.println("\n=== Two Sum lesson completed! ===");
    }
    
    /**
     * Tests all two sum solution approaches
     */
    public static void testTwoSumSolutions(int[] nums, int target) {
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        // Solution 1: Brute Force
        int[] result1 = twoSumBruteForce(nums, target);
        System.out.println("Brute Force: " + Arrays.toString(result1));
        
        // Solution 2: Hash Map (One Pass)
        int[] result2 = twoSumHashMap(nums, target);
        System.out.println("Hash Map: " + Arrays.toString(result2));
        
        // Solution 3: Two Pointers (for sorted array)
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        int[] result3 = twoSumTwoPointers(sortedNums, target);
        System.out.println("Two Pointers (sorted): " + Arrays.toString(result3));
        
        System.out.println();
    }
    
    /**
     * Solution 1: Brute Force Approach
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     * 
     * Approach:
     * - Check every pair of numbers
     * - Return indices when sum equals target
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Not found
    }
    
    /**
     * Solution 2: Hash Map Approach (One Pass)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Approach:
     * - Use hash map to store number and its index
     * - For each number, check if complement exists in map
     * - If found, return current index and complement's index
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
        
        return new int[]{-1, -1}; // Not found
    }
    
    /**
     * Solution 3: Two Pointers Approach (for sorted array)
     * Time Complexity: O(n log n) for sorting + O(n) for two pointers = O(n log n)
     * Space Complexity: O(1) if sorting in-place
     * 
     * Approach:
     * - Sort the array first
     * - Use two pointers from start and end
     * - Move pointers based on sum comparison with target
     * 
     * Note: This approach loses original indices due to sorting
     */
    public static int[] twoSumTwoPointers(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
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
        
        return new int[]{-1, -1}; // Not found
    }
    
    /**
     * Demonstrates various two sum problem variations
     */
    public static void twoSumVariations(int[] nums, int target) {
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);
        
        // Variation 1: Find all pairs that sum to target
        System.out.println("\n--- Find All Pairs ---");
        List<int[]> allPairs = findAllTwoSumPairs(nums, target);
        for (int[] pair : allPairs) {
            System.out.println("Pair: " + Arrays.toString(pair) + 
                             " -> " + nums[pair[0]] + " + " + nums[pair[1]] + " = " + target);
        }
        
        // Variation 2: Count pairs that sum to target
        System.out.println("\n--- Count Pairs ---");
        int pairCount = countTwoSumPairs(nums, target);
        System.out.println("Number of pairs: " + pairCount);
        
        // Variation 3: Two sum with duplicates allowed
        System.out.println("\n--- Two Sum with Duplicates ---");
        int[] numsWithDuplicates = {1, 1, 2, 2, 3, 3, 4, 4};
        int targetDup = 5;
        System.out.println("Array with duplicates: " + Arrays.toString(numsWithDuplicates));
        System.out.println("Target: " + targetDup);
        List<int[]> duplicatePairs = findAllTwoSumPairs(numsWithDuplicates, targetDup);
        for (int[] pair : duplicatePairs) {
            System.out.println("Pair: " + Arrays.toString(pair));
        }
        
        // Variation 4: Two sum closest to target
        System.out.println("\n--- Two Sum Closest to Target ---");
        int[] closestPair = twoSumClosest(nums, target + 3); // Target + 3 to show closest
        if (closestPair[0] != -1) {
            int sum = nums[closestPair[0]] + nums[closestPair[1]];
            System.out.println("Closest pair: " + Arrays.toString(closestPair) + 
                             " -> sum = " + sum + " (target was " + (target + 3) + ")");
        }
    }
    
    /**
     * Finds all pairs that sum to target
     * Time Complexity: O(n²)
     * Space Complexity: O(k) where k is number of pairs
     */
    public static List<int[]> findAllTwoSumPairs(int[] nums, int target) {
        List<int[]> pairs = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    pairs.add(new int[]{i, j});
                }
            }
        }
        
        return pairs;
    }
    
    /**
     * Counts pairs that sum to target
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int countTwoSumPairs(int[] nums, int target) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * Finds pair with sum closest to target
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static int[] twoSumClosest(int[] nums, int target) {
        int[] closestPair = {-1, -1};
        int minDifference = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int difference = Math.abs(sum - target);
                
                if (difference < minDifference) {
                    minDifference = difference;
                    closestPair[0] = i;
                    closestPair[1] = j;
                }
            }
        }
        
        return closestPair;
    }
    
    /**
     * Performance comparison between different approaches
     */
    public static void performanceComparison() {
        int[] sizes = {100, 1000, 5000};
        
        System.out.println("Performance Comparison:");
        System.out.println("┌─────────────┬─────────────┬─────────────┬─────────────┐");
        System.out.println("│ Array Size  │ Brute Force │ Hash Map    │ Two Pointers│");
        System.out.println("├─────────────┼─────────────┼─────────────┼─────────────┤");
        
        for (int size : sizes) {
            int[] testArray = generateTestArray(size);
            int target = testArray[0] + testArray[size - 1]; // Ensure solution exists
            
            // Measure brute force
            long startTime = System.nanoTime();
            twoSumBruteForce(testArray, target);
            long bruteForceTime = System.nanoTime() - startTime;
            
            // Measure hash map
            startTime = System.nanoTime();
            twoSumHashMap(testArray, target);
            long hashMapTime = System.nanoTime() - startTime;
            
            // Measure two pointers (including sort time)
            startTime = System.nanoTime();
            int[] sortedArray = testArray.clone();
            Arrays.sort(sortedArray);
            twoSumTwoPointers(sortedArray, target);
            long twoPointersTime = System.nanoTime() - startTime;
            
            System.out.printf("│ %11d │ %9.2f ms │ %9.2f ms │ %9.2f ms │%n",
                            size,
                            bruteForceTime / 1000000.0,
                            hashMapTime / 1000000.0,
                            twoPointersTime / 1000000.0);
        }
        
        System.out.println("└─────────────┴─────────────┴─────────────┴─────────────┘");
        
        System.out.println("\nComplexity Analysis:");
        System.out.println("┌─────────────────┬─────────────────┬─────────────────┐");
        System.out.println("│ Approach        │ Time Complexity │ Space Complexity│");
        System.out.println("├─────────────────┼─────────────────┼─────────────────┤");
        System.out.println("│ Brute Force     │ O(n²)           │ O(1)            │");
        System.out.println("│ Hash Map        │ O(n)            │ O(n)            │");
        System.out.println("│ Two Pointers    │ O(n log n)      │ O(1)            │");
        System.out.println("└─────────────────┴─────────────────┴─────────────────┘");
        
        System.out.println("\nWhen to use which approach:");
        System.out.println("• Brute Force: Small arrays, simple implementation");
        System.out.println("• Hash Map: Best overall performance, most common choice");
        System.out.println("• Two Pointers: When array is already sorted, space-constrained");
    }
    
    /**
     * Generates test array for performance testing
     */
    public static int[] generateTestArray(int size) {
        int[] array = new int[size];
        Random random = new Random(42); // Fixed seed for consistent results
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        
        return array;
    }
    
    /**
     * Additional helper method: Two Sum with return values instead of indices
     */
    public static int[] twoSumValues(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                return new int[]{complement, num};
            }
            map.put(num, 1);
        }
        
        return new int[]{-1, -1};
    }
    
    /**
     * Three Sum problem (bonus)
     * Find three numbers that sum to target
     */
    public static List<int[]> threeSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(new int[]{i, left, right});
                    
                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}

/*
 * Problem Summary:
 * 
 * Two Sum is a fundamental problem that teaches:
 * 1. Array traversal and searching techniques
 * 2. Hash map optimization for O(n) solutions
 * 3. Two pointers technique for sorted arrays
 * 4. Time vs space complexity trade-offs
 * 
 * Key Insights:
 * - Brute force is simple but inefficient O(n²)
 * - Hash map provides optimal O(n) time with O(n) space
 * - Two pointers work well for sorted arrays
 * - Consider problem constraints when choosing approach
 * 
 * Common Variations:
 * - Two Sum II (sorted array)
 * - Two Sum III (data structure design)
 * - Three Sum, Four Sum
 * - Two Sum closest to target
 * - Count pairs with given sum
 * 
 * Interview Tips:
 * - Start with brute force, then optimize
 * - Discuss trade-offs between approaches
 * - Handle edge cases (empty array, no solution)
 * - Consider follow-up questions and variations
 * 
 * Real-world Applications:
 * - Finding complementary items in e-commerce
 * - Matching algorithms in dating apps
 * - Portfolio optimization in finance
 * - Resource allocation problems
 */
