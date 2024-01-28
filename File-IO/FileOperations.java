/**
 * FileOperations.java - File Input/Output Operations in Java
 * 
 * Learning Objectives:
 * - Understand Java I/O streams and file handling
 * - Learn different ways to read and write files
 * - Practice file operations: create, read, write, delete
 * - Master try-with-resources for automatic resource management
 * - Understand character vs byte streams
 */

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileOperations {
    
    // Constants for file paths
    private static final String SAMPLE_FILE = "sample.txt";
    private static final String OUTPUT_FILE = "output.txt";
    private static final String BINARY_FILE = "data.bin";
    private static final String CSV_FILE = "students.csv";
    
    public static void main(String[] args) {
        
        System.out.println("=== File I/O Operations in Java ===\n");
        
        // ========== BASIC FILE OPERATIONS ==========
        
        System.out.println("=== Basic File Operations ===");
        basicFileOperations();
        
        // ========== CHARACTER STREAMS ==========
        
        System.out.println("\n=== Character Streams (Text Files) ===");
        characterStreamOperations();
        
        // ========== BYTE STREAMS ==========
        
        System.out.println("\n=== Byte Streams (Binary Files) ===");
        byteStreamOperations();
        
        // ========== NIO.2 FILE OPERATIONS ==========
        
        System.out.println("\n=== NIO.2 File Operations ===");
        nioFileOperations();
        
        // ========== PRACTICAL EXAMPLES ==========
        
        System.out.println("\n=== Practical File Processing Examples ===");
        practicalExamples();
        
        // ========== CLEANUP ==========
        
        System.out.println("\n=== Cleanup ===");
        cleanup();
        
        System.out.println("\n=== File Operations lesson completed! ===");
    }
    
    /**
     * Demonstrates basic file operations
     */
    public static void basicFileOperations() {
        
        // Create File object
        File file = new File(SAMPLE_FILE);
        
        System.out.println("File operations with File class:");
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Parent directory: " + file.getParent());
        System.out.println("File exists: " + file.exists());
        
        try {
            // Create new file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
            
            // File properties
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
            System.out.println("File size: " + file.length() + " bytes");
            System.out.println("Last modified: " + new Date(file.lastModified()));
            
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
        
        // Directory operations
        System.out.println("\n--- Directory Operations ---");
        File directory = new File("test_directory");
        
        if (directory.mkdir()) {
            System.out.println("Directory created: " + directory.getName());
        } else {
            System.out.println("Directory already exists or couldn't be created");
        }
        
        // List files in current directory
        File currentDir = new File(".");
        String[] files = currentDir.list();
        System.out.println("Files in current directory:");
        if (files != null) {
            for (String fileName : files) {
                System.out.println("  " + fileName);
            }
        }
    }
    
    /**
     * Demonstrates character stream operations for text files
     */
    public static void characterStreamOperations() {
        
        // Writing to file using FileWriter
        System.out.println("--- Writing with FileWriter ---");
        try (FileWriter writer = new FileWriter(SAMPLE_FILE)) {
            writer.write("Hello, World!\n");
            writer.write("This is a sample text file.\n");
            writer.write("Java File I/O operations.\n");
            writer.write("Character encoding: UTF-8\n");
            System.out.println("Successfully wrote to file using FileWriter");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
        
        // Reading from file using FileReader
        System.out.println("\n--- Reading with FileReader ---");
        try (FileReader reader = new FileReader(SAMPLE_FILE)) {
            int character;
            StringBuilder content = new StringBuilder();
            
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            
            System.out.println("File content:");
            System.out.println(content.toString());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        // Writing with BufferedWriter (more efficient)
        System.out.println("\n--- Writing with BufferedWriter ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write("Line 1: BufferedWriter example");
            writer.newLine();
            writer.write("Line 2: More efficient for large files");
            writer.newLine();
            writer.write("Line 3: Automatic buffering");
            writer.newLine();
            System.out.println("Successfully wrote to file using BufferedWriter");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
        
        // Reading with BufferedReader (more efficient)
        System.out.println("\n--- Reading with BufferedReader ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE))) {
            String line;
            int lineNumber = 1;
            
            System.out.println("File content (line by line):");
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        // Appending to file
        System.out.println("\n--- Appending to File ---");
        try (FileWriter writer = new FileWriter(OUTPUT_FILE, true)) { // true for append mode
            writer.write("Line 4: Appended content\n");
            writer.write("Line 5: File append operation\n");
            System.out.println("Successfully appended to file");
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates byte stream operations for binary files
     */
    public static void byteStreamOperations() {
        
        // Writing binary data using FileOutputStream
        System.out.println("--- Writing Binary Data ---");
        try (FileOutputStream fos = new FileOutputStream(BINARY_FILE);
             DataOutputStream dos = new DataOutputStream(fos)) {
            
            // Write different data types
            dos.writeInt(42);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Binary file example");
            dos.writeLong(System.currentTimeMillis());
            
            System.out.println("Successfully wrote binary data to file");
        } catch (IOException e) {
            System.err.println("Error writing binary file: " + e.getMessage());
        }
        
        // Reading binary data using FileInputStream
        System.out.println("\n--- Reading Binary Data ---");
        try (FileInputStream fis = new FileInputStream(BINARY_FILE);
             DataInputStream dis = new DataInputStream(fis)) {
            
            // Read data in the same order it was written
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String stringValue = dis.readUTF();
            long longValue = dis.readLong();
            
            System.out.println("Read binary data:");
            System.out.println("Integer: " + intValue);
            System.out.println("Double: " + doubleValue);
            System.out.println("Boolean: " + booleanValue);
            System.out.println("String: " + stringValue);
            System.out.println("Long: " + longValue);
            System.out.println("Timestamp: " + new Date(longValue));
            
        } catch (IOException e) {
            System.err.println("Error reading binary file: " + e.getMessage());
        }
        
        // Copying files using byte streams
        System.out.println("\n--- File Copying ---");
        String sourceFile = SAMPLE_FILE;
        String destinationFile = "copy_" + SAMPLE_FILE;
        
        try (FileInputStream source = new FileInputStream(sourceFile);
             FileOutputStream destination = new FileOutputStream(destinationFile)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = source.read(buffer)) != -1) {
                destination.write(buffer, 0, bytesRead);
            }
            
            System.out.println("File copied successfully: " + sourceFile + " -> " + destinationFile);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates NIO.2 file operations (Java 7+)
     */
    public static void nioFileOperations() {
        
        Path filePath = Paths.get("nio_example.txt");
        
        // Writing using NIO.2
        System.out.println("--- NIO.2 Writing ---");
        try {
            List<String> lines = Arrays.asList(
                "NIO.2 File Operations",
                "More modern approach to file I/O",
                "Better error handling",
                "Path-based operations"
            );
            
            Files.write(filePath, lines, StandardCharsets.UTF_8);
            System.out.println("Successfully wrote file using NIO.2");
        } catch (IOException e) {
            System.err.println("Error writing file with NIO.2: " + e.getMessage());
        }
        
        // Reading using NIO.2
        System.out.println("\n--- NIO.2 Reading ---");
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            System.out.println("File content:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + ": " + lines.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error reading file with NIO.2: " + e.getMessage());
        }
        
        // File attributes
        System.out.println("\n--- File Attributes ---");
        try {
            if (Files.exists(filePath)) {
                System.out.println("File size: " + Files.size(filePath) + " bytes");
                System.out.println("Is regular file: " + Files.isRegularFile(filePath));
                System.out.println("Is readable: " + Files.isReadable(filePath));
                System.out.println("Is writable: " + Files.isWritable(filePath));
                System.out.println("Last modified: " + Files.getLastModifiedTime(filePath));
            }
        } catch (IOException e) {
            System.err.println("Error getting file attributes: " + e.getMessage());
        }
        
        // Moving/renaming file
        System.out.println("\n--- Moving/Renaming File ---");
        Path newPath = Paths.get("renamed_nio_example.txt");
        try {
            Files.move(filePath, newPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File moved/renamed successfully");
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
        }
        
        // Delete file
        try {
            Files.deleteIfExists(newPath);
            System.out.println("File deleted successfully");
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
    
    /**
     * Demonstrates practical file processing examples
     */
    public static void practicalExamples() {
        
        // Example 1: CSV file processing
        System.out.println("=== Example 1: CSV File Processing ===");
        csvFileExample();
        
        // Example 2: Log file analysis
        System.out.println("\n=== Example 2: Log File Analysis ===");
        logFileExample();
        
        // Example 3: Configuration file handling
        System.out.println("\n=== Example 3: Configuration File ===");
        configFileExample();
        
        // Example 4: Word count in text file
        System.out.println("\n=== Example 4: Word Count ===");
        wordCountExample();
    }
    
    /**
     * CSV file processing example
     */
    public static void csvFileExample() {
        
        // Create sample CSV data
        List<String> csvData = Arrays.asList(
            "Name,Age,Grade,Subject",
            "Alice,20,A,Computer Science",
            "Bob,19,B,Mathematics",
            "Charlie,21,A,Physics",
            "Diana,20,B,Chemistry"
        );
        
        // Write CSV file
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
            for (String line : csvData) {
                writer.println(line);
            }
            System.out.println("CSV file created successfully");
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
            return;
        }
        
        // Read and parse CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean isHeader = true;
            
            System.out.println("CSV file content:");
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                
                if (isHeader) {
                    System.out.println("Headers: " + Arrays.toString(fields));
                    isHeader = false;
                } else {
                    System.out.printf("Student: %s, Age: %s, Grade: %s, Subject: %s%n",
                                    fields[0], fields[1], fields[2], fields[3]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
    
    /**
     * Log file analysis example
     */
    public static void logFileExample() {
        String logFile = "application.log";
        
        // Create sample log file
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile))) {
            writer.println("2024-01-03 10:15:30 INFO Application started");
            writer.println("2024-01-03 10:15:35 DEBUG Loading configuration");
            writer.println("2024-01-03 10:15:40 INFO Database connection established");
            writer.println("2024-01-03 10:16:00 WARN High memory usage detected");
            writer.println("2024-01-03 10:16:15 ERROR Failed to process request");
            writer.println("2024-01-03 10:16:20 INFO Request processed successfully");
            writer.println("2024-01-03 10:16:30 ERROR Database connection lost");
            System.out.println("Log file created");
        } catch (IOException e) {
            System.err.println("Error creating log file: " + e.getMessage());
            return;
        }
        
        // Analyze log file
        Map<String, Integer> logLevels = new HashMap<>();
        int totalLines = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                totalLines++;
                
                // Extract log level
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String level = parts[2];
                    logLevels.put(level, logLevels.getOrDefault(level, 0) + 1);
                }
            }
            
            System.out.println("Log analysis results:");
            System.out.println("Total log entries: " + totalLines);
            System.out.println("Log level distribution:");
            logLevels.forEach((level, count) -> 
                System.out.println("  " + level + ": " + count));
                
        } catch (IOException e) {
            System.err.println("Error analyzing log file: " + e.getMessage());
        }
        
        // Clean up
        new File(logFile).delete();
    }
    
    /**
     * Configuration file handling example
     */
    public static void configFileExample() {
        String configFile = "app.properties";
        
        // Create configuration file
        Properties config = new Properties();
        config.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
        config.setProperty("database.username", "admin");
        config.setProperty("database.password", "secret");
        config.setProperty("app.name", "MyApplication");
        config.setProperty("app.version", "1.0.0");
        config.setProperty("logging.level", "INFO");
        
        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            config.store(fos, "Application Configuration");
            System.out.println("Configuration file created");
        } catch (IOException e) {
            System.err.println("Error creating config file: " + e.getMessage());
            return;
        }
        
        // Read configuration file
        Properties loadedConfig = new Properties();
        try (FileInputStream fis = new FileInputStream(configFile)) {
            loadedConfig.load(fis);
            
            System.out.println("Configuration loaded:");
            loadedConfig.forEach((key, value) -> 
                System.out.println("  " + key + " = " + value));
                
        } catch (IOException e) {
            System.err.println("Error loading config file: " + e.getMessage());
        }
        
        // Clean up
        new File(configFile).delete();
    }
    
    /**
     * Word count example
     */
    public static void wordCountExample() {
        
        // Use existing sample file for word count
        try (BufferedReader reader = new BufferedReader(new FileReader(SAMPLE_FILE))) {
            Map<String, Integer> wordCount = new HashMap<>();
            String line;
            int totalWords = 0;
            int totalLines = 0;
            int totalChars = 0;
            
            while ((line = reader.readLine()) != null) {
                totalLines++;
                totalChars += line.length();
                
                // Split line into words and count
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalWords++;
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            System.out.println("Word count analysis:");
            System.out.println("Total lines: " + totalLines);
            System.out.println("Total characters: " + totalChars);
            System.out.println("Total words: " + totalWords);
            System.out.println("Unique words: " + wordCount.size());
            
            System.out.println("\nMost frequent words:");
            wordCount.entrySet().stream()
                     .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                     .limit(5)
                     .forEach(entry -> System.out.println("  " + entry.getKey() + ": " + entry.getValue()));
                     
        } catch (IOException e) {
            System.err.println("Error analyzing file: " + e.getMessage());
        }
    }
    
    /**
     * Clean up created files
     */
    public static void cleanup() {
        String[] filesToDelete = {
            SAMPLE_FILE, OUTPUT_FILE, BINARY_FILE, CSV_FILE, 
            "copy_" + SAMPLE_FILE, "test_directory"
        };
        
        for (String fileName : filesToDelete) {
            File file = new File(fileName);
            if (file.exists()) {
                if (file.isDirectory()) {
                    file.delete(); // Only works if directory is empty
                } else {
                    file.delete();
                }
                System.out.println("Deleted: " + fileName);
            }
        }
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Java provides multiple ways to handle file I/O operations
 * 2. Character streams (Reader/Writer) are for text files
 * 3. Byte streams (InputStream/OutputStream) are for binary files
 * 4. Buffered streams improve performance for large files
 * 5. Try-with-resources ensures automatic resource cleanup
 * 6. NIO.2 provides modern, path-based file operations
 * 
 * Stream Types:
 * Character Streams:
 * - FileReader/FileWriter: Basic text file operations
 * - BufferedReader/BufferedWriter: Efficient text processing
 * - PrintWriter: Convenient text output with formatting
 * 
 * Byte Streams:
 * - FileInputStream/FileOutputStream: Basic binary operations
 * - DataInputStream/DataOutputStream: Typed data operations
 * - BufferedInputStream/BufferedOutputStream: Efficient binary processing
 * 
 * NIO.2 Features:
 * - Path-based operations
 * - Better error handling
 * - Atomic file operations
 * - File attributes and metadata
 * - Directory traversal
 * 
 * Best Practices:
 * - Always use try-with-resources for automatic cleanup
 * - Choose appropriate stream type for your data
 * - Use buffered streams for better performance
 * - Handle IOException properly
 * - Close resources in finally block if not using try-with-resources
 * - Consider character encoding for text files
 * 
 * Common Use Cases:
 * - Configuration file management
 * - Log file processing and analysis
 * - CSV data import/export
 * - Binary data serialization
 * - File copying and backup operations
 * - Text processing and analysis
 */
