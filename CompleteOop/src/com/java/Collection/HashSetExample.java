package com.java.Collection;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Object> h = new HashSet<>();

        // Adding elements to the HashSet
        h.add("Apple");
        h.add("Banana");
        h.add("Cherry");
        h.add(null);
        h.add(10);
        // Duplicate, won't be added
        System.out.println(h.add("Banana"));  //false
        System.out.println(h);  // cannot say as insertion order is not preserved
        // each object has specific hashcode
    }
}
