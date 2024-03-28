package com.java.DSAQuestions.Matrix;


//    https://leetcode.com/problems/search-a-2d-matrix/description/
public class BinarySearch {

    public static boolean searchMatrix(int[][] A, int target) {

        // Approach-1
        /*    Time Complexity: O(r + log(c)) , SC = O(1)
We are traversing all rows and it takes O(N) time complexity.
 But for all rows, we are not applying binary search rather we
 are only applying it once for a particular row.
 That is why the time complexity is O(N + logM) instead of O(N*logM).*/

        /*int r = A.length, c = A[0].length;

        for (int i = 0; i < r; i++) {
            if ((A[i][0] <= target) && (target <= A[i][c - 1])) {
                return binarySearch(A[i], 0, c - 1, target);
            }
        }
        return false;*/

        // Approach-2
        // Time Complexity: O(log(r*c)) , SC = O(1)
        int r = A.length, c = A[0].length;

        int low = 0, high = (r*c)-1;
        int row_ind,col_ind,mid;

        while(low<=high) {
            mid = (low+high)/2;

            row_ind = mid/c;
            col_ind = mid%c;

            if(A[row_ind][col_ind] == target)
                return true;
            else if(A[row_ind][col_ind] < target)
                low = mid+1;
            else
                high = mid-1;
        }

        return false;
    }

    public static boolean binarySearch(int[] A, int left, int right,int target) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == target)
                return true;
            else if (A[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 } };

        int target = 10;

        System.out.print("Target "+target+" is present ?");
        System.out.println(searchMatrix(arr, target));
    }
}
