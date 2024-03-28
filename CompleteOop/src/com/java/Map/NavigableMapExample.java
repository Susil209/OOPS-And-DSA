package com.java.Map;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapExample {
    public static void main(String[] args) {
        NavigableMap<Integer,String> m = new TreeMap<>();

        m.put(5, "Five");
        m.put(10, "Ten");
        m.put(15, "Fifteen");
        m.put(20, "Twenty");
        m.put(25, "Twenty-Five");

        System.out.println(m); // {5=Five, 10=Ten, 15=Fifteen, 20=Twenty, 25=Twenty-Five}

        System.out.println("floor key to 15: "+m.floorKey(15)); // 15
        System.out.println("Lower key to 15: "+m.lowerKey(15)); // 10

        System.out.println("ceiling key to 10: "+m.ceilingKey(10)); // 10
        System.out.println("higher key to 10: "+m.higherKey(10)); // 15

        System.out.println("floor entry to 15: "+m.floorEntry(15));
        System.out.println("Lower entry to 15: "+m.lowerEntry(15));

        System.out.println("ceiling entry to 10: "+m.ceilingEntry(10));
        System.out.println("higher entry to 10: "+m.higherEntry(10));

        System.out.println(m.pollFirstEntry());
        System.out.println(m.pollLastEntry());

        System.out.println("Descending map: "+m.descendingMap());
        System.out.println(m);


    }
}
