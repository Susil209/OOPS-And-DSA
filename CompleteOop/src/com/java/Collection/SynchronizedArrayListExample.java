package com.java.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedArrayListExample {
    public static void main(String[] args) {
        // Create a regular ArrayList
        List<String> arrayList = new ArrayList<>();

        // Add elements to the ArrayList
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");

        // Create a synchronized version of the ArrayList
        List<String> synchronizedList = Collections.synchronizedList(arrayList);

        // Now, 'synchronizedList' can be safely accessed by multiple threads
        // and all its operations are synchronized.

        // Example of adding an element to the synchronized list
        synchronizedList.add("Item 4");

        // Example of iterating over the synchronized list
        synchronized (synchronizedList) {
            for (String item : synchronizedList) {
                System.out.println(item);
            }
        }
    }
}
