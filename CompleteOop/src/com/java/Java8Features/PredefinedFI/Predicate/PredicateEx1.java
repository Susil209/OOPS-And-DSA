package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.function.Predicate;

public class PredicateEx1 {
    // print all the names stats with "K"
    public static void main(String[] args) {
        String[] names = {"Sunny","Kajal","Katrina","Kareena","Deepika"};
        Predicate<String> p = s -> s.charAt(0) == 'K';

        for (String s1: names) {
            if (p.test(s1)){
                System.out.println(s1);
            }
        }
    }
}
