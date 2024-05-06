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

class MinMaxPair {
    int leftmost;
    int rightmost;

    MinMaxPair(int leftmost, int rightmost) {
        this.leftmost = leftmost;
        this.rightmost = rightmost;
    }
}

public class TopView {


    public static List<Integer> topViewOfTree(Node root){
        // Approach-1(hash using map)
        // TC=O(n), SC=O(n)

        /*List<Integer> ans = new ArrayList<>();
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
        return ans;*/


        // Approach-2(Using BFS or Level order traversal)
        // (hash using array)
        // TC=O(n), SC=O(n)
        
        /*
        // Initialize with initial values
        MinMaxPair pair = new MinMaxPair(0, 0);

        // vertical indexing of tree
        vertical_indexing(root, 0, pair);

        int leftmost = pair.leftmost;
        int rightmost = pair.rightmost;

        // vector to store top view
        int size = rightmost-leftmost+1;
        Integer[] top_view = new Integer[size];

        // hashing table for checking the first occurrence of node
        boolean[] hashed_array = new boolean[size];
        Arrays.fill(new boolean[size], false);

        System.out.println("Length of hashed array: "+hashed_array.length);
        System.out.println("Hashed array: "+Arrays.toString(hashed_array));


        // take two queues to store node and its vertical index
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();

        // push root node and its vertical index
        q.offer(root);
        index.offer(-1 * leftmost);

        while(!q.isEmpty()) {
            // get the current node
            Node temp = q.remove();

            // get its vertical position
            int pos = index.remove();

            // check whether we encounter the current node index for very
            // first time in hash table

            // if not visited
            if(!hashed_array[pos]){
                // mark as visited and push the node data in answer
                hashed_array[pos] =  true;
                top_view[pos] =  temp.data;
            }

            // move to the left and right child nodes, and do the same
            if(temp.left != null) {
                q.offer(temp.left);
                index.offer(pos-1);
            }

            if(temp.right != null){
                q.offer(temp.right);
                index.offer(pos+1);
            }

        }

        return Arrays.asList(top_view);
*/

        // Approach-3(Using recursion)

        // Initialize with initial values
        MinMaxPair pair = new MinMaxPair(0, 0);

        // vertical indexing of tree
        vertical_indexing(root, 0, pair);

        int leftmost = pair.leftmost;
        int rightmost = pair.rightmost;

        // vector to store top view
        int size = rightmost-leftmost+1;
        Integer[] top_view = new Integer[size];

        // level array to store level
        Integer[] level_array = new Integer[size];
        Arrays.fill(level_array, Integer.MAX_VALUE);

        // function to get the top view
        get_top_view(root, -1*leftmost, top_view, level_array, 0);

        //return the top view
        return Arrays.asList(top_view);
    }

    public static void get_top_view(Node root, int pos, Integer[] topView, Integer[] levelArray, int currentLevel) {
        // base case
        if(root == null) return;

        // check if current position in level array is greater than level position

        if(levelArray[pos] > currentLevel){
            topView[pos] = root.data;
            levelArray[pos] = currentLevel;
        }

        // call the left and right children recursively
        get_top_view(root.left, pos-1, topView, levelArray, currentLevel+1);
        get_top_view(root.right, pos+1, topView, levelArray, currentLevel+1);
    }

    public static void vertical_indexing(Node root, int pos, MinMaxPair pair){

            if(root == null) return;
            pair.leftmost = Math.min(pair.leftmost, pos);
            pair.rightmost = Math.max(pair.rightmost, pos);

            vertical_indexing(root.left, pos-1, pair);
            vertical_indexing(root.right, pos+1, pair);
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
