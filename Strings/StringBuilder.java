/**
 * StringBuilder.java - Understanding StringBuilder for Efficient String Operations
 * 
 * Learning Objectives:
 * - Understand why StringBuilder is needed over String concatenation
 * - Learn StringBuilder methods and operations
 * - Compare performance between String and StringBuilder
 * - Practice building strings efficiently
 * - Understand StringBuffer vs StringBuilder differences
 */

public class StringBuilder {
    
    public static void main(String[] args) {
        
        System.out.println("=== StringBuilder for Efficient String Operations ===\n");
        
        // ========== WHY STRINGBUILDER? ==========
        
        System.out.println("=== Why StringBuilder? ===");
        whyStringBuilder();
        
        // ========== STRINGBUILDER BASICS ==========
        
        System.out.println("\n=== StringBuilder Basics ===");
        stringBuilderBasics();
        
        // ========== STRINGBUILDER METHODS ==========
        
        System.out.println("\n=== StringBuilder Methods ===");
        stringBuilderMethods();
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("\n=== Performance Comparison ===");
        performanceComparison();
        
        // ========== STRINGBUFFER VS STRINGBUILDER ==========
        
        System.out.println("\n=== StringBuffer vs StringBuilder ===");
        stringBufferVsStringBuilder();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        practicalExamples();
        
        System.out.println("\n=== StringBuilder lesson completed! ===");
    }
    
    /**
     * Explains why StringBuilder is needed
     */
    public static void whyStringBuilder() {
        System.out.println("String Immutability Problem:");
        
        // Problem with String concatenation
        String result = "";
        System.out.println("String concatenation in loop:");
        
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            result += "a"; // Creates new String object each time
        }
        long endTime = System.nanoTime();
        
        System.out.println("String concatenation time: " + (endTime - startTime) / 1000000.0 + " ms");
        System.out.println("Final length: " + result.length());
        
        // Solution with StringBuilder
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        System.out.println("\nStringBuilder approach:");
        
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            sb.append("a"); // Modifies existing buffer
        }
        endTime = System.nanoTime();
        
        System.out.println("StringBuilder time: " + (endTime - startTime) / 1000000.0 + " ms");
        System.out.println("Final length: " + sb.length());
        
        System.out.println("\nWhy StringBuilder is faster:");
        System.out.println("- String: Creates new object for each concatenation");
        System.out.println("- StringBuilder: Uses resizable buffer, modifies in place");
        System.out.println("- String: O(n²) for n concatenations");
        System.out.println("- StringBuilder: O(n) for n concatenations");
    }
    
    /**
     * Demonstrates StringBuilder creation and basic operations
     */
    public static void stringBuilderBasics() {
        
        // Creating StringBuilder
        java.lang.StringBuilder sb1 = new java.lang.StringBuilder(); // Empty, capacity 16
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(50); // Empty, capacity 50
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder("Hello"); // With initial string
        
        System.out.println("sb1 capacity: " + sb1.capacity() + ", length: " + sb1.length());
        System.out.println("sb2 capacity: " + sb2.capacity() + ", length: " + sb2.length());
        System.out.println("sb3 capacity: " + sb3.capacity() + ", length: " + sb3.length());
        System.out.println("sb3 content: \"" + sb3.toString() + "\"");
        
        // Basic operations
        sb1.append("Java");
        sb1.append(" ");
        sb1.append("Programming");
        
        System.out.println("\nAfter appending:");
        System.out.println("sb1: \"" + sb1.toString() + "\"");
        System.out.println("sb1 capacity: " + sb1.capacity() + ", length: " + sb1.length());
        
        // Capacity expansion
        System.out.println("\nCapacity expansion demonstration:");
        java.lang.StringBuilder sbCapacity = new java.lang.StringBuilder(5);
        System.out.println("Initial capacity: " + sbCapacity.capacity());
        
        sbCapacity.append("Hello World"); // Exceeds initial capacity
        System.out.println("After exceeding capacity: " + sbCapacity.capacity());
        System.out.println("Content: \"" + sbCapacity.toString() + "\"");
        
        // Manual capacity management
        sbCapacity.ensureCapacity(100);
        System.out.println("After ensureCapacity(100): " + sbCapacity.capacity());
        
        sbCapacity.trimToSize();
        System.out.println("After trimToSize(): " + sbCapacity.capacity());
    }
    
    /**
     * Demonstrates various StringBuilder methods
     */
    public static void stringBuilderMethods() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Hello World");
        
        System.out.println("Initial: \"" + sb.toString() + "\"");
        
        // append() methods
        sb.append(" - Java");
        sb.append(' ');
        sb.append(2024);
        sb.append('!');
        System.out.println("After appends: \"" + sb.toString() + "\"");
        
        // insert() methods
        sb.insert(5, " Beautiful");
        System.out.println("After insert at 5: \"" + sb.toString() + "\"");
        
        sb.insert(0, ">>> ");
        System.out.println("After insert at 0: \"" + sb.toString() + "\"");
        
        // delete() and deleteCharAt()
        sb.delete(0, 4); // Remove ">>> "
        System.out.println("After delete(0, 4): \"" + sb.toString() + "\"");
        
        sb.deleteCharAt(sb.length() - 1); // Remove last character
        System.out.println("After deleteCharAt(last): \"" + sb.toString() + "\"");
        
        // replace()
        sb.replace(6, 15, "Amazing"); // Replace "Beautiful" with "Amazing"
        System.out.println("After replace(6, 15, \"Amazing\"): \"" + sb.toString() + "\"");
        
        // reverse()
        java.lang.StringBuilder sbReverse = new java.lang.StringBuilder("Hello");
        System.out.println("Before reverse: \"" + sbReverse.toString() + "\"");
        sbReverse.reverse();
        System.out.println("After reverse: \"" + sbReverse.toString() + "\"");
        
        // setCharAt() and setLength()
        java.lang.StringBuilder sbChar = new java.lang.StringBuilder("Hello");
        sbChar.setCharAt(1, 'a');
        System.out.println("After setCharAt(1, 'a'): \"" + sbChar.toString() + "\"");
        
        sbChar.setLength(3); // Truncate to 3 characters
        System.out.println("After setLength(3): \"" + sbChar.toString() + "\"");
        
        sbChar.setLength(10); // Extend with null characters
        System.out.println("After setLength(10): \"" + sbChar.toString() + "\" (length: " + sbChar.length() + ")");
        
        // charAt() and indexOf()
        java.lang.StringBuilder sbSearch = new java.lang.StringBuilder("Hello World Hello");
        System.out.println("charAt(6): '" + sbSearch.charAt(6) + "'");
        System.out.println("indexOf(\"Hello\"): " + sbSearch.indexOf("Hello"));
        System.out.println("lastIndexOf(\"Hello\"): " + sbSearch.lastIndexOf("Hello"));
        
        // substring()
        System.out.println("substring(6, 11): \"" + sbSearch.substring(6, 11) + "\"");
    }
    
    /**
     * Compares performance between String and StringBuilder
     */
    public static void performanceComparison() {
        int iterations = 10000;
        
        System.out.println("Performance test with " + iterations + " iterations:");
        
        // String concatenation performance
        long startTime = System.nanoTime();
        String stringResult = "";
        for (int i = 0; i < iterations; i++) {
            stringResult += "a";
        }
        long stringTime = System.nanoTime() - startTime;
        
        // StringBuilder performance
        startTime = System.nanoTime();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        String sbResult = sb.toString();
        long sbTime = System.nanoTime() - startTime;
        
        // StringBuilder with initial capacity
        startTime = System.nanoTime();
        java.lang.StringBuilder sbCapacity = new java.lang.StringBuilder(iterations);
        for (int i = 0; i < iterations; i++) {
            sbCapacity.append("a");
        }
        String sbCapacityResult = sbCapacity.toString();
        long sbCapacityTime = System.nanoTime() - startTime;
        
        System.out.println("String concatenation time: " + stringTime / 1000000.0 + " ms");
        System.out.println("StringBuilder time: " + sbTime / 1000000.0 + " ms");
        System.out.println("StringBuilder (with capacity) time: " + sbCapacityTime / 1000000.0 + " ms");
        
        System.out.println("\nPerformance improvement:");
        System.out.println("StringBuilder is " + (stringTime / (double) sbTime) + "x faster");
        System.out.println("StringBuilder with capacity is " + (stringTime / (double) sbCapacityTime) + "x faster");
        
        // Memory usage demonstration
        System.out.println("\nMemory efficiency:");
        System.out.println("String creates " + iterations + " intermediate objects");
        System.out.println("StringBuilder uses single resizable buffer");
    }
    
    /**
     * Compares StringBuffer and StringBuilder
     */
    public static void stringBufferVsStringBuilder() {
        System.out.println("StringBuffer vs StringBuilder comparison:");
        
        // StringBuilder (not thread-safe, faster)
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        // StringBuffer (thread-safe, slower)
        StringBuffer sbf = new StringBuffer();
        
        int iterations = 100000;
        
        // StringBuilder performance
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long sbTime = System.nanoTime() - startTime;
        
        // StringBuffer performance
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        long sbfTime = System.nanoTime() - startTime;
        
        System.out.println("StringBuilder time: " + sbTime / 1000000.0 + " ms");
        System.out.println("StringBuffer time: " + sbfTime / 1000000.0 + " ms");
        System.out.println("StringBuilder is " + (sbfTime / (double) sbTime) + "x faster");
        
        System.out.println("\nKey differences:");
        System.out.println("┌─────────────────┬─────────────────┬─────────────────┐");
        System.out.println("│ Feature         │ StringBuilder   │ StringBuffer    │");
        System.out.println("├─────────────────┼─────────────────┼─────────────────┤");
        System.out.println("│ Thread Safety   │ Not thread-safe │ Thread-safe     │");
        System.out.println("│ Performance     │ Faster          │ Slower          │");
        System.out.println("│ Synchronization │ No              │ Yes             │");
        System.out.println("│ Since Version   │ Java 5          │ Java 1.0        │");
        System.out.println("│ Use Case        │ Single thread   │ Multi-thread    │");
        System.out.println("└─────────────────┴─────────────────┴─────────────────┘");
        
        System.out.println("\nRecommendation:");
        System.out.println("- Use StringBuilder for single-threaded applications (most common)");
        System.out.println("- Use StringBuffer only when thread safety is required");
    }
    
    /**
     * Demonstrates practical StringBuilder usage examples
     */
    public static void practicalExamples() {
        
        // Example 1: Building CSV string
        System.out.println("=== Example 1: Building CSV ===");
        String[] data = {"John", "25", "Engineer", "New York"};
        String csv = buildCSV(data);
        System.out.println("CSV: " + csv);
        
        // Example 2: Building HTML
        System.out.println("\n=== Example 2: Building HTML ===");
        String[] items = {"Apple", "Banana", "Orange"};
        String html = buildHTMLList(items);
        System.out.println("HTML:\n" + html);
        
        // Example 3: Building SQL query
        System.out.println("\n=== Example 3: Building SQL Query ===");
        String[] columns = {"name", "age", "city"};
        String[] values = {"'John'", "25", "'NYC'"};
        String sql = buildInsertQuery("users", columns, values);
        System.out.println("SQL: " + sql);
        
        // Example 4: String formatting
        System.out.println("\n=== Example 4: Custom String Formatting ===");
        String formatted = formatUserInfo("Alice", 30, "alice@email.com");
        System.out.println("Formatted: " + formatted);
        
        // Example 5: Building file path
        System.out.println("\n=== Example 5: Building File Path ===");
        String[] pathComponents = {"home", "user", "documents", "file.txt"};
        String path = buildFilePath(pathComponents);
        System.out.println("Path: " + path);
        
        // Example 6: Reversing words in sentence
        System.out.println("\n=== Example 6: Reversing Words ===");
        String sentence = "Hello World Java Programming";
        String reversed = reverseWords(sentence);
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + reversed);
        
        // Example 7: Building JSON-like string
        System.out.println("\n=== Example 7: Building JSON-like String ===");
        String json = buildSimpleJSON("John", 25, "Engineer");
        System.out.println("JSON: " + json);
    }
    
    /**
     * Builds CSV string from array
     */
    public static String buildCSV(String[] data) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Builds HTML unordered list
     */
    public static String buildHTMLList(String[] items) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        sb.append("<ul>\n");
        for (String item : items) {
            sb.append("  <li>").append(item).append("</li>\n");
        }
        sb.append("</ul>");
        
        return sb.toString();
    }
    
    /**
     * Builds SQL INSERT query
     */
    public static String buildInsertQuery(String table, String[] columns, String[] values) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        sb.append("INSERT INTO ").append(table).append(" (");
        
        // Add columns
        for (int i = 0; i < columns.length; i++) {
            sb.append(columns[i]);
            if (i < columns.length - 1) {
                sb.append(", ");
            }
        }
        
        sb.append(") VALUES (");
        
        // Add values
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i < values.length - 1) {
                sb.append(", ");
            }
        }
        
        sb.append(")");
        
        return sb.toString();
    }
    
    /**
     * Formats user information
     */
    public static String formatUserInfo(String name, int age, String email) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        sb.append("User Information:\n");
        sb.append("  Name: ").append(name).append("\n");
        sb.append("  Age: ").append(age).append(" years old\n");
        sb.append("  Email: ").append(email);
        
        return sb.toString();
    }
    
    /**
     * Builds file path from components
     */
    public static String buildFilePath(String[] components) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        for (int i = 0; i < components.length; i++) {
            sb.append(components[i]);
            if (i < components.length - 1) {
                sb.append("/"); // Unix-style path separator
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Reverses words in a sentence
     */
    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Builds simple JSON-like string
     */
    public static String buildSimpleJSON(String name, int age, String profession) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        
        sb.append("{\n");
        sb.append("  \"name\": \"").append(name).append("\",\n");
        sb.append("  \"age\": ").append(age).append(",\n");
        sb.append("  \"profession\": \"").append(profession).append("\"\n");
        sb.append("}");
        
        return sb.toString();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. StringBuilder is mutable and efficient for string building
 * 2. Use StringBuilder when performing multiple string operations
 * 3. String concatenation in loops is inefficient due to immutability
 * 4. StringBuilder uses resizable buffer for better performance
 * 5. StringBuffer is thread-safe but slower than StringBuilder
 * 
 * When to Use StringBuilder:
 * - Multiple string concatenations
 * - Building strings in loops
 * - Dynamic string construction
 * - Performance-critical string operations
 * - Single-threaded applications
 * 
 * StringBuilder Methods:
 * - append(): Add content to end
 * - insert(): Insert content at specific position
 * - delete(): Remove characters
 * - replace(): Replace characters in range
 * - reverse(): Reverse the content
 * - setCharAt(): Change character at position
 * - toString(): Convert to String
 * 
 * Performance Tips:
 * - Set initial capacity if size is known
 * - Use StringBuilder for 3+ concatenations
 * - Avoid toString() in loops
 * - Consider StringJoiner for delimiter-separated values
 * 
 * Best Practices:
 * - Use StringBuilder for building, String for storage
 * - Set appropriate initial capacity
 * - Use method chaining when possible
 * - Convert to String only when needed
 */
