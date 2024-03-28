package com.java.StaticControlFlow;

public class Derived extends Base{
    static int x = 100;
    static {
        m2();
        System.out.println("Derived class first static block");
    }

    public static void main(String[] args) {
        m2();
        System.out.println("Derived main method");
    }

    public static void m2(){
        System.out.println(y);
    }

    static {
        System.out.println("Derived class second static block");
    }

    static int y = 200;
}
