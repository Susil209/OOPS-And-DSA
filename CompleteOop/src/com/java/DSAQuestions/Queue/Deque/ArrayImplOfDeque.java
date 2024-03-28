package com.java.DSAQuestions.Queue.Deque;

class DequeArr{
    private int front,rear,size;
    private int[] arr;

    DequeArr(int value){
        this.size=value;
        this.arr = new int[value];
        front=rear=-1;
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return (rear+1)%size == front;
    }

    public void push_front(int x){
        if(isEmpty()){
            front=rear=0;
            arr[front] = x;
        } else if (isFull()) {
            System.out.println("Overflow");
        }else{
            front = (front-1+size)%size;
            arr[front]=x;
        }
    }

    public void push_back(int x){
        if(isEmpty()){
            front=rear=0;
            arr[rear] = x;
        } else if (isFull()) {
            System.out.println("Overflow");
        }else{
            rear = (rear+1)%size;
            arr[rear]=x;
        }
    }
    
    public int pop_front(){
        int removedEle=0;
        if(isEmpty())
            System.out.println("Underflow");
        else if (front == rear) {
            removedEle = arr[front];
            front=rear=-1;
        }else {
            removedEle = arr[front];
            front = (front+1)%size;
        }
        return removedEle;
    }

    public int pop_back(){
        int removedEle=0;
        if(isEmpty())
            System.out.println("Underflow");
        else if (front == rear) {
            removedEle = arr[rear];
            front=rear=-1;
        }else {
            removedEle = arr[rear];
            rear= (rear-1+size)%size;
        }
        return removedEle;
    }

    public int start(){
        if(isEmpty())
            return -1;
        else
            return arr[front];
    }

    public int end(){
        if(isEmpty())
            return -1;
        else
            return arr[rear];
    }

    public void display(){
        int i = front;
        while(i != rear){
            System.out.print(arr[i]+ " ");
            i = (i+1)%size;
        }
//        for (int k : arr) {
//            System.out.print(k + " ");
//        }
    }
}


public class ArrayImplOfDeque {
    public static void main(String[] args) {
        DequeArr dq = new DequeArr(6);

        dq.push_back(10);
        dq.push_back(20);
        dq.push_back(30);


        dq.push_front(40);
        dq.push_front(50);
        dq.push_front(60);

//        dq.display();

        System.out.println("Front element " + dq.start());
        System.out.println("Rear element "+dq.end());


        System.out.println("Pop an element from front "+ dq.pop_front());
        System.out.println("Pop an element from back "+ dq.pop_back());

        System.out.println("Front element " + dq.start());
        System.out.println("Rear element "+dq.end());
    }
}
