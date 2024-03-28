package com.java.DSAQuestions.Matrix;

public class SearchAnElement {
    // Linear search
    public static boolean searchInMatrix(int[][] A, int ele){
        int r = A.length, c=A[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(A[i][j] == ele)
                    return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int x = 8;
        int[][] arr = { { 0, 6, 8, 9, 11 },
                { 20, 22, 28, 29, 31 },
                { 36, 38, 50, 61, 63 },
                { 64, 66, 100, 122, 128 } };

        if (searchInMatrix(arr, x)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
