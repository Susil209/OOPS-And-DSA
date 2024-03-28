package com.java.DSAQuestions.Queue.Deque;


class Node{
    int data;
    Node prev,next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class Deque{
    Node front,rear;
    Deque(){
        front = rear = null;
    }

    void push_front(int x){
        if(front == null){
            front = rear = new Node(x);
        }else{
            Node temp = new Node(x);
            temp.next=front;
            front.prev=temp;
            front=temp;
        }
    }


    void push_back(int x){
        if(front == null){
            front = rear = new Node(x);
        }else{
            Node temp = new Node(x);
            rear.next=temp;
            temp.prev=rear;
            rear=temp;
        }
    }

    int pop_front() {
        int removedEle = 0;
        if(front == null){
            System.out.println("Underflow");
        }
        else{
            Node temp = front;
            front=front.next;
            removedEle = temp.data;

            if(front!=null)
                front.prev = null;
            else
                rear = null;
        }

        return removedEle;
    }

    int pop_back(){
        int removedEle = 0;
        if(front == null){
            System.out.println("Underflow");
        }
        else{
            Node temp = rear;
            rear=rear.prev;
            removedEle = temp.data;

            if(rear!=null)
                rear.next = null;
            else
                front = null;
        }

        return removedEle;
    }

    int start(){
        if(front == null)
            return -1;
        else
            return front.data;
    }

    int end(){
        if (front == null)
            return -1;
        else
            return rear.data;
    }

    void display(){
        Node t = front;
        while(t!=null){
            System.out.print(t.data + "<->");
            t = t.next;
        }
        System.out.println();
    }

}

public class DLLImplOfDeque {
    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.push_back(10);
        dq.push_back(20);
        dq.push_back(30);

        dq.push_front(90);
        dq.push_front(190);

        dq.display(); // 190 90 10 20 30

        System.out.println(dq.start());//190
        System.out.println(dq.end()); // 30

        System.out.println(dq.pop_front()); //190
        System.out.println(dq.pop_back()); // 30

        dq.display(); //90 10 20

    }
}
