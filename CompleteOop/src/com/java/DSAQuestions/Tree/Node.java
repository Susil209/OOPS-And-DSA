package com.java.DSAQuestions.Tree;

public class Node{
    int data;
    Node left;
    Node right;

    Node()
    {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    Node(int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
