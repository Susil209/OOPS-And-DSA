package com.java.Java8Features.PredefinedFI.Supplier;

import java.util.Date;
import java.util.function.Supplier;

// Program to get System Date by using Supplier

public class SupplierEx1 {
    public static void main(String[] args) {
        Supplier<Date> date = () -> new Date();
        System.out.println(date.get());
    }
}
