package com.java.introduction;

public class Main {

    public static class Student{
        int rno;
        String name;
        float marks;
    }

    public static void main(String[] args) {
       Student s1 = new Student();
       s1.rno = 101;
       s1.name = "Susil";
       s1.marks = 89.8f;

        System.out.println(s1.name);
    }
}
