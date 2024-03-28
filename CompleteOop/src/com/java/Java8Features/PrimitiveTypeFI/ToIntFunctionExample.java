package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.ToIntFunction;

public class ToIntFunctionExample {
    public static void main(String[] args) {
        // here String is input type
        ToIntFunction<String> f = s -> s.length();
        System.out.println(f.applyAsInt("Function")); // it returns int primitive value

        /*
            ToLongFunction<T>
            ToDoubleFunction<T>
         */
    }
}
