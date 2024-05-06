package com.java.DSAQuestions.Tree;

import java.util.*;

class Pair{
    Node node;
    int vertical;
    public Pair(Node n, int v){
        node=n;
        vertical=v;
    }
}

public class TopView {


    public static List<Integer> topViewOfTree(Node root){
        // Approach-1
        // TC=O(n), SC=O(n)

        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer,Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            var temp = q.poll();
            Node node = temp.node;
            int index = temp.vertical;

            if(!mp.containsKey(index)){
                mp.put(index, node.data);
            }

            if(node.left != null)
                q.offer(new Pair(node.left, index-1));

            if(node.right != null)
                q.offer(new Pair(node.right, index+1));
        }

        // Iterate through map and store values in answer list
        ans.addAll(mp.values());

        // return ans
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

        List<Integer> leftView = topViewOfTree(root);
        System.out.println("Top view: "+ leftView);
    }
}
