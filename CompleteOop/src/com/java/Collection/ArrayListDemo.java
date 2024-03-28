package com.java.Collection;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> l = new ArrayList<>();
        l.add("A");
        l.add(10);
        l.add("A"); // Duplicates
        l.add(null);

        // Internally toString() method is called for Collection
        System.out.println(l); // [A,10,A,null] -> Insertion order preserved

        l.remove(2);
        System.out.println(l); // [A,10,null]

        l.add(2,"X");
        l.add(7);

        System.out.println(l); // [A,10,X,null,7]

    }
}
