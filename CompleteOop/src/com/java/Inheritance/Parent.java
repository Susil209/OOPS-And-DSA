package com.java.Inheritance;

public class Parent {
    private int age;
    private String values;

    Parent(){
        super();
        this.age = 0;
        this.values="";
    }

    Parent(int age, String values) {
        this.age = age;
        this.values = values;
    }

    Parent(Parent p) {
        this.age = p.age;
        this.values = p.values;
    }

    public void m1(){
        System.out.println("parent class");
    }

}


