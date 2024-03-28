package com.java.Collection;

import java.util.Comparator;
import java.util.TreeSet;

// problem statement: write a program to insert 'String' & 'StringBuffer' objects
// into the TreeSet where sorting order is in increasing order.
// If 2 objects have same length then consider their alphabetical order.

public class TreeSetExample4 {
    public static void main(String[] args) {
        TreeSet<Object> t= new TreeSet<Object>(new MyComparator4());

        t.add(new StringBuffer("ABC"));
        t.add("A");
        t.add("XX");
        t.add(new StringBuffer("AA"));
        t.add("ABCD");

        System.out.println(t); // [A, AA, XX, ABC, ABCD]
    }


}

class MyComparator4 implements Comparator{
    public int compare(Object o1, Object o2){
        // convert object into string
        String s1 = o1.toString();
        String s2 = o2.toString();

        int l1 = s1.length(), l2 = s2.length();
        if(l1<l2) return -1;
        else if(l1>l2) return 1;
        else return s1.compareTo(s2);
    }
}
