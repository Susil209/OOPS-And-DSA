package com.java.DSAQuestions.Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;

public class DequeCollection {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

//        dq.removeLast();
//        System.out.println(dq); // NoSuchElementFoundException

        dq.offerFirst(10);
        dq.offerLast(20);
        dq.offerFirst(30);
        dq.offerLast(40);

        System.out.println(dq); // [30, 10, 20, 40]

        System.out.println("Size : "+dq.size()); // 4
        System.out.println("First ele : "+dq.getFirst());
        System.out.println("Last ele : "+dq.getLast());

        System.out.println("Pop first ele ");
        dq.removeFirst();
        System.out.println(dq);

        System.out.println("Pop last ele ");
        dq.removeLast();
        System.out.println(dq);

    }
}
