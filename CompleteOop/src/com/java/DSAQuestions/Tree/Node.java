package com.java.DSAQuestions.Tree;

public class Node{
    public int data;
    public Node left;
    public Node right;

    public Node()
    {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left, Node right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
