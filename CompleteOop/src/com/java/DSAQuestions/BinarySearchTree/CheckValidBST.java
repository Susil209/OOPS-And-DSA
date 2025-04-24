package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

public class CheckValidBST {

    static boolean checkBST(Node root, Long minVal, Long maxVal){
        // Approach-1
        // TC = O(n), SC = O(h)

        if(root == null) return true;
        // check range
        if(root.data <= minVal || root.data >= maxVal) return false;

        // check for both left and right
        return checkBST(root.left, minVal, (long) root.data)
                && checkBST(root.right, (long) root.data, maxVal);

    }


    // Function to check if the entire binary tree is a BST
    static boolean isBST(Node root) {
        // Approach-1
        // return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // Approach-2
        // TC = O(n), SC = O(h)
        return checkBST(root, null);
    }

    private static boolean checkBST(Node root, Node prev) {
        if(root == null) return true;

        // left check
        if(!checkBST(root.left, prev)) return false;
        if(prev != null && root.data <= prev.data) return false;

        // right check
        prev = root;
        return checkBST(root.right,prev);
    }


    public static void main(String[] args) {
        // Create a sample binary tree
        //     10
        //    /  \
        //   5    20
        //        / \
        //       9   25
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(9);
        root.right.right = new Node(25);

        if (isBST(root)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}
