/**
 * Operators.java - Understanding Java operators
 * 
 * Learning Objectives:
 * - Master arithmetic operators
 * - Understand comparison and logical operators
 * - Learn assignment and increment/decrement operators
 * - Practice operator precedence
 */

public class Operators {
    
    public static void main(String[] args) {
        
        System.out.println("=== Java Operators Tutorial ===\n");
        
        // ========== ARITHMETIC OPERATORS ==========
        
        System.out.println("1. ARITHMETIC OPERATORS:");
        
        int a = 15;
        int b = 4;
        
        // Basic arithmetic operations
        int addition = a + b;       // Addition
        int subtraction = a - b;    // Subtraction
        int multiplication = a * b; // Multiplication
        int division = a / b;       // Division (integer division)
        int modulus = a % b;        // Modulus (remainder)
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + addition);
        System.out.println("Subtraction (a - b): " + subtraction);
        System.out.println("Multiplication (a * b): " + multiplication);
        System.out.println("Division (a / b): " + division); // Note: 15/4 = 3 (not 3.75)
        System.out.println("Modulus (a % b): " + modulus);   // Remainder: 15 % 4 = 3
        
        // Floating-point division for accurate results
        double preciseDiv = (double) a / b;
        System.out.println("Precise division: " + preciseDiv);
        
        // ========== ASSIGNMENT OPERATORS ==========
        
        System.out.println("\n2. ASSIGNMENT OPERATORS:");
        
        int x = 10;  // Simple assignment
        System.out.println("Initial x: " + x);
        
        x += 5;  // Same as: x = x + 5
        System.out.println("After x += 5: " + x);
        
        x -= 3;  // Same as: x = x - 3
        System.out.println("After x -= 3: " + x);
        
        x *= 2;  // Same as: x = x * 2
        System.out.println("After x *= 2: " + x);
        
        x /= 4;  // Same as: x = x / 4
        System.out.println("After x /= 4: " + x);
        
        x %= 3;  // Same as: x = x % 3
        System.out.println("After x %= 3: " + x);
        
        // ========== INCREMENT/DECREMENT OPERATORS ==========
        
        System.out.println("\n3. INCREMENT/DECREMENT OPERATORS:");
        
        int count = 5;
        System.out.println("Initial count: " + count);
        
        // Pre-increment: increment first, then use value
        System.out.println("Pre-increment (++count): " + (++count)); // count becomes 6, prints 6
        
        // Post-increment: use value first, then increment
        System.out.println("Post-increment (count++): " + (count++)); // prints 6, count becomes 7
        System.out.println("Count after post-increment: " + count);
        
        // Pre-decrement: decrement first, then use value
        System.out.println("Pre-decrement (--count): " + (--count)); // count becomes 6, prints 6
        
        // Post-decrement: use value first, then decrement
        System.out.println("Post-decrement (count--): " + (count--)); // prints 6, count becomes 5
        System.out.println("Final count: " + count);
        
        // ========== COMPARISON OPERATORS ==========
        
        System.out.println("\n4. COMPARISON OPERATORS:");
        
        int num1 = 10;
        int num2 = 20;
        
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("num1 == num2: " + (num1 == num2)); // Equal to
        System.out.println("num1 != num2: " + (num1 != num2)); // Not equal to
        System.out.println("num1 < num2: " + (num1 < num2));   // Less than
        System.out.println("num1 > num2: " + (num1 > num2));   // Greater than
        System.out.println("num1 <= num2: " + (num1 <= num2)); // Less than or equal
        System.out.println("num1 >= num2: " + (num1 >= num2)); // Greater than or equal
        
        // ========== LOGICAL OPERATORS ==========
        
        System.out.println("\n5. LOGICAL OPERATORS:");
        
        boolean isStudent = true;
        boolean hasJob = false;
        int age = 22;
        
        // AND operator (&&) - both conditions must be true
        boolean canGetLoan = isStudent && age >= 18;
        System.out.println("Can get student loan (isStudent && age >= 18): " + canGetLoan);
        
        // OR operator (||) - at least one condition must be true
        boolean isEligible = isStudent || hasJob;
        System.out.println("Is eligible (isStudent || hasJob): " + isEligible);
        
        // NOT operator (!) - reverses the boolean value
        boolean isNotStudent = !isStudent;
        System.out.println("Is not a student (!isStudent): " + isNotStudent);
        
        // Complex logical expressions
        boolean complexCondition = (age >= 18 && isStudent) || (age >= 21 && hasJob);
        System.out.println("Complex condition: " + complexCondition);
        
        // ========== OPERATOR PRECEDENCE ==========
        
        System.out.println("\n6. OPERATOR PRECEDENCE:");
        
        int result1 = 10 + 5 * 2;        // Multiplication first: 10 + 10 = 20
        int result2 = (10 + 5) * 2;      // Parentheses first: 15 * 2 = 30
        
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        
        // Boolean precedence
        boolean boolResult = true || false && false; // && has higher precedence
        System.out.println("true || false && false = " + boolResult); // true
        
        // ========== TERNARY OPERATOR ==========
        
        System.out.println("\n7. TERNARY OPERATOR (? :):");
        
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : "C";
        System.out.println("Score: " + score + ", Grade: " + grade);
        
        // Simple ternary example
        int max = (a > b) ? a : b;
        System.out.println("Maximum of " + a + " and " + b + " is: " + max);
        
        System.out.println("\n=== Operators lesson completed! ===");
    }
}

/*
 * Operator Precedence (High to Low):
 * 1. () [] .
 * 2. ++ -- ! ~ (unary)
 * 3. * / %
 * 4. + -
 * 5. < <= > >=
 * 6. == !=
 * 7. &&
 * 8. ||
 * 9. ? : (ternary)
 * 10. = += -= *= /= %= (assignment)
 * 
 * Remember: When in doubt, use parentheses for clarity!
 */
