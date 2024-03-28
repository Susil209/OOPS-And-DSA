package com.java.Java8Features.FunctionalInterface;

interface NewInter {
    // static method
    static int add(int a,int b){
        return a+b;
    }
}


public class StaticMethod {
    public static void main(String[] args) {
        System.out.println(NewInter.add(10,7));
    }
}
