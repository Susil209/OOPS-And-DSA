package com.java.Exception;

public class NestedTryCatchFinally {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try block");
            try {
                System.out.println("Inner try block");
                System.out.println(10/0);
            }
            catch (ArithmeticException ae){
                System.out.println("Inner catch block");
            }
            System.out.println("Outside of inner catch block");
        }
        catch (Exception e){
            System.out.println("Outer catch block");
        }
        finally {
            System.out.println("Outer finally block");
        }
    }
}
