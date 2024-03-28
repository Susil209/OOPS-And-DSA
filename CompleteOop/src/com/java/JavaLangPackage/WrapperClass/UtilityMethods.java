package com.java.JavaLangPackage.WrapperClass;

public class UtilityMethods {
    // 4 utility methods
    // 1. valueOf()

    public static void main(String[] args)
    {
        Integer I = Integer.valueOf("10"); //10
        System.out.println(I);

        Double D = Double.valueOf("10.0"); // 10.0
        System.out.println(D);

        Boolean B = Boolean.valueOf("true"); // true
        System.out.println(B);

        // Here we will get RuntimeException
//        Integer I1 = Integer.valueOf("ten");

        Integer I1 = Integer.valueOf("1111", 2);
        System.out.println(I1);

        Integer I2 = Integer.valueOf("1111", 4);
        System.out.println(I2);


        //4. toString()
        String s1 = Integer.toBinaryString(10);
        System.out.println(s1); // 1010

        String s2 = Integer.toOctalString(10);
        System.out.println(s2); // 12

        String s3 = Integer.toHexString(10);
        System.out.println(s3); //a
    }
}
