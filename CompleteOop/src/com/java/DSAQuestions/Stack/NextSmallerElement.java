package com.java.DSAQuestions.Stack;

import java.util.*;
import java.util.Stack;

public class NextSmallerElement {
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){


        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(-1);
        }

        // or
//        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n,-1));

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr.get(st.peek()) > arr.get(i)) {
                res.set(st.pop(),arr.get(i));
            }

            st.push(i);
        }
        return res;
    }

    public static void immediateSmaller(int []a) {
        // Approach-1 (Using Stack)
        //TC=O(n), SC=O(n)

        /*
        Stack<Integer> st = new Stack<>();
        int n =a.length;

        st.push(a[0]);

        for (int i = 1; i < n; i++) {
            if(st.peek() > a[i]){
                a[i-1] = a[i];
            }else {
                a[i-1]=-1;
            }
            st.push(a[i]);
        }

        a[n-1] = -1;

         */


        // Approach-2 (Without using stack)
        //TC=O(n), SC=O(1)
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
        {
            // Check for the next element
            if (a[i + 1] < a[i]) {
                a[i] = a[i + 1];
            } else {
                a[i] = -1;
            }
        }

        // Finally for the last element put it as -1
        a[n - 1] = -1;

    }

    public static void main(String[] args) {
//        ArrayList<Integer> al = new ArrayList<>(List.of(7,9,12,10,14,8,3,6,9));
//        ArrayList<Integer> ans = NextSmallerElement.nextSmallerElement(al, al.size());
//        System.out.println(ans);

        int[] arr = {4,7,8,2,3,1};
        NextSmallerElement.immediateSmaller(arr);
        System.out.println(Arrays.toString(arr));
    }
}
