package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class SumOfKthSmallest {


    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        int k = 3;
        System.out.println("Sum of "+ k +"th smallest element is :");
        System.out.println(sumOfkthSmallest(root,k));
    }

    private static int sumOfkthSmallest(Node root, int k) {
        List<Integer> inorder = new ArrayList<>();
        findSum(root,inorder,k);

        int sum = 0;
        for(int i=0; i<k; i++)
            sum = sum + inorder.get(i);
        return sum;
    }

    private static void findSum(Node root,List<Integer> inorder, int k) {
        if(root == null || k==0) return;

        // inorder traversal
        // go to left node
        findSum(root.left, inorder, k);
        inorder.add(root.data);
        // go to right
        findSum(root.right,inorder,k);
    }


}
