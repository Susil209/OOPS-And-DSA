package com.java.DSAQuestions.Tree;

import javax.swing.tree.FixedHeightLayoutCache;
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
