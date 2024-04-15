/**
 * MathBasics.java - Basic Mathematical Operations and Algorithms
 * 
 * Learning Objectives:
 * - Master fundamental mathematical operations in programming
 * - Learn efficient algorithms for common mathematical problems
 * - Understand precision and overflow considerations
 * - Practice optimization techniques for mathematical computations
 * - Apply mathematical concepts in algorithmic problem solving
 */

import java.math.BigInteger;
import java.util.*;

public class MathBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Mathematical Algorithms and Operations ===\n");
        
        // ========== BASIC ARITHMETIC OPERATIONS ==========
        
        System.out.println("=== Basic Arithmetic Operations ===");
        demonstrateBasicOperations();
        
        // ========== EXPONENTIATION ==========
        
        System.out.println("\n=== Exponentiation Algorithms ===");
        demonstrateExponentiation();
        
        // ========== SQUARE ROOT ALGORITHMS ==========
        
        System.out.println("\n=== Square Root Algorithms ===");
        demonstrateSquareRoot();
        
        // ========== FACTORIAL AND COMBINATIONS ==========
        
        System.out.println("\n=== Factorial and Combinations ===");
        demonstrateFactorialAndCombinations();
        
        // ========== MATHEMATICAL SERIES ==========
        
        System.out.println("\n=== Mathematical Series ===");
        demonstrateMathematicalSeries();
    }
    
    /**
     * Demonstrate basic arithmetic operations with edge cases
     */
    public static void demonstrateBasicOperations() {
        System.out.println("Basic operations with overflow and precision considerations:");
        System.out.println();
        
        // Integer overflow demonstration
        System.out.println("=== Integer Overflow ===");
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE: " + maxInt);
        System.out.println("MAX_VALUE + 1: " + (maxInt + 1)); // Overflow!
        System.out.println("Safe addition using Math.addExact:");
        
        try {
            int safeResult = Math.addExact(maxInt, 1);
            System.out.println("Safe result: " + safeResult);
        } catch (ArithmeticException e) {
            System.out.println("Overflow detected: " + e.getMessage());
        }
        System.out.println();
        
        // Division operations
        System.out.println("=== Division Operations ===");
        System.out.println("Integer division: 7 / 3 = " + (7 / 3));
        System.out.println("Float division: 7.0 / 3.0 = " + (7.0 / 3.0));
        System.out.println("Modulo operation: 7 % 3 = " + (7 % 3));
        
        // Handle division by zero
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero: " + e.getMessage());
        }
        
        System.out.println("Float division by zero: " + (10.0 / 0.0)); // Infinity
        System.out.println("NaN example: " + (0.0 / 0.0));
        System.out.println();
        
        // Absolute value and sign operations
        System.out.println("=== Absolute Value and Sign ===");
        int[] testNumbers = {-5, 0, 5, Integer.MIN_VALUE};
        for (int num : testNumbers) {
            System.out.printf("abs(%d) = %d, signum(%d) = %d\n", 
                             num, Math.abs(num), num, (int)Math.signum(num));
        }
        
        // Special case: Math.abs(Integer.MIN_VALUE) overflows
        System.out.println("Special case - Integer.MIN_VALUE abs: " + Math.abs(Integer.MIN_VALUE));
    }
    
    /**
     * Demonstrate exponentiation algorithms
     */
    public static void demonstrateExponentiation() {
        System.out.println("Different approaches to calculate powers:");
        System.out.println();
        
        int base = 2;
        int[] exponents = {0, 1, 5, 10, 20};
        
        System.out.println("=== Power Calculation Methods ===");
        for (int exp : exponents) {
            long naive = powerNaive(base, exp);
            long fast = powerFast(base, exp);
            double mathPow = Math.pow(base, exp);
            
            System.out.printf("%d^%d: Naive=%d, Fast=%d, Math.pow=%.0f\n", 
                             base, exp, naive, fast, mathPow);
        }
        System.out.println();
        
        // Large number exponentiation
        System.out.println("=== Large Number Exponentiation ===");
        BigInteger bigBase = BigInteger.valueOf(2);
        int largeExp = 100;
        BigInteger bigResult = bigBase.pow(largeExp);
        System.out.println("2^100 = " + bigResult);
        System.out.println("Number of digits: " + bigResult.toString().length());
        System.out.println();
        
        // Modular exponentiation
        System.out.println("=== Modular Exponentiation ===");
        long modBase = 3, modExp = 10, mod = 13;
        long modResult = modularPower(modBase, modExp, mod);
        System.out.printf("%d^%d mod %d = %d\n", modBase, modExp, mod, modResult);
        
        // Verify with BigInteger
        BigInteger bigModResult = BigInteger.valueOf(modBase).modPow(
            BigInteger.valueOf(modExp), BigInteger.valueOf(mod));
        System.out.println("BigInteger verification: " + bigModResult);
    }
    
    /**
     * Naive power calculation - O(n) time
     */
    public static long powerNaive(long base, int exp) {
        if (exp == 0) return 1;
        
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
    
    /**
     * Fast exponentiation using binary method - O(log n) time
     */
    public static long powerFast(long base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        
        if (exp % 2 == 0) {
            long half = powerFast(base, exp / 2);
            return half * half;
        } else {
            return base * powerFast(base, exp - 1);
        }
    }
    
    /**
     * Modular exponentiation - (base^exp) % mod
     */
    public static long modularPower(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            exp = exp >> 1;
            base = (base * base) % mod;
        }
        
        return result;
    }
    
    /**
     * Demonstrate square root algorithms
     */
    public static void demonstrateSquareRoot() {
        System.out.println("Different methods to calculate square roots:");
        System.out.println();
        
        double[] testNumbers = {4, 9, 16, 25, 2, 10, 100};
        
        System.out.println("=== Square Root Methods ===");
        System.out.printf("%-8s %-12s %-12s %-12s\n", "Number", "Math.sqrt", "Newton", "Binary");
        System.out.println("------------------------------------------------");
        
        for (double num : testNumbers) {
            double mathSqrt = Math.sqrt(num);
            double newtonSqrt = sqrtNewton(num);
            double binarySqrt = sqrtBinarySearch(num);
            
            System.out.printf("%-8.0f %-12.6f %-12.6f %-12.6f\n", 
                             num, mathSqrt, newtonSqrt, binarySqrt);
        }
        System.out.println();
        
        // Integer square root
        System.out.println("=== Integer Square Root ===");
        int[] intNumbers = {1, 4, 8, 9, 15, 16, 24, 25};
        for (int num : intNumbers) {
            int intSqrt = integerSquareRoot(num);
            System.out.printf("floor(sqrt(%d)) = %d\n", num, intSqrt);
        }
    }
    
    /**
     * Newton's method for square root
     */
    public static double sqrtNewton(double n) {
        if (n == 0) return 0;
        
        double x = n;
        double epsilon = 1e-10;
        
        while (true) {
            double newX = 0.5 * (x + n / x);
            if (Math.abs(newX - x) < epsilon) {
                return newX;
            }
            x = newX;
        }
    }
    
    /**
     * Binary search method for square root
     */
    public static double sqrtBinarySearch(double n) {
        if (n == 0) return 0;
        
        double left = 0, right = Math.max(1, n);
        double epsilon = 1e-10;
        
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            double square = mid * mid;
            
            if (square < n) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return (left + right) / 2;
    }
    
    /**
     * Integer square root using binary search
     */
    public static int integerSquareRoot(int n) {
        if (n == 0) return 0;
        
        int left = 1, right = n;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (mid <= n / mid) { // Avoid overflow
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Demonstrate factorial and combinations
     */
    public static void demonstrateFactorialAndCombinations() {
        System.out.println("Factorial and combinatorial calculations:");
        System.out.println();
        
        // Factorial calculations
        System.out.println("=== Factorial Calculations ===");
        for (int i = 0; i <= 10; i++) {
            long fact = factorial(i);
            BigInteger bigFact = factorialBig(i);
            System.out.printf("%d! = %d (BigInteger: %s)\n", i, fact, bigFact);
        }
        
        // Large factorial
        int largeN = 50;
        BigInteger largeFact = factorialBig(largeN);
        System.out.printf("\n%d! = %s\n", largeN, largeFact);
        System.out.println("Number of digits: " + largeFact.toString().length());
        System.out.println();
        
        // Combinations and permutations
        System.out.println("=== Combinations and Permutations ===");
        int n = 10;
        for (int r = 0; r <= 5; r++) {
            long comb = combination(n, r);
            long perm = permutation(n, r);
            System.out.printf("C(%d,%d) = %d, P(%d,%d) = %d\n", n, r, comb, n, r, perm);
        }
        System.out.println();
        
        // Pascal's triangle
        System.out.println("=== Pascal's Triangle (first 6 rows) ===");
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(combination(row, col) + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Factorial calculation
     */
    public static long factorial(int n) {
        if (n <= 1) return 1;
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    /**
     * Factorial using BigInteger for large numbers
     */
    public static BigInteger factorialBig(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    /**
     * Combination C(n,r) = n! / (r! * (n-r)!)
     */
    public static long combination(int n, int r) {
        if (r > n || r < 0) return 0;
        if (r == 0 || r == n) return 1;
        
        // Optimize: C(n,r) = C(n,n-r)
        r = Math.min(r, n - r);
        
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
    
    /**
     * Permutation P(n,r) = n! / (n-r)!
     */
    public static long permutation(int n, int r) {
        if (r > n || r < 0) return 0;
        
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
        }
        return result;
    }
    
    /**
     * Demonstrate mathematical series
     */
    public static void demonstrateMathematicalSeries() {
        System.out.println("Common mathematical series calculations:");
        System.out.println();
        
        // Arithmetic series
        System.out.println("=== Arithmetic Series ===");
        int firstTerm = 2, commonDiff = 3, numTerms = 10;
        long arithSum = arithmeticSeriesSum(firstTerm, commonDiff, numTerms);
        System.out.printf("Sum of arithmetic series (a=%d, d=%d, n=%d): %d\n", 
                         firstTerm, commonDiff, numTerms, arithSum);
        
        // Geometric series
        System.out.println("\n=== Geometric Series ===");
        double firstTermGeo = 1, commonRatio = 2;
        int numTermsGeo = 10;
        double geoSum = geometricSeriesSum(firstTermGeo, commonRatio, numTermsGeo);
        System.out.printf("Sum of geometric series (a=%.0f, r=%.0f, n=%d): %.0f\n", 
                         firstTermGeo, commonRatio, numTermsGeo, geoSum);
        
        // Harmonic series (partial sum)
        System.out.println("\n=== Harmonic Series ===");
        for (int n : new int[]{10, 100, 1000}) {
            double harmonicSum = harmonicSeriesSum(n);
            System.out.printf("H_%d = %.6f\n", n, harmonicSum);
        }
        
        // Fibonacci series
        System.out.println("\n=== Fibonacci Series ===");
        System.out.print("First 15 Fibonacci numbers: ");
        for (int i = 0; i < 15; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        // Pi approximation using series
        System.out.println("\n=== Pi Approximation ===");
        for (int terms : new int[]{100, 1000, 10000}) {
            double piApprox = piLeibnizSeries(terms);
            double error = Math.abs(Math.PI - piApprox);
            System.out.printf("Pi approximation (%d terms): %.6f, Error: %.6f\n", 
                             terms, piApprox, error);
        }
        
        System.out.println("\n=== Mathematical Basics completed! ===");
    }
    
    /**
     * Sum of arithmetic series: S = n/2 * (2a + (n-1)d)
     */
    public static long arithmeticSeriesSum(int firstTerm, int commonDiff, int numTerms) {
        return (long) numTerms * (2 * firstTerm + (numTerms - 1) * commonDiff) / 2;
    }
    
    /**
     * Sum of geometric series: S = a * (r^n - 1) / (r - 1)
     */
    public static double geometricSeriesSum(double firstTerm, double commonRatio, int numTerms) {
        if (commonRatio == 1) {
            return firstTerm * numTerms;
        }
        return firstTerm * (Math.pow(commonRatio, numTerms) - 1) / (commonRatio - 1);
    }
    
    /**
     * Harmonic series sum: H_n = 1 + 1/2 + 1/3 + ... + 1/n
     */
    public static double harmonicSeriesSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
    
    /**
     * Fibonacci number calculation
     */
    public static long fibonacci(int n) {
        if (n <= 1) return n;
        
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
    
    /**
     * Pi approximation using Leibniz series: π/4 = 1 - 1/3 + 1/5 - 1/7 + ...
     */
    public static double piLeibnizSeries(int terms) {
        double sum = 0.0;
        for (int i = 0; i < terms; i++) {
            sum += Math.pow(-1, i) / (2 * i + 1);
        }
        return 4 * sum;
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Arithmetic Operations:
 *    - Be aware of integer overflow (use Math.addExact, etc.)
 *    - Handle division by zero appropriately
 *    - Understand floating-point precision limitations
 * 
 * 2. Exponentiation:
 *    - Naive: O(n) time complexity
 *    - Fast (binary): O(log n) time complexity
 *    - Modular exponentiation for large numbers
 * 
 * 3. Square Root:
 *    - Newton's method: fast convergence
 *    - Binary search: guaranteed convergence
 *    - Integer square root: avoid floating-point errors
 * 
 * 4. Combinatorics:
 *    - Use BigInteger for large factorials
 *    - Optimize combinations using symmetry
 *    - Calculate incrementally to avoid overflow
 * 
 * 5. Mathematical Series:
 *    - Arithmetic: linear progression
 *    - Geometric: exponential progression
 *    - Harmonic: logarithmic growth
 *    - Series approximations for constants (π, e)
 */
