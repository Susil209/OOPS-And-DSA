package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.BuildTreeUsingPreAndInOrder;
import com.java.DSAQuestions.Tree.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.java.DSAQuestions.Tree.CreateBTree.inOrder;

public class BSTfromPreorder {

    static int idx = 0;
    
    private static Node bstFromPreorder(List<Integer> pre) {
        // Approach-1 (Brute force)
        // TC = O(N^2) , SC = O(n)
//        Node root = null;
//
//        // One by one insert all keys from pre[]
//        for (int key : pre) {
//            root = insertBST(root, key);
//        }
//
//        return root;

        // Approach-2 (better)
        // use preorder and inorder traversal
        // O(nlog(n)) & O(N)

//         List<Integer> in = pre.stream().sorted().toList();
//
//        // convert to array
//        int[] preorder = pre.stream().mapToInt(Integer::intValue).toArray();
//        int[] inorder = in.stream().mapToInt(Integer::intValue).toArray();

//        System.out.println(Arrays.toString(preorder));
//        System.out.println(Arrays.toString(inorder));
//
//        return BuildTreeUsingPreAndInOrder.buildTree(preorder,inorder);


        // Approach-3 (Optimal)
        // TC = O(n), SC = O(n)
         return createBST(pre,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Node insertBST(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (root.data > key)
            root.left = insertBST(root.left, key);
        else if (root.data < key)
            root.right = insertBST(root.right, key);
        return root;
    }

    private static Node createBST(List<Integer> pre, int low, int high) {
        int n = pre.size();
        // Base case
        if(idx == n || pre.get(idx) < low || pre.get(idx) > high) return null;

        // create root node
        Node root = new Node(pre.get(idx++));

        // create left and right subtree

        // left subtree range:[INT_MIN < node < root.data]
        root.left = createBST(pre,low,root.data);

        // right subtree range:[root.data < node < INT_MAX]
        root.right = createBST(pre,root.data,high);

        return root;
    }

    public static void main(String[] args) {
        List<Integer> pre = Arrays.asList(10, 5, 1, 7, 40, 50);

//        // sorted list
//        List<Integer> inorder = pre.stream().sorted().toList();
//        System.out.println(inorder);

        Node root = bstFromPreorder(pre);
        System.out.println("Inorder elements are: ");
        inOrder(root);
    }


}
