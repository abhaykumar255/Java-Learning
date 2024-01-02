# Algorithms in Java 🧮

Algorithms are step-by-step procedures for solving computational problems. Understanding algorithms is crucial for writing efficient code and solving complex programming challenges.

## What are Algorithms?

An algorithm is a finite sequence of well-defined instructions for solving a problem or performing a computation. Good algorithms are:
- **Correct**: Produces the right output for all valid inputs
- **Efficient**: Uses minimal time and space resources
- **Clear**: Easy to understand and implement
- **Robust**: Handles edge cases gracefully

## Algorithm Categories

### **By Problem Type**
- **Sorting**: Arranging data in order
- **Searching**: Finding specific elements
- **Graph**: Working with networks and relationships
- **Dynamic Programming**: Optimizing recursive problems
- **Greedy**: Making locally optimal choices
- **Divide and Conquer**: Breaking problems into subproblems

### **By Approach**
- **Iterative**: Using loops
- **Recursive**: Function calling itself
- **Brute Force**: Trying all possibilities
- **Optimization**: Finding best solution

## Topics Covered

### 1. **SortingAlgorithms.java** - Data ordering
- Bubble Sort, Selection Sort, Insertion Sort
- Merge Sort, Quick Sort, Heap Sort
- Time and space complexity analysis
- When to use which sorting algorithm

### 2. **SearchingAlgorithms.java** - Data retrieval
- Linear Search, Binary Search
- Interpolation Search, Exponential Search
- Search optimization techniques
- Search in different data structures

### 3. **RecursionExamples.java** - Recursive solutions
- Understanding recursion principles
- Base cases and recursive cases
- Factorial, Fibonacci, Tower of Hanoi
- Recursion vs iteration trade-offs

### 4. **DynamicProgramming.java** - Optimization problems
- Memoization and tabulation
- Fibonacci with DP, Longest Common Subsequence
- Knapsack problem, Coin change problem
- Bottom-up vs top-down approaches

### 5. **GreedyAlgorithms.java** - Local optimization
- Greedy choice property
- Activity selection, Fractional knapsack
- Huffman coding, Minimum spanning tree
- When greedy works and when it doesn't

### 6. **GraphAlgorithms.java** - Network problems
- Graph representation and traversal
- Depth-First Search (DFS), Breadth-First Search (BFS)
- Shortest path algorithms (Dijkstra, Floyd-Warshall)
- Minimum spanning tree (Kruskal, Prim)

## Time Complexity Analysis

### **Big O Notation**
Describes the upper bound of algorithm's time complexity

| Complexity | Name | Example |
|------------|------|---------|
| O(1) | Constant | Array access |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Linear search |
| O(n log n) | Linearithmic | Merge sort |
| O(n²) | Quadratic | Bubble sort |
| O(n³) | Cubic | Matrix multiplication |
| O(2ⁿ) | Exponential | Recursive Fibonacci |
| O(n!) | Factorial | Traveling salesman |

### **Space Complexity**
Amount of memory an algorithm uses

- **In-place**: O(1) extra space
- **Linear**: O(n) extra space
- **Recursive**: O(depth) stack space

## Sorting Algorithms Comparison

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable |
|-----------|-----------|--------------|------------|-------|--------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | No |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | No |

## Algorithm Design Techniques

### **1. Divide and Conquer**
- Break problem into smaller subproblems
- Solve subproblems recursively
- Combine solutions
- **Examples**: Merge Sort, Quick Sort, Binary Search

### **2. Dynamic Programming**
- Break problem into overlapping subproblems
- Store solutions to avoid recomputation
- Build solution bottom-up or top-down
- **Examples**: Fibonacci, Knapsack, LCS

### **3. Greedy Algorithms**
- Make locally optimal choice at each step
- Hope global optimum is achieved
- Works when greedy choice property holds
- **Examples**: Activity Selection, Huffman Coding

### **4. Backtracking**
- Try all possibilities systematically
- Abandon paths that can't lead to solution
- Use recursion with pruning
- **Examples**: N-Queens, Sudoku Solver

### **5. Branch and Bound**
- Systematic enumeration with pruning
- Use bounds to eliminate subproblems
- Often used for optimization problems
- **Examples**: Traveling Salesman, Knapsack

## Problem-Solving Strategies

### **1. Understand the Problem**
- Read carefully and identify inputs/outputs
- Consider edge cases and constraints
- Look for patterns or similar problems

### **2. Choose the Right Approach**
- Analyze time and space requirements
- Consider the size of input data
- Think about trade-offs

### **3. Implement and Test**
- Start with simple cases
- Test with edge cases
- Optimize if necessary

### **4. Analyze Complexity**
- Calculate time and space complexity
- Compare with alternative solutions
- Document assumptions and limitations

## Common Algorithm Patterns

### **Two Pointers**
```java
// Find pair with target sum in sorted array
int left = 0, right = arr.length - 1;
while (left < right) {
    int sum = arr[left] + arr[right];
    if (sum == target) return true;
    else if (sum < target) left++;
    else right--;
}
```

### **Sliding Window**
```java
// Find maximum sum of k consecutive elements
int maxSum = 0, windowSum = 0;
for (int i = 0; i < k; i++) windowSum += arr[i];
maxSum = windowSum;
for (int i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
}
```

### **Binary Search Template**
```java
int left = 0, right = arr.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1;
```

## Algorithm Selection Guide

### **For Sorting**
- **Small arrays (< 50)**: Insertion Sort
- **General purpose**: Quick Sort or Merge Sort
- **Stability required**: Merge Sort
- **Memory constrained**: Heap Sort
- **Nearly sorted**: Insertion Sort

### **For Searching**
- **Unsorted data**: Linear Search
- **Sorted data**: Binary Search
- **Frequent searches**: Hash Table
- **Range queries**: Binary Search Tree

### **For Optimization**
- **Optimal substructure**: Dynamic Programming
- **Greedy choice property**: Greedy Algorithm
- **Small search space**: Brute Force
- **Large search space**: Heuristic methods

## Learning Progression

1. **Master basic sorting and searching** - Foundation algorithms
2. **Understand recursion** - Essential for advanced algorithms
3. **Learn dynamic programming** - Optimization technique
4. **Practice greedy algorithms** - Local optimization strategy
5. **Study graph algorithms** - Network and relationship problems
6. **Explore advanced topics** - String algorithms, computational geometry

## Real-World Applications

### **Sorting**
- Database indexing
- Search engine ranking
- Data analysis and reporting
- Graphics rendering

### **Searching**
- Web search engines
- Database queries
- File systems
- Network routing

### **Graph Algorithms**
- Social networks
- GPS navigation
- Network protocols
- Recommendation systems

### **Dynamic Programming**
- Resource allocation
- Sequence alignment (bioinformatics)
- Financial modeling
- Game theory

---
*Algorithms are the heart of computer science - master them to become a better programmer!*
