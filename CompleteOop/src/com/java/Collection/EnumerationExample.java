package com.java.Collection;

import java.util.Vector;
import java.util.Enumeration;

public class EnumerationExample {
    public static void main(String[] args) {
        // Create a Vector and add elements
        Vector<String> vector = new Vector<>();
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Obtain an Enumeration for the Vector
        Enumeration<String> enumeration = vector.elements();

        // Iterate over the elements using Enumeration
        while (enumeration.hasMoreElements()) {
            String element = enumeration.nextElement();
            System.out.println(element);
        }
    }
}
