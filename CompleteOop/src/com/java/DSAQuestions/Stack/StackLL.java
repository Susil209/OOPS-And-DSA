package com.java.DSAQuestions.Stack;

/*
Advantages of Linked List implementation:
--------------------------------------------
    1.The linked list implementation of a stack can grow and shrink according to the needs at runtime.
    2.It is used in many virtual machines like JVM.

Disadvantages of Linked List implementation:
----------------------------------------------
    1.Requires extra memory due to the involvement of pointers.
    2.Random accessing is not possible in stack.
 */

class Node {
    int data;
    Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class StackUsingLL {
    Node top;

    public StackUsingLL() {
        this.top = null;
    }

    // push
    public void push(int x) {
        //create a new node
        Node t = new Node();
        // check if stack (heap) is full. Then inserting an
        //  element would lead to stack overflow
        if (t == null) {
            System.out.println("Stack overflow");
        } else {
            t.data = x;
            t.next = top;
            top = t;
        }
    }


    //pop
    public int pop() {
        int x = -1;
        Node t;
        if (top == null) {
            System.out.println("Stack underflow");
        } else {
            t = top;
            top = top.next;
            x = t.data;
        }
        return x;
    }

    public int peek(int index) {
        Node t = top;
        for (int i = 0; t != null && i < index - 1; i++) {
            t = t.next;
        }

        return t != null ? t.data : -1;
    }

    int isEmpty() {
        return top == null ? 1 : 0;
    }

    int isFull() {
        Node t = top;
        return t != null ? 1 : 0;
    }

    int stackTop() {
        return top != null ? top.data : -1;
    }

    int getSize()
    {
        int count=0;
        Node temp=top;
        while(temp!=null){
            temp=temp.next;
            count++;
        }

        return count;
    }

    void display(){
        Node p=top;
        while(p!=null){
            System.out.print(p.data+" ");
            p=p.next;
        }
        System.out.println();
    }

}

public class StackLL {
    public static void main(String[] args) {
        StackUsingLL s = new StackUsingLL();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Deleted ele = "+s.pop());
        s.display();

        s.push(88);
        s.push(77);

        s.display();

        System.out.println(s.peek(2));
        System.out.println(s.stackTop());


        System.out.println(s.getSize());

    }
}
