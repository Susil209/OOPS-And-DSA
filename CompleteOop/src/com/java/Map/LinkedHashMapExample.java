package com.java.Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Create a LinkedHashMap with access order
        Map<String, Integer> studentScores = new LinkedHashMap<>(16, 0.75f, true);

        // Add key-value pairs
        studentScores.put("Alice", 90);
        studentScores.put("Bob", 85);
        studentScores.put("Charlie", 78);

        System.out.println(studentScores); // insertion order is preserved
        // {Alice=90, Bob=85, Charlie=78}


        // Retrieve values
        int aliceScore = studentScores.get("Alice");
        System.out.println("Alice's score: " + aliceScore);

        // Accessing Bob will change the order
        int bobScore = studentScores.get("Bob");
        System.out.println(bobScore);

        // Iterate over keys and values (in access order)
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Score: " + entry.getValue());
        }
    }
}
