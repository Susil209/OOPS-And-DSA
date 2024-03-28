package com.java.Java8Features.PredefinedFI.Function;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

// perform salary increment

public class FunctionEx2 {
    public static void main(String[] args) {
        ArrayList<Employee> al = new ArrayList<>();

        al.add(new Employee("Akash",1.2,20000));
        al.add(new Employee("Bikash",3.2,30000));
        al.add(new Employee("Prakash",4.2,35000));
        al.add(new Employee("Saksee",4,40000));
        al.add(new Employee("Lina",2.2,20000));
        al.add(new Employee("Anmol",7.2,80000));

        System.out.println(al);

        // salary <25000 and exp > 1
        Predicate<Employee> p = e -> e.salary <25000 && e.exp >1;

        // return the employees who satisfy the above condition
        // and increment their sal by 2000
        Function<Employee,Employee> f = e -> {
          if (p.test(e)){
              e.salary += 2000;
          }
          return e;
        };

        for (Employee emp:
             al) {
            f.apply(emp);
        }

        System.out.println(al);

    }

    static class Employee {
        String name;
        double exp;
        double salary;

        Employee(String name,double exp,double salary){
            this.name = name;
            this.exp = exp;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name+"-"+exp+"-"+salary;
        }
    }
}
