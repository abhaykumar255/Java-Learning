/**
 * RecursionBasics.java - Understanding Recursion Fundamentals
 * 
 * Learning Objectives:
 * - Understand what recursion is and how it works
 * - Learn the anatomy of a recursive function (base case + recursive case)
 * - Visualize the call stack during recursive execution
 * - Practice simple recursive problems to build intuition
 * - Compare recursive vs iterative approaches
 */

public class RecursionBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Recursion Basics - Understanding the Fundamentals ===\n");
        
        // ========== WHAT IS RECURSION? ==========
        
        System.out.println("=== What is Recursion? ===");
        System.out.println("Recursion is when a function calls itself to solve a problem");
        System.out.println("by breaking it down into smaller, similar subproblems.\n");
        
        // ========== SIMPLE COUNTDOWN EXAMPLE ==========
        
        System.out.println("=== Example 1: Simple Countdown ===");
        System.out.println("Let's see recursion in action with a countdown:");
        countdown(5);
        System.out.println("Countdown completed!\n");
        
        // ========== FACTORIAL CALCULATION ==========
        
        System.out.println("=== Example 2: Factorial Calculation ===");
        int n = 5;
        long factorialResult = factorial(n);
        System.out.println(n + "! = " + factorialResult);
        
        // Compare with iterative approach
        long iterativeResult = factorialIterative(n);
        System.out.println(n + "! (iterative) = " + iterativeResult);
        System.out.println();
        
        // ========== SUM OF NUMBERS ==========
        
        System.out.println("=== Example 3: Sum of Numbers 1 to N ===");
        int num = 10;
        int sumResult = sumOfNumbers(num);
        System.out.println("Sum of 1 to " + num + " = " + sumResult);
        
        // Show the mathematical formula
        int formulaResult = num * (num + 1) / 2;
        System.out.println("Using formula n*(n+1)/2 = " + formulaResult);
        System.out.println();
        
        // ========== POWER CALCULATION ==========
        
        System.out.println("=== Example 4: Power Calculation ===");
        int base = 2, exponent = 8;
        long powerResult = power(base, exponent);
        System.out.println(base + "^" + exponent + " = " + powerResult);
        System.out.println();
        
        // ========== FIBONACCI SEQUENCE ==========
        
        System.out.println("=== Example 5: Fibonacci Sequence ===");
        System.out.println("First 10 Fibonacci numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println("\n");
        
        // ========== UNDERSTANDING CALL STACK ==========
        
        System.out.println("=== Understanding Call Stack ===");
        System.out.println("Let's trace through factorial(4) to see the call stack:");
        factorialWithTrace(4);
        System.out.println();
        
        // ========== RECURSION BEST PRACTICES ==========
        
        System.out.println("=== Recursion Best Practices ===");
        demonstrateBestPractices();
    }
    
    /**
     * Example 1: Simple Countdown
     * This demonstrates the basic structure of recursion
     */
    public static void countdown(int n) {
        // BASE CASE: When to stop the recursion
        if (n <= 0) {
            System.out.println("Blast off! 🚀");
            return;
        }
        
        // RECURSIVE CASE: Do some work and call yourself with smaller input
        System.out.println("Countdown: " + n);
        countdown(n - 1); // Recursive call with smaller problem
    }
    
    /**
     * Example 2: Factorial Calculation (Recursive)
     * n! = n * (n-1) * (n-2) * ... * 1
     * Base case: 0! = 1, 1! = 1
     */
    public static long factorial(int n) {
        // BASE CASE: factorial of 0 or 1 is 1
        if (n <= 1) {
            return 1;
        }
        
        // RECURSIVE CASE: n! = n * (n-1)!
        return n * factorial(n - 1);
    }
    
    /**
     * Factorial Calculation (Iterative) - for comparison
     */
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Example 3: Sum of Numbers from 1 to N
     * sum(n) = n + sum(n-1)
     */
    public static int sumOfNumbers(int n) {
        // BASE CASE: sum of 1 is 1, sum of 0 is 0
        if (n <= 1) {
            return n;
        }
        
        // RECURSIVE CASE: n + sum(n-1)
        return n + sumOfNumbers(n - 1);
    }
    
    /**
     * Example 4: Power Calculation
     * base^exponent = base * base^(exponent-1)
     */
    public static long power(int base, int exponent) {
        // BASE CASE: any number to power 0 is 1
        if (exponent == 0) {
            return 1;
        }
        
        // BASE CASE: any number to power 1 is itself
        if (exponent == 1) {
            return base;
        }
        
        // RECURSIVE CASE: base * base^(exponent-1)
        return base * power(base, exponent - 1);
    }
    
    /**
     * Example 5: Fibonacci Sequence
     * fib(n) = fib(n-1) + fib(n-2)
     * Note: This is inefficient due to repeated calculations
     */
    public static int fibonacci(int n) {
        // BASE CASES: fib(0) = 0, fib(1) = 1
        if (n <= 1) {
            return n;
        }
        
        // RECURSIVE CASE: fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    /**
     * Factorial with Call Stack Trace
     * This helps visualize how recursion works
     */
    public static long factorialWithTrace(int n) {
        System.out.println("→ Entering factorial(" + n + ")");
        
        if (n <= 1) {
            System.out.println("← Base case reached! factorial(" + n + ") = 1");
            return 1;
        }
        
        System.out.println("  Computing " + n + " * factorial(" + (n-1) + ")");
        long result = n * factorialWithTrace(n - 1);
        System.out.println("← Returning factorial(" + n + ") = " + result);
        
        return result;
    }
    
    /**
     * Demonstrate Recursion Best Practices
     */
    public static void demonstrateBestPractices() {
        System.out.println("1. Always have a base case to prevent infinite recursion");
        System.out.println("2. Make sure recursive calls progress toward the base case");
        System.out.println("3. Consider space complexity (each call uses stack space)");
        System.out.println("4. For some problems, iterative solutions may be more efficient");
        System.out.println("5. Use memoization for problems with overlapping subproblems");
        
        System.out.println("\n=== Recursion Basics completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Recursion has two essential parts:
 *    - Base case: When to stop
 *    - Recursive case: How to break down the problem
 * 
 * 2. Each recursive call creates a new frame on the call stack
 * 
 * 3. Recursion is powerful for problems that have:
 *    - Self-similar subproblems
 *    - Natural recursive structure (trees, fractals)
 *    - Divide and conquer approach
 * 
 * 4. Common pitfalls:
 *    - Missing base case (infinite recursion)
 *    - Not progressing toward base case
 *    - Stack overflow for large inputs
 * 
 * 5. When to choose recursion vs iteration:
 *    - Recursion: More intuitive for certain problems
 *    - Iteration: Generally more space-efficient
 */
