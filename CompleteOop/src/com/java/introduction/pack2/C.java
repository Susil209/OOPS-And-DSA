package com.java.introduction.pack2;

import com.java.introduction.A;


public class C extends A {
    public static void main(String[] args) {
        A a = new A();
        // a.m1();  -> CE : m1() has protected access in com.java.introduction.A

        C c = new C();
        c.m1(); // perfectly available

        A a1 = new C();
        // a1.m1(); -> CE : m1() has protected access in com.java.introduction.A
    }
}

class D extends C{
    public static void main(String[] args) {
        A a = new A();
        // a.m1(); m1() has protected access in com.java.introduction.A

        C c = new C();
        // c.m1(); m1() has protected access in com.java.introduction.A

        D d = new D();
        d.m1(); // perfectly available

        A a1 = new C();
        // a1.m1(); m1() has protected access in com.java.introduction.A

        A a2 = new D();
//        a2.m1(); m1() has protected access in com.java.introduction.A

        C c1 = new D();
        // c1.m1(); m1() has protected access in com.java.introduction.A
    }
}
