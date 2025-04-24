package com.java.DSAQuestions.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTreeUsingPreAndInOrder {

    public static int preIndex = 0;

    public static int getInorderIndex(int [] inOrder, int start, int end, int data){
        for(int i=start;i<=end;i++){
            if(inOrder[i]==data){
                return i;
            }
        }
        return -1;
    }

    public static Node makeBTree(int [] inOrder, int [] preOrder, int iStart, int iEnd ){
        if(iStart>iEnd){
            return null;
        }
        Node root = new Node(preOrder[preIndex++]);

        if(iStart==iEnd){
            return root;
        }
        int index = getInorderIndex(inOrder, iStart, iEnd, root.data);

        root.left = makeBTree(inOrder,preOrder,iStart, index-1);
        root.right = makeBTree(inOrder,preOrder,index+1, iEnd);

        return root;
    }

    public static int findPosInorder(int[] in, int target, int start,int end){
        for (int i = start; i <= end ; i++) {
            if(in[i] == target)
                return i;
        }
        return -1;
    }


    private static Node makeBTree(int[] in, int[] pre, int inStart,int inEnd,int index){
        // Base case
        if(inStart > inEnd) return null;

        // create a node using preorder elements
        Node root = new Node(pre[index]);

        // search and get pos of node in inorder
        int getPos = findPosInorder(in,pre[index],inStart,inEnd);

        //create left subtree recursively
        root.left = makeBTree(in,pre,inStart,getPos-1,index+1);

        //create right subtree recursively
        root.right = makeBTree(in,pre,getPos+1,inEnd, index+(getPos-inStart)+1);

        return root;
    }



    public static Node buildTree(int[] in, int[] pre){
        // Approach-1(Recursive)
        // TC=O(n^2),SC=O(n)
        //return makeBTree(in,pre,0,in.length-1,0);

        // Approach-2(Better)
        // TC=O(n^2),SC=O(n)
        //return makeBTree(in,pre,0,in.length-1);

        // Approach-3(Hashing)
        // TC=O(n),SC=O(n)

        // Create a map to store indices
        // of elements in the inorder traversal
        Map<Integer,Integer> map = new HashMap<>();

        // Populate the map with indices
        // of elements in the inorder traversal
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }

        return makeBTree(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private static Node makeBTree(int[] pre, int preStart, int preEnd,
                                  int[] in, int inStart, int inEnd, Map<Integer, Integer> map) {
        // base case
        if(preStart > preEnd || inStart > inEnd)
            return null;

        // Create a new TreeNode with value
        // at the current preorder index
        Node root = new Node(pre[preStart]);

        // get the index of current node from inorder by using map
        int getIndex = map.get(root.data);

        // get the length of left subtree
        int sizeLeft = getIndex - inStart;

        // recursive call to make left and right subtrees
        root.left = makeBTree(pre,preStart+1, preStart+sizeLeft,in,inStart,getIndex-1,map);
        root.right = makeBTree(pre,preStart+sizeLeft+1, preEnd, in, getIndex+1, inEnd,map);


        return root;
    }


    public static void printInOrder(Node p){
        if(p!=null){
            printInOrder(p.left);
            System.out.print(p.data+ " ");
            printInOrder(p.right);
        }
    }

    public static void main(String[] args) {
        int [] preOrder = {1,2,4,5,8,9,3,6,7,10};
        int [] inOrder = {4,2,8,5,9,1,6,3,7,10};

        Node root = buildTree(inOrder,preOrder);
        System.out.println("Constructed Tree using inorder: ");
        printInOrder(root);
    }
}
