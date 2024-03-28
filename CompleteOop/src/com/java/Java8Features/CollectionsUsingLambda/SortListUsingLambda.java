package com.java.Java8Features.CollectionsUsingLambda;

import java.util.ArrayList;
import java.util.Collections;

public class SortListUsingLambda {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(20);
        l.add(5);
        l.add(15);
        l.add(0);

        System.out.println("Before sorting -> "+l);

        // sort using lambda expression
        Collections.sort(l,(o1, o2) -> o2.compareTo(o1));
        System.out.println("After sorting -> "+l);
    }
}
