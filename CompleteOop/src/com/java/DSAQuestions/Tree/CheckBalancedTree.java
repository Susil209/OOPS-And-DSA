package com.java.DSAQuestions.Tree;

public class CheckBalancedTree {
    private static int balanced=-1;
    public static boolean isBalanced(Node root){
        // Approach-1(Brute force)
//        checkBalanced(root,balanced);
//        return balanced != 0;

        // Approach-2(Optimal)
        // TC=O(n),SC=O(n)
        return checkHeight(root) != -1;
    }

    private static int checkHeight(Node root){
        if(root == null) return 0;

        // count left and right nodes
        int lh = checkHeight(root.left);
        int rh = checkHeight(root.right);

        // unbalanced condition
        if(lh==-1 || rh==-1) return -1;
        if(Math.abs(lh-rh) > 1) return -1;

        // return height
        return Math.max(lh,rh) + 1;
    }

    private static int checkBalanced(Node root, int balanced){
        if(root == null) return 0;

        // count left and right nodes
        int lh = checkBalanced(root.left,balanced);
        int rh = checkBalanced(root.right, balanced);

        // check balanced condition
        if(Math.abs(lh-rh) > 1){
            balanced=0;
            return balanced;
        }

        // return height
        return Math.max(lh,rh) + 1;
    }
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if(isBalanced(root))
            System.out.println("Tree is balanced.");
        else
            System.out.println("Not a balanced tree");
    }
}
