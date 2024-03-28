package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

class Employee {
    String name;
    String designation;
    double salary;
    String address;

    public Employee(String name, String designation, double salary, String address) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public String toString() {
        return String.format("(%s,%s,%.2f,%s)",name,designation,salary,address);
    }
}

public class PredicateEx4 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        populate(list);
//        System.out.println(list);

        System.out.println("List of all Employees:");
        for (Employee e:
             list) {
            System.out.println(e);
        }

        System.out.println("------------------------------");

        // if employee is manager print details
        Predicate<Employee> p = s -> s.designation.equals("Manager");

        System.out.println("Managers details:");
        display(p,list);


        System.out.println("------------------------------");

        // employees from bangalore
        Predicate<Employee> p1 = s-> s.address.equals("Bangalore");

        System.out.println("Employees from Bangalore:");
        display(p1,list);

        System.out.println("------------------------------");

        //employees having salary less than 20000

        Predicate<Employee> p2 = s -> s.salary < 20000;
        System.out.println("Salary less than 20000");
        display(p2,list);

        System.out.println("------------------------------");

        //manager from Bangalore

        //  Predicate<Employee> p3 = s -> s.designation.equals("Manager") && s.address.equals("Bangalore");
        Predicate<Employee> p3 = p.and(p1);

        System.out.println("Managers from Bangalore");
        display(p3,list);

        System.out.println("------------------------------");

        //employees are managers or salary less than 20000
        Predicate<Employee> p4 = p.or(p2);

        System.out.println("Employees are managers or salary less than 20000");
        display(p4,list);

        System.out.println("------------------------------");

        // Not managers

        Predicate<Employee> p5 = p.negate();

        System.out.println("Not managers");
        display(p5,list);

    }

    public static void populate(ArrayList<Employee> l){
        l.add(new Employee("Akbar","CEO",120000,"Mumbai"));
        l.add(new Employee("Ashish","Manager",100000,"Chennai"));
        l.add(new Employee("Alok","President",90000,"Guwahati"));
        l.add(new Employee("Naina","HR",80000,"Delhi"));
        l.add(new Employee("Tara","Lead",50000,"Jammu"));
        l.add(new Employee("Lila","Senior developer",30000,"Punjab"));
        l.add(new Employee("Tina","Senior developer",30000,"Bangalore"));
        l.add(new Employee("Bikash","Senior developer",20000,"Chandigarh"));
        l.add(new Employee("Manoj","Junior developer",20000,"Bhubaneswar"));
        l.add(new Employee("Garima","Trainee developer",13000,"Bangalore"));
        l.add(new Employee("Radhika","Trainee developer",13000,"Kolkata"));
        l.add(new Employee("Asutosh","Manager",90000,"Bangalore"));
        l.add(new Employee("Pradhan","Manager",50000,"Chennai"));
        l.add(new Employee("Subhash","Manager",100000,"Bangalore"));
        l.add(new Employee("Sikandar","Manager",80000,"Hyderabad"));


    }


    public static void display(Predicate<Employee> p, ArrayList<Employee> list){
        for (Employee e:
                list) {
            if (p.test(e)){
                System.out.println(e);
            }
        }
    }
}