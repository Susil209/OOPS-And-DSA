package com.java.Linkedlist;

public class SearchElement {
    public Node head;

    // Node class
    public class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Inserts a new node at the front of the list
    public void push(int new_data)
    {
        // Allocate new node and putting data
        Node new_node = new Node(new_data);

        // Make next of new node as head
        new_node.next = head;

        // Move the head to point to new Node
        head = new_node;
    }

    //search the element
    public boolean Search(Node p,int key){
        while(p!=null){
            if(p.data == key){
                return true;
            }
            p=p.next;
        }
        return false;
    }

    //recursively
    public boolean RSearch(Node p,int key){
        if(p==null) return false;
        if(p.data == key) return true;
        RSearch(p.next,key);
        return false;
    }

    public static void main(String[] args) {
        //empty list
        SearchElement s = new SearchElement();

        s.push(10);
        s.push(7);
        s.push(14);
        s.push(5);
        s.push(24);

        System.out.println(s.Search(s.head, 14));
        System.out.println(s.RSearch(s.head,23));
    }



}
