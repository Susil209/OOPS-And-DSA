package com.java.DSAQuestions.Tree;

public class ConvertToMirror {

    // Function to convert a binary tree into its mirror tree.
    public static void mirror(Node root) {
        if(root == null) return;

        // swap left and right
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);
    }

    public static void Inorder(Node root){
        if (root == null) return;

        Inorder(root.left);
        System.out.print(root.data+ " ");
        Inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of the constructed tree is");
        Inorder(root);
        System.out.println();

        /* convert tree to its mirror */
        mirror(root);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of the mirror tree is");
        Inorder(root);
    }
}
