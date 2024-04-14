package com.java.DSAQuestions.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(Node root){
        // Approach-1: (Using two stacks)
        // TC=O(n), SC=O(n)
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;


        Stack<Node> s1 = new Stack<>(); // r to l
        Stack<Node> s2 = new Stack<>(); // l to r

        s1.push(root); // push root first in r to l stack



        while(!s1.empty() || !s2.empty()){

            if(!s1.empty()){
                while(!s1.empty()){

                    int size1 = s1.size();
                    List<Integer> res = new ArrayList<>();

                    for (int i = 0; i < size1; i++) {
                        // for r to l stack
                        Node t1 = s1.peek();
                        s1.pop();
                        res.add(t1.data);

                        // push its right and left children in l to r stack
                        if(t1.left != null) s2.push(t1.left);
                        if(t1.right != null) s2.push(t1.right);
                    }

                    ans.add(res);
                }
            }

            else{
                while(!s2.empty()){

                    int size2 = s2.size();
                    List<Integer> res = new ArrayList<>();

                    for (int i = 0; i < size2; i++) {
                        // for l to r stack
                        Node t2 = s2.peek();
                        s2.pop();
                        res.add(t2.data);

                        // push its left and right children in r to l stack

                        if(t2.right != null) s1.push(t2.right);
                        if(t2.left != null) s1.push(t2.left);
                    }

                    ans.add(res);
                }
            }

        }

        return ans;

    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> zigzag = zigzagLevelOrder(root);
        System.out.println("Zigzag Order traversal of binary tree is :");
        System.out.println(zigzag);
    }
}
