package com.java.Java8Features.PredefinedFI.Function;

import java.util.function.Function;

// Program to find student grade

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

/*
marks >= 80 -> A
      >=60  -> B
      >=50  -> C
      >=35  -> D
      else  -> E
 */


public class FunctionEx3 {
    public static void main(String[] args) {

        // input student object and output string grade
        Function<Student, String> gradeOfStudent = s -> {
            String grade;
            if (s.marks >= 80) grade = "A";
            else if (s.marks >= 60) grade = "B";
            else if (s.marks >= 50) grade = "C";
            else if (s.marks >= 35) grade = "D";
            else grade = "E";

            return grade;
        };

        Student[] students = {new Student("Akash", 90),
                new Student("Bikash", 79),
                new Student("Karina", 67),
                new Student("Polar", 56),
                new Student("Jimbey", 49),
                new Student("Madhu", 23)};

        for (Student s :
                students) {
            System.out.println("name: " + s.name + ", grade: " + gradeOfStudent.apply(s));
        }
    }
}
