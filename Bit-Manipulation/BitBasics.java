/**
 * BitBasics.java - Understanding Bit Manipulation Fundamentals
 * 
 * Learning Objectives:
 * - Understand binary representation of numbers
 * - Learn all bitwise operators and their applications
 * - Practice converting between decimal and binary
 * - Master basic bit manipulation techniques
 * - Understand signed vs unsigned integers in Java
 */

public class BitBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Bit Manipulation Basics ===\n");
        
        // ========== BINARY REPRESENTATION ==========
        
        System.out.println("=== Binary Representation ===");
        demonstrateBinaryRepresentation();
        
        // ========== BITWISE OPERATORS ==========
        
        System.out.println("\n=== Bitwise Operators ===");
        demonstrateBitwiseOperators();
        
        // ========== BIT SHIFTING ==========
        
        System.out.println("\n=== Bit Shifting Operations ===");
        demonstrateBitShifting();
        
        // ========== PRACTICAL APPLICATIONS ==========
        
        System.out.println("\n=== Practical Applications ===");
        demonstratePracticalApplications();
        
        // ========== COMMON BIT TRICKS ==========
        
        System.out.println("\n=== Common Bit Tricks ===");
        demonstrateCommonTricks();
    }
    
    /**
     * Demonstrate binary representation of numbers
     */
    public static void demonstrateBinaryRepresentation() {
        System.out.println("Understanding how numbers are stored in binary:");
        
        int[] numbers = {0, 1, 5, 8, 15, 16, 31, 255};
        
        for (int num : numbers) {
            String binary = Integer.toBinaryString(num);
            String paddedBinary = String.format("%8s", binary).replace(' ', '0');
            System.out.printf("Decimal: %3d → Binary: %s\n", num, paddedBinary);
        }
        
        System.out.println("\nNegative numbers (Two's complement):");
        int[] negativeNumbers = {-1, -5, -8, -16};
        
        for (int num : negativeNumbers) {
            String binary = Integer.toBinaryString(num);
            System.out.printf("Decimal: %3d → Binary: %s\n", num, binary);
        }
    }
    
    /**
     * Demonstrate all bitwise operators
     */
    public static void demonstrateBitwiseOperators() {
        int a = 12;  // Binary: 1100
        int b = 10;  // Binary: 1010
        
        System.out.printf("a = %d (Binary: %s)\n", a, Integer.toBinaryString(a));
        System.out.printf("b = %d (Binary: %s)\n", b, Integer.toBinaryString(b));
        System.out.println();
        
        // AND operator (&)
        int andResult = a & b;
        System.out.printf("a & b = %d & %d = %d (Binary: %s)\n", 
                         a, b, andResult, Integer.toBinaryString(andResult));
        System.out.println("AND: Both bits must be 1 to get 1");
        System.out.println("1100 & 1010 = 1000");
        System.out.println();
        
        // OR operator (|)
        int orResult = a | b;
        System.out.printf("a | b = %d | %d = %d (Binary: %s)\n", 
                         a, b, orResult, Integer.toBinaryString(orResult));
        System.out.println("OR: At least one bit must be 1 to get 1");
        System.out.println("1100 | 1010 = 1110");
        System.out.println();
        
        // XOR operator (^)
        int xorResult = a ^ b;
        System.out.printf("a ^ b = %d ^ %d = %d (Binary: %s)\n", 
                         a, b, xorResult, Integer.toBinaryString(xorResult));
        System.out.println("XOR: Bits must be different to get 1");
        System.out.println("1100 ^ 1010 = 0110");
        System.out.println();
        
        // NOT operator (~)
        int notA = ~a;
        System.out.printf("~a = ~%d = %d (Binary: %s)\n", 
                         a, notA, Integer.toBinaryString(notA));
        System.out.println("NOT: Flips all bits (0→1, 1→0)");
        System.out.println("Note: Result is negative due to two's complement");
    }
    
    /**
     * Demonstrate bit shifting operations
     */
    public static void demonstrateBitShifting() {
        int num = 12; // Binary: 1100
        
        System.out.printf("Original number: %d (Binary: %s)\n", num, Integer.toBinaryString(num));
        System.out.println();
        
        // Left shift (<<)
        System.out.println("=== Left Shift (<<) ===");
        for (int i = 1; i <= 3; i++) {
            int leftShifted = num << i;
            System.out.printf("%d << %d = %d (Binary: %s)\n", 
                             num, i, leftShifted, Integer.toBinaryString(leftShifted));
            System.out.printf("Effect: Multiply by 2^%d = %d\n", i, (int)Math.pow(2, i));
            System.out.println();
        }
        
        // Right shift (>>)
        System.out.println("=== Right Shift (>>) ===");
        int largerNum = 48; // Binary: 110000
        System.out.printf("Using number: %d (Binary: %s)\n", largerNum, Integer.toBinaryString(largerNum));
        
        for (int i = 1; i <= 3; i++) {
            int rightShifted = largerNum >> i;
            System.out.printf("%d >> %d = %d (Binary: %s)\n", 
                             largerNum, i, rightShifted, Integer.toBinaryString(rightShifted));
            System.out.printf("Effect: Divide by 2^%d = %d\n", i, (int)Math.pow(2, i));
            System.out.println();
        }
        
        // Unsigned right shift (>>>)
        System.out.println("=== Unsigned Right Shift (>>>) ===");
        int negativeNum = -8;
        System.out.printf("Negative number: %d (Binary: %s)\n", negativeNum, Integer.toBinaryString(negativeNum));
        
        int signedShift = negativeNum >> 1;
        int unsignedShift = negativeNum >>> 1;
        
        System.out.printf("Signed shift (>>): %d (Binary: %s)\n", signedShift, Integer.toBinaryString(signedShift));
        System.out.printf("Unsigned shift (>>>): %d (Binary: %s)\n", unsignedShift, Integer.toBinaryString(unsignedShift));
    }
    
    /**
     * Demonstrate practical applications of bit operations
     */
    public static void demonstratePracticalApplications() {
        System.out.println("=== Fast Arithmetic Operations ===");
        
        int number = 25;
        
        // Fast multiplication by powers of 2
        System.out.printf("Original: %d\n", number);
        System.out.printf("Multiply by 2: %d << 1 = %d\n", number, number << 1);
        System.out.printf("Multiply by 4: %d << 2 = %d\n", number, number << 2);
        System.out.printf("Multiply by 8: %d << 3 = %d\n", number, number << 3);
        System.out.println();
        
        // Fast division by powers of 2
        int largeNumber = 100;
        System.out.printf("Original: %d\n", largeNumber);
        System.out.printf("Divide by 2: %d >> 1 = %d\n", largeNumber, largeNumber >> 1);
        System.out.printf("Divide by 4: %d >> 2 = %d\n", largeNumber, largeNumber >> 2);
        System.out.printf("Divide by 8: %d >> 3 = %d\n", largeNumber, largeNumber >> 3);
        System.out.println();
        
        // Check if number is even or odd
        System.out.println("=== Even/Odd Check ===");
        int[] testNumbers = {4, 7, 12, 15, 20};
        
        for (int num : testNumbers) {
            boolean isEven = (num & 1) == 0;
            System.out.printf("%d is %s (LSB: %d)\n", num, isEven ? "even" : "odd", num & 1);
        }
    }
    
    /**
     * Demonstrate common bit manipulation tricks
     */
    public static void demonstrateCommonTricks() {
        System.out.println("=== Swap Two Numbers Without Temp Variable ===");
        int x = 15, y = 25;
        System.out.printf("Before swap: x = %d, y = %d\n", x, y);
        
        x = x ^ y;  // x now contains x XOR y
        y = x ^ y;  // y now contains original x
        x = x ^ y;  // x now contains original y
        
        System.out.printf("After swap: x = %d, y = %d\n", x, y);
        System.out.println();
        
        System.out.println("=== Check if Number is Power of 2 ===");
        int[] powerTestNumbers = {1, 2, 4, 6, 8, 15, 16, 32, 33};
        
        for (int num : powerTestNumbers) {
            boolean isPowerOf2 = (num > 0) && ((num & (num - 1)) == 0);
            System.out.printf("%d is %s power of 2\n", num, isPowerOf2 ? "a" : "not a");
        }
        System.out.println();
        
        System.out.println("=== Count Number of Set Bits (1s) ===");
        int[] countTestNumbers = {7, 15, 31, 255};
        
        for (int num : countTestNumbers) {
            int count = Integer.bitCount(num); // Built-in method
            int manualCount = countSetBitsManual(num);
            System.out.printf("%d (Binary: %s) has %d set bits\n", 
                             num, Integer.toBinaryString(num), count);
        }
    }
    
    /**
     * Manually count set bits using bit manipulation
     */
    public static int countSetBitsManual(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1); // Remove the rightmost set bit
        }
        return count;
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Bitwise operators work directly on binary representation:
 *    - & (AND): Both bits must be 1
 *    - | (OR): At least one bit must be 1
 *    - ^ (XOR): Bits must be different
 *    - ~ (NOT): Flips all bits
 * 
 * 2. Bit shifting is fast arithmetic:
 *    - Left shift (<<): Multiply by 2^n
 *    - Right shift (>>): Divide by 2^n (signed)
 *    - Unsigned right shift (>>>): Divide by 2^n (unsigned)
 * 
 * 3. Common applications:
 *    - Fast arithmetic operations
 *    - Even/odd checking
 *    - Power of 2 detection
 *    - Bit counting
 * 
 * 4. Important tricks:
 *    - n & (n-1): Removes rightmost set bit
 *    - n & 1: Checks if number is odd
 *    - x ^ y ^ y = x: XOR properties for swapping
 * 
 * 5. Java specifics:
 *    - int is 32-bit signed integer
 *    - Negative numbers use two's complement
 *    - >>> operator for unsigned right shift
 */
