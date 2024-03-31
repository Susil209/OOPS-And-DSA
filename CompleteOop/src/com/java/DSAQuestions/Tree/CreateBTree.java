package com.java.DSAQuestions.Tree;

import javax.swing.tree.FixedHeightLayoutCache;
import java.util.LinkedList;
import java.util.Queue;


// This is a test class message
// for creating pull request

public class CreateBTree {

    public static Node binaryTree(int[] A){

        // Approach-1 (Using Queue/ Iterative)
        // TC = O(n), SC=O(n)

        // create a queue of type Node to store node address
        /*Queue<Node> q = new LinkedList<>();

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
            if(A[i] != -1) {
                temp.left = new Node(A[i]);
                i++;
                q.offer(temp.left);
            }

            // create right node of temp and push its address in the queue
            if(i < A.length && A[i] != -1){
                temp.right = new Node(A[i]);
                i++;
                q.offer(temp.right);
            }

        }

        return root;*/



        // Approach-2 (Recursive)
        // TC=O(n), SC=O(h), h = height of the tree
        return createRecursiveTree(A, 0);

    }

    public static Node createRecursiveTree(int[] A, int i){
        // Base case
        if(i>=A.length || A[i] == -1)
            return null;

        Node root = new Node(A[i]);
//        System.out.printf("Left child of %d is %d\n", A[i], A[i+1]);
        root.left = createRecursiveTree(A, 2*i+1);

//        System.out.printf("Right child of %d is %d\n", A[i], A[i+1]);
        root.right = createRecursiveTree(A, 2*i+2);

        return root;
    }

    public static void preOrder(Node p){
        if(p!=null){
            System.out.print(p.data+ " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public static void inOrder(Node p){
        if(p!=null){
            inOrder(p.left);
            System.out.print(p.data+ " ");
            inOrder(p.right);
        }
    }

    public static void postOrder(Node p){
        if(p!=null){
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data+ " ");
        }
    }

    public static void levelOrder(Node p){
        Queue<Node> q = new LinkedList<>();

        if(p!=null){
            System.out.print(p.data+" ");
            q.offer(p);

            while(!q.isEmpty()){
                p = q.remove();
                if(p.left != null){
                    System.out.print(p.left.data+" ");
                    q.offer(p.left);
                }
                if(p.right!=null){
                    System.out.print(p.right.data+" ");
                    q.offer(p.right);
                }
            }
        }

    }

    public static int height(Node p){
        int x,y;

        if (p == null) return 0;
        x = height(p.left);
        y = height(p.right);

        return x > y ? x+1 : y+1;

    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};
//        int[] arr = {1,2,3,-1,-1,-1,4,-1,-1};

        Node root = binaryTree(arr);
        if(root != null)
            System.out.println("Root of the tree: "+ root.data);


        System.out.print("Preorder traversal: ");
        preOrder(root);
        System.out.println();

        System.out.print("Inorder traversal: ");
        inOrder(root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        postOrder(root);
        System.out.println();

        System.out.print("Level order traversal: ");
        levelOrder(root);
        System.out.println();

        System.out.print("Height of the tree: "+ height(root));
        System.out.println();
    }
}
