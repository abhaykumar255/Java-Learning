/**
 * StringInterviewProblems.java - Common String Interview Questions
 * 
 * Learning Objectives:
 * - Master frequently asked string problems in interviews
 * - Practice different string manipulation techniques
 * - Learn pattern matching and substring algorithms
 * - Understand time and space complexity optimizations
 * - Build confidence for coding interviews
 */

import java.util.*;

public class StringInterviewProblems {
    
    public static void main(String[] args) {
        
        System.out.println("=== String Interview Problems ===\n");
        
        // ========== EASY LEVEL PROBLEMS ==========
        
        System.out.println("=== Easy Level Problems ===");
        solveEasyProblems();
        
        // ========== MEDIUM LEVEL PROBLEMS ==========
        
        System.out.println("\n=== Medium Level Problems ===");
        solveMediumProblems();
        
        // ========== HARD LEVEL PROBLEMS ==========
        
        System.out.println("\n=== Hard Level Problems ===");
        solveHardProblems();
        
        // ========== PATTERN MATCHING PROBLEMS ==========
        
        System.out.println("\n=== Pattern Matching Problems ===");
        solvePatternProblems();
    }
    
    /**
     * Easy level string problems
     */
    public static void solveEasyProblems() {
        
        // Problem 1: Reverse a string
        System.out.println("Problem 1: Reverse a String");
        String str1 = "hello world";
        System.out.println("Input: " + str1);
        System.out.println("Output: " + reverseString(str1));
        System.out.println("Time: O(n), Space: O(n)");
        System.out.println();
        
        // Problem 2: Check if string is palindrome
        System.out.println("Problem 2: Valid Palindrome");
        String str2 = "A man a plan a canal Panama";
        System.out.println("Input: " + str2);
        System.out.println("Is palindrome: " + isPalindrome(str2));
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
        
        // Problem 3: First unique character
        System.out.println("Problem 3: First Unique Character");
        String str3 = "leetcode";
        System.out.println("Input: " + str3);
        System.out.println("First unique index: " + firstUniqChar(str3));
        System.out.println("Time: O(n), Space: O(1) - limited alphabet");
        System.out.println();
        
        // Problem 4: Valid anagram
        System.out.println("Problem 4: Valid Anagram");
        String s4a = "anagram", s4b = "nagaram";
        System.out.println("Input: s1=" + s4a + ", s2=" + s4b);
        System.out.println("Are anagrams: " + isAnagram(s4a, s4b));
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
    }
    
    /**
     * Reverse a string
     */
    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    /**
     * Check if string is palindrome (ignoring case and non-alphanumeric)
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * Find first unique character index
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count frequency of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find first character with count 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Check if two strings are anagrams
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] charCount = new int[26]; // For lowercase letters
        
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        
        for (int count : charCount) {
            if (count != 0) return false;
        }
        
        return true;
    }
    
    /**
     * Medium level string problems
     */
    public static void solveMediumProblems() {
        
        // Problem 1: Longest substring without repeating characters
        System.out.println("Problem 1: Longest Substring Without Repeating Characters");
        String str1 = "abcabcbb";
        System.out.println("Input: " + str1);
        System.out.println("Length: " + lengthOfLongestSubstring(str1));
        System.out.println("Time: O(n), Space: O(min(m,n)) where m is charset size");
        System.out.println();
        
        // Problem 2: Group anagrams
        System.out.println("Problem 2: Group Anagrams");
        String[] strs2 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(strs2));
        System.out.println("Groups: " + groupAnagrams(strs2));
        System.out.println("Time: O(n*k*log(k)), Space: O(n*k)");
        System.out.println();
        
        // Problem 3: String to integer (atoi)
        System.out.println("Problem 3: String to Integer (atoi)");
        String str3 = "   -42";
        System.out.println("Input: '" + str3 + "'");
        System.out.println("Output: " + myAtoi(str3));
        System.out.println("Time: O(n), Space: O(1)");
        System.out.println();
        
        // Problem 4: Longest palindromic substring
        System.out.println("Problem 4: Longest Palindromic Substring");
        String str4 = "babad";
        System.out.println("Input: " + str4);
        System.out.println("Output: " + longestPalindrome(str4));
        System.out.println("Time: O(n²), Space: O(1)");
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
     * Group anagrams together
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }
    
    /**
     * String to integer implementation
     */
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int i = 0, n = s.length();
        
        // Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') i++;
        
        if (i == n) return 0;
        
        // Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        
        // Convert digits
        long result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            // Check overflow
            if (sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            i++;
        }
        
        return (int) (sign * result);
    }
    
    /**
     * Longest palindromic substring using expand around centers
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        
        int start = 0, maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes
            int len1 = expandAroundCenter(s, i, i);
            // Check for even length palindromes
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    /**
     * Helper method to expand around center
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    
    /**
     * Hard level string problems
     */
    public static void solveHardProblems() {
        
        // Problem 1: Minimum window substring
        System.out.println("Problem 1: Minimum Window Substring");
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println("String: " + s1);
        System.out.println("Pattern: " + t1);
        System.out.println("Minimum window: " + minWindow(s1, t1));
        System.out.println("Time: O(|s| + |t|), Space: O(|s| + |t|)");
        System.out.println();
        
        // Problem 2: Edit distance
        System.out.println("Problem 2: Edit Distance");
        String word1 = "horse", word2 = "ros";
        System.out.println("Word1: " + word1);
        System.out.println("Word2: " + word2);
        System.out.println("Edit distance: " + minDistance(word1, word2));
        System.out.println("Time: O(m*n), Space: O(m*n)");
        System.out.println();
        
        // Problem 3: Regular expression matching
        System.out.println("Problem 3: Regular Expression Matching");
        String s3 = "aa", p3 = "a*";
        System.out.println("String: " + s3);
        System.out.println("Pattern: " + p3);
        System.out.println("Matches: " + isMatch(s3, p3));
        System.out.println("Time: O(m*n), Space: O(m*n)");
        System.out.println();
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
     * Edit distance (Levenshtein distance)
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                        dp[i - 1][j - 1]
                    );
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * Regular expression matching with . and *
     */
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '*') {
                    char prevPc = p.charAt(j - 2);
                    // Zero occurrences
                    dp[i][j] = dp[i][j - 2];
                    // One or more occurrences
                    if (prevPc == '.' || prevPc == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
    
    /**
     * Pattern matching problems
     */
    public static void solvePatternProblems() {
        System.out.println("Pattern matching is crucial for string problems:");
        System.out.println("- KMP algorithm for pattern searching");
        System.out.println("- Rabin-Karp for multiple pattern matching");
        System.out.println("- Trie for prefix matching");
        System.out.println("- Regular expressions for complex patterns");
        System.out.println();
        
        System.out.println("Key techniques for string interviews:");
        System.out.println("1. Two pointers for palindromes and comparisons");
        System.out.println("2. Sliding window for substring problems");
        System.out.println("3. Hash maps for character counting");
        System.out.println("4. Dynamic programming for edit distance");
        System.out.println("5. Expand around center for palindromes");
        
        System.out.println("\n=== String Interview Problems completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Common String Patterns:
 *    - Two pointers: palindromes, reversing
 *    - Sliding window: substring problems
 *    - Hash map: character frequency, anagrams
 *    - Dynamic programming: edit distance, regex
 * 
 * 2. Time Complexity Optimization:
 *    - Use character arrays for in-place operations
 *    - Hash maps for O(1) lookups
 *    - Sliding window to avoid nested loops
 *    - Expand around center for palindromes
 * 
 * 3. Edge Cases to Consider:
 *    - Empty strings
 *    - Single character strings
 *    - Case sensitivity
 *    - Special characters and whitespace
 * 
 * 4. Interview Tips:
 *    - Clarify requirements (case sensitivity, character set)
 *    - Start with brute force, then optimize
 *    - Consider space-time tradeoffs
 *    - Test with edge cases
 * 
 * 5. Practice Categories:
 *    - Easy: basic operations, palindromes, anagrams
 *    - Medium: substring problems, grouping
 *    - Hard: pattern matching, dynamic programming
 */
