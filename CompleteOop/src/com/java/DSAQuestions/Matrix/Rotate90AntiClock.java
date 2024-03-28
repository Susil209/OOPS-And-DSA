package com.java.DSAQuestions.Matrix;

public class Rotate90AntiClock {

    private static void reverseByRow(int[][] A,int n){
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[n-i-1][j];
                A[n-i-1][j] = temp;
            }
        }
    }


    private static void transpose(int[][] A,int n){
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }

    public static void rotateBy90Anti(int[][] A,int n){
        transpose(A,n);
        reverseByRow(A,n);
    }

    public static void main(String[] args) {
        int[][] mat = { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};

        rotateBy90Anti(mat, 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
