package com.java.Java8Features.LambdaExpression;

// Functional Interface
@FunctionalInterface
interface Intern {
    // void m1(); // abstract method
//    void add(int a,int b);

//    int getLength(String s);

    int getSquare(int x);
}

// Note : Functional Interface can contain only one abstract method

public class LambdaExpression {

    public static void main(String[] args) {
        // lambda expression
//        Intern i = () -> System.out.println("m1 method implemented");
//        i.m1();

//        Intern i = (a,b) -> System.out.println("Addition is " + (a+b));
//        i.add(10,20);
//        i.add(100,200);


//        Intern i = s -> s.length();
//        System.out.println(i.getLength("Hello World"));
//        System.out.println(i.getLength("Demo String"));

        Intern i = x -> x*x;
        System.out.println(i.getSquare(8));

    }
}
