package com.java.introduction;

import static java.lang.System.out;

import static java.lang.Integer.MAX_VALUE; // ---- (2) Explicit static import
import static java.lang.Byte.*; // ---- (3)  Implicit static import

/*
* While resolving "static" member compiler will always take precedence
* in the following order.
*
*   1. Current class static member
*   2. Explicit static import
*   3. Implicit static import
*
* */

public class StaticImport {
    static int MAX_VALUE = 999; // ---- (1) Current class static member

    public static void main(String[] args) {
        out.println("Hello");
        out.println("Static import");

        out.println(MAX_VALUE); // 999
    }
}
