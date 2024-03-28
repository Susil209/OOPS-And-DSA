package com.java.Collection.Arrays;

import java.util.Arrays;
import java.util.Comparator;


public class ArraysSortExample {
    public static void main(String[] args) {
        // array of primitive elements
        int[] a = {10,6,7,34,9};

        System.out.println("Primitive arrays before sorting : ");
        for (int x: a) {
            System.out.print(x + " "); // 10 6 7 34 9
        }
        System.out.println();

        // sorting array
        Arrays.sort(a);
        System.out.println("Primitive arrays after sorting : ");
        for (int x: a) {
            System.out.print(x + " "); // 6 7 9 10 34
        }
        System.out.println();

        // array  of object types
        String[] s = {"A","Z","K","B"};
        System.out.println("Object arrays before sorting : ");
        for (String x: s) {
            System.out.print(x + " "); // A Z K B
        }
        System.out.println();

        // sorting array (D.N.S.O)
        Arrays.sort(s);
        System.out.println("Object arrays after sorting : ");
        for (String x: s) {
            System.out.print(x + " "); // A B K Z
        }
        System.out.println();

        // sorting array (C.S.O)
        Arrays.sort(s,new MyComparatorK());
        System.out.println("Object arrays after sorting by comparator: ");
        for (String x: s) {
            System.out.print(x + " "); // Z K B A
        }
    }
}


class MyComparatorK implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}