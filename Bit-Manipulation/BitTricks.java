/**
 * BitTricks.java - Common Bit Manipulation Tricks and Optimizations
 * 
 * Learning Objectives:
 * - Master common bit manipulation tricks used in competitive programming
 * - Learn to solve problems efficiently using bit operations
 * - Understand bit manipulation patterns and when to apply them
 * - Practice optimization techniques using bitwise operations
 * - Build intuition for thinking in binary
 */

public class BitTricks {
    
    public static void main(String[] args) {
        
        System.out.println("=== Bit Manipulation Tricks and Optimizations ===\n");
        
        // ========== BASIC BIT TRICKS ==========
        
        System.out.println("=== Basic Bit Tricks ===");
        demonstrateBasicTricks();
        
        // ========== POWER OF 2 OPERATIONS ==========
        
        System.out.println("\n=== Power of 2 Operations ===");
        demonstratePowerOf2Tricks();
        
        // ========== BIT COUNTING TRICKS ==========
        
        System.out.println("\n=== Bit Counting Tricks ===");
        demonstrateBitCounting();
        
        // ========== PRACTICAL APPLICATIONS ==========
        
        System.out.println("\n=== Practical Applications ===");
        demonstratePracticalApplications();
    }
    
    /**
     * Demonstrate basic bit manipulation tricks
     */
    public static void demonstrateBasicTricks() {
        
        // Trick 1: Check if number is odd or even
        System.out.println("Trick 1: Check Odd/Even using LSB");
        int[] numbers = {5, 8, 13, 20, 7};
        for (int num : numbers) {
            boolean isOdd = (num & 1) == 1;
            System.out.printf("%d is %s\n", num, isOdd ? "odd" : "even");
        }
        System.out.println("Logic: LSB is 1 for odd numbers, 0 for even");
        System.out.println();
        
        // Trick 2: Swap two numbers without temp variable
        System.out.println("Trick 2: Swap without temp variable");
        int a = 15, b = 25;
        System.out.printf("Before: a=%d, b=%d\n", a, b);
        
        a = a ^ b;  // a now contains a XOR b
        b = a ^ b;  // b = (a XOR b) XOR b = a
        a = a ^ b;  // a = (a XOR b) XOR a = b
        
        System.out.printf("After: a=%d, b=%d\n", a, b);
        System.out.println("Logic: XOR property - x ^ y ^ y = x");
        System.out.println();
        
        // Trick 3: Get absolute value
        System.out.println("Trick 3: Get absolute value using bit manipulation");
        int[] testNumbers = {-5, 10, -15, 7, -1};
        for (int num : testNumbers) {
            int abs = getAbsolute(num);
            System.out.printf("abs(%d) = %d\n", num, abs);
        }
        System.out.println();
        
        // Trick 4: Find opposite sign
        System.out.println("Trick 4: Find number with opposite sign");
        for (int num : testNumbers) {
            int opposite = ~num + 1;  // Two's complement
            System.out.printf("opposite(%d) = %d\n", num, opposite);
        }
        System.out.println();
    }
    
    /**
     * Get absolute value using bit manipulation
     */
    public static int getAbsolute(int n) {
        int mask = n >> 31;  // All 1s if negative, all 0s if positive
        return (n + mask) ^ mask;
    }
    
    /**
     * Demonstrate power of 2 related tricks
     */
    public static void demonstratePowerOf2Tricks() {
        
        // Check if number is power of 2
        System.out.println("Check if number is power of 2:");
        int[] testNumbers = {1, 2, 3, 4, 8, 15, 16, 32, 33};
        
        for (int num : testNumbers) {
            boolean isPowerOf2 = (num > 0) && ((num & (num - 1)) == 0);
            System.out.printf("%d is %s power of 2\n", num, isPowerOf2 ? "a" : "not a");
        }
        System.out.println("Logic: Power of 2 has only one bit set, so n & (n-1) == 0");
        System.out.println();
        
        // Find next power of 2
        System.out.println("Find next power of 2:");
        int[] inputs = {5, 8, 15, 17, 31};
        for (int num : inputs) {
            int nextPower = nextPowerOf2(num);
            System.out.printf("Next power of 2 after %d is %d\n", num, nextPower);
        }
        System.out.println();
        
        // Fast multiplication and division by powers of 2
        System.out.println("Fast multiplication/division by powers of 2:");
        int number = 12;
        System.out.printf("Original: %d\n", number);
        System.out.printf("Multiply by 4: %d << 2 = %d\n", number, number << 2);
        System.out.printf("Divide by 2: %d >> 1 = %d\n", number, number >> 1);
        System.out.printf("Modulo 8: %d & 7 = %d\n", number, number & 7);
        System.out.println("Logic: Shifting left multiplies, right divides by 2^n");
        System.out.println();
    }
    
    /**
     * Find next power of 2 greater than or equal to n
     */
    public static int nextPowerOf2(int n) {
        if (n <= 1) return 1;
        
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        
        return n + 1;
    }
    
    /**
     * Demonstrate bit counting tricks
     */
    public static void demonstrateBitCounting() {
        
        // Count set bits (1s) in different ways
        System.out.println("Count set bits (1s) in numbers:");
        int[] numbers = {7, 15, 31, 255, 1023};
        
        for (int num : numbers) {
            int count1 = countSetBitsBasic(num);
            int count2 = countSetBitsBrianKernighan(num);
            int count3 = Integer.bitCount(num);  // Built-in method
            
            System.out.printf("%d (binary: %s) has %d set bits\n", 
                             num, Integer.toBinaryString(num), count1);
        }
        System.out.println();
        
        // Find position of rightmost set bit
        System.out.println("Find position of rightmost set bit:");
        for (int num : numbers) {
            int position = getRightmostSetBitPosition(num);
            System.out.printf("%d: rightmost set bit at position %d\n", num, position);
        }
        System.out.println();
        
        // Isolate rightmost set bit
        System.out.println("Isolate rightmost set bit:");
        for (int num : numbers) {
            int isolated = num & (-num);
            System.out.printf("%d: rightmost set bit value = %d\n", num, isolated);
        }
        System.out.println("Logic: n & (-n) isolates rightmost set bit");
        System.out.println();
    }
    
    /**
     * Count set bits - basic method
     */
    public static int countSetBitsBasic(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
    /**
     * Count set bits - Brian Kernighan's algorithm
     */
    public static int countSetBitsBrianKernighan(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);  // Remove rightmost set bit
            count++;
        }
        return count;
    }
    
    /**
     * Get position of rightmost set bit (1-indexed)
     */
    public static int getRightmostSetBitPosition(int n) {
        if (n == 0) return 0;
        return Integer.numberOfTrailingZeros(n) + 1;
    }
    
    /**
     * Demonstrate practical applications
     */
    public static void demonstratePracticalApplications() {
        
        // Application 1: Set operations using bits
        System.out.println("Application 1: Set operations using bits");
        int setA = 0b1010;  // {1, 3} in binary representation
        int setB = 0b1100;  // {2, 3} in binary representation
        
        System.out.printf("Set A: %s (elements at positions of 1s)\n", Integer.toBinaryString(setA));
        System.out.printf("Set B: %s\n", Integer.toBinaryString(setB));
        System.out.printf("Union (A | B): %s\n", Integer.toBinaryString(setA | setB));
        System.out.printf("Intersection (A & B): %s\n", Integer.toBinaryString(setA & setB));
        System.out.printf("Difference (A & ~B): %s\n", Integer.toBinaryString(setA & ~setB));
        System.out.println();
        
        // Application 2: Generate all subsets
        System.out.println("Application 2: Generate all subsets using bits");
        String[] elements = {"a", "b", "c"};
        generateSubsets(elements);
        System.out.println();
        
        // Application 3: Find single number in array
        System.out.println("Application 3: Find single number (others appear twice)");
        int[] array = {2, 3, 5, 4, 5, 3, 4};
        int single = findSingleNumber(array);
        System.out.printf("Array: %s\n", java.util.Arrays.toString(array));
        System.out.printf("Single number: %d\n", single);
        System.out.println("Logic: XOR of all elements cancels out pairs");
        System.out.println();
        
        // Application 4: Check if two numbers have opposite signs
        System.out.println("Application 4: Check if two numbers have opposite signs");
        int[][] pairs = {{5, -3}, {-7, 2}, {4, 8}, {-1, -5}};
        for (int[] pair : pairs) {
            boolean oppositeSign = (pair[0] ^ pair[1]) < 0;
            System.out.printf("%d and %d have %s signs\n", 
                             pair[0], pair[1], oppositeSign ? "opposite" : "same");
        }
        System.out.println("Logic: XOR of opposite signs gives negative result");
        
        System.out.println("\n=== Bit Tricks completed! ===");
    }
    
    /**
     * Generate all subsets using bit manipulation
     */
    public static void generateSubsets(String[] elements) {
        int n = elements.length;
        int totalSubsets = 1 << n;  // 2^n subsets
        
        System.out.println("All subsets:");
        for (int i = 0; i < totalSubsets; i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(elements[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
    
    /**
     * Find single number in array where others appear twice
     */
    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR cancels out pairs
        }
        return result;
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Essential Bit Tricks:
 *    - n & 1: Check if odd
 *    - n & (n-1): Remove rightmost set bit
 *    - n & (-n): Isolate rightmost set bit
 *    - x ^ y ^ y = x: XOR cancellation property
 * 
 * 2. Power of 2 Operations:
 *    - Check: (n > 0) && ((n & (n-1)) == 0)
 *    - Multiply by 2^k: n << k
 *    - Divide by 2^k: n >> k
 *    - Modulo 2^k: n & ((1 << k) - 1)
 * 
 * 3. Bit Counting:
 *    - Brian Kernighan's algorithm for counting set bits
 *    - Built-in methods: Integer.bitCount(), numberOfTrailingZeros()
 *    - Position finding and bit isolation
 * 
 * 4. Practical Applications:
 *    - Set operations using bit vectors
 *    - Subset generation using binary representation
 *    - Finding unique elements using XOR
 *    - Sign checking and arithmetic optimizations
 * 
 * 5. When to Use Bit Manipulation:
 *    - Performance-critical code
 *    - Memory-constrained environments
 *    - Competitive programming
 *    - Low-level system programming
 */
