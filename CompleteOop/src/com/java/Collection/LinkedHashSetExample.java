package com.java.Collection;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<Object> h = new LinkedHashSet<>();

        // Adding elements to the HashSet
        h.add("Apple");
        h.add("Banana");
        h.add("Cherry");
        h.add(null);
        h.add(10);
        // Duplicate, won't be added
        System.out.println(h.add("Banana"));  //false
        System.out.println(h); // [Apple, Banana, Cherry, null, 10]
    }
}
