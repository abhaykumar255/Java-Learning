# Bit Manipulation in Java 🔢

Bit manipulation involves directly manipulating bits using bitwise operators. It's essential for optimization, low-level programming, and solving certain algorithmic problems efficiently.

## Topics Covered

### 1. **BitBasics.java** - Introduction to bit operations
- Understanding binary representation
- Bitwise operators (AND, OR, XOR, NOT, shifts)
- Converting between decimal and binary
- Basic bit manipulation techniques

### 2. **BitTricks.java** - Common bit manipulation tricks
- Check if number is power of 2
- Count set bits (1s) in a number
- Find the only non-duplicate number
- Swap two numbers without temp variable

### 3. **BitProblems.java** - Algorithmic problems using bits
- Single number problems
- Missing number using XOR
- Bit manipulation in arrays
- Subset generation using bits

### 4. **BitOptimization.java** - Performance optimization
- Fast multiplication and division
- Bit masking techniques
- Space-efficient data structures
- Boolean array compression

## Key Concepts

### **Bitwise Operators**
- `&` (AND): Both bits must be 1
- `|` (OR): At least one bit must be 1  
- `^` (XOR): Bits must be different
- `~` (NOT): Flips all bits
- `<<` (Left Shift): Multiply by 2^n
- `>>` (Right Shift): Divide by 2^n

### **Common Bit Tricks**
- `n & (n-1)`: Removes the rightmost set bit
- `n & -n`: Isolates the rightmost set bit
- `n ^ n`: Always equals 0
- `n ^ 0`: Always equals n

### **Applications**
- Fast arithmetic operations
- Memory optimization
- Cryptography and hashing
- Graphics and game programming
- Competitive programming

## Learning Path

1. Start with `BitBasics.java` to understand fundamentals
2. Learn common tricks in `BitTricks.java`
3. Practice problems in `BitProblems.java`
4. Explore optimizations in `BitOptimization.java`

## Important Notes

- Bit manipulation can make code faster but less readable
- Always consider the trade-off between optimization and maintainability
- Useful for competitive programming and system-level programming
- Understanding binary representation is crucial

---
*Think in bits, optimize in bytes! 💻*
