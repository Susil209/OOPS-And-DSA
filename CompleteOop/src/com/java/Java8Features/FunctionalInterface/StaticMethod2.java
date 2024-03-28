package com.java.Java8Features.FunctionalInterface;

interface Employee{
    static void dept(){
        System.out.println("IT");
    }
}

//class NewEmployee implements Employee{
//
//    // Note this is not overriding.
//    // Implementation class cannot access static methods present inside Interface.
//
//    static void dept(){
//        System.out.println("HR");
//    }
//}


public class StaticMethod2 implements Employee{

    static void dept(){
        System.out.println("Mrkt");
    }

    public static void main(String[] args) {
//        NewEmployee.dept();
        Employee.dept();
//        StaticMethod2.dept(); CE
        StaticMethod2.dept();
    }
}
