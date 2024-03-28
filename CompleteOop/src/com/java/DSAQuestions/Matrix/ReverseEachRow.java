package com.java.DSAQuestions.Matrix;

public class ReverseEachRow {

    public static int[][] reverseRow(int[][] A){
        int r = A.length, c = A[0].length;
        int[][] C = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = A[i][c-j-1];
            }
        }

        return C;
    }

    public static void main(String[] args) {
        int[][] mat = { {2,3,4},
                        {7,18,9},
                        {17,11,3}};

        int[][] res = reverseRow(mat);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
