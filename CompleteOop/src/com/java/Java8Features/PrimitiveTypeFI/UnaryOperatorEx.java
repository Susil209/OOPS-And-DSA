package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorEx {
    public static void main(String[] args) {
        UnaryOperator<Integer> u = x -> x*x;
        System.out.println(u.apply(10));

        IntUnaryOperator x = i -> i*100;
        System.out.println(x.applyAsInt(9));

        /*
            LongUnaryOperator
            DoubleUnaryOperator
         */
    }
}
