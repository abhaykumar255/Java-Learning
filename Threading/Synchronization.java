/**
 * Synchronization.java - Thread Synchronization in Java
 * 
 * Learning Objectives:
 * - Understand thread synchronization and race conditions
 * - Learn synchronized methods and blocks
 * - Master wait(), notify(), and notifyAll() methods
 * - Practice producer-consumer pattern
 * - Understand deadlock and how to prevent it
 */

/**
 * Counter class demonstrating race condition and synchronization
 */
class Counter {
    private int count = 0;
    
    // Unsynchronized method - can cause race condition
    public void incrementUnsafe() {
        count++;
    }
    
    // Synchronized method - thread-safe
    public synchronized void increment() {
        count++;
    }
    
    // Synchronized block - more granular control
    public void incrementWithBlock() {
        synchronized(this) {
            count++;
        }
    }
    
    public synchronized int getCount() {
        return count;
    }
    
    public void reset() {
        count = 0;
    }
}

/**
 * Bank Account class demonstrating synchronized methods
 */
class BankAccount {
    private double balance;
    private final String accountNumber;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + 
                             " deposited $" + amount + ". New balance: $" + balance);
        }
    }
    
    // Synchronized withdraw method
    public synchronized boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + 
                             " withdrew $" + amount + ". New balance: $" + balance);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + 
                             " failed to withdraw $" + amount + ". Insufficient funds.");
            return false;
        }
    }
    
    public synchronized double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

/**
 * Producer-Consumer example using wait() and notify()
 */
class SharedBuffer {
    private int[] buffer;
    private int count = 0;
    private int in = 0;
    private int out = 0;
    
    public SharedBuffer(int size) {
        buffer = new int[size];
    }
    
    // Producer method
    public synchronized void produce(int item) throws InterruptedException {
        // Wait if buffer is full
        while (count == buffer.length) {
            System.out.println("Buffer full. Producer waiting...");
            wait();
        }
        
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        count++;
        
        System.out.println("Produced: " + item + " (Buffer count: " + count + ")");
        
        // Notify waiting consumers
        notifyAll();
    }
    
    // Consumer method
    public synchronized int consume() throws InterruptedException {
        // Wait if buffer is empty
        while (count == 0) {
            System.out.println("Buffer empty. Consumer waiting...");
            wait();
        }
        
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        count--;
        
        System.out.println("Consumed: " + item + " (Buffer count: " + count + ")");
        
        // Notify waiting producers
        notifyAll();
        
        return item;
    }
    
    public synchronized int getCount() {
        return count;
    }
}

/**
 * Deadlock demonstration classes
 */
class Resource {
    private final String name;
    
    public Resource(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

class DeadlockDemo {
    private static Resource resource1 = new Resource("Resource1");
    private static Resource resource2 = new Resource("Resource2");
    
    public static void createDeadlock() {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Holding " + resource1.getName());
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                System.out.println("Thread 1: Waiting for " + resource2.getName());
                synchronized (resource2) {
                    System.out.println("Thread 1: Acquired " + resource2.getName());
                }
            }
        }, "Thread-1");
        
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Holding " + resource2.getName());
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                
                System.out.println("Thread 2: Waiting for " + resource1.getName());
                synchronized (resource1) {
                    System.out.println("Thread 2: Acquired " + resource1.getName());
                }
            }
        }, "Thread-2");
        
        thread1.start();
        thread2.start();
        
        // Wait for threads to potentially deadlock
        try {
            thread1.join(2000); // Wait max 2 seconds
            thread2.join(2000);
            
            if (thread1.isAlive() || thread2.isAlive()) {
                System.out.println("Deadlock detected! Threads are still running.");
                thread1.interrupt();
                thread2.interrupt();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Deadlock prevention using ordered resource acquisition
    public static void preventDeadlock() {
        Thread thread1 = new Thread(() -> {
            // Always acquire resources in the same order
            synchronized (resource1) {
                System.out.println("Thread 1: Holding " + resource1.getName());
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                
                synchronized (resource2) {
                    System.out.println("Thread 1: Acquired " + resource2.getName());
                }
            }
        }, "Thread-1-Safe");
        
        Thread thread2 = new Thread(() -> {
            // Same order as thread1
            synchronized (resource1) {
                System.out.println("Thread 2: Holding " + resource1.getName());
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                
                synchronized (resource2) {
                    System.out.println("Thread 2: Acquired " + resource2.getName());
                }
            }
        }, "Thread-2-Safe");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
            System.out.println("Both threads completed successfully - no deadlock!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Synchronization {
    
    public static void main(String[] args) {
        
        System.out.println("=== Thread Synchronization in Java ===\n");
        
        // ========== RACE CONDITION DEMO ==========
        
        System.out.println("=== Race Condition Demonstration ===");
        raceConditionDemo();
        
        // ========== SYNCHRONIZED METHODS ==========
        
        System.out.println("\n=== Synchronized Methods ===");
        synchronizedMethodsDemo();
        
        // ========== PRODUCER-CONSUMER PATTERN ==========
        
        System.out.println("\n=== Producer-Consumer Pattern ===");
        producerConsumerDemo();
        
        // ========== DEADLOCK DEMONSTRATION ==========
        
        System.out.println("\n=== Deadlock Demonstration ===");
        deadlockDemo();
        
        System.out.println("\n=== Synchronization lesson completed! ===");
    }
    
    /**
     * Demonstrates race condition and its solution
     */
    public static void raceConditionDemo() {
        Counter counter = new Counter();
        int numThreads = 5;
        int incrementsPerThread = 1000;
        
        // Test without synchronization
        System.out.println("--- Without Synchronization (Race Condition) ---");
        counter.reset();
        
        Thread[] unsafeThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            unsafeThreads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.incrementUnsafe();
                }
            }, "UnsafeThread-" + i);
        }
        
        // Start all threads
        for (Thread thread : unsafeThreads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : unsafeThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Expected count: " + (numThreads * incrementsPerThread));
        System.out.println("Actual count (unsafe): " + counter.getCount());
        System.out.println("Data race occurred: " + (counter.getCount() != numThreads * incrementsPerThread));
        
        // Test with synchronization
        System.out.println("\n--- With Synchronization (Thread-Safe) ---");
        counter.reset();
        
        Thread[] safeThreads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            safeThreads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            }, "SafeThread-" + i);
        }
        
        // Start all threads
        for (Thread thread : safeThreads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : safeThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Expected count: " + (numThreads * incrementsPerThread));
        System.out.println("Actual count (safe): " + counter.getCount());
        System.out.println("Thread-safe result: " + (counter.getCount() == numThreads * incrementsPerThread));
    }
    
    /**
     * Demonstrates synchronized methods with bank account
     */
    public static void synchronizedMethodsDemo() {
        BankAccount account = new BankAccount("ACC001", 1000.0);
        
        System.out.println("Initial balance: $" + account.getBalance());
        
        // Create multiple threads for deposits and withdrawals
        Thread[] threads = new Thread[6];
        
        // Deposit threads
        for (int i = 0; i < 3; i++) {
            final int threadNum = i;
            threads[i] = new Thread(() -> {
                account.deposit(100.0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                account.deposit(50.0);
            }, "Depositor-" + threadNum);
        }
        
        // Withdrawal threads
        for (int i = 3; i < 6; i++) {
            final int threadNum = i;
            threads[i] = new Thread(() -> {
                account.withdraw(75.0);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                account.withdraw(25.0);
            }, "Withdrawer-" + threadNum);
        }
        
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("Final balance: $" + account.getBalance());
    }
    
    /**
     * Demonstrates producer-consumer pattern with wait/notify
     */
    public static void producerConsumerDemo() {
        SharedBuffer buffer = new SharedBuffer(5);
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.produce(i);
                    Thread.sleep(200); // Simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    buffer.consume();
                    Thread.sleep(300); // Simulate consumption time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");
        
        // Start both threads
        producer.start();
        consumer.start();
        
        // Wait for both threads to complete
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("Producer-Consumer demo completed");
        System.out.println("Final buffer count: " + buffer.getCount());
    }
    
    /**
     * Demonstrates deadlock and its prevention
     */
    public static void deadlockDemo() {
        
        System.out.println("--- Deadlock Creation ---");
        System.out.println("Creating deadlock scenario...");
        DeadlockDemo.createDeadlock();
        
        // Wait a bit before next demo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("\n--- Deadlock Prevention ---");
        System.out.println("Preventing deadlock with ordered resource acquisition...");
        DeadlockDemo.preventDeadlock();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Synchronization prevents race conditions in multithreaded programs
 * 2. synchronized keyword ensures only one thread accesses critical section
 * 3. wait(), notify(), and notifyAll() enable thread communication
 * 4. Producer-consumer pattern is common in concurrent programming
 * 5. Deadlock occurs when threads wait for each other indefinitely
 * 
 * Synchronization Mechanisms:
 * - synchronized methods: Entire method is synchronized
 * - synchronized blocks: Only specific code section is synchronized
 * - wait(): Thread releases lock and waits for notification
 * - notify(): Wakes up one waiting thread
 * - notifyAll(): Wakes up all waiting threads
 * 
 * Race Condition:
 * - Occurs when multiple threads access shared data simultaneously
 * - Results in unpredictable and incorrect behavior
 * - Solved by synchronizing access to shared resources
 * 
 * Deadlock Prevention:
 * - Ordered resource acquisition
 * - Timeout mechanisms
 * - Deadlock detection algorithms
 * - Avoiding nested locks when possible
 * 
 * Best Practices:
 * - Minimize synchronized code sections
 * - Use synchronized blocks instead of methods when possible
 * - Always use wait() in a loop with condition checking
 * - Prefer higher-level concurrency utilities (java.util.concurrent)
 * - Avoid nested synchronization when possible
 * - Use thread-safe collections when appropriate
 * 
 * Performance Considerations:
 * - Synchronization adds overhead
 * - Can reduce parallelism
 * - May cause thread contention
 * - Consider lock-free alternatives for high-performance scenarios
 */
