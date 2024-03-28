package com.java.Collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("John");
        names.add("Doe");
        names.add("Jane");
        names.add("Dove");

        System.out.println(names);// [John,Doe,Jane,Dove]

        // Obtain a ListIterator for the list
        ListIterator<String> iterator = names.listIterator();

        // Iterate forward through the elements
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("Next element: " + element);
        }

        // Iterate backward through the elements
        while (iterator.hasPrevious()) {
            String element = iterator.previous();
            System.out.println("Previous element: " + element);
        }

        while(iterator.hasNext()){
            String s = iterator.next();
            switch (s) {
                case "Doe":
                    iterator.remove(); //[John,Jane,Dove]
                case "Dove":
                    iterator.add("Jarvis"); // [John,Jane,Dove,Jarvis]
                case "Jane":
                    iterator.set("James"); // [John,James,Dove,Jarvis]
            }
        }

        System.out.println(names);// [John,James,Dove,Jarvis]
    }
}
