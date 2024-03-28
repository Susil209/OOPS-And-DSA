package com.java.introduction;

import java.util.Date; // 1. Explicit class import
import java.sql.*; // 3. Implicit class import

/*
*  While resolving class names compiler will always give precedence
*  in the following order.
*
*   1. Explicit class import
*   2. Class present in PWD
*   3. Implicit class import
*
*   In this example Date class is present in both util and sql package
*   but due to util.Date is explicit import it got the highest priority.
* */


import static java.lang.Math.*;

public class ImportDemo {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.getClass().getName()); // java.util.Date

        // By using static imports
        System.out.println(sqrt(4.0));
        System.out.println(max(10,20));
        System.out.println(random());

    }
}
