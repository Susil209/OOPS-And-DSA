package com.java.DSAQuestions.Queue;

class CircularQueue{

    private static final int DEFAULT_SIZE = 10;
    int rear,front;
    int[] CQ;

    int size;

    // constructor
    CircularQueue(){
        this(DEFAULT_SIZE);
    }

    CircularQueue(int s){
        this.size=s;
        rear=0;
        front=0;
        this.CQ = new int[s];
    }

    boolean isFull(){
        return (rear+1) % size == front;
    }

    boolean isEmpty(){
        return rear == front;
    }

    void enqueue(int item){
        if(isFull()) System.out.println("Queue is full/overflow.");
        rear = (rear+1) % size;
        CQ[rear] = item;
    }

    int dequeue() throws QueueException {
        int removedItem;
        if(isEmpty()){
            System.out.println("Queue is empty/underflow");
            throw new QueueException("Elements can't pop out of empty queue.");
        }else{
            front = (front+1) % size;
            removedItem = CQ[front];
        }


        return removedItem;
    }


    int front(){
        if(isEmpty()) return Integer.MIN_VALUE;
        return CQ[front];
    }

    int rear(){
        if(isEmpty()) return Integer.MIN_VALUE;
        return CQ[rear];
    }

    void displayQueue(){
        int i = front + 1;
        do {
            System.out.print(CQ[i]);
            if (i < rear) {
                System.out.print(" <- ");
            }
            i = (i + 1) % size;
        } while (i != (rear + 1) % size);
        System.out.println();
    }
}

public class CircularQueueArray {
    public static void main(String[] args) throws QueueException {
        int[] A = {10, 20, 30, 40};
        CircularQueue cq = new CircularQueue(A.length+1);

        for(int n: A){
            cq.enqueue(n);
        }

        cq.displayQueue();

        System.out.printf("Deque ele %d\n", cq.dequeue());

        cq.displayQueue();
//
        cq.enqueue(100);
//
        cq.displayQueue();
    }
}
