package com.java.introduction;

interface Intrepid {

    //variables
    int x = 10;


    // methods
    void m1();
    void m2();
}

abstract class ServiceProvider implements Intrepid {
    public static void main(String[] args) {
        // x = 100; // Cannot assign a value to final variable 'x'
        int x = 100; // we can modify local variable
        System.out.println(x);
    }
    public void m1(){
    }
}

class SubServiceProvider extends ServiceProvider{
    public void m2(){
    }
}
