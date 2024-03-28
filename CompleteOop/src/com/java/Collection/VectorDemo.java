package com.java.Collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Object> v = new Vector<>();
        System.out.println(v.capacity()); //10

        // Adding 10 elements
        for (int i = 0; i < 10; i++) {
            v.addElement(i);
        }

        System.out.println(v.capacity()); // 10

        // Adding elements to the Vector
        v.addElement("Apple");
        v.addElement("Banana");
        v.addElement("Cherry");

        System.out.println(v.capacity()); //20

        // Accessing elements
        Object firstElement = v.firstElement();
        Object lastElement = v.lastElement();

        System.out.println(firstElement + " and " + lastElement );

        // Iterating through the Vector using an Enumeration
        Enumeration<Object> e = v.elements();
        while (e.hasMoreElements()) {
            Object items = e.nextElement();
            System.out.println(items);
        }

        System.out.println(v);
    }
}
