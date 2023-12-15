/**
 * Stack.java - Implementation of Stack Data Structure
 * 
 * Learning Objectives:
 * - Understand Stack data structure and LIFO principle
 * - Implement Stack using arrays and linked lists
 * - Learn stack operations: push, pop, peek, isEmpty
 * - Practice stack applications and real-world use cases
 * - Understand stack overflow and underflow conditions
 */

import java.util.EmptyStackException;
import java.util.Arrays;

/**
 * Array-based Stack implementation
 */
class ArrayStack<T> {
    private Object[] stack;
    private int top;
    private int capacity;
    
    // Constructor with default capacity
    public ArrayStack() {
        this(10);
    }
    
    // Constructor with specified capacity
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Object[capacity];
        this.top = -1;
    }
    
    /**
     * Push element onto stack
     * Time Complexity: O(1)
     */
    public void push(T item) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow: Cannot push to full stack");
        }
        stack[++top] = item;
        System.out.println("Pushed: " + item);
    }
    
    /**
     * Pop element from stack
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) stack[top];
        stack[top--] = null; // Help GC
        System.out.println("Popped: " + item);
        return item;
    }
    
    /**
     * Peek at top element without removing
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) stack[top];
    }
    
    /**
     * Check if stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Check if stack is full
     */
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    /**
     * Get current size of stack
     */
    public int size() {
        return top + 1;
    }
    
    /**
     * Display stack contents
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

/**
 * Node class for linked list implementation
 */
class StackNode<T> {
    T data;
    StackNode<T> next;
    
    public StackNode(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Linked List-based Stack implementation
 */
class LinkedStack<T> {
    private StackNode<T> top;
    private int size;
    
    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }
    
    /**
     * Push element onto stack
     * Time Complexity: O(1)
     */
    public void push(T item) {
        StackNode<T> newNode = new StackNode<>(item);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Pushed: " + item);
    }
    
    /**
     * Pop element from stack
     * Time Complexity: O(1)
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        size--;
        System.out.println("Popped: " + item);
        return item;
    }
    
    /**
     * Peek at top element
     * Time Complexity: O(1)
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }
    
    /**
     * Check if stack is empty
     */
    public boolean isEmpty() {
        return top == null;
    }
    
    /**
     * Get current size
     */
    public int size() {
        return size;
    }
    
    /**
     * Display stack contents
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        StackNode<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Stack {
    
    public static void main(String[] args) {
        
        System.out.println("=== Stack Data Structure Implementation ===\n");
        
        // ========== ARRAY-BASED STACK ==========
        
        System.out.println("=== Array-based Stack ===");
        arrayStackDemo();
        
        // ========== LINKED LIST-BASED STACK ==========
        
        System.out.println("\n=== Linked List-based Stack ===");
        linkedStackDemo();
        
        // ========== STACK APPLICATIONS ==========
        
        System.out.println("\n=== Stack Applications ===");
        stackApplications();
        
        // ========== EXPRESSION EVALUATION ==========
        
        System.out.println("\n=== Expression Evaluation ===");
        expressionEvaluation();
        
        System.out.println("\n=== Stack lesson completed! ===");
    }
    
    /**
     * Demonstrates array-based stack operations
     */
    public static void arrayStackDemo() {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        
        System.out.println("Creating array stack with capacity 5");
        System.out.println("Is empty: " + stack.isEmpty());
        
        // Push operations
        System.out.println("\nPushing elements:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        
        // Peek operation
        System.out.println("\nPeek top element: " + stack.peek());
        System.out.println("Size: " + stack.size());
        
        // Pop operations
        System.out.println("\nPopping elements:");
        stack.pop();
        stack.pop();
        stack.display();
        
        // Fill stack to capacity
        System.out.println("\nFilling stack to capacity:");
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.display();
        System.out.println("Is full: " + stack.isFull());
        
        // Try to overflow
        try {
            stack.push(80);
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        // Empty the stack
        System.out.println("\nEmptying the stack:");
        while (!stack.isEmpty()) {
            stack.pop();
        }
        
        // Try to underflow
        try {
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Exception caught: EmptyStackException");
        }
    }
    
    /**
     * Demonstrates linked list-based stack operations
     */
    public static void linkedStackDemo() {
        LinkedStack<String> stack = new LinkedStack<>();
        
        System.out.println("Creating linked list stack");
        System.out.println("Is empty: " + stack.isEmpty());
        
        // Push operations
        System.out.println("\nPushing elements:");
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.display();
        
        // Peek and size
        System.out.println("\nPeek top element: " + stack.peek());
        System.out.println("Size: " + stack.size());
        
        // Pop operations
        System.out.println("\nPopping elements:");
        stack.pop();
        stack.display();
        
        // Add more elements
        System.out.println("\nAdding more elements:");
        stack.push("Fourth");
        stack.push("Fifth");
        stack.push("Sixth");
        stack.display();
        
        // Clear stack
        System.out.println("\nClearing stack:");
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println("Final size: " + stack.size());
    }
    
    /**
     * Demonstrates practical stack applications
     */
    public static void stackApplications() {
        
        // Application 1: Parentheses matching
        System.out.println("=== Application 1: Parentheses Matching ===");
        String[] expressions = {
            "(a + b) * (c - d)",
            "((a + b) * c",
            "a + b) * c",
            "{[a + b] * (c - d)}",
            "{[a + b} * (c - d)]"
        };
        
        for (String expr : expressions) {
            boolean isValid = isValidParentheses(expr);
            System.out.println("\"" + expr + "\" -> " + (isValid ? "Valid" : "Invalid"));
        }
        
        // Application 2: Reverse string
        System.out.println("\n=== Application 2: Reverse String ===");
        String original = "Hello World";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
        
        // Application 3: Undo operations
        System.out.println("\n=== Application 3: Undo Operations ===");
        undoOperationsDemo();
        
        // Application 4: Function call simulation
        System.out.println("\n=== Application 4: Function Call Stack ===");
        functionCallDemo();
    }
    
    /**
     * Checks if parentheses in expression are balanced
     */
    public static boolean isValidParentheses(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>();
        
        for (char ch : expression.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    /**
     * Helper method to check if brackets match
     */
    public static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '[' && closing == ']') ||
               (opening == '{' && closing == '}');
    }
    
    /**
     * Reverses a string using stack
     */
    public static String reverseString(String str) {
        ArrayStack<Character> stack = new ArrayStack<>();
        
        // Push all characters onto stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        
        // Pop all characters to build reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
    
    /**
     * Demonstrates undo operations using stack
     */
    public static void undoOperationsDemo() {
        ArrayStack<String> undoStack = new ArrayStack<>();
        
        // Simulate text editing operations
        String[] operations = {
            "Type 'Hello'",
            "Type ' World'",
            "Delete 'World'",
            "Type ' Java'",
            "Type ' Programming'"
        };
        
        System.out.println("Performing operations:");
        for (String operation : operations) {
            undoStack.push(operation);
            System.out.println("Operation: " + operation);
        }
        
        System.out.println("\nUndo operations:");
        while (!undoStack.isEmpty()) {
            String lastOperation = undoStack.pop();
            System.out.println("Undoing: " + lastOperation);
        }
    }
    
    /**
     * Simulates function call stack
     */
    public static void functionCallDemo() {
        ArrayStack<String> callStack = new ArrayStack<>();
        
        System.out.println("Simulating function calls:");
        
        // Simulate nested function calls
        callStack.push("main()");
        System.out.println("Called: main()");
        
        callStack.push("functionA()");
        System.out.println("Called: functionA()");
        
        callStack.push("functionB()");
        System.out.println("Called: functionB()");
        
        callStack.push("functionC()");
        System.out.println("Called: functionC()");
        
        System.out.println("\nCurrent call stack:");
        callStack.display();
        
        System.out.println("\nFunctions returning:");
        while (!callStack.isEmpty()) {
            String function = callStack.pop();
            System.out.println("Returning from: " + function);
        }
    }
    
    /**
     * Demonstrates expression evaluation using stacks
     */
    public static void expressionEvaluation() {
        
        // Postfix expression evaluation
        System.out.println("=== Postfix Expression Evaluation ===");
        String[] postfixExpressions = {
            "2 3 + 4 *",      // (2 + 3) * 4 = 20
            "5 2 - 3 *",      // (5 - 2) * 3 = 9
            "1 2 + 3 4 + *"   // (1 + 2) * (3 + 4) = 21
        };
        
        for (String expr : postfixExpressions) {
            int result = evaluatePostfix(expr);
            System.out.println("\"" + expr + "\" = " + result);
        }
        
        // Infix to postfix conversion
        System.out.println("\n=== Infix to Postfix Conversion ===");
        String[] infixExpressions = {
            "2 + 3 * 4",
            "(2 + 3) * 4",
            "a + b * c - d"
        };
        
        for (String expr : infixExpressions) {
            String postfix = infixToPostfix(expr);
            System.out.println("Infix: \"" + expr + "\" -> Postfix: \"" + postfix + "\"");
        }
    }
    
    /**
     * Evaluates postfix expression
     */
    public static int evaluatePostfix(String expression) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token.charAt(0));
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    /**
     * Converts infix expression to postfix
     */
    public static String infixToPostfix(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>();
        StringBuilder postfix = new StringBuilder();
        
        for (char ch : expression.toCharArray()) {
            if (ch == ' ') continue;
            
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch).append(" ");
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Remove '('
            } else if (isOperator(String.valueOf(ch))) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        
        return postfix.toString().trim();
    }
    
    /**
     * Helper methods for expression evaluation
     */
    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    public static int performOperation(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            default: return 0;
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Stack follows LIFO (Last In, First Out) principle
 * 2. Main operations: push, pop, peek, isEmpty
 * 3. Can be implemented using arrays or linked lists
 * 4. Array implementation has fixed size, linked list is dynamic
 * 5. All basic operations have O(1) time complexity
 * 
 * Stack Applications:
 * - Function call management
 * - Expression evaluation and conversion
 * - Parentheses matching
 * - Undo operations in applications
 * - Browser back button functionality
 * - Depth-First Search (DFS) in graphs
 * 
 * Implementation Comparison:
 * Array-based:
 * + Fixed memory usage
 * + Better cache locality
 * - Fixed size limitation
 * - Memory waste if not full
 * 
 * Linked List-based:
 * + Dynamic size
 * + No memory waste
 * - Extra memory for pointers
 * - Poor cache locality
 * 
 * Common Stack Problems:
 * - Stack Overflow: Pushing to full stack
 * - Stack Underflow: Popping from empty stack
 * - Memory management in linked implementation
 * 
 * Best Practices:
 * - Always check if stack is empty before pop/peek
 * - Handle stack overflow in array implementation
 * - Use appropriate implementation based on requirements
 * - Consider using built-in Stack class for production code
 */
