/**
 * FunctionalInterfaces.java - Working with Built-in and Custom Functional Interfaces
 * 
 * Learning Objectives:
 * - Master built-in functional interfaces (Predicate, Function, Consumer, Supplier)
 * - Learn to create custom functional interfaces
 * - Practice method references and lambda expressions
 * - Understand functional composition and chaining
 * - Apply functional programming patterns in real scenarios
 */

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    
    public static void main(String[] args) {
        
        System.out.println("=== Functional Interfaces in Java ===\n");
        
        // ========== BUILT-IN FUNCTIONAL INTERFACES ==========
        
        System.out.println("=== Built-in Functional Interfaces ===");
        demonstrateBuiltInInterfaces();
        
        // ========== CUSTOM FUNCTIONAL INTERFACES ==========
        
        System.out.println("\n=== Custom Functional Interfaces ===");
        demonstrateCustomInterfaces();
        
        // ========== METHOD REFERENCES ==========
        
        System.out.println("\n=== Method References ===");
        demonstrateMethodReferences();
        
        // ========== FUNCTIONAL COMPOSITION ==========
        
        System.out.println("\n=== Functional Composition ===");
        demonstrateFunctionalComposition();
    }
    
    /**
     * Demonstrate built-in functional interfaces
     */
    public static void demonstrateBuiltInInterfaces() {
        
        // PREDICATE<T> - takes T, returns boolean
        System.out.println("=== Predicate<T> - T -> boolean ===");
        
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<String> isLongWord = s -> s.length() > 5;
        
        List<Integer> numbers = Arrays.asList(-2, -1, 0, 1, 2, 3, 4, 5, 6);
        List<String> words = Arrays.asList("cat", "elephant", "dog", "butterfly", "ant");
        
        System.out.println("Numbers: " + numbers);
        System.out.println("Even numbers: " + filterList(numbers, isEven));
        System.out.println("Positive numbers: " + filterList(numbers, isPositive));
        System.out.println("Even AND positive: " + filterList(numbers, isEven.and(isPositive)));
        System.out.println("Even OR positive: " + filterList(numbers, isEven.or(isPositive)));
        System.out.println("NOT even (odd): " + filterList(numbers, isEven.negate()));
        
        System.out.println("\nWords: " + words);
        System.out.println("Long words: " + filterList(words, isLongWord));
        System.out.println();
        
        // FUNCTION<T, R> - takes T, returns R
        System.out.println("=== Function<T, R> - T -> R ===");
        
        Function<String, Integer> stringLength = String::length;
        Function<Integer, String> numberToString = Object::toString;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<Integer, Integer> square = n -> n * n;
        
        System.out.println("String lengths: " + mapList(words, stringLength));
        System.out.println("Numbers as strings: " + mapList(numbers, numberToString));
        System.out.println("Uppercase words: " + mapList(words, toUpperCase));
        System.out.println("Squared numbers: " + mapList(numbers, square));
        
        // Function composition
        Function<String, String> lengthThenString = stringLength.andThen(numberToString);
        System.out.println("Length then string: " + mapList(words, lengthThenString));
        System.out.println();
        
        // CONSUMER<T> - takes T, returns void
        System.out.println("=== Consumer<T> - T -> void ===");
        
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        Consumer<Integer> printSquare = n -> System.out.println(n + "² = " + (n * n));
        Consumer<String> printLength = s -> System.out.println(s + " has " + s.length() + " characters");
        
        System.out.println("Printing words in uppercase:");
        words.forEach(printUpperCase);
        
        System.out.println("\nPrinting squares:");
        Arrays.asList(1, 2, 3, 4, 5).forEach(printSquare);
        
        System.out.println("\nPrinting word lengths:");
        words.forEach(printLength);
        
        // Consumer chaining
        Consumer<String> printBoth = printUpperCase.andThen(printLength);
        System.out.println("\nChained consumers:");
        Arrays.asList("hello", "world").forEach(printBoth);
        System.out.println();
        
        // SUPPLIER<T> - takes nothing, returns T
        System.out.println("=== Supplier<T> - () -> T ===");
        
        Supplier<String> randomWord = () -> {
            String[] wordArray = {"apple", "banana", "cherry", "date"};
            return wordArray[new Random().nextInt(wordArray.length)];
        };
        
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);
        Supplier<Double> randomDouble = Math::random;
        Supplier<String> currentTime = () -> new Date().toString();
        
        System.out.println("Random word: " + randomWord.get());
        System.out.println("Random number: " + randomNumber.get());
        System.out.println("Random double: " + randomDouble.get());
        System.out.println("Current time: " + currentTime.get());
        
        // Generate list using supplier
        List<Integer> randomNumbers = generateList(randomNumber, 5);
        System.out.println("Generated random numbers: " + randomNumbers);
        System.out.println();
        
        // BIFUNCTION<T, U, R> - takes T and U, returns R
        System.out.println("=== BiFunction<T, U, R> - (T, U) -> R ===");
        
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
        
        System.out.println("5 + 3 = " + add.apply(5, 3));
        System.out.println("5 * 3 = " + multiply.apply(5, 3));
        System.out.println("Concat: " + concat.apply("Hello", "World"));
        System.out.println("Repeat: " + repeat.apply("Java", 3));
        System.out.println();
        
        // UNARYOPERATOR<T> and BINARYOPERATOR<T>
        System.out.println("=== UnaryOperator<T> and BinaryOperator<T> ===");
        
        UnaryOperator<String> addExclamation = s -> s + "!";
        UnaryOperator<Integer> doubleValue = n -> n * 2;
        
        BinaryOperator<Integer> max = Integer::max;
        BinaryOperator<String> longerString = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;
        
        System.out.println("Add exclamation: " + addExclamation.apply("Hello"));
        System.out.println("Double value: " + doubleValue.apply(21));
        System.out.println("Max of 5 and 8: " + max.apply(5, 8));
        System.out.println("Longer string: " + longerString.apply("cat", "elephant"));
    }
    
    // Helper methods for demonstrations
    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public static <T, R> List<R> mapList(List<T> list, Function<T, R> mapper) {
        return list.stream().map(mapper).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    public static <T> List<T> generateList(Supplier<T> supplier, int count) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(supplier.get());
        }
        return result;
    }
    
    /**
     * Demonstrate custom functional interfaces
     */
    public static void demonstrateCustomInterfaces() {
        System.out.println("Creating custom functional interfaces for specific use cases:");
        System.out.println();
        
        // Custom functional interfaces
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;
        
        System.out.println("Calculator operations:");
        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 * 5 = " + multiply.calculate(10, 5));
        System.out.println("10 - 5 = " + subtract.calculate(10, 5));
        System.out.println();
        
        // String processor
        StringProcessor toUpper = String::toUpperCase;
        StringProcessor reverse = s -> new StringBuilder(s).reverse().toString();
        StringProcessor addPrefix = s -> "PREFIX_" + s;
        
        String text = "hello";
        System.out.println("String processing:");
        System.out.println("Original: " + text);
        System.out.println("Upper: " + toUpper.process(text));
        System.out.println("Reverse: " + reverse.process(text));
        System.out.println("Add prefix: " + addPrefix.process(text));
        System.out.println();
        
        // Validator
        Validator<String> emailValidator = email -> email.contains("@") && email.contains(".");
        Validator<Integer> positiveValidator = n -> n > 0;
        Validator<String> lengthValidator = s -> s.length() >= 5;
        
        System.out.println("Validation examples:");
        System.out.println("'user@example.com' is valid email: " + emailValidator.isValid("user@example.com"));
        System.out.println("'invalid-email' is valid email: " + emailValidator.isValid("invalid-email"));
        System.out.println("42 is positive: " + positiveValidator.isValid(42));
        System.out.println("-5 is positive: " + positiveValidator.isValid(-5));
        System.out.println("'hello' has length >= 5: " + lengthValidator.isValid("hello"));
        System.out.println("'hi' has length >= 5: " + lengthValidator.isValid("hi"));
    }
    
    // Custom functional interfaces
    @FunctionalInterface
    interface Calculator {
        double calculate(double a, double b);
    }
    
    @FunctionalInterface
    interface StringProcessor {
        String process(String input);
    }
    
    @FunctionalInterface
    interface Validator<T> {
        boolean isValid(T value);
    }
    
    /**
     * Demonstrate method references
     */
    public static void demonstrateMethodReferences() {
        System.out.println("Method references provide concise syntax for lambda expressions:");
        System.out.println();
        
        List<String> words = Arrays.asList("apple", "Banana", "cherry", "Date");
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        
        // Static method reference
        System.out.println("=== Static Method References ===");
        
        // Lambda: s -> Integer.parseInt(s)
        // Method ref: Integer::parseInt
        List<String> numberStrings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> parsed = numberStrings.stream()
            .map(Integer::parseInt)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Parsed numbers: " + parsed);
        
        // Lambda: (a, b) -> Integer.compare(a, b)
        // Method ref: Integer::compare
        numbers.sort(Integer::compare);
        System.out.println("Sorted numbers: " + numbers);
        System.out.println();
        
        // Instance method reference
        System.out.println("=== Instance Method References ===");
        
        // Lambda: s -> s.toUpperCase()
        // Method ref: String::toUpperCase
        List<String> upperWords = words.stream()
            .map(String::toUpperCase)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Uppercase words: " + upperWords);
        
        // Lambda: s -> s.length()
        // Method ref: String::length
        List<Integer> lengths = words.stream()
            .map(String::length)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Word lengths: " + lengths);
        System.out.println();
        
        // Bound method reference
        System.out.println("=== Bound Method References ===");
        
        String prefix = "Hello, ";
        Function<String, String> greeter = prefix::concat;
        System.out.println("Greeting: " + greeter.apply("World"));
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> greetings = names.stream()
            .map(prefix::concat)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("Greetings: " + greetings);
        System.out.println();
        
        // Constructor reference
        System.out.println("=== Constructor References ===");
        
        // Lambda: () -> new ArrayList<>()
        // Method ref: ArrayList::new
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> newList = listSupplier.get();
        newList.add("Created with constructor reference");
        System.out.println("New list: " + newList);
        
        // Lambda: s -> new StringBuilder(s)
        // Method ref: StringBuilder::new
        Function<String, StringBuilder> sbCreator = StringBuilder::new;
        StringBuilder sb = sbCreator.apply("Hello");
        System.out.println("StringBuilder: " + sb.toString());
    }
    
    /**
     * Demonstrate functional composition
     */
    public static void demonstrateFunctionalComposition() {
        System.out.println("Functional composition allows combining simple functions into complex ones:");
        System.out.println();
        
        // Function composition
        System.out.println("=== Function Composition ===");
        
        Function<String, String> removeSpaces = s -> s.replace(" ", "");
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, Integer> getLength = String::length;
        
        // Compose functions using andThen
        Function<String, String> cleanAndUpper = removeSpaces.andThen(toUpperCase);
        Function<String, Integer> cleanUpperLength = removeSpaces.andThen(toUpperCase).andThen(getLength);
        
        String input = "Hello World";
        System.out.println("Input: '" + input + "'");
        System.out.println("Remove spaces: '" + removeSpaces.apply(input) + "'");
        System.out.println("Clean and upper: '" + cleanAndUpper.apply(input) + "'");
        System.out.println("Clean, upper, length: " + cleanUpperLength.apply(input));
        System.out.println();
        
        // Predicate composition
        System.out.println("=== Predicate Composition ===");
        
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isLarge = n -> n > 10;
        
        Predicate<Integer> isEvenAndPositive = isEven.and(isPositive);
        Predicate<Integer> isEvenOrLarge = isEven.or(isLarge);
        Predicate<Integer> isNotEven = isEven.negate();
        
        List<Integer> testNumbers = Arrays.asList(-4, -2, 0, 1, 2, 5, 8, 12, 15);
        
        System.out.println("Test numbers: " + testNumbers);
        System.out.println("Even AND positive: " + filterList(testNumbers, isEvenAndPositive));
        System.out.println("Even OR large: " + filterList(testNumbers, isEvenOrLarge));
        System.out.println("NOT even (odd): " + filterList(testNumbers, isNotEven));
        System.out.println();
        
        // Consumer composition
        System.out.println("=== Consumer Composition ===");
        
        Consumer<String> print = System.out::print;
        Consumer<String> printNewline = s -> System.out.println();
        Consumer<String> printWithNewline = print.andThen(printNewline);
        
        System.out.println("Composed consumer output:");
        Arrays.asList("Hello", "World", "Java").forEach(printWithNewline);
        
        System.out.println("\n=== Functional Interfaces completed! ===");
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Built-in Functional Interfaces:
 *    - Predicate<T>: T -> boolean (testing)
 *    - Function<T,R>: T -> R (transformation)
 *    - Consumer<T>: T -> void (side effects)
 *    - Supplier<T>: () -> T (generation)
 *    - UnaryOperator<T>: T -> T (same type transformation)
 *    - BinaryOperator<T>: (T,T) -> T (combining same types)
 * 
 * 2. Method References:
 *    - Static: ClassName::methodName
 *    - Instance: ClassName::methodName
 *    - Bound: object::methodName
 *    - Constructor: ClassName::new
 * 
 * 3. Functional Composition:
 *    - Function: andThen(), compose()
 *    - Predicate: and(), or(), negate()
 *    - Consumer: andThen()
 * 
 * 4. Custom Functional Interfaces:
 *    - Use @FunctionalInterface annotation
 *    - Must have exactly one abstract method
 *    - Can have default and static methods
 * 
 * 5. Best Practices:
 *    - Use built-in interfaces when possible
 *    - Prefer method references over lambdas when readable
 *    - Compose simple functions into complex ones
 *    - Use meaningful names for custom interfaces
 */
