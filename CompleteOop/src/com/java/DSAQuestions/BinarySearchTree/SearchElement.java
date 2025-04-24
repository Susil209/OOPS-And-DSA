package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import static com.java.DSAQuestions.Tree.BuildTreeUsingPreAndInOrder.printInOrder;

public class SearchElement {

    private static boolean searchBST(Node root, int target) {
        // Approach-1(Recursive)
        // TC=O(h), SC=O(h)

        /*if(root == null) return false;
        if(root.data == target) return true;

        if(target < root.data)
            return searchBST(root.left, target);
        else
            return searchBST(root.right,target);*/

        // Approach-2(Iterative)
        // TC=O(h), SC=O(1)
        while(root != null){
            if(root.data == target) return true;
            else if(target < root.data) root = root.left;
            else root = root.right;
        }

        return false;

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);

        System.out.println("Binary Search Tree: ");
        printInOrder(root);
        System.out.println();

        int target = 10;
        boolean isElementPresent = searchBST(root, target);

        // Displaying the search result
        if (isElementPresent) {
            System.out.println("Value " + target + " found in the BST!");
        } else {
            System.out.println("Value " + target + " not found in the BST.");
        }
    }


}
