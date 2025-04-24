package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import static com.java.DSAQuestions.Tree.CreateBTree.preOrder;

public class SortedArrayToBST {
    // TC = O(n), SC = O(n)
    public static Node sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return createHeightBalancedBST(nums,0,n-1);
    }

    private static Node createHeightBalancedBST(int[] nums, int start, int end) {
        // Base condition
        if(start>end) return null;

        // find mid element
        int mid = start + (end-start)/2;

        // create root node using mid element
        Node root = new Node(nums[mid]);

        // create left subtree
        root.left = createHeightBalancedBST(nums,start,mid-1);

        // create right subtree
        root.right = createHeightBalancedBST(nums,mid+1,end);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};
        Node root = sortedArrayToBST(arr);

        System.out.print("Preorder traversal(Height balanced BST): ");
        preOrder(root);
        System.out.println();

    }


}
