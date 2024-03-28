package com.java.DSAQuestions.Matrix;

public class SumOfDiagonal {

    public static  int DiagonalSum(int[][] A){
        int sum=0;
        int r = A.length, c = A[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(i == j){
                    sum += A[i][j];
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = { {2,3,4},
                        {7,8,9},
                        {7,1,3}};
        System.out.println("Sum of diagonal elements " + DiagonalSum(mat));
    }
}
