package com.java.Java8Features.StreamAPI;

import java.util.stream.IntStream;

public class PrimitiveStream {
    public static void main(String[] args) {

        IntStream intStream = IntStream.range(1,5);
        intStream.forEach(c -> System.out.println(c)); // 1 2 3 4

        IntStream intStream1 = IntStream.rangeClosed(1,5);
        intStream1.forEach(c -> System.out.println(c)); // 1 2 3 4 5

        /*
            LongStream
            DoubleStream
         */
    }
}
