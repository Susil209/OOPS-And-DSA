package com.java.DSAQuestions.Tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public static List<Integer> printBoundary(Node root){
        List<Integer> ans = new ArrayList<>();

        // empty tree
        if(root == null) return ans;

        // If the root is not a leaf,
        // add its value to the result
        if(!isLeaf(root)){
            ans.add(root.data);
        }

        // add left subtree boundary
        leftBoundary(root.left, ans);

        // add leaf nodes
        leafNodes(root, ans);

        //add right subtree boundary
        rightBoundary(root.right, ans);

        return ans;
    }

    private static void rightBoundary(Node root, List<Integer> ans) {
        // base case:
        if(root == null || isLeaf(root)) return;

        // postorder
        // Move to the right child if it exists,
        // otherwise move to the left child
        if(root.right != null){
            rightBoundary(root.right, ans);
        }else {
            rightBoundary(root.left, ans);
        }

        // right nodes should be pushed in reverse order
        // so push them when returning from the call
        ans.add(root.data);
    }

    private static void leafNodes(Node root, List<Integer> ans) {
        // base case:
        if(root == null) return;

        // If the current node is a
        // leaf, add its value to the result
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }

        // Recursively add leaves of
        // the left and right subtrees
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    private static void leftBoundary(Node root, List<Integer> ans) {
        // base case: return when encounter a leaf node
        if(root == null || isLeaf(root)) return;

        // push the left child
        ans.add(root.data);

        // Move to the left child if it exists,
        // otherwise move to the right child
        if (root.left != null) {
            leftBoundary(root.left,ans);
        } else {
            leftBoundary(root.right,ans);
        }
    }

    private static boolean isLeaf(Node root) {
        // if root is a leaf it has no left and right children
        return root.left == null && root.right == null;
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

        List<Integer> result = printBoundary(root);

        System.out.println("Boundary order traversal is: ");
        System.out.println(result);
    }
}
