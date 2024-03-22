/**
 * SingletonPattern.java - Singleton Design Pattern Implementation
 * 
 * Learning Objectives:
 * - Understand Singleton pattern and its use cases
 * - Learn different ways to implement Singleton pattern
 * - Practice thread-safe Singleton implementations
 * - Understand pros and cons of Singleton pattern
 * - Learn best practices and common pitfalls
 */

/**
 * Basic Singleton implementation (not thread-safe)
 */
class BasicSingleton {
    private static BasicSingleton instance;
    private String data;
    
    // Private constructor prevents instantiation
    private BasicSingleton() {
        this.data = "Basic Singleton Instance";
        System.out.println("BasicSingleton instance created");
    }
    
    // Public method to get instance
    public static BasicSingleton getInstance() {
        if (instance == null) {
            instance = new BasicSingleton();
        }
        return instance;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
}

/**
 * Thread-safe Singleton using synchronized method
 */
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private String data;
    
    private ThreadSafeSingleton() {
        this.data = "Thread-Safe Singleton Instance";
        System.out.println("ThreadSafeSingleton instance created");
    }
    
    // Synchronized method - thread-safe but slower
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    
    public String getData() {
        return data;
    }
}

/**
 * Eager initialization Singleton
 */
class EagerSingleton {
    // Instance created at class loading time
    private static final EagerSingleton instance = new EagerSingleton();
    private String data;
    
    private EagerSingleton() {
        this.data = "Eager Singleton Instance";
        System.out.println("EagerSingleton instance created");
    }
    
    public static EagerSingleton getInstance() {
        return instance;
    }
    
    public String getData() {
        return data;
    }
}

/**
 * Double-checked locking Singleton (recommended for multithreading)
 */
class DoubleCheckedSingleton {
    // volatile ensures visibility across threads
    private static volatile DoubleCheckedSingleton instance;
    private String data;
    
    private DoubleCheckedSingleton() {
        this.data = "Double-Checked Singleton Instance";
        System.out.println("DoubleCheckedSingleton instance created");
    }
    
    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
    
    public String getData() {
        return data;
    }
}

/**
 * Bill Pugh Singleton using inner static class (recommended)
 */
class BillPughSingleton {
    private String data;
    
    private BillPughSingleton() {
        this.data = "Bill Pugh Singleton Instance";
        System.out.println("BillPughSingleton instance created");
    }
    
    // Inner static class - loaded only when getInstance() is called
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public String getData() {
        return data;
    }
}

/**
 * Enum Singleton (best approach for most cases)
 */
enum EnumSingleton {
    INSTANCE;
    
    private String data;
    
    // Constructor is called only once
    EnumSingleton() {
        this.data = "Enum Singleton Instance";
        System.out.println("EnumSingleton instance created");
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void doSomething() {
        System.out.println("Enum Singleton doing something with: " + data);
    }
}

/**
 * Real-world example: Database Connection Manager
 */
class DatabaseConnectionManager {
    private static volatile DatabaseConnectionManager instance;
    private String connectionString;
    private boolean isConnected;
    
    private DatabaseConnectionManager() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        this.isConnected = false;
        System.out.println("DatabaseConnectionManager instance created");
    }
    
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }
    
    public void connect() {
        if (!isConnected) {
            System.out.println("Connecting to database: " + connectionString);
            isConnected = true;
        } else {
            System.out.println("Already connected to database");
        }
    }
    
    public void disconnect() {
        if (isConnected) {
            System.out.println("Disconnecting from database");
            isConnected = false;
        } else {
            System.out.println("Not connected to database");
        }
    }
    
    public boolean isConnected() {
        return isConnected;
    }
    
    public String getConnectionString() {
        return connectionString;
    }
}

/**
 * Real-world example: Logger
 */
class Logger {
    private static volatile Logger instance;
    private StringBuilder logBuffer;
    
    private Logger() {
        this.logBuffer = new StringBuilder();
        System.out.println("Logger instance created");
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    public void log(String level, String message) {
        String timestamp = java.time.LocalDateTime.now().toString();
        String logEntry = String.format("[%s] %s: %s%n", timestamp, level, message);
        
        synchronized (this) {
            logBuffer.append(logEntry);
            System.out.print(logEntry);
        }
    }
    
    public void info(String message) {
        log("INFO", message);
    }
    
    public void error(String message) {
        log("ERROR", message);
    }
    
    public void debug(String message) {
        log("DEBUG", message);
    }
    
    public String getLogs() {
        synchronized (this) {
            return logBuffer.toString();
        }
    }
    
    public void clearLogs() {
        synchronized (this) {
            logBuffer.setLength(0);
            System.out.println("Logs cleared");
        }
    }
}

public class SingletonPattern {
    
    public static void main(String[] args) {
        
        System.out.println("=== Singleton Design Pattern ===\n");
        
        // ========== BASIC SINGLETON ==========
        
        System.out.println("=== Basic Singleton (Not Thread-Safe) ===");
        basicSingletonDemo();
        
        // ========== THREAD-SAFE IMPLEMENTATIONS ==========
        
        System.out.println("\n=== Thread-Safe Singleton Implementations ===");
        threadSafeSingletonDemo();
        
        // ========== MULTITHREADING TEST ==========
        
        System.out.println("\n=== Multithreading Test ===");
        multithreadingTest();
        
        // ========== REAL-WORLD EXAMPLES ==========
        
        System.out.println("\n=== Real-World Examples ===");
        realWorldExamples();
        
        // ========== SINGLETON COMPARISON ==========
        
        System.out.println("\n=== Singleton Implementation Comparison ===");
        singletonComparison();
        
        System.out.println("\n=== Singleton Pattern lesson completed! ===");
    }
    
    /**
     * Demonstrates basic singleton usage
     */
    public static void basicSingletonDemo() {
        
        System.out.println("Creating first instance:");
        BasicSingleton singleton1 = BasicSingleton.getInstance();
        System.out.println("Data: " + singleton1.getData());
        
        System.out.println("\nCreating second instance:");
        BasicSingleton singleton2 = BasicSingleton.getInstance();
        System.out.println("Data: " + singleton2.getData());
        
        System.out.println("\nAre both instances same? " + (singleton1 == singleton2));
        System.out.println("Hash codes - singleton1: " + singleton1.hashCode() + 
                          ", singleton2: " + singleton2.hashCode());
        
        // Modify data through one instance
        singleton1.setData("Modified data");
        System.out.println("After modification:");
        System.out.println("singleton1 data: " + singleton1.getData());
        System.out.println("singleton2 data: " + singleton2.getData());
    }
    
    /**
     * Demonstrates different thread-safe singleton implementations
     */
    public static void threadSafeSingletonDemo() {
        
        // Thread-safe synchronized method
        System.out.println("--- Thread-Safe Synchronized ---");
        ThreadSafeSingleton ts1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton ts2 = ThreadSafeSingleton.getInstance();
        System.out.println("Same instance: " + (ts1 == ts2));
        
        // Eager initialization
        System.out.println("\n--- Eager Initialization ---");
        EagerSingleton es1 = EagerSingleton.getInstance();
        EagerSingleton es2 = EagerSingleton.getInstance();
        System.out.println("Same instance: " + (es1 == es2));
        
        // Double-checked locking
        System.out.println("\n--- Double-Checked Locking ---");
        DoubleCheckedSingleton dcs1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dcs2 = DoubleCheckedSingleton.getInstance();
        System.out.println("Same instance: " + (dcs1 == dcs2));
        
        // Bill Pugh Singleton
        System.out.println("\n--- Bill Pugh Singleton ---");
        BillPughSingleton bps1 = BillPughSingleton.getInstance();
        BillPughSingleton bps2 = BillPughSingleton.getInstance();
        System.out.println("Same instance: " + (bps1 == bps2));
        
        // Enum Singleton
        System.out.println("\n--- Enum Singleton ---");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("Same instance: " + (enum1 == enum2));
        enum1.doSomething();
    }
    
    /**
     * Tests singleton behavior in multithreaded environment
     */
    public static void multithreadingTest() {
        
        System.out.println("Testing Double-Checked Locking in multithreaded environment:");
        
        // Create multiple threads trying to get singleton instance
        Thread[] threads = new Thread[5];
        
        for (int i = 0; i < threads.length; i++) {
            final int threadNum = i;
            threads[i] = new Thread(() -> {
                DoubleCheckedSingleton instance = DoubleCheckedSingleton.getInstance();
                System.out.println("Thread " + threadNum + " got instance: " + 
                                 instance.hashCode());
            }, "Thread-" + i);
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
        
        System.out.println("All threads completed. Check if all got same instance.");
    }
    
    /**
     * Demonstrates real-world singleton examples
     */
    public static void realWorldExamples() {
        
        // Database Connection Manager example
        System.out.println("=== Database Connection Manager ===");
        DatabaseConnectionManager dbManager1 = DatabaseConnectionManager.getInstance();
        DatabaseConnectionManager dbManager2 = DatabaseConnectionManager.getInstance();
        
        System.out.println("Same instance: " + (dbManager1 == dbManager2));
        
        dbManager1.connect();
        System.out.println("Connection status: " + dbManager2.isConnected());
        
        dbManager2.disconnect();
        System.out.println("Connection status: " + dbManager1.isConnected());
        
        // Logger example
        System.out.println("\n=== Logger Example ===");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Same logger instance: " + (logger1 == logger2));
        
        logger1.info("Application started");
        logger2.debug("Debug message from logger2");
        logger1.error("An error occurred");
        
        System.out.println("\nAll logs:");
        System.out.println(logger2.getLogs());
        
        logger1.clearLogs();
    }
    
    /**
     * Compares different singleton implementations
     */
    public static void singletonComparison() {
        
        System.out.println("Singleton Implementation Comparison:");
        System.out.println();
        
        System.out.println("┌─────────────────────┬─────────────┬─────────────┬─────────────┬─────────────┐");
        System.out.println("│ Implementation      │ Thread Safe │ Lazy Init   │ Performance │ Complexity  │");
        System.out.println("├─────────────────────┼─────────────┼─────────────┼─────────────┼─────────────┤");
        System.out.println("│ Basic               │ No          │ Yes         │ Fast        │ Simple      │");
        System.out.println("│ Synchronized Method │ Yes         │ Yes         │ Slow        │ Simple      │");
        System.out.println("│ Eager Initialization│ Yes         │ No          │ Fast        │ Simple      │");
        System.out.println("│ Double-Checked Lock │ Yes         │ Yes         │ Fast        │ Complex     │");
        System.out.println("│ Bill Pugh          │ Yes         │ Yes         │ Fast        │ Medium      │");
        System.out.println("│ Enum               │ Yes         │ No          │ Fast        │ Simple      │");
        System.out.println("└─────────────────────┴─────────────┴─────────────┴─────────────┴─────────────┘");
        
        System.out.println("\nRecommendations:");
        System.out.println("• Use Enum Singleton for most cases (simple and safe)");
        System.out.println("• Use Bill Pugh for lazy initialization requirements");
        System.out.println("• Use Double-Checked Locking for complex scenarios");
        System.out.println("• Avoid Basic Singleton in multithreaded applications");
        System.out.println("• Consider Eager Initialization for small objects");
        
        System.out.println("\nSingleton Pattern Pros:");
        System.out.println("• Ensures only one instance exists");
        System.out.println("• Global access point");
        System.out.println("• Lazy initialization possible");
        System.out.println("• Memory efficient");
        
        System.out.println("\nSingleton Pattern Cons:");
        System.out.println("• Violates Single Responsibility Principle");
        System.out.println("• Difficult to unit test");
        System.out.println("• Can create tight coupling");
        System.out.println("• Global state can cause issues");
        System.out.println("• Reflection can break singleton");
        
        System.out.println("\nWhen to Use Singleton:");
        System.out.println("• Database connection pools");
        System.out.println("• Logging services");
        System.out.println("• Configuration managers");
        System.out.println("• Cache managers");
        System.out.println("• Thread pools");
        
        System.out.println("\nAlternatives to Consider:");
        System.out.println("• Dependency Injection");
        System.out.println("• Factory Pattern");
        System.out.println("• Static classes");
        System.out.println("• Service Locator Pattern");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Singleton ensures only one instance of a class exists
 * 2. Multiple implementation approaches with different trade-offs
 * 3. Thread safety is crucial in multithreaded applications
 * 4. Enum singleton is often the best choice for simplicity and safety
 * 5. Consider alternatives like dependency injection for better testability
 * 
 * Implementation Types:
 * - Basic: Simple but not thread-safe
 * - Synchronized Method: Thread-safe but slower
 * - Eager Initialization: Thread-safe, no lazy loading
 * - Double-Checked Locking: Thread-safe with lazy loading
 * - Bill Pugh: Uses inner static class for lazy loading
 * - Enum: Simplest and safest approach
 * 
 * Thread Safety Considerations:
 * - Race conditions in basic implementation
 * - Synchronized methods add overhead
 * - Double-checked locking requires volatile keyword
 * - Enum provides built-in thread safety
 * 
 * Best Practices:
 * - Use enum singleton when possible
 * - Make constructor private
 * - Consider lazy vs eager initialization
 * - Handle serialization properly
 * - Be aware of reflection attacks
 * - Consider dependency injection as alternative
 * 
 * Common Use Cases:
 * - Database connection managers
 * - Logging services
 * - Configuration managers
 * - Cache implementations
 * - Hardware interface access
 */
