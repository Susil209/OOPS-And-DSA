package com.java.finalModifier;

// list of duplicates name, map to keep track of count of
// distinct names. Standardize names before they printed for mailing.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {
    public static void main(String[] args) {
        String[] names = {"Ann Jones", "Ann Johns Ph.D", "Bob Jones M.D", "Carol Jones", "Ed Green Ph.D",
                "Ed Green M.D", "Ed Black"};

        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum); // if name is not yet in map assign value 1
            // else if name is already present assign total count sum
        });
        System.out.println(counts);

        // count of ann johns Ph-D
        StringBuilder annJonesPhd = new StringBuilder("Ann Johns Ph.D");
        System.out.println("There are " + counts.get(annJonesPhd) + " records for " + annJonesPhd);
    }

    // random list of names
    private static List<StringBuilder> getNames(String[] names) {
        List<StringBuilder> list = new ArrayList<>();
        // index to determine how many names to add in list for each distinct name
        int index = 3;

        // add number of same names in the list determined by value if index variable
        for (String name : names) {
            for (int i = 0; i < index; i++) {
                list.add(new StringBuilder(name));
            }
            index++;
        }

        return list;
    }
}
