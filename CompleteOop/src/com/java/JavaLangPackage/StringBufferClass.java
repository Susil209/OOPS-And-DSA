package com.java.JavaLangPackage;

public class StringBufferClass {
    public static void main(String[] args) {

        // constructors
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity()); // 16

        for(int i=0; i<16; i++) {
            sb.append((char) (i + 97));
        }

        System.out.println(sb);
        System.out.println("After append capacity = "+ sb.capacity());
        sb.append("q");
        System.out.println("After 17th character = "+ sb.capacity());

        System.out.println("----------------------------");
        StringBuffer sb1 = new StringBuffer("Java");
        System.out.println("With string as parameter = "+sb1.capacity()); // 16 + 4 = 20

        //methods
        System.out.println(sb1.charAt(2)); // v

        sb1.setCharAt(2,'o');
        System.out.println("after char set = "+ sb1); // Jaoa

        //method chaining
        sb1.append(" // The value of pi = ").append(3.14).append(true);
        System.out.println(sb1); // Jaoa // The value of pi = 3.14true

        sb1.insert(7, 10);
        sb1.insert(9, "Hello");
        System.out.println(sb1); // Jaoa //10Hello The value of pi = 3.14true

        sb1.reverse();
        System.out.println(sb1); // eurt41.3 = ip fo eulav ehT olleH01// aoaJ

        sb1.setLength(9);
        System.out.println(sb1);// eurt41.3
    }
}
