# Data Structures in Java 🏗️

Data structures are ways of organizing and storing data to enable efficient access and modification. Understanding data structures is crucial for writing efficient algorithms and solving complex problems.

## What are Data Structures?

Data structures are containers that organize data in a specific way to make operations like insertion, deletion, searching, and traversal efficient. Different data structures are optimized for different types of operations.

## Categories of Data Structures

### **Linear Data Structures**
- Elements are arranged in a sequential manner
- Each element has a unique predecessor and successor (except first and last)
- Examples: Arrays, Linked Lists, Stacks, Queues

### **Non-Linear Data Structures**
- Elements are not arranged sequentially
- Elements can have multiple predecessors and successors
- Examples: Trees, Graphs, Hash Tables

## Topics Covered

### 1. **LinkedList.java** - Dynamic linear structure
- Singly Linked List implementation
- Node structure and pointer manipulation
- Insertion, deletion, and traversal operations
- Advantages over arrays

### 2. **Stack.java** - LIFO (Last In, First Out)
- Stack implementation using arrays and linked lists
- Push, pop, peek operations
- Applications: expression evaluation, function calls
- Practical examples and use cases

### 3. **Queue.java** - FIFO (First In, First Out)
- Queue implementation using arrays and linked lists
- Enqueue, dequeue, front operations
- Circular queue implementation
- Applications: scheduling, breadth-first search

### 4. **BinaryTree.java** - Hierarchical structure
- Binary tree node structure
- Tree traversal algorithms (inorder, preorder, postorder)
- Binary Search Tree (BST) operations
- Tree properties and applications

### 5. **HashTable.java** - Key-value mapping
- Hash function implementation
- Collision handling techniques
- Hash table operations
- Performance analysis

### 6. **Graph.java** - Network structure
- Graph representation (adjacency list, matrix)
- Graph traversal (DFS, BFS)
- Basic graph algorithms
- Real-world applications

## Time Complexity Comparison

| Data Structure | Access | Search | Insertion | Deletion |
|----------------|--------|--------|-----------|----------|
| Array | O(1) | O(n) | O(n) | O(n) |
| Linked List | O(n) | O(n) | O(1) | O(1) |
| Stack | O(n) | O(n) | O(1) | O(1) |
| Queue | O(n) | O(n) | O(1) | O(1) |
| Binary Search Tree | O(log n) | O(log n) | O(log n) | O(log n) |
| Hash Table | N/A | O(1)* | O(1)* | O(1)* |

*Average case, O(n) worst case

## Key Concepts

### **Memory Management**
- **Static**: Fixed size at compile time (Arrays)
- **Dynamic**: Size can change at runtime (Linked Lists)

### **Access Patterns**
- **Sequential**: Elements accessed one after another
- **Random**: Elements accessed in any order

### **Operation Types**
- **Insertion**: Adding new elements
- **Deletion**: Removing elements
- **Traversal**: Visiting all elements
- **Searching**: Finding specific elements

## Choosing the Right Data Structure

### **Use Arrays when:**
- You need fast random access to elements
- Memory usage is a concern
- You're doing mathematical operations

### **Use Linked Lists when:**
- Frequent insertions/deletions at arbitrary positions
- Size varies significantly
- You don't need random access

### **Use Stacks when:**
- You need LIFO behavior
- Implementing recursion iteratively
- Parsing expressions or syntax

### **Use Queues when:**
- You need FIFO behavior
- Implementing breadth-first search
- Managing tasks or requests

### **Use Trees when:**
- You need hierarchical data representation
- Fast searching in sorted data
- Implementing file systems or decision trees

### **Use Hash Tables when:**
- You need very fast lookups
- Implementing caches or databases
- Counting frequencies

## Learning Progression

1. **Start with Arrays** - Understand basic concepts
2. **Learn Linked Lists** - Dynamic memory management
3. **Master Stack and Queue** - Linear data structures with restrictions
4. **Explore Trees** - Hierarchical data organization
5. **Understand Hash Tables** - Fast key-value mapping
6. **Study Graphs** - Complex relationship modeling

## Real-World Applications

### **Stacks**
- Browser back button
- Undo operations in editors
- Function call management

### **Queues**
- Print job scheduling
- CPU task scheduling
- Breadth-first search in maps

### **Trees**
- File system directories
- Database indexing
- Decision making algorithms

### **Hash Tables**
- Database indexing
- Caching systems
- Compiler symbol tables

### **Graphs**
- Social networks
- GPS navigation
- Network routing

---
*Master data structures to become a better programmer and problem solver!*
