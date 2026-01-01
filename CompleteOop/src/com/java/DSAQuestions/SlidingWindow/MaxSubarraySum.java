package com.java.DSAQuestions.SlidingWindow;

// Problem:
// Given an array of integers arr[]  and a number k.
// Return the maximum sum of a subarray of size k.
//Note: A subarray is a contiguous part of any given array.

// TC = O(n) , SC = O(n)

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {5, 2, -1, 0, 3};
        int k = 3;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int n, int k) {
        int i=0,j=0;
        int sum=0, maxsum = Integer.MIN_VALUE;

        while(j < n){
            sum = sum + arr[j];

            if(j-i+1 < k){ // j-i+1 = window size
                j++;
            }

            else if(j-i+1 == k){
                maxsum = Math.max(maxsum, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }

        return maxsum;
    }
}
