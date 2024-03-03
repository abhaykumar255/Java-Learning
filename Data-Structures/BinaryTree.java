/**
 * BinaryTree.java - Binary Tree Implementation and Operations
 * 
 * Learning Objectives:
 * - Understand binary tree structure and properties
 * - Implement binary tree with insertion and traversal methods
 * - Learn different tree traversal techniques (DFS and BFS)
 * - Practice tree operations: search, height, size calculations
 * - Understand binary search tree properties and operations
 */

import java.util.*;

/**
 * TreeNode class representing a node in binary tree
 */
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

/**
 * Binary Tree implementation
 */
class BinaryTree {
    TreeNode root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(int rootData) {
        this.root = new TreeNode(rootData);
    }
    
    // ========== TREE TRAVERSALS ==========
    
    /**
     * Inorder traversal (Left, Root, Right)
     * For BST, this gives sorted order
     */
    public void inorderTraversal() {
        System.out.print("Inorder: ");
        inorderHelper(root);
        System.out.println();
    }
    
    private void inorderHelper(TreeNode node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(node.data + " ");
            inorderHelper(node.right);
        }
    }
    
    /**
     * Preorder traversal (Root, Left, Right)
     * Useful for creating copy of tree
     */
    public void preorderTraversal() {
        System.out.print("Preorder: ");
        preorderHelper(root);
        System.out.println();
    }
    
    private void preorderHelper(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }
    
    /**
     * Postorder traversal (Left, Right, Root)
     * Useful for deleting tree
     */
    public void postorderTraversal() {
        System.out.print("Postorder: ");
        postorderHelper(root);
        System.out.println();
    }
    
    private void postorderHelper(TreeNode node) {
        if (node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    /**
     * Level order traversal (BFS)
     * Visits nodes level by level
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Level order: Tree is empty");
            return;
        }
        
        System.out.print("Level order: ");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        System.out.println();
    }
    
    /**
     * Level order traversal with level separation
     */
    public void levelOrderWithLevels() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.data + " ");
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            System.out.println();
            level++;
        }
    }
    
    // ========== TREE PROPERTIES ==========
    
    /**
     * Calculate height of tree
     * Height = longest path from root to leaf
     */
    public int height() {
        return heightHelper(root);
    }
    
    private int heightHelper(TreeNode node) {
        if (node == null) {
            return -1; // Height of empty tree is -1
        }
        
        int leftHeight = heightHelper(node.left);
        int rightHeight = heightHelper(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    /**
     * Count total number of nodes
     */
    public int size() {
        return sizeHelper(root);
    }
    
    private int sizeHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }
    
    /**
     * Count leaf nodes
     */
    public int countLeaves() {
        return countLeavesHelper(root);
    }
    
    private int countLeavesHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            return 1; // Leaf node
        }
        
        return countLeavesHelper(node.left) + countLeavesHelper(node.right);
    }
    
    /**
     * Find maximum value in tree
     */
    public int findMax() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return findMaxHelper(root);
    }
    
    private int findMaxHelper(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        
        int leftMax = findMaxHelper(node.left);
        int rightMax = findMaxHelper(node.right);
        
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }
    
    /**
     * Find minimum value in tree
     */
    public int findMin() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return findMinHelper(root);
    }
    
    private int findMinHelper(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        
        int leftMin = findMinHelper(node.left);
        int rightMin = findMinHelper(node.right);
        
        return Math.min(node.data, Math.min(leftMin, rightMin));
    }
    
    /**
     * Search for a value in tree
     */
    public boolean search(int value) {
        return searchHelper(root, value);
    }
    
    private boolean searchHelper(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        
        if (node.data == value) {
            return true;
        }
        
        return searchHelper(node.left, value) || searchHelper(node.right, value);
    }
    
    /**
     * Check if tree is balanced
     * A tree is balanced if height difference between left and right subtrees <= 1
     */
    public boolean isBalanced() {
        return isBalancedHelper(root) != -1;
    }
    
    private int isBalancedHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftHeight = isBalancedHelper(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not balanced
        
        int rightHeight = isBalancedHelper(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced
        
        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // ========== TREE CONSTRUCTION ==========
    
    /**
     * Insert node in level order (complete binary tree)
     */
    public void insertLevelOrder(int data) {
        TreeNode newNode = new TreeNode(data);
        
        if (root == null) {
            root = newNode;
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if (current.left == null) {
                current.left = newNode;
                return;
            } else if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
    }
    
    /**
     * Build tree from array (level order)
     */
    public static BinaryTree fromArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return new BinaryTree();
        }
        
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(arr[0]);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree.root);
        
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            
            // Add left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            
            // Add right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        
        return tree;
    }
}

/**
 * Binary Search Tree implementation
 */
class BinarySearchTree extends BinaryTree {
    
    /**
     * Insert value maintaining BST property
     */
    public void insert(int data) {
        root = insertHelper(root, data);
    }
    
    private TreeNode insertHelper(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        }
        
        if (data < node.data) {
            node.left = insertHelper(node.left, data);
        } else if (data > node.data) {
            node.right = insertHelper(node.right, data);
        }
        // Ignore duplicates
        
        return node;
    }
    
    /**
     * Search in BST (more efficient than general tree search)
     */
    public boolean searchBST(int value) {
        return searchBSTHelper(root, value);
    }
    
    private boolean searchBSTHelper(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        
        if (value == node.data) {
            return true;
        } else if (value < node.data) {
            return searchBSTHelper(node.left, value);
        } else {
            return searchBSTHelper(node.right, value);
        }
    }
    
    /**
     * Delete node from BST
     */
    public void delete(int data) {
        root = deleteHelper(root, data);
    }
    
    private TreeNode deleteHelper(TreeNode node, int data) {
        if (node == null) {
            return null;
        }
        
        if (data < node.data) {
            node.left = deleteHelper(node.left, data);
        } else if (data > node.data) {
            node.right = deleteHelper(node.right, data);
        } else {
            // Node to be deleted found
            
            // Case 1: No children (leaf node)
            if (node.left == null && node.right == null) {
                return null;
            }
            
            // Case 2: One child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            
            // Case 3: Two children
            // Find inorder successor (smallest in right subtree)
            TreeNode successor = findMin(node.right);
            node.data = successor.data;
            node.right = deleteHelper(node.right, successor.data);
        }
        
        return node;
    }
    
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    /**
     * Validate if tree is a valid BST
     */
    public boolean isValidBST() {
        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        
        if (node.data <= min || node.data >= max) {
            return false;
        }
        
        return isValidBSTHelper(node.left, min, node.data) &&
               isValidBSTHelper(node.right, node.data, max);
    }
}

public class BinaryTree {
    
    public static void main(String[] args) {
        
        System.out.println("=== Binary Tree Implementation and Operations ===\n");
        
        // ========== BINARY TREE DEMO ==========
        
        System.out.println("=== Binary Tree Demo ===");
        binaryTreeDemo();
        
        // ========== BINARY SEARCH TREE DEMO ==========
        
        System.out.println("\n=== Binary Search Tree Demo ===");
        binarySearchTreeDemo();
        
        // ========== TREE CONSTRUCTION DEMO ==========
        
        System.out.println("\n=== Tree Construction Demo ===");
        treeConstructionDemo();
        
        System.out.println("\n=== Binary Tree lesson completed! ===");
    }
    
    /**
     * Demonstrates binary tree operations
     */
    public static void binaryTreeDemo() {
        
        // Create a sample binary tree
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        
        BinaryTree tree = new BinaryTree(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);
        
        System.out.println("Sample Binary Tree:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    / \\   \\");
        System.out.println("   4   5   6");
        System.out.println();
        
        // Tree traversals
        tree.inorderTraversal();
        tree.preorderTraversal();
        tree.postorderTraversal();
        tree.levelOrderTraversal();
        
        System.out.println();
        tree.levelOrderWithLevels();
        
        // Tree properties
        System.out.println("\n--- Tree Properties ---");
        System.out.println("Height: " + tree.height());
        System.out.println("Size: " + tree.size());
        System.out.println("Leaf count: " + tree.countLeaves());
        System.out.println("Maximum value: " + tree.findMax());
        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Is balanced: " + tree.isBalanced());
        
        // Search operations
        System.out.println("\n--- Search Operations ---");
        int[] searchValues = {1, 5, 7, 3};
        for (int value : searchValues) {
            boolean found = tree.search(value);
            System.out.println("Search " + value + ": " + found);
        }
    }
    
    /**
     * Demonstrates binary search tree operations
     */
    public static void binarySearchTreeDemo() {
        
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert values
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        System.out.println("Inserting values: " + Arrays.toString(values));
        
        for (int value : values) {
            bst.insert(value);
        }
        
        System.out.println("\nBST after insertions:");
        System.out.println("       50");
        System.out.println("      /  \\");
        System.out.println("    30    70");
        System.out.println("   / \\   / \\");
        System.out.println("  20 40 60 80");
        System.out.println();
        
        // Traversals
        bst.inorderTraversal(); // Should be sorted
        bst.preorderTraversal();
        bst.levelOrderTraversal();
        
        // BST properties
        System.out.println("\n--- BST Properties ---");
        System.out.println("Height: " + bst.height());
        System.out.println("Size: " + bst.size());
        System.out.println("Is valid BST: " + bst.isValidBST());
        
        // Search operations
        System.out.println("\n--- BST Search ---");
        int[] searchValues = {40, 25, 70, 90};
        for (int value : searchValues) {
            boolean found = bst.searchBST(value);
            System.out.println("Search " + value + ": " + found);
        }
        
        // Delete operations
        System.out.println("\n--- Delete Operations ---");
        System.out.println("Before deletion:");
        bst.inorderTraversal();
        
        // Delete leaf node
        bst.delete(20);
        System.out.println("After deleting 20 (leaf):");
        bst.inorderTraversal();
        
        // Delete node with one child
        bst.delete(30);
        System.out.println("After deleting 30 (one child):");
        bst.inorderTraversal();
        
        // Delete node with two children
        bst.delete(50);
        System.out.println("After deleting 50 (two children):");
        bst.inorderTraversal();
    }
    
    /**
     * Demonstrates tree construction from array
     */
    public static void treeConstructionDemo() {
        
        // Build tree from array
        Integer[] treeArray = {1, 2, 3, 4, 5, null, 6, null, null, 7, 8};
        BinaryTree tree = BinaryTree.fromArray(treeArray);
        
        System.out.println("Tree built from array: " + Arrays.toString(treeArray));
        System.out.println("Tree structure:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    / \\   \\");
        System.out.println("   4   5   6");
        System.out.println("      / \\");
        System.out.println("     7   8");
        System.out.println();
        
        tree.levelOrderWithLevels();
        tree.inorderTraversal();
        
        // Level order insertion
        System.out.println("\n--- Level Order Insertion ---");
        BinaryTree levelTree = new BinaryTree();
        int[] insertValues = {1, 2, 3, 4, 5, 6, 7};
        
        System.out.println("Inserting in level order: " + Arrays.toString(insertValues));
        for (int value : insertValues) {
            levelTree.insertLevelOrder(value);
        }
        
        System.out.println("Resulting tree:");
        levelTree.levelOrderWithLevels();
        levelTree.inorderTraversal();
        
        System.out.println("\nTree properties:");
        System.out.println("Height: " + levelTree.height());
        System.out.println("Size: " + levelTree.size());
        System.out.println("Is balanced: " + levelTree.isBalanced());
    }
}

/*
 * Key Takeaways:
 * 
 * 1. Binary trees are hierarchical data structures with at most 2 children per node
 * 2. Tree traversals: Inorder (LNR), Preorder (NLR), Postorder (LRN), Level-order (BFS)
 * 3. Binary Search Trees maintain sorted order with left < root < right property
 * 4. BST operations (search, insert, delete) have O(log n) average time complexity
 * 5. Tree height affects performance - balanced trees are more efficient
 * 
 * Tree Traversals:
 * - Inorder: Left → Node → Right (gives sorted order for BST)
 * - Preorder: Node → Left → Right (useful for copying tree)
 * - Postorder: Left → Right → Node (useful for deleting tree)
 * - Level-order: BFS traversal level by level
 * 
 * BST Properties:
 * - Left subtree values < root value
 * - Right subtree values > root value
 * - Inorder traversal gives sorted sequence
 * - Average case: O(log n) for search, insert, delete
 * - Worst case: O(n) for unbalanced tree (like linked list)
 * 
 * Common Applications:
 * - Expression trees for parsing
 * - File system hierarchies
 * - Database indexing
 * - Huffman coding trees
 * - Decision trees in AI
 * 
 * Performance Considerations:
 * - Balanced trees maintain O(log n) operations
 * - Unbalanced trees degrade to O(n) operations
 * - Self-balancing trees (AVL, Red-Black) maintain balance automatically
 * - Consider tree height when designing algorithms
 */
