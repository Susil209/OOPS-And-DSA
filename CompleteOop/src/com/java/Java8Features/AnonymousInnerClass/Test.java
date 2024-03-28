package com.java.Java8Features.AnonymousInnerClass;

// Achieve the same using Anonymous inner class
class Parent{
    public void m1(){
        System.out.println("Parent class method");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p =new Parent()
        {
            int x=10; // instance variable
            @Override
            public void m1(){
                x=20;
                System.out.println(this);
                System.out.println(this.x);
                System.out.println("Anonymous Inner Class method");
            }
        };

        p.m1();
    }
}


// Conventional Approach

/*
class Parent{
    public void m1(){
        System.out.println("Parent class method");
    }
}

class Child extends Parent{
    @Override
    public void m1(){
        System.out.println("Child class method");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p =new Child();
        p.m1();
    }
}

 */

