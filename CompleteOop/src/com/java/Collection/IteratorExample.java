package com.java.Collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        // Create a list of Integers
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            l.add(i);
        }
        System.out.println(l); // [0,1,2,...,10]

        // Obtain an Iterator for the list
        Iterator<Integer> it = l.iterator();

        // Iterate over the elements using Iterator
        while (it.hasNext()) {
            Integer I = it.next();
            if(I%2==0)
                System.out.println(I); // 0 2 4 6 8 10
            else
                it.remove();
        }

        System.out.println(l); // [0,2,4,6,8,10]
    }
}
