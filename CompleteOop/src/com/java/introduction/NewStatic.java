package com.java.introduction;

public class NewStatic {
    /*
    static int x = m1();
    public static int m1(){
        System.out.println("print 1");
        System.exit(0);
        return -1;
    }
     */

    /*
    static NewStatic n = new NewStatic();
    {
        System.out.println("print 2");
        System.exit(0);
    }
     */

    static NewStatic n = new NewStatic();

    NewStatic() {
        System.out.println("print 3");
        System.exit(0);
    }
}
