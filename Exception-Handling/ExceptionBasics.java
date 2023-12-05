/**
 * ExceptionBasics.java - Understanding Exception fundamentals in Java
 * 
 * Learning Objectives:
 * - Understand what exceptions are and why they occur
 * - Learn about different types of exceptions
 * - See how programs behave with and without exception handling
 * - Understand the exception hierarchy
 * - Practice identifying common exception scenarios
 */

public class ExceptionBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Exception Basics in Java ===\n");
        
        // ========== WHAT ARE EXCEPTIONS? ==========
        
        /*
         * An exception is an event that occurs during program execution
         * that disrupts the normal flow of instructions.
         * 
         * Without exception handling, the program would terminate abruptly.
         * With exception handling, we can gracefully handle errors and continue execution.
         */
        
        System.out.println("=== Understanding Exceptions ===");
        
        // ========== COMMON EXCEPTION SCENARIOS ==========
        
        System.out.println("\n1. NullPointerException Example:");
        demonstrateNullPointerException();
        
        System.out.println("\n2. ArrayIndexOutOfBoundsException Example:");
        demonstrateArrayIndexOutOfBoundsException();
        
        System.out.println("\n3. NumberFormatException Example:");
        demonstrateNumberFormatException();
        
        System.out.println("\n4. ArithmeticException Example:");
        demonstrateArithmeticException();
        
        System.out.println("\n5. IllegalArgumentException Example:");
        demonstrateIllegalArgumentException();
        
        // ========== EXCEPTION HIERARCHY DEMONSTRATION ==========
        
        System.out.println("\n=== Exception Hierarchy ===");
        demonstrateExceptionHierarchy();
        
        // ========== PROGRAM FLOW WITH EXCEPTIONS ==========
        
        System.out.println("\n=== Program Flow with Exceptions ===");
        demonstrateProgramFlow();
        
        System.out.println("\n=== Exception Basics lesson completed! ===");
    }
    
    /**
     * Demonstrates NullPointerException
     * Occurs when trying to use a reference that points to no location in memory (null)
     */
    public static void demonstrateNullPointerException() {
        try {
            String text = null; // This reference points to nothing
            
            // Trying to call a method on null reference
            int length = text.length(); // This will throw NullPointerException
            System.out.println("Text length: " + length);
            
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException!");
            System.out.println("Reason: Trying to use a null reference");
            System.out.println("Solution: Check for null before using the reference");
            
            // Proper way to handle
            String text = null;
            if (text != null) {
                System.out.println("Text length: " + text.length());
            } else {
                System.out.println("Text is null, cannot get length");
            }
        }
    }
    
    /**
     * Demonstrates ArrayIndexOutOfBoundsException
     * Occurs when trying to access an array element with an invalid index
     */
    public static void demonstrateArrayIndexOutOfBoundsException() {
        try {
            int[] numbers = {10, 20, 30, 40, 50}; // Array with indices 0-4
            
            // Valid access
            System.out.println("Valid access - numbers[2]: " + numbers[2]);
            
            // Invalid access - index 10 doesn't exist
            System.out.println("Invalid access - numbers[10]: " + numbers[10]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException!");
            System.out.println("Reason: Trying to access array index that doesn't exist");
            System.out.println("Solution: Always check array bounds before accessing");
            
            // Proper way to handle
            int[] numbers = {10, 20, 30, 40, 50};
            int index = 10;
            
            if (index >= 0 && index < numbers.length) {
                System.out.println("numbers[" + index + "]: " + numbers[index]);
            } else {
                System.out.println("Index " + index + " is out of bounds for array of length " + numbers.length);
            }
        }
    }
    
    /**
     * Demonstrates NumberFormatException
     * Occurs when trying to convert an invalid string to a number
     */
    public static void demonstrateNumberFormatException() {
        try {
            String invalidNumber = "abc123"; // This is not a valid number
            
            // Trying to convert invalid string to integer
            int number = Integer.parseInt(invalidNumber);
            System.out.println("Converted number: " + number);
            
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException!");
            System.out.println("Reason: Trying to convert invalid string to number");
            System.out.println("Invalid string: abc123");
            System.out.println("Solution: Validate string format before conversion");
            
            // Proper way to handle
            String[] testStrings = {"123", "45.67", "abc", "12abc", ""};
            
            for (String str : testStrings) {
                try {
                    int num = Integer.parseInt(str);
                    System.out.println("'" + str + "' converted to: " + num);
                } catch (NumberFormatException ex) {
                    System.out.println("'" + str + "' is not a valid integer");
                }
            }
        }
    }
    
    /**
     * Demonstrates ArithmeticException
     * Occurs during arithmetic operations, commonly division by zero
     */
    public static void demonstrateArithmeticException() {
        try {
            int dividend = 100;
            int divisor = 0; // Division by zero
            
            int result = dividend / divisor; // This will throw ArithmeticException
            System.out.println("Result: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException!");
            System.out.println("Reason: Division by zero");
            System.out.println("Solution: Check divisor before division");
            
            // Proper way to handle
            int dividend = 100;
            int divisor = 0;
            
            if (divisor != 0) {
                int result = dividend / divisor;
                System.out.println("Result: " + result);
            } else {
                System.out.println("Cannot divide by zero!");
            }
        }
    }
    
    /**
     * Demonstrates IllegalArgumentException
     * Occurs when a method receives an inappropriate argument
     */
    public static void demonstrateIllegalArgumentException() {
        try {
            // Method that validates age
            setAge(-5); // Negative age is invalid
            
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException!");
            System.out.println("Reason: " + e.getMessage());
            System.out.println("Solution: Validate arguments before processing");
            
            // Proper usage
            try {
                setAge(25); // Valid age
                System.out.println("Age set successfully!");
            } catch (IllegalArgumentException ex) {
                System.out.println("Failed to set age: " + ex.getMessage());
            }
        }
    }
    
    /**
     * Helper method that validates age and throws IllegalArgumentException for invalid values
     */
    public static void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150, got: " + age);
        }
        System.out.println("Age set to: " + age);
    }
    
    /**
     * Demonstrates exception hierarchy
     * Shows how different exceptions are related
     */
    public static void demonstrateExceptionHierarchy() {
        System.out.println("Exception Hierarchy in Java:");
        System.out.println("Throwable");
        System.out.println("├── Error (System errors, usually unrecoverable)");
        System.out.println("│   ├── OutOfMemoryError");
        System.out.println("│   └── StackOverflowError");
        System.out.println("└── Exception");
        System.out.println("    ├── RuntimeException (Unchecked)");
        System.out.println("    │   ├── NullPointerException");
        System.out.println("    │   ├── ArrayIndexOutOfBoundsException");
        System.out.println("    │   ├── IllegalArgumentException");
        System.out.println("    │   └── NumberFormatException");
        System.out.println("    └── Checked Exceptions");
        System.out.println("        ├── IOException");
        System.out.println("        ├── SQLException");
        System.out.println("        └── ClassNotFoundException");
        
        // Demonstrating catching parent exception
        try {
            throw new NumberFormatException("Demo exception");
        } catch (RuntimeException e) { // Parent class catches child exception
            System.out.println("\nCaught using parent class: " + e.getClass().getSimpleName());
        }
    }
    
    /**
     * Demonstrates how program flow changes with exception handling
     */
    public static void demonstrateProgramFlow() {
        System.out.println("=== Without Exception Handling ===");
        
        // Simulate what happens without exception handling
        System.out.println("Step 1: Program starts");
        System.out.println("Step 2: Performing operations");
        System.out.println("Step 3: About to encounter error...");
        // If exception occurred here without handling, program would terminate
        System.out.println("Step 4: This might not execute if exception occurred");
        
        System.out.println("\n=== With Exception Handling ===");
        
        try {
            System.out.println("Step 1: Program starts");
            System.out.println("Step 2: Performing operations");
            System.out.println("Step 3: About to encounter error...");
            
            // Simulate an exception
            int result = 10 / 0; // This will throw ArithmeticException
            
            System.out.println("Step 4: This won't execute due to exception");
            
        } catch (ArithmeticException e) {
            System.out.println("Step 4: Exception caught and handled gracefully");
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Step 5: Program continues after exception handling");
        System.out.println("Step 6: Program completes successfully");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Exceptions are runtime errors that disrupt normal program flow
 * 2. Without handling, exceptions cause program termination
 * 3. With proper handling, programs can recover and continue
 * 4. Common exceptions include NullPointer, ArrayIndexOutOfBounds, NumberFormat
 * 5. Exception hierarchy allows catching parent classes to handle multiple exception types
 * 6. Prevention is better than handling - validate inputs when possible
 * 
 * Exception Categories:
 * - Checked: Must be handled or declared (IOException, SQLException)
 * - Unchecked: Runtime exceptions, handling optional (NullPointerException)
 * - Errors: System-level problems, usually unrecoverable (OutOfMemoryError)
 * 
 * Best Practices:
 * - Always validate inputs to prevent exceptions
 * - Handle exceptions gracefully with meaningful messages
 * - Don't catch exceptions just to ignore them
 * - Use specific exception types rather than generic Exception
 * - Log exception details for debugging
 */
