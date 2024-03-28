package com.java.JavaLangPackage.StringClass;

import java.util.Arrays;

public class StringClassMethods {
    public static void main(String[] args) {

        /*
        String s = "My name is Susil. What is your name?";

        // indexOf(String s)
        System.out.println("Index of 'name' is "+ s.indexOf("name"));

        //indexOf(int ch)
        System.out.println("Index of 'i' is "+ s.indexOf('i'));
        System.out.println("Index of 'i after 'What' is '"+ s.indexOf('i',15));

        //lastIndexOf(int ch)
        System.out.println("Last index of 'n' "+ s.lastIndexOf('n'));

        //replace()
        System.out.println("Replaced string= " + s.replace("name","game"));

        //split
        System.out.println("Using split:");
        String[] s1 = s.split(" ");
        String[] s2 = s.split(" ",5);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));

        //final vs immutability
        final StringBuffer sb = new StringBuffer("java");
        sb.append("Programme");
        System.out.println(sb); // javaProgramme

         */

//        sb = new StringBuffer("language");
//        System.out.println(sb); // CE :  cannot assign a value to final variable sb

        //intern method
        String s1 = new String("java");
        String s2 = s1.intern();
        System.out.println(s1==s2); // false

        String s3 = "java";
        System.out.println(s2==s3); //true

    }
}
