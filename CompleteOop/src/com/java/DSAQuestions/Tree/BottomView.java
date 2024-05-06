package com.java.DSAQuestions.Tree;

import java.util.*;

public class BottomView {
    // Function to return the
    // bottom view of the binary tree
    public static List<Integer> bottomViewOfTree(Node root){
        // Approach-1
        // TC=O(n), SC=O(n)
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if(root == null) return ans;

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer,Integer> mp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Pair> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.offer(new Pair(root, 0));

        // BFS traversal
        while(!q.isEmpty()){
            // Retrieve the node and its vertical
            // position from the front of the queue
            var temp = q.poll();
            Node node = temp.node;
            int index = temp.vertical;

            // Update the map with the node's data
            // for the current vertical position
            mp.put(index, node.data);

            // Push the left child with a decreased
            // vertical position into the queue
            if(node.left != null)
                q.offer(new Pair(node.left, index-1));

            // Push the right child with an increased
            // vertical position into the queue
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

        List<Integer> leftView = bottomViewOfTree(root);
        System.out.println("Bottom view: "+ leftView);
    }
}
