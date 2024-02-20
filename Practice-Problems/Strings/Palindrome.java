/**
 * Palindrome.java - Palindrome Problems and Solutions
 * 
 * Problem Statement:
 * A palindrome is a word, phrase, number, or sequence that reads the same
 * backward as forward (e.g., "racecar", "A man a plan a canal Panama").
 * 
 * Difficulty: Easy to Medium ⭐⭐
 * 
 * Learning Objectives:
 * - Master different palindrome checking techniques
 * - Practice string manipulation and two-pointer approach
 * - Understand case-insensitive and alphanumeric-only palindromes
 * - Learn palindrome substring and subsequence problems
 */

import java.util.*;

public class Palindrome {
    
    public static void main(String[] args) {
        
        System.out.println("=== Palindrome Problems and Solutions ===\n");
        
        // ========== BASIC PALINDROME CHECK ==========
        
        System.out.println("=== Problem 1: Basic Palindrome Check ===");
        basicPalindromeCheck();
        
        // ========== VALID PALINDROME ==========
        
        System.out.println("\n=== Problem 2: Valid Palindrome (Alphanumeric Only) ===");
        validPalindromeCheck();
        
        // ========== PALINDROME AFTER REMOVAL ==========
        
        System.out.println("\n=== Problem 3: Valid Palindrome After Removing One Character ===");
        palindromeAfterRemoval();
        
        // ========== LONGEST PALINDROMIC SUBSTRING ==========
        
        System.out.println("\n=== Problem 4: Longest Palindromic Substring ===");
        longestPalindromicSubstring();
        
        // ========== PALINDROMIC SUBSEQUENCE ==========
        
        System.out.println("\n=== Problem 5: Longest Palindromic Subsequence ===");
        longestPalindromicSubsequence();
        
        // ========== PALINDROME PARTITIONING ==========
        
        System.out.println("\n=== Problem 6: Palindrome Partitioning ===");
        palindromePartitioning();
        
        System.out.println("\n=== Palindrome Problems lesson completed! ===");
    }
    
    /**
     * Problem 1: Basic palindrome check
     */
    public static void basicPalindromeCheck() {
        String[] testCases = {
            "racecar", "hello", "madam", "A", "", "ab", "aba"
        };
        
        System.out.println("Testing basic palindrome check:");
        for (String str : testCases) {
            boolean result1 = isPalindromeIterative(str);
            boolean result2 = isPalindromeRecursive(str);
            boolean result3 = isPalindromeBuiltIn(str);
            
            System.out.println("\"" + str + "\" -> Iterative: " + result1 + 
                             ", Recursive: " + result2 + ", Built-in: " + result3);
        }
    }
    
    /**
     * Iterative approach using two pointers
     * Time: O(n), Space: O(1)
     */
    public static boolean isPalindromeIterative(String str) {
        if (str == null) return false;
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Recursive approach
     * Time: O(n), Space: O(n) due to recursion stack
     */
    public static boolean isPalindromeRecursive(String str) {
        if (str == null) return false;
        return isPalindromeRecursiveHelper(str, 0, str.length() - 1);
    }
    
    private static boolean isPalindromeRecursiveHelper(String str, int left, int right) {
        if (left >= right) return true;
        
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        
        return isPalindromeRecursiveHelper(str, left + 1, right - 1);
    }
    
    /**
     * Using built-in string methods
     * Time: O(n), Space: O(n)
     */
    public static boolean isPalindromeBuiltIn(String str) {
        if (str == null) return false;
        
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
    /**
     * Problem 2: Valid palindrome (alphanumeric characters only, case-insensitive)
     */
    public static void validPalindromeCheck() {
        String[] testCases = {
            "A man a plan a canal Panama",
            "race a car",
            "Was it a car or a cat I saw?",
            "Madam, I'm Adam",
            "No 'x' in Nixon",
            "Mr. Owl ate my metal worm"
        };
        
        System.out.println("Testing valid palindrome (alphanumeric only):");
        for (String str : testCases) {
            boolean result1 = isValidPalindrome(str);
            boolean result2 = isValidPalindromeOptimized(str);
            
            System.out.println("\"" + str + "\" -> Method1: " + result1 + 
                             ", Optimized: " + result2);
        }
    }
    
    /**
     * Valid palindrome using string preprocessing
     * Time: O(n), Space: O(n)
     */
    public static boolean isValidPalindrome(String str) {
        if (str == null) return false;
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        return isPalindromeIterative(cleaned);
    }
    
    /**
     * Valid palindrome using two pointers without preprocessing
     * Time: O(n), Space: O(1)
     */
    public static boolean isValidPalindromeOptimized(String str) {
        if (str == null) return false;
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            
            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            
            // Compare characters (case-insensitive)
            if (Character.toLowerCase(str.charAt(left)) != 
                Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Problem 3: Valid palindrome after removing at most one character
     */
    public static void palindromeAfterRemoval() {
        String[] testCases = {
            "aba", "abca", "abc", "raceacar", "deeee", "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"
        };
        
        System.out.println("Testing palindrome after removing one character:");
        for (String str : testCases) {
            boolean result = validPalindromeII(str);
            System.out.println("\"" + str + "\" -> Can be palindrome: " + result);
        }
    }
    
    /**
     * Check if string can be palindrome after removing at most one character
     * Time: O(n), Space: O(1)
     */
    public static boolean validPalindromeII(String str) {
        if (str == null) return false;
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                // Try removing left character or right character
                return isPalindromeRange(str, left + 1, right) || 
                       isPalindromeRange(str, left, right - 1);
            }
            left++;
            right--;
        }
        
        return true; // Already a palindrome
    }
    
    /**
     * Helper method to check palindrome in a range
     */
    private static boolean isPalindromeRange(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Problem 4: Longest palindromic substring
     */
    public static void longestPalindromicSubstring() {
        String[] testCases = {
            "babad", "cbbd", "racecar", "abcdef", "noon", "aabbaa"
        };
        
        System.out.println("Finding longest palindromic substring:");
        for (String str : testCases) {
            String result1 = longestPalindromeExpandCenter(str);
            String result2 = longestPalindromeDP(str);
            
            System.out.println("\"" + str + "\" -> Expand: \"" + result1 + 
                             "\", DP: \"" + result2 + "\"");
        }
    }
    
    /**
     * Longest palindromic substring using expand around center
     * Time: O(n²), Space: O(1)
     */
    public static String longestPalindromeExpandCenter(String str) {
        if (str == null || str.length() < 2) return str;
        
        int start = 0;
        int maxLength = 1;
        
        for (int i = 0; i < str.length(); i++) {
            // Check for odd-length palindromes
            int len1 = expandAroundCenter(str, i, i);
            // Check for even-length palindromes
            int len2 = expandAroundCenter(str, i, i + 1);
            
            int currentMax = Math.max(len1, len2);
            if (currentMax > maxLength) {
                maxLength = currentMax;
                start = i - (currentMax - 1) / 2;
            }
        }
        
        return str.substring(start, start + maxLength);
    }
    
    /**
     * Helper method to expand around center
     */
    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && 
               str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    /**
     * Longest palindromic substring using dynamic programming
     * Time: O(n²), Space: O(n²)
     */
    public static String longestPalindromeDP(String str) {
        if (str == null || str.length() < 2) return str;
        
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        
        // All single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // Check for two-character palindromes
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        // Check for palindromes of length 3 and more
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }
        
        return str.substring(start, start + maxLength);
    }
    
    /**
     * Problem 5: Longest palindromic subsequence
     */
    public static void longestPalindromicSubsequence() {
        String[] testCases = {
            "bbbab", "cbbd", "abcdcba", "aab"
        };
        
        System.out.println("Finding longest palindromic subsequence:");
        for (String str : testCases) {
            int length = longestPalindromicSubsequenceLength(str);
            String subsequence = longestPalindromicSubsequenceString(str);
            
            System.out.println("\"" + str + "\" -> Length: " + length + 
                             ", Subsequence: \"" + subsequence + "\"");
        }
    }
    
    /**
     * Length of longest palindromic subsequence using DP
     * Time: O(n²), Space: O(n²)
     */
    public static int longestPalindromicSubsequenceLength(String str) {
        if (str == null || str.length() == 0) return 0;
        
        int n = str.length();
        int[][] dp = new int[n][n];
        
        // Single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        // Fill the DP table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }
    
    /**
     * Get the actual longest palindromic subsequence
     */
    public static String longestPalindromicSubsequenceString(String str) {
        if (str == null || str.length() == 0) return "";
        
        int n = str.length();
        int[][] dp = new int[n][n];
        
        // Fill DP table (same as above)
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // Reconstruct the subsequence
        StringBuilder result = new StringBuilder();
        int i = 0, j = n - 1;
        
        while (i <= j) {
            if (i == j) {
                result.append(str.charAt(i));
                break;
            } else if (str.charAt(i) == str.charAt(j)) {
                result.append(str.charAt(i));
                i++;
                j--;
            } else if (dp[i + 1][j] > dp[i][j - 1]) {
                i++;
            } else {
                j--;
            }
        }
        
        // Add the reverse of the first half (excluding middle character if odd length)
        String firstHalf = result.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();
        
        if (dp[0][n - 1] % 2 == 1) {
            // Odd length - remove last character from second half
            secondHalf = secondHalf.substring(1);
        }
        
        return firstHalf + secondHalf;
    }
    
    /**
     * Problem 6: Palindrome partitioning
     */
    public static void palindromePartitioning() {
        String[] testCases = {
            "aab", "raceacar", "abcba"
        };
        
        System.out.println("Finding palindrome partitions:");
        for (String str : testCases) {
            List<List<String>> partitions = partition(str);
            System.out.println("\"" + str + "\" partitions:");
            for (List<String> partition : partitions) {
                System.out.println("  " + partition);
            }
        }
    }
    
    /**
     * Palindrome partitioning using backtracking
     * Time: O(n × 2^n), Space: O(n)
     */
    public static List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();
        if (str == null || str.length() == 0) return result;
        
        backtrack(str, 0, new ArrayList<>(), result);
        return result;
    }
    
    /**
     * Backtracking helper for palindrome partitioning
     */
    private static void backtrack(String str, int start, List<String> current, 
                                 List<List<String>> result) {
        if (start == str.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int end = start; end < str.length(); end++) {
            String substring = str.substring(start, end + 1);
            if (isPalindromeIterative(substring)) {
                current.add(substring);
                backtrack(str, end + 1, current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }
}

/*
 * Problem Summary:
 * 
 * Palindrome problems teach fundamental string manipulation techniques:
 * 1. Two-pointer approach for efficient palindrome checking
 * 2. Dynamic programming for optimization problems
 * 3. Backtracking for generating all possible solutions
 * 4. String preprocessing for handling special cases
 * 
 * Key Techniques:
 * - Two Pointers: Most efficient for basic palindrome checking
 * - Expand Around Center: Good for finding palindromic substrings
 * - Dynamic Programming: Optimal for subsequence problems
 * - Backtracking: Necessary for generating all partitions
 * 
 * Time Complexities:
 * - Basic check: O(n)
 * - Longest substring: O(n²)
 * - Longest subsequence: O(n²)
 * - All partitions: O(n × 2^n)
 * 
 * Common Variations:
 * - Case-insensitive palindromes
 * - Alphanumeric-only palindromes
 * - Palindromes after character removal
 * - Minimum cuts for palindrome partitioning
 * - Count of palindromic substrings
 * 
 * Interview Tips:
 * - Start with basic two-pointer approach
 * - Consider edge cases (empty string, single character)
 * - Optimize space when possible
 * - Discuss different approaches and trade-offs
 * - Practice both iterative and recursive solutions
 */
