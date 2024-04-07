package com.java.DSAQuestions.Tree;

public class CheckTreesIdentical {

    private static boolean isIdentical(Node p, Node q) {
        // conditions:
        if (p == null && q==null) return true;
        if (p ==null || q==null) return false;

        // base case:
        if(p.data != q.data) return false;
        else return isIdentical(p.left,q.left) && isIdentical(p.right,q.right);
    }
    public static void main(String[] args) {
        Node tree1;
        Node tree2;

        tree1 = new Node(1);
        tree1.left = new Node(2);
        tree1.right = new Node(3);
        tree1.left.left = new Node(4);
        tree1.left.right = new Node(5);

        tree2 = new Node(1);
        tree2.left = new Node(2);
        tree2.right = new Node(3);
        tree2.left.left = new Node(4);
        tree2.left.right = new Node(5);

        if(isIdentical(tree1, tree2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");


    }


}
