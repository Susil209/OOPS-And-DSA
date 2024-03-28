package com.java.Exception;

public class ExceptionPrintMethods {
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
        }
        catch (ArithmeticException e){
            //e.printStackTrace();  // java.lang.ArithmeticException: / by zero
                                                // at com.java.Exception.ExceptionPrintMethods.main(ExceptionPrintMethods.java:6)
           // System.out.println(e); // java.lang.ArithmeticException: / by zero
            System.out.println(e.getMessage()); // / by zero
        }
    }
}
