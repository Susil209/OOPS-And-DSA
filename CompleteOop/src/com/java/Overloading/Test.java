package com.java.Overloading;

public class Test {
    public void m1(){
        System.out.println("no-args");
    }

    public void m1(int i){
        System.out.println("int-arg" + i);
    }

    public void m1(double d){
        System.out.println("double-arg" + d);
    }

    public void m1(String s){
        System.out.println("Sting version");
    }

    public void m1(Object o){
        System.out.println("Object version");
    }

    public void m1(StringBuffer sb){
        System.out.println("string buffer version");
    }

//    public void m1(int i,float f){
//        System.out.println("int-float version");
//    }
//
//
//    public void m1(float f,int i){
//        System.out.println("float-int version");
//    }

    public void m1(int... x){
        System.out.println("var-arg method");
    }

    public void m1(Animal a){
        System.out.println("Animal version");
    }

    public void m1(Monkey m){
        System.out.println("Monkey version");
    }

    public static void main(String[] args) {
        Test t = new Test();
        //case-1
        t.m1();
        t.m1(10);
        t.m1(22.3);

        //case-2
        //Automatic promotions
        t.m1('c'); // automatic promotion from char to int by the compiler
        t.m1(98L);
        t.m1(56.8F);

        //case-3
        t.m1(new Object());
        t.m1("car");
//      t.m1(null); ambiguous reference

        //case-4
        t.m1(new StringBuffer("cat"));
        t.m1("cat");
//        t.m1(null);

        //case-5
//        t.m1(10,10.5f);
//        t.m1(10.5f,10);
//        t.m1(10,10);// method m1 ambiguous
//        t.m1(10.5f,10.5f); // cannot find symbol

        //case-6
        t.m1(); // var-arg
        t.m1(10,20);// var-arg
        t.m1(10); // general

        //case-7
        Animal a = new Animal();
        t.m1(a);

        Monkey m = new Monkey();
        t.m1(m);

        Animal a1 =new Monkey();
        t.m1(a1); // Compile time polymorphism
    }
}
