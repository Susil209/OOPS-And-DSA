package com.java.Collection;

import java.util.Comparator;
import java.util.TreeSet;

// problem statement: write a program to insert integer objects into the TreeSet
// where sorting order is descending.

public class TreeSetExample2 {
    public static void main(String[] args) {
        // Using customized sorting
        TreeSet<Integer> t = new TreeSet<Integer>(new MyComparator());
        t.add(10);
        t.add(0);
        t.add(5);
        t.add(20);
        t.add(15);
        t.add(20);
        System.out.println(t); // [20, 15, 10, 5, 0]
    }

}

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Integer I1 = (Integer) o1;
        Integer I2 = (Integer) o2;

        if(I1 < I2)
            return +1;
        else if (I1 > I2)
            return -1;
        else
            return 0;
    }
}
