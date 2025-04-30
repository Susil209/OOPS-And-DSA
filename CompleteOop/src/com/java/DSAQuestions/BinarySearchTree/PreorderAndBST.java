package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import java.util.Arrays;
import java.util.List;


public class PreorderAndBST {
    // problem statement:
//    Given an array arr[ ] of size N consisting of distinct integers,
//    write a program that returns 1 if given array can represent
//    preorder traversal of a possible BST, else returns 0.

    static int index = 0;

    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(2,4,3);
        int size = arr1.size();

        if(canRepresentBST(arr1, size))
            System.out.println("Yes, The given array can represent BST");
        else
            System.out.println("No, can't represent BST.");

    }

    private static Boolean canRepresentBST(List<Integer> arr, int N) {

        // Approach-1 (Brute force)
        // TC = O(n^2), SC = O(n)

        // Step 1: Build BST from arr[]
//        Node root = null;
//        for (int i=0 ; i<N; i++){
//            root = insertBST(root, arr.get(i));
//        }
//
//        // Step 2: Do preorder traversal of the BST
//        List<Integer> traversal = new ArrayList<>();
//        preorder(root, traversal);
//
//        // Step 3: Compare with input array
//
//        // wrong approach, This canRepresentBST() logic is returning true too early
//        // — it's returning true if even one element in preorder traversal matches the corresponding input element.
//
//
////        for(int i=0; i<N; i++){
////            if(traversal.get(i).equals(arr.get(i))) {
////                return true; // ❌ This will return true even if only the first element matches
////            }
////        }
////
////        return false;
//
//        for (int i = 0; i < N; i++) {
//            if(!traversal.get(i).equals(arr.get(i)))
//                return false;
//        }
//
//        return true;

        // Approach-2 (Optimal Solution) (Using Recursion)

        checkValidBST( arr, Integer.MIN_VALUE, Integer.MAX_VALUE, N);
        return index == N;

    }

    private static void checkValidBST(List<Integer> arr, int minValue, int maxValue, int n) {

        // stopping case
        if(index == n || arr.get(index) < minValue || arr.get(index) > maxValue)
            return;

        int val = arr.get(index++);
        // left subtree
        checkValidBST(arr,minValue,val,n);
        // right subtree
        checkValidBST(arr,val,maxValue,n);

    }

    private static Node insertBST(Node root, Integer key) {
        if (root == null)
            return new Node(key);
        if (root.data > key)
            root.left = insertBST(root.left, key);
        else if (root.data < key)
            root.right = insertBST(root.right, key);
        return root;
    }

    private static void preorder(Node root, List<Integer> res) {
        if(root == null) return;

        res.add(root.data);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
