package com.java.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSearchExample {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Z");
        l.add("A");
        l.add("K");
        l.add("M");
        l.add("a");

        // Insertion order preserved
        System.out.println(l); // [Z, A, K, M, a]

        // sorting the list
        Collections.sort(l);
        System.out.println("Sorted list :"+ l); // [A, K, M, Z, a]
                                           // index 0  1  2  3  4
                               // insertion point  -1 -2 -3 -4 -5

        // Binary search
        System.out.println(Collections.binarySearch(l,"K")); // 1
        System.out.println(Collections.binarySearch(l,"J")); // -2

        System.out.println("list is :" + l);

    }
}
