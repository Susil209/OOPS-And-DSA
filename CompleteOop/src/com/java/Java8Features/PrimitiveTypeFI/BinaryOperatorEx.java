package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class BinaryOperatorEx {
    public static void main(String[] args) {
        BinaryOperator<String> b = (s1,s2) -> s1+s2;
        System.out.println(b.apply("Hello","World"));

        IntBinaryOperator bi = (i,j) -> i+j;
        System.out.println(bi.applyAsInt(10,20));

        /*
            LongBinaryOperator
            DoubleBinaryOperator
         */
    }
}
