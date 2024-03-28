package com.java.Collection;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        //Create a LinkedList of Objects
        LinkedList<Object> l = new LinkedList<>();

        // Adding elements
        l.add("Apple");
        l.add(10);
        l.add("Apple");
        l.add(null);

        System.out.println(l); // [Apple, 10, Apple, null]

        // Accessing elements
        Object firstElement = l.getFirst();
        Object lastElement = l.getLast();

        // Iterating through the LinkedList
        for (Object o : l) {
            System.out.println(o);
        }

        //Removing elements
        l.removeFirst(); //[10,"Apple",null]
        l.removeLast(); //[10,"Apple"]

        // Inserting elements at specific positions
        l.add(1, "Grapes"); // [10,Grapes,Apple]

        // Size of the LinkedList
        int size = l.size(); // 3

        l.set(0,77); //[77,Grapes,Apple]
        System.out.println(l);

    }
}
