package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.function.Predicate;

public class PredicateJoining {
    public static void main(String[] args) {
        int[] num = {5,10,15,20,25,30};

        Predicate<Integer> p1 = x -> x>10;
        Predicate<Integer> p2 = x -> x%2==0;

        System.out.println("Greater than 10:");
        m1(p1,num);

        System.out.println("Even numbers:");
        m1(p2,num);

        // and()
        System.out.println("Greater then 10 and even numbers:");
        m1(p1.and(p2),num);

        // or()
        System.out.println("Greater than 10 or even numbers");
        m1(p1.or(p2),num);

        //negate()
        System.out.println("Less than 10");
        m1(p1.negate(),num);
    }

    public static void m1(Predicate<Integer> p,int[] x){
        for (int i: x) {
            if (p.test(i)){
                System.out.println(i);
            }
        }
    }
}
