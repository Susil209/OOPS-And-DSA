package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateEx2 {
    // Remove all null values and empty string from the list

    public static void main(String[] args) {
        String[] names = {"Ravi","","Shiva","",null,"Durga",null};
        Predicate<String> p = s -> s != null && !s.isEmpty();

        ArrayList<String> al = new ArrayList<>();

        for (String s1: names) {
            if (p.test(s1)){
                al.add(s1);
            }
        }

        System.out.println(al);
    }

}
