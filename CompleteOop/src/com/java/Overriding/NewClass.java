package com.java.Overriding;

public class NewClass {

    public static class P{
//        public void m1(){
//            System.out.println("Parent");
//        }

        public static void m1(){
            System.out.println("Parent");
        }
    }

    public static class C extends P{
//        public void m1(){
//            System.out.println("Child");
//        }


//        CE :m1() in com.java.Overriding.NewClass.C cannot override
//              m1() in com.java.Overriding.NewClass.P
//              attempting to assign weaker access privileges; was public

//        private static void m1(){
//            System.out.println("Child");
//        }
    }

    public static void main(String[] args) {
        P p = new P();
        p.m1(); // parent

        C c = new C();
        c.m1(); // child

        P p1 = new C();
//        p1.m1(); // child , when both parent and child method m1() is NON-STATIC.
                 // Method execution is done by JVM at runtime -> Overriding


        P.m1(); // Parent , when both parent and child method m1() is STATIC.
                // Method execution is done by compiler -> Method-Hiding


    }
}
