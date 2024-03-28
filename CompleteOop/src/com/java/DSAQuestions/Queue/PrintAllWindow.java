package com.java.DSAQuestions.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllWindow {


    public static void printWindow(int[] arr, int n, int k){

        //Approach-1(using 2 pointers)

        // TC=O(n*k), SC=O(1)
        /*
        int left=0;
        int right=k-1;

        while(right<n){
            for (int i = left; i <= right ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            left++;
            right++;
        }

         */

        // Approach-2(using queue)
        //TC=O(n), SC=O(n)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k-1; i++) {
            q.add(arr[i]);
        }

        for (int i = k-1; i < n; i++) {
            q.add(arr[i]);
//            System.out.println(q);
            display(q);
            q.remove();
        }

    }

    private static void display(Queue<Integer> q){
        Queue<Integer> q1 = new LinkedList<>(q);
        while(!q1.isEmpty()){
            System.out.print(q1.peek()+ " ");
            q1.remove();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,11,21,98,13};
        int k=3;
        printWindow(nums,nums.length,k);
    }
}
