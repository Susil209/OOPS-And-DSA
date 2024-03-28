package com.java.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortExample {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Z");
        l.add("L");
        l.add("A");
        l.add("C");
        // l.add(10); // RE: CCE
        // l.add(null); // RE:NPE

        System.out.println("Before sorting :"+l); // Before sorting :[Z, L, A, C]

        Collections.sort(l);
        System.out.println("After sorting :"+l); // After sorting :[A, C, L, Z]

    }
}
