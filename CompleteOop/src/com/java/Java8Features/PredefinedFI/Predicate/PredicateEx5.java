package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.function.Predicate;

public class PredicateEx5 {
    public static void main(String[] args) {
        Predicate<String> ans = Predicate.isEqual("Deepika");
        System.out.println((ans.test("Deepika")));
    }
}
