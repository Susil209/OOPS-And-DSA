package com.java.DSAQuestions.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

//    https://leetcode.com/problems/next-greater-element-i/description/
    public static int[] findNGE1(int[] nums1, int[] nums2) {
        // Approach-1 (Brute Force)
        // TC=O(n^2), SC=O(1)
        
        /*
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int max=-1;
            for (int j = 0; j < nums2.length; j++) {
                int idx=j+1;
                // Found element in nums2 that matches current element in nums1
                if(nums1[i] == nums2[j]) {
                    // Iterate through remaining elements in nums2 to find next greater element
                    while(idx != nums2.length){
                        if(nums2[idx] > nums2[j]){
                            // Update max if we find a greater element
                            max = nums2[idx];
                            break;
                        }
                        idx++;
                    }
                }
            }
            ans[i] = max;
        }

        return ans;
        
         */
        
        
        // Approach-2 (Using Stack) , Monotonic decreasing stack

        // TC=O(n) , SC=O(n)
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();

        for (int num : nums2) {
            if (!st.isEmpty() && st.peek() < num) {
                mp.put(st.pop(), num);
            }
            st.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = mp.getOrDefault(nums1[i], -1);
            // or
            // nums1[i] = mp.containsKey(nums1[i]) ? mp.get(nums1[i]) : -1;
        }

        return nums1;


    }

//    https://leetcode.com/problems/next-greater-element-ii/description/
    public static int[] nextGreaterElements(int[] nums) {

        // Approach-1 (Brute force)
        // TC=O(n^2), SC=O(n)

        /*
        int N = nums.length;
        int[] doubleNums = new int[2 * N];
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            doubleNums[i] = nums[i];
            doubleNums[i+ N] = nums[i];
        }


        for (int i = 0; i < N; i++) {
            res[i] = -1;
            for (int j = i+1; j < N; j++) {
                if(doubleNums[j] > doubleNums[i]){
                    res[i] = doubleNums[j];
                    break;
                }
            }
        }

        return res;

         */

        // Approach-2 (Better Brute force)
        // TC=O(n^2) , SC= O(n)
        /*
        int N = nums.length;
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            res[i] = -1;

            for (int j = 1; j < N; j++) {
                if (nums[(i+j)%N] > nums[i]) {
                    res[i] = nums[(i+j)%N];
                }
            }
        }

        return res;

         */



        // Approach-3(Using Stack)
        // TC=O(n) , SC= O(n)

        /*
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 2*n-1; i >=0 ; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (!st.isEmpty()) res[i] = st.peek();
                else res[i] = -1;
            }

            st.push(nums[i % n]);
        }
        return res;


         */

        // More optimised
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < 2 * n; i++) {
            while (top >= 0 && nums[i % n] > nums[stack[top]]) {
                result[stack[top]] = nums[i % n];
                top--;
            }
            if (i < n) {
                top++;
                stack[top] = i % n;
            }
        }

        return result;

    }

    public static void main(String[] args) {
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2};
//
//        System.out.println(Arrays.toString(findNGE1(nums1, nums2)));

        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
