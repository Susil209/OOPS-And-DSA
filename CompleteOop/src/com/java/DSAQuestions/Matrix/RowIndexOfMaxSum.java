package com.java.DSAQuestions.Matrix;

public class RowIndexOfMaxSum {

    public  static int rowIndWithMaxSum(int[][] A){
        int maxSum = Integer.MIN_VALUE;
        int maxIndex=-1;
        int r = A.length, c = A[0].length;

        for (int i = 0; i < r; i++) {
            int rowSum = 0;
            for (int j = 0; j < c; j++) {
                rowSum += A[i][j];
                if(rowSum > maxSum){
                    maxSum = rowSum;
                    maxIndex = i;
                }
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        int[][] mat = {{2,3,4},{7,8,9},{7,1,3}};
        System.out.println("Maximum index is "+ rowIndWithMaxSum(mat));
    }
}
