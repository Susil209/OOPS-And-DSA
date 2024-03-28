package com.java.DSAQuestions.Queue.Deque;


import java.util.Deque;
import java.util.LinkedList;

class Stack{
    Deque<Integer> dq = new LinkedList<>();

    void push(int x){
        dq.offerLast(x);
    }

    void pop(){
        dq.removeLast();
    }

    int top(){
        return dq.peekLast();
    }

    void displayStack(){
        System.out.println(dq);
    }
}

class Queue{
    Deque<Integer> dq = new LinkedList<>();

    void enqueue(int x){
        dq.offerLast(x);
    }

    void dequeue(){
        dq.removeFirst();
    }

    int front(){
        return dq.peekFirst();
    }

    void displayQueue(){
        System.out.println(dq);
    }
}

public class StackAndQueueUsingDq {
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st.displayStack();

        System.out.println("Top ele :"+ st.top());

        System.out.println("Pop ele ->");
        st.pop();

        st.displayStack();
        System.out.println("Top ele :"+ st.top());

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.displayQueue();

        System.out.println("Front ele "+ q.front());

        System.out.println("Pop ele ->");
        q.dequeue();

        q.displayQueue();
        

    }
}
