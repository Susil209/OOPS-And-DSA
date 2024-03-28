package com.java.Overriding;

public class Test {
    public static void main(String[] args) {
        // Anonymous inner class
        Parent p = new Parent() {
            @Override
            public void b1() {
                System.out.println("Abstract method implementation");
            }
        };
        p.marry();

        Child c = new Child();
        c.marry();

        Parent p1 = new Child();
        p1.marry(); // Runtime Polymorphism
    }
}
