/**
 * RecursionProblems.java - Classic Recursive Problems and Solutions
 * 
 * Learning Objectives:
 * - Practice solving classic recursive problems
 * - Master different types of recursion patterns
 * - Learn to identify recursive subproblems
 * - Understand base cases and recursive cases
 * - Compare recursive vs iterative solutions
 */

import java.util.*;

public class RecursionProblems {
    
    public static void main(String[] args) {
        
        System.out.println("=== Classic Recursive Problems ===\n");
        
        // ========== MATHEMATICAL RECURSION ==========
        
        System.out.println("=== Mathematical Recursion ===");
        solveMathematicalProblems();
        
        // ========== ARRAY RECURSION ==========
        
        System.out.println("\n=== Array Recursion ===");
        solveArrayProblems();
        
        // ========== STRING RECURSION ==========
        
        System.out.println("\n=== String Recursion ===");
        solveStringProblems();
        
        // ========== TREE RECURSION ==========
        
        System.out.println("\n=== Tree Recursion ===");
        solveTreeProblems();
    }
    
    /**
     * Mathematical recursion problems
     */
    public static void solveMathematicalProblems() {
        
        // Problem 1: Tower of Hanoi
        System.out.println("Problem 1: Tower of Hanoi");
        int disks = 3;
        System.out.println("Moving " + disks + " disks from A to C:");
        towerOfHanoi(disks, 'A', 'C', 'B');
        System.out.println();
        
        // Problem 2: GCD using recursion
        System.out.println("Problem 2: GCD using Euclidean Algorithm");
        int a = 48, b = 18;
        System.out.printf("GCD(%d, %d) = %d\n", a, b, gcd(a, b));
        System.out.println();
        
        // Problem 3: Power calculation
        System.out.println("Problem 3: Fast Exponentiation");
        int base = 2, exp = 10;
        System.out.printf("%d^%d = %d\n", base, exp, power(base, exp));
        System.out.println();
    }
    
    /**
     * Tower of Hanoi - Classic recursion problem
     * Move n disks from source to destination using auxiliary rod
     */
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary
        towerOfHanoi(n - 1, source, auxiliary, destination);
        
        // Move the largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Move n-1 disks from auxiliary to destination
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
    
    /**
     * GCD using Euclidean algorithm
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    /**
     * Fast exponentiation using recursion
     */
    public static long power(int base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        
        if (exp % 2 == 0) {
            long half = power(base, exp / 2);
            return half * half;
        } else {
            return base * power(base, exp - 1);
        }
    }
    
    /**
     * Array recursion problems
     */
    public static void solveArrayProblems() {
        
        // Problem 1: Array sum
        System.out.println("Problem 1: Sum of Array Elements");
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Sum: " + arraySum(arr1, 0));
        System.out.println();
        
        // Problem 2: Find maximum element
        System.out.println("Problem 2: Find Maximum Element");
        int[] arr2 = {3, 7, 1, 9, 2, 8};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Maximum: " + findMax(arr2, 0));
        System.out.println();
        
        // Problem 3: Binary search
        System.out.println("Problem 3: Binary Search");
        int[] arr3 = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;
        System.out.println("Sorted Array: " + Arrays.toString(arr3));
        System.out.println("Target: " + target);
        int result = binarySearch(arr3, target, 0, arr3.length - 1);
        System.out.println("Found at index: " + (result != -1 ? result : "Not found"));
        System.out.println();
    }
    
    /**
     * Sum of array elements using recursion
     */
    public static int arraySum(int[] arr, int index) {
        if (index >= arr.length) return 0;
        return arr[index] + arraySum(arr, index + 1);
    }
    
    /**
     * Find maximum element using recursion
     */
    public static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) return arr[index];
        return Math.max(arr[index], findMax(arr, index + 1));
    }
    
    /**
     * Binary search using recursion
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, right);
        else return binarySearch(arr, target, left, mid - 1);
    }
    
    /**
     * String recursion problems
     */
    public static void solveStringProblems() {
        
        // Problem 1: Reverse string
        System.out.println("Problem 1: Reverse String");
        String str1 = "hello";
        System.out.println("Original: " + str1);
        System.out.println("Reversed: " + reverseString(str1));
        System.out.println();
        
        // Problem 2: Check palindrome
        System.out.println("Problem 2: Check Palindrome");
        String str2 = "racecar";
        System.out.println("String: " + str2);
        System.out.println("Is palindrome: " + isPalindrome(str2, 0, str2.length() - 1));
        System.out.println();
        
        // Problem 3: Generate permutations
        System.out.println("Problem 3: Generate Permutations");
        String str3 = "abc";
        System.out.println("String: " + str3);
        System.out.println("Permutations:");
        generatePermutations(str3, "");
        System.out.println();
    }
    
    /**
     * Reverse string using recursion
     */
    public static String reverseString(String str) {
        if (str.length() <= 1) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Check if string is palindrome using recursion
     */
    public static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1);
    }
    
    /**
     * Generate all permutations of a string
     */
    public static void generatePermutations(String str, String current) {
        if (str.length() == 0) {
            System.out.println(current);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(remaining, current + ch);
        }
    }
    
    /**
     * Tree recursion problems
     */
    public static void solveTreeProblems() {
        System.out.println("Tree problems demonstrate the power of recursion:");
        System.out.println("- Tree traversals (inorder, preorder, postorder)");
        System.out.println("- Tree height calculation");
        System.out.println("- Path finding in trees");
        System.out.println("- Tree validation problems");
        System.out.println();
        
        System.out.println("Key insight: Trees are naturally recursive structures!");
        System.out.println("Each subtree is a smaller version of the same problem.");
        
        System.out.println("\n=== Recursive Problems completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Problem-Solving Pattern:
 *    - Identify base case (when to stop)
 *    - Define recursive case (how to break down)
 *    - Ensure progress toward base case
 * 
 * 2. Types of Recursion:
 *    - Linear: single recursive call (factorial, sum)
 *    - Binary: two recursive calls (fibonacci, tree traversal)
 *    - Multiple: many recursive calls (permutations)
 * 
 * 3. Common Recursive Problems:
 *    - Mathematical: factorial, fibonacci, GCD
 *    - Array: sum, search, sorting
 *    - String: reverse, palindrome, permutations
 *    - Tree: traversal, height, validation
 * 
 * 4. Optimization Techniques:
 *    - Memoization for overlapping subproblems
 *    - Tail recursion optimization
 *    - Converting to iterative when needed
 * 
 * 5. When to Use Recursion:
 *    - Problem has recursive structure
 *    - Tree/graph traversal
 *    - Divide and conquer algorithms
 *    - Backtracking problems
 */
