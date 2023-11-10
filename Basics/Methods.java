/**
 * Methods.java - Understanding Methods in Java
 * 
 * Learning Objectives:
 * - Understand what methods are and why we need them
 * - Learn method syntax and components
 * - Practice method parameters and return types
 * - Understand method overloading
 * - Explore variable scope and method calls
 */

public class Methods {
    
    // ========== INSTANCE VARIABLES ==========
    // These can be accessed by all methods in this class
    static String className = "Methods Demo";
    static int totalMethodsCalled = 0;
    
    public static void main(String[] args) {
        
        System.out.println("=== Methods in Java ===\n");
        
        // ========== WHY DO WE NEED METHODS? ==========
        
        System.out.println("=== Why Methods? ===");
        
        // Without methods - repetitive code
        System.out.println("Without methods (repetitive approach):");
        int num1 = 10, num2 = 20;
        int sum1 = num1 + num2;
        System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum1);
        
        int num3 = 30, num4 = 40;
        int sum2 = num3 + num4;
        System.out.println("Sum of " + num3 + " and " + num4 + " is: " + sum2);
        
        // With methods - reusable code
        System.out.println("\nWith methods (reusable approach):");
        int result1 = addNumbers(10, 20);
        int result2 = addNumbers(30, 40);
        System.out.println("Sum using method: " + result1);
        System.out.println("Sum using method: " + result2);
        
        // ========== BASIC METHOD CALLS ==========
        
        System.out.println("\n=== Basic Method Calls ===");
        
        // Calling methods without parameters
        greetUser();
        displayCurrentTime();
        
        // Calling methods with parameters
        greetUserByName("Alice");
        greetUserByName("Bob");
        
        // ========== METHODS WITH RETURN VALUES ==========
        
        System.out.println("\n=== Methods with Return Values ===");
        
        // Methods that return values
        int square = calculateSquare(5);
        System.out.println("Square of 5 is: " + square);
        
        double area = calculateCircleArea(3.0);
        System.out.println("Area of circle with radius 3.0 is: " + area);
        
        boolean isEven = checkIfEven(8);
        System.out.println("Is 8 even? " + isEven);
        
        String message = createWelcomeMessage("John", "Java Programming");
        System.out.println(message);
        
        // ========== METHOD OVERLOADING ==========
        
        System.out.println("\n=== Method Overloading ===");
        
        // Same method name, different parameters
        System.out.println("Add two integers: " + add(5, 3));
        System.out.println("Add three integers: " + add(5, 3, 2));
        System.out.println("Add two doubles: " + add(5.5, 3.2));
        System.out.println("Add two strings: " + add("Hello", "World"));
        
        // ========== VARIABLE SCOPE ==========
        
        System.out.println("\n=== Variable Scope ===");
        demonstrateScope();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical Examples ===");
        
        // Temperature conversion
        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        
        // Grade calculation
        int[] scores = {85, 92, 78, 96, 88};
        double average = calculateAverage(scores);
        String grade = getLetterGrade(average);
        System.out.println("Average score: " + average + ", Grade: " + grade);
        
        // Number operations
        int num = 12345;
        System.out.println("Number of digits in " + num + ": " + countDigits(num));
        System.out.println("Reverse of " + num + ": " + reverseNumber(num));
        System.out.println("Is " + num + " palindrome? " + isPalindrome(num));
        
        // Display method call statistics
        System.out.println("\nTotal methods called: " + totalMethodsCalled);
        
        System.out.println("\n=== Methods lesson completed! ===");
    }
    
    // ========== BASIC METHODS ==========
    
    /**
     * Method without parameters and no return value
     * Access modifier: public, static (can be called without object)
     * Return type: void (returns nothing)
     */
    public static void greetUser() {
        totalMethodsCalled++;
        System.out.println("Hello! Welcome to Java programming!");
    }
    
    /**
     * Method to display current time (simulated)
     */
    public static void displayCurrentTime() {
        totalMethodsCalled++;
        System.out.println("Current time: 10:30 AM (simulated)");
    }
    
    /**
     * Method with parameter but no return value
     * @param name - the name to greet
     */
    public static void greetUserByName(String name) {
        totalMethodsCalled++;
        System.out.println("Hello, " + name + "! Nice to meet you!");
    }
    
    // ========== METHODS WITH RETURN VALUES ==========
    
    /**
     * Method that takes two parameters and returns their sum
     * @param a - first number
     * @param b - second number
     * @return sum of a and b
     */
    public static int addNumbers(int a, int b) {
        totalMethodsCalled++;
        return a + b; // return statement sends value back to caller
    }
    
    /**
     * Method to calculate square of a number
     * @param number - the number to square
     * @return square of the number
     */
    public static int calculateSquare(int number) {
        totalMethodsCalled++;
        return number * number;
    }
    
    /**
     * Method to calculate area of a circle
     * @param radius - radius of the circle
     * @return area of the circle
     */
    public static double calculateCircleArea(double radius) {
        totalMethodsCalled++;
        final double PI = 3.14159; // local constant
        return PI * radius * radius;
    }
    
    /**
     * Method to check if a number is even
     * @param number - number to check
     * @return true if even, false if odd
     */
    public static boolean checkIfEven(int number) {
        totalMethodsCalled++;
        return number % 2 == 0;
    }
    
    /**
     * Method to create a welcome message
     * @param name - user's name
     * @param course - course name
     * @return formatted welcome message
     */
    public static String createWelcomeMessage(String name, String course) {
        totalMethodsCalled++;
        return "Welcome " + name + "! You are enrolled in " + course + ".";
    }
    
    // ========== METHOD OVERLOADING EXAMPLES ==========
    
    /**
     * Add two integers
     */
    public static int add(int a, int b) {
        totalMethodsCalled++;
        return a + b;
    }
    
    /**
     * Add three integers (overloaded method)
     */
    public static int add(int a, int b, int c) {
        totalMethodsCalled++;
        return a + b + c;
    }
    
    /**
     * Add two doubles (overloaded method)
     */
    public static double add(double a, double b) {
        totalMethodsCalled++;
        return a + b;
    }
    
    /**
     * Concatenate two strings (overloaded method)
     */
    public static String add(String a, String b) {
        totalMethodsCalled++;
        return a + " " + b;
    }
    
    // ========== SCOPE DEMONSTRATION ==========
    
    /**
     * Method to demonstrate variable scope
     */
    public static void demonstrateScope() {
        totalMethodsCalled++;
        
        // Local variable - only accessible within this method
        int localVariable = 100;
        
        System.out.println("Local variable: " + localVariable);
        System.out.println("Class variable: " + className);
        
        // Block scope
        {
            int blockVariable = 200; // Only accessible within this block
            System.out.println("Block variable: " + blockVariable);
            System.out.println("Local variable from block: " + localVariable);
        }
        
        // System.out.println(blockVariable); // This would cause error!
        
        // Method parameters also have method scope
        demonstrateParameterScope(50);
    }
    
    /**
     * Helper method to demonstrate parameter scope
     */
    public static void demonstrateParameterScope(int parameter) {
        totalMethodsCalled++;
        System.out.println("Parameter value: " + parameter);
        // parameter is only accessible within this method
    }
    
    // ========== PRACTICAL UTILITY METHODS ==========
    
    /**
     * Convert Celsius to Fahrenheit
     * @param celsius - temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        totalMethodsCalled++;
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    /**
     * Calculate average of an array of scores
     * @param scores - array of integer scores
     * @return average score as double
     */
    public static double calculateAverage(int[] scores) {
        totalMethodsCalled++;
        
        if (scores.length == 0) {
            return 0.0; // Handle empty array
        }
        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        
        return (double) sum / scores.length;
    }
    
    /**
     * Get letter grade based on numeric average
     * @param average - numeric average
     * @return letter grade
     */
    public static String getLetterGrade(double average) {
        totalMethodsCalled++;
        
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    /**
     * Count number of digits in an integer
     * @param number - the number
     * @return number of digits
     */
    public static int countDigits(int number) {
        totalMethodsCalled++;
        
        if (number == 0) {
            return 1;
        }
        
        int count = 0;
        number = Math.abs(number); // Handle negative numbers
        
        while (number > 0) {
            count++;
            number /= 10;
        }
        
        return count;
    }
    
    /**
     * Reverse the digits of a number
     * @param number - the number to reverse
     * @return reversed number
     */
    public static int reverseNumber(int number) {
        totalMethodsCalled++;
        
        int reversed = 0;
        boolean isNegative = number < 0;
        number = Math.abs(number);
        
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        
        return isNegative ? -reversed : reversed;
    }
    
    /**
     * Check if a number is palindrome
     * @param number - the number to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        totalMethodsCalled++;
        return number == reverseNumber(number);
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Methods promote code reusability and organization
 * 2. Method signature: access_modifier return_type method_name(parameters)
 * 3. Methods can have parameters (input) and return values (output)
 * 4. Method overloading allows same name with different parameters
 * 5. Variables have scope - local, method parameter, class level
 * 6. static methods belong to class, not instances
 * 
 * Method Components:
 * - Access modifier: public, private, protected, default
 * - static keyword: method belongs to class
 * - Return type: void, int, String, boolean, etc.
 * - Method name: should be descriptive and follow camelCase
 * - Parameters: input values (optional)
 * - Method body: code to execute
 * 
 * Best Practices:
 * - Use descriptive method names
 * - Keep methods focused on single responsibility
 * - Use parameters instead of global variables when possible
 * - Document methods with comments
 * - Handle edge cases (empty arrays, null values)
 * - Return meaningful values
 */
