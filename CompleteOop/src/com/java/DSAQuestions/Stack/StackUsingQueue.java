package com.java.DSAQuestions.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    // Using 2 Queues
    /*
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    void push(int x){
        if(empty()) q1.add(x);
        else if(q1.isEmpty()) q2.add(x);
        else q1.add(x);
    }

    int pop() {
        if(empty()) return 0;
        if(q1.isEmpty()) {
            while(q2.size()>1){
                q1.add(q2.remove());
            }

            return q2.remove();
        }else {
            while(q1.size()>1){
                q2.add(q1.remove());
            }

            return q1.remove();
        }
    }

    int top(){
        if(empty()) return 0;
        if (!q1.isEmpty()) {
            return q1.element();
        }if(!q2.isEmpty()) {
            return q2.element();
        }

        return 0;
    }

     */


    // Using One queue
    Queue<Integer> q = new LinkedList<>();

    void push(int x){
        q.add(x);
        for (int i = 0; i < q.size(); i++) {
            q.add(q.remove());
        }
    }

    int pop(){
        return q.remove();
    }

    boolean empty(){
        return q.isEmpty();
    }

    int top(){
        if(!q.isEmpty()) return q.peek();
        return 0;
    }


    public static void main(String[] args) {
        StackUsingQueue s = new StackUsingQueue();

        s.push(19);
        s.push(303);
        s.push(89);

//        System.out.println(s.q1);
//        System.out.println(s.q2);

        System.out.println(s.pop());

//        System.out.println(s.q1);
//        System.out.println(s.q2);
        System.out.println(s.empty());
        System.out.println(s.top());
    }
}
