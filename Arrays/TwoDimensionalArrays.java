/**
 * TwoDimensionalArrays.java - Understanding 2D Arrays and Matrix Operations
 * 
 * Learning Objectives:
 * - Understand 2D array structure and memory layout
 * - Learn matrix creation, initialization, and traversal
 * - Practice matrix operations (addition, multiplication, transpose)
 * - Implement common matrix algorithms
 * - Solve practical 2D array problems
 */

import java.util.Arrays;
import java.util.Random;

public class TwoDimensionalArrays {
    
    public static void main(String[] args) {
        
        System.out.println("=== Two-Dimensional Arrays and Matrix Operations ===\n");
        
        // ========== 2D ARRAY BASICS ==========
        
        System.out.println("=== 2D Array Basics ===");
        twoDArrayBasics();
        
        // ========== MATRIX OPERATIONS ==========
        
        System.out.println("\n=== Matrix Operations ===");
        matrixOperations();
        
        // ========== MATRIX ALGORITHMS ==========
        
        System.out.println("\n=== Matrix Algorithms ===");
        matrixAlgorithms();
        
        // ========== PRACTICAL PROBLEMS ==========
        
        System.out.println("\n=== Practical 2D Array Problems ===");
        practicalProblems();
        
        System.out.println("\n=== Two-Dimensional Arrays lesson completed! ===");
    }
    
    /**
     * Demonstrates 2D array creation, initialization, and basic operations
     */
    public static void twoDArrayBasics() {
        
        // Method 1: Declaration and initialization
        int[][] matrix1 = new int[3][4]; // 3 rows, 4 columns
        
        // Method 2: Declaration with values
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // Method 3: Jagged array (different column sizes)
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix2 (3x4):");
        printMatrix(matrix2);
        
        System.out.println("\nJagged Array:");
        printJaggedArray(jaggedArray);
        
        // Accessing elements
        System.out.println("\nAccessing elements:");
        System.out.println("matrix2[1][2] = " + matrix2[1][2]); // Row 1, Column 2
        System.out.println("Matrix dimensions: " + matrix2.length + " x " + matrix2[0].length);
        
        // Modifying elements
        matrix2[0][0] = 100;
        System.out.println("After modifying matrix2[0][0] to 100:");
        printMatrix(matrix2);
        
        // Filling matrix with values
        fillMatrix(matrix1, 5);
        System.out.println("\nMatrix1 filled with 5:");
        printMatrix(matrix1);
    }
    
    /**
     * Demonstrates various matrix operations
     */
    public static void matrixOperations() {
        
        // Create test matrices
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        System.out.println("Matrix A:");
        printMatrix(matrixA);
        
        System.out.println("\nMatrix B:");
        printMatrix(matrixB);
        
        // Matrix Addition
        int[][] sum = addMatrices(matrixA, matrixB);
        System.out.println("\nMatrix A + B:");
        printMatrix(sum);
        
        // Matrix Subtraction
        int[][] difference = subtractMatrices(matrixA, matrixB);
        System.out.println("\nMatrix A - B:");
        printMatrix(difference);
        
        // Matrix Transpose
        int[][] transpose = transposeMatrix(matrixA);
        System.out.println("\nTranspose of Matrix A:");
        printMatrix(transpose);
        
        // Matrix Multiplication
        int[][] matrixC = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        
        int[][] matrixD = {
            {7, 8, 9},
            {10, 11, 12}
        };
        
        System.out.println("\nMatrix C (3x2):");
        printMatrix(matrixC);
        
        System.out.println("\nMatrix D (2x3):");
        printMatrix(matrixD);
        
        int[][] product = multiplyMatrices(matrixC, matrixD);
        System.out.println("\nMatrix C × D:");
        printMatrix(product);
    }
    
    /**
     * Demonstrates matrix algorithms and special operations
     */
    public static void matrixAlgorithms() {
        
        // Create test matrices
        int[][] squareMatrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] identityMatrix = createIdentityMatrix(3);
        
        System.out.println("Square Matrix:");
        printMatrix(squareMatrix);
        
        System.out.println("\nIdentity Matrix (3x3):");
        printMatrix(identityMatrix);
        
        // Diagonal sum
        int primaryDiagonalSum = getPrimaryDiagonalSum(squareMatrix);
        int secondaryDiagonalSum = getSecondaryDiagonalSum(squareMatrix);
        
        System.out.println("\nPrimary diagonal sum: " + primaryDiagonalSum);
        System.out.println("Secondary diagonal sum: " + secondaryDiagonalSum);
        
        // Matrix rotation
        int[][] rotated90 = rotateMatrix90Clockwise(squareMatrix);
        System.out.println("\nMatrix rotated 90° clockwise:");
        printMatrix(rotated90);
        
        // Spiral traversal
        System.out.println("\nSpiral traversal:");
        spiralTraversal(squareMatrix);
        
        // Check if matrix is symmetric
        int[][] symmetricMatrix = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };
        
        System.out.println("\nSymmetric Matrix:");
        printMatrix(symmetricMatrix);
        System.out.println("Is symmetric: " + isSymmetric(symmetricMatrix));
        System.out.println("Original matrix is symmetric: " + isSymmetric(squareMatrix));
    }
    
    /**
     * Demonstrates practical 2D array problems
     */
    public static void practicalProblems() {
        
        // Problem 1: Find maximum element in matrix
        int[][] matrix = {
            {3, 7, 2, 9},
            {1, 4, 8, 5},
            {6, 12, 3, 7}
        };
        
        System.out.println("Matrix:");
        printMatrix(matrix);
        
        int[] maxInfo = findMaxElement(matrix);
        System.out.println("Maximum element: " + maxInfo[0] + 
                          " at position (" + maxInfo[1] + ", " + maxInfo[2] + ")");
        
        // Problem 2: Search element in sorted matrix
        int[][] sortedMatrix = {
            {1,  4,  7,  11},
            {2,  5,  8,  12},
            {3,  6,  9,  16}
        };
        
        System.out.println("\nSorted Matrix:");
        printMatrix(sortedMatrix);
        
        int target = 5;
        boolean found = searchInSortedMatrix(sortedMatrix, target);
        System.out.println("Element " + target + " found: " + found);
        
        // Problem 3: Sum of each row and column
        System.out.println("\nRow and Column Sums:");
        calculateRowColumnSums(matrix);
        
        // Problem 4: Pascal's Triangle
        System.out.println("\nPascal's Triangle (5 rows):");
        int[][] pascalTriangle = generatePascalTriangle(5);
        printPascalTriangle(pascalTriangle);
        
        // Problem 5: Matrix boundary traversal
        System.out.println("\nBoundary traversal:");
        boundaryTraversal(matrix);
    }
    
    // ========== UTILITY METHODS ==========
    
    /**
     * Prints a 2D matrix in formatted way
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
    }
    
    /**
     * Prints a jagged array
     */
    public static void printJaggedArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Fills matrix with a specific value
     */
    public static void fillMatrix(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value;
            }
        }
    }
    
    /**
     * Adds two matrices
     */
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    
    /**
     * Subtracts two matrices
     */
    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }
    
    /**
     * Transposes a matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    /**
     * Multiplies two matrices
     */
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        
        int[][] result = new int[rowsA][colsB];
        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    
    /**
     * Creates an identity matrix
     */
    public static int[][] createIdentityMatrix(int size) {
        int[][] identity = new int[size][size];
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }
    
    /**
     * Calculates primary diagonal sum
     */
    public static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    
    /**
     * Calculates secondary diagonal sum
     */
    public static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - 1 - i];
        }
        return sum;
    }
    
    /**
     * Rotates matrix 90 degrees clockwise
     */
    public static int[][] rotateMatrix90Clockwise(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }
    
    /**
     * Performs spiral traversal of matrix
     */
    public static void spiralTraversal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, bottom = rows - 1;
        int left = 0, right = cols - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            
            // Traverse left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }
            
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
    
    /**
     * Checks if matrix is symmetric
     */
    public static boolean isSymmetric(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Finds maximum element and its position
     */
    public static int[] findMaxElement(int[][] matrix) {
        int max = matrix[0][0];
        int maxRow = 0, maxCol = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return new int[]{max, maxRow, maxCol};
    }
    
    /**
     * Searches element in row-wise and column-wise sorted matrix
     */
    public static boolean searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    
    /**
     * Calculates sum of each row and column
     */
    public static void calculateRowColumnSums(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Row sums
        System.out.println("Row sums:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + i + ": " + rowSum);
        }
        
        // Column sums
        System.out.println("Column sums:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += matrix[i][j];
            }
            System.out.println("Column " + j + ": " + colSum);
        }
    }
    
    /**
     * Generates Pascal's Triangle
     */
    public static int[][] generatePascalTriangle(int rows) {
        int[][] triangle = new int[rows][];
        
        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1; // First element
            triangle[i][i] = 1; // Last element
            
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
        return triangle;
    }
    
    /**
     * Prints Pascal's Triangle in formatted way
     */
    public static void printPascalTriangle(int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            // Print spaces for alignment
            for (int k = 0; k < triangle.length - i - 1; k++) {
                System.out.print("  ");
            }
            
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.printf("%4d", triangle[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Performs boundary traversal of matrix
     */
    public static void boundaryTraversal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // First row
        for (int j = 0; j < cols; j++) {
            System.out.print(matrix[0][j] + " ");
        }
        
        // Last column (excluding first row)
        for (int i = 1; i < rows; i++) {
            System.out.print(matrix[i][cols-1] + " ");
        }
        
        // Last row (excluding last column, if more than one row)
        if (rows > 1) {
            for (int j = cols - 2; j >= 0; j--) {
                System.out.print(matrix[rows-1][j] + " ");
            }
        }
        
        // First column (excluding first and last row, if more than one column)
        if (cols > 1) {
            for (int i = rows - 2; i > 0; i--) {
                System.out.print(matrix[i][0] + " ");
            }
        }
        System.out.println();
    }
}

/*
 * Key Takeaways:
 * 
 * 1. 2D arrays are arrays of arrays - matrix[row][column]
 * 2. Memory layout is row-major order in Java
 * 3. Jagged arrays allow different row sizes
 * 4. Matrix operations require compatible dimensions
 * 5. Many algorithms use nested loops for traversal
 * 
 * Common 2D Array Patterns:
 * - Row-wise traversal: for(int i=0; i<rows; i++) for(int j=0; j<cols; j++)
 * - Column-wise traversal: for(int j=0; j<cols; j++) for(int i=0; i<rows; i++)
 * - Diagonal traversal: matrix[i][i] and matrix[i][n-1-i]
 * - Spiral traversal: Use four boundaries (top, bottom, left, right)
 * 
 * Matrix Operations Complexity:
 * - Addition/Subtraction: O(m×n)
 * - Multiplication: O(m×n×p) for m×n and n×p matrices
 * - Transpose: O(m×n)
 * - Search in sorted matrix: O(m+n)
 * 
 * Real-world Applications:
 * - Image processing (pixels as 2D array)
 * - Game boards (chess, tic-tac-toe)
 * - Spreadsheet calculations
 * - Graph adjacency matrices
 * - Dynamic programming tables
 */
