package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    public static void main(String[] args) {

        int[] nums = {0, 2, 34, 5, 12, 33, 12, 242};

        IntPredicate i = x -> x % 2 == 0;
        for (int num : nums) {
            if(i.test(num)) System.out.println(num);
        }

        /*
            LongPredicate
            DoublePredicate
         */
    }
}
