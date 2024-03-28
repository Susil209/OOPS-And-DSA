package com.java.DSAQuestions.Queue;

import java.util.Stack;

public class QueueImplUsingStack {

    private int front;
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();

    boolean empty(){
        return st1.isEmpty() && st2.isEmpty();
    }

    void push(int x) {
        if(st1.isEmpty()){
            front = x;
        }
        st1.push(x);
    }

    int pop() {
        if(empty()) return 0;
        if(!st2.isEmpty()){
            int removedEle = st2.peek();
            st2.pop();
            return removedEle;
        }else {
            while(!st1.isEmpty()){
                st2.push(st1.peek());
                st1.pop();
            }
            int removedEle = st2.peek();
            st2.pop();
            return removedEle;
        }
    }

    int peek() {
        if(empty()) return 0;
        if(!st2.isEmpty()){
            return st2.peek();
        }

        return front;
    }


    public static void main(String[] args) {
        QueueImplUsingStack q = new QueueImplUsingStack();
        q.push(10);
        q.push(20);
        q.push(30);

        int popEle = q.pop();
        int frontEle = q.peek();

        boolean isEmpty = q.empty();

        System.out.println("Removed ele "+ popEle + ",front ele "+ frontEle + ", is queue empty "+ isEmpty);
    }
}
