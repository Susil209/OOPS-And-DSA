package com.java.Collection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        // follows default natural sorting order
//        TreeSet<Object> t = new TreeSet<>();

        // customized sorting order(descending order)
        TreeSet<StringBuffer> t = new TreeSet<StringBuffer>(new MyComparator3());


        //add elements(String class Objects) in tree set
        /*
        t.add("A");
        t.add("a");
        t.add("B");
        t.add("Z");
        t.add("L");
        t.add("M");

         */



//         t.add(10); //ClassCastException
//        t.add(null); //NullPointerException



        // Adding StringBuffer Objects in TreeSet
        t.add(new StringBuffer("A"));
        t.add(new StringBuffer("B"));
        t.add(new StringBuffer("Z"));
        t.add(new StringBuffer("X"));
        t.add(new StringBuffer("L"));

        // By default, the elements will be sorted
        // in Ascending order
        System.out.println(t);

    }


}

class MyComparator3 implements Comparator<Object>{
    public int compare(Object o1, Object o2){
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s2.compareTo(s1); // [Z, X, L, B, A]
    }
}
