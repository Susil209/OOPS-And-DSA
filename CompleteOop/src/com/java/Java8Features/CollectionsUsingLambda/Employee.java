package com.java.Java8Features.CollectionsUsingLambda;

public class Employee {
    int eno;
    String ename;

    public Employee(int eno, String ename) {
        this.eno = eno;
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                '}';
    }
}
