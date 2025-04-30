package com.java.DSAQuestions.BinarySearchTree;

import com.java.DSAQuestions.Tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.java.DSAQuestions.BinarySearchTree.BSTfromPreorder.insertBST;

public class LeastCommonAncestorOfBST {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(6,2,8,0,4,7,9,3,5);

        Node root = null;

        for(int val: values){
            root = insertBST(root,val);
        }

        int p = 2, q = 8;

        Node ans = lca(root, p, q);
        if(ans == null){
            System.out.println("No common ancestor found");
        }
        else{
            System.out.println("LCA of " + p + " and " + q + " is: " + ans.data);
        }
    }

    private static Node lca(Node root, int p, int q) {
        // Approach-1 (Brute force)
        // O(n) Time and O(n) Space

        /*
        List<Node> arr1 = new ArrayList<>();
        List<Node> arr2 = new ArrayList<>();

        // Find paths from root to n1 and
        // root to n2. If either
        // n1 or n2 is not present, return null.
        if(!findPath(root,arr1,p) || !findPath(root,arr2,q)){
            return null;
        }

        // Compare the paths to get the first
        // different value
        int i;
        for(i=0; i< arr1.size() && i < arr2.size() ; i++){
            if(arr1.get(i) != arr2.get(i))
                return arr1.get(i-1);
        }

        // if both the data are same, return last node
        return arr1.get(i-1);

         */

        // Approach-2 (Optimal)
        // TC = O(h) , SC= O(n)

        if(root == null) return null;

        if(p < root.data && q < root.data){
            // Both nodes are in the left subtree
            return lca(root.left, p ,q);
        } else if (p > root.data && q > root.data) {
            // Both nodes are in the right subtree
            return lca(root.right, p ,q);
        }else {
            // We are at the split point
            return root;
        }

    }

    private static boolean findPath(Node root, List<Node> arr, int k) {

        if(root == null) return false;

        arr.add(root);

        if(root.data == k || findPath(root.left, arr, k) || findPath(root.right, arr, k)){
            return true;
        }

        arr.remove(root);
        return false;
    }
}
