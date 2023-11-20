/**
 * StringBasics.java - Understanding String fundamentals in Java
 * 
 * Learning Objectives:
 * - Understand what strings are and how they work
 * - Learn different ways to create strings
 * - Understand string immutability concept
 * - Explore string pool and memory management
 * - Practice basic string operations
 */

public class StringBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== String Basics in Java ===\n");
        
        // ========== WHAT ARE STRINGS? ==========
        
        /*
         * A String in Java is:
         * - A sequence of characters
         * - An object (reference type, not primitive)
         * - Immutable (cannot be changed after creation)
         * - Stored in heap memory (with string pool optimization)
         */
        
        System.out.println("=== String Creation Methods ===");
        
        // Method 1: String literal (most common)
        String name1 = "John Doe";
        
        // Method 2: Using new keyword
        String name2 = new String("John Doe");
        
        // Method 3: From character array
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String name3 = new String(charArray);
        
        // Method 4: Empty string
        String empty1 = "";           // Empty string literal
        String empty2 = new String(); // Empty string object
        
        System.out.println("String literal: " + name1);
        System.out.println("String object: " + name2);
        System.out.println("From char array: " + name3);
        System.out.println("Empty strings: '" + empty1 + "' and '" + empty2 + "'");
        
        // ========== STRING IMMUTABILITY ==========
        
        System.out.println("\n=== String Immutability ===");
        
        String original = "Hello";
        System.out.println("Original string: " + original);
        
        // When we "modify" a string, a new string is created
        String modified = original + " World";
        System.out.println("After concatenation:");
        System.out.println("Original: " + original);  // Still "Hello"
        System.out.println("Modified: " + modified);  // "Hello World"
        
        // The original string is unchanged - this is immutability!
        
        // Another example
        String text = "Java";
        text.toUpperCase(); // This creates a new string but doesn't change 'text'
        System.out.println("After toUpperCase() call: " + text); // Still "Java"
        
        // To actually change the reference, we need assignment
        text = text.toUpperCase();
        System.out.println("After assignment: " + text); // Now "JAVA"
        
        // ========== STRING POOL ==========
        
        System.out.println("\n=== String Pool Concept ===");
        
        /*
         * String Pool is a special memory area in heap where string literals are stored.
         * It helps save memory by reusing identical string literals.
         */
        
        String str1 = "Hello";        // Stored in string pool
        String str2 = "Hello";        // Reuses the same object from pool
        String str3 = new String("Hello"); // Creates new object in heap (not pool)
        
        // Checking if they refer to the same object
        System.out.println("str1 == str2: " + (str1 == str2));     // true (same object)
        System.out.println("str1 == str3: " + (str1 == str3));     // false (different objects)
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true (same content)
        
        // intern() method can add strings to pool
        String str4 = new String("Hello").intern(); // Now in pool
        System.out.println("str1 == str4: " + (str1 == str4));     // true (same object)
        
        // ========== BASIC STRING OPERATIONS ==========
        
        System.out.println("\n=== Basic String Operations ===");
        
        String message = "Java Programming";
        
        // Getting string length
        System.out.println("Length of '" + message + "': " + message.length());
        
        // Accessing individual characters
        System.out.println("First character: " + message.charAt(0));
        System.out.println("Last character: " + message.charAt(message.length() - 1));
        
        // String concatenation
        String greeting = "Hello";
        String target = "World";
        String combined1 = greeting + " " + target;           // Using + operator
        String combined2 = greeting.concat(" ").concat(target); // Using concat() method
        
        System.out.println("Concatenation with +: " + combined1);
        System.out.println("Concatenation with concat(): " + combined2);
        
        // ========== STRING COMPARISON ==========
        
        System.out.println("\n=== String Comparison ===");
        
        String word1 = "apple";
        String word2 = "Apple";
        String word3 = "apple";
        
        // Content comparison (case-sensitive)
        System.out.println("word1.equals(word2): " + word1.equals(word2));   // false
        System.out.println("word1.equals(word3): " + word1.equals(word3));   // true
        
        // Content comparison (case-insensitive)
        System.out.println("word1.equalsIgnoreCase(word2): " + word1.equalsIgnoreCase(word2)); // true
        
        // Lexicographic comparison
        System.out.println("word1.compareTo(word2): " + word1.compareTo(word2)); // positive (a > A in ASCII)
        System.out.println("word1.compareTo(word3): " + word1.compareTo(word3)); // 0 (equal)
        
        // ========== STRING SEARCHING ==========
        
        System.out.println("\n=== String Searching ===");
        
        String sentence = "The quick brown fox jumps over the lazy dog";
        
        // Check if string contains substring
        System.out.println("Contains 'fox': " + sentence.contains("fox"));
        System.out.println("Contains 'cat': " + sentence.contains("cat"));
        
        // Find index of substring
        System.out.println("Index of 'fox': " + sentence.indexOf("fox"));
        System.out.println("Index of 'the': " + sentence.indexOf("the"));        // First occurrence
        System.out.println("Last index of 'the': " + sentence.lastIndexOf("the")); // Last occurrence
        
        // Check prefix and suffix
        System.out.println("Starts with 'The': " + sentence.startsWith("The"));
        System.out.println("Ends with 'dog': " + sentence.endsWith("dog"));
        
        // ========== STRING EXTRACTION ==========
        
        System.out.println("\n=== String Extraction ===");
        
        String data = "Java Programming Language";
        
        // Extract substring
        System.out.println("Substring(0, 4): " + data.substring(0, 4));     // "Java"
        System.out.println("Substring(5): " + data.substring(5));           // "Programming Language"
        System.out.println("Substring(5, 16): " + data.substring(5, 16));   // "Programming"
        
        // ========== STRING TRANSFORMATION ==========
        
        System.out.println("\n=== String Transformation ===");
        
        String mixedCase = "  Hello World  ";
        
        // Case conversion
        System.out.println("Original: '" + mixedCase + "'");
        System.out.println("Upper case: '" + mixedCase.toUpperCase() + "'");
        System.out.println("Lower case: '" + mixedCase.toLowerCase() + "'");
        System.out.println("Trimmed: '" + mixedCase.trim() + "'");
        
        // String replacement
        String text2 = "Java is great. Java is powerful.";
        System.out.println("Original: " + text2);
        System.out.println("Replace 'Java' with 'Python': " + text2.replace("Java", "Python"));
        System.out.println("Replace first 'Java': " + text2.replaceFirst("Java", "Python"));
        
        // ========== SPECIAL CHARACTERS AND ESCAPE SEQUENCES ==========
        
        System.out.println("\n=== Special Characters ===");
        
        // Escape sequences
        String quotes = "He said, \"Hello World!\"";
        String path = "C:\\Users\\Documents\\file.txt";
        String multiLine = "Line 1\nLine 2\nLine 3";
        String tabbed = "Name:\tJohn\tAge:\t25";
        
        System.out.println("Quotes: " + quotes);
        System.out.println("Path: " + path);
        System.out.println("Multi-line:\n" + multiLine);
        System.out.println("Tabbed: " + tabbed);
        
        // Unicode characters
        String unicode = "Unicode: \u0048\u0065\u006C\u006C\u006F"; // "Hello"
        System.out.println(unicode);
        
        System.out.println("\n=== String Basics lesson completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Strings are immutable - operations create new strings
 * 2. String pool optimizes memory for string literals
 * 3. Use equals() for content comparison, not ==
 * 4. String concatenation with + is convenient but can be inefficient
 * 5. Many useful methods available for string manipulation
 * 6. Always handle null strings to avoid NullPointerException
 * 
 * Performance Tips:
 * - Use StringBuilder for multiple concatenations
 * - Reuse string objects when possible
 * - Be aware of string pool behavior
 * - Use appropriate methods for your use case
 * 
 * Common Methods Summary:
 * - length(), charAt(), substring()
 * - equals(), equalsIgnoreCase(), compareTo()
 * - contains(), indexOf(), startsWith(), endsWith()
 * - toUpperCase(), toLowerCase(), trim()
 * - replace(), replaceFirst(), replaceAll()
 */
