package com.java.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListReverseExample {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(89);
        l.add(56);
        l.add(100);
        l.add(10);
        l.add(45);

        System.out.println("Before reverse: "+l); // Before reverse: [89, 56, 100, 10, 45]

        Collections.reverse(l);
        System.out.println("After reverse: "+l); // After reverse: [45, 10, 100, 56, 89]
    }
}
