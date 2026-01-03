package com.java.AccentureCodingRound;

import java.util.Scanner;

public class FindCounter {
    /*
    Problem Statement:

    You are given a function,
    int findCount(int arr[], int length, int num, int diff);

    The function accepts an integer array ‘arr,’ its length and two integer variables ‘num’ and ‘diff.’
    Implement this function to find and return the number of elements of ‘arr’ having an absolute difference
    of less than or equal to ‘diff’ with ‘num’.

    Note: In case there is no element in ‘arr’ whose absolute difference with ‘num’ is less than or equal to ‘diff,’
     return -1.

    Example:
    Input:

    arr: 12 3 14 56 77 13
    num: 13
    diff: 2
    Output:
    3

    Explanation:
    Elements of ‘arr’ having absolute difference of less than or equal to ‘diff’ i.e., 2 with ‘num’
    i.e., 13 are 12, 13 and 14.

     */

    private static int findCount(int[] arr, int n, int num, int diff) {

        // edge case
        if(arr == null || n == 0) return -1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(Math.abs(arr[i] - num) <= diff){
                count++;
            }
        }
        return count == 0 ? -1 : count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.println("Enter n :");
        int n = sc.nextInt ();

        int arr[] = new int[n];

        //System.out.println("Enter arr ele: ");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt ();

        //System.out.println("Enter num: ");
        int num = sc.nextInt ();

        //System.out.println("Enter diff: ");
        int diff = sc.nextInt ();

        //System.out.println("Output :");
        System.out.println (findCount (arr, n, num, diff));
        sc.close();
    }


}

/*
Edge case test inputs (use all of these)

Run these manually. This is where weak solutions fold.

1️⃣ Normal case
6
12 3 14 56 77 13
13
2


Output

3

2️⃣ No matching elements
5
1 2 3 4 5
10
1


Output

-1

3️⃣ All elements match
5
10 11 12 13 14
12
2


Output

5

4️⃣ Single element, match
1
10
11
1


Output

1

5️⃣ Single element, no match
1
10
15
2


Output

-1

6️⃣ diff = 0 (exact matches only)
6
1 2 3 3 3 4
3
0


Output

3

7️⃣ Negative diff
4
1 2 3 4
3
-1


Output

-1

8️⃣ num is negative
5
-5 -3 -1 0 2
-3
1


Output

3

9️⃣ Array contains duplicates
6
5 5 5 5 5 5
5
0


Output

6

🔟 Empty array
0


Output

-1

 */
