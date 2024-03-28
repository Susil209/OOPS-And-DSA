package com.java.Java8Features.PredefinedFI.Supplier;

import java.util.function.Supplier;

// Program to get Random OTP by using Supplier

public class SupplierEx3 {
    public static void main(String[] args) {

        Supplier<String> generateOtp = () -> {
            StringBuilder otp= new StringBuilder();
            for (int i = 0; i < 6; i++) {
                otp.append((int) (Math.random() * 10));
            }

            return otp.toString();
        };

        System.out.println("OTP is: "+ generateOtp.get());


        /*
        Supplier<Integer> generateOtp = () -> (int)(Math.random()*10);

        System.out.println("OTP is : ");

        for (int i = 0; i < 6; i++) {
            System.out.print(generateOtp.get());
        }

         */
    }
}
