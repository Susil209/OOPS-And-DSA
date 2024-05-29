package com.java.DSAQuestions.Tree;

import java.util.*;

public class DiagonalTraversal {

    // count the left most nodes
    static int leftCount=0;

    public static List<Integer> diagonal(Node root){

        //Approach-1
//        Time complexity: O( N logN )
//        Auxiliary Space: O( N )

        /*TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();

        findDiagonalUsingMap(root, 0, mp);

        ArrayList<Integer> ans = new ArrayList<>();

        for(Map.Entry<Integer, ArrayList<Integer>> entry: mp.entrySet()){
            ans.addAll(entry.getValue());
        }

        return ans;*/



        // Approach-2

      /*  // create a function to count the left nodes
        findCount(root, 0);

        //create a 2d array/vector to hold left diagonal count and
        // nodes in that diagonal

        List<List<Integer>> diagonal = new ArrayList<>(leftCount+1);


        // create a function to find the diagonal elements
        findDiagonal(root, 0, diagonal);

        List<Integer> result = new ArrayList<>();

        for(List<Integer> it: diagonal){
            result.addAll(it);
        }

        return result;*/


        // Approach-3(Using Queue)
        // TC=O(n), SC=O(n)

        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, List<Integer>> mp = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();

            Node temp = p.node;
            int diagPos = p.vertical;

            mp.putIfAbsent(diagPos, new ArrayList<>());
            mp.get(diagPos).add(temp.data);

            if(temp.left != null){
                q.add(new Pair(temp.left, diagPos+1));
            }

            if(temp.right != null){
                q.add(new Pair(temp.right, diagPos));
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry: mp.entrySet()){
            int k = entry.getKey();

            List<Integer> l = mp.get(k);
            ans.addAll(l);

        }

        return ans;
    }

    private static void findDiagonal(Node root, int pos, List<List<Integer>> ans) {
        if(root == null) return;

        // get the list at the particular pos value
        List<Integer> index = ans.get(pos);

        if(pos == 0){
            index = new ArrayList<>();
            index.add(root.data);
        }else{
            index.add(root.data);
        }

        ans.add(pos, index);
        findDiagonal(root.left, pos+1, ans);
        findDiagonal(root.right, pos, ans);
    }

    private static void findCount(Node root, int pos) {
        if(root == null) return;

        // left count is the maximum between position and left count
        leftCount = Math.max(pos,leftCount);

        // recursively traverse left and right children,
        // while moving left child increment the count by 1
        // but not for right
        findCount(root.left, pos+1);
        findCount(root.right, pos);
    }

    private static void findDiagonalUsingMap(Node root, int pos, TreeMap<Integer, ArrayList<Integer>> mp) {
        // Base case
        if(root == null) return;

        // get the list at the particular pos value
        ArrayList<Integer> index = mp.get(pos);

        // index is null then create a
        // vector and store the data
        if(index == null){
            index = new ArrayList<>();
            index.add(root.data);
        }else{
            // index is not null then update the list
            index.add(root.data);
        }

        // Store all nodes of same line together as a list
        mp.put(pos, index);

        // Increase the vertical distance if left child
        findDiagonalUsingMap(root.left, pos+1, mp);

        // Vertical distance remains same for right child
        findDiagonalUsingMap(root.right, pos, mp);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        List<Integer> diagonalTraversal = diagonal(root);

        System.out.println("Diagonal Traversal of Binary Tree");
        System.out.println(diagonalTraversal);
    }
}
