package com.java.Collection.Arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {
    public static void main(String[] args) {
        String[] s = {"A","Z","L"};
        List<String> l = Arrays.asList(s);
        System.out.println(l); // [A,Z,L]

        s[0] = "H";
        System.out.println(l); // [H,Z,L]

        l.set(1,"U");
        for(String s1:s)
            System.out.print(s1+" "); // H U L
        System.out.println();

        // l.add("snake"); // RE: java.lang.UnsupportedOperationException
        // l.remove(1); //  RE: java.lang.UnsupportedOperationException
        // l.set(1,10); // CE: ArrayStoreException
    }
}
