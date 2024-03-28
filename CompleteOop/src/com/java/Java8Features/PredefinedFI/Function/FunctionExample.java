package com.java.Java8Features.PredefinedFI.Function;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        // find length of string

        /*
        Function<String,Integer> f = s -> s.length();
        System.out.println(f.apply("Java")); // 4
        System.out.println(f.apply("String")); // 6

         */

        //convert string to uppercase
        /*
        Function<String,String> f = s -> s.toUpperCase();
        System.out.println(f.apply("Java")); // JAVA
        System.out.println(f.apply("String")); // STRING

         */

        // get the first three characters
        Function<String,String> f = s -> s.substring(0,3);
        System.out.println(f.apply("Function")); // Fun


    }
}
