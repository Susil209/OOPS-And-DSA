package com.java.JavaLangPackage.ObjectClass;

import java.lang.reflect.Method;

public class getClassMethod {
    public static void main(String[] args) {
        int count=0;
        Object o = new String("during");
        Class<?> c = o.getClass();
        System.out.println("Fully qualified name of the class: "+c.getName()); //  java.lang.String

        Method[] m = c.getDeclaredMethods();
        for (Method m1:m) {
            count++;
            System.out.println(m1.getName());
        }

        System.out.println("The number of methods are: "+ count);
    }
}
