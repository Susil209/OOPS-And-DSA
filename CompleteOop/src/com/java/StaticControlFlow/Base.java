package com.java.StaticControlFlow;

public class Base {
    static int i=10;
    static {
        m1();
        System.out.println("Base class static block");
    }

    public static void main(String[] args) {
        m1();
        System.out.println("Base class main method");
    }

    public static void m1(){
        System.out.println(j);
    }
    static int j=20;
}
