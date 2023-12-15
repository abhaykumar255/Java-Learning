/**
 * LinkedList.java - Implementation of Singly Linked List Data Structure
 * 
 * Learning Objectives:
 * - Understand linked list structure and node concept
 * - Implement basic linked list operations (insert, delete, search)
 * - Compare linked list with arrays
 * - Practice pointer manipulation and memory management
 * - Understand when to use linked lists vs arrays
 */

/**
 * Node class represents individual elements in the linked list
 * Each node contains data and a reference to the next node
 */
class ListNode {
    int data;           // Data stored in the node
    ListNode next;      // Reference to the next node
    
    // Constructor to create a new node
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * LinkedList class implements a singly linked list
 */
class SinglyLinkedList {
    private ListNode head;  // Reference to the first node
    private int size;       // Number of elements in the list
    
    // Constructor to create an empty linked list
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Insert element at the beginning of the list
     * Time Complexity: O(1)
     */
    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;    // Point new node to current head
        head = newNode;         // Update head to point to new node
        size++;
        System.out.println("Inserted " + data + " at beginning");
    }
    
    /**
     * Insert element at the end of the list
     * Time Complexity: O(n)
     */
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        
        // If list is empty, make new node the head
        if (head == null) {
            head = newNode;
            size++;
            System.out.println("Inserted " + data + " at end (first element)");
            return;
        }
        
        // Traverse to the last node
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        // Link the last node to new node
        current.next = newNode;
        size++;
        System.out.println("Inserted " + data + " at end");
    }
    
    /**
     * Insert element at specific position
     * Time Complexity: O(n)
     */
    public void insertAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position: " + position);
            return;
        }
        
        // Insert at beginning if position is 0
        if (position == 0) {
            insertAtBeginning(data);
            return;
        }
        
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        
        // Traverse to position - 1
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        // Insert new node
        newNode.next = current.next;
        current.next = newNode;
        size++;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    /**
     * Delete element from the beginning
     * Time Complexity: O(1)
     */
    public boolean deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty, cannot delete");
            return false;
        }
        
        int deletedData = head.data;
        head = head.next;   // Move head to next node
        size--;
        System.out.println("Deleted " + deletedData + " from beginning");
        return true;
    }
    
    /**
     * Delete element from the end
     * Time Complexity: O(n)
     */
    public boolean deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty, cannot delete");
            return false;
        }
        
        // If only one element
        if (head.next == null) {
            int deletedData = head.data;
            head = null;
            size--;
            System.out.println("Deleted " + deletedData + " from end (last element)");
            return true;
        }
        
        // Traverse to second last node
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        int deletedData = current.next.data;
        current.next = null;    // Remove reference to last node
        size--;
        System.out.println("Deleted " + deletedData + " from end");
        return true;
    }
    
    /**
     * Delete element by value
     * Time Complexity: O(n)
     */
    public boolean deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty, cannot delete " + data);
            return false;
        }
        
        // If head node contains the data
        if (head.data == data) {
            head = head.next;
            size--;
            System.out.println("Deleted " + data + " (was head)");
            return true;
        }
        
        // Search for the node to delete
        ListNode current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        // If data not found
        if (current.next == null) {
            System.out.println("Element " + data + " not found");
            return false;
        }
        
        // Delete the node
        current.next = current.next.next;
        size--;
        System.out.println("Deleted " + data);
        return true;
    }
    
    /**
     * Search for an element in the list
     * Time Complexity: O(n)
     */
    public boolean search(int data) {
        ListNode current = head;
        int position = 0;
        
        while (current != null) {
            if (current.data == data) {
                System.out.println("Found " + data + " at position " + position);
                return true;
            }
            current = current.next;
            position++;
        }
        
        System.out.println("Element " + data + " not found");
        return false;
    }
    
    /**
     * Get element at specific position
     * Time Complexity: O(n)
     */
    public Integer get(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position: " + position);
            return null;
        }
        
        ListNode current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        
        return current.data;
    }
    
    /**
     * Display all elements in the list
     * Time Complexity: O(n)
     */
    public void display() {
        if (head == null) {
            System.out.println("List is empty: []");
            return;
        }
        
        System.out.print("List: [");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println("] (size: " + size + ")");
    }
    
    /**
     * Get the size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if list is empty
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Reverse the linked list
     * Time Complexity: O(n)
     */
    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("List is empty or has only one element");
            return;
        }
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;    // Store next node
            current.next = prev;    // Reverse the link
            prev = current;         // Move prev forward
            current = next;         // Move current forward
        }
        
        head = prev;    // Update head to new first node
        System.out.println("List reversed");
    }
    
    /**
     * Find the middle element of the list (using two pointers)
     * Time Complexity: O(n)
     */
    public Integer findMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        
        ListNode slow = head;   // Moves one step at a time
        ListNode fast = head;   // Moves two steps at a time
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        System.out.println("Middle element: " + slow.data);
        return slow.data;
    }
    
    /**
     * Detect if there's a cycle in the list (Floyd's algorithm)
     * Time Complexity: O(n)
     */
    public boolean hasCycle() {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                System.out.println("Cycle detected");
                return true;
            }
        }
        
        System.out.println("No cycle detected");
        return false;
    }
}

public class LinkedList {
    
    public static void main(String[] args) {
        
        System.out.println("=== Linked List Implementation ===\n");
        
        // Create a new linked list
        SinglyLinkedList list = new SinglyLinkedList();
        
        // ========== INSERTION OPERATIONS ==========
        
        System.out.println("=== Insertion Operations ===");
        
        // Insert at beginning
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.display();
        
        // Insert at end
        list.insertAtEnd(5);
        list.insertAtEnd(1);
        list.display();
        
        // Insert at specific position
        list.insertAtPosition(15, 2);
        list.insertAtPosition(25, 0);  // At beginning
        list.insertAtPosition(0, 7);   // At end
        list.display();
        
        // ========== SEARCH OPERATIONS ==========
        
        System.out.println("\n=== Search Operations ===");
        
        list.search(15);    // Should find
        list.search(100);   // Should not find
        
        // Get element at position
        System.out.println("Element at position 3: " + list.get(3));
        System.out.println("Element at position 10: " + list.get(10)); // Invalid
        
        // ========== DELETION OPERATIONS ==========
        
        System.out.println("\n=== Deletion Operations ===");
        
        list.display();
        
        // Delete from beginning
        list.deleteFromBeginning();
        list.display();
        
        // Delete from end
        list.deleteFromEnd();
        list.display();
        
        // Delete by value
        list.deleteByValue(15);
        list.deleteByValue(100);  // Not found
        list.display();
        
        // ========== ADVANCED OPERATIONS ==========
        
        System.out.println("\n=== Advanced Operations ===");
        
        // Find middle element
        list.findMiddle();
        
        // Reverse the list
        list.reverse();
        list.display();
        
        // Check for cycle
        list.hasCycle();
        
        // ========== COMPARISON WITH ARRAYS ==========
        
        System.out.println("\n=== Linked List vs Array Comparison ===");
        compareWithArrays();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        practicalExamples();
        
        System.out.println("\n=== Linked List lesson completed! ===");
    }
    
    /**
     * Compare linked list with arrays
     */
    public static void compareWithArrays() {
        System.out.println("Linked List vs Array:");
        System.out.println("┌─────────────────┬─────────────────┬─────────────────┐");
        System.out.println("│ Operation       │ Linked List     │ Array           │");
        System.out.println("├─────────────────┼─────────────────┼─────────────────┤");
        System.out.println("│ Access by index │ O(n)            │ O(1)            │");
        System.out.println("│ Insert at start │ O(1)            │ O(n)            │");
        System.out.println("│ Insert at end   │ O(n)            │ O(1)*           │");
        System.out.println("│ Delete at start │ O(1)            │ O(n)            │");
        System.out.println("│ Delete at end   │ O(n)            │ O(1)            │");
        System.out.println("│ Search          │ O(n)            │ O(n)            │");
        System.out.println("│ Memory usage    │ Extra pointers  │ Contiguous      │");
        System.out.println("│ Cache locality  │ Poor            │ Good            │");
        System.out.println("└─────────────────┴─────────────────┴─────────────────┘");
        System.out.println("*O(n) if array needs to be resized");
        
        System.out.println("\nWhen to use Linked List:");
        System.out.println("✅ Frequent insertions/deletions at beginning");
        System.out.println("✅ Size varies significantly");
        System.out.println("✅ Don't know maximum size in advance");
        System.out.println("✅ Implementing other data structures (stacks, queues)");
        
        System.out.println("\nWhen to use Array:");
        System.out.println("✅ Need random access to elements");
        System.out.println("✅ Memory usage is critical");
        System.out.println("✅ Cache performance is important");
        System.out.println("✅ Mathematical operations on data");
    }
    
    /**
     * Practical examples of linked list usage
     */
    public static void practicalExamples() {
        
        // Example 1: Undo functionality
        System.out.println("Example 1: Undo Functionality");
        SinglyLinkedList undoStack = new SinglyLinkedList();
        
        // Simulate user actions
        undoStack.insertAtBeginning(1); // Action 1
        undoStack.insertAtBeginning(2); // Action 2
        undoStack.insertAtBeginning(3); // Action 3
        
        System.out.println("Actions performed:");
        undoStack.display();
        
        // Undo last action
        System.out.println("Undoing last action...");
        undoStack.deleteFromBeginning();
        undoStack.display();
        
        // Example 2: Music playlist
        System.out.println("\nExample 2: Music Playlist");
        SinglyLinkedList playlist = new SinglyLinkedList();
        
        // Add songs (represented by numbers)
        playlist.insertAtEnd(101); // Song 1
        playlist.insertAtEnd(102); // Song 2
        playlist.insertAtEnd(103); // Song 3
        playlist.insertAtEnd(104); // Song 4
        
        System.out.println("Current playlist:");
        playlist.display();
        
        // Add song at specific position
        playlist.insertAtPosition(105, 2);
        System.out.println("After adding song 105 at position 2:");
        playlist.display();
        
        // Remove a song
        playlist.deleteByValue(102);
        System.out.println("After removing song 102:");
        playlist.display();
        
        // Example 3: Browser history (simplified)
        System.out.println("\nExample 3: Browser History");
        SinglyLinkedList history = new SinglyLinkedList();
        
        // Visit pages (represented by numbers)
        history.insertAtBeginning(1); // google.com
        history.insertAtBeginning(2); // stackoverflow.com
        history.insertAtBeginning(3); // github.com
        
        System.out.println("Browser history (most recent first):");
        history.display();
        
        // Go back (remove most recent)
        System.out.println("Going back...");
        history.deleteFromBeginning();
        history.display();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Linked lists provide dynamic size and efficient insertion/deletion
 * 2. Each node contains data and a pointer to the next node
 * 3. No random access - must traverse from head to reach any element
 * 4. Memory is not contiguous, leading to poor cache locality
 * 5. Extra memory overhead for storing pointers
 * 
 * Types of Linked Lists:
 * - Singly Linked List: Each node points to next node
 * - Doubly Linked List: Each node has pointers to both next and previous
 * - Circular Linked List: Last node points back to first node
 * 
 * Common Applications:
 * - Implementing stacks and queues
 * - Undo functionality in applications
 * - Music playlists and browser history
 * - Memory management in operating systems
 * - Polynomial representation in mathematics
 * 
 * Best Practices:
 * - Always check for null pointers
 * - Handle edge cases (empty list, single element)
 * - Keep track of list size for efficiency
 * - Consider using doubly linked list for bidirectional traversal
 * - Use appropriate data structure based on access patterns
 */
