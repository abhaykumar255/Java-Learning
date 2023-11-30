/**
 * Encapsulation.java - Understanding Encapsulation in Java OOP
 * 
 * Learning Objectives:
 * - Understand encapsulation concept and data hiding
 * - Learn access modifiers and their scope
 * - Practice getter and setter methods
 * - Understand the benefits of encapsulation
 * - Implement proper encapsulation in real-world scenarios
 */

/**
 * BankAccount class demonstrating proper encapsulation
 */
class BankAccount {
    // Private fields - cannot be accessed directly from outside
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private boolean isActive;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = 0.0;
        this.isActive = true;
    }
    
    // Getter methods (Accessors)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    // Setter methods (Mutators) with validation
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName != null && !accountHolderName.trim().isEmpty()) {
            this.accountHolderName = accountHolderName;
        } else {
            System.out.println("Invalid account holder name");
        }
    }
    
    public void setAccountType(String accountType) {
        if (accountType != null && (accountType.equals("Savings") || 
            accountType.equals("Current") || accountType.equals("Fixed"))) {
            this.accountType = accountType;
        } else {
            System.out.println("Invalid account type. Must be Savings, Current, or Fixed");
        }
    }
    
    // Business methods with encapsulated logic
    public boolean deposit(double amount) {
        if (!isActive) {
            System.out.println("Cannot deposit to inactive account");
            return false;
        }
        
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
            return true;
        } else {
            System.out.println("Deposit amount must be positive");
            return false;
        }
    }
    
    public boolean withdraw(double amount) {
        if (!isActive) {
            System.out.println("Cannot withdraw from inactive account");
            return false;
        }
        
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Insufficient funds. Current balance: $" + balance);
            return false;
        }
        
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + ". New balance: $" + balance);
        return true;
    }
    
    public void deactivateAccount() {
        isActive = false;
        System.out.println("Account " + accountNumber + " has been deactivated");
    }
    
    public void activateAccount() {
        isActive = true;
        System.out.println("Account " + accountNumber + " has been activated");
    }
    
    public void displayAccountInfo() {
        System.out.println("=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
    }
}

/**
 * Student class demonstrating different access levels
 */
class Student {
    // Different access modifiers
    public String name;           // Public - accessible everywhere
    protected int age;            // Protected - accessible in same package and subclasses
    String course;                // Package-private (default) - accessible in same package
    private double gpa;           // Private - accessible only within this class
    
    // Private static field
    private static int totalStudents = 0;
    
    // Constructor
    public Student(String name, int age, String course, double gpa) {
        this.name = name;
        this.age = age;
        this.course = course;
        setGpa(gpa); // Use setter for validation
        totalStudents++;
    }
    
    // Public getter for private field
    public double getGpa() {
        return gpa;
    }
    
    // Public setter with validation
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA. Must be between 0.0 and 4.0");
        }
    }
    
    // Public static method to access private static field
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    // Private helper method
    private String getGradeLevel() {
        if (gpa >= 3.5) return "Excellent";
        else if (gpa >= 3.0) return "Good";
        else if (gpa >= 2.0) return "Average";
        else return "Below Average";
    }
    
    // Public method using private helper
    public void displayStudentInfo() {
        System.out.println("Student: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa + " (" + getGradeLevel() + ")");
    }
}

/**
 * Employee class demonstrating encapsulation with complex validation
 */
class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double salary;
    private String email;
    private int yearsOfExperience;
    
    // Constructor with validation
    public Employee(String employeeId, String name, String department, double salary, String email) {
        setEmployeeId(employeeId);
        setName(name);
        setDepartment(department);
        setSalary(salary);
        setEmail(email);
        this.yearsOfExperience = 0;
    }
    
    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    
    // Setters with validation
    public void setEmployeeId(String employeeId) {
        if (employeeId != null && employeeId.matches("EMP\\d{4}")) {
            this.employeeId = employeeId;
        } else {
            throw new IllegalArgumentException("Employee ID must be in format EMP####");
        }
    }
    
    public void setName(String name) {
        if (name != null && name.trim().length() >= 2) {
            this.name = name.trim();
        } else {
            throw new IllegalArgumentException("Name must be at least 2 characters long");
        }
    }
    
    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department.trim();
        } else {
            throw new IllegalArgumentException("Department cannot be empty");
        }
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
    }
    
    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email.toLowerCase();
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    
    // Business methods
    public void addExperience(int years) {
        if (years > 0) {
            this.yearsOfExperience += years;
            System.out.println("Added " + years + " years of experience");
        }
    }
    
    public double calculateAnnualBonus() {
        double bonusPercentage = 0.05; // 5% base bonus
        if (yearsOfExperience >= 5) bonusPercentage += 0.02; // Additional 2% for 5+ years
        if (yearsOfExperience >= 10) bonusPercentage += 0.03; // Additional 3% for 10+ years
        
        return salary * bonusPercentage;
    }
    
    public void displayEmployeeInfo() {
        System.out.println("=== Employee Information ===");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("Email: " + email);
        System.out.println("Experience: " + yearsOfExperience + " years");
        System.out.println("Annual Bonus: $" + calculateAnnualBonus());
    }
}

public class Encapsulation {
    
    public static void main(String[] args) {
        
        System.out.println("=== Encapsulation in Java OOP ===\n");
        
        // ========== BANK ACCOUNT DEMO ==========
        
        System.out.println("=== Bank Account Encapsulation Demo ===");
        bankAccountDemo();
        
        // ========== ACCESS MODIFIERS DEMO ==========
        
        System.out.println("\n=== Access Modifiers Demo ===");
        accessModifiersDemo();
        
        // ========== EMPLOYEE VALIDATION DEMO ==========
        
        System.out.println("\n=== Employee Validation Demo ===");
        employeeValidationDemo();
        
        // ========== ENCAPSULATION BENEFITS ==========
        
        System.out.println("\n=== Encapsulation Benefits ===");
        encapsulationBenefits();
        
        System.out.println("\n=== Encapsulation lesson completed! ===");
    }
    
    /**
     * Demonstrates bank account encapsulation
     */
    public static void bankAccountDemo() {
        
        // Create bank account
        BankAccount account = new BankAccount("ACC001", "John Doe", "Savings");
        
        // Display initial info
        account.displayAccountInfo();
        
        // Perform operations
        System.out.println("\n--- Banking Operations ---");
        account.deposit(1000);
        account.deposit(-50);  // Invalid deposit
        account.withdraw(200);
        account.withdraw(2000); // Insufficient funds
        
        // Try to access private fields directly (would cause compilation error)
        // System.out.println(account.balance); // Error: balance has private access
        
        // Access through getter methods
        System.out.println("\nAccount balance through getter: $" + account.getBalance());
        
        // Update account holder name
        account.setAccountHolderName("John Smith");
        account.setAccountType("Current");
        
        // Deactivate and try operations
        System.out.println("\n--- Account Deactivation ---");
        account.deactivateAccount();
        account.deposit(500); // Should fail
        account.withdraw(100); // Should fail
        
        // Reactivate
        account.activateAccount();
        account.deposit(500); // Should work
        
        account.displayAccountInfo();
    }
    
    /**
     * Demonstrates different access modifiers
     */
    public static void accessModifiersDemo() {
        
        Student student = new Student("Alice Johnson", 20, "Computer Science", 3.8);
        
        // Public field - directly accessible
        System.out.println("Student name (public): " + student.name);
        student.name = "Alice Smith"; // Can modify directly
        
        // Protected field - accessible in same package
        System.out.println("Student age (protected): " + student.age);
        student.age = 21; // Can modify directly
        
        // Package-private field - accessible in same package
        System.out.println("Student course (package-private): " + student.course);
        student.course = "Software Engineering"; // Can modify directly
        
        // Private field - must use getter/setter
        System.out.println("Student GPA (private, via getter): " + student.getGpa());
        // student.gpa = 3.9; // Error: gpa has private access
        student.setGpa(3.9); // Must use setter
        student.setGpa(5.0);  // Invalid GPA
        
        // Static method to access private static field
        System.out.println("Total students: " + Student.getTotalStudents());
        
        // Create another student
        Student student2 = new Student("Bob Wilson", 22, "Mathematics", 3.5);
        System.out.println("Total students after creating second: " + Student.getTotalStudents());
        
        student.displayStudentInfo();
    }
    
    /**
     * Demonstrates employee validation through encapsulation
     */
    public static void employeeValidationDemo() {
        
        try {
            // Create valid employee
            Employee emp = new Employee("EMP1001", "Sarah Connor", "IT", 75000, "sarah@company.com");
            emp.displayEmployeeInfo();
            
            // Add experience and recalculate bonus
            emp.addExperience(3);
            emp.addExperience(7); // Total 10 years
            System.out.println("\nAfter adding experience:");
            emp.displayEmployeeInfo();
            
            // Try invalid operations
            System.out.println("\n--- Testing Validation ---");
            
            try {
                emp.setEmployeeId("INVALID"); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
            
            try {
                emp.setName(""); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
            
            try {
                emp.setSalary(-1000); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
            
            try {
                emp.setEmail("invalid-email"); // Should throw exception
            } catch (IllegalArgumentException e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }
    
    /**
     * Explains the benefits of encapsulation
     */
    public static void encapsulationBenefits() {
        
        System.out.println("Benefits of Encapsulation:");
        System.out.println();
        
        System.out.println("1. Data Hiding:");
        System.out.println("   - Private fields cannot be accessed directly");
        System.out.println("   - Internal implementation is hidden from users");
        System.out.println("   - Prevents unauthorized access and modification");
        
        System.out.println("\n2. Data Validation:");
        System.out.println("   - Setter methods can validate input before setting values");
        System.out.println("   - Prevents invalid data from corrupting object state");
        System.out.println("   - Maintains data integrity and consistency");
        
        System.out.println("\n3. Controlled Access:");
        System.out.println("   - Getter and setter methods control how data is accessed");
        System.out.println("   - Can implement business logic in accessors");
        System.out.println("   - Can make fields read-only or write-only as needed");
        
        System.out.println("\n4. Flexibility:");
        System.out.println("   - Internal implementation can be changed without affecting users");
        System.out.println("   - Can add logging, caching, or other features transparently");
        System.out.println("   - Easier to maintain and evolve the codebase");
        
        System.out.println("\n5. Security:");
        System.out.println("   - Sensitive data can be protected from direct access");
        System.out.println("   - Access can be restricted based on user permissions");
        System.out.println("   - Reduces the risk of data corruption or misuse");
        
        System.out.println("\nAccess Modifier Summary:");
        System.out.println("┌─────────────┬─────────┬─────────┬─────────┬─────────┐");
        System.out.println("│ Modifier    │ Class   │ Package │ Subclass│ World   │");
        System.out.println("├─────────────┼─────────┼─────────┼─────────┼─────────┤");
        System.out.println("│ public      │ Yes     │ Yes     │ Yes     │ Yes     │");
        System.out.println("│ protected   │ Yes     │ Yes     │ Yes     │ No      │");
        System.out.println("│ (default)   │ Yes     │ Yes     │ No      │ No      │");
        System.out.println("│ private     │ Yes     │ No      │ No      │ No      │");
        System.out.println("└─────────────┴─────────┴─────────┴─────────┴─────────┘");
        
        System.out.println("\nBest Practices:");
        System.out.println("• Make fields private by default");
        System.out.println("• Provide public getters and setters only when needed");
        System.out.println("• Validate input in setter methods");
        System.out.println("• Use meaningful names for getter and setter methods");
        System.out.println("• Consider making classes immutable when possible");
        System.out.println("• Use protected for fields that subclasses need to access");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Encapsulation bundles data and methods that operate on that data
 * 2. Data hiding protects object state from unauthorized access
 * 3. Access modifiers control the visibility of class members
 * 4. Getter and setter methods provide controlled access to private fields
 * 5. Validation in setters ensures data integrity
 * 
 * Access Modifiers:
 * - private: Accessible only within the same class
 * - (default): Accessible within the same package
 * - protected: Accessible within package and subclasses
 * - public: Accessible from anywhere
 * 
 * Benefits:
 * - Data security and integrity
 * - Code maintainability and flexibility
 * - Controlled access to object state
 * - Ability to change implementation without affecting users
 * - Better organization and structure
 * 
 * Best Practices:
 * - Make fields private by default
 * - Provide getters and setters only when necessary
 * - Validate input in setter methods
 * - Use meaningful method names
 * - Consider immutability for value objects
 * - Document access restrictions and requirements
 */
