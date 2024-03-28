package com.java.Map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapExample2 {
    public static void main(String[] args) {
        // Customized sorting order
        TreeMap<Object,Object> t = new TreeMap<>(new MyComparator());

        t.put("XXX",70);
        t.put("ZZZ",90);
        t.put("AAA",40);
        t.put("LLL",20);

        System.out.println(t); // {ZZZ=90, XXX=70, LLL=20, AAA=40}

    }
}

class MyComparator implements Comparator<Object>{
    public int compare(Object o1, Object o2){
        String s1 = o1.toString();
        String s2 = o2.toString();
        return s2.compareTo(s1); // Descending
    }
}
