package com.java.DSAQuestions.Tree;

public class SizeOfBtree {

    public static int getSize(Node root){
        /*if(root == null) return 0;

        int leftCount = getSize(root.left);
        int rightCount = getSize(root.right);

        return 1+leftCount+rightCount;*/

        // or

        return root == null ? 0 : 1 + getSize(root.left) + getSize(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(getSize(root));
    }
}
