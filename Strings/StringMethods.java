/**
 * StringMethods.java - Essential String Methods in Java
 * 
 * Learning Objectives:
 * - Master essential String methods and their usage
 * - Understand method chaining and string manipulation
 * - Practice string validation and transformation
 * - Learn performance considerations with string operations
 * - Explore practical string processing scenarios
 */

import java.util.Arrays;
import java.util.StringJoiner;

public class StringMethods {
    
    public static void main(String[] args) {
        
        System.out.println("=== Essential String Methods in Java ===\n");
        
        // ========== LENGTH AND CHARACTER ACCESS ==========
        
        System.out.println("=== Length and Character Access ===");
        lengthAndCharacterMethods();
        
        // ========== SUBSTRING OPERATIONS ==========
        
        System.out.println("\n=== Substring Operations ===");
        substringMethods();
        
        // ========== SEARCH AND INDEX METHODS ==========
        
        System.out.println("\n=== Search and Index Methods ===");
        searchAndIndexMethods();
        
        // ========== CASE CONVERSION METHODS ==========
        
        System.out.println("\n=== Case Conversion Methods ===");
        caseConversionMethods();
        
        // ========== TRIMMING AND WHITESPACE ==========
        
        System.out.println("\n=== Trimming and Whitespace Methods ===");
        trimmingMethods();
        
        // ========== REPLACEMENT METHODS ==========
        
        System.out.println("\n=== Replacement Methods ===");
        replacementMethods();
        
        // ========== SPLITTING AND JOINING ==========
        
        System.out.println("\n=== Splitting and Joining Methods ===");
        splittingAndJoiningMethods();
        
        // ========== VALIDATION METHODS ==========
        
        System.out.println("\n=== Validation Methods ===");
        validationMethods();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical String Processing Examples ===");
        practicalExamples();
        
        System.out.println("\n=== String Methods lesson completed! ===");
    }
    
    /**
     * Demonstrates length and character access methods
     */
    public static void lengthAndCharacterMethods() {
        String text = "Hello, World!";
        
        System.out.println("Text: \"" + text + "\"");
        
        // length() - returns the number of characters
        System.out.println("Length: " + text.length());
        
        // charAt(index) - returns character at specific index
        System.out.println("Character at index 0: '" + text.charAt(0) + "'");
        System.out.println("Character at index 7: '" + text.charAt(7) + "'");
        System.out.println("Last character: '" + text.charAt(text.length() - 1) + "'");
        
        // toCharArray() - converts string to character array
        char[] charArray = text.toCharArray();
        System.out.println("Character array: " + Arrays.toString(charArray));
        
        // getChars() - copies characters to destination array
        char[] destination = new char[5];
        text.getChars(0, 5, destination, 0); // Copy "Hello"
        System.out.println("Copied characters: " + Arrays.toString(destination));
        
        // Iterating through characters
        System.out.print("Characters: ");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i) + " ");
        }
        System.out.println();
        
        // Enhanced for loop with toCharArray()
        System.out.print("Using enhanced for: ");
        for (char c : text.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
    
    /**
     * Demonstrates substring operations
     */
    public static void substringMethods() {
        String text = "Java Programming Language";
        
        System.out.println("Text: \"" + text + "\"");
        
        // substring(beginIndex) - from index to end
        System.out.println("substring(5): \"" + text.substring(5) + "\"");
        
        // substring(beginIndex, endIndex) - from begin to end-1
        System.out.println("substring(0, 4): \"" + text.substring(0, 4) + "\"");
        System.out.println("substring(5, 16): \"" + text.substring(5, 16) + "\"");
        
        // Extract words using substring
        int spaceIndex1 = text.indexOf(' ');
        int spaceIndex2 = text.indexOf(' ', spaceIndex1 + 1);
        
        String word1 = text.substring(0, spaceIndex1);
        String word2 = text.substring(spaceIndex1 + 1, spaceIndex2);
        String word3 = text.substring(spaceIndex2 + 1);
        
        System.out.println("Word 1: \"" + word1 + "\"");
        System.out.println("Word 2: \"" + word2 + "\"");
        System.out.println("Word 3: \"" + word3 + "\"");
        
        // subSequence() - returns CharSequence
        CharSequence subSeq = text.subSequence(5, 16);
        System.out.println("subSequence(5, 16): \"" + subSeq + "\"");
    }
    
    /**
     * Demonstrates search and index methods
     */
    public static void searchAndIndexMethods() {
        String text = "The quick brown fox jumps over the lazy dog";
        
        System.out.println("Text: \"" + text + "\"");
        
        // indexOf() methods
        System.out.println("indexOf('o'): " + text.indexOf('o'));
        System.out.println("indexOf('o', 15): " + text.indexOf('o', 15)); // Start from index 15
        System.out.println("indexOf(\"fox\"): " + text.indexOf("fox"));
        System.out.println("indexOf(\"cat\"): " + text.indexOf("cat")); // Not found
        
        // lastIndexOf() methods
        System.out.println("lastIndexOf('o'): " + text.lastIndexOf('o'));
        System.out.println("lastIndexOf('o', 30): " + text.lastIndexOf('o', 30)); // Search backwards from index 30
        System.out.println("lastIndexOf(\"the\"): " + text.lastIndexOf("the"));
        
        // contains() - checks if string contains substring
        System.out.println("contains(\"fox\"): " + text.contains("fox"));
        System.out.println("contains(\"cat\"): " + text.contains("cat"));
        
        // startsWith() and endsWith()
        System.out.println("startsWith(\"The\"): " + text.startsWith("The"));
        System.out.println("startsWith(\"quick\", 4): " + text.startsWith("quick", 4)); // From index 4
        System.out.println("endsWith(\"dog\"): " + text.endsWith("dog"));
        System.out.println("endsWith(\"cat\"): " + text.endsWith("cat"));
        
        // Finding all occurrences
        System.out.println("\nAll occurrences of 'o':");
        findAllOccurrences(text, 'o');
        
        System.out.println("\nAll occurrences of \"the\":");
        findAllOccurrences(text, "the");
    }
    
    /**
     * Helper method to find all occurrences of a character
     */
    public static void findAllOccurrences(String text, char target) {
        int index = text.indexOf(target);
        while (index != -1) {
            System.out.println("Found '" + target + "' at index: " + index);
            index = text.indexOf(target, index + 1);
        }
    }
    
    /**
     * Helper method to find all occurrences of a substring
     */
    public static void findAllOccurrences(String text, String target) {
        int index = text.toLowerCase().indexOf(target.toLowerCase());
        while (index != -1) {
            System.out.println("Found \"" + target + "\" at index: " + index);
            index = text.toLowerCase().indexOf(target.toLowerCase(), index + 1);
        }
    }
    
    /**
     * Demonstrates case conversion methods
     */
    public static void caseConversionMethods() {
        String text = "Hello World! 123";
        
        System.out.println("Original: \"" + text + "\"");
        
        // toUpperCase() and toLowerCase()
        System.out.println("toUpperCase(): \"" + text.toUpperCase() + "\"");
        System.out.println("toLowerCase(): \"" + text.toLowerCase() + "\"");
        
        // Locale-specific case conversion
        String turkish = "İstanbul";
        System.out.println("Turkish text: \"" + turkish + "\"");
        System.out.println("toLowerCase(): \"" + turkish.toLowerCase() + "\"");
        
        // Custom title case method
        String sentence = "the quick brown fox";
        System.out.println("Original sentence: \"" + sentence + "\"");
        System.out.println("Title case: \"" + toTitleCase(sentence) + "\"");
        
        // Toggle case method
        String mixed = "HeLLo WoRLd";
        System.out.println("Mixed case: \"" + mixed + "\"");
        System.out.println("Toggled case: \"" + toggleCase(mixed) + "\"");
    }
    
    /**
     * Custom method to convert to title case
     */
    public static String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                result.append(c);
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        
        return result.toString();
    }
    
    /**
     * Custom method to toggle case
     */
    public static String toggleCase(String text) {
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    /**
     * Demonstrates trimming and whitespace methods
     */
    public static void trimmingMethods() {
        String text = "   Hello World   ";
        String textWithTabs = "\t\tHello\tWorld\t\t";
        String textWithNewlines = "\n\nHello\nWorld\n\n";
        
        System.out.println("Original: \"" + text + "\" (length: " + text.length() + ")");
        
        // trim() - removes leading and trailing whitespace
        String trimmed = text.trim();
        System.out.println("trim(): \"" + trimmed + "\" (length: " + trimmed.length() + ")");
        
        // strip() - similar to trim() but handles Unicode whitespace (Java 11+)
        System.out.println("strip(): \"" + text.strip() + "\"");
        
        // stripLeading() and stripTrailing() (Java 11+)
        System.out.println("stripLeading(): \"" + text.stripLeading() + "\"");
        System.out.println("stripTrailing(): \"" + text.stripTrailing() + "\"");
        
        // Handling different whitespace characters
        System.out.println("\nWith tabs: \"" + textWithTabs + "\"");
        System.out.println("Trimmed: \"" + textWithTabs.trim() + "\"");
        
        System.out.println("\nWith newlines: \"" + textWithNewlines.replace("\n", "\\n") + "\"");
        System.out.println("Trimmed: \"" + textWithNewlines.trim().replace("\n", "\\n") + "\"");
        
        // isBlank() - checks if string is empty or contains only whitespace (Java 11+)
        System.out.println("\nBlank checking:");
        System.out.println("\"   \".isBlank(): " + "   ".isBlank());
        System.out.println("\"Hello\".isBlank(): " + "Hello".isBlank());
        System.out.println("\"\".isEmpty(): " + "".isEmpty());
    }
    
    /**
     * Demonstrates replacement methods
     */
    public static void replacementMethods() {
        String text = "The quick brown fox jumps over the lazy dog";
        
        System.out.println("Original: \"" + text + "\"");
        
        // replace(char, char) - replaces all occurrences
        System.out.println("replace('o', '0'): \"" + text.replace('o', '0') + "\"");
        
        // replace(CharSequence, CharSequence) - replaces all occurrences
        System.out.println("replace(\"the\", \"THE\"): \"" + text.replace("the", "THE") + "\"");
        
        // replaceFirst(regex, replacement) - replaces first match
        System.out.println("replaceFirst(\"the\", \"THE\"): \"" + text.replaceFirst("the", "THE") + "\"");
        
        // replaceAll(regex, replacement) - replaces all matches using regex
        System.out.println("replaceAll(\"\\\\b\\\\w{3}\\\\b\", \"XXX\"): \"" + 
                          text.replaceAll("\\b\\w{3}\\b", "XXX") + "\""); // Replace 3-letter words
        
        // Remove all digits
        String textWithNumbers = "Hello123World456";
        System.out.println("\nWith numbers: \"" + textWithNumbers + "\"");
        System.out.println("Remove digits: \"" + textWithNumbers.replaceAll("\\d", "") + "\"");
        
        // Remove extra spaces
        String textWithSpaces = "Hello    World    Java";
        System.out.println("\nWith extra spaces: \"" + textWithSpaces + "\"");
        System.out.println("Single spaces: \"" + textWithSpaces.replaceAll("\\s+", " ") + "\"");
        
        // Replace with custom logic
        String phoneNumber = "123-456-7890";
        System.out.println("\nPhone: \"" + phoneNumber + "\"");
        System.out.println("Formatted: \"" + phoneNumber.replaceAll("(\\d{3})-(\\d{3})-(\\d{4})", "($1) $2-$3") + "\"");
    }
    
    /**
     * Demonstrates splitting and joining methods
     */
    public static void splittingAndJoiningMethods() {
        String csvData = "apple,banana,orange,grape";
        String sentence = "The quick brown fox";
        
        System.out.println("CSV data: \"" + csvData + "\"");
        
        // split(regex) - splits string into array
        String[] fruits = csvData.split(",");
        System.out.println("Split by comma: " + Arrays.toString(fruits));
        
        // split(regex, limit) - limits number of splits
        String[] limitedSplit = csvData.split(",", 2);
        System.out.println("Split with limit 2: " + Arrays.toString(limitedSplit));
        
        System.out.println("\nSentence: \"" + sentence + "\"");
        String[] words = sentence.split(" ");
        System.out.println("Split by space: " + Arrays.toString(words));
        
        // Split by multiple delimiters
        String mixedDelimiters = "apple,banana;orange:grape";
        String[] mixedSplit = mixedDelimiters.split("[,;:]");
        System.out.println("Mixed delimiters: " + Arrays.toString(mixedSplit));
        
        // String.join() - joins array elements with delimiter
        String joined = String.join(" | ", fruits);
        System.out.println("Joined with ' | ': \"" + joined + "\"");
        
        // StringJoiner for more control
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String fruit : fruits) {
            joiner.add(fruit);
        }
        System.out.println("StringJoiner result: \"" + joiner.toString() + "\"");
        
        // Join with different separators
        System.out.println("Join with newlines:");
        System.out.println(String.join("\n", words));
    }
    
    /**
     * Demonstrates validation methods
     */
    public static void validationMethods() {
        String[] testStrings = {
            "Hello123",
            "12345",
            "hello world",
            "HELLO WORLD",
            "",
            "   ",
            null
        };
        
        System.out.println("String validation examples:");
        
        for (String str : testStrings) {
            System.out.println("\nTesting: " + (str == null ? "null" : "\"" + str + "\""));
            
            if (str == null) {
                System.out.println("  - String is null");
                continue;
            }
            
            System.out.println("  - isEmpty(): " + str.isEmpty());
            System.out.println("  - isBlank(): " + str.trim().isEmpty()); // Simulating isBlank()
            System.out.println("  - length(): " + str.length());
            
            if (!str.isEmpty()) {
                System.out.println("  - isNumeric(): " + isNumeric(str));
                System.out.println("  - isAlphabetic(): " + isAlphabetic(str));
                System.out.println("  - isAlphanumeric(): " + isAlphanumeric(str));
                System.out.println("  - isUpperCase(): " + str.equals(str.toUpperCase()));
                System.out.println("  - isLowerCase(): " + str.equals(str.toLowerCase()));
            }
        }
    }
    
    /**
     * Custom method to check if string is numeric
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Custom method to check if string is alphabetic
     */
    public static boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Custom method to check if string is alphanumeric
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Demonstrates practical string processing examples
     */
    public static void practicalExamples() {
        
        // Example 1: Email validation (basic)
        System.out.println("=== Email Validation ===");
        String[] emails = {"user@example.com", "invalid.email", "test@domain.co.uk"};
        
        for (String email : emails) {
            System.out.println("\"" + email + "\" is valid: " + isValidEmail(email));
        }
        
        // Example 2: Password strength checking
        System.out.println("\n=== Password Strength ===");
        String[] passwords = {"weak", "Strong123", "VeryStrong123!", "short"};
        
        for (String password : passwords) {
            System.out.println("\"" + password + "\" strength: " + getPasswordStrength(password));
        }
        
        // Example 3: Text formatting
        System.out.println("\n=== Text Formatting ===");
        String rawText = "  this is a SAMPLE text with   MIXED case and extra   spaces  ";
        System.out.println("Raw: \"" + rawText + "\"");
        System.out.println("Formatted: \"" + formatText(rawText) + "\"");
        
        // Example 4: Word count
        System.out.println("\n=== Word Count ===");
        String article = "Java is a popular programming language. Java is object-oriented.";
        System.out.println("Article: \"" + article + "\"");
        System.out.println("Word count: " + countWords(article));
        System.out.println("Character count (no spaces): " + countCharacters(article));
        
        // Example 5: Acronym generation
        System.out.println("\n=== Acronym Generation ===");
        String phrase = "Java Virtual Machine";
        System.out.println("Phrase: \"" + phrase + "\"");
        System.out.println("Acronym: \"" + generateAcronym(phrase) + "\"");
    }
    
    /**
     * Basic email validation
     */
    public static boolean isValidEmail(String email) {
        return email != null && 
               email.contains("@") && 
               email.indexOf("@") > 0 && 
               email.lastIndexOf("@") == email.indexOf("@") &&
               email.indexOf("@") < email.lastIndexOf(".") &&
               email.lastIndexOf(".") < email.length() - 1;
    }
    
    /**
     * Password strength checker
     */
    public static String getPasswordStrength(String password) {
        if (password == null || password.length() < 6) {
            return "Weak";
        }
        
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasLower = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        
        int score = 0;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;
        if (password.length() >= 8) score++;
        
        if (score >= 4) return "Strong";
        if (score >= 2) return "Medium";
        return "Weak";
    }
    
    /**
     * Text formatting utility
     */
    public static String formatText(String text) {
        return text.trim()                    // Remove leading/trailing spaces
                  .replaceAll("\\s+", " ")    // Replace multiple spaces with single space
                  .toLowerCase()              // Convert to lowercase
                  .substring(0, 1).toUpperCase() + // Capitalize first letter
                  text.trim().replaceAll("\\s+", " ").toLowerCase().substring(1);
    }
    
    /**
     * Word counter
     */
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
    
    /**
     * Character counter (excluding spaces)
     */
    public static int countCharacters(String text) {
        if (text == null) {
            return 0;
        }
        return text.replace(" ", "").length();
    }
    
    /**
     * Acronym generator
     */
    public static String generateAcronym(String phrase) {
        if (phrase == null || phrase.trim().isEmpty()) {
            return "";
        }
        
        StringBuilder acronym = new StringBuilder();
        String[] words = phrase.trim().split("\\s+");
        
        for (String word : words) {
            if (!word.isEmpty()) {
                acronym.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        
        return acronym.toString();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. String methods are essential for text processing and manipulation
 * 2. Many methods return new String objects (immutability)
 * 3. Regular expressions provide powerful pattern matching capabilities
 * 4. Always validate input strings to avoid NullPointerException
 * 5. Consider performance implications of string operations in loops
 * 
 * Essential String Methods Categories:
 * - Length/Access: length(), charAt(), toCharArray()
 * - Substring: substring(), subSequence()
 * - Search: indexOf(), lastIndexOf(), contains(), startsWith(), endsWith()
 * - Case: toUpperCase(), toLowerCase()
 * - Trim: trim(), strip() (Java 11+)
 * - Replace: replace(), replaceFirst(), replaceAll()
 * - Split/Join: split(), String.join()
 * - Validation: isEmpty(), isBlank() (Java 11+)
 * 
 * Performance Tips:
 * - Use StringBuilder for multiple concatenations
 * - Cache frequently used string operations
 * - Use appropriate methods for specific tasks
 * - Consider using StringUtils from Apache Commons for advanced operations
 * 
 * Common Patterns:
 * - Input validation and sanitization
 * - Text formatting and normalization
 * - Parsing and data extraction
 * - Search and replace operations
 */
