package com.java.JavaLangPackage.WrapperClass;

public class BooleanClass {
    public static void main(String[] args) {
        Boolean X = Boolean.valueOf("true"); // true
        Boolean Y = Boolean.valueOf("yes"); // false

        Boolean B = Boolean.getBoolean("oops"); // false
        Boolean Z = Boolean.getBoolean("true"); // false

        System.out.println(X);
        System.out.println(Y);
        System.out.println(B);
        System.out.println(Z);
    }
}
