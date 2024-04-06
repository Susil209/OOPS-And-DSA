package com.java.DSAQuestions.Tree;

public class LeafNodesInBtree {
    private static int getLeafNodes(Node root) {

        /*if (root == null) return 0;

        int leftLeaves = getLeafNodes(root.left);
        int rightLeaves = getLeafNodes(root.right);

        return root.left==null && root.right==null ? 1+leftLeaves+rightLeaves
                :leftLeaves+rightLeaves;*/


        //or
        // Base case
        if (root == null) return 0;

        //if the current node is a leaf node, return 1.
        if(root.left == null && root.right == null)
            return 1;


        //recursively count the number of leaf nodes in the left
        // and right subtrees and return the sum of them.
        return getLeafNodes(root.left)+getLeafNodes(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(getLeafNodes(root));
    }


}
