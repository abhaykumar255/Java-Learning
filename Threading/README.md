# Multithreading in Java 🧵

Multithreading is a Java feature that allows concurrent execution of multiple threads, enabling programs to perform multiple tasks simultaneously and improve performance.

## What is Multithreading?

Multithreading is the ability of a program to execute multiple threads concurrently. Each thread represents a separate path of execution within a program, allowing different parts of the program to run simultaneously.

## Key Concepts

### **Thread**
- Lightweight subprocess
- Smallest unit of processing
- Shares memory space with other threads in the same process
- Has its own stack and program counter

### **Process vs Thread**
- **Process**: Independent execution environment with separate memory space
- **Thread**: Lightweight process that shares memory with other threads

### **Concurrency vs Parallelism**
- **Concurrency**: Multiple threads making progress (may not be simultaneous)
- **Parallelism**: Multiple threads executing simultaneously on multiple cores

## Thread Lifecycle

```
NEW → RUNNABLE → BLOCKED/WAITING/TIMED_WAITING → TERMINATED
```

### **Thread States**
1. **NEW**: Thread created but not started
2. **RUNNABLE**: Thread executing or ready to execute
3. **BLOCKED**: Thread blocked waiting for monitor lock
4. **WAITING**: Thread waiting indefinitely for another thread
5. **TIMED_WAITING**: Thread waiting for specified time
6. **TERMINATED**: Thread completed execution

## Topics Covered

### 1. **ThreadBasics.java** - Thread fundamentals
- Creating threads (extending Thread class)
- Implementing Runnable interface
- Thread lifecycle and states
- Basic thread operations

### 2. **ThreadMethods.java** - Thread control methods
- start(), run(), sleep(), join()
- Thread priorities and daemon threads
- Thread interruption and stopping
- Thread naming and identification

### 3. **Synchronization.java** - Thread safety
- Synchronized methods and blocks
- Race conditions and critical sections
- Object-level and class-level locking
- Deadlock prevention

### 4. **ProducerConsumer.java** - Inter-thread communication
- wait(), notify(), notifyAll() methods
- Producer-Consumer problem solution
- Thread coordination patterns
- Blocking queues

### 5. **ThreadPool.java** - Executor framework
- ExecutorService and thread pools
- Different types of thread pools
- Callable and Future interfaces
- Thread pool best practices

### 6. **ConcurrentCollections.java** - Thread-safe collections
- ConcurrentHashMap, CopyOnWriteArrayList
- Atomic variables and operations
- Lock-free programming
- Performance considerations

## Creating Threads

### **Method 1: Extending Thread Class**
```java
class MyThread extends Thread {
    public void run() {
        // Thread execution code
    }
}
MyThread thread = new MyThread();
thread.start();
```

### **Method 2: Implementing Runnable Interface**
```java
class MyRunnable implements Runnable {
    public void run() {
        // Thread execution code
    }
}
Thread thread = new Thread(new MyRunnable());
thread.start();
```

### **Method 3: Lambda Expression (Java 8+)**
```java
Thread thread = new Thread(() -> {
    // Thread execution code
});
thread.start();
```

## Synchronization Mechanisms

### **Synchronized Methods**
```java
public synchronized void method() {
    // Thread-safe code
}
```

### **Synchronized Blocks**
```java
synchronized(object) {
    // Thread-safe code
}
```

### **Locks (java.util.concurrent.locks)**
```java
ReentrantLock lock = new ReentrantLock();
lock.lock();
try {
    // Critical section
} finally {
    lock.unlock();
}
```

## Common Threading Problems

### **Race Condition**
- Multiple threads accessing shared data simultaneously
- Results in unpredictable behavior
- **Solution**: Synchronization

### **Deadlock**
- Two or more threads waiting for each other indefinitely
- **Prevention**: Consistent lock ordering, timeout mechanisms

### **Starvation**
- Thread unable to gain access to shared resources
- **Solution**: Fair scheduling, priority management

### **Livelock**
- Threads continuously change state in response to other threads
- **Solution**: Randomized retry mechanisms

## Thread Safety Strategies

### **1. Immutability**
- Objects that cannot be modified after creation
- Naturally thread-safe
- Example: String, Integer wrapper classes

### **2. Thread Confinement**
- Restrict data access to single thread
- ThreadLocal variables
- Stack confinement

### **3. Synchronization**
- Coordinate access to shared resources
- Synchronized methods/blocks
- Explicit locks

### **4. Atomic Operations**
- Operations that complete in single step
- AtomicInteger, AtomicReference
- Compare-and-swap operations

## Best Practices

### **Thread Creation**
1. **Prefer Runnable over Thread**: More flexible, allows multiple inheritance
2. **Use thread pools**: Avoid creating threads manually
3. **Name your threads**: Easier debugging and monitoring
4. **Set appropriate priorities**: But don't rely on them for correctness

### **Synchronization**
1. **Minimize synchronized code**: Keep critical sections small
2. **Avoid nested locks**: Prevents deadlocks
3. **Use concurrent collections**: Better performance than synchronized collections
4. **Prefer immutable objects**: Eliminates need for synchronization

### **Performance**
1. **Use appropriate thread pool size**: CPU-bound vs I/O-bound tasks
2. **Avoid excessive context switching**: Too many threads can hurt performance
3. **Use lock-free algorithms**: When possible, for better performance
4. **Monitor thread usage**: Use profiling tools

## Common Use Cases

### **CPU-Intensive Tasks**
- Mathematical calculations
- Image/video processing
- Data analysis
- Cryptographic operations

### **I/O-Intensive Tasks**
- File operations
- Network communication
- Database operations
- Web service calls

### **Background Tasks**
- Periodic cleanup
- Monitoring and logging
- Cache refresh
- Scheduled maintenance

### **User Interface**
- Keep UI responsive
- Background data loading
- Progress indicators
- Event handling

## Thread Pool Types

| Type | Description | Use Case |
|------|-------------|----------|
| **FixedThreadPool** | Fixed number of threads | Known workload |
| **CachedThreadPool** | Creates threads as needed | Variable workload |
| **SingleThreadExecutor** | Single worker thread | Sequential execution |
| **ScheduledThreadPool** | Scheduled/periodic tasks | Timer-based tasks |

## Performance Considerations

### **Thread Overhead**
- Thread creation and destruction cost
- Memory overhead (stack space)
- Context switching overhead

### **Optimal Thread Count**
- **CPU-bound**: Number of cores
- **I/O-bound**: Higher than number of cores
- **Mixed workload**: Profile and test

### **Monitoring**
- Thread count and states
- CPU utilization
- Memory usage
- Deadlock detection

## Learning Progression

1. **Understand thread basics** - creation and lifecycle
2. **Master synchronization** - prevent race conditions
3. **Learn inter-thread communication** - coordination patterns
4. **Practice with thread pools** - efficient thread management
5. **Explore concurrent collections** - thread-safe data structures
6. **Study advanced topics** - locks, atomic operations, performance tuning

---
*Multithreading enables efficient utilization of system resources and improved application performance!*
