package com.java.DSAQuestions.Tree;


import java.util.HashMap;
import java.util.Map;

import static com.java.DSAQuestions.Tree.BuildTreeUsingPreAndInOrder.findPosInorder;
import static com.java.DSAQuestions.Tree.BuildTreeUsingPreAndInOrder.printInOrder;

public class BuildTreeUsingPostAndInOrder {

    private static int idx;

    private static Node buildTree(int[] inorder, int[] postorder) {
        // Approach-1(Recursive)
        // TC=O(n^2),SC=O(n)
        //return makeTree(inorder,postorder,0,inorder.length-1,postorder.length-1);

        // Approach-2
        // TC=O(n^2),SC=O(n)
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = postorder.length-1;
        return build(inorder, postorder, 0, idx);

        // Approach-2(Hashing)
        // TC=O(n),SC=O(n)
//        if (inorder == null || postorder == null || inorder.length != postorder.length)
//            return null;
//
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < inorder.length; i++) {
//            map.put(inorder[i],i);
//        }
//
//        return makeTree(postorder,0, postorder.length-1,
//                inorder,0,inorder.length-1,map);

    }

    private static Node build(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        Node node = new Node(postorder[idx--]);
        if (start==end) return node;

        int index = findIdx(inorder, node.data, end);
        node.right = build(inorder, postorder, index+1, end);
        node.left = build(inorder, postorder, start, index-1);
        return node;
    }

    private static int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }

    private static Node makeTree(int[] postorder, int poststart,int postend,
                                 int[] inorder, int instart, int inend,Map<Integer,Integer> map){

        // base case
        if(poststart > postend || instart > inend)
            return null;


        // Create a new Node with value
        // at the current preorder index
        Node root = new Node(postorder[postend]);

        // get the index of current node from inorder by using map
        int pos = map.get(postorder[postend]);

        // get the length of left subtree
        int leftsize = pos - instart;

        // recursive call to make left and right subtrees
        root.left = makeTree(postorder,poststart, poststart+leftsize-1,
                inorder,instart,pos-1,map);
        root.right = makeTree(postorder,poststart+leftsize, postend-1,
                inorder, pos+1, inend,map);


        return root;

    }

    private static Node makeTree(int[] inorder, int[] postorder, int instart, int inend, int index) {
        //base case
        if(instart > inend) return null;

        //create root (post)
        Node root = new Node(postorder[index]);

        //get pos (inorder)
        int pos = findPosInorder(inorder,root.data,instart,inend);

        //left and right
        root.left = makeTree(inorder,postorder,instart,pos-1,index-(inend-pos)-1);
        root.right = makeTree(inorder,postorder,pos+1,inend,index-1);

        return root;
    }


    public static void main(String[] args) {
        int[] postOrder = {9,15,7,20,3};
        int[] inOrder = {9,3,15,20,7};

        Node root = buildTree(inOrder,postOrder);
        System.out.println("Constructed Tree using inorder: ");
        printInOrder(root);
    }


}
