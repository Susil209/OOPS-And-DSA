package com.java.DSAQuestions.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

/**    Time Complexity: O(m x n)
    { Since all the elements are being traversed once and
    there are total n x m elements ( m elements in each row and total n rows)
    so the time complexity will be O(n x m)}.

     Space Complexity: O(n) { Extra Space used for storing traversal
     in the ans array }.*/
    public static List<Integer> printSpiral(int[][] A){

        int r = A.length, c = A[0].length;
        List<Integer> ans = new ArrayList<>();

        int top=0, bottom=r-1, left=0, right=c-1;

        while(top <= bottom && left <= right){
            for (int i = left; i <= right ; i++) {
                ans.add(A[top][i]);
            }
            top++;

            for (int i = top; i <= bottom ; i++) {
                ans.add(A[i][right]);
            }
            right--;

            if(top <= bottom){
                for (int i = right; i >= left ; i--) {
                    ans.add(A[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for (int i = bottom; i >= top ; i--) {
                    ans.add(A[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        //Matrix initialization.
        int[][] mat = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};

        List<Integer> res = printSpiral(mat);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }
}
