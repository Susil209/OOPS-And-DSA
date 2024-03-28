package com.java.Java8Features.AnonymousInnerClass;

abstract class Employee{
    abstract void getName(String name);
    abstract void getDept(String dept);
}


public class AbstractClass {
    public static void main(String[] args) {
        Employee e = new Employee() {
            @Override
            void getName(String name) {
                System.out.println("name :"+name);
            }

            @Override
            void getDept(String dept) {
                System.out.println("dept :"+dept);
            }
        };

        e.getName("Akash");
        e.getDept("IT");
    }
}

/*
abstract class Employee{
    abstract void getName(String name);
    abstract void getDept(String dept);
}

class ItEmployee extends Employee{

    @Override
    void getName(String name) {
        System.out.println("name :"+name);
    }

    @Override
    void getDept(String dept) {
        System.out.println("dept :"+dept);
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Employee e = new ItEmployee();
        e.getName("Sujit");
        e.getDept("IT");
    }
}
 */