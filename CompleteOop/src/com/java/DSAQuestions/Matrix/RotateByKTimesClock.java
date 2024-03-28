package com.java.DSAQuestions.Matrix;

public class RotateByKTimesClock {

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

    private static void reverseByCol(int[][] A,int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n-j-1];
                A[i][n-j-1] = temp;
            }
        }
    }

    public static void rotateByKTimesClockWise(int[][] A,int n,int k){
        // 90 deg case
        if(k % 4 == 1){
            transpose(A,n);
            reverseByCol(A,n);
        }

        // 180 deg case
        else if(k % 4 == 2){
            reverseByCol(A,n);
            reverseByRow(A,n);
        }
        // 270 deg case
        else if (k % 4 == 3) {
            transpose(A,n);
            reverseByRow(A,n);
        }
        // 360 or 0 deg case
        else {
            return;
        }
    }

    public static void main(String[] args) {
        int[][] mat = { {1, 2,  3, 4},
                        {5, 6,  7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};


        rotateByKTimesClockWise(mat,4, 9);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
