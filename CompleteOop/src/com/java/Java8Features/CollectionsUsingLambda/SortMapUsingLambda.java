package com.java.Java8Features.CollectionsUsingLambda;

import java.util.TreeMap;

public class SortMapUsingLambda {
    public static void main(String[] args) {

        // Custom sorting using lambda
        TreeMap<Integer,String> t
                = new TreeMap<>((I1,I2) -> I2.compareTo(I1));

        t.put(70,"A");
        t.put(90,"K");
        t.put(40,"Z");
        t.put(20,"L");

        System.out.println(t); //{90=K, 70=A, 40=Z, 20=L}
    }
}
