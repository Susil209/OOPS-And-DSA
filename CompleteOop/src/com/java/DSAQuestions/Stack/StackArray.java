package com.java.DSAQuestions.Stack;

class Stack {
    private static final int DEFAULT_SIZE = 10;
    int top = -1;
    int[] st;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        this.st = new int[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == st.length - 1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack overflow");
        } else {
            top++;
            st[top] = x;
        }

    }

    public int pop() throws StackException {
        if(isEmpty()){
            System.out.println("Stack underflow");
            throw new StackException("Elements can't pop out of empty stack.");
        }
        return st[top--];
    }


    //peek the given index
    public int peek(int index) throws StackException {
        if(top-index+1<0){
            throw new StackException("Invalid index");
        }
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty stack.");
        }

        return st[top-index+1];
    }


    //stack top
    public int stackTop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty stack.");
        }
        return st[top];
    }



    public void displayStack(){
        for (int i = top; i>=0 ; i--) {
            System.out.print(st[i]+" ");
        }
        System.out.println();
    }
}

public class StackArray {
    public static void main(String[] args) throws StackException {
//        Stack s = new Stack(5);
        Stack s = new DynamicStack(5);

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);


        System.out.println("After inserting elements:");
        s.displayStack();
//
//        System.out.println("Removed element="+s.pop());
//        System.out.println("After removing elements:");
//        s.displayStack();
//
//        s.push(40);
//        s.push(50);
//        s.displayStack();
//
//        System.out.println("Element at index is ="+s.peek(2));
//        System.out.println("Top element is="+s.stackTop());
    }
}
