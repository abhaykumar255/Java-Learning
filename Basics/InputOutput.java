/**
 * InputOutput.java - Understanding Input and Output in Java
 * 
 * Learning Objectives:
 * - Learn how to take user input using Scanner class
 * - Understand different input methods for various data types
 * - Practice formatted output using printf and format
 * - Handle input validation and common input errors
 * - Explore file input/output basics
 */

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class InputOutput {
    
    public static void main(String[] args) {
        
        System.out.println("=== Input and Output in Java ===\n");
        
        // ========== BASIC OUTPUT ==========
        
        System.out.println("=== Basic Output Methods ===");
        
        // Different output methods
        System.out.println("println() - prints and moves to next line");
        System.out.print("print() - prints without moving to next line. ");
        System.out.print("This is on the same line.\n");
        
        // printf() for formatted output
        String name = "Alice";
        int age = 25;
        double salary = 75000.50;
        
        System.out.printf("printf() example: %s is %d years old and earns $%.2f%n", name, age, salary);
        
        // format() method (similar to printf)
        String formatted = String.format("Formatted string: %s earns $%,.2f per year", name, salary);
        System.out.println(formatted);
        
        // ========== SCANNER CLASS FOR INPUT ==========
        
        System.out.println("\n=== Scanner Class for Input ===");
        
        // Create Scanner object for reading input
        Scanner scanner = new Scanner(System.in);
        
        // Note: In a real program, you would uncomment these lines for actual user input
        // For demonstration, we'll simulate input
        
        /*
        // Reading different data types
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int userAge = scanner.nextInt();
        
        System.out.print("Enter your height (in meters): ");
        double userHeight = scanner.nextDouble();
        
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        
        System.out.println("\n=== Your Information ===");
        System.out.println("Name: " + userName);
        System.out.println("Age: " + userAge);
        System.out.println("Height: " + userHeight + " meters");
        System.out.println("Student: " + isStudent);
        */
        
        // Simulated input demonstration
        System.out.println("Simulated input demonstration:");
        demonstrateInputMethods();
        
        // ========== INPUT VALIDATION ==========
        
        System.out.println("\n=== Input Validation ===");
        demonstrateInputValidation();
        
        // ========== FORMATTED OUTPUT ==========
        
        System.out.println("\n=== Formatted Output ===");
        demonstrateFormattedOutput();
        
        // ========== FILE INPUT/OUTPUT BASICS ==========
        
        System.out.println("\n=== File Input/Output Basics ===");
        demonstrateFileIO();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        practicalExamples();
        
        // Always close Scanner when done (important for resource management)
        scanner.close();
        
        System.out.println("\n=== Input/Output lesson completed! ===");
    }
    
    /**
     * Demonstrates different Scanner input methods
     */
    public static void demonstrateInputMethods() {
        System.out.println("Scanner Input Methods:");
        
        // Simulating different input scenarios
        String[] simulatedInputs = {"John Doe", "25", "5.9", "true", "A"};
        
        System.out.println("nextLine() - reads entire line: \"" + simulatedInputs[0] + "\"");
        System.out.println("nextInt() - reads integer: " + simulatedInputs[1]);
        System.out.println("nextDouble() - reads decimal: " + simulatedInputs[2]);
        System.out.println("nextBoolean() - reads boolean: " + simulatedInputs[3]);
        System.out.println("next() - reads single word: \"" + simulatedInputs[4] + "\"");
        
        // Important notes about Scanner methods
        System.out.println("\nImportant Scanner Notes:");
        System.out.println("- nextLine() reads the entire line including spaces");
        System.out.println("- next() reads only until whitespace");
        System.out.println("- nextInt(), nextDouble() leave newline in buffer");
        System.out.println("- Use nextLine() after numeric input to consume newline");
    }
    
    /**
     * Demonstrates input validation techniques
     */
    public static void demonstrateInputValidation() {
        Scanner scanner = new Scanner("25\nabc\n30\n"); // Simulated input
        
        System.out.println("Reading integers with validation:");
        
        int validNumber = 0;
        boolean validInput = false;
        
        // Simulate reading multiple inputs
        String[] testInputs = {"25", "abc", "30"};
        
        for (String input : testInputs) {
            try {
                validNumber = Integer.parseInt(input);
                System.out.println("Valid input: " + validNumber);
                validInput = true;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: '" + input + "' - Please enter a valid integer");
            }
        }
        
        if (validInput) {
            System.out.println("Successfully read valid number: " + validNumber);
        }
        
        // Demonstrate hasNext methods
        Scanner testScanner = new Scanner("123 45.67 true hello");
        
        System.out.println("\nUsing hasNext methods for validation:");
        
        if (testScanner.hasNextInt()) {
            System.out.println("Next token is an integer: " + testScanner.nextInt());
        }
        
        if (testScanner.hasNextDouble()) {
            System.out.println("Next token is a double: " + testScanner.nextDouble());
        }
        
        if (testScanner.hasNextBoolean()) {
            System.out.println("Next token is a boolean: " + testScanner.nextBoolean());
        }
        
        if (testScanner.hasNext()) {
            System.out.println("Next token is a string: " + testScanner.next());
        }
        
        testScanner.close();
    }
    
    /**
     * Demonstrates various formatted output techniques
     */
    public static void demonstrateFormattedOutput() {
        String name = "Bob";
        int age = 30;
        double price = 19.99;
        double percentage = 0.856;
        
        System.out.println("Format Specifiers:");
        
        // String formatting
        System.out.printf("%%s (string): %s%n", name);
        System.out.printf("%%10s (right-aligned, width 10): '%10s'%n", name);
        System.out.printf("%%-10s (left-aligned, width 10): '%-10s'%n", name);
        
        // Integer formatting
        System.out.printf("%%d (integer): %d%n", age);
        System.out.printf("%%5d (width 5): '%5d'%n", age);
        System.out.printf("%%05d (zero-padded): '%05d'%n", age);
        
        // Floating-point formatting
        System.out.printf("%%f (float): %f%n", price);
        System.out.printf("%%.2f (2 decimal places): %.2f%n", price);
        System.out.printf("%%8.2f (width 8, 2 decimals): '%8.2f'%n", price);
        
        // Percentage formatting
        System.out.printf("%%% (percentage): %.1f%%%n", percentage * 100);
        
        // Scientific notation
        double largeNumber = 123456789.123;
        System.out.printf("%%e (scientific): %e%n", largeNumber);
        System.out.printf("%%.2e (scientific, 2 decimals): %.2e%n", largeNumber);
        
        // Hexadecimal and octal
        int number = 255;
        System.out.printf("%%x (hexadecimal): %x%n", number);
        System.out.printf("%%X (uppercase hex): %X%n", number);
        System.out.printf("%%o (octal): %o%n", number);
        
        // Date and time formatting (basic example)
        System.out.printf("%%tF (date): %tF%n", new java.util.Date());
        System.out.printf("%%tT (time): %tT%n", new java.util.Date());
    }
    
    /**
     * Demonstrates basic file input/output operations
     */
    public static void demonstrateFileIO() {
        String fileName = "sample_output.txt";
        
        try {
            // Writing to file
            PrintWriter writer = new PrintWriter(fileName);
            writer.println("Hello, File I/O!");
            writer.println("This is line 2");
            writer.printf("Formatted output: %s is %d years old%n", "Alice", 25);
            writer.close();
            
            System.out.println("Successfully wrote to file: " + fileName);
            
            // Reading from file
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            
            System.out.println("Reading from file:");
            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }
            
            fileScanner.close();
            
            // Clean up - delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully");
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
    
    /**
     * Practical examples of input/output operations
     */
    public static void practicalExamples() {
        
        // Example 1: Simple Calculator
        System.out.println("Example 1: Simple Calculator (simulated)");
        
        // Simulated input
        double num1 = 10.5;
        double num2 = 3.2;
        char operator = '+';
        
        System.out.printf("Input: %.1f %c %.1f%n", num1, operator, num2);
        
        double result = 0;
        boolean validOperation = true;
        
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    validOperation = false;
                }
                break;
            default:
                System.out.println("Error: Invalid operator!");
                validOperation = false;
        }
        
        if (validOperation) {
            System.out.printf("Result: %.2f%n", result);
        }
        
        // Example 2: Grade Calculator
        System.out.println("\nExample 2: Grade Calculator (simulated)");
        
        double[] scores = {85.5, 92.0, 78.5, 96.0, 88.5};
        
        System.out.println("Student Scores:");
        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Test %d: %.1f%n", i + 1, scores[i]);
            total += scores[i];
        }
        
        double average = total / scores.length;
        System.out.printf("Average: %.2f%n", average);
        
        char letterGrade;
        if (average >= 90) {
            letterGrade = 'A';
        } else if (average >= 80) {
            letterGrade = 'B';
        } else if (average >= 70) {
            letterGrade = 'C';
        } else if (average >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        
        System.out.printf("Letter Grade: %c%n", letterGrade);
        
        // Example 3: Temperature Converter
        System.out.println("\nExample 3: Temperature Converter (simulated)");
        
        double celsius = 25.0;
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        double kelvin = celsius + 273.15;
        
        System.out.printf("Temperature Conversions:%n");
        System.out.printf("Celsius: %.1f°C%n", celsius);
        System.out.printf("Fahrenheit: %.1f°F%n", fahrenheit);
        System.out.printf("Kelvin: %.2fK%n", kelvin);
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Scanner class is the primary way to read user input in Java
 * 2. Always validate input to prevent crashes and unexpected behavior
 * 3. Use appropriate Scanner methods for different data types
 * 4. printf() and format() provide powerful formatting capabilities
 * 5. Always close Scanner objects to free resources
 * 6. Handle exceptions when dealing with file I/O
 * 
 * Scanner Methods:
 * - nextLine(): reads entire line (including spaces)
 * - next(): reads single word (until whitespace)
 * - nextInt(): reads integer
 * - nextDouble(): reads decimal number
 * - nextBoolean(): reads boolean value
 * - hasNext(): checks if more input is available
 * 
 * Format Specifiers:
 * - %s: string
 * - %d: integer
 * - %f: floating-point
 * - %c: character
 * - %b: boolean
 * - %n: newline (platform independent)
 * 
 * Best Practices:
 * - Always validate user input
 * - Use try-catch for error handling
 * - Close Scanner objects when done
 * - Use meaningful prompts for user input
 * - Handle edge cases (empty input, invalid format)
 * - Use appropriate data types for input
 */
