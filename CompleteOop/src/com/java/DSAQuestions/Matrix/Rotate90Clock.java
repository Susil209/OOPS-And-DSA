package com.java.DSAQuestions.Matrix;

public class Rotate90Clock {

    // Approach-1 (Using extra space/ brute force)
    // TC=O(n^2), SC=O(n^2)
    /*public static int[][] rotateBy90Deg(int[][] A,int n) {

        int[][] B = new int[n][n];
        int col = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[n-j-1][col];
            }
            col++;
        }

        return B;
    }*/
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

    public static void rotateBy90Deg(int[][] A,int n){
        // get the transpose
        transpose(A,n);

        // reverse column wise
        reverseByCol(A,n);
    }



    public static void main(String[] args) {
        int[][] mat = { {1, 2,  3, 4},
                        {5, 6,  7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

//        int[][] res = rotateBy90Deg(mat,4);

        rotateBy90Deg(mat,4);


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }


}
