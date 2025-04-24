package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import javax.management.Query;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InsertElement {

    private static Node insertInBST(Node root, int val) {
        // Approach-1(Using recursion)
        // TC = O(h), SC = O(n)
        /*if(root == null){
            return new Node(val);
        }

        if(val < root.data){
            root.left = insertInBST(root.left, val);
        }else {
            root.right = insertInBST(root.right, val);
        }

        return root;*/

        //Approach-2(Using Iteration)
        // TC = O(n), SC = O(1)
        if(root == null){
            return new Node(val);
        }

        Node prev = null;
        Node curr = root;

        while(curr != null){
            prev = curr;

            if(val == curr.data)
                return curr;
            else if(val < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        curr = new Node(val);

        if(curr.data < prev.data)
            prev.left = curr;
        else
            prev.right = curr;

        return root;
    }

    private static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){

            Node temp = q.peek();
            q.poll();
            System.out.printf(temp.data + " ");

            if(temp.left!=null){
                q.offer(temp.left);
            }

            if(temp.right!=null){
                q.offer(temp.right);
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
         int[] nodes = {4,2,7,1,3};
        Node root = null;

        for (int node : nodes) {
            root = insertInBST(root, node);
        }

        System.out.println("The level order traversal of BST: ");
        printLevelOrder(root);

        // inserting another node
        System.out.println("After inserting another node: ");
        insertInBST(root, 15);
        insertInBST(root, 5);
        printLevelOrder(root);
    }

}
