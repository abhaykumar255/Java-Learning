/**
 * ControlFlow.java - Understanding Control Flow Statements in Java
 * 
 * Learning Objectives:
 * - Master if-else conditional statements
 * - Understand switch-case statements
 * - Learn different types of loops (for, while, do-while)
 * - Practice nested control structures
 * - Understand break and continue statements
 */

public class ControlFlow {
    
    public static void main(String[] args) {
        
        System.out.println("=== Control Flow Statements in Java ===\n");
        
        // ========== IF-ELSE STATEMENTS ==========
        
        System.out.println("=== If-Else Statements ===");
        
        int age = 20;
        double gpa = 3.7;
        boolean hasJob = false;
        
        // Simple if statement
        if (age >= 18) {
            System.out.println("You are eligible to vote!");
        }
        
        // if-else statement
        if (age >= 21) {
            System.out.println("You can drink alcohol legally.");
        } else {
            System.out.println("You cannot drink alcohol yet.");
        }
        
        // if-else-if ladder
        if (gpa >= 3.8) {
            System.out.println("Excellent academic performance!");
        } else if (gpa >= 3.5) {
            System.out.println("Very good academic performance!");
        } else if (gpa >= 3.0) {
            System.out.println("Good academic performance!");
        } else if (gpa >= 2.0) {
            System.out.println("Satisfactory academic performance.");
        } else {
            System.out.println("Need to improve academic performance.");
        }
        
        // Nested if statements
        if (age >= 18) {
            if (gpa >= 3.0) {
                if (hasJob) {
                    System.out.println("Eligible for premium student loan.");
                } else {
                    System.out.println("Eligible for standard student loan.");
                }
            } else {
                System.out.println("GPA too low for student loan.");
            }
        } else {
            System.out.println("Too young for student loan.");
        }
        
        // ========== SWITCH-CASE STATEMENTS ==========
        
        System.out.println("\n=== Switch-Case Statements ===");
        
        int dayOfWeek = 3;
        String dayName;
        
        // Traditional switch statement
        switch (dayOfWeek) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        
        System.out.println("Day " + dayOfWeek + " is: " + dayName);
        
        // Switch with multiple cases
        char grade = 'B';
        switch (grade) {
            case 'A':
            case 'a':
                System.out.println("Excellent! Grade: " + grade);
                break;
            case 'B':
            case 'b':
                System.out.println("Good! Grade: " + grade);
                break;
            case 'C':
            case 'c':
                System.out.println("Average! Grade: " + grade);
                break;
            case 'D':
            case 'd':
                System.out.println("Below Average! Grade: " + grade);
                break;
            case 'F':
            case 'f':
                System.out.println("Failed! Grade: " + grade);
                break;
            default:
                System.out.println("Invalid grade: " + grade);
                break;
        }
        
        // ========== FOR LOOPS ==========
        
        System.out.println("\n=== For Loops ===");
        
        // Basic for loop
        System.out.println("Counting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // For loop with different increments
        System.out.println("\nEven numbers from 2 to 10:");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even: " + i);
        }
        
        // Reverse for loop
        System.out.println("\nCountdown from 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            System.out.println("Countdown: " + i);
        }
        
        // Enhanced for loop (for-each) with arrays
        int[] numbers = {10, 20, 30, 40, 50};
        System.out.println("\nArray elements using enhanced for loop:");
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
        
        // Nested for loops - multiplication table
        System.out.println("\nMultiplication table (3x3):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println(); // New line after each row
        }
        
        // ========== WHILE LOOPS ==========
        
        System.out.println("\n=== While Loops ===");
        
        // Basic while loop
        int count = 1;
        System.out.println("While loop counting to 5:");
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++; // Important: increment to avoid infinite loop
        }
        
        // While loop for input validation simulation
        int userInput = 15; // Simulated user input
        System.out.println("\nValidating input (must be between 1 and 10):");
        while (userInput < 1 || userInput > 10) {
            System.out.println("Invalid input: " + userInput + ". Please enter a number between 1 and 10.");
            userInput = 7; // Simulated corrected input
        }
        System.out.println("Valid input received: " + userInput);
        
        // ========== DO-WHILE LOOPS ==========
        
        System.out.println("\n=== Do-While Loops ===");
        
        // Basic do-while loop
        int num = 1;
        System.out.println("Do-while loop (executes at least once):");
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num <= 3);
        
        // Do-while vs while difference
        int x = 10;
        System.out.println("\nDo-while with false condition (still executes once):");
        do {
            System.out.println("This executes once even though condition is false: " + x);
            x++;
        } while (x < 10); // Condition is false from start
        
        System.out.println("\nWhile with false condition (doesn't execute):");
        int y = 10;
        while (y < 10) { // Condition is false from start
            System.out.println("This will never execute: " + y);
            y++;
        }
        
        // ========== BREAK AND CONTINUE ==========
        
        System.out.println("\n=== Break and Continue Statements ===");
        
        // Break statement - exits the loop
        System.out.println("Break statement example:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Breaking at i = " + i);
                break; // Exit the loop when i equals 6
            }
            System.out.println("i = " + i);
        }
        
        // Continue statement - skips current iteration
        System.out.println("\nContinue statement example (skip even numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.println("Odd number: " + i);
        }
        
        // Break in nested loops
        System.out.println("\nBreak in nested loops:");
        outerLoop: // Label for outer loop
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking outer loop at i=" + i + ", j=" + j);
                    break outerLoop; // Break outer loop
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        
        // Find factorial using for loop
        int factorial = 1;
        int n = 5;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + n + " is: " + factorial);
        
        // Find sum of digits
        int number = 12345;
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            sum += temp % 10; // Add last digit
            temp /= 10;       // Remove last digit
        }
        System.out.println("Sum of digits in " + number + " is: " + sum);
        
        // Check if number is prime
        int primeCandidate = 17;
        boolean isPrime = true;
        
        if (primeCandidate <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(primeCandidate); i++) {
                if (primeCandidate % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        
        System.out.println(primeCandidate + " is " + (isPrime ? "prime" : "not prime"));
        
        System.out.println("\n=== Control Flow lesson completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. if-else: Use for conditional execution based on boolean expressions
 * 2. switch-case: Use for multiple discrete value comparisons
 * 3. for loop: Use when you know the number of iterations
 * 4. while loop: Use when condition is checked before execution
 * 5. do-while loop: Use when you need at least one execution
 * 6. break: Exits the current loop completely
 * 7. continue: Skips current iteration and moves to next
 * 
 * Best Practices:
 * - Always include break in switch cases (unless fall-through is intended)
 * - Be careful with loop conditions to avoid infinite loops
 * - Use enhanced for loop when you don't need indices
 * - Use meaningful variable names in loop conditions
 * - Consider using labels for breaking out of nested loops
 * 
 * Common Mistakes:
 * - Forgetting to increment counter in while loops
 * - Missing break statements in switch cases
 * - Using = instead of == in conditions
 * - Creating infinite loops by mistake
 */
