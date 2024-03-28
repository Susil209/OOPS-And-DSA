package com.java.DSAQuestions.Matrix;

public class BSInDecSortedMatrix {

    public static boolean searchMatrixInDec(int[][] A, int target) {
        int r = A.length, c = A[0].length;
        for (int i = 0; i < r; i++) {
            if ((A[i][0] >= target) && (target >= A[i][c - 1])) {
                return binarySearchInDec(A[i], 0, c - 1, target);
            }
        }
        return false;
    }

    private static boolean binarySearchInDec(int[] A, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == target)
                return true;
            else if (A[mid] > target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = { {20,19,18,17},
                        {15,14,13,11},
                        {10,9,8,6},
                        {4,3,2,1}};

        int target = 14;

        System.out.print("Target "+target+" is present ?");
        System.out.println(searchMatrixInDec(mat, target));
    }
}
