package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.function.Predicate;

class SoftwareEngineers{
    String name;
    int age;

    boolean haveGF;

    public SoftwareEngineers(String name, int age, boolean haveGF) {
        this.name = name;
        this.age = age;
        this.haveGF = haveGF;
    }

    public String toString() {
        return name;
    }

}


public class PredicateEx3 {
    public static void main(String[] args) {
        SoftwareEngineers[] si = {new SoftwareEngineers("A",19,false),
        new SoftwareEngineers("B",23,true),
        new SoftwareEngineers("C",21,true),
        new SoftwareEngineers("D",22,false),
        new SoftwareEngineers("E",29,true)};

        Predicate<SoftwareEngineers> p = s -> s.age >= 18 && s.haveGF;


        for (SoftwareEngineers s1: si) {
            if (p.test(s1)){
                System.out.println(s1);
            }
        }

    }
}
