package com.java.Java8Features.MethodReference;

public class MethodRefEx3 {

//    static void method() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Child Thread");
//        }
//    }

    void method() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }
    }

    public static void main(String[] args) {

        // static method
//        Runnable r = MethodRefEx3::method;

        // instance method
        MethodRefEx3 m3 = new MethodRefEx3();
        Runnable r = m3::method;

        Thread t = new Thread(r);
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
        }
    }
}
