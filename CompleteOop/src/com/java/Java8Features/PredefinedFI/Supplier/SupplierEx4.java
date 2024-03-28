package com.java.Java8Features.PredefinedFI.Supplier;

import java.util.function.Supplier;

// 8 digit password
// at even place number between 0-9
// at odd place Uppercase letter or symbols like @,#,$

public class SupplierEx4 {
    public static void main(String[] args) {

        Supplier<StringBuilder> password = () -> {
            StringBuilder generatedPassword = new StringBuilder();

            Supplier<Integer> digitsSupplier = () -> (int) (Math.random() * 10);

            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
            Supplier<Character> characterSupplier = () -> symbols.charAt((int) (Math.random() * symbols.length()));

            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) generatedPassword.append(digitsSupplier.get());
                else generatedPassword.append(characterSupplier.get());
            }

            return generatedPassword;
        };

        System.out.println(password.get());
    }
}
