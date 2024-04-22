package com.java.DSAQuestions.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    private static List<Integer> rightViewOfTree(Node root){
        // Approach-1
        /*List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();
            ans.add(q.peek().data);

            while(size!=0){
                Node temp = q.poll();

                if(temp!=null){
                    if(temp.right!=null) q.offer(temp.right);
                    if(temp.left!=null) q.offer(temp.left);
                }
                size--;
            }
        }

        return ans;*/

        //Approach-2
        /*List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);


        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node temp = q.poll();
                if(i==size-1 && temp!=null) ans.add(temp.data);

                if(temp!=null){
                    if(temp.left!=null) q.offer(temp.left);
                    if(temp.right!=null) q.offer(temp.right);
                }
            }
        }

        return ans;*/

        //Approach-3
        List<Integer> ans = new ArrayList<>();
        int level=0;

        getRightView(root,level,ans);
        return ans;
    }

    private static void getRightView(Node root, int level,List<Integer> ans) {

        if(root==null) return;

        if(level == ans.size()){
            ans.add(root.data);
        }

        getRightView(root.right,level+1,ans);
        getRightView(root.left, level+1,ans);
    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> rightView = rightViewOfTree(root);
        System.out.println("Right view: "+ rightView);
    }
}
