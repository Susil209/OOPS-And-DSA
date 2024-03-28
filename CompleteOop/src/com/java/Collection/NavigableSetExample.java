package com.java.Collection;

import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        NavigableSet<Integer> s = new TreeSet<>();

        s.add(10);
        s.add(15);
        s.add(20);
        s.add(30);
        s.add(50);

        System.out.println(s); //[10, 15, 20, 30, 50]

        System.out.println("floor to 20: "+s.floor(20)); // 20
        System.out.println("Lower to 20: "+s.lower(20)); // 15
        System.out.println("Ceiling to 15: " + s.ceiling(15)); // 15
        System.out.println("Higher to 15:" + s.higher(15)); // 20
        System.out.println(s.pollFirst()); //10
        System.out.println(s.pollLast()); //50

        System.out.println("Descending set: "+ s.descendingSet()); // [30,20,15]
        System.out.println(s); // [15,20,30]
    }
}
