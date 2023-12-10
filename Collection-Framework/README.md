# Java Collection Framework 📚

The Java Collection Framework is a unified architecture for representing and manipulating collections of objects. It provides ready-to-use data structures and algorithms, making programming more efficient and standardized.

## What is Collection Framework?

The Collection Framework is a set of classes and interfaces that implement commonly reusable collection data structures. It provides:
- **Interfaces**: Abstract data types representing collections
- **Implementations**: Concrete implementations of collection interfaces
- **Algorithms**: Methods for searching, sorting, and manipulating collections

## Collection Hierarchy

```
Collection (Interface)
├── List (Interface) - Ordered, allows duplicates
│   ├── ArrayList - Dynamic array implementation
│   ├── LinkedList - Doubly linked list implementation
│   └── Vector - Synchronized dynamic array
├── Set (Interface) - No duplicates allowed
│   ├── HashSet - Hash table implementation
│   ├── LinkedHashSet - Hash table + linked list
│   └── TreeSet - Red-black tree implementation
└── Queue (Interface) - FIFO operations
    ├── PriorityQueue - Heap-based priority queue
    └── LinkedList - Also implements Queue

Map (Interface) - Key-value pairs
├── HashMap - Hash table implementation
├── LinkedHashMap - Hash table + linked list
└── TreeMap - Red-black tree implementation
```

## Topics Covered

### 1. **ArrayListDemo.java** - Dynamic arrays
- ArrayList creation and initialization
- Adding, removing, and accessing elements
- Iteration techniques
- ArrayList vs Array comparison

### 2. **LinkedListDemo.java** - Doubly linked lists
- LinkedList operations
- Performance comparison with ArrayList
- Using LinkedList as Stack and Queue
- When to choose LinkedList over ArrayList

### 3. **HashSetDemo.java** - Unique elements collection
- Set operations and properties
- Adding, removing, checking elements
- Set operations: union, intersection, difference
- HashSet vs TreeSet vs LinkedHashSet

### 4. **HashMapDemo.java** - Key-value mapping
- Map operations and methods
- Iterating over maps
- Common map patterns and use cases
- HashMap vs TreeMap vs LinkedHashMap

### 5. **IteratorsDemo.java** - Collection traversal
- Iterator interface and usage
- ListIterator for bidirectional traversal
- Enhanced for loop vs Iterator
- Concurrent modification handling

### 6. **CollectionsUtility.java** - Utility methods
- Collections class static methods
- Sorting, searching, and shuffling
- Creating immutable collections
- Synchronization and thread safety

## Key Interfaces

### **Collection Interface**
- Root interface for all collections
- Basic operations: add(), remove(), contains(), size()
- Bulk operations: addAll(), removeAll(), containsAll()

### **List Interface**
- Ordered collection (sequence)
- Allows duplicate elements
- Index-based access: get(index), set(index, element)
- Implementations: ArrayList, LinkedList, Vector

### **Set Interface**
- Collection with no duplicate elements
- Mathematical set operations
- Implementations: HashSet, LinkedHashSet, TreeSet

### **Map Interface**
- Key-value pair mapping
- No duplicate keys allowed
- Operations: put(), get(), remove(), containsKey()
- Implementations: HashMap, LinkedHashMap, TreeMap

## Performance Comparison

| Operation | ArrayList | LinkedList | HashSet | HashMap |
|-----------|-----------|------------|---------|---------|
| Add | O(1)* | O(1) | O(1)* | O(1)* |
| Remove | O(n) | O(1)** | O(1)* | O(1)* |
| Get | O(1) | O(n) | O(1)* | O(1)* |
| Contains | O(n) | O(n) | O(1)* | O(1)* |
| Iteration | O(n) | O(n) | O(n) | O(n) |

*Average case, O(n) worst case  
**If you have reference to the node

## When to Use Which Collection

### **ArrayList**
- ✅ Frequent random access to elements
- ✅ More reads than writes
- ✅ Memory efficiency is important
- ❌ Frequent insertions/deletions in middle

### **LinkedList**
- ✅ Frequent insertions/deletions
- ✅ Implementing stacks or queues
- ✅ Size varies significantly
- ❌ Random access to elements

### **HashSet**
- ✅ Need unique elements
- ✅ Fast lookups required
- ✅ Order doesn't matter
- ❌ Need sorted elements

### **TreeSet**
- ✅ Need unique, sorted elements
- ✅ Range operations required
- ✅ Natural ordering needed
- ❌ Performance is critical

### **HashMap**
- ✅ Fast key-value lookups
- ✅ Order doesn't matter
- ✅ General-purpose mapping
- ❌ Need sorted keys

### **TreeMap**
- ✅ Need sorted key-value pairs
- ✅ Range operations on keys
- ✅ Natural key ordering
- ❌ Performance is critical

## Best Practices

### **Choosing Collections**
1. **Use interfaces for declarations**: `List<String> list = new ArrayList<>();`
2. **Choose based on operations**: Consider what operations you'll perform most
3. **Consider thread safety**: Use concurrent collections for multi-threaded access
4. **Specify initial capacity**: For better performance when size is known

### **Performance Tips**
1. **ArrayList**: Specify initial capacity if size is known
2. **HashMap**: Choose good hash function and initial capacity
3. **Iteration**: Use enhanced for loop when possible
4. **Bulk operations**: Use addAll(), removeAll() instead of loops

### **Memory Considerations**
1. **Trim collections**: Use trimToSize() for ArrayList when done adding
2. **Remove unused references**: Set to null when no longer needed
3. **Choose appropriate collection**: Don't use HashMap for small, fixed data

## Common Patterns

### **Initialization**
```java
// List initialization
List<String> list = Arrays.asList("a", "b", "c");
List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c"));

// Set initialization
Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));

// Map initialization
Map<String, Integer> map = new HashMap<>();
map.put("one", 1);
map.put("two", 2);
```

### **Safe Iteration**
```java
// Safe removal during iteration
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    if (shouldRemove(item)) {
        it.remove(); // Safe removal
    }
}
```

## Learning Progression

1. **Understand Collection hierarchy** and interfaces
2. **Master ArrayList** - most commonly used collection
3. **Learn HashMap** - essential for key-value operations
4. **Practice with HashSet** - understand Set operations
5. **Explore LinkedList** - understand when to use it
6. **Study utility methods** - Collections class helpers
7. **Learn iteration patterns** - safe and efficient traversal

---
*Collections make Java programming more efficient and standardized!*
