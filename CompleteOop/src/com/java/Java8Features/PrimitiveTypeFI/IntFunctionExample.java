package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.IntFunction;

public class IntFunctionExample {
    public static void main(String[] args) {
        // here Integer is return type
        IntFunction<Integer> f = i -> i*2;
        System.out.println(f.apply(10));

        /*
            LongFunction<R>
            DoubleFunction<R>
         */
    }
}
