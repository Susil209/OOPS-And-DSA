package com.java.Inheritance;

public class GrandChild extends Child {
    private int money;

    public GrandChild() {
        super();
        this.money = 0;
    }

    //copy constructor
    GrandChild(GrandChild gc){
        super(gc);
        this.money= gc.money;
    }

    public GrandChild(int cars, int age, String values, int money) {
        super(cars, age, values);
        this.money = money;
    }
}
