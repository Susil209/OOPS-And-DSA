package com.java.Exception;

// Unchecked Exception

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class UncheckedExceptionExample {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("abc.txt");
        pw.write("Hello");
        System.out.println(10/0); // runtime exception
    }
}

/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at com.java.Exception.UncheckedExceptionExample.main(UncheckedExceptionExample.java:12)
 */
