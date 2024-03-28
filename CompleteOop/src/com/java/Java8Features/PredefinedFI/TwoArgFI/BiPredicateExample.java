package com.java.Java8Features.PredefinedFI.TwoArgFI;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        // check if sum of two numbers are even
        BiPredicate<Integer,Integer> bp = (x,y) -> (x+y) % 2 ==0;
        System.out.println(bp.test(10,20)); // true

    }
}
