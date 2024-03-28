package com.java.Java8Features.PredefinedFI.Supplier;

import java.util.function.Supplier;

public class SupplierEx2 {
    public static void main(String[] args) {

        String[] names = {"Akash","Nill","Pratham","John"};
        Supplier<String> name = () -> names[(int)(Math.random()*4)];

        System.out.println(name.get());
    }
}
