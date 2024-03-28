package com.java.JavaLangPackage.ObjectClass;

class Student {
    String name;
    int roll;

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }


    @Override
    public String toString() {
        return "Name = " + name + " and roll no = " + roll;
    }

    @Override
    public boolean equals(Object obj) {
        /*
        try {
            int roll1 = this.roll;
            String name1 = this.name;

            Student s = (Student) obj;
            int roll2 = s.roll;
            String name2 = s.name;

            if (name1.equals(name2) && roll1 == roll2) {
                return true;
            } else {
                return false;
            }
        }
        catch (ClassCastException | NullPointerException c){
            return false;
        }
         */

        //OR

        if (obj instanceof Student s){
            if (obj == this) return true;
            return name.equals(s.name) && roll == s.roll;
        }
        return false;
    }
}


public class toStringMethod {
    public static void main(String[] args) {
        Student s = new Student("Ram", 10);
        // Student s1 = new Student("Mira", 20);
        System.out.println(s);
    }
}
