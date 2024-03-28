package com.java.Java8Features.CollectionsUsingLambda;

import java.util.ArrayList;
import java.util.Collections;

public class UserDefinedClassSort {
    public static void main(String[] args) {
        ArrayList<Employee> a = new ArrayList<>();
        a.add(new Employee(100,"A"));
        a.add(new Employee(500,"K"));
        a.add(new Employee(200,"O"));
        a.add(new Employee(900,"L"));

        System.out.println("Before sorting -> "+ a);
        // [{eno=100, ename='A'}, {eno=500, ename='K'},
        //                  {eno=200, ename='O'}, {eno=900, ename='L'}]

    // Collections.sort(a,(e1,e2) -> ((Integer)e2.eno).compareTo(((Integer)e1.eno)));
        // or
        Collections.sort(a,(e1,e2) -> Integer.compare(e2.eno, e1.eno));
        //or
        //Collections.sort(a,(e1,e2) -> e1.eno < e2.eno ? -1 : e1.eno > e2.eno ? 1 : 0);


        System.out.println("After sorting ->"+a);
    }
}
