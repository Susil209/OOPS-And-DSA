package com.java.DSAQuestions.Matrix;

//https://www.geeksforgeeks.org/problems/count-zeros-in-a-sorted-matrix

public class CountZeros {

    public static int countNoOf0s(int[][] A){

        // Approach-1 (Brute force)
        // TC=O(r*c), SC=O(1)
        /*int count=0;
        int r = A.length;
        int c = A[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(A[i][j] == 0){
                    count += 1;
                }else{
                    break;
                }
            }
        }

        return count;*/


        // Approach-2(Better)
        // TC = O(r * log*c), SC=O(1)

        /*int r = A.length;
        int c = A[0].length;

        int count_of_zeros = 0;

        for (int i = 0; i < r; i++) {
            count_of_zeros += lowerBound(A[i],c,1); // lowerBound(1)
        }

        return count_of_zeros;*/

        // Approach-3(Optimal)
        // TC=O(r+c), SC=O(1)

        int r = A.length;
        int c = A[0].length;

        int bottom=c-1,left=0;
        int count=0;

        while(bottom >= 0 && left < r){
            if(A[bottom][left] == 1){
                bottom--;
            }

            else{
                count += bottom+1;
                left++;
            }
        }

        return count;
    }

    private static int lowerBound(int[] arr, int c, int x) {
        int low=0,high=c-1;
        int ans=c;

        while(low<=high){

            int mid = (low+high)/2;

            if(arr[mid] >= x){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
//        int[][] mat = {{0,0,0},{0,0,1},{1,1,1}};
        int[][] mat = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println("Total no of 0's : "+ countNoOf0s(mat));
    }
}
