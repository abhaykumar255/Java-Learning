/**
 * HelloWorld.java - My first Java program!
 * 
 * Learning Objectives:
 * - Understand basic Java program structure
 * - Learn about the main() method
 * - Practice using System.out.println()
 * 
 * Key Concepts:
 * - Every Java program must have a main() method
 * - Java is case-sensitive (HelloWorld vs helloworld)
 * - Statements end with semicolons (;)
 * - Code blocks are enclosed in curly braces {}
 */

public class HelloWorld {
    
    /**
     * The main method - entry point of every Java program
     * 
     * Why 'public'? - So JVM can access it from anywhere
     * Why 'static'? - So JVM can call it without creating an object
     * Why 'void'? - It doesn't return any value
     * Why 'String[] args'? - To accept command line arguments
     */
    public static void main(String[] args) {
        
        // This is a single-line comment
        // println() prints text and moves to next line
        System.out.println("Hello, World!");
        System.out.println("Welcome to Java Learning!");
        
        /*
         * This is a multi-line comment
         * You can write multiple lines here
         * Useful for longer explanations
         */
        
        // Let's print some more messages
        System.out.println("Java is fun to learn!");
        System.out.println("Let's master programming step by step.");
        
        // print() vs println() - what's the difference?
        System.out.print("This doesn't move to next line. ");
        System.out.print("See? Same line! ");
        System.out.println("Now we move to next line.");
        
        // We can also print numbers and calculations
        System.out.println("2 + 3 = " + (2 + 3));
        System.out.println("Current year: " + 2024);
        
        // Escape sequences - special characters
        System.out.println("Quote: \"Learning Java is awesome!\"");
        System.out.println("New line example:\nThis is on a new line");
        System.out.println("Tab example:\tThis is tabbed");
        
        System.out.println("\n=== Program completed successfully! ===");
    }
}

/*
 * Compilation and Execution:
 * 1. Save this file as HelloWorld.java (filename must match class name)
 * 2. Compile: javac HelloWorld.java (creates HelloWorld.class)
 * 3. Run: java HelloWorld
 * 
 * Remember: Java is compiled to bytecode, then interpreted by JVM
 */
