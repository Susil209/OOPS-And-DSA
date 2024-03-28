package com.java.Overriding;

public abstract class Parent {

    public abstract void b1();

    public  void property(){
        System.out.println("cash+land+gold");
    }

    /*
        If the parent class method is declared as "final",then we can't
        override the method in child class.
     */

    public final void marry(){
        System.out.println("person x");
    }

    public Object m1(){
        return null;
    }
}
