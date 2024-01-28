# File Input/Output in Java 📁

File I/O (Input/Output) operations allow Java programs to read from and write to files, enabling data persistence and communication with external systems.

## What is File I/O?

File I/O refers to the operations that read data from files or write data to files. Java provides comprehensive APIs for file operations through various classes in the `java.io` and `java.nio` packages.

## File I/O Concepts

### **Streams**
- **Byte Streams**: Handle binary data (images, videos, executables)
- **Character Streams**: Handle text data (documents, configuration files)

### **Direction**
- **Input Streams**: Read data from files
- **Output Streams**: Write data to files

### **Buffering**
- **Buffered**: Use internal buffer for efficiency
- **Unbuffered**: Direct read/write operations

## Java I/O Class Hierarchy

### **Byte Streams**
```
InputStream (Abstract)
├── FileInputStream - Read bytes from files
├── BufferedInputStream - Buffered byte input
└── DataInputStream - Read primitive data types

OutputStream (Abstract)
├── FileOutputStream - Write bytes to files
├── BufferedOutputStream - Buffered byte output
└── DataOutputStream - Write primitive data types
```

### **Character Streams**
```
Reader (Abstract)
├── FileReader - Read characters from files
├── BufferedReader - Buffered character input
└── InputStreamReader - Bridge from byte to character streams

Writer (Abstract)
├── FileWriter - Write characters to files
├── BufferedWriter - Buffered character output
└── OutputStreamWriter - Bridge from character to byte streams
```

## Topics Covered

### 1. **FileBasics.java** - File operations fundamentals
- File class for file/directory operations
- Creating, deleting, and checking file properties
- File paths and directory navigation
- File permissions and metadata

### 2. **TextFileIO.java** - Text file operations
- Reading and writing text files
- Character streams (FileReader, FileWriter)
- Buffered streams for efficiency
- Line-by-line file processing

### 3. **BinaryFileIO.java** - Binary file operations
- Reading and writing binary data
- Byte streams (FileInputStream, FileOutputStream)
- Handling different data types
- Working with images and binary files

### 4. **SerializationDemo.java** - Object serialization
- Converting objects to byte streams
- Serializable interface
- ObjectInputStream and ObjectOutputStream
- Versioning and compatibility

### 5. **NIOExample.java** - New I/O (NIO.2)
- Path and Files classes
- Modern file operations
- Walking directory trees
- File watching and monitoring

### 6. **FileUtilities.java** - Practical file utilities
- File copying and moving
- Directory operations
- File searching and filtering
- Backup and archiving utilities

## Common File Operations

### **File Creation and Deletion**
```java
File file = new File("example.txt");
file.createNewFile();  // Create file
file.delete();         // Delete file
```

### **Reading Text Files**
```java
BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
String line;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}
reader.close();
```

### **Writing Text Files**
```java
BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
writer.write("Hello, World!");
writer.newLine();
writer.close();
```

### **Try-with-Resources (Recommended)**
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

## File Paths

### **Absolute Paths**
- Complete path from root directory
- Windows: `C:\Users\username\Documents\file.txt`
- Unix/Linux: `/home/username/documents/file.txt`

### **Relative Paths**
- Path relative to current working directory
- `./file.txt` (current directory)
- `../file.txt` (parent directory)
- `folder/file.txt` (subdirectory)

### **Path Separators**
- Use `File.separator` for platform independence
- Or use forward slashes (Java converts automatically)

## Exception Handling

### **Common Exceptions**
- **FileNotFoundException**: File doesn't exist
- **IOException**: General I/O error
- **SecurityException**: Permission denied
- **IllegalArgumentException**: Invalid file path

### **Best Practices**
```java
try (FileReader reader = new FileReader("file.txt")) {
    // File operations
} catch (FileNotFoundException e) {
    System.err.println("File not found: " + e.getMessage());
} catch (IOException e) {
    System.err.println("I/O error: " + e.getMessage());
}
```

## Performance Considerations

### **Buffering**
- Use BufferedReader/BufferedWriter for text
- Use BufferedInputStream/BufferedOutputStream for binary
- Significantly improves performance for small, frequent operations

### **File Size**
- For large files, consider reading in chunks
- Use memory mapping for very large files (NIO)
- Monitor memory usage to prevent OutOfMemoryError

### **Resource Management**
- Always close streams to free resources
- Use try-with-resources for automatic cleanup
- Avoid resource leaks in long-running applications

## File Formats

### **Text Files**
- Plain text (.txt)
- CSV (Comma Separated Values)
- JSON (JavaScript Object Notation)
- XML (eXtensible Markup Language)
- Properties files

### **Binary Files**
- Images (.jpg, .png, .gif)
- Documents (.pdf, .doc)
- Executables (.exe, .jar)
- Serialized objects

## Security Considerations

### **File Permissions**
- Check read/write permissions before operations
- Handle SecurityException appropriately
- Validate file paths to prevent directory traversal attacks

### **Input Validation**
- Validate file names and paths
- Check file size limits
- Sanitize user-provided file paths

## Modern Java I/O (NIO.2)

### **Advantages of NIO.2**
- Better performance for large files
- More intuitive API
- Better error handling
- Support for file system events
- Atomic file operations

### **Key Classes**
- **Path**: Represents file system paths
- **Files**: Utility methods for file operations
- **Paths**: Factory methods for creating Path objects

## Learning Progression

1. **Master File class** - Basic file operations
2. **Learn text file I/O** - Reading and writing text
3. **Understand binary I/O** - Working with binary data
4. **Practice exception handling** - Robust error handling
5. **Explore serialization** - Object persistence
6. **Study NIO.2** - Modern file operations

## Real-World Applications

### **Configuration Management**
- Reading application settings
- Storing user preferences
- Environment configuration

### **Data Processing**
- Log file analysis
- CSV data import/export
- Report generation

### **Backup and Archiving**
- File synchronization
- Data backup utilities
- Archive creation

### **Content Management**
- Document storage
- Image processing
- File upload/download

## Best Practices

### **Resource Management**
1. **Always close streams**: Use try-with-resources
2. **Handle exceptions**: Provide meaningful error messages
3. **Use buffered streams**: For better performance
4. **Check file existence**: Before attempting operations

### **Performance**
1. **Choose appropriate buffer size**: Balance memory and performance
2. **Use NIO for large files**: Better performance characteristics
3. **Avoid frequent small operations**: Batch operations when possible
4. **Monitor memory usage**: Especially with large files

### **Security**
1. **Validate inputs**: Check file paths and names
2. **Handle permissions**: Check before attempting operations
3. **Limit file sizes**: Prevent resource exhaustion
4. **Use secure temporary files**: For sensitive data

---
*File I/O is essential for data persistence and system integration!*
