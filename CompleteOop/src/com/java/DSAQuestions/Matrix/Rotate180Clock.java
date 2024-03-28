package com.java.DSAQuestions.Matrix;

public class Rotate180Clock {

    private static void reverseByCol(int[][] A,int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n-j-1];
                A[i][n-j-1] = temp;
            }
        }
    }

    private static void reverseByRow(int[][] A,int n){
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[n-i-1][j];
                A[n-i-1][j] = temp;
            }
        }
    }
    public static void rotateBy180Deg(int[][] A,int n){
        reverseByCol(A,n);
        reverseByRow(A,n);
    }

    public static void main(String[] args) {
        int[][] mat = { {1, 2,  3, 4},
                        {5, 6,  7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};


        rotateBy180Deg(mat,4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
