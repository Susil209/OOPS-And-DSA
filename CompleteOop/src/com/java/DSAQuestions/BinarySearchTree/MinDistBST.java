package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

// Problem :
//Given the root of a Binary Search Tree (BST),
//return the minimum difference between the values of any two different nodes
//in the tree.

public class MinDistBST {
    static Integer prev = null;
    static int ans = Integer.MAX_VALUE;

    private static int minDiff(Node root){
        if(root == null) return 0;

        minDiff(root.left);
        if (prev != null)
            ans = Math.min(ans, root.data-prev);

        prev = root.data;
        minDiff(root.right);
        return ans;
    }

    public static int minDistBST(Node root) {
        return minDiff(root);
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        //     4
        //    /  \
        //   2    6
        //  / \
        // 1   3
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // get the minimum
        System.out.println("Minimum distance between two nodes: ");
        System.out.println(minDistBST(root));
    }
}
