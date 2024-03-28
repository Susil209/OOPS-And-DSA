package com.java.Java8Features.FunctionalInterface;

// Multiple inheritance is not supported

interface A {
    default void m1(){
        System.out.println("m1 in A");
    }
}

interface B {
    default void m1() {
        System.out.println("m1 in B");
    }
}

public class New implements A,B{
    public static void main(String[] args) {
        New n = new New();
        n.m1();
    }

    @Override
    public void m1() {
        A.super.m1();
    }
}
