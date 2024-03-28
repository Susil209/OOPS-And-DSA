package com.java.Java8Features.PredefinedFI.Function;

import java.util.function.Function;

public class FunctionalChaining {
    public static void main(String[] args) {
        Function<Integer,Integer> f1 = i -> i*2;
        Function<Integer,Integer> f2 = i -> i*i*i;

        // first f1 execute , f1 = 10*2 = 20
        // and then f2 execute but taking the value of f1 result as argument
        // i.e f2 = 20*20*20 = 8000

        // andThen()
        System.out.println(f1.andThen(f2).apply(10)); // 8000
        System.out.println(f2.andThen(f1).apply(10)); // 2000

        //compose()
        System.out.println(f1.compose(f2).apply(10));


        //identity()
        Function<String,String> name = Function.identity();
        System.out.println(name.apply("John")); // John


    }
}
