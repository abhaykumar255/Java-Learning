/**
 * Polymorphism.java - Understanding Polymorphism in Java OOP
 * 
 * Learning Objectives:
 * - Understand polymorphism concept and its types
 * - Learn method overloading (compile-time polymorphism)
 * - Master method overriding (runtime polymorphism)
 * - Practice dynamic method dispatch
 * - Understand virtual method calls and late binding
 */

// ========== BASE CLASS FOR POLYMORPHISM DEMO ==========

/**
 * Shape class serves as base class for polymorphism demonstration
 */
abstract class Shape {
    protected String color;
    protected double area;
    
    public Shape(String color) {
        this.color = color;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Abstract method for perimeter
    public abstract double calculatePerimeter();
    
    // Concrete method that can be overridden
    public void displayInfo() {
        System.out.println("Shape: " + getClass().getSimpleName());
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
    
    // Method overloading example
    public void draw() {
        System.out.println("Drawing a " + color + " " + getClass().getSimpleName());
    }
    
    public void draw(String style) {
        System.out.println("Drawing a " + color + " " + getClass().getSimpleName() + " in " + style + " style");
    }
    
    public void draw(String style, int thickness) {
        System.out.println("Drawing a " + color + " " + getClass().getSimpleName() + 
                          " in " + style + " style with thickness " + thickness);
    }
}

// ========== CONCRETE SHAPE CLASSES ==========

/**
 * Circle class - demonstrates method overriding
 */
class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Radius: " + radius);
    }
    
    // Circle-specific method
    public double getDiameter() {
        return 2 * radius;
    }
    
    // Method overloading in Circle
    public void resize(double factor) {
        this.radius *= factor;
        System.out.println("Circle resized by factor " + factor + ", new radius: " + radius);
    }
    
    public void resize(double newRadius, boolean absolute) {
        if (absolute) {
            this.radius = newRadius;
            System.out.println("Circle radius set to: " + radius);
        } else {
            resize(newRadius);
        }
    }
}

/**
 * Rectangle class - demonstrates method overriding
 */
class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }
    
    // Rectangle-specific method
    public boolean isSquare() {
        return length == width;
    }
    
    // Method overloading in Rectangle
    public void resize(double lengthFactor, double widthFactor) {
        this.length *= lengthFactor;
        this.width *= widthFactor;
        System.out.println("Rectangle resized - Length: " + length + ", Width: " + width);
    }
    
    public void resize(double factor) {
        resize(factor, factor); // Uniform scaling
    }
}

/**
 * Triangle class - demonstrates method overriding
 */
class Triangle extends Shape {
    private double side1, side2, side3;
    
    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Sides: " + side1 + ", " + side2 + ", " + side3);
        System.out.println("Triangle type: " + getTriangleType());
    }
    
    // Triangle-specific method
    public String getTriangleType() {
        if (side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }
}

// ========== CALCULATOR CLASS FOR METHOD OVERLOADING ==========

/**
 * Calculator class demonstrates method overloading extensively
 */
class Calculator {
    
    // Method overloading with different number of parameters
    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    
    public int add(int a, int b, int c, int d) {
        System.out.println("Adding four integers: " + a + " + " + b + " + " + c + " + " + d);
        return a + b + c + d;
    }
    
    // Method overloading with different data types
    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }
    
    public float add(float a, float b) {
        System.out.println("Adding two floats: " + a + " + " + b);
        return a + b;
    }
    
    // Method overloading with different parameter order
    public String add(String a, int b) {
        System.out.println("Concatenating string and int: " + a + " + " + b);
        return a + b;
    }
    
    public String add(int a, String b) {
        System.out.println("Concatenating int and string: " + a + " + " + b);
        return a + b;
    }
    
    // Method overloading with arrays
    public int add(int[] numbers) {
        System.out.print("Adding array elements: ");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println("= " + sum);
        return sum;
    }
    
    // Variable arguments (varargs) - special case of overloading
    public int add(int... numbers) {
        System.out.print("Adding variable arguments: ");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.print(num + " ");
        }
        System.out.println("= " + sum);
        return sum;
    }
}

// ========== MAIN CLASS FOR DEMONSTRATION ==========

public class Polymorphism {
    
    public static void main(String[] args) {
        
        System.out.println("=== Polymorphism in Java OOP ===\n");
        
        // ========== METHOD OVERLOADING (COMPILE-TIME POLYMORPHISM) ==========
        
        System.out.println("=== Method Overloading (Compile-time Polymorphism) ===");
        methodOverloadingDemo();
        
        // ========== METHOD OVERRIDING (RUNTIME POLYMORPHISM) ==========
        
        System.out.println("\n=== Method Overriding (Runtime Polymorphism) ===");
        methodOverridingDemo();
        
        // ========== DYNAMIC METHOD DISPATCH ==========
        
        System.out.println("\n=== Dynamic Method Dispatch ===");
        dynamicMethodDispatchDemo();
        
        // ========== POLYMORPHIC ARRAYS ==========
        
        System.out.println("\n=== Polymorphic Arrays ===");
        polymorphicArrayDemo();
        
        // ========== INSTANCEOF AND CASTING ==========
        
        System.out.println("\n=== instanceof and Casting ===");
        instanceofAndCastingDemo();
        
        System.out.println("\n=== Polymorphism lesson completed! ===");
    }
    
    /**
     * Demonstrates method overloading
     */
    public static void methodOverloadingDemo() {
        Calculator calc = new Calculator();
        
        System.out.println("Method Overloading Examples:");
        
        // Different number of parameters
        calc.add(5, 3);
        calc.add(5, 3, 2);
        calc.add(5, 3, 2, 1);
        
        // Different data types
        calc.add(5.5, 3.2);
        calc.add(5.5f, 3.2f);
        
        // Different parameter order
        calc.add("Result: ", 42);
        calc.add(42, " is the answer");
        
        // Array parameter
        int[] numbers = {1, 2, 3, 4, 5};
        calc.add(numbers);
        
        // Variable arguments
        calc.add(1, 2, 3, 4, 5, 6);
        
        // Shape class overloading
        System.out.println("\nShape drawing overloading:");
        Circle circle = new Circle("Red", 5.0);
        circle.draw();
        circle.draw("solid");
        circle.draw("dashed", 3);
        
        // Circle resize overloading
        System.out.println("\nCircle resize overloading:");
        circle.resize(1.5);
        circle.resize(10.0, true);
    }
    
    /**
     * Demonstrates method overriding
     */
    public static void methodOverridingDemo() {
        System.out.println("Method Overriding Examples:");
        
        // Create different shape objects
        Circle circle = new Circle("Blue", 3.0);
        Rectangle rectangle = new Rectangle("Green", 4.0, 6.0);
        Triangle triangle = new Triangle("Yellow", 3.0, 4.0, 5.0);
        
        // Each class has its own implementation of abstract methods
        System.out.println("=== Circle ===");
        circle.displayInfo();
        
        System.out.println("\n=== Rectangle ===");
        rectangle.displayInfo();
        
        System.out.println("\n=== Triangle ===");
        triangle.displayInfo();
        
        // Demonstrating that overridden methods are called
        System.out.println("\nDirect method calls:");
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Triangle area: " + triangle.calculateArea());
    }
    
    /**
     * Demonstrates dynamic method dispatch
     */
    public static void dynamicMethodDispatchDemo() {
        System.out.println("Dynamic Method Dispatch Examples:");
        
        // Parent reference, child objects
        Shape shape1 = new Circle("Red", 4.0);
        Shape shape2 = new Rectangle("Blue", 5.0, 3.0);
        Shape shape3 = new Triangle("Green", 6.0, 8.0, 10.0);
        
        // The actual method called is determined at runtime
        System.out.println("=== Runtime Method Resolution ===");
        
        processShape(shape1); // Calls Circle's methods
        System.out.println();
        
        processShape(shape2); // Calls Rectangle's methods
        System.out.println();
        
        processShape(shape3); // Calls Triangle's methods
        System.out.println();
        
        // Demonstrating that the correct overridden method is called
        System.out.println("=== Method Dispatch Verification ===");
        Shape[] shapes = {shape1, shape2, shape3};
        
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " area: " + shape.calculateArea());
        }
    }
    
    /**
     * Helper method to process any shape polymorphically
     */
    public static void processShape(Shape shape) {
        System.out.println("Processing shape: " + shape.getClass().getSimpleName());
        shape.displayInfo();
        
        // The correct overridden method is called based on actual object type
        System.out.println("Calculated area: " + shape.calculateArea());
        System.out.println("Calculated perimeter: " + shape.calculatePerimeter());
    }
    
    /**
     * Demonstrates polymorphic arrays
     */
    public static void polymorphicArrayDemo() {
        System.out.println("Polymorphic Array Examples:");
        
        // Array of Shape references holding different shape objects
        Shape[] shapes = {
            new Circle("Red", 2.5),
            new Rectangle("Blue", 4.0, 3.0),
            new Triangle("Green", 3.0, 4.0, 5.0),
            new Circle("Yellow", 1.5),
            new Rectangle("Purple", 2.0, 2.0)
        };
        
        System.out.println("Processing array of shapes:");
        double totalArea = 0;
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\nShape " + (i + 1) + ":");
            shapes[i].displayInfo();
            totalArea += shapes[i].calculateArea();
        }
        
        System.out.println("\nTotal area of all shapes: " + totalArea);
        
        // Enhanced for loop with polymorphic array
        System.out.println("\nUsing enhanced for loop:");
        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " - Area: " + 
                             String.format("%.2f", shape.calculateArea()));
        }
    }
    
    /**
     * Demonstrates instanceof operator and casting
     */
    public static void instanceofAndCastingDemo() {
        System.out.println("instanceof and Casting Examples:");
        
        Shape[] shapes = {
            new Circle("Red", 3.0),
            new Rectangle("Blue", 4.0, 5.0),
            new Triangle("Green", 3.0, 4.0, 5.0)
        };
        
        for (Shape shape : shapes) {
            System.out.println("\nProcessing: " + shape.getClass().getSimpleName());
            
            // Check type and cast to access specific methods
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println("  Circle diameter: " + circle.getDiameter());
                System.out.println("  Circle area: " + circle.calculateArea());
                
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("  Is square: " + rectangle.isSquare());
                System.out.println("  Rectangle area: " + rectangle.calculateArea());
                
            } else if (shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                System.out.println("  Triangle type: " + triangle.getTriangleType());
                System.out.println("  Triangle area: " + triangle.calculateArea());
            }
            
            // All shapes can call common methods
            System.out.println("  Perimeter: " + shape.calculatePerimeter());
        }
        
        // Demonstrating safe casting
        System.out.println("\n=== Safe Casting Example ===");
        Shape unknownShape = new Circle("Orange", 2.0);
        
        if (unknownShape instanceof Circle) {
            Circle circle = (Circle) unknownShape;
            System.out.println("Successfully cast to Circle, diameter: " + circle.getDiameter());
        } else {
            System.out.println("Cannot cast to Circle");
        }
        
        // This would be unsafe without instanceof check
        // Rectangle rect = (Rectangle) unknownShape; // ClassCastException!
        
        if (unknownShape instanceof Rectangle) {
            Rectangle rect = (Rectangle) unknownShape;
            System.out.println("Cast to Rectangle successful");
        } else {
            System.out.println("Cannot cast to Rectangle - avoiding ClassCastException");
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Polymorphism allows objects of different types to be treated uniformly
 * 2. Method overloading is compile-time polymorphism (same name, different parameters)
 * 3. Method overriding is runtime polymorphism (same signature, different implementation)
 * 4. Dynamic method dispatch determines which method to call at runtime
 * 5. instanceof operator safely checks object type before casting
 * 
 * Types of Polymorphism:
 * - Compile-time (Static): Method overloading, operator overloading
 * - Runtime (Dynamic): Method overriding, virtual method calls
 * 
 * Method Overloading Rules:
 * - Same method name, different parameter list
 * - Different number, type, or order of parameters
 * - Return type alone cannot differentiate overloaded methods
 * - Access modifiers can be different
 * 
 * Method Overriding Rules:
 * - Same method signature (name, parameters, return type)
 * - Child class provides specific implementation
 * - Cannot override static, final, or private methods
 * - Access modifier cannot be more restrictive
 * 
 * Benefits of Polymorphism:
 * - Code flexibility and extensibility
 * - Uniform interface for different implementations
 * - Easier maintenance and modification
 * - Support for dynamic behavior
 * - Foundation for design patterns
 * 
 * Best Practices:
 * - Use polymorphism to write flexible, maintainable code
 * - Always use instanceof before casting
 * - Prefer composition over inheritance when appropriate
 * - Design interfaces and abstract classes for polymorphic behavior
 */
