package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.IntToDoubleFunction;

public class IntToDoubleEx {
    public static void main(String[] args) {
        IntToDoubleFunction f = x -> x*3.98;
        System.out.println(f.applyAsDouble(10)); // 39.8
        /*
            IntToLongFunction

            LongToIntFunction
            LongToDoubleFunction

            DoubleToIntFunction
            DoubleToLongFunction
         */
    }
}
