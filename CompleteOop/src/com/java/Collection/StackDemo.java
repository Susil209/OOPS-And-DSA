package com.java.Collection;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println(st); // [10,20,30,40]
        System.out.println(st.peek()); // 40
        st.pop(); //40

        System.out.println(st); // [10,20,30]

        System.out.println(st.search(10)); // 3
        System.out.println(st.search(20)); // 2
        System.out.println(st.search(90)); // -1

    }
}
