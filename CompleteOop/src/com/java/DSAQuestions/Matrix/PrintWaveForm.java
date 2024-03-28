package com.java.DSAQuestions.Matrix;

public class PrintWaveForm {

    public static void waveForm(int[][] A){

        // TC=O(r*c), SC=O(r*c)
        int row = A.length, col = A[0].length;

        for (int j = 0; j < col; j++) {
            if(j%2==0){
                for (int i = 0; i < row; i++) {
                    System.out.print(A[i][j] + " ");
                }
            }else {
                for (int i = row-1; i >= 0; i--) {
                    System.out.print(A[i][j] + " ");
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] mat = { {2,3,4,11},
                        {17,8,9,12},
                        {7,1,3,13},
                        {8,6,1,10}};

        waveForm(mat);
    }
}
