package com.java.Map;
import java.util.IdentityHashMap;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        IdentityHashMap<String, Integer> identityHashMap = new IdentityHashMap<>();

        // Create two String objects with the same content
        String key1 = new String("John");
        String key2 = new String("John");


        identityHashMap.put(key1, 1);
        identityHashMap.put(key2, 2); // key1 == key2 -> false, hence 2 different keys

        System.out.println(identityHashMap.size());  // Outputs: 2
        System.out.println(identityHashMap);  // Outputs: {John=1, John=2}
    }
}

