package com.java.introduction;

import java.util.Stack;

public class Test {
    static int c;
    // final static int x; -> // CE: x might not have been initialized

    final static int x;

    // static block
    static {
        x=10;
    }

    public static void main(String[] args) {
        // JVM will provide default value for static variable
        System.out.println(c); // 0
        System.out.println(x); // 10

        // public int p = 10; ->// illegal start of expression
    }
}
