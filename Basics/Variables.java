/**
 * Variables.java - Understanding Java variables and data types
 * 
 * Learning Objectives:
 * - Learn about primitive data types
 * - Understand variable declaration and initialization
 * - Practice naming conventions
 * - Explore type casting and conversion
 */

public class Variables {
    
    public static void main(String[] args) {
        
        System.out.println("=== Java Variables and Data Types ===\n");
        
        // ========== INTEGER TYPES ==========
        
        // byte: 8-bit, range -128 to 127
        byte smallNumber = 100;
        System.out.println("byte value: " + smallNumber);
        
        // short: 16-bit, range -32,768 to 32,767
        short mediumNumber = 25000;
        System.out.println("short value: " + mediumNumber);
        
        // int: 32-bit, most commonly used integer type
        int age = 25;
        int population = 1000000;
        System.out.println("int values: age = " + age + ", population = " + population);
        
        // long: 64-bit, for very large numbers (note the 'L' suffix)
        long bigNumber = 9876543210L;
        System.out.println("long value: " + bigNumber);
        
        // ========== FLOATING-POINT TYPES ==========
        
        // float: 32-bit decimal (note the 'f' suffix)
        float price = 19.99f;
        System.out.println("float value: " + price);
        
        // double: 64-bit decimal, more precise than float
        double pi = 3.14159265359;
        double salary = 75000.50;
        System.out.println("double values: pi = " + pi + ", salary = " + salary);
        
        // ========== CHARACTER TYPE ==========
        
        // char: 16-bit Unicode character (single quotes)
        char grade = 'A';
        char symbol = '@';
        char unicodeChar = '\u0041'; // Unicode for 'A'
        System.out.println("char values: " + grade + ", " + symbol + ", " + unicodeChar);
        
        // ========== BOOLEAN TYPE ==========
        
        // boolean: true or false only
        boolean isStudent = true;
        boolean isWorking = false;
        boolean canVote = age >= 18; // Expression result
        System.out.println("boolean values: isStudent = " + isStudent + 
                          ", canVote = " + canVote);
        
        // ========== STRING TYPE ==========
        
        // String: Not a primitive type, but very commonly used
        String name = "John Doe";
        String course = "Java Programming";
        System.out.println("String values: " + name + " is learning " + course);
        
        // ========== VARIABLE NAMING CONVENTIONS ==========
        
        // Good naming practices:
        int studentAge = 20;           // camelCase for variables
        String firstName = "Alice";    // descriptive names
        boolean isActive = true;       // boolean variables often start with 'is'
        final double TAX_RATE = 0.08;  // UPPER_CASE for constants
        
        System.out.println("\n=== Variable Naming Examples ===");
        System.out.println("Student: " + firstName + ", Age: " + studentAge);
        System.out.println("Tax Rate: " + TAX_RATE);
        
        // ========== TYPE CASTING ==========
        
        System.out.println("\n=== Type Casting Examples ===");
        
        // Implicit casting (automatic) - smaller to larger type
        int intValue = 100;
        double doubleValue = intValue; // int to double
        System.out.println("Implicit casting: int " + intValue + " to double " + doubleValue);
        
        // Explicit casting (manual) - larger to smaller type
        double largeValue = 99.99;
        int smallValue = (int) largeValue; // double to int (loses decimal part)
        System.out.println("Explicit casting: double " + largeValue + " to int " + smallValue);
        
        // ========== VARIABLE SCOPE EXAMPLE ==========
        
        {
            // This is a code block - variables declared here have block scope
            int blockVariable = 50;
            System.out.println("Block variable: " + blockVariable);
            // blockVariable is only accessible within this block
        }
        // System.out.println(blockVariable); // This would cause an error!
        
        System.out.println("\n=== Variables lesson completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Choose appropriate data types based on your needs
 * 2. Use meaningful variable names (camelCase convention)
 * 3. Initialize variables before using them
 * 4. Be careful with type casting - you might lose data
 * 5. Understand variable scope - where variables can be accessed
 * 
 * Memory sizes:
 * byte(1), short(2), int(4), long(8), float(4), double(8), char(2), boolean(1)
 */
