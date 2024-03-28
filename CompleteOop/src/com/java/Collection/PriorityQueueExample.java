package com.java.Collection;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {

        // default natural sorting order
        PriorityQueue<Object> q = new PriorityQueue<>();

        // System.out.println(q.peek()); // null
        // System.out.println(q.element()); // RE : java.util.NoSuchElementException

        for (int i = 0; i < 11; i++) {
            q.offer(i);
        }

        System.out.println(q); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(q.poll()); // 0

        // insertion order is not preserved
        System.out.println(q); // [1, 3, 2, 7, 4, 5, 6, 10, 8, 9]
    }
}
