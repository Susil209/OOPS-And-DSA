package com.java.DSAQuestions.Matrix;

public class TransposeMatrix {

    public static void transpose(int[][] A, int n){
        // Approach-1
        // TC=O(r*c), SC=O(r*c)
        /*int[][] B = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = B[i][j];
            }
        }*/

        // Approach-2
        // TC=O(r*c), SC=O(1)
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

    }


    public static void main(String[] args) {
        int[][] mat = { {1, 2,  3, 4},
                        {5, 6,  7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

        transpose(mat, 4);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
