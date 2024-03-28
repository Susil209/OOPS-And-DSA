package com.java.JavaLangPackage.ObjectClass;

public class equalsMethod {
    public static void main(String[] args) {
        Student s1 = new Student("Durga",101);
        Student s2 = new Student("Ravi",102);
        Student s3 = new Student("Durga",101);
        Student s4 = s1;

        // diff reference(address value) and diff content
        System.out.println(s1.equals(s2)); // false

        // diff reference but same content
        // Object class equals() method compare the reference,
        // it can be overridden to check for content type

        //System.out.println(s1.equals(s3)); // false, for Object class equals
        System.out.println(s1.equals(s3)); // true for overridden equals

        // same reference and same content
        System.out.println(s1.equals(s4)); // true

        // heterogeneous objects (Student.equals(String))
        System.out.println(s1.equals("durga")); // false

        // null
        System.out.println(s1.equals(null)); // false


        // Note: "==" operator is used to check for reference type
        // Object.equals() is by default check for reference type
        // however equals() can be overridden to check for content type
    }
}
