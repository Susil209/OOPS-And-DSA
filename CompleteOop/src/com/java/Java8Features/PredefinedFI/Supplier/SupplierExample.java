package com.java.Java8Features.PredefinedFI.Supplier;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Double> value = () -> Math.floor(Math.random()*10);
        System.out.println(value.get()); // getting the random value
    }
}
