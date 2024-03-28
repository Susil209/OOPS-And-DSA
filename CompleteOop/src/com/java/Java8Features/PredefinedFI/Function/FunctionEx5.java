package com.java.Java8Features.PredefinedFI.Function;

import java.util.ArrayList;
import java.util.function.Function;

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "name='" + name + ", salary=" + salary;
    }
}

public class FunctionEx5 {
    public static void main(String[] args) {
        // program to find total monthly salary
        ArrayList<Employee> al = new ArrayList<>();
        populate(al);

        Function<ArrayList<Employee>,Integer> totalSalary = e -> {
            int total = 0;
            for (Employee e1: e) {
                total += e1.salary;
            }
            return total;
        };

        System.out.println(totalSalary.apply(al));
    }

    static void populate(ArrayList<Employee> l) {
        l.add(new Employee("Akash",20000));
        l.add(new Employee("Bikash",10000));
        l.add(new Employee("Prakash",50000));
        l.add(new Employee("Suresh",20000));
        l.add(new Employee("Nilesh",80000));
        l.add(new Employee("Chinmayee",21000));
        l.add(new Employee("Kali",12000));

    }
}
