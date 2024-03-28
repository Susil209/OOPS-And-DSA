package com.java.Java8Features.PredefinedFI.TwoArgFI;


import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class BiConsumerExample {
    public static void main(String[] args) {
//        BiConsumer<String, Integer> bc =
//                (name, age) -> System.out.println(name + " " + age);
//        bc.accept("Peter", 28);

        //Program to Increment Employee Salary by using BiFunction & BiConsumer

        ArrayList<Employee> l = new ArrayList<>();
        BiFunction<String, Integer, Employee> emp =
                (name, sal) -> new Employee(name, sal);

        l.add(emp.apply("Akash",20000));
        l.add(emp.apply("Bikash",10000));
        l.add(emp.apply("Prakash",50000));
        l.add(emp.apply("Suresh",20000));
        l.add(emp.apply("Nilesh",80000));
        l.add(emp.apply("Chinmayee",21000));
        l.add(emp.apply("Kali",12000));

        BiConsumer<Employee,Integer> b = (e,inc) -> e.salary = e.salary+inc;

        for (Employee e: l) {
            b.accept(e,3000);
        }

        for (Employee e: l) {
            System.out.println(e.name+"->"+e.salary);
        }


    }
    static class Employee {
        String name;
        int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }
    }
}
