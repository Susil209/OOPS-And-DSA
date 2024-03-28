package com.java.Map;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Default natural sorting order
        TreeMap<Object,Object> t = new TreeMap<>();

        //add key,value
        t.put(100,"John");
        t.put(200,"Jane");
        t.put(300,"Joe");
        t.put(400,900);

        // t.put("Green","Light"); // RE : java.lang.ClassCastException
        // t.put(null,"Root"); // RE : java.lang.NullPointerException

        System.out.println(t); // { 100=John, 200=Jane, 300=Joe, 400=900}
    }
}
