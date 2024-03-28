package com.java.Java8Features.MethodReference;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample {

    public static void main(String[] args) {
        Consumer<String> c = System.out::println;
        c.accept("Hello world");
    }
}
