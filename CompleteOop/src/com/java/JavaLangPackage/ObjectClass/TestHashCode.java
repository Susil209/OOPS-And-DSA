package com.java.JavaLangPackage.ObjectClass;

public class TestHashCode {
    int i;
    TestHashCode(int i){
        this.i = i;
    }

    @Override
    public int hashCode(){
        return i;
    }

    @Override
    public String toString(){
        return i+"";
    }

    public static void main(String[] args) {

        TestHashCode t1 = new TestHashCode(10);
        TestHashCode t2 = new TestHashCode(100);

        // if hashCode() and toString() are not overridden
        // Object.toString() internally calls Object.hashCode()

        // System.out.println(t1); // TestHashCode@65ab7765
        // System.out.println(t2); // TestHashCode@1b28cdfa


        // when hashCode() is overridden, but toString() is not overridden
        // Object.toString() calls our own overridden hashCode()

//        System.out.println(t1); // TestHashCode@a
//        System.out.println(t2); // TestHashCode@64

        // when hashCode() and toString() are overridden
        // overridden toString() don't call hashCode()
        System.out.println(t1); // 10
        System.out.println(t2); // 100

    }
}
