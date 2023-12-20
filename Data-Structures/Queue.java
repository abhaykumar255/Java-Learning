/**
 * Queue.java - Implementation of Queue Data Structure
 * 
 * Learning Objectives:
 * - Understand Queue data structure and FIFO principle
 * - Implement Queue using arrays and linked lists
 * - Learn queue operations: enqueue, dequeue, front, isEmpty
 * - Practice queue applications and real-world use cases
 * - Understand circular queue and priority queue concepts
 */

import java.util.EmptyStackException;

/**
 * Array-based Queue implementation
 */
class ArrayQueue<T> {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Add element to rear of queue
     * Time Complexity: O(1)
     */
    public void enqueue(T item) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow: Cannot enqueue to full queue");
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = item;
        size++;
        System.out.println("Enqueued: " + item);
    }
    
    /**
     * Remove element from front of queue
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) queue[front];
        queue[front] = null; // Help GC
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + item);
        return item;
    }
    
    /**
     * Peek at front element without removing
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T front() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) queue[front];
    }
    
    /**
     * Check if queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Check if queue is full
     */
    public boolean isFull() {
        return size == capacity;
    }
    
    /**
     * Get current size
     */
    public int size() {
        return size;
    }
    
    /**
     * Display queue contents
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }
}

/**
 * Node class for linked list implementation
 */
class QueueNode<T> {
    T data;
    QueueNode<T> next;
    
    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Linked List-based Queue implementation
 */
class LinkedQueue<T> {
    private QueueNode<T> front;
    private QueueNode<T> rear;
    private int size;
    
    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    /**
     * Add element to rear of queue
     * Time Complexity: O(1)
     */
    public void enqueue(T item) {
        QueueNode<T> newNode = new QueueNode<>(item);
        
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + item);
    }
    
    /**
     * Remove element from front of queue
     * Time Complexity: O(1)
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        T item = front.data;
        front = front.next;
        
        if (front == null) {
            rear = null;
        }
        
        size--;
        System.out.println("Dequeued: " + item);
        return item;
    }
    
    /**
     * Peek at front element
     * Time Complexity: O(1)
     */
    public T front() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return front.data;
    }
    
    /**
     * Check if queue is empty
     */
    public boolean isEmpty() {
        return front == null;
    }
    
    /**
     * Get current size
     */
    public int size() {
        return size;
    }
    
    /**
     * Display queue contents
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        QueueNode<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Priority Queue implementation using array
 */
class PriorityQueue<T extends Comparable<T>> {
    private Object[] queue;
    private int size;
    private int capacity;
    
    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.size = 0;
    }
    
    /**
     * Add element maintaining priority order
     * Time Complexity: O(n)
     */
    public void enqueue(T item) {
        if (size >= capacity) {
            throw new RuntimeException("Priority Queue is full");
        }
        
        // Find correct position to insert
        int i = size - 1;
        while (i >= 0 && ((T) queue[i]).compareTo(item) > 0) {
            queue[i + 1] = queue[i];
            i--;
        }
        
        queue[i + 1] = item;
        size++;
        System.out.println("Enqueued with priority: " + item);
    }
    
    /**
     * Remove highest priority element
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        
        T item = (T) queue[0];
        
        // Shift elements left
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        
        size--;
        System.out.println("Dequeued highest priority: " + item);
        return item;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty");
            return;
        }
        
        System.out.print("Priority Queue (highest to lowest): ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class Queue {
    
    public static void main(String[] args) {
        
        System.out.println("=== Queue Data Structure Implementation ===\n");
        
        // ========== ARRAY-BASED QUEUE ==========
        
        System.out.println("=== Array-based Queue ===");
        arrayQueueDemo();
        
        // ========== LINKED LIST-BASED QUEUE ==========
        
        System.out.println("\n=== Linked List-based Queue ===");
        linkedQueueDemo();
        
        // ========== PRIORITY QUEUE ==========
        
        System.out.println("\n=== Priority Queue ===");
        priorityQueueDemo();
        
        // ========== QUEUE APPLICATIONS ==========
        
        System.out.println("\n=== Queue Applications ===");
        queueApplications();
        
        System.out.println("\n=== Queue lesson completed! ===");
    }
    
    /**
     * Demonstrates array-based queue operations
     */
    public static void arrayQueueDemo() {
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        
        System.out.println("Creating array queue with capacity 5");
        System.out.println("Is empty: " + queue.isEmpty());
        
        // Enqueue operations
        System.out.println("\nEnqueuing elements:");
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.display();
        
        // Front operation
        System.out.println("\nFront element: " + queue.front());
        System.out.println("Size: " + queue.size());
        
        // Dequeue operations
        System.out.println("\nDequeuing elements:");
        queue.dequeue();
        queue.dequeue();
        queue.display();
        
        // Fill queue to capacity
        System.out.println("\nFilling queue to capacity:");
        queue.enqueue("Fourth");
        queue.enqueue("Fifth");
        queue.enqueue("Sixth");
        queue.enqueue("Seventh");
        queue.display();
        System.out.println("Is full: " + queue.isFull());
        
        // Try to overflow
        try {
            queue.enqueue("Eighth");
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Empty the queue
        System.out.println("\nEmptying the queue:");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        
        // Try to underflow
        try {
            queue.dequeue();
        } catch (EmptyStackException e) {
            System.out.println("Exception caught: EmptyStackException");
        }
    }
    
    /**
     * Demonstrates linked list-based queue operations
     */
    public static void linkedQueueDemo() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        
        System.out.println("Creating linked list queue");
        System.out.println("Is empty: " + queue.isEmpty());
        
        // Enqueue operations
        System.out.println("\nEnqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        
        // Front and size
        System.out.println("\nFront element: " + queue.front());
        System.out.println("Size: " + queue.size());
        
        // Dequeue operations
        System.out.println("\nDequeuing elements:");
        queue.dequeue();
        queue.display();
        
        // Add more elements
        System.out.println("\nAdding more elements:");
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();
        
        // Clear queue
        System.out.println("\nClearing queue:");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        System.out.println("Final size: " + queue.size());
    }
    
    /**
     * Demonstrates priority queue operations
     */
    public static void priorityQueueDemo() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        
        System.out.println("Creating priority queue");
        
        // Add elements in random order
        System.out.println("\nAdding elements:");
        pq.enqueue(30);
        pq.enqueue(10);
        pq.enqueue(50);
        pq.enqueue(20);
        pq.enqueue(40);
        pq.display();
        
        // Remove elements (should come out in priority order)
        System.out.println("\nRemoving elements:");
        while (!pq.isEmpty()) {
            pq.dequeue();
        }
        
        // String priority queue
        System.out.println("\n--- String Priority Queue ---");
        PriorityQueue<String> stringPQ = new PriorityQueue<>(5);
        stringPQ.enqueue("Zebra");
        stringPQ.enqueue("Apple");
        stringPQ.enqueue("Mango");
        stringPQ.enqueue("Banana");
        stringPQ.display();
        
        while (!stringPQ.isEmpty()) {
            stringPQ.dequeue();
        }
    }
    
    /**
     * Demonstrates practical queue applications
     */
    public static void queueApplications() {
        
        // Application 1: BFS traversal simulation
        System.out.println("=== Application 1: BFS Traversal Simulation ===");
        bfsSimulation();
        
        // Application 2: Task scheduling
        System.out.println("\n=== Application 2: Task Scheduling ===");
        taskScheduling();
        
        // Application 3: Buffer for data processing
        System.out.println("\n=== Application 3: Data Buffer ===");
        dataBuffer();
        
        // Application 4: Print queue simulation
        System.out.println("\n=== Application 4: Print Queue ===");
        printQueueSimulation();
    }
    
    /**
     * Simulates BFS traversal using queue
     */
    public static void bfsSimulation() {
        LinkedQueue<String> bfsQueue = new LinkedQueue<>();
        
        System.out.println("Simulating BFS traversal:");
        
        // Start with root node
        bfsQueue.enqueue("Root");
        
        while (!bfsQueue.isEmpty()) {
            String current = bfsQueue.dequeue();
            System.out.println("Visiting: " + current);
            
            // Add children to queue (simulation)
            if (current.equals("Root")) {
                bfsQueue.enqueue("Left Child");
                bfsQueue.enqueue("Right Child");
            } else if (current.equals("Left Child")) {
                bfsQueue.enqueue("Left-Left");
                bfsQueue.enqueue("Left-Right");
            } else if (current.equals("Right Child")) {
                bfsQueue.enqueue("Right-Left");
                bfsQueue.enqueue("Right-Right");
            }
            
            // Stop after processing a few levels
            if (bfsQueue.size() > 4) break;
        }
    }
    
    /**
     * Simulates task scheduling
     */
    public static void taskScheduling() {
        LinkedQueue<String> taskQueue = new LinkedQueue<>();
        
        // Add tasks to queue
        String[] tasks = {"Email Processing", "Data Backup", "Report Generation", 
                         "System Update", "Log Cleanup"};
        
        System.out.println("Adding tasks to scheduler:");
        for (String task : tasks) {
            taskQueue.enqueue(task);
        }
        
        System.out.println("\nProcessing tasks in FIFO order:");
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.dequeue();
            System.out.println("Processing: " + task);
            
            // Simulate processing time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("All tasks completed!");
    }
    
    /**
     * Simulates data buffer
     */
    public static void dataBuffer() {
        ArrayQueue<Integer> buffer = new ArrayQueue<>(3);
        
        System.out.println("Data buffer with capacity 3:");
        
        // Producer adds data
        System.out.println("\nProducer adding data:");
        for (int i = 1; i <= 5; i++) {
            try {
                buffer.enqueue(i * 10);
                buffer.display();
            } catch (RuntimeException e) {
                System.out.println("Buffer full, processing data...");
                
                // Consumer processes data
                while (!buffer.isEmpty()) {
                    int data = buffer.dequeue();
                    System.out.println("Processed: " + data);
                }
                
                // Add current data
                buffer.enqueue(i * 10);
                buffer.display();
            }
        }
        
        // Process remaining data
        System.out.println("\nProcessing remaining data:");
        while (!buffer.isEmpty()) {
            int data = buffer.dequeue();
            System.out.println("Processed: " + data);
        }
    }
    
    /**
     * Simulates print queue
     */
    public static void printQueueSimulation() {
        LinkedQueue<String> printQueue = new LinkedQueue<>();
        
        // Add print jobs
        String[] documents = {"Document1.pdf", "Photo.jpg", "Report.docx", 
                             "Presentation.pptx", "Spreadsheet.xlsx"};
        
        System.out.println("Adding documents to print queue:");
        for (String doc : documents) {
            printQueue.enqueue(doc);
        }
        printQueue.display();
        
        System.out.println("\nPrinting documents:");
        while (!printQueue.isEmpty()) {
            String doc = printQueue.dequeue();
            System.out.println("Printing: " + doc + "...");
            
            // Simulate printing time
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(doc + " printed successfully!");
        }
        System.out.println("Print queue empty - all documents printed!");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Queue follows FIFO (First In, First Out) principle
 * 2. Main operations: enqueue (add), dequeue (remove), front (peek)
 * 3. Can be implemented using arrays (circular) or linked lists
 * 4. Array implementation has fixed size, linked list is dynamic
 * 5. All basic operations have O(1) time complexity
 * 
 * Queue Applications:
 * - BFS (Breadth-First Search) in graphs and trees
 * - Task scheduling in operating systems
 * - Buffer for data streams
 * - Print queue management
 * - Level-order tree traversal
 * - Handling requests in web servers
 * 
 * Implementation Comparison:
 * Array-based (Circular):
 * + Fixed memory usage
 * + Better cache locality
 * - Fixed size limitation
 * - Memory waste if not full
 * 
 * Linked List-based:
 * + Dynamic size
 * + No memory waste
 * - Extra memory for pointers
 * - Poor cache locality
 * 
 * Queue Variations:
 * - Simple Queue: Basic FIFO queue
 * - Circular Queue: Array-based with circular indexing
 * - Priority Queue: Elements have priorities
 * - Double-ended Queue (Deque): Insert/remove from both ends
 * 
 * Best Practices:
 * - Choose implementation based on requirements
 * - Handle queue overflow and underflow
 * - Use appropriate queue type for the problem
 * - Consider thread safety for concurrent access
 */
