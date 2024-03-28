package com.java.DSAQuestions.Matrix;

public class AddTwoMatrix {

    public static int[][] SumOfMatrix(int[][] A,int[][] B){

        int r = A.length, c = A[0].length;
        int[][] C = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] matA = {{2,3,4},{7,8,9},{7,1,3}};
        int[][] matB = {{9,3,14},{27,18,9},{87,10,38}};

        int[][] res = SumOfMatrix(matA,matB);

        System.out.print("Result matrix is \n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(res[i][j] + " ");
            System.out.print("\n");
        }
    }
}
