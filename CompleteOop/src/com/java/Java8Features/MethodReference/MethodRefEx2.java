package com.java.Java8Features.MethodReference;

import java.util.Arrays;
import java.util.List;

public class MethodRefEx2 {

    static void print(String s){
        System.out.println(s);
    }


    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob","Ben","Ali");
//        names.forEach(s -> System.out.println(s)); // using lambda
        names.forEach(MethodRefEx2::print); // using method reference
    }
}
