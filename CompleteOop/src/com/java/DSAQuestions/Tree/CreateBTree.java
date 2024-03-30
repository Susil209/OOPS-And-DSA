package com.java.DSAQuestions.Tree;

import java.util.LinkedList;
import java.util.Queue;


// This is a test class message
// for creating pull request

public class CreateBTree {

    public static Node binaryTree(int[] A){

        // create a queue of type Node to store node address
        Queue<Node> q = new LinkedList<>();

        if(A.length == 0) return null;

        // create root node and push the 1st array ele
        Node root = new Node(A[0]);

        // push the root address in queue
        q.offer(root);

        // from 1st index onwards in the array
        int i=1;

        // until queue is not empty
        while(!q.isEmpty() && i < A.length) {

            // create a temp node pointing to root node
            Node temp = q.remove();

            // create left node of temp and push its address in the queue
            temp.left = new Node(A[i]);
            i++;
            q.offer(temp.left);

            // create right node of temp and push its address in the queue
            if(i < A.length){
                temp.right = new Node(A[i]);
                i++;
                q.offer(temp.right);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};

        Node root = binaryTree(arr);
        if(root != null)
            System.out.println("Root of the tree: "+ root.data);

    }
}
