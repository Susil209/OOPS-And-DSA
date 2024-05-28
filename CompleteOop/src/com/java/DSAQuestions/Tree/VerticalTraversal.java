package com.java.DSAQuestions.Tree;

import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

class Tuple{
    Node node;
    int row;
    int col;

    public Tuple(Node node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalTraversal {

    /*
     Time Complexity: O(N * log2N * log2N * log2N) where N represents the number of nodes in the Binary Tree.
        Postorder Traversal performed using BFS as a time complexity of O(N) as we are visiting each and
         every node once.
        Multiset Operations to insert overlapping nodes at a specific vertical and horizontal level
         also takes O(log2N) complexity.
        Map operations involve insertion and retrieval of nodes with their vertical and level as their keys.
         Since there are two nested maps, the total time complexity becomes O(log2N)*O(log2N).

     Space Complexity: O(N + N/2) where N represents the number of nodes in the Binary Tree.
        The map for storing nodes based on their vertical and level information occupies an
         additional space complexity of O(N) as it stores all N nodes of the Binary Tree.
        The queue for breadth first traversal occupies a space proportional to the maximum level
        of the tree which can be O(N/2) in the worst case of a balanced tree.

     */


    // Function to perform vertical order traversal
    // and return a 2D ArrayList of node values

    // Approach-1

    /*public static List<List<Integer>> findVertical(Node root) {
        // Map to store nodes based on
        // vertical and level information
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical and level information
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root,0, 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();

            Node temp = t.node;
            int verticalIndex = t.row;
            int level = t.col;

            if(!mp.containsKey(verticalIndex)){
                mp.put(verticalIndex, new TreeMap<>());
            }

            if(!mp.get(verticalIndex).containsKey(level)){
                mp.get(verticalIndex).put(level, new PriorityQueue<>());
            }

            mp.get(verticalIndex).get(level).offer(temp.data);

            if(temp.left != null){
                q.offer(new Tuple(temp.left, verticalIndex-1, level+1));
            }

            if(temp.right != null){
                q.offer(new Tuple(temp.right, verticalIndex+1, level+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> it: mp.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> nodes: it.values()){
                while(!nodes.isEmpty()){
                    col.add(nodes.poll());
                }
            }

            ans.add(col);
        }

        return ans;
    }*/

    public static List<List<Integer>> findVertical(Node root){
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();

        Queue<Pair> q = new ArrayDeque<>();

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int hd = pair.vertical;
            Node temp = pair.node;

            if(mp.containsKey(hd)){
                mp.get(hd).add(temp.data);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.data);
                mp.put(hd, list);
            }

            if(temp.left != null){
                q.offer(new Pair(temp.left, hd-1));
            }

            if(temp.right != null){
                q.offer(new Pair(temp.right, hd+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()){
            List<Integer> col = new ArrayList<>(entry.getValue());
            ans.add(col);
        }

        return ans;

    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<List<Integer>> verticalTraversal = findVertical(root);

        // Print the result
        System.out.println("Vertical Traversal: ");
        System.out.println(verticalTraversal);
    }
}
