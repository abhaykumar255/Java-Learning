/**
 * CreationalPatterns.java - Creational Design Patterns in Java
 * 
 * Learning Objectives:
 * - Understand creational design patterns and their purposes
 * - Learn when and how to implement each pattern
 * - Practice Factory, Builder, and Singleton patterns
 * - Compare different approaches to object creation
 * - Apply patterns to solve real-world problems
 */

import java.util.*;

// ========== FACTORY PATTERN ==========

/**
 * Factory Pattern - Creates objects without specifying exact classes
 * Use when: You need to create objects based on some criteria
 */

// Product interface
interface Vehicle {
    void start();
    void stop();
    String getType();
}

// Concrete products
class Car implements Vehicle {
    @Override
    public void start() { System.out.println("Car engine started"); }
    
    @Override
    public void stop() { System.out.println("Car engine stopped"); }
    
    @Override
    public String getType() { return "Car"; }
}

class Motorcycle implements Vehicle {
    @Override
    public void start() { System.out.println("Motorcycle engine started"); }
    
    @Override
    public void stop() { System.out.println("Motorcycle engine stopped"); }
    
    @Override
    public String getType() { return "Motorcycle"; }
}

class Truck implements Vehicle {
    @Override
    public void start() { System.out.println("Truck engine started"); }
    
    @Override
    public void stop() { System.out.println("Truck engine stopped"); }
    
    @Override
    public String getType() { return "Truck"; }
}

// Factory class
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "motorcycle":
                return new Motorcycle();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

// ========== BUILDER PATTERN ==========

/**
 * Builder Pattern - Constructs complex objects step by step
 * Use when: Object has many optional parameters or complex construction
 */

class Computer {
    // Required parameters
    private final String cpu;
    private final String ram;
    
    // Optional parameters
    private final String storage;
    private final String gpu;
    private final boolean hasWifi;
    private final boolean hasBluetooth;
    
    // Private constructor - only builder can create instances
    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasWifi = builder.hasWifi;
        this.hasBluetooth = builder.hasBluetooth;
    }
    
    // Static nested Builder class
    public static class ComputerBuilder {
        // Required parameters
        private final String cpu;
        private final String ram;
        
        // Optional parameters with default values
        private String storage = "256GB SSD";
        private String gpu = "Integrated";
        private boolean hasWifi = true;
        private boolean hasBluetooth = false;
        
        // Constructor with required parameters
        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        
        // Methods for optional parameters (return this for chaining)
        public ComputerBuilder storage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public ComputerBuilder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        
        public ComputerBuilder wifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }
        
        public ComputerBuilder bluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }
        
        // Build method creates the final object
        public Computer build() {
            return new Computer(this);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Computer{cpu='%s', ram='%s', storage='%s', gpu='%s', wifi=%s, bluetooth=%s}",
                cpu, ram, storage, gpu, hasWifi, hasBluetooth);
    }
}

// ========== PROTOTYPE PATTERN ==========

/**
 * Prototype Pattern - Creates objects by cloning existing instances
 * Use when: Object creation is expensive or complex
 */

abstract class Shape implements Cloneable {
    protected String type;
    protected String color;
    
    public abstract void draw();
    
    public String getType() { return type; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}

class Circle extends Shape {
    private int radius;
    
    public Circle() {
        type = "Circle";
        color = "Red";
        radius = 5;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " " + type + " with radius " + radius);
    }
    
    public void setRadius(int radius) { this.radius = radius; }
}

class Rectangle extends Shape {
    private int width, height;
    
    public Rectangle() {
        type = "Rectangle";
        color = "Blue";
        width = 10;
        height = 5;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " " + type + " " + width + "x" + height);
    }
    
    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

// Shape cache for prototypes
class ShapeCache {
    private static Map<String, Shape> shapeMap = new HashMap<>();
    
    public static Shape getShape(String shapeType) {
        Shape cachedShape = shapeMap.get(shapeType);
        return cachedShape != null ? cachedShape.clone() : null;
    }
    
    public static void loadCache() {
        Circle circle = new Circle();
        shapeMap.put("circle", circle);
        
        Rectangle rectangle = new Rectangle();
        shapeMap.put("rectangle", rectangle);
    }
}

public class CreationalPatterns {
    
    public static void main(String[] args) {
        
        System.out.println("=== Creational Design Patterns ===\n");
        
        // ========== FACTORY PATTERN DEMO ==========
        
        System.out.println("=== Factory Pattern Demo ===");
        demonstrateFactoryPattern();
        
        // ========== BUILDER PATTERN DEMO ==========
        
        System.out.println("\n=== Builder Pattern Demo ===");
        demonstrateBuilderPattern();
        
        // ========== PROTOTYPE PATTERN DEMO ==========
        
        System.out.println("\n=== Prototype Pattern Demo ===");
        demonstratePrototypePattern();
        
        // ========== PATTERN COMPARISON ==========
        
        System.out.println("\n=== Pattern Comparison ===");
        comparePatterns();
    }
    
    /**
     * Demonstrate Factory Pattern
     */
    public static void demonstrateFactoryPattern() {
        System.out.println("Factory Pattern creates objects without specifying exact classes");
        System.out.println("Client doesn't need to know about concrete classes");
        System.out.println();
        
        // Create different vehicles using factory
        String[] vehicleTypes = {"car", "motorcycle", "truck"};
        
        for (String type : vehicleTypes) {
            try {
                Vehicle vehicle = VehicleFactory.createVehicle(type);
                System.out.println("Created: " + vehicle.getType());
                vehicle.start();
                vehicle.stop();
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        // Benefits of Factory Pattern
        System.out.println("Benefits:");
        System.out.println("- Encapsulates object creation logic");
        System.out.println("- Easy to add new vehicle types");
        System.out.println("- Client code doesn't depend on concrete classes");
        System.out.println("- Follows Open/Closed Principle");
    }
    
    /**
     * Demonstrate Builder Pattern
     */
    public static void demonstrateBuilderPattern() {
        System.out.println("Builder Pattern constructs complex objects step by step");
        System.out.println("Useful when object has many optional parameters");
        System.out.println();
        
        // Build different computer configurations
        System.out.println("Building different computer configurations:");
        
        // Basic computer
        Computer basicComputer = new Computer.ComputerBuilder("Intel i3", "8GB")
                .build();
        System.out.println("Basic: " + basicComputer);
        
        // Gaming computer
        Computer gamingComputer = new Computer.ComputerBuilder("Intel i7", "16GB")
                .storage("1TB SSD")
                .gpu("RTX 3080")
                .wifi(true)
                .bluetooth(true)
                .build();
        System.out.println("Gaming: " + gamingComputer);
        
        // Office computer
        Computer officeComputer = new Computer.ComputerBuilder("Intel i5", "8GB")
                .storage("512GB SSD")
                .wifi(true)
                .build();
        System.out.println("Office: " + officeComputer);
        
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("- Readable and maintainable code");
        System.out.println("- Flexible object construction");
        System.out.println("- Immutable objects");
        System.out.println("- Method chaining for fluent API");
    }
    
    /**
     * Demonstrate Prototype Pattern
     */
    public static void demonstratePrototypePattern() {
        System.out.println("Prototype Pattern creates objects by cloning existing instances");
        System.out.println("Useful when object creation is expensive");
        System.out.println();
        
        // Load prototypes into cache
        ShapeCache.loadCache();
        
        // Clone shapes from cache
        System.out.println("Cloning shapes from cache:");
        
        Shape clonedCircle1 = ShapeCache.getShape("circle");
        if (clonedCircle1 != null) {
            clonedCircle1.draw();
        }
        
        Shape clonedCircle2 = ShapeCache.getShape("circle");
        if (clonedCircle2 != null) {
            clonedCircle2.setColor("Green");
            clonedCircle2.draw();
        }
        
        Shape clonedRectangle = ShapeCache.getShape("rectangle");
        if (clonedRectangle != null) {
            clonedRectangle.setColor("Yellow");
            clonedRectangle.draw();
        }
        
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("- Avoids expensive object creation");
        System.out.println("- Reduces subclassing");
        System.out.println("- Dynamic object creation at runtime");
        System.out.println("- Performance improvement for complex objects");
    }
    
    /**
     * Compare different creational patterns
     */
    public static void comparePatterns() {
        System.out.println("When to use each creational pattern:");
        System.out.println();
        
        System.out.println("Factory Pattern:");
        System.out.println("- When you need to create objects based on some criteria");
        System.out.println("- When you want to hide object creation complexity");
        System.out.println("- When you need to support multiple product families");
        System.out.println();
        
        System.out.println("Builder Pattern:");
        System.out.println("- When object has many optional parameters");
        System.out.println("- When you want to create immutable objects");
        System.out.println("- When construction process is complex");
        System.out.println();
        
        System.out.println("Prototype Pattern:");
        System.out.println("- When object creation is expensive");
        System.out.println("- When you need to create similar objects");
        System.out.println("- When you want to avoid subclassing");
        System.out.println();
        
        System.out.println("Singleton Pattern:");
        System.out.println("- When you need exactly one instance of a class");
        System.out.println("- For logging, caching, thread pools, database connections");
        System.out.println("- When global access point is needed");
        
        System.out.println("\n=== Creational Patterns completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Factory Pattern:
 *    - Encapsulates object creation
 *    - Promotes loose coupling
 *    - Easy to extend with new types
 *    - Follows Open/Closed Principle
 * 
 * 2. Builder Pattern:
 *    - Handles complex object construction
 *    - Provides fluent API with method chaining
 *    - Creates immutable objects
 *    - Separates construction from representation
 * 
 * 3. Prototype Pattern:
 *    - Creates objects by cloning
 *    - Useful for expensive object creation
 *    - Reduces need for subclassing
 *    - Supports dynamic object creation
 * 
 * 4. Pattern Selection:
 *    - Factory: When creation logic is complex
 *    - Builder: When many optional parameters
 *    - Prototype: When cloning is cheaper than creation
 *    - Singleton: When only one instance needed
 * 
 * 5. Real-world Applications:
 *    - Factory: Database drivers, UI components
 *    - Builder: Configuration objects, SQL queries
 *    - Prototype: Game objects, document templates
 *    - Singleton: Loggers, caches, connection pools
 */
