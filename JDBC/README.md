# JDBC (Java Database Connectivity) 🗄️

JDBC is a Java API that enables Java applications to interact with databases. It provides a standard interface for connecting to and executing operations on various database management systems.

## What is JDBC?

JDBC (Java Database Connectivity) is a Java API that allows Java programs to execute SQL statements and interact with databases. It acts as a bridge between Java applications and databases, providing a uniform interface regardless of the underlying database system.

## JDBC Architecture

### **JDBC Components**
1. **JDBC API**: Application-to-JDBC Manager connection
2. **JDBC Driver Manager**: JDBC Manager-to-Driver connection
3. **JDBC Drivers**: Driver-to-Database connection
4. **Database**: The actual database system

### **JDBC Driver Types**
1. **Type 1 (JDBC-ODBC Bridge)**: Uses ODBC driver
2. **Type 2 (Native-API Driver)**: Partly Java, partly native code
3. **Type 3 (Network Protocol Driver)**: Pure Java, uses middleware
4. **Type 4 (Thin Driver)**: Pure Java, direct database connection

## Core JDBC Classes and Interfaces

### **Key Interfaces**
- **Driver**: Represents database driver
- **Connection**: Represents database connection
- **Statement**: Executes SQL statements
- **PreparedStatement**: Pre-compiled SQL statements
- **CallableStatement**: Executes stored procedures
- **ResultSet**: Represents query results

### **Key Classes**
- **DriverManager**: Manages database drivers
- **SQLException**: Handles database errors
- **Types**: SQL data type constants

## Topics Covered

### 1. **JDBCBasics.java** - JDBC fundamentals
- Database connection establishment
- Loading JDBC drivers
- Connection string formats
- Basic database operations

### 2. **CRUDOperations.java** - Database operations
- Create (INSERT) operations
- Read (SELECT) operations
- Update operations
- Delete operations

### 3. **PreparedStatements.java** - Secure SQL execution
- Parameterized queries
- SQL injection prevention
- Batch operations
- Performance optimization

### 4. **TransactionManagement.java** - Database transactions
- Transaction concepts (ACID properties)
- Commit and rollback operations
- Isolation levels
- Savepoints

### 5. **ConnectionPooling.java** - Connection management
- Connection pooling concepts
- HikariCP implementation
- Performance optimization
- Resource management

### 6. **DatabaseMetadata.java** - Database information
- Database metadata retrieval
- Table and column information
- Database capabilities
- Schema exploration

## Database Connection Process

### **Step 1: Load Driver**
```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

### **Step 2: Establish Connection**
```java
String url = "jdbc:mysql://localhost:3306/database_name";
String username = "user";
String password = "password";
Connection conn = DriverManager.getConnection(url, username, password);
```

### **Step 3: Create Statement**
```java
Statement stmt = conn.createStatement();
// or
PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
```

### **Step 4: Execute Query**
```java
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
// or
int rowsAffected = stmt.executeUpdate("INSERT INTO users VALUES (...)");
```

### **Step 5: Process Results**
```java
while (rs.next()) {
    String name = rs.getString("name");
    int age = rs.getInt("age");
    // Process data
}
```

### **Step 6: Close Resources**
```java
rs.close();
stmt.close();
conn.close();
```

## Common Database URLs

| Database | URL Format | Example |
|----------|------------|---------|
| **MySQL** | `jdbc:mysql://host:port/database` | `jdbc:mysql://localhost:3306/mydb` |
| **PostgreSQL** | `jdbc:postgresql://host:port/database` | `jdbc:postgresql://localhost:5432/mydb` |
| **Oracle** | `jdbc:oracle:thin:@host:port:sid` | `jdbc:oracle:thin:@localhost:1521:xe` |
| **SQL Server** | `jdbc:sqlserver://host:port;database=db` | `jdbc:sqlserver://localhost:1433;database=mydb` |
| **SQLite** | `jdbc:sqlite:path` | `jdbc:sqlite:C:/data/mydb.db` |
| **H2** | `jdbc:h2:path` | `jdbc:h2:~/test` |

## SQL Data Types and Java Mapping

| SQL Type | Java Type | ResultSet Method |
|----------|-----------|------------------|
| **VARCHAR** | String | getString() |
| **INT** | int | getInt() |
| **BIGINT** | long | getLong() |
| **DECIMAL** | BigDecimal | getBigDecimal() |
| **DOUBLE** | double | getDouble() |
| **BOOLEAN** | boolean | getBoolean() |
| **DATE** | java.sql.Date | getDate() |
| **TIMESTAMP** | java.sql.Timestamp | getTimestamp() |
| **BLOB** | byte[] | getBytes() |

## Best Practices

### **Connection Management**
1. **Use connection pooling**: For production applications
2. **Close resources**: Always close connections, statements, and result sets
3. **Use try-with-resources**: Automatic resource management
4. **Handle exceptions**: Proper error handling and logging

### **SQL Security**
1. **Use PreparedStatement**: Prevents SQL injection
2. **Validate inputs**: Check user inputs before database operations
3. **Limit privileges**: Use database users with minimal required permissions
4. **Encrypt connections**: Use SSL/TLS for database connections

### **Performance Optimization**
1. **Use batch operations**: For multiple similar operations
2. **Optimize queries**: Use indexes and efficient SQL
3. **Fetch size tuning**: Optimize ResultSet fetch size
4. **Connection reuse**: Use connection pooling

### **Error Handling**
```java
try (Connection conn = DriverManager.getConnection(url, user, password);
     PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
    // Database operations
    
} catch (SQLException e) {
    System.err.println("SQL Error: " + e.getMessage());
    System.err.println("SQL State: " + e.getSQLState());
    System.err.println("Error Code: " + e.getErrorCode());
}
```

## Transaction Management

### **ACID Properties**
- **Atomicity**: All operations succeed or all fail
- **Consistency**: Database remains in valid state
- **Isolation**: Concurrent transactions don't interfere
- **Durability**: Committed changes are permanent

### **Transaction Example**
```java
Connection conn = null;
try {
    conn = DriverManager.getConnection(url, user, password);
    conn.setAutoCommit(false); // Start transaction
    
    // Multiple database operations
    stmt1.executeUpdate("INSERT INTO accounts ...");
    stmt2.executeUpdate("UPDATE accounts ...");
    
    conn.commit(); // Commit transaction
    
} catch (SQLException e) {
    if (conn != null) {
        conn.rollback(); // Rollback on error
    }
} finally {
    if (conn != null) {
        conn.setAutoCommit(true); // Restore auto-commit
        conn.close();
    }
}
```

## Common JDBC Patterns

### **DAO (Data Access Object) Pattern**
```java
public interface UserDAO {
    void createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}
```

### **Repository Pattern**
```java
public class UserRepository {
    private DataSource dataSource;
    
    public User findById(Long id) {
        // Database access logic
    }
    
    public List<User> findAll() {
        // Database access logic
    }
}
```

## Modern Alternatives

### **JPA (Java Persistence API)**
- Object-Relational Mapping (ORM)
- Hibernate, EclipseLink implementations
- Annotation-based configuration
- Automatic SQL generation

### **Spring JDBC**
- JdbcTemplate for simplified JDBC
- Automatic resource management
- Exception translation
- Transaction management

### **MyBatis**
- SQL mapping framework
- XML or annotation configuration
- Custom SQL with object mapping
- Dynamic SQL generation

## Learning Progression

1. **Master JDBC basics** - Connection and simple queries
2. **Learn CRUD operations** - Complete database operations
3. **Practice PreparedStatement** - Secure and efficient SQL
4. **Understand transactions** - Data consistency and integrity
5. **Explore connection pooling** - Production-ready applications
6. **Study design patterns** - DAO and Repository patterns

## Real-World Applications

### **Web Applications**
- User authentication and authorization
- Content management systems
- E-commerce platforms
- Social media applications

### **Enterprise Systems**
- Customer relationship management (CRM)
- Enterprise resource planning (ERP)
- Financial systems
- Inventory management

### **Data Processing**
- ETL (Extract, Transform, Load) operations
- Data warehousing
- Reporting systems
- Analytics platforms

## Troubleshooting Common Issues

### **Connection Problems**
- Check database server status
- Verify connection URL and credentials
- Ensure JDBC driver is in classpath
- Check firewall and network settings

### **Performance Issues**
- Use connection pooling
- Optimize SQL queries
- Implement proper indexing
- Monitor database performance

### **Memory Issues**
- Close ResultSet and Statement objects
- Use appropriate fetch sizes
- Avoid loading large datasets into memory
- Implement pagination for large results

---
*JDBC is the foundation for Java database programming - master it for robust data-driven applications!*
