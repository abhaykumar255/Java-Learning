/**
 * AdvancedThreading.java - Advanced Threading Concepts and Patterns
 * 
 * Learning Objectives:
 * - Master advanced threading concepts beyond basics
 * - Learn thread pools and executor framework
 * - Understand concurrent collections and atomic operations
 * - Practice producer-consumer and other threading patterns
 * - Explore modern concurrency utilities in Java
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class AdvancedThreading {
    
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("=== Advanced Threading Concepts ===\n");
        
        // ========== THREAD POOLS ==========
        
        System.out.println("=== Thread Pools and Executor Framework ===");
        demonstrateThreadPools();
        
        // ========== ATOMIC OPERATIONS ==========
        
        System.out.println("\n=== Atomic Operations ===");
        demonstrateAtomicOperations();
        
        // ========== CONCURRENT COLLECTIONS ==========
        
        System.out.println("\n=== Concurrent Collections ===");
        demonstrateConcurrentCollections();
        
        // ========== PRODUCER-CONSUMER PATTERN ==========
        
        System.out.println("\n=== Producer-Consumer Pattern ===");
        demonstrateProducerConsumer();
        
        // ========== COUNTDOWNLATCH AND CYCLICBARRIER ==========
        
        System.out.println("\n=== Synchronization Utilities ===");
        demonstrateSynchronizationUtilities();
    }
    
    /**
     * Demonstrate thread pools and executor framework
     */
    public static void demonstrateThreadPools() {
        System.out.println("Thread pools manage a pool of worker threads for better performance");
        System.out.println("Benefits: Reuse threads, control resource usage, better performance");
        System.out.println();
        
        // Fixed Thread Pool
        System.out.println("=== Fixed Thread Pool ===");
        ExecutorService fixedPool = Executors.newFixedThreadPool(3);
        
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            fixedPool.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        fixedPool.shutdown();
        try {
            fixedPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Cached Thread Pool
        System.out.println("\n=== Cached Thread Pool ===");
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            cachedPool.submit(() -> {
                System.out.println("Cached task " + taskId + " by " + Thread.currentThread().getName());
            });
        }
        
        cachedPool.shutdown();
        
        // Scheduled Thread Pool
        System.out.println("\n=== Scheduled Thread Pool ===");
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(2);
        
        // Schedule a task to run after 1 second
        scheduledPool.schedule(() -> {
            System.out.println("Delayed task executed after 1 second");
        }, 1, TimeUnit.SECONDS);
        
        // Schedule a task to run repeatedly every 2 seconds
        ScheduledFuture<?> repeatingTask = scheduledPool.scheduleAtFixedRate(() -> {
            System.out.println("Repeating task: " + new Date());
        }, 0, 2, TimeUnit.SECONDS);
        
        // Cancel the repeating task after 6 seconds
        scheduledPool.schedule(() -> {
            repeatingTask.cancel(false);
            System.out.println("Repeating task cancelled");
            scheduledPool.shutdown();
        }, 6, TimeUnit.SECONDS);
    }
    
    /**
     * Demonstrate atomic operations for thread-safe operations
     */
    public static void demonstrateAtomicOperations() throws InterruptedException {
        System.out.println("Atomic operations provide thread-safe operations without synchronization");
        System.out.println("Common atomic classes: AtomicInteger, AtomicLong, AtomicReference");
        System.out.println();
        
        // Problem with regular integer
        System.out.println("=== Problem with Regular Integer ===");
        Counter regularCounter = new Counter();
        
        Thread[] threads1 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads1[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    regularCounter.increment();
                }
            });
            threads1[i].start();
        }
        
        for (Thread thread : threads1) {
            thread.join();
        }
        
        System.out.println("Regular counter result: " + regularCounter.getValue() + " (should be 5000)");
        
        // Solution with atomic integer
        System.out.println("\n=== Solution with Atomic Integer ===");
        AtomicCounter atomicCounter = new AtomicCounter();
        
        Thread[] threads2 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads2[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicCounter.increment();
                }
            });
            threads2[i].start();
        }
        
        for (Thread thread : threads2) {
            thread.join();
        }
        
        System.out.println("Atomic counter result: " + atomicCounter.getValue() + " (should be 5000)");
        
        // Atomic operations examples
        System.out.println("\n=== Atomic Operations Examples ===");
        AtomicInteger atomicInt = new AtomicInteger(10);
        
        System.out.println("Initial value: " + atomicInt.get());
        System.out.println("Increment and get: " + atomicInt.incrementAndGet());
        System.out.println("Add 5 and get: " + atomicInt.addAndGet(5));
        System.out.println("Compare and set (16 to 20): " + atomicInt.compareAndSet(16, 20));
        System.out.println("Final value: " + atomicInt.get());
    }
    
    // Regular counter (not thread-safe)
    static class Counter {
        private int count = 0;
        
        public void increment() {
            count++; // Not atomic operation
        }
        
        public int getValue() {
            return count;
        }
    }
    
    // Atomic counter (thread-safe)
    static class AtomicCounter {
        private AtomicInteger count = new AtomicInteger(0);
        
        public void increment() {
            count.incrementAndGet(); // Atomic operation
        }
        
        public int getValue() {
            return count.get();
        }
    }
    
    /**
     * Demonstrate concurrent collections
     */
    public static void demonstrateConcurrentCollections() throws InterruptedException {
        System.out.println("Concurrent collections are thread-safe versions of regular collections");
        System.out.println("Examples: ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue");
        System.out.println();
        
        // ConcurrentHashMap
        System.out.println("=== ConcurrentHashMap ===");
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // Multiple threads adding to map
        Thread[] mapThreads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            mapThreads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    String key = "Thread" + threadId + "_Key" + j;
                    concurrentMap.put(key, threadId * 10 + j);
                }
            });
            mapThreads[i].start();
        }
        
        for (Thread thread : mapThreads) {
            thread.join();
        }
        
        System.out.println("ConcurrentHashMap size: " + concurrentMap.size());
        System.out.println("Sample entries: " + concurrentMap.entrySet().stream().limit(3).toList());
        
        // CopyOnWriteArrayList
        System.out.println("\n=== CopyOnWriteArrayList ===");
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                copyOnWriteList.add("Item " + i);
                System.out.println("Added: Item " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        Thread reader = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Reading list size: " + copyOnWriteList.size());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        
        writer.start();
        reader.start();
        writer.join();
        reader.join();
    }
    
    /**
     * Demonstrate producer-consumer pattern using BlockingQueue
     */
    public static void demonstrateProducerConsumer() throws InterruptedException {
        System.out.println("Producer-Consumer pattern using BlockingQueue");
        System.out.println("BlockingQueue handles synchronization automatically");
        System.out.println();
        
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String item = "Item " + i;
                    queue.put(item); // Blocks if queue is full
                    System.out.println("Produced: " + item + " (Queue size: " + queue.size() + ")");
                    Thread.sleep(100); // Simulate production time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String item = queue.take(); // Blocks if queue is empty
                    System.out.println("Consumed: " + item + " (Queue size: " + queue.size() + ")");
                    Thread.sleep(150); // Simulate consumption time
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
        
        System.out.println("Producer-Consumer demo completed");
    }
    
    /**
     * Demonstrate synchronization utilities
     */
    public static void demonstrateSynchronizationUtilities() throws InterruptedException {
        System.out.println("Java provides utilities for complex synchronization scenarios");
        System.out.println();
        
        // CountDownLatch
        System.out.println("=== CountDownLatch ===");
        System.out.println("Allows threads to wait for other threads to complete");
        
        CountDownLatch latch = new CountDownLatch(3);
        
        for (int i = 1; i <= 3; i++) {
            final int workerId = i;
            new Thread(() -> {
                try {
                    System.out.println("Worker " + workerId + " starting work");
                    Thread.sleep(1000 + workerId * 500); // Different work times
                    System.out.println("Worker " + workerId + " completed work");
                    latch.countDown(); // Signal completion
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        
        System.out.println("Main thread waiting for all workers to complete...");
        latch.await(); // Wait for all workers
        System.out.println("All workers completed! Main thread continuing...");
        
        // CyclicBarrier
        System.out.println("\n=== CyclicBarrier ===");
        System.out.println("Allows threads to wait for each other at a barrier point");
        
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads reached barrier! Proceeding together...");
        });
        
        for (int i = 1; i <= 3; i++) {
            final int runnerId = i;
            new Thread(() -> {
                try {
                    System.out.println("Runner " + runnerId + " preparing...");
                    Thread.sleep(runnerId * 500); // Different preparation times
                    System.out.println("Runner " + runnerId + " ready at starting line");
                    barrier.await(); // Wait for all runners
                    System.out.println("Runner " + runnerId + " started running!");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
        
        Thread.sleep(3000); // Give time for demo to complete
        System.out.println("\n=== Advanced Threading completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Thread Pools:
 *    - FixedThreadPool: Fixed number of threads
 *    - CachedThreadPool: Creates threads as needed
 *    - ScheduledThreadPool: For delayed/periodic tasks
 *    - Better resource management than creating threads manually
 * 
 * 2. Atomic Operations:
 *    - AtomicInteger, AtomicLong, AtomicReference
 *    - Thread-safe operations without synchronization
 *    - Compare-and-swap operations
 *    - Better performance than synchronized blocks
 * 
 * 3. Concurrent Collections:
 *    - ConcurrentHashMap: Thread-safe HashMap
 *    - CopyOnWriteArrayList: Thread-safe ArrayList for read-heavy scenarios
 *    - BlockingQueue: Thread-safe queue with blocking operations
 * 
 * 4. Synchronization Utilities:
 *    - CountDownLatch: Wait for multiple threads to complete
 *    - CyclicBarrier: Threads wait for each other at barrier
 *    - Semaphore: Control access to resources
 * 
 * 5. Best Practices:
 *    - Use thread pools instead of creating threads manually
 *    - Prefer atomic operations over synchronization when possible
 *    - Use concurrent collections for thread-safe data structures
 *    - Choose appropriate synchronization utility for your use case
 */
