package com.java.DSAQuestions.Queue;

class Node{
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
}


class QueueLL{
    Node front;
    Node rear;

    QueueLL() {
        front=rear=null;
    }

    boolean isEmpty() {
        return front == null;
    }

    // TC=O(1)
    void enqueue(int x) {
        // create a new node
        Node newNode = new Node(x);

        // If queue is empty, then new node is front and rear both
        if(isEmpty()){
            front=rear=newNode;
        }

        // Add the new node at the end of queue and change rear
        // to new added node
        else {
            rear.next = newNode;
            rear=newNode;
        }
    }


    // TC=O(1)
    int dequeue() {
        int removedEle = -1;
        // check empty case
        if(isEmpty()){
            System.out.println("Queue is empty,can't dequeue.");
        }else {
            Node temp = front;
            front = front.next;
            removedEle = temp.data;
        }
        return removedEle;
    }

    void Display() {
        Node p = front;
        while(p!=null){
            System.out.printf("%d ",p.data);
            p=p.next;
        }
        System.out.println();
    }
}


public class QueueUsingLL{
    public static void main(String[] args) {
        QueueLL q = new QueueLL();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.Display();

        System.out.printf("Dequeued ele %d\n", q.dequeue());

        q.Display();
    }
}
