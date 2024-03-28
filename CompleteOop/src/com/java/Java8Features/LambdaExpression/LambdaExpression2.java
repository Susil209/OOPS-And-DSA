package com.java.Java8Features.LambdaExpression;

public class LambdaExpression2 {
    public static void main(String[] args) {

        // Lambda Expression
        // Runnable in inbuilt Functional Interface having only one abstract method run
        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread");
            }
        };

        Thread t= new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}
