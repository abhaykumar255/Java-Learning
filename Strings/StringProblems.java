/**
 * StringProblems.java - Common String Problems and Solutions
 * 
 * Learning Objectives:
 * - Solve frequently asked string problems in interviews
 * - Practice string manipulation and pattern matching
 * - Understand different string processing techniques
 * - Learn optimization strategies for string operations
 * - Master palindrome, anagram, and substring problems
 */

import java.util.*;

public class StringProblems {
    
    public static void main(String[] args) {
        
        System.out.println("=== Common String Problems and Solutions ===\n");
        
        // ========== PALINDROME PROBLEMS ==========
        
        System.out.println("=== Problem 1: Palindrome Check ===");
        palindromeProblems();
        
        // ========== ANAGRAM PROBLEMS ==========
        
        System.out.println("\n=== Problem 2: Anagram Detection ===");
        anagramProblems();
        
        // ========== SUBSTRING PROBLEMS ==========
        
        System.out.println("\n=== Problem 3: Substring Problems ===");
        substringProblems();
        
        // ========== CHARACTER FREQUENCY ==========
        
        System.out.println("\n=== Problem 4: Character Frequency ===");
        characterFrequencyProblems();
        
        // ========== STRING REVERSAL ==========
        
        System.out.println("\n=== Problem 5: String Reversal ===");
        stringReversalProblems();
        
        // ========== PATTERN MATCHING ==========
        
        System.out.println("\n=== Problem 6: Pattern Matching ===");
        patternMatchingProblems();
        
        System.out.println("\n=== String Problems lesson completed! ===");
    }
    
    /**
     * Palindrome-related problems
     */
    public static void palindromeProblems() {
        String[] testStrings = {
            "racecar", "hello", "A man a plan a canal Panama", 
            "race a car", "Madam", "12321", "12345"
        };
        
        System.out.println("--- Basic Palindrome Check ---");
        for (String str : testStrings) {
            boolean isPalindrome1 = isPalindrome(str);
            boolean isPalindrome2 = isPalindromeIgnoreCase(str);
            System.out.println("\"" + str + "\" -> Basic: " + isPalindrome1 + 
                             ", Ignore case/spaces: " + isPalindrome2);
        }
        
        // Longest palindromic substring
        System.out.println("\n--- Longest Palindromic Substring ---");
        String[] testCases = {"babad", "cbbd", "racecar", "abcdef"};
        for (String str : testCases) {
            String longest = longestPalindromicSubstring(str);
            System.out.println("\"" + str + "\" -> Longest palindrome: \"" + longest + "\"");
        }
        
        // Valid palindrome after removing one character
        System.out.println("\n--- Valid Palindrome After Removing One Character ---");
        String[] testCases2 = {"aba", "abca", "abc", "raceacar"};
        for (String str : testCases2) {
            boolean canBePalindrome = validPalindromeAfterRemoval(str);
            System.out.println("\"" + str + "\" -> Can be palindrome: " + canBePalindrome);
        }
    }
    
    /**
     * Basic palindrome check
     * Time: O(n), Space: O(1)
     */
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        
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
     * Palindrome check ignoring case and non-alphanumeric characters
     * Time: O(n), Space: O(1)
     */
    public static boolean isPalindromeIgnoreCase(String str) {
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
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
     * Find longest palindromic substring
     * Time: O(n²), Space: O(1)
     */
    public static String longestPalindromicSubstring(String str) {
        if (str == null || str.length() < 2) return str;
        
        int start = 0, maxLength = 1;
        
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
     * Check if string can be palindrome after removing at most one character
     * Time: O(n), Space: O(1)
     */
    public static boolean validPalindromeAfterRemoval(String str) {
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                // Try removing left character or right character
                return isPalindrome(str.substring(left + 1, right + 1)) ||
                       isPalindrome(str.substring(left, right));
            }
            left++;
            right--;
        }
        return true; // Already a palindrome
    }
    
    /**
     * Anagram-related problems
     */
    public static void anagramProblems() {
        
        // Basic anagram check
        System.out.println("--- Basic Anagram Check ---");
        String[][] anagramPairs = {
            {"listen", "silent"}, {"evil", "vile"}, {"hello", "world"},
            {"anagram", "nagaram"}, {"rat", "car"}
        };
        
        for (String[] pair : anagramPairs) {
            boolean isAnagram1 = isAnagram(pair[0], pair[1]);
            boolean isAnagram2 = isAnagramOptimized(pair[0], pair[1]);
            System.out.println("\"" + pair[0] + "\" & \"" + pair[1] + "\" -> " + 
                             "Anagram: " + isAnagram1 + " (Optimized: " + isAnagram2 + ")");
        }
        
        // Group anagrams
        System.out.println("\n--- Group Anagrams ---");
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(words);
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Grouped anagrams: " + groupedAnagrams);
        
        // Find all anagrams in string
        System.out.println("\n--- Find All Anagrams ---");
        String text = "abab";
        String pattern = "ab";
        List<Integer> anagramIndices = findAnagrams(text, pattern);
        System.out.println("Text: \"" + text + "\", Pattern: \"" + pattern + "\"");
        System.out.println("Anagram start indices: " + anagramIndices);
    }
    
    /**
     * Check if two strings are anagrams (sorting approach)
     * Time: O(n log n), Space: O(1)
     */
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    /**
     * Check if two strings are anagrams (frequency counting)
     * Time: O(n), Space: O(1) - assuming fixed character set
     */
    public static boolean isAnagramOptimized(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        
        int[] charCount = new int[26]; // Assuming lowercase letters only
        
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }
        
        for (int count : charCount) {
            if (count != 0) return false;
        }
        
        return true;
    }
    
    /**
     * Group anagrams together
     * Time: O(n * k log k), Space: O(n * k) where k is max string length
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            anagramGroups.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
    
    /**
     * Find all anagram start indices in text
     * Time: O(n), Space: O(1)
     */
    public static List<Integer> findAnagrams(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (text.length() < pattern.length()) return result;
        
        int[] patternCount = new int[26];
        int[] windowCount = new int[26];
        
        // Count characters in pattern
        for (char c : pattern.toCharArray()) {
            patternCount[c - 'a']++;
        }
        
        int windowSize = pattern.length();
        
        // Sliding window
        for (int i = 0; i < text.length(); i++) {
            // Add current character to window
            windowCount[text.charAt(i) - 'a']++;
            
            // Remove character that's out of window
            if (i >= windowSize) {
                windowCount[text.charAt(i - windowSize) - 'a']--;
            }
            
            // Check if current window is anagram
            if (i >= windowSize - 1 && Arrays.equals(patternCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }
        
        return result;
    }
    
    /**
     * Substring-related problems
     */
    public static void substringProblems() {
        
        // Longest substring without repeating characters
        System.out.println("--- Longest Substring Without Repeating Characters ---");
        String[] testStrings = {"abcabcbb", "bbbbb", "pwwkew", "abcdef", ""};
        for (String str : testStrings) {
            int length = lengthOfLongestSubstring(str);
            String substring = longestSubstringWithoutRepeating(str);
            System.out.println("\"" + str + "\" -> Length: " + length + 
                             ", Substring: \"" + substring + "\"");
        }
        
        // Longest common substring
        System.out.println("\n--- Longest Common Substring ---");
        String[][] pairs = {
            {"abcdxyz", "xyzabcd"}, {"zxabcdezy", "yzabcdezx"}, {"hello", "world"}
        };
        for (String[] pair : pairs) {
            String lcs = longestCommonSubstring(pair[0], pair[1]);
            System.out.println("\"" + pair[0] + "\" & \"" + pair[1] + "\" -> LCS: \"" + lcs + "\"");
        }
    }
    
    /**
     * Length of longest substring without repeating characters
     * Time: O(n), Space: O(min(m,n)) where m is character set size
     */
    public static int lengthOfLongestSubstring(String str) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0;
        
        for (int right = 0; right < str.length(); right++) {
            while (seen.contains(str.charAt(right))) {
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    /**
     * Get the actual longest substring without repeating characters
     */
    public static String longestSubstringWithoutRepeating(String str) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0, bestStart = 0;
        
        for (int right = 0; right < str.length(); right++) {
            while (seen.contains(str.charAt(right))) {
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(right));
            
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                bestStart = left;
            }
        }
        
        return str.substring(bestStart, bestStart + maxLength);
    }
    
    /**
     * Find longest common substring
     * Time: O(n*m), Space: O(n*m)
     */
    public static String longestCommonSubstring(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLength = 0, endIndex = 0;
        
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }
        
        return str1.substring(endIndex - maxLength, endIndex);
    }
    
    /**
     * Character frequency problems
     */
    public static void characterFrequencyProblems() {
        
        // First non-repeating character
        System.out.println("--- First Non-Repeating Character ---");
        String[] testStrings = {"leetcode", "loveleetcode", "aabb", "abccba"};
        for (String str : testStrings) {
            char firstUnique = firstNonRepeatingChar(str);
            System.out.println("\"" + str + "\" -> First non-repeating: '" + 
                             (firstUnique == '\0' ? "None" : firstUnique) + "'");
        }
        
        // Character frequency map
        System.out.println("\n--- Character Frequency Analysis ---");
        String text = "programming";
        Map<Character, Integer> frequency = getCharacterFrequency(text);
        System.out.println("\"" + text + "\" frequency map:");
        frequency.entrySet().stream()
                 .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                 .forEach(entry -> System.out.println("  '" + entry.getKey() + "': " + entry.getValue()));
    }
    
    /**
     * Find first non-repeating character
     * Time: O(n), Space: O(1) - fixed character set
     */
    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        
        // Count frequencies
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find first character with count 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return '\0'; // No non-repeating character found
    }
    
    /**
     * Get character frequency map
     */
    public static Map<Character, Integer> getCharacterFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        return frequency;
    }
    
    /**
     * String reversal problems
     */
    public static void stringReversalProblems() {
        
        // Basic string reversal
        System.out.println("--- String Reversal Methods ---");
        String original = "Hello World";
        System.out.println("Original: \"" + original + "\"");
        System.out.println("Reversed (StringBuilder): \"" + reverseStringBuilder(original) + "\"");
        System.out.println("Reversed (Two Pointers): \"" + reverseTwoPointers(original) + "\"");
        System.out.println("Reversed (Recursion): \"" + reverseRecursive(original) + "\"");
        
        // Reverse words in string
        System.out.println("\n--- Reverse Words ---");
        String sentence = "The quick brown fox";
        System.out.println("Original: \"" + sentence + "\"");
        System.out.println("Words reversed: \"" + reverseWords(sentence) + "\"");
        System.out.println("Each word reversed: \"" + reverseEachWord(sentence) + "\"");
    }
    
    /**
     * Reverse string using StringBuilder
     * Time: O(n), Space: O(n)
     */
    public static String reverseStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * Reverse string using two pointers
     * Time: O(n), Space: O(n) for char array
     */
    public static String reverseTwoPointers(String str) {
        char[] chars = str.toCharArray();
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
     * Reverse string using recursion
     * Time: O(n), Space: O(n) for recursion stack
     */
    public static String reverseRecursive(String str) {
        if (str.length() <= 1) return str;
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
    
    /**
     * Reverse words in string
     * Time: O(n), Space: O(n)
     */
    public static String reverseWords(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" ");
        }
        
        return result.toString();
    }
    
    /**
     * Reverse each word in string
     */
    public static String reverseEachWord(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(reverseStringBuilder(words[i]));
            if (i < words.length - 1) result.append(" ");
        }
        
        return result.toString();
    }
    
    /**
     * Pattern matching problems
     */
    public static void patternMatchingProblems() {
        
        // String contains pattern
        System.out.println("--- Pattern Matching ---");
        String text = "abcdefghijk";
        String pattern = "def";
        boolean contains = text.contains(pattern);
        int index = text.indexOf(pattern);
        System.out.println("Text: \"" + text + "\", Pattern: \"" + pattern + "\"");
        System.out.println("Contains: " + contains + ", Index: " + index);
        
        // Count pattern occurrences
        String text2 = "abababa";
        String pattern2 = "aba";
        int count = countPatternOccurrences(text2, pattern2);
        System.out.println("\nText: \"" + text2 + "\", Pattern: \"" + pattern2 + "\"");
        System.out.println("Occurrences: " + count);
        
        // Wildcard pattern matching
        System.out.println("\n--- Wildcard Pattern Matching ---");
        String[] texts = {"adceb", "acdcb", "abc"};
        String wildcardPattern = "a*c?b";
        for (String txt : texts) {
            boolean matches = wildcardMatch(txt, wildcardPattern);
            System.out.println("\"" + txt + "\" matches \"" + wildcardPattern + "\": " + matches);
        }
    }
    
    /**
     * Count pattern occurrences (overlapping)
     * Time: O(n*m), Space: O(1)
     */
    public static int countPatternOccurrences(String text, String pattern) {
        int count = 0;
        int index = 0;
        
        while ((index = text.indexOf(pattern, index)) != -1) {
            count++;
            index++; // Move by 1 to find overlapping occurrences
        }
        
        return count;
    }
    
    /**
     * Simple wildcard pattern matching (* matches any sequence, ? matches any single char)
     * Time: O(n*m), Space: O(1)
     */
    public static boolean wildcardMatch(String text, String pattern) {
        int textIndex = 0, patternIndex = 0;
        int starIndex = -1, match = 0;
        
        while (textIndex < text.length()) {
            if (patternIndex < pattern.length() && 
                (pattern.charAt(patternIndex) == '?' || 
                 pattern.charAt(patternIndex) == text.charAt(textIndex))) {
                textIndex++;
                patternIndex++;
            } else if (patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
                starIndex = patternIndex;
                match = textIndex;
                patternIndex++;
            } else if (starIndex != -1) {
                patternIndex = starIndex + 1;
                match++;
                textIndex = match;
            } else {
                return false;
            }
        }
        
        while (patternIndex < pattern.length() && pattern.charAt(patternIndex) == '*') {
            patternIndex++;
        }
        
        return patternIndex == pattern.length();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. String problems often involve multiple solution approaches
 * 2. Two pointers technique is powerful for palindromes and reversals
 * 3. Sliding window is effective for substring problems
 * 4. Hash maps optimize character frequency and anagram problems
 * 5. Dynamic programming helps with longest common substring problems
 * 
 * Common Problem Patterns:
 * - Two Pointers: Palindromes, reversals, valid strings
 * - Sliding Window: Longest substring, anagrams in string
 * - Hash Map: Character frequency, anagram detection
 * - Dynamic Programming: Longest common substring/subsequence
 * - Recursion: String reversal, pattern matching
 * 
 * Optimization Strategies:
 * - Use StringBuilder for string building
 * - Prefer character arrays for in-place operations
 * - Use appropriate data structures (Set, Map, Array)
 * - Consider space-time trade-offs
 * - Handle edge cases (empty strings, single characters)
 * 
 * Interview Tips:
 * - Clarify requirements (case sensitivity, character set)
 * - Start with brute force, then optimize
 * - Consider multiple approaches and their trade-offs
 * - Test with edge cases and examples
 * - Explain time and space complexity
 */
