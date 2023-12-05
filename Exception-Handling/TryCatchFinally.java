/**
 * TryCatchFinally.java - Understanding Try-Catch-Finally blocks in Java
 * 
 * Learning Objectives:
 * - Master try-catch-finally syntax and execution flow
 * - Learn to handle multiple exception types
 * - Understand exception propagation and handling hierarchy
 * - Practice resource management with finally blocks
 * - Explore try-with-resources for automatic resource management
 */

import java.io.*;
import java.util.Scanner;

public class TryCatchFinally {
    
    public static void main(String[] args) {
        
        System.out.println("=== Try-Catch-Finally in Java ===\n");
        
        // ========== BASIC TRY-CATCH ==========
        
        System.out.println("=== Basic Try-Catch ===");
        basicTryCatch();
        
        // ========== MULTIPLE CATCH BLOCKS ==========
        
        System.out.println("\n=== Multiple Catch Blocks ===");
        multipleCatchBlocks();
        
        // ========== FINALLY BLOCK ==========
        
        System.out.println("\n=== Finally Block ===");
        finallyBlockDemo();
        
        // ========== TRY-WITH-RESOURCES ==========
        
        System.out.println("\n=== Try-with-Resources ===");
        tryWithResourcesDemo();
        
        // ========== EXCEPTION PROPAGATION ==========
        
        System.out.println("\n=== Exception Propagation ===");
        exceptionPropagationDemo();
        
        // ========== NESTED TRY-CATCH ==========
        
        System.out.println("\n=== Nested Try-Catch ===");
        nestedTryCatchDemo();
        
        // ========== BEST PRACTICES ==========
        
        System.out.println("\n=== Best Practices ===");
        bestPracticesDemo();
        
        System.out.println("\n=== Try-Catch-Finally lesson completed! ===");
    }
    
    /**
     * Demonstrates basic try-catch syntax and usage
     */
    public static void basicTryCatch() {
        System.out.println("Basic try-catch example:");
        
        try {
            // Code that might throw an exception
            int[] numbers = {1, 2, 3, 4, 5};
            System.out.println("Accessing valid index: " + numbers[2]);
            
            // This will throw ArrayIndexOutOfBoundsException
            System.out.println("Accessing invalid index: " + numbers[10]);
            
            // This line won't execute due to exception above
            System.out.println("This line won't be reached");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the specific exception
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
            System.out.println("Array index was out of bounds!");
        }
        
        System.out.println("Program continues after exception handling");
    }
    
    /**
     * Demonstrates handling multiple exception types
     */
    public static void multipleCatchBlocks() {
        System.out.println("Multiple catch blocks example:");
        
        String[] testInputs = {"123", "abc", null, "456"};
        
        for (String input : testInputs) {
            try {
                System.out.println("\nProcessing input: " + input);
                
                // This might throw NullPointerException
                int length = input.length();
                System.out.println("Input length: " + length);
                
                // This might throw NumberFormatException
                int number = Integer.parseInt(input);
                System.out.println("Parsed number: " + number);
                
                // This might throw ArithmeticException
                int result = 100 / number;
                System.out.println("100 divided by " + number + " = " + result);
                
            } catch (NullPointerException e) {
                System.out.println("Error: Input is null");
            } catch (NumberFormatException e) {
                System.out.println("Error: Cannot parse '" + input + "' as number");
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero");
            } catch (Exception e) {
                // Generic catch block for any other exceptions
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
        
        // Multi-catch block (Java 7+)
        try {
            // Some operation that might throw multiple exception types
            performRiskyOperation();
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Caught IOException or IllegalArgumentException: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates finally block usage
     */
    public static void finallyBlockDemo() {
        System.out.println("Finally block demonstration:");
        
        // Example 1: Finally block always executes
        try {
            System.out.println("In try block");
            int result = 10 / 2; // No exception
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("In catch block");
        } finally {
            System.out.println("In finally block - always executes");
        }
        
        System.out.println();
        
        // Example 2: Finally block executes even when exception occurs
        try {
            System.out.println("In try block");
            int result = 10 / 0; // ArithmeticException
            System.out.println("This won't print");
        } catch (ArithmeticException e) {
            System.out.println("In catch block: " + e.getMessage());
        } finally {
            System.out.println("In finally block - executes even with exception");
        }
        
        System.out.println();
        
        // Example 3: Resource cleanup in finally
        FileInputStream fis = null;
        try {
            System.out.println("Attempting to open file...");
            fis = new FileInputStream("nonexistent.txt");
            // File operations would go here
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } finally {
            // Cleanup resources
            if (fis != null) {
                try {
                    fis.close();
                    System.out.println("File stream closed in finally block");
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            } else {
                System.out.println("No file stream to close");
            }
        }
    }
    
    /**
     * Demonstrates try-with-resources for automatic resource management
     */
    public static void tryWithResourcesDemo() {
        System.out.println("Try-with-resources demonstration:");
        
        // Example 1: Single resource
        try (Scanner scanner = new Scanner("Hello World")) {
            System.out.println("Reading from scanner: " + scanner.nextLine());
            // Scanner is automatically closed when try block exits
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        // No need for finally block to close scanner
        
        System.out.println();
        
        // Example 2: Multiple resources
        String fileName = "test_output.txt";
        try (FileWriter writer = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            
            bufferedWriter.write("Hello, Try-with-Resources!");
            bufferedWriter.newLine();
            bufferedWriter.write("This is automatically managed.");
            
            System.out.println("Successfully wrote to file: " + fileName);
            
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        // Both writer and bufferedWriter are automatically closed
        
        // Clean up the test file
        File testFile = new File(fileName);
        if (testFile.exists() && testFile.delete()) {
            System.out.println("Test file cleaned up");
        }
        
        System.out.println();
        
        // Example 3: Custom resource with AutoCloseable
        try (CustomResource resource = new CustomResource("MyResource")) {
            resource.doSomething();
            // CustomResource will be automatically closed
        } catch (Exception e) {
            System.out.println("Error with custom resource: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates exception propagation up the call stack
     */
    public static void exceptionPropagationDemo() {
        System.out.println("Exception propagation demonstration:");
        
        try {
            methodA();
        } catch (RuntimeException e) {
            System.out.println("Caught exception in main: " + e.getMessage());
            System.out.println("Exception type: " + e.getClass().getSimpleName());
        }
    }
    
    /**
     * Method A calls Method B
     */
    public static void methodA() {
        System.out.println("In methodA - calling methodB");
        methodB(); // Exception will propagate from here
    }
    
    /**
     * Method B calls Method C
     */
    public static void methodB() {
        System.out.println("In methodB - calling methodC");
        methodC(); // Exception will propagate from here
    }
    
    /**
     * Method C throws an exception
     */
    public static void methodC() {
        System.out.println("In methodC - about to throw exception");
        throw new RuntimeException("Exception from methodC");
    }
    
    /**
     * Demonstrates nested try-catch blocks
     */
    public static void nestedTryCatchDemo() {
        System.out.println("Nested try-catch demonstration:");
        
        try {
            System.out.println("Outer try block");
            
            try {
                System.out.println("Inner try block");
                int result = 10 / 0; // ArithmeticException
                System.out.println("This won't execute");
                
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Arithmetic exception handled");
                
                // Throwing a new exception from catch block
                throw new RuntimeException("New exception from inner catch");
            }
            
            System.out.println("This won't execute due to exception in inner catch");
            
        } catch (RuntimeException e) {
            System.out.println("Outer catch: " + e.getMessage());
        } finally {
            System.out.println("Outer finally block");
        }
    }
    
    /**
     * Demonstrates exception handling best practices
     */
    public static void bestPracticesDemo() {
        System.out.println("Exception handling best practices:");
        
        // Practice 1: Be specific with exception types
        try {
            riskyOperation();
        } catch (FileNotFoundException e) {
            System.out.println("Specific handling for file not found");
        } catch (IOException e) {
            System.out.println("General I/O error handling");
        } catch (Exception e) {
            System.out.println("Fallback for any other exception");
        }
        
        // Practice 2: Log exception details
        try {
            anotherRiskyOperation();
        } catch (Exception e) {
            logException(e);
        }
        
        // Practice 3: Don't ignore exceptions
        try {
            potentiallyFailingOperation();
        } catch (Exception e) {
            // BAD: Empty catch block
            // Good: At least log the exception
            System.out.println("Operation failed: " + e.getMessage());
        }
        
        // Practice 4: Use try-with-resources for resource management
        try (AutoCloseable resource = createResource()) {
            // Use resource
            System.out.println("Using resource safely");
        } catch (Exception e) {
            System.out.println("Resource operation failed: " + e.getMessage());
        }
    }
    
    /**
     * Helper method that might throw IOException
     */
    public static void performRiskyOperation() throws IOException, IllegalArgumentException {
        // Simulate different types of exceptions
        double random = Math.random();
        if (random < 0.3) {
            throw new IOException("Simulated I/O error");
        } else if (random < 0.6) {
            throw new IllegalArgumentException("Simulated argument error");
        }
        // Otherwise, operation succeeds
    }
    
    /**
     * Helper method for demonstrating specific exception handling
     */
    public static void riskyOperation() throws IOException {
        // Simulate file operation
        if (Math.random() < 0.5) {
            throw new FileNotFoundException("Simulated file not found");
        } else {
            throw new IOException("Simulated I/O error");
        }
    }
    
    /**
     * Another risky operation for demonstration
     */
    public static void anotherRiskyOperation() throws Exception {
        throw new Exception("Simulated exception for logging demo");
    }
    
    /**
     * Potentially failing operation
     */
    public static void potentiallyFailingOperation() throws Exception {
        if (Math.random() < 0.7) {
            throw new Exception("Operation failed randomly");
        }
    }
    
    /**
     * Creates a resource for demonstration
     */
    public static AutoCloseable createResource() {
        return new CustomResource("DemoResource");
    }
    
    /**
     * Logs exception details (simplified logging)
     */
    public static void logException(Exception e) {
        System.out.println("=== Exception Log ===");
        System.out.println("Exception Type: " + e.getClass().getSimpleName());
        System.out.println("Message: " + e.getMessage());
        System.out.println("Stack Trace:");
        e.printStackTrace();
        System.out.println("===================");
    }
}

/**
 * Custom resource class implementing AutoCloseable
 * for try-with-resources demonstration
 */
class CustomResource implements AutoCloseable {
    private String name;
    private boolean closed = false;
    
    public CustomResource(String name) {
        this.name = name;
        System.out.println("CustomResource '" + name + "' created");
    }
    
    public void doSomething() {
        if (closed) {
            throw new IllegalStateException("Resource is closed");
        }
        System.out.println("CustomResource '" + name + "' is doing something");
    }
    
    @Override
    public void close() throws Exception {
        if (!closed) {
            closed = true;
            System.out.println("CustomResource '" + name + "' closed");
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Try-catch-finally provides structured exception handling
 * 2. Multiple catch blocks handle different exception types
 * 3. Finally block always executes for cleanup operations
 * 4. Try-with-resources automatically manages resource cleanup
 * 5. Exceptions propagate up the call stack until caught
 * 6. Be specific with exception types and provide meaningful handling
 * 
 * Exception Handling Flow:
 * 1. Code in try block executes
 * 2. If exception occurs, matching catch block executes
 * 3. Finally block always executes (if present)
 * 4. Program continues after try-catch-finally
 * 
 * Best Practices:
 * - Catch specific exceptions before general ones
 * - Use try-with-resources for automatic resource management
 * - Don't ignore exceptions - at least log them
 * - Provide meaningful error messages
 * - Clean up resources in finally blocks
 * - Don't catch exceptions you can't handle meaningfully
 * 
 * Try-with-Resources Benefits:
 * - Automatic resource management
 * - Cleaner code without explicit finally blocks
 * - Handles suppressed exceptions
 * - Works with any AutoCloseable resource
 * - Reduces resource leak risks
 */
