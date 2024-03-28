package com.java.Collection;

public class ComparableExample {
    public static void main(String[] args) {
        System.out.println("A".compareTo("B")); // -ve
        System.out.println("C".compareTo("A")); // +ve
        System.out.println("A".compareTo("A")); // 0
//        System.out.println("A".compareTo(null)); // NullPointerException
    }
}
