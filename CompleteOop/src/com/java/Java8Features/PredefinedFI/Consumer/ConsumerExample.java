package com.java.Java8Features.PredefinedFI.Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        c.accept("Hello Consumer"); // Hello Consumer

        Consumer<List<Integer>> list = s -> {
            for (Integer i:
                 s) {
                System.out.println(i*100);
            }
        };

        list.accept(Arrays.asList(2,3,9,7)); // 200 300 900 700
    }
}
