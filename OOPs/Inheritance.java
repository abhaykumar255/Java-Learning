/**
 * Inheritance.java - Understanding Inheritance in Java OOP
 * 
 * Learning Objectives:
 * - Understand inheritance concept and benefits
 * - Learn extends keyword and parent-child relationships
 * - Practice method overriding and super keyword
 * - Understand constructor chaining in inheritance
 * - Explore different types of inheritance
 */

// ========== PARENT CLASS (SUPERCLASS) ==========

/**
 * Vehicle class serves as the parent class
 * Contains common properties and methods for all vehicles
 */
class Vehicle {
    // Protected variables can be accessed by child classes
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    
    // Constructor for Vehicle class
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        System.out.println("Vehicle constructor called");
    }
    
    // Default constructor
    public Vehicle() {
        this("Unknown", "Unknown", 0, 0.0);
        System.out.println("Vehicle default constructor called");
    }
    
    // Method to start the vehicle
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }
    
    // Method to stop the vehicle
    public void stop() {
        System.out.println(brand + " " + model + " has stopped.");
    }
    
    // Method to display vehicle information
    public void displayInfo() {
        System.out.println("=== Vehicle Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
    
    // Method to calculate age
    public int getAge() {
        return 2024 - year;
    }
    
    // Method that can be overridden by child classes
    public void honk() {
        System.out.println("Generic vehicle sound: Beep beep!");
    }
    
    // Final method cannot be overridden
    public final void getVehicleId() {
        System.out.println("Vehicle ID: " + brand + "-" + model + "-" + year);
    }
}

// ========== CHILD CLASS 1 (SUBCLASS) ==========

/**
 * Car class extends Vehicle class
 * Inherits all properties and methods from Vehicle
 * Adds car-specific features
 */
class Car extends Vehicle {
    // Additional properties specific to cars
    private int numberOfDoors;
    private String fuelType;
    private boolean isAutomatic;
    
    // Constructor for Car class
    public Car(String brand, String model, int year, double price, 
               int numberOfDoors, String fuelType, boolean isAutomatic) {
        // Call parent class constructor using super()
        super(brand, model, year, price);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.isAutomatic = isAutomatic;
        System.out.println("Car constructor called");
    }
    
    // Default constructor
    public Car() {
        super(); // Call parent default constructor
        this.numberOfDoors = 4;
        this.fuelType = "Gasoline";
        this.isAutomatic = true;
        System.out.println("Car default constructor called");
    }
    
    // Override parent method to provide car-specific implementation
    @Override
    public void start() {
        System.out.println("Car " + brand + " " + model + " engine started with key/button");
    }
    
    // Override honk method
    @Override
    public void honk() {
        System.out.println("Car horn: Honk honk!");
    }
    
    // Override displayInfo to include car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method first
        System.out.println("Number of doors: " + numberOfDoors);
        System.out.println("Fuel type: " + fuelType);
        System.out.println("Transmission: " + (isAutomatic ? "Automatic" : "Manual"));
    }
    
    // Car-specific method
    public void openTrunk() {
        System.out.println(brand + " " + model + " trunk opened");
    }
    
    // Method to demonstrate super keyword usage
    public void demonstrateSuper() {
        System.out.println("=== Demonstrating super keyword ===");
        
        // Access parent class variable
        System.out.println("Parent brand: " + super.brand);
        
        // Call parent class method
        System.out.println("Parent honk:");
        super.honk();
        
        System.out.println("Child honk:");
        this.honk(); // or just honk()
    }
}

// ========== CHILD CLASS 2 (SUBCLASS) ==========

/**
 * Motorcycle class extends Vehicle class
 * Another example of inheritance with different characteristics
 */
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCapacity; // in CC
    
    public Motorcycle(String brand, String model, int year, double price,
                     boolean hasSidecar, int engineCapacity) {
        super(brand, model, year, price);
        this.hasSidecar = hasSidecar;
        this.engineCapacity = engineCapacity;
        System.out.println("Motorcycle constructor called");
    }
    
    // Override start method
    @Override
    public void start() {
        System.out.println("Motorcycle " + brand + " " + model + " started with kick/electric start");
    }
    
    // Override honk method
    @Override
    public void honk() {
        System.out.println("Motorcycle horn: Beep beep! (high pitch)");
    }
    
    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has sidecar: " + hasSidecar);
        System.out.println("Engine capacity: " + engineCapacity + " CC");
    }
    
    // Motorcycle-specific method
    public void wheelie() {
        System.out.println(brand + " " + model + " is doing a wheelie!");
    }
}

// ========== GRANDCHILD CLASS (MULTILEVEL INHERITANCE) ==========

/**
 * SportsCar class extends Car class
 * Demonstrates multilevel inheritance (SportsCar -> Car -> Vehicle)
 */
class SportsCar extends Car {
    private int topSpeed;
    private double acceleration; // 0-60 mph time
    
    public SportsCar(String brand, String model, int year, double price,
                    int numberOfDoors, String fuelType, boolean isAutomatic,
                    int topSpeed, double acceleration) {
        super(brand, model, year, price, numberOfDoors, fuelType, isAutomatic);
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        System.out.println("SportsCar constructor called");
    }
    
    // Override start method again
    @Override
    public void start() {
        System.out.println("Sports car " + brand + " " + model + " roars to life!");
    }
    
    // Override honk method
    @Override
    public void honk() {
        System.out.println("Sports car horn: HONK! (aggressive sound)");
    }
    
    // Override displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo(); // Calls Car's displayInfo, which calls Vehicle's
        System.out.println("Top speed: " + topSpeed + " mph");
        System.out.println("0-60 mph: " + acceleration + " seconds");
    }
    
    // Sports car specific methods
    public void turboBoost() {
        System.out.println(brand + " " + model + " turbo boost activated!");
    }
    
    public void raceMode() {
        System.out.println(brand + " " + model + " switched to race mode!");
    }
}

// ========== MAIN CLASS FOR DEMONSTRATION ==========

public class Inheritance {
    
    public static void main(String[] args) {
        
        System.out.println("=== Inheritance in Java OOP ===\n");
        
        // ========== CREATING OBJECTS ==========
        
        System.out.println("=== Creating Objects ===");
        
        // Create parent class object
        Vehicle genericVehicle = new Vehicle("Generic", "Model-X", 2020, 25000);
        System.out.println();
        
        // Create child class objects
        Car myCar = new Car("Toyota", "Camry", 2022, 35000, 4, "Gasoline", true);
        System.out.println();
        
        Motorcycle myBike = new Motorcycle("Harley-Davidson", "Street 750", 2021, 8000, false, 750);
        System.out.println();
        
        SportsCar sportsCar = new SportsCar("Ferrari", "F8 Tributo", 2023, 280000, 2, "Gasoline", true, 211, 2.9);
        System.out.println();
        
        // ========== METHOD INHERITANCE ==========
        
        System.out.println("=== Method Inheritance ===");
        
        // Child objects can use parent methods
        System.out.println("Using inherited methods:");
        myCar.getVehicleId();    // Inherited from Vehicle
        myBike.getVehicleId();   // Inherited from Vehicle
        
        System.out.println("Car age: " + myCar.getAge() + " years");
        System.out.println("Bike age: " + myBike.getAge() + " years");
        
        // ========== METHOD OVERRIDING ==========
        
        System.out.println("\n=== Method Overriding ===");
        
        // Same method name, different implementations
        genericVehicle.start();
        myCar.start();
        myBike.start();
        sportsCar.start();
        
        System.out.println();
        
        // Honk method overriding
        genericVehicle.honk();
        myCar.honk();
        myBike.honk();
        sportsCar.honk();
        
        // ========== SUPER KEYWORD DEMONSTRATION ==========
        
        System.out.println("\n=== Super Keyword ===");
        myCar.demonstrateSuper();
        
        // ========== POLYMORPHISM WITH INHERITANCE ==========
        
        System.out.println("\n=== Polymorphism with Inheritance ===");
        
        // Parent reference can hold child objects
        Vehicle[] vehicles = {
            new Vehicle("Generic", "Basic", 2020, 20000),
            new Car("Honda", "Civic", 2023, 25000, 4, "Gasoline", true),
            new Motorcycle("Yamaha", "R15", 2022, 3000, false, 155),
            new SportsCar("Lamborghini", "Huracan", 2024, 350000, 2, "Gasoline", true, 202, 3.2)
        };
        
        System.out.println("Polymorphic method calls:");
        for (Vehicle vehicle : vehicles) {
            vehicle.start(); // Calls overridden method based on actual object type
        }
        
        // ========== INSTANCEOF OPERATOR ==========
        
        System.out.println("\n=== instanceof Operator ===");
        
        Vehicle testVehicle = new Car("Test", "Car", 2023, 30000, 4, "Electric", true);
        
        System.out.println("testVehicle instanceof Vehicle: " + (testVehicle instanceof Vehicle));
        System.out.println("testVehicle instanceof Car: " + (testVehicle instanceof Car));
        System.out.println("testVehicle instanceof Motorcycle: " + (testVehicle instanceof Motorcycle));
        
        // Safe casting
        if (testVehicle instanceof Car) {
            Car testCar = (Car) testVehicle;
            testCar.openTrunk();
        }
        
        // ========== DISPLAYING OBJECT INFORMATION ==========
        
        System.out.println("\n=== Object Information ===");
        
        genericVehicle.displayInfo();
        System.out.println();
        
        myCar.displayInfo();
        System.out.println();
        
        myBike.displayInfo();
        System.out.println();
        
        sportsCar.displayInfo();
        System.out.println();
        
        // ========== CHILD-SPECIFIC METHODS ==========
        
        System.out.println("=== Child-Specific Methods ===");
        
        myCar.openTrunk();
        myBike.wheelie();
        sportsCar.turboBoost();
        sportsCar.raceMode();
        
        // ========== INHERITANCE HIERARCHY ==========
        
        System.out.println("\n=== Inheritance Hierarchy ===");
        demonstrateInheritanceHierarchy();
        
        System.out.println("\n=== Inheritance lesson completed! ===");
    }
    
    /**
     * Demonstrates inheritance hierarchy and relationships
     */
    public static void demonstrateInheritanceHierarchy() {
        System.out.println("Inheritance Hierarchy:");
        System.out.println("Vehicle (Parent/Superclass)");
        System.out.println("├── Car (Child/Subclass)");
        System.out.println("│   └── SportsCar (Grandchild)");
        System.out.println("└── Motorcycle (Child/Subclass)");
        
        System.out.println("\nInheritance Benefits:");
        System.out.println("✅ Code Reusability - Child classes reuse parent code");
        System.out.println("✅ Method Overriding - Customize behavior in child classes");
        System.out.println("✅ Polymorphism - Same interface, different implementations");
        System.out.println("✅ Extensibility - Easy to add new types");
        System.out.println("✅ Maintainability - Changes in parent affect all children");
        
        System.out.println("\nTypes of Inheritance in Java:");
        System.out.println("• Single Inheritance: One parent, one child");
        System.out.println("• Multilevel Inheritance: Chain of inheritance (A->B->C)");
        System.out.println("• Hierarchical Inheritance: One parent, multiple children");
        System.out.println("• Note: Java doesn't support multiple inheritance of classes");
        
        System.out.println("\nKey Keywords:");
        System.out.println("• extends: Establishes inheritance relationship");
        System.out.println("• super: Access parent class members");
        System.out.println("• @Override: Indicates method overriding");
        System.out.println("• final: Prevents inheritance/overriding");
        System.out.println("• instanceof: Check object type");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Inheritance allows child classes to inherit properties and methods from parent classes
 * 2. Use 'extends' keyword to establish inheritance relationship
 * 3. Child classes can override parent methods to provide specific implementations
 * 4. 'super' keyword accesses parent class members and constructors
 * 5. Constructor chaining: child constructor calls parent constructor
 * 6. Java supports single inheritance (one parent) but multiple levels
 * 
 * Method Overriding Rules:
 * - Same method signature (name, parameters, return type)
 * - Child method cannot be more restrictive than parent
 * - Use @Override annotation for clarity and error checking
 * - final methods cannot be overridden
 * 
 * Benefits of Inheritance:
 * - Code reusability and reduced duplication
 * - Polymorphism and dynamic method dispatch
 * - Easier maintenance and extensibility
 * - Natural modeling of real-world relationships
 * 
 * Best Practices:
 * - Use inheritance for "is-a" relationships
 * - Prefer composition over inheritance when appropriate
 * - Keep inheritance hierarchies shallow and logical
 * - Document inheritance relationships clearly
 * - Use protected access for child class access
 */
