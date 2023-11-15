/**
 * NumberTheory.java - Understanding Number Theory Algorithms
 * 
 * Learning Objectives:
 * - Learn fundamental number theory concepts
 * - Implement prime number algorithms efficiently
 * - Master GCD and LCM calculations
 * - Understand modular arithmetic applications
 * - Practice optimization techniques for mathematical operations
 */

import java.util.*;

public class NumberTheory {
    
    public static void main(String[] args) {
        
        System.out.println("=== Number Theory Algorithms ===\n");
        
        // ========== PRIME NUMBERS ==========
        
        System.out.println("=== Prime Number Algorithms ===");
        demonstratePrimeNumbers();
        
        // ========== GCD AND LCM ==========
        
        System.out.println("\n=== GCD and LCM Algorithms ===");
        demonstrateGcdLcm();
        
        // ========== MODULAR ARITHMETIC ==========
        
        System.out.println("\n=== Modular Arithmetic ===");
        demonstrateModularArithmetic();
        
        // ========== SIEVE OF ERATOSTHENES ==========
        
        System.out.println("\n=== Sieve of Eratosthenes ===");
        demonstrateSieve();
        
        // ========== FACTORIZATION ==========
        
        System.out.println("\n=== Prime Factorization ===");
        demonstrateFactorization();
    }
    
    /**
     * Demonstrate prime number algorithms
     */
    public static void demonstratePrimeNumbers() {
        System.out.println("Testing prime numbers:");
        
        int[] testNumbers = {2, 3, 4, 17, 25, 29, 97, 100, 101};
        
        for (int num : testNumbers) {
            boolean isPrimeBasic = isPrimeBasic(num);
            boolean isPrimeOptimized = isPrimeOptimized(num);
            System.out.printf("%3d: Basic=%s, Optimized=%s\n", 
                             num, isPrimeBasic, isPrimeOptimized);
        }
        
        System.out.println("\nFirst 20 prime numbers:");
        List<Integer> primes = generatePrimes(20);
        System.out.println(primes);
    }
    
    /**
     * Basic prime checking algorithm
     * Time Complexity: O(n)
     */
    public static boolean isPrimeBasic(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        // Check all numbers from 5 to n-1
        for (int i = 5; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    /**
     * Optimized prime checking algorithm
     * Time Complexity: O(√n)
     */
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        // Only check up to √n and skip even numbers
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Generate first n prime numbers
     */
    public static List<Integer> generatePrimes(int count) {
        List<Integer> primes = new ArrayList<>();
        int num = 2;
        
        while (primes.size() < count) {
            if (isPrimeOptimized(num)) {
                primes.add(num);
            }
            num++;
        }
        
        return primes;
    }
    
    /**
     * Demonstrate GCD and LCM algorithms
     */
    public static void demonstrateGcdLcm() {
        int[][] testPairs = {{48, 18}, {100, 25}, {17, 13}, {56, 42}};
        
        System.out.println("GCD and LCM calculations:");
        for (int[] pair : testPairs) {
            int a = pair[0], b = pair[1];
            int gcdResult = gcd(a, b);
            int lcmResult = lcm(a, b);
            
            System.out.printf("GCD(%d, %d) = %d, LCM(%d, %d) = %d\n", 
                             a, b, gcdResult, a, b, lcmResult);
        }
        
        // Demonstrate extended Euclidean algorithm
        System.out.println("\nExtended Euclidean Algorithm:");
        int a = 30, b = 18;
        int[] result = extendedGcd(a, b);
        System.out.printf("For %d and %d: GCD = %d, x = %d, y = %d\n", 
                         a, b, result[0], result[1], result[2]);
        System.out.printf("Verification: %d*%d + %d*%d = %d\n", 
                         a, result[1], b, result[2], a*result[1] + b*result[2]);
    }
    
    /**
     * Greatest Common Divisor using Euclidean algorithm
     * Time Complexity: O(log(min(a,b)))
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    /**
     * Least Common Multiple
     * LCM(a,b) = (a * b) / GCD(a,b)
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    /**
     * Extended Euclidean Algorithm
     * Returns [gcd, x, y] where ax + by = gcd(a,b)
     */
    public static int[] extendedGcd(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }
        
        int[] result = extendedGcd(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];
        
        int x = y1;
        int y = x1 - (a / b) * y1;
        
        return new int[]{gcd, x, y};
    }
    
    /**
     * Demonstrate modular arithmetic
     */
    public static void demonstrateModularArithmetic() {
        System.out.println("Modular arithmetic operations:");
        
        int a = 23, b = 7, mod = 13;
        
        System.out.printf("a = %d, b = %d, mod = %d\n", a, b, mod);
        System.out.printf("(a + b) mod %d = %d\n", mod, (a + b) % mod);
        System.out.printf("(a - b) mod %d = %d\n", mod, (a - b + mod) % mod);
        System.out.printf("(a * b) mod %d = %d\n", mod, (a * b) % mod);
        
        // Modular exponentiation
        int base = 3, exp = 10;
        long modExpResult = modularExponentiation(base, exp, mod);
        System.out.printf("%d^%d mod %d = %d\n", base, exp, mod, modExpResult);
        
        // Modular inverse
        int inverse = modularInverse(a, mod);
        if (inverse != -1) {
            System.out.printf("Modular inverse of %d mod %d = %d\n", a, mod, inverse);
            System.out.printf("Verification: (%d * %d) mod %d = %d\n", 
                             a, inverse, mod, (a * inverse) % mod);
        }
    }
    
    /**
     * Fast modular exponentiation
     * Calculates (base^exp) % mod efficiently
     * Time Complexity: O(log exp)
     */
    public static long modularExponentiation(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        
        while (exp > 0) {
            // If exp is odd, multiply base with result
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            
            // exp must be even now
            exp = exp >> 1; // exp = exp / 2
            base = (base * base) % mod;
        }
        
        return result;
    }
    
    /**
     * Find modular inverse using extended Euclidean algorithm
     * Returns x such that (a * x) % mod = 1
     */
    public static int modularInverse(int a, int mod) {
        int[] result = extendedGcd(a, mod);
        int gcd = result[0];
        int x = result[1];
        
        if (gcd != 1) {
            return -1; // Modular inverse doesn't exist
        }
        
        return (x % mod + mod) % mod;
    }
    
    /**
     * Demonstrate Sieve of Eratosthenes
     */
    public static void demonstrateSieve() {
        int limit = 50;
        boolean[] primes = sieveOfEratosthenes(limit);
        
        System.out.printf("Prime numbers up to %d using Sieve of Eratosthenes:\n", limit);
        for (int i = 2; i <= limit; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Count primes
        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (primes[i]) count++;
        }
        System.out.printf("Total primes up to %d: %d\n", limit, count);
    }
    
    /**
     * Sieve of Eratosthenes algorithm
     * Time Complexity: O(n log log n)
     * Space Complexity: O(n)
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return isPrime;
    }
    
    /**
     * Demonstrate prime factorization
     */
    public static void demonstrateFactorization() {
        int[] testNumbers = {12, 28, 60, 97, 100, 315};
        
        System.out.println("Prime factorization:");
        for (int num : testNumbers) {
            List<Integer> factors = primeFactorization(num);
            System.out.printf("%d = %s\n", num, formatFactors(factors));
        }
    }
    
    /**
     * Find prime factorization of a number
     * Time Complexity: O(√n)
     */
    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();
        
        // Handle factor 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        // Handle odd factors from 3 onwards
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        // If n is still greater than 1, it's a prime factor
        if (n > 1) {
            factors.add(n);
        }
        
        return factors;
    }
    
    /**
     * Format factors for display
     */
    public static String formatFactors(List<Integer> factors) {
        if (factors.isEmpty()) return "1";
        
        Map<Integer, Integer> factorCount = new HashMap<>();
        for (int factor : factors) {
            factorCount.put(factor, factorCount.getOrDefault(factor, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<Integer, Integer> entry : factorCount.entrySet()) {
            if (!first) sb.append(" × ");
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append("^").append(entry.getValue());
            }
            first = false;
        }
        
        return sb.toString();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Prime Number Algorithms:
 *    - Basic: O(n) - check all numbers
 *    - Optimized: O(√n) - check only up to square root
 *    - Sieve: O(n log log n) - find all primes up to n
 * 
 * 2. GCD and LCM:
 *    - Euclidean algorithm: O(log(min(a,b)))
 *    - LCM(a,b) = (a × b) / GCD(a,b)
 *    - Extended Euclidean: finds coefficients for Bézout's identity
 * 
 * 3. Modular Arithmetic:
 *    - Fast exponentiation: O(log exp)
 *    - Modular inverse: using extended Euclidean algorithm
 *    - Applications in cryptography and number theory
 * 
 * 4. Optimization Techniques:
 *    - Skip even numbers (except 2) for prime checking
 *    - Use bit operations for fast division/multiplication by 2
 *    - Precompute results using sieve for multiple queries
 * 
 * 5. Applications:
 *    - Cryptography (RSA, Diffie-Hellman)
 *    - Hash functions
 *    - Random number generation
 *    - Competitive programming
 */
