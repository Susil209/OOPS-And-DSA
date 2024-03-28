package com.java.Java8Features.FunctionalInterface;

interface Parent{
    //void m1(); // abstract method
    default void m2(){
        System.out.println("Default method");
    }
}

class Child implements Parent{

//    @Override
//    public void m1() {
//
//    }
//
    @Override
    public void m2() {
        System.out.println("Customized default method");
    }
}

public class DefaultMethod {
    public static void main(String[] args) {
//       Parent p = new Child();
//       p.m2();

        Child c = new Child();
        c.m2();
    }
}
