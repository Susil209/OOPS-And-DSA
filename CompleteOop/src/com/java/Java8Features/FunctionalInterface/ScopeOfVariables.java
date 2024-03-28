package com.java.Java8Features.FunctionalInterface;

interface Inter{
    void m1();
}

public class ScopeOfVariables {

    int z=1000; // instance variable
    public void m2(){
        int y=100; // local variable of m2()
        Inter i = () -> {
            int x= 10; // local variable of method m1()
            System.out.println(x);
            System.out.println(this);

//            y=98; // inside lambda y is final , so can't reassign
            System.out.println(y);

            System.out.println(z);
        };
        i.m1();

        // inside lambda y is final , so can't reassign it again outside
//        y=83;
//        System.out.println(y);
    }

    public static void main(String[] args) {
        ScopeOfVariables s = new ScopeOfVariables();
        s.m2();
    }
}
