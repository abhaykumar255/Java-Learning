/**
 * ClassesAndObjects.java - Understanding Classes and Objects in Java
 * 
 * Learning Objectives:
 * - Understand the difference between class and object
 * - Learn how to define classes with attributes and methods
 * - Practice creating and using objects
 * - Understand constructors and the 'this' keyword
 * - Explore object memory allocation
 */

// ========== STUDENT CLASS DEFINITION ==========

/**
 * Student class represents a student with basic information
 * This is our blueprint/template for creating student objects
 */
class Student {
    
    // ========== INSTANCE VARIABLES (ATTRIBUTES) ==========
    // These variables belong to each individual object
    // Each student object will have its own copy of these variables
    
    String name;        // Student's name
    int age;           // Student's age
    String course;     // Course enrolled in
    double gpa;        // Grade Point Average
    boolean isActive;  // Whether student is currently active
    
    // ========== CONSTRUCTORS ==========
    
    /**
     * Default constructor - called when no parameters are provided
     * Java provides this automatically if we don't define any constructor
     */
    public Student() {
        // Initialize with default values
        this.name = "Unknown";
        this.age = 18;
        this.course = "Undeclared";
        this.gpa = 0.0;
        this.isActive = true;
        
        System.out.println("Default constructor called - Student created with default values");
    }
    
    /**
     * Parameterized constructor - allows creating student with specific values
     * 'this' keyword refers to the current object being created
     */
    public Student(String name, int age, String course) {
        this.name = name;      // this.name refers to instance variable
        this.age = age;        // age refers to parameter
        this.course = course;
        this.gpa = 0.0;        // Default GPA for new student
        this.isActive = true;  // New students are active by default
        
        System.out.println("Parameterized constructor called - Student " + name + " created");
    }
    
    /**
     * Full constructor - initializes all attributes
     */
    public Student(String name, int age, String course, double gpa, boolean isActive) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.gpa = gpa;
        this.isActive = isActive;
        
        System.out.println("Full constructor called - Student " + name + " created with all details");
    }
    
    // ========== INSTANCE METHODS ==========
    // These methods operate on individual objects
    
    /**
     * Method to display student information
     * No parameters needed as it works with instance variables
     */
    public void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Course: " + this.course);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Status: " + (this.isActive ? "Active" : "Inactive"));
        System.out.println("========================");
    }
    
    /**
     * Method to update GPA
     * Demonstrates how methods can modify object state
     */
    public void updateGPA(double newGPA) {
        if (newGPA >= 0.0 && newGPA <= 4.0) {
            this.gpa = newGPA;
            System.out.println(this.name + "'s GPA updated to: " + newGPA);
        } else {
            System.out.println("Invalid GPA! Must be between 0.0 and 4.0");
        }
    }
    
    /**
     * Method to change course
     */
    public void changeCourse(String newCourse) {
        String oldCourse = this.course;
        this.course = newCourse;
        System.out.println(this.name + " changed course from " + oldCourse + " to " + newCourse);
    }
    
    /**
     * Method to check if student is honor roll (GPA >= 3.5)
     * Returns a boolean value
     */
    public boolean isHonorRoll() {
        return this.gpa >= 3.5;
    }
    
    /**
     * Method to get student's academic status based on GPA
     * Demonstrates method returning different values based on object state
     */
    public String getAcademicStatus() {
        if (this.gpa >= 3.7) {
            return "Excellent";
        } else if (this.gpa >= 3.0) {
            return "Good";
        } else if (this.gpa >= 2.0) {
            return "Satisfactory";
        } else {
            return "Needs Improvement";
        }
    }
    
    /**
     * Method demonstrating 'this' keyword usage
     * 'this' refers to the current object
     */
    public void introduceYourself() {
        System.out.println("Hi! I'm " + this.name + 
                          ", a " + this.age + " year old student studying " + this.course);
    }
}

// ========== MAIN CLASS FOR DEMONSTRATION ==========

public class ClassesAndObjects {
    
    public static void main(String[] args) {
        
        System.out.println("=== Classes and Objects in Java ===\n");
        
        // ========== CREATING OBJECTS (INSTANTIATION) ==========
        
        System.out.println("=== Creating Objects ===");
        
        // Using default constructor
        Student student1 = new Student();
        
        // Using parameterized constructor
        Student student2 = new Student("Alice Johnson", 20, "Computer Science");
        
        // Using full constructor
        Student student3 = new Student("Bob Smith", 22, "Mathematics", 3.8, true);
        
        System.out.println();
        
        // ========== ACCESSING OBJECT ATTRIBUTES ==========
        
        System.out.println("=== Accessing Object Attributes ===");
        
        // Direct access to public attributes (not recommended in real applications)
        System.out.println("Student1 name: " + student1.name);
        System.out.println("Student2 age: " + student2.age);
        System.out.println("Student3 GPA: " + student3.gpa);
        
        // Modifying attributes directly
        student1.name = "Charlie Brown";
        student1.age = 19;
        student1.course = "Physics";
        
        System.out.println("After modification - Student1 name: " + student1.name);
        System.out.println();
        
        // ========== CALLING OBJECT METHODS ==========
        
        System.out.println("=== Calling Object Methods ===");
        
        // Each object has its own copy of instance variables
        // but shares the same method code
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();
        
        // ========== DEMONSTRATING OBJECT BEHAVIOR ==========
        
        System.out.println("=== Object Behavior Demonstration ===");
        
        // Update GPAs
        student1.updateGPA(3.2);
        student2.updateGPA(3.9);
        student3.updateGPA(4.1); // Invalid GPA
        
        // Change courses
        student2.changeCourse("Data Science");
        
        // Check honor roll status
        System.out.println(student1.name + " is on honor roll: " + student1.isHonorRoll());
        System.out.println(student2.name + " is on honor roll: " + student2.isHonorRoll());
        System.out.println(student3.name + " is on honor roll: " + student3.isHonorRoll());
        
        // Get academic status
        System.out.println(student1.name + "'s academic status: " + student1.getAcademicStatus());
        System.out.println(student2.name + "'s academic status: " + student2.getAcademicStatus());
        System.out.println(student3.name + "'s academic status: " + student3.getAcademicStatus());
        
        // Self introduction
        System.out.println("\n=== Student Introductions ===");
        student1.introduceYourself();
        student2.introduceYourself();
        student3.introduceYourself();
        
        // ========== OBJECT INDEPENDENCE ==========
        
        System.out.println("\n=== Object Independence ===");
        
        // Each object is independent - changes to one don't affect others
        student1.updateGPA(2.5);
        student2.updateGPA(3.7);
        
        System.out.println("After GPA updates:");
        System.out.println(student1.name + " GPA: " + student1.gpa);
        System.out.println(student2.name + " GPA: " + student2.gpa);
        System.out.println(student3.name + " GPA: " + student3.gpa + " (unchanged)");
        
        // ========== MULTIPLE REFERENCES TO SAME OBJECT ==========
        
        System.out.println("\n=== Object References ===");
        
        Student anotherRefToStudent2 = student2; // Same object, different reference
        
        System.out.println("student2 name: " + student2.name);
        System.out.println("anotherRefToStudent2 name: " + anotherRefToStudent2.name);
        
        // Changing through one reference affects the other (same object)
        anotherRefToStudent2.name = "Alice Williams";
        
        System.out.println("After name change through anotherRefToStudent2:");
        System.out.println("student2 name: " + student2.name);
        System.out.println("anotherRefToStudent2 name: " + anotherRefToStudent2.name);
        
        // ========== NULL REFERENCES ==========
        
        System.out.println("\n=== Null References ===");
        
        Student nullStudent = null; // Reference not pointing to any object
        
        if (nullStudent == null) {
            System.out.println("nullStudent is null - no object created yet");
        }
        
        // Attempting to use null reference would cause NullPointerException
        // nullStudent.displayInfo(); // This would crash the program!
        
        System.out.println("\n=== Classes and Objects lesson completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Class is a blueprint, Object is an instance of that blueprint
 * 2. Each object has its own copy of instance variables
 * 3. Objects share the same method code but operate on their own data
 * 4. Constructors initialize objects when they are created
 * 5. 'this' keyword refers to the current object
 * 6. Multiple references can point to the same object
 * 7. Always check for null before using object references
 * 
 * Memory Concepts:
 * - Objects are stored in heap memory
 * - References are stored in stack memory
 * - Garbage collection removes unused objects
 * 
 * Best Practices:
 * - Use meaningful class and variable names
 * - Initialize objects properly through constructors
 * - Make instance variables private (encapsulation)
 * - Provide public methods to interact with objects
 */
