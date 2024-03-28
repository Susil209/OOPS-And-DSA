package com.java.JavaLangPackage.ObjectClass;

public class equalsMethod2 {
    public static void main(String[] args) {
        String s1 = new String("Dog");
        String s2 = new String("Dog");

        // == check for reference , so false
        System.out.println(s1 == s2); // false

        // In String class equals() is overridden to check for content, hence true
        System.out.println(s1.equals(s2)); // true

        StringBuffer sb1 = new StringBuffer("Mouse");
        StringBuffer sb2 = new StringBuffer("Mouse");

        // == check for reference , so false
        System.out.println(sb1 == sb2); // false

        // StringBuffer class do not override equals(),
        // hence according to Object class equals() check
        // references are not equal so false
        System.out.println(sb1.equals(sb2)); // false

    }
}
