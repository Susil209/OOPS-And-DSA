package com.java.DSAQuestions.Tree;

import java.util.*;

import static com.java.DSAQuestions.Tree.TopView.vertical_indexing;

public class BottomView {
    // Function to return the
    // bottom view of the binary tree
    public static List<Integer> bottomViewOfTree(Node root){
        // Approach-1(hash using map)
        // TC=O(n), SC=O(n)
        // List to store the result

        /*
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if(root == null) return answer;

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
        return ans;*/


        // Approach-2(Using BFS or Level order traversal)
        // (hash using array)
        // TC=O(n), SC=O(n)

        // Initialize with initial values
        MinMaxPair pair = new MinMaxPair(0, 0);

        // vertical indexing of tree
        vertical_indexing(root, 0, pair);

        int leftmost = pair.leftmost;
        int rightmost = pair.rightmost;

        // vector to store top view
        int size = rightmost-leftmost+1;
        Integer[] top_view = new Integer[size];


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

            // update the pos according to the current node
            top_view[pos] =  temp.data;

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


        // Approach-3(Using recursion)
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

        // level array to store level
        Integer[] level_array = new Integer[size];
        Arrays.fill(level_array, Integer.MIN_VALUE);

        // function to get the top view
        get_bottom_view(root, -1*leftmost, top_view, level_array, 0);

        //return the top view
        return Arrays.asList(top_view);*/
    }

    public static void get_bottom_view(Node root, int pos, Integer[] bottomView, Integer[] levelArray, int currentLevel) {
        // base case
        if(root == null) return;

        // check if current position in level array is greater than level position

        if(levelArray[pos] < currentLevel){
            bottomView[pos] = root.data;
            levelArray[pos] = currentLevel;
        }

        // call the left and right children recursively
        get_bottom_view(root.left, pos-1, bottomView, levelArray, currentLevel+1);
        get_bottom_view(root.right, pos+1, bottomView, levelArray, currentLevel+1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);

        List<Integer> leftView = bottomViewOfTree(root);
        System.out.println("Bottom view: "+ leftView);
    }
}
