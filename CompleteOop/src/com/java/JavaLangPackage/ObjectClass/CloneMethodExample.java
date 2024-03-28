package com.java.JavaLangPackage.ObjectClass;

public class CloneMethodExample implements Cloneable{
    int i=10,j=20;
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneMethodExample c1 = new CloneMethodExample();
        CloneMethodExample c2 = (CloneMethodExample) c1.clone();
        c2.i = 999;
        c2.j = 199;

        System.out.println(c1.i+"......"+ c1.j);
        System.out.println(c2.i+"......"+ c2.j);

    }
}
