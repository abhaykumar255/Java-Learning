/**
 * ThreadBasics.java - Understanding Thread Fundamentals in Java
 * 
 * Learning Objectives:
 * - Understand what threads are and why they're useful
 * - Learn different ways to create threads in Java
 * - Master thread lifecycle and states
 * - Practice basic thread operations and methods
 * - Understand thread scheduling and priorities
 */

/**
 * Method 1: Creating thread by extending Thread class
 */
class MyThread extends Thread {
    private String threadName;
    
    public MyThread(String name) {
        this.threadName = name;
        System.out.println("Creating thread: " + threadName);
    }
    
    @Override
    public void run() {
        System.out.println("Thread " + threadName + " is starting execution");
        
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " - Count: " + i);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted");
        }
        
        System.out.println("Thread " + threadName + " is finishing execution");
    }
}

/**
 * Method 2: Creating thread by implementing Runnable interface
 */
class MyRunnable implements Runnable {
    private String taskName;
    
    public MyRunnable(String name) {
        this.taskName = name;
        System.out.println("Creating runnable task: " + taskName);
    }
    
    @Override
    public void run() {
        System.out.println("Task " + taskName + " is starting execution");
        
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(taskName + " - Step: " + i);
                Thread.sleep(800); // Sleep for 0.8 seconds
            }
        } catch (InterruptedException e) {
            System.out.println(taskName + " was interrupted");
        }
        
        System.out.println("Task " + taskName + " is finishing execution");
    }
}

/**
 * Demonstration of thread states and lifecycle
 */
class ThreadStateDemo implements Runnable {
    private String name;
    private Object lock = new Object();
    
    public ThreadStateDemo(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        System.out.println(name + " - State: RUNNING");
        
        try {
            // TIMED_WAITING state
            System.out.println(name + " - Going to TIMED_WAITING state");
            Thread.sleep(2000);
            
            // BLOCKED state demonstration
            synchronized (lock) {
                System.out.println(name + " - In synchronized block");
                Thread.sleep(1000);
            }
            
            // WAITING state demonstration
            synchronized (this) {
                System.out.println(name + " - Going to WAITING state");
                this.wait(1000);
            }
            
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted");
        }
        
        System.out.println(name + " - State: TERMINATED");
    }
}

public class ThreadBasics {
    
    public static void main(String[] args) {
        
        System.out.println("=== Thread Basics in Java ===\n");
        
        // ========== THREAD CREATION METHODS ==========
        
        System.out.println("=== Thread Creation Methods ===");
        threadCreationDemo();
        
        // ========== THREAD LIFECYCLE ==========
        
        System.out.println("\n=== Thread Lifecycle and States ===");
        threadLifecycleDemo();
        
        // ========== THREAD METHODS ==========
        
        System.out.println("\n=== Thread Methods ===");
        threadMethodsDemo();
        
        // ========== THREAD PRIORITIES ==========
        
        System.out.println("\n=== Thread Priorities ===");
        threadPriorityDemo();
        
        // ========== DAEMON THREADS ==========
        
        System.out.println("\n=== Daemon Threads ===");
        daemonThreadDemo();
        
        // ========== LAMBDA EXPRESSIONS WITH THREADS ==========
        
        System.out.println("\n=== Lambda Expressions with Threads ===");
        lambdaThreadDemo();
        
        System.out.println("\n=== Thread Basics lesson completed! ===");
    }
    
    /**
     * Demonstrates different ways to create threads
     */
    public static void threadCreationDemo() {
        
        // Method 1: Extending Thread class
        System.out.println("--- Method 1: Extending Thread Class ---");
        MyThread thread1 = new MyThread("ExtendedThread");
        thread1.start(); // Start the thread
        
        try {
            Thread.sleep(2000); // Let it run for a bit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Method 2: Implementing Runnable interface
        System.out.println("\n--- Method 2: Implementing Runnable Interface ---");
        MyRunnable runnable = new MyRunnable("RunnableTask");
        Thread thread2 = new Thread(runnable);
        thread2.start();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Method 3: Anonymous class
        System.out.println("\n--- Method 3: Anonymous Class ---");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous thread is running");
                for (int i = 1; i <= 3; i++) {
                    System.out.println("Anonymous - Count: " + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread3.start();
        
        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrates thread lifecycle and states
     */
    public static void threadLifecycleDemo() {
        
        System.out.println("Thread States: NEW -> RUNNABLE -> BLOCKED/WAITING/TIMED_WAITING -> TERMINATED");
        
        // Create thread (NEW state)
        Thread thread = new Thread(new ThreadStateDemo("StateDemo"));
        System.out.println("Thread state after creation: " + thread.getState()); // NEW
        
        // Start thread (RUNNABLE state)
        thread.start();
        System.out.println("Thread state after start(): " + thread.getState()); // RUNNABLE
        
        // Monitor thread states
        Thread monitor = new Thread(() -> {
            while (thread.isAlive()) {
                System.out.println("Current thread state: " + thread.getState());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("Final thread state: " + thread.getState()); // TERMINATED
        });
        
        monitor.start();
        
        try {
            thread.join(); // Wait for thread to complete
            monitor.join(); // Wait for monitor to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrates important thread methods
     */
    public static void threadMethodsDemo() {
        
        System.out.println("--- Thread Methods Demonstration ---");
        
        // Current thread information
        Thread currentThread = Thread.currentThread();
        System.out.println("Current thread name: " + currentThread.getName());
        System.out.println("Current thread ID: " + currentThread.getId());
        System.out.println("Current thread priority: " + currentThread.getPriority());
        System.out.println("Is daemon: " + currentThread.isDaemon());
        
        // Create and start a thread
        Thread worker = new Thread(() -> {
            Thread current = Thread.currentThread();
            System.out.println("\nWorker thread info:");
            System.out.println("Name: " + current.getName());
            System.out.println("ID: " + current.getId());
            System.out.println("Priority: " + current.getPriority());
            
            for (int i = 1; i <= 5; i++) {
                System.out.println("Worker - Iteration: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Worker thread was interrupted");
                    return; // Exit gracefully
                }
            }
        }, "WorkerThread");
        
        worker.start();
        
        // Demonstrate join() method
        System.out.println("\nMain thread waiting for worker to complete...");
        try {
            worker.join(); // Wait for worker to finish
            System.out.println("Worker thread has completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Demonstrate interrupt() method
        Thread interruptibleThread = new Thread(() -> {
            try {
                System.out.println("Interruptible thread sleeping...");
                Thread.sleep(5000); // Sleep for 5 seconds
                System.out.println("Interruptible thread woke up normally");
            } catch (InterruptedException e) {
                System.out.println("Interruptible thread was interrupted!");
            }
        }, "InterruptibleThread");
        
        interruptibleThread.start();
        
        try {
            Thread.sleep(2000); // Let it sleep for 2 seconds
            System.out.println("Interrupting the sleeping thread...");
            interruptibleThread.interrupt(); // Interrupt it
            interruptibleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Demonstrates thread priorities
     */
    public static void threadPriorityDemo() {
        
        System.out.println("--- Thread Priority Demonstration ---");
        System.out.println("Thread priorities range from " + Thread.MIN_PRIORITY + 
                          " to " + Thread.MAX_PRIORITY);
        System.out.println("Default priority is " + Thread.NORM_PRIORITY);
        
        // Create threads with different priorities
        Thread lowPriorityThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Low Priority Thread - Count: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "LowPriorityThread");
        
        Thread highPriorityThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("High Priority Thread - Count: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "HighPriorityThread");
        
        // Set priorities
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        
        System.out.println("Low priority: " + lowPriorityThread.getPriority());
        System.out.println("High priority: " + highPriorityThread.getPriority());
        
        // Start threads
        lowPriorityThread.start();
        highPriorityThread.start();
        
        try {
            lowPriorityThread.join();
            highPriorityThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Note: Thread priority is a hint to the scheduler, not a guarantee");
    }
    
    /**
     * Demonstrates daemon threads
     */
    public static void daemonThreadDemo() {
        
        System.out.println("--- Daemon Thread Demonstration ---");
        
        // Regular user thread
        Thread userThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("User Thread - Count: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("User thread completed");
        }, "UserThread");
        
        // Daemon thread
        Thread daemonThread = new Thread(() -> {
            int count = 1;
            while (true) { // Infinite loop
                System.out.println("Daemon Thread - Count: " + count++);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "DaemonThread");
        
        // Set as daemon thread (must be done before start())
        daemonThread.setDaemon(true);
        
        System.out.println("User thread is daemon: " + userThread.isDaemon());
        System.out.println("Daemon thread is daemon: " + daemonThread.isDaemon());
        
        // Start both threads
        userThread.start();
        daemonThread.start();
        
        try {
            userThread.join(); // Wait for user thread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Main thread ending - daemon thread will be terminated automatically");
        // Note: Daemon thread will be terminated when all user threads finish
    }
    
    /**
     * Demonstrates using lambda expressions with threads
     */
    public static void lambdaThreadDemo() {
        
        System.out.println("--- Lambda Expressions with Threads ---");
        
        // Simple lambda thread
        Thread lambdaThread1 = new Thread(() -> {
            System.out.println("Lambda thread 1 is running");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        });
        lambdaThread1.start();
        
        // Lambda thread with parameters
        Runnable task = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda task - Iteration: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
        
        Thread lambdaThread2 = new Thread(task, "LambdaThread2");
        lambdaThread2.start();
        
        // Multiple threads with same lambda
        for (int i = 1; i <= 3; i++) {
            final int threadNum = i;
            Thread thread = new Thread(() -> {
                System.out.println("Lambda thread " + threadNum + " executing");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Lambda thread " + threadNum + " completed");
            }, "LambdaThread" + i);
            
            thread.start();
        }
        
        try {
            lambdaThread1.join();
            lambdaThread2.join();
            Thread.sleep(2000); // Wait for other lambda threads
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Threads enable concurrent execution of multiple tasks
 * 2. Two main ways to create threads: extend Thread or implement Runnable
 * 3. Thread lifecycle: NEW -> RUNNABLE -> BLOCKED/WAITING/TIMED_WAITING -> TERMINATED
 * 4. Important methods: start(), run(), join(), sleep(), interrupt()
 * 5. Thread priorities are hints to scheduler, not guarantees
 * 6. Daemon threads terminate when all user threads finish
 * 
 * Thread Creation Methods:
 * - Extending Thread class: Simple but limits inheritance
 * - Implementing Runnable: Preferred, allows multiple inheritance
 * - Lambda expressions: Concise for simple tasks
 * - Anonymous classes: Good for one-time use
 * 
 * Thread States:
 * - NEW: Thread created but not started
 * - RUNNABLE: Thread executing or ready to execute
 * - BLOCKED: Thread blocked waiting for monitor lock
 * - WAITING: Thread waiting indefinitely
 * - TIMED_WAITING: Thread waiting for specified time
 * - TERMINATED: Thread completed execution
 * 
 * Best Practices:
 * - Prefer Runnable over extending Thread
 * - Use meaningful thread names for debugging
 * - Handle InterruptedException properly
 * - Don't rely on thread priorities for correctness
 * - Use daemon threads for background services
 * - Always call start(), never run() directly
 * 
 * Common Pitfalls:
 * - Calling run() instead of start()
 * - Not handling InterruptedException
 * - Setting daemon flag after starting thread
 * - Assuming thread execution order
 * - Not joining threads when needed
 */
