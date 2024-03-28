package com.java.DSAQuestions.Queue;


class Queue{
    private static final int DEFAULT_SIZE = 10;

    // using single pointer
    int rear=-1;
    int[] Q;

    // constructor
    Queue(){
        this(DEFAULT_SIZE);
    }

    Queue(int size){
        this.Q = new int[size];
    }

    boolean isFull(){
        return rear == Q.length-1;
    }

    boolean isEmpty(){
        return rear == -1;
    }

    // TC=O(1)
    void enqueue(int item){
        if(isFull()) System.out.println("Queue is full/overflow.");
        rear++;
        Q[rear] = item;
    }

    // TC=O(n)
    int dequeue() throws QueueException {
        int removedItem;
        if(isEmpty()){
            System.out.println("Queue is empty/underflow");
            throw new QueueException("Elements can't pop out of empty queue.");
        }

        // shift the elements
        for (int i = 1; i <= rear; i++) {
            Q[i-1]=Q[i];
        }
        rear--;

        removedItem = Q[0];
        return removedItem;
    }

    int front(){
        if(isEmpty()) return Integer.MIN_VALUE;
        return Q[0];
    }

    int rear(){
        if(isEmpty()) return Integer.MIN_VALUE;
        return Q[rear];
    }


    void displayQueue(){
        for (int i = 0; i <= rear; i++) {
            System.out.print(Q[i]+" ");
        }
        System.out.println();
    }

}

public class QueueArray {
    public static void main(String[] args) throws QueueException {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.displayQueue();
        System.out.println(q.front());
        System.out.println(q.rear());

        System.out.println(q.dequeue());

        q.displayQueue();
    }
}
