package com.java.DSAQuestions.Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    public static void reverseQueue(Queue<Integer> res, int size) {
        // Approach-1(using array)
        // TC=O(n), SC=O(n)

        /*
        int[] arr = new int[size];

        int i=0;
        while(i< size){
            arr[i] = res.remove();
            i++;
        }

        int n = arr.length;
        for (int j = n-1; j >= 0 ; j--) {
            res.add(arr[j]);
        }

         */

        // Approach-2(using stack)
        // TC=O(n), SC=O(n)

        Stack<Integer> st = new Stack<>();

        while(!res.isEmpty()) {
            st.push(res.remove());
        }

        while(!st.empty()){
            res.add(st.pop());
        }

    }

    // Function to reverse first k elements of a queue.
    public static void modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>();
        int i=0;

        // push first k elements into the stack
        while(i<k){
            st.push(q.remove());
            i++;
        }

        // store the size of queue
        int size = q.size();

        // empty the stack and push all ele in queue
        while(!st.empty()){
            q.add(st.pop());
        }

        // push first n elements of queue at last
        while(size!=0){
            q.add(q.remove());
            size--;
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

//        System.out.println("Before: ");
//        System.out.println(q);
//
//        System.out.println("After: ");
//        reverseQueue(q, q.size());
//        System.out.println(q);

        System.out.println("Before: ");
        System.out.println(q);

        System.out.println("After: ");
        modifyQueue(q, 3);
        System.out.println(q);
    }
}
