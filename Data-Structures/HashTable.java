/**
 * HashTable.java - Understanding Hash Table Data Structure
 * 
 * Learning Objectives:
 * - Understand hash table concepts and implementation
 * - Learn about hash functions and collision handling
 * - Practice implementing hash table from scratch
 * - Compare different collision resolution techniques
 * - Understand time complexity and performance characteristics
 */

import java.util.*;

/**
 * Simple Hash Table implementation using separate chaining
 * This helps understand the internal workings of HashMap
 */
class SimpleHashTable<K, V> {
    
    // Inner class to represent key-value pairs
    private static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next; // For chaining in case of collisions
        
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private HashNode<K, V>[] buckets; // Array of linked lists
    private int capacity; // Size of the bucket array
    private int size;     // Number of key-value pairs
    
    // Constructor
    @SuppressWarnings("unchecked")
    public SimpleHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new HashNode[capacity];
    }
    
    // Default constructor
    public SimpleHashTable() {
        this(16); // Default capacity
    }
    
    /**
     * Hash function to convert key to array index
     * This is a simple hash function for demonstration
     */
    private int hash(K key) {
        if (key == null) return 0;
        
        // Use built-in hashCode() and handle negative values
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }
    
    /**
     * Insert or update a key-value pair
     */
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> head = buckets[index];
        
        // Check if key already exists
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // Update existing key
                return;
            }
            current = current.next;
        }
        
        // Key doesn't exist, add new node at the beginning
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;
        
        // Check if we need to resize (load factor > 0.75)
        if ((double) size / capacity > 0.75) {
            resize();
        }
    }
    
    /**
     * Get value by key
     */
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = buckets[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        
        return null; // Key not found
    }
    
    /**
     * Remove a key-value pair
     */
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = buckets[index];
        HashNode<K, V> prev = null;
        
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    // Removing the first node
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        
        return null; // Key not found
    }
    
    /**
     * Check if key exists
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    /**
     * Get the number of key-value pairs
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if hash table is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Resize the hash table when load factor becomes too high
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        HashNode<K, V>[] oldBuckets = buckets;
        capacity *= 2;
        size = 0;
        buckets = new HashNode[capacity];
        
        // Rehash all existing elements
        for (HashNode<K, V> head : oldBuckets) {
            HashNode<K, V> current = head;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    /**
     * Display the hash table structure
     */
    public void display() {
        System.out.println("Hash Table Structure (Capacity: " + capacity + ", Size: " + size + "):");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode<K, V> current = buckets[i];
            if (current == null) {
                System.out.println("empty");
            } else {
                while (current != null) {
                    System.out.print("[" + current.key + ":" + current.value + "]");
                    if (current.next != null) {
                        System.out.print(" -> ");
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}

public class HashTable {
    
    public static void main(String[] args) {
        
        System.out.println("=== Hash Table Implementation and Concepts ===\n");
        
        // ========== BASIC HASH TABLE OPERATIONS ==========
        
        System.out.println("=== Basic Hash Table Operations ===");
        demonstrateBasicOperations();
        
        // ========== COLLISION HANDLING ==========
        
        System.out.println("\n=== Collision Handling ===");
        demonstrateCollisions();
        
        // ========== HASH FUNCTION ANALYSIS ==========
        
        System.out.println("\n=== Hash Function Analysis ===");
        demonstrateHashFunction();
        
        // ========== PERFORMANCE COMPARISON ==========
        
        System.out.println("\n=== Performance Comparison ===");
        compareWithJavaHashMap();
        
        // ========== REAL-WORLD APPLICATIONS ==========
        
        System.out.println("\n=== Real-world Applications ===");
        demonstrateApplications();
    }
    
    /**
     * Demonstrate basic hash table operations
     */
    public static void demonstrateBasicOperations() {
        SimpleHashTable<String, Integer> hashTable = new SimpleHashTable<>(8);
        
        System.out.println("Creating a hash table with capacity 8");
        hashTable.display();
        
        // Insert operations
        System.out.println("Inserting key-value pairs:");
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 8);
        hashTable.put("grape", 12);
        
        hashTable.display();
        
        // Get operations
        System.out.println("Retrieving values:");
        System.out.println("apple: " + hashTable.get("apple"));
        System.out.println("banana: " + hashTable.get("banana"));
        System.out.println("mango: " + hashTable.get("mango")); // Not found
        
        // Update operation
        System.out.println("\nUpdating apple value to 10:");
        hashTable.put("apple", 10);
        System.out.println("apple: " + hashTable.get("apple"));
        
        // Remove operation
        System.out.println("\nRemoving banana:");
        Integer removed = hashTable.remove("banana");
        System.out.println("Removed value: " + removed);
        hashTable.display();
    }
    
    /**
     * Demonstrate collision handling
     */
    public static void demonstrateCollisions() {
        // Create a small hash table to force collisions
        SimpleHashTable<String, String> hashTable = new SimpleHashTable<>(4);
        
        System.out.println("Creating small hash table (capacity 4) to demonstrate collisions:");
        
        // These keys might hash to the same bucket
        hashTable.put("key1", "value1");
        hashTable.put("key2", "value2");
        hashTable.put("key3", "value3");
        hashTable.put("key4", "value4");
        hashTable.put("key5", "value5"); // This will likely cause collision
        
        hashTable.display();
        
        System.out.println("Notice how multiple keys can be in the same bucket (collision)");
        System.out.println("Our implementation uses separate chaining to handle collisions");
    }
    
    /**
     * Demonstrate hash function behavior
     */
    public static void demonstrateHashFunction() {
        System.out.println("Understanding hash functions:");
        
        String[] keys = {"apple", "banana", "cherry", "date", "elderberry"};
        int capacity = 8;
        
        System.out.println("Hash values for different keys (capacity = " + capacity + "):");
        for (String key : keys) {
            int hashCode = key.hashCode();
            int index = Math.abs(hashCode) % capacity;
            System.out.printf("Key: %-12s | HashCode: %-10d | Index: %d\n", 
                             key, hashCode, index);
        }
        
        System.out.println("\nKey insights:");
        System.out.println("- Hash function converts key to array index");
        System.out.println("- Good hash function distributes keys evenly");
        System.out.println("- Collisions occur when different keys hash to same index");
    }
    
    /**
     * Compare with Java's built-in HashMap
     */
    public static void compareWithJavaHashMap() {
        System.out.println("Comparing with Java's HashMap:");
        
        // Our implementation
        SimpleHashTable<String, Integer> ourHashTable = new SimpleHashTable<>();
        
        // Java's HashMap
        HashMap<String, Integer> javaHashMap = new HashMap<>();
        
        String[] keys = {"apple", "banana", "cherry", "date", "elderberry"};
        int[] values = {5, 3, 8, 12, 6};
        
        // Time our implementation
        long startTime = System.nanoTime();
        for (int i = 0; i < keys.length; i++) {
            ourHashTable.put(keys[i], values[i]);
        }
        long ourTime = System.nanoTime() - startTime;
        
        // Time Java's HashMap
        startTime = System.nanoTime();
        for (int i = 0; i < keys.length; i++) {
            javaHashMap.put(keys[i], values[i]);
        }
        long javaTime = System.nanoTime() - startTime;
        
        System.out.println("Insertion time comparison:");
        System.out.println("Our implementation: " + ourTime + " nanoseconds");
        System.out.println("Java HashMap: " + javaTime + " nanoseconds");
        System.out.println("(Note: Java's HashMap is highly optimized)");
    }
    
    /**
     * Demonstrate real-world applications
     */
    public static void demonstrateApplications() {
        System.out.println("Real-world applications of hash tables:");
        
        // 1. Caching
        System.out.println("\n1. Caching System:");
        SimpleHashTable<String, String> cache = new SimpleHashTable<>();
        cache.put("user:123", "John Doe");
        cache.put("user:456", "Jane Smith");
        System.out.println("Cached user data: " + cache.get("user:123"));
        
        // 2. Frequency counting
        System.out.println("\n2. Frequency Counting:");
        String text = "hello world hello java world";
        SimpleHashTable<String, Integer> wordCount = new SimpleHashTable<>();
        
        for (String word : text.split(" ")) {
            Integer count = wordCount.get(word);
            wordCount.put(word, (count == null) ? 1 : count + 1);
        }
        
        System.out.println("Word frequencies:");
        // Note: In a real implementation, we'd have a method to iterate over all keys
        System.out.println("hello: " + wordCount.get("hello"));
        System.out.println("world: " + wordCount.get("world"));
        System.out.println("java: " + wordCount.get("java"));
        
        System.out.println("\n=== Hash Table lesson completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Hash Table Components:
 *    - Hash function: Converts key to array index
 *    - Buckets: Array slots to store key-value pairs
 *    - Collision handling: Method to handle multiple keys mapping to same index
 * 
 * 2. Collision Resolution Techniques:
 *    - Separate Chaining: Use linked lists in each bucket
 *    - Open Addressing: Find next available slot (linear/quadratic probing)
 * 
 * 3. Time Complexity:
 *    - Average case: O(1) for insert, search, delete
 *    - Worst case: O(n) when all keys hash to same bucket
 * 
 * 4. Load Factor:
 *    - Ratio of number of elements to bucket count
 *    - Keep below 0.75 for good performance
 *    - Resize when load factor gets too high
 * 
 * 5. Applications:
 *    - Database indexing
 *    - Caching systems
 *    - Symbol tables in compilers
 *    - Frequency counting
 *    - Set operations
 */
