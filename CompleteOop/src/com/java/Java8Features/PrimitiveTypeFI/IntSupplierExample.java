package com.java.Java8Features.PrimitiveTypeFI;

import java.util.function.IntSupplier;

public class IntSupplierExample {
    public static void main(String[] args) {
        IntSupplier s = () -> (int)(Math.random()*10);
        System.out.println(s.getAsInt());

        // LongSupplier ==> long getAsLong()
        // DoubleSupplier  ==> double getAsDouble()
    }
}
