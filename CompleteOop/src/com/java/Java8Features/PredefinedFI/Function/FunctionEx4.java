package com.java.Java8Features.PredefinedFI.Function;

import java.util.function.Function;

public class FunctionEx4 {
    public static void main(String[] args) {
        // program to remove spaces from string
        String quote = "Hi there,my name is Bikash.It is nice to meet you.";
//        Function<String, String> removeSpaces = s -> s.replaceAll(" ","");
//        System.out.println(removeSpaces.apply(quote));

        // count no of spaces in the string

        // string length with space - string length without space
        Function<String, Integer> countSpaces =
                s -> s.length() - s.replaceAll(" ", "").length();

        /*
        Function<String, Integer> countSpaces = s -> {
            int count = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') count++;
            }

            return count;
        };

         */

        System.out.println(countSpaces.apply(quote));

    }
}
