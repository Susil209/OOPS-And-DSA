package com.java.Inheritance;

public class Child extends Parent{

    private int cars;

    Child() {
        super();
        this.cars = 0;
    }

    Child(Child c) {
       super(c);
       this.cars = c.cars;
   }

    Child(int cars,int age,String values){
        super(age,values);
        this.cars=cars;
    }

    public void m2(){
        System.out.println("child class");
    }
}
