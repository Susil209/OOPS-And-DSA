package com.java.DSAQuestions.Matrix;

public class SearchInRowColSorted {

    public static boolean searchInRowCol(int[][] A, int N, int M, int x){

        // Approach-1 (Brute)
        // TC = O(N*M) , SC=O(1)
        /*for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] == x)
                    return true;
            }
        }

        return false;*/

        // Approach-2 (Better)
        // TC = O(N + logM), SC=O(1)
        /*for (int i = 0; i < N; i++) {
            if(A[i][0] <= x && x<= A[i][M-1]){
                int low = 0, high = M-1;

                while(low <= high){
                    int mid = (low + high)/2;
                    if(mid == x) return true;
                    else if(mid < x) low = mid+1;
                    else high = mid-1;
                }

                return false;
            }
        }

        return false;*/



        // Approach-3 (Optimal)
        // TC = O(N+M), SC=O(1)
        int i = 0, j = M-1;

        while(i < N && j >= 0){
            if(A[i][j] == x) return true;
            else if(A[i][j] > x) j--;
            else i++;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = { {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};

        int numOfRows = mat.length, numOfCols = mat[0].length;
        int target = 18;

        System.out.print("Target "+ target + " is present? ");
        System.out.println(searchInRowCol(mat, numOfRows, numOfCols , target));

    }
}
