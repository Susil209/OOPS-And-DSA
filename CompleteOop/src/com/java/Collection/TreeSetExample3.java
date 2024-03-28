package com.java.Collection;

import java.util.Comparator;
import java.util.TreeSet;

// problem statement: write a program to insert string objects into the TreeSet
// where all elements should be inserted according to reverse of
// alphabetical order.

public class TreeSetExample3 {
    public static void main(String[] args) {
        TreeSet<String> t= new TreeSet<String>(new MyComparator2());

        t.add("subham");
        t.add("susil");
        t.add("manoj");
        t.add("akbar");
        t.add("sushant");

        System.out.println(t); // [susil, sushant, subham, manoj, akbar]
    }
}

class MyComparator2 implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        // convert object into string
        String s1 = o1.toString();
        String s2 = (String) o2;


        // insert string in reverse alphabetical order
        return s2.compareTo(s1);
        // return -s1.compareTo(s2);
    }
}
