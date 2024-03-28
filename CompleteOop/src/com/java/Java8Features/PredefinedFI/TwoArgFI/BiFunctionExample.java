package com.java.Java8Features.PredefinedFI.TwoArgFI;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
//        BiFunction<Integer,Integer,Integer> bf = (x,y) -> x*y;
//        System.out.println(bf.apply(3,3)); // 9

        //Creation of Student object by taking name and rollno as input with BiFunction

        /*
        ArrayList<Student> l = new ArrayList<>();

        BiFunction<String, Integer, Student> student =
                (name, roll) -> new Student(name, roll);

        l.add(student.apply("Akash",12));
        l.add(student.apply("Susil",21));
        l.add(student.apply("Tanmay",32));
        l.add(student.apply("Birup",29));
        l.add(student.apply("Biswas",38));

        System.out.println(l);

         */

        //Calculate Monthly Salary With Employee and TimeSheet Objects
        // as input by using BiFunction

        BiFunction<Employee,Timesheet,Integer> getMonthlySalary =
                (e,t) -> e.dailywage * t.days;

        Employee e = new Employee(101,"Nina",2000);
        Timesheet t = new Timesheet(101,30);

        System.out.println(getMonthlySalary.apply(e,t));

    }

    static class Employee{
        int eno;
        String name;
        int dailywage;

        public Employee(int eno, String name, int dailywage) {
            this.eno = eno;
            this.name = name;
            this.dailywage = dailywage;
        }
    }

    static class Timesheet{
        int eno;
        int days;

        public Timesheet(int eno, int days) {
            this.eno = eno;
            this.days = days;
        }
    }


    static class Student {
        String name;
        int roll;

        public Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", roll=" + roll +
                    '}';
        }
    }
}
