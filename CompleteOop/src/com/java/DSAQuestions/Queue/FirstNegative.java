package com.java.DSAQuestions.Queue;

import java.util.*;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegative {

    public static long[] printFirstNegativeInteger(long[] arr, int n, int k) {

        // Approach-1 (Two pointer)
        // TC=O(n*k), SC=O(1)
        /*
        long[] res = new long[n-k+1];
        int left=0;
        int right=k-1;

        // {2,-3,-4,-2,7,8,9,-10}

        while(right<n){
            for (int i = left; i <= right; i++) {
                if(arr[i] < 0) {
                    res[left] = arr[i];
                    break;
                }
            }
            left++;
            right++;
        }


        return res;

         */



        // Approach-2 (Using queue)
        // TC=O(n*k), SC=O(k)

        /*long[] res = new long[n-k+1];
        Queue<Long> q = new LinkedList<>();

        for (int i = 0; i < k-1; i++) {
            q.add(arr[i]);
        }

        for(int i=k-1; i<n; i++){
            q.add(arr[i]);
            res[i+1-k] = firstNegative(q);
            q.remove();
        }


        return res;*/

        // Approach-3
        // TC=O(n) , SC=O(k)

        /*long[] res = new long[n-k+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k-1; i++) {
            if(arr[i]<0) q.add(i);
        }

        for (int i = k-1; i < n; i++) {
            if(arr[i] < 0)
                q.add(i);


            if(q.isEmpty())
                res[i-k+1] = 0;
            else {
                if(q.peek()<=(i-k)) {
                    q.remove();
                }
                if(q.isEmpty())
                    res[i - k + 1] = 0;
                else
                    res[i-k+1] = arr[q.peek()];
            }

        }

        return res;*/


        //Approach-4 (Optimal)
        // TC=O(n) , SC=O(1)

        long[] res = new long[n-k+1];
        int firstNegativeIndex=0;

        for (int i = k-1; i < n; i++) {
            while(firstNegativeIndex<i &&
                    (firstNegativeIndex<=i-k || arr[firstNegativeIndex]>=0)){
                firstNegativeIndex++;
            }

            if(arr[firstNegativeIndex] < 0)
                res[i-k+1] = arr[firstNegativeIndex];
            else
                res[i-k+1] = 0;
        }

        return res;
    }

    private static long firstNegative(Queue<Long> q){
        Queue<Long> q1 = new LinkedList<>(q);
        while(!q1.isEmpty()){
            if(q1.peek() < 0)
                return q1.peek();
            q1.remove();
        }
        return 0L;
    }

    public static void main(String[] args) {
        long[] arr = {2,-3,-4,-2,7,8,9,-10};
//        long[] arr={12, -1, -7, 8, -15, 30, 16, 28};
        long[] ans = printFirstNegativeInteger(arr, arr.length, 3);

        StringBuilder sb = new StringBuilder();
        for (long an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }

}
