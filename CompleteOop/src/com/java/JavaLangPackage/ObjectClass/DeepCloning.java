package com.java.JavaLangPackage.ObjectClass;

class Dog1 implements Cloneable{
    Cat c;
    int i;
    Dog1(Cat c, int i){
        this.c = c;
        this.i=i;
    }

    @Override
    public Object clone() {
        Cat c1 = new Cat(c.j);
        return new Dog1(c1,i);
    }
}

public class DeepCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cat c = new Cat(10);
        Dog1 d1 = new Dog1(c,20);

        System.out.println("Before Cloning: "+ d1.i+"...."+d1.c.j);//20...10
        Dog1 d2 = (Dog1) d1.clone();

        d2.i = 888;
        d2.c.j = 999;

        System.out.println("After Cloning: "+ d1.i+"...."+d1.c.j);//20...10

    }
}

