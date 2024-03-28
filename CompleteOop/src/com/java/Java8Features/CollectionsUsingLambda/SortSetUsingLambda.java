package com.java.Java8Features.CollectionsUsingLambda;

import java.util.TreeSet;

public class SortSetUsingLambda {
    public static void main(String[] args) {
        // Default natural sorting order
//        TreeSet<Integer> t = new TreeSet<>();

        // Custom sorting using lambda
        TreeSet<Integer> t = new TreeSet<>((I1,I2) -> I2.compareTo(I1));


        t.add(10);
        t.add(20);
        t.add(5);
        t.add(15);
        t.add(0);

        System.out.println("After sorting -> "+ t);

    }
}
