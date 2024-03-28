package com.java.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortExample2 {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Z");
        l.add("L");
        l.add("A");
        l.add("C");

        System.out.println("Before sorting :"+l); // Before sorting :[Z, L, A, C]

        Collections.sort(l,new MyComparatorM());
        System.out.println("After sorting :"+l); // After sorting :After sorting :[Z, L, C, A]
    }
}

class MyComparatorM implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        String s1 =o1.toString();
        String s2 = o2.toString();
        return s2.compareTo(s1);
    }
}
