package com.java.DSAQuestions.Queue;


import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrintQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        int n = q.size();
        while(n!=0) {
            System.out.print(q.peek()+" ");
            q.add(q.peek());
            q.poll();
            n--;
        }
//        System.out.println(q);
    }
}
