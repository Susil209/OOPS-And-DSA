package com.java.DSAQuestions.Matrix;

public class FindRowWithMaxOnes {

    public static int rowWithMax1s(int[][] A, int n, int m) {

        // Approach-1(Brute )
        // TC = O(r*c), SC=O(1)


        /*int max_count=-1, row_index=-1;
        for (int i = 0; i < n; i++) {
            int count_ones=0;
            for (int j = 0; j < m; j++) {
                count_ones += A[i][j];
            }

            if(count_ones > max_count){
                max_count = count_ones;
                row_index = i;
            }
        }

        return row_index;*/

        // Approach-2(Optimal using binary search)
        // Time Complexity: O(n * log*m), SC=O(1)

        /*int cnt_max=0, index=-1;

        for (int i = 0; i < n; i++) {
            int cnt_ones=0;
            for (int j = 0; j < m; j++) {
//                 cnt_ones = m - lower_bound(A[i], m, 1); // lower_bound(1)

                //or
//                 cnt_ones = m - upper_bound(A[i], m , 0); // upper_bound(0)

                // or
                cnt_ones = m - firstOccurrence(A[i], m, 1); // firstOccurrence(1)
            }

            if(cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                index = i;
            }
        }

        return index;*/

        // Approach-3 (Optimal)
        // TC = O(n + m) , SC=O(1)

        int top=0, right=m-1;
        int index=-1;

        while(top < n && right >= 0){
            if(A[top][right] == 1){ // encounter 1
                index = top;
                right--; // move left
            }else{ // encounter 0
                top++; // move down
            }
        }

        return index;
    }

    private static int firstOccurrence(int[] arr, int m, int x) {
        int first=m;
        int low=0, high=m-1;

        while(low<=high){
            int mid = (low+high)/2;
            // maybe an answer
            if(arr[mid] == x){
                first = mid;
                high = mid-1;//look for smaller index on the left
            } else if (arr[mid] < x) {
                low = mid+1; // look on right
            }else {
                high = mid - 1; // look on the left
            }
        }


        return first;
    }

    private static int upper_bound(int[] arr, int m, int x) {
        int low=0, high=m-1;
        int ans=m;

        while(low<=high){
            int mid = (low+high)/2;
            // maybe an answer
            if(arr[mid] > x){
                ans = mid;
                high = mid-1;//look for smaller index on the left
            }else{
                low= mid+1; // look on the right
            }
        }

        return ans;
    }

    private static int lower_bound(int[] arr, int m, int x) {

        int low=0, high=m-1;
        int ans=m;

        while(low<=high){
            int mid = (low+high)/2;
            // maybe an answer
            if(arr[mid] >= x){
                ans = mid;
                high = mid-1;//look for smaller index on the left
            }else{
                low= mid+1; // look on the right
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] mat = { {0,0,1,1},
                        {0,1,1,1},
                        {1,1,1,1},
                        {0,0,0,1}};

//        int[][] mat = { {0,0,0,0},
//                {0,0,0,0},
//                {0,0,0,0},
//                {0,0,0,0}};
        int n=4,m=4;

        System.out.println("The row with maximum no. of 1's is: "
            + rowWithMax1s(mat, n, m));
    }


}
