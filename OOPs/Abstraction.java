/**
 * Abstraction.java - Understanding Abstraction in Java OOP
 * 
 * Learning Objectives:
 * - Understand abstraction concept and its importance
 * - Learn abstract classes and abstract methods
 * - Master interfaces and their implementation
 * - Practice multiple inheritance through interfaces
 * - Compare abstract classes vs interfaces
 */

// ========== ABSTRACT CLASS EXAMPLE ==========

/**
 * Abstract Vehicle class - cannot be instantiated
 * Contains both abstract and concrete methods
 */
abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    
    // Constructor in abstract class
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        System.out.println("Vehicle constructor called");
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void start();
    public abstract void stop();
    public abstract double calculateFuelEfficiency();
    
    // Concrete method - can be used by subclasses
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model + " (" + year + ")");
    }
    
    // Concrete method with implementation
    public void honk() {
        System.out.println("Vehicle is honking: Beep beep!");
    }
    
    // Final method - cannot be overridden
    public final String getVehicleId() {
        return brand + "-" + model + "-" + year;
    }
}

// ========== CONCRETE CLASSES EXTENDING ABSTRACT CLASS ==========

/**
 * Car class extends abstract Vehicle
 */
class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    
    public Car(String brand, String model, int year, int numberOfDoors, String fuelType) {
        super(brand, model, year);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }
    
    @Override
    public void start() {
        System.out.println("Car " + brand + " " + model + " started with ignition key");
    }
    
    @Override
    public void stop() {
        System.out.println("Car " + brand + " " + model + " stopped");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Simple calculation based on fuel type
        switch (fuelType.toLowerCase()) {
            case "petrol": return 15.0;
            case "diesel": return 20.0;
            case "electric": return 100.0; // km per charge equivalent
            default: return 10.0;
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car, Doors: " + numberOfDoors + ", Fuel: " + fuelType);
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + " km/l");
    }
    
    // Car-specific method
    public void openTrunk() {
        System.out.println("Car trunk opened");
    }
}

/**
 * Motorcycle class extends abstract Vehicle
 */
class Motorcycle extends Vehicle {
    private int engineCapacity;
    private boolean hasSidecar;
    
    public Motorcycle(String brand, String model, int year, int engineCapacity, boolean hasSidecar) {
        super(brand, model, year);
        this.engineCapacity = engineCapacity;
        this.hasSidecar = hasSidecar;
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle " + brand + " " + model + " started with kick/electric start");
    }
    
    @Override
    public void stop() {
        System.out.println("Motorcycle " + brand + " " + model + " stopped");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Motorcycles generally have better fuel efficiency
        return 40.0 + (1000.0 / engineCapacity); // Smaller engines are more efficient
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle, Engine: " + engineCapacity + "cc, Sidecar: " + hasSidecar);
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + " km/l");
    }
    
    // Motorcycle-specific method
    public void wheelie() {
        System.out.println("Motorcycle doing a wheelie!");
    }
}

// ========== INTERFACES ==========

/**
 * Flyable interface - defines flying behavior
 */
interface Flyable {
    // All methods in interface are public and abstract by default
    void takeOff();
    void land();
    double getMaxAltitude();
    
    // Default method (Java 8+)
    default void fly() {
        System.out.println("Flying at altitude: " + getMaxAltitude() + " meters");
    }
    
    // Static method (Java 8+)
    static void displayFlyingRules() {
        System.out.println("Flying Rules: Follow air traffic control instructions");
    }
}

/**
 * Swimmable interface - defines swimming behavior
 */
interface Swimmable {
    void dive();
    void surface();
    double getMaxDepth();
    
    default void swim() {
        System.out.println("Swimming at depth: " + getMaxDepth() + " meters");
    }
}

/**
 * Electric interface - defines electric vehicle behavior
 */
interface Electric {
    void charge();
    double getBatteryLevel();
    int getRange();
    
    default void displayBatteryInfo() {
        System.out.println("Battery: " + getBatteryLevel() + "%, Range: " + getRange() + " km");
    }
}

// ========== CLASSES IMPLEMENTING INTERFACES ==========

/**
 * Airplane class - implements Flyable interface
 */
class Airplane implements Flyable {
    private String model;
    private int passengerCapacity;
    
    public Airplane(String model, int passengerCapacity) {
        this.model = model;
        this.passengerCapacity = passengerCapacity;
    }
    
    @Override
    public void takeOff() {
        System.out.println("Airplane " + model + " is taking off from runway");
    }
    
    @Override
    public void land() {
        System.out.println("Airplane " + model + " is landing on runway");
    }
    
    @Override
    public double getMaxAltitude() {
        return 12000.0; // 12 km
    }
    
    public void displayInfo() {
        System.out.println("Airplane: " + model + ", Capacity: " + passengerCapacity + " passengers");
    }
}

/**
 * Submarine class - implements Swimmable interface
 */
class Submarine implements Swimmable {
    private String name;
    private int crewSize;
    
    public Submarine(String name, int crewSize) {
        this.name = name;
        this.crewSize = crewSize;
    }
    
    @Override
    public void dive() {
        System.out.println("Submarine " + name + " is diving");
    }
    
    @Override
    public void surface() {
        System.out.println("Submarine " + name + " is surfacing");
    }
    
    @Override
    public double getMaxDepth() {
        return 300.0; // 300 meters
    }
    
    public void displayInfo() {
        System.out.println("Submarine: " + name + ", Crew: " + crewSize);
    }
}

/**
 * ElectricCar class - extends Car and implements Electric interface
 * Demonstrates multiple inheritance through interfaces
 */
class ElectricCar extends Car implements Electric {
    private double batteryLevel;
    private int range;
    
    public ElectricCar(String brand, String model, int year, int numberOfDoors, 
                      double batteryLevel, int range) {
        super(brand, model, year, numberOfDoors, "Electric");
        this.batteryLevel = batteryLevel;
        this.range = range;
    }
    
    @Override
    public void charge() {
        System.out.println("Electric car " + brand + " " + model + " is charging");
        batteryLevel = 100.0;
    }
    
    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }
    
    @Override
    public int getRange() {
        return (int) (range * (batteryLevel / 100.0));
    }
    
    @Override
    public void start() {
        if (batteryLevel > 0) {
            System.out.println("Electric car " + brand + " " + model + " started silently");
        } else {
            System.out.println("Cannot start - battery is empty. Please charge first.");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        displayBatteryInfo();
    }
}

/**
 * Amphibious vehicle - implements both Flyable and Swimmable
 * Demonstrates multiple interface implementation
 */
class AmphibiousVehicle implements Flyable, Swimmable {
    private String name;
    
    public AmphibiousVehicle(String name) {
        this.name = name;
    }
    
    // Flyable interface methods
    @Override
    public void takeOff() {
        System.out.println("Amphibious vehicle " + name + " taking off from water");
    }
    
    @Override
    public void land() {
        System.out.println("Amphibious vehicle " + name + " landing on water");
    }
    
    @Override
    public double getMaxAltitude() {
        return 1000.0; // 1 km
    }
    
    // Swimmable interface methods
    @Override
    public void dive() {
        System.out.println("Amphibious vehicle " + name + " diving underwater");
    }
    
    @Override
    public void surface() {
        System.out.println("Amphibious vehicle " + name + " surfacing");
    }
    
    @Override
    public double getMaxDepth() {
        return 50.0; // 50 meters
    }
    
    public void displayCapabilities() {
        System.out.println("Amphibious Vehicle: " + name);
        System.out.println("Can fly up to: " + getMaxAltitude() + " meters");
        System.out.println("Can dive up to: " + getMaxDepth() + " meters");
    }
}

// ========== MAIN CLASS FOR DEMONSTRATION ==========

public class Abstraction {
    
    public static void main(String[] args) {
        
        System.out.println("=== Abstraction in Java OOP ===\n");
        
        // ========== ABSTRACT CLASSES ==========
        
        System.out.println("=== Abstract Classes ===");
        abstractClassDemo();
        
        // ========== INTERFACES ==========
        
        System.out.println("\n=== Interfaces ===");
        interfaceDemo();
        
        // ========== MULTIPLE INHERITANCE THROUGH INTERFACES ==========
        
        System.out.println("\n=== Multiple Inheritance through Interfaces ===");
        multipleInheritanceDemo();
        
        // ========== ABSTRACT CLASS VS INTERFACE ==========
        
        System.out.println("\n=== Abstract Class vs Interface Comparison ===");
        comparisonDemo();
        
        System.out.println("\n=== Abstraction lesson completed! ===");
    }
    
    /**
     * Demonstrates abstract classes
     */
    public static void abstractClassDemo() {
        
        // Cannot instantiate abstract class
        // Vehicle vehicle = new Vehicle(); // Compilation error
        
        // Create concrete objects
        Car car = new Car("Toyota", "Camry", 2023, 4, "Petrol");
        Motorcycle motorcycle = new Motorcycle("Honda", "CBR600", 2022, 600, false);
        
        System.out.println("=== Car Demo ===");
        car.displayInfo();
        car.start();
        car.honk(); // Inherited concrete method
        car.openTrunk(); // Car-specific method
        car.stop();
        System.out.println("Vehicle ID: " + car.getVehicleId()); // Final method
        
        System.out.println("\n=== Motorcycle Demo ===");
        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.honk(); // Inherited concrete method
        motorcycle.wheelie(); // Motorcycle-specific method
        motorcycle.stop();
        
        // Polymorphism with abstract class
        System.out.println("\n=== Polymorphism with Abstract Class ===");
        Vehicle[] vehicles = {car, motorcycle};
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nProcessing: " + vehicle.getClass().getSimpleName());
            vehicle.displayInfo();
            vehicle.start();
            System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency() + " km/l");
            vehicle.stop();
        }
    }
    
    /**
     * Demonstrates interfaces
     */
    public static void interfaceDemo() {
        
        // Create objects implementing interfaces
        Airplane airplane = new Airplane("Boeing 747", 400);
        Submarine submarine = new Submarine("USS Nautilus", 100);
        ElectricCar electricCar = new ElectricCar("Tesla", "Model S", 2023, 4, 85.0, 500);
        
        System.out.println("=== Airplane Demo ===");
        airplane.displayInfo();
        airplane.takeOff();
        airplane.fly(); // Default method
        airplane.land();
        System.out.println("Max altitude: " + airplane.getMaxAltitude() + " meters");
        
        System.out.println("\n=== Submarine Demo ===");
        submarine.displayInfo();
        submarine.dive();
        submarine.swim(); // Default method
        submarine.surface();
        System.out.println("Max depth: " + submarine.getMaxDepth() + " meters");
        
        System.out.println("\n=== Electric Car Demo ===");
        electricCar.displayInfo();
        electricCar.start();
        electricCar.charge();
        electricCar.displayBatteryInfo(); // Default method from Electric interface
        electricCar.stop();
        
        // Static method call
        System.out.println("\n=== Static Method Demo ===");
        Flyable.displayFlyingRules();
    }
    
    /**
     * Demonstrates multiple inheritance through interfaces
     */
    public static void multipleInheritanceDemo() {
        
        AmphibiousVehicle amphibious = new AmphibiousVehicle("SeaPlane-X1");
        
        System.out.println("=== Amphibious Vehicle Demo ===");
        amphibious.displayCapabilities();
        
        // Can be treated as Flyable
        System.out.println("\n--- As Flyable ---");
        Flyable flyable = amphibious;
        flyable.takeOff();
        flyable.fly();
        flyable.land();
        
        // Can be treated as Swimmable
        System.out.println("\n--- As Swimmable ---");
        Swimmable swimmable = amphibious;
        swimmable.dive();
        swimmable.swim();
        swimmable.surface();
        
        // Interface array polymorphism
        System.out.println("\n=== Interface Polymorphism ===");
        Flyable[] flyables = {new Airplane("Fighter Jet", 2), amphibious};
        
        for (Flyable f : flyables) {
            System.out.println("Flying object: " + f.getClass().getSimpleName());
            f.takeOff();
            f.fly();
            f.land();
            System.out.println();
        }
    }
    
    /**
     * Demonstrates comparison between abstract classes and interfaces
     */
    public static void comparisonDemo() {
        
        System.out.println("Abstract Class vs Interface Comparison:");
        System.out.println();
        
        System.out.println("┌─────────────────────┬─────────────────────┬─────────────────────┐");
        System.out.println("│ Feature             │ Abstract Class      │ Interface           │");
        System.out.println("├─────────────────────┼─────────────────────┼─────────────────────┤");
        System.out.println("│ Instantiation       │ Cannot instantiate  │ Cannot instantiate  │");
        System.out.println("│ Methods             │ Abstract + Concrete │ Abstract + Default  │");
        System.out.println("│ Variables           │ Any type            │ public static final │");
        System.out.println("│ Constructor         │ Yes                 │ No                  │");
        System.out.println("│ Access Modifiers    │ Any                 │ public (default)    │");
        System.out.println("│ Multiple Inheritance│ No                  │ Yes                 │");
        System.out.println("│ Keyword             │ extends             │ implements          │");
        System.out.println("│ When to use         │ IS-A relationship   │ CAN-DO behavior     │");
        System.out.println("└─────────────────────┴─────────────────────┴─────────────────────┘");
        
        System.out.println("\nWhen to use Abstract Classes:");
        System.out.println("• When you want to share code among related classes");
        System.out.println("• When you have common fields or methods with common access modifiers");
        System.out.println("• When you want to provide a common interface with some implementation");
        System.out.println("• When you need constructors or destructors");
        
        System.out.println("\nWhen to use Interfaces:");
        System.out.println("• When you want to specify behavior that can be implemented by any class");
        System.out.println("• When you need multiple inheritance of type");
        System.out.println("• When you want to achieve loose coupling");
        System.out.println("• When you want to define contracts for unrelated classes");
        
        System.out.println("\nReal-world Examples:");
        System.out.println("Abstract Class: Animal -> Dog, Cat (shared characteristics)");
        System.out.println("Interface: Drawable -> Circle, Rectangle, Triangle (common behavior)");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Abstraction hides implementation details and shows only essential features
 * 2. Abstract classes cannot be instantiated but can have constructors
 * 3. Abstract methods must be implemented by concrete subclasses
 * 4. Interfaces define contracts that implementing classes must follow
 * 5. Java supports multiple inheritance through interfaces
 * 
 * Abstract Classes:
 * - Can have both abstract and concrete methods
 * - Can have instance variables and constructors
 * - Support single inheritance (extends one class)
 * - Use when classes share common code and structure
 * 
 * Interfaces:
 * - All methods are public and abstract by default (before Java 8)
 * - Can have default and static methods (Java 8+)
 * - Variables are public, static, and final by default
 * - Support multiple inheritance (implements multiple interfaces)
 * - Use when defining common behavior for unrelated classes
 * 
 * Benefits of Abstraction:
 * - Code reusability and organization
 * - Enforces implementation of essential methods
 * - Supports polymorphism and loose coupling
 * - Provides clear contracts and interfaces
 * - Enables multiple inheritance through interfaces
 * 
 * Best Practices:
 * - Use abstract classes for IS-A relationships
 * - Use interfaces for CAN-DO behaviors
 * - Prefer composition over inheritance when possible
 * - Keep interfaces focused and cohesive
 * - Use meaningful names for abstract methods
 * - Document abstract classes and interfaces well
 */
