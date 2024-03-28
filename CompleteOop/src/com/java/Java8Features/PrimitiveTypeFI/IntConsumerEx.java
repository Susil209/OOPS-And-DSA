package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.IntConsumer;

public class IntConsumerEx {
    public static void main(String[] args) {
        IntConsumer c = i -> System.out.println(i*i);
        c.accept(100);
        /*
            LongConsumer
            DoubleConsumer
         */
    }
}
