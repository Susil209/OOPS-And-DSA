package com.java.DSAQuestions.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {

    private static List<Integer> leftViewOfTree(Node root){
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
                    if(temp.left!=null) q.offer(temp.left);
                    if(temp.right!=null) q.offer(temp.right);
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
                if(i==0) ans.add(temp.data);

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

        getLeftView(root,level,ans);
//        System.out.println("Level "+level);
        return ans;
    }

    private static void getLeftView(Node root, int level,List<Integer> ans) {

        if(root==null) return;

        if(level == ans.size()){
            ans.add(root.data);
        }

        getLeftView(root.left, level+1,ans);
        getLeftView(root.right,level+1,ans);

    }


    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> leftView = leftViewOfTree(root);
        System.out.println("Left view: "+ leftView);
    }
}
