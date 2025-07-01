package com.java.DSAQuestions.BinarySearchTree.AVLTree;

// Node class for AVL Tree
class Node {
    int data, height;
    Node left, right;

    Node(int val) {
        data = val;
        height = 1;
        left = right = null;
    }
}

public class CreateAVLTree {


    // Root of AVL Tree
    private Node root;

     Node getRoot() {
        return root;
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // Inorder Traversal
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }

    // ========== Private Helper Methods ==========

    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node root) {
        Node child = root.left;
        Node childRight = child.right;

        // Rotation
        child.right = root;
        root.left = childRight;

        // Update heights
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        // New child as a new root
        return child;
    }

    private Node leftRotate(Node root) {
        Node child = root.right;
        Node childLeft = child.left;

        // Rotation
        child.left = root;
        root.right = childLeft;

        // Update heights
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        child.height = Math.max(height(child.left), height(child.right)) + 1;

        // New root
        return child;
    }

    private Node insert(Node node, int key) {
        // Normal BST insertion
        if (node == null) return new Node(key);

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            return node; // No duplicates
        }

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get balance factor
        int bf = getBalanceFactor(node);

        // Handle 4 cases of imbalance

        // LL
        if (bf > 1 && key < node.left.data) {
            return rightRotate(node);
        }

        // LR
        if (bf > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (bf < -1 && key > node.right.data) {
            return leftRotate(node);
        }

        // RL
        if (bf < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // ======= Main Method for Testing =======
    public static void main(String[] args) {
        CreateAVLTree avl = new CreateAVLTree();

//                    30
//                 20
//              10

        avl.insert(30);
        avl.insert(20);
        avl.insert(10);  // Triggers LL rotation

//                    20
//                10      30

        System.out.println("---Perform LL rotation---");
        System.out.print("Inorder Traversal: ");
        avl.inorder(avl.getRoot());
        System.out.println();
        System.out.println("Root after balancing: " + avl.getRoot().data); // Should be 20

//                    20
//            10             30
//                                40
//                                    50

        avl.insert(40);
        avl.insert(50);

//                    20
//            10             40
//                        30     50
//

        System.out.println("---Perform RR rotation---");
        System.out.print("Inorder Traversal: ");
        avl.inorder(avl.getRoot());
        System.out.println();

        System.out.println("Root after balancing: " + avl.getRoot().data); // Should be 20
        System.out.println("Root right after balancing: " + avl.root.right.data); // Should be 40

//                    20
//            10               40
//       7                  30     50
//          9


        avl.insert(7);
        avl.insert(9);

        // After LR case

//                    20
//            9               40
//       7       10        30     50
//

        System.out.println("---Perform LR rotation---");
        System.out.print("Inorder Traversal: ");
        avl.inorder(avl.getRoot());
        System.out.println();

        System.out.println("Root after balancing: " + avl.getRoot().data); // Should be 20
        System.out.println("Root right after balancing: " + avl.root.left.data); // Should be 9
        System.out.println("Root right after balancing: " + avl.root.left.right.data); // Should be 10
    }
}
