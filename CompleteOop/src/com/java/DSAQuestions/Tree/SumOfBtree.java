package com.java.DSAQuestions.Tree;

public class SumOfBtree {

    private static int sumOf(Node head) {
        if (head == null) return 0;
        return head.data + sumOf(head.left) + sumOf(head.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(sumOf(root));
    }
}
