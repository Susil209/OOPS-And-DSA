package com.java.Java8Features.MethodReference;

import java.util.function.IntBinaryOperator;

public class MethodRefEx4 {

    static int Sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        IntBinaryOperator i = MethodRefEx4::Sum;
        System.out.println(i.applyAsInt(10, 20));

    }
}
