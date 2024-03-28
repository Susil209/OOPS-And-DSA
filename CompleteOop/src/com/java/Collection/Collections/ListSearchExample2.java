package com.java.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSearchExample2 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(17);
        l.add(8);
        l.add(39);
        l.add(23);
        l.add(6);

        System.out.println(l); // [17, 8, 39, 23, 6]
        Collections.sort(l,new MyComparatorS());

        System.out.println("Customized sorted list: "+l);
                // Customized sorted list: [39, 23, 17, 8, 6]
                                //  index   0    1   2  3  4
                    // insertion points     -1  -2  -3  -4 -5


        System.out.println(Collections.binarySearch(l,17,new MyComparatorS()));//2
        System.out.println(Collections.binarySearch(l,20,new MyComparatorS()));//-3

        System.out.println(Collections.binarySearch(l,10)); // unpredictable result

    }
}

class MyComparatorS implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2.compareTo(i1);
    }
}