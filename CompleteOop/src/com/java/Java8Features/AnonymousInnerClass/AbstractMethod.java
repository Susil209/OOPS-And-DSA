package com.java.Java8Features.AnonymousInnerClass;

// the same can be implemented by anonymous class
interface Student{
    // abstract methods
    void getName(String name);
    void getCourse(String course);
}

public class AbstractMethod {
    public static void main(String[] args) {

        Student s = new Student() {
            @Override
            public void getName(String name) {
                System.out.println("name :"+name);
            }

            @Override
            public void getCourse(String course) {
                System.out.println("course :"+course);
            }
        };

        s.getName("Susil");
        s.getCourse("Java");

    }
}

// Conventional Approach
/*
interface Student{
    // abstract methods
    void getName(String name);
    void getCourse(String course);
}

class JavaStudent implements Student{

    @Override
    public void getName(String s) {
        System.out.println("name :"+s);
    }

    @Override
    public void getCourse(String course) {
        System.out.println("course :"+course);
    }


}

public class AbstractMethod {
    public static void main(String[] args) {
        Student s = new JavaStudent();
        s.getName("Susil");
        s.getCourse("Java");

        Student s1 = new JavaStudent();
        s1.getName("Sujit");
        s1.getCourse("Java 8");
    }
}

 */
