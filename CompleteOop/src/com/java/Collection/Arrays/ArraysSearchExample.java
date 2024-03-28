package com.java.Collection.Arrays;

import java.util.Arrays;

public class ArraysSearchExample {
    public static void main(String[] args) {
        int[] a = {10,5,20,11,6};
        Arrays.sort(a); // sort by natural order
        System.out.println(Arrays.binarySearch(a,6)); // 1
        System.out.println(Arrays.binarySearch(a,14));// -5

        String[] s = {"A","Z","B"};
        Arrays.sort(s);
        System.out.println(Arrays.binarySearch(s,"Z")); // 2
        System.out.println(Arrays.binarySearch(s,"S")); // -3

        Arrays.sort(s,new MyComparatorK());
        System.out.println(Arrays.binarySearch(s,"Z",new MyComparatorK()));// 0
        System.out.println(Arrays.binarySearch(s,"N",new MyComparatorK()));
        // unpredictable result
    }
}
