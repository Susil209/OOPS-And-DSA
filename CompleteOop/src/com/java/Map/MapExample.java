package com.java.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        HashMap<String,Double> m = new HashMap<>();

        //put elements in the map
        m.put("Chennai", 97.3);
        m.put("Vellore", 105.2);
        m.put("Ooty", 17.5);
        m.put("Kanyakumari", 78.6);
        m.put("Kovai", 100.8);

        System.out.println("HashMap(keyValue pair:"+m);
        System.out.println("Key elements:"+m.keySet());
        System.out.println("Value elements:"+m.values());
        System.out.println();

        LinkedHashMap<String,Double> lm = new LinkedHashMap<>();

        lm.put("Chennai", 97.3);
        lm.put("Vellore", 105.2);
        lm.put("Ooty", 17.5);
        lm.put("Kanyakumari", 78.6);
        lm.put("Kovai", 100.8);

        System.out.println("LinkedHashMap(keyValue pair:"+lm);
        System.out.println("Key elements:"+lm.keySet());
        System.out.println("Value elements:"+lm.values());
        System.out.println();

        TreeMap<String,Double> tm = new TreeMap<>(lm);
        System.out.println("HashMap(keyValue pair:"+tm);
        System.out.println("Key elements:"+tm.keySet());
        System.out.println("Value elements:"+tm.values());
    }
}
