package com.java.Linkedlist.doublyLL;

import java.util.Stack;

public class DoublyLL {

    Node head;

    public void createDllUsingArray(int []A, int size){
        Node tail,temp;
        head = new Node(A[0]);
        head.prev = null;
        head.next = null;
        tail=head;

        for(int i=1; i<size; i++){
            temp = new Node(A[i]);
            temp.next = null;
            temp.prev =tail;
            tail.next = temp;
            tail = temp;
        }
    }

    public void insertAtFirst(int val){
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAtLast(int val){
        Node newNode = new Node(val);
        newNode.next = null;


        Node last = head;

        if(head == null){
            newNode.prev = null;
            head = newNode;
            return;
        }

        while(last.next!=null){
            last= last.next;
        }

        last.next = newNode;
        newNode.prev = last;
    }

    public void insert(int pos,int val){
        Node temp = head;

        //edge case
        if(pos < 0 || pos > countNode()) return;

        for(int i=0; i<pos-1; i++)
            temp = temp.next;

        Node newNode = new Node(val);

        newNode.next = temp.next;
        newNode.prev = temp;
        if(temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
    }

    public int deleteFirst(){
        Node p = head;
        head = head.next;
        int x = p.data;
        if(head!=null)
            head.prev = null;
        return x;
    }

    public int delete(int pos) {
        Node p = head;

        if(pos < 0 || pos > countNode()) return -1;

        for (int i = 0; i < pos - 1; i++) {
            p = p.next;
        }

        p.prev.next = p.next;
        if(p.next != null){
            p.next.prev = p.prev;
        }

        return p.data;
    }

    public int countNode(){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }

        return count;
    }

    public int findMiddle(){
        // Approach-1
        /*
        int length = countNode();
        Node p = head;
        for(int i=0 ; i<(length/2); i++){
            p = p.next;
        }

        return (p.data);


         */

        //Approach-2 (Using 2 pointers)

        Node p = head,q = head;

        while(q!=null && q.next!=null){
            p=p.next;
            q=q.next.next;
        }

        if(p!=null)
            return p.data;

        return 0;

        // Approach -3 (Using stack)

        /*
        Stack<Node> s = new Stack<>();
        Node p = head;

        while (p!=null) {
            s.push(p);
            p=p.next;
        }

        for (int i = 0; i < s.size() / 2; i++) {
            s.pop();
        }

        return s.peek().data;

         */
    }

    public void displayList(){
        Node p = head;
        System.out.print("START <-> ");
         while(p!=null){
             System.out.print(p.data + " <-> ");
             p=p.next;
         }
        System.out.println("END");
    }

    public void reverseDll(){
        Node p = head;
        while(p!=null){
            Node temp;

            //swap the pointers
            temp = p.next;
            p.next = p.prev;
            p.prev = temp;

            p = p.prev;

            if(p.next == null) {
                p.next = p.prev;
                p.prev = null;
                head = p;
                break;
            }
        }
    }




    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        int []A = {10,20};


        dll.createDllUsingArray(A,A.length);

        System.out.println("List is :");
        dll.displayList();


        System.out.println("Middle element is " + dll.findMiddle());

//        System.out.println("After Reverse :");
//        dll.reverseDll();
//        dll.displayList();

//        System.out.println("After Insert :");
//        dll.insert(3,78);
//        dll.displayList();

//        System.out.println("Deleted node is " + dll.deleteFirst());
//        dll.displayList();

//        System.out.println("After Delete :");
//        System.out.println("Deleted node is " + dll.delete(3));
//        dll.displayList();

//        dll.insertAtFirst(10);
//        dll.insertAtFirst(20);
//        dll.insertAtFirst(30);
//
//        System.out.println("Insert at first :");
//        dll.displayList();
//        System.out.println("Number of nodes = " +  dll.countNode());
//
//        dll.insertAtLast(40);
//        dll.insertAtLast(50);
//        dll.insertAtLast(60);
//
//        System.out.println("Insert at last :");
//        dll.displayList();
    }


    private class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next=null;
        }
    }


}
