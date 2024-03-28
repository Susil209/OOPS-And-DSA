package com.java.Collection;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample2 {
    public static void main(String[] args) {
        // customized sorting order
        PriorityQueue<Object> pq = new PriorityQueue<>
                            (15,new MyComparatorX());

        // add elements
        pq.offer("A");
        pq.offer("L");
        pq.offer("Z");
        pq.offer("K");
        pq.offer("C");

        System.out.println(pq); // [Z, L, K, C, A]

    }
}

class MyComparatorX implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s2.compareTo(s1);
    }
}
