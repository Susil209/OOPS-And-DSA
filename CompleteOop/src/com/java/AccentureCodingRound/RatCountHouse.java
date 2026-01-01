package com.java.AccentureCodingRound;

import java.util.Scanner;

public class RatCountHouse {
    /*
Problem Description :
    The function accepts two positive integers ‘r’ and ‘unit’ and a positive integer array ‘arr’ of size ‘n’
    as its argument ‘r’ represents the number of rats present in an area,
    ‘unit’ is the amount of food each rat consumes, and each ith element of array
    ‘arr’ represents the amount of food present in ‘i+1’ house number, where 0 <= i

Note:
- Return -1 if the array is null
- Return 0 if the total amount of food from all houses is not enough for all the rats.
- Computed values lie within the integer range.

Example:

Input:
r: 7
unit: 2
n: 8
arr: 2 8 3 5 7 4 1 2

Output:
4

Explanation:
Total amount of food required for all rats = r * unit
                                           = 7 * 2 = 14.

The amount of food in 1st houses = 2+8+3+5 = 18. Since, amount of food in 1st 4 houses is enough for all the rats.
 Thus, output is 4.

*/
    private static int Solve(int r, int unit, int[] arr, int n) {

        // TC = O(n), SC = O(1)
        // base case
//        if(n == 0) return -1; // not solving arr = null problem
        if(arr == null) return -1;
        if(r==0 || unit==0) return 0;
        int total_food = r * unit;

        int curr_food = 0, no_of_houses = 0;
        while(no_of_houses < n) {
            curr_food = curr_food + arr[no_of_houses];
            no_of_houses++;

            if(curr_food >= total_food){
                return no_of_houses; // Note the i + 1 because house count is 1-based.
            }
        }

        // if total food is not enough returns 0
        if(curr_food < total_food) return 0;


        return no_of_houses;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Take r : ");
        int r = sc.nextInt ();
        System.out.print("Take unit : ");
        int unit = sc.nextInt ();
        System.out.print("Take n : ");
        int n = sc.nextInt ();
        int arr[] = new int[n];

        System.out.println("Take arr : ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt ();
        }

        System.out.println("Total no. of houses: ");
        System.out.println(Solve(r, unit, arr, n));
        sc.close();
    }


}

/*

 TEST CASES

1. Null array (hard fail case)

Input

r = 5
unit = 2
arr = null


Expected Output

-1


Why
Problem statement explicitly says so. No philosophy required.

2. Empty array (no houses)

Input

r = 5
unit = 2
arr = {}


Expected Output

0


Why
No houses → no food → insufficient food.

3. Single house, exact food match

Input

r = 4
unit = 3
arr = {12}


Expected Output

1


Why
One house feeds all rats exactly. No leftovers, no drama.

4. Single house, insufficient food

Input

r = 4
unit = 3
arr = {10}


Expected Output

0


Why
Required = 12, available = 10. Rats stay hungry. Interviewers stay happy.

5. Food becomes sufficient at the last house

(off-by-one killer case)

Input

r = 6
unit = 2
arr = {2, 2, 2, 2, 2, 2}


Expected Output

6


Why
Total food = 12, achieved only after last house.

This is where buggy logic returns 0 instead of 6.

6. Food sufficient at first house

Input

r = 3
unit = 2
arr = {10, 1, 1}


Expected Output

1


Why
Stop early. No need to loot the whole neighborhood.

7. Required food is zero (rats or unit = 0)
Case A: No rats
r = 0
unit = 5
arr = {1, 2, 3}

Case B: Zero consumption
r = 5
unit = 0
arr = {1, 2, 3}


Expected Output

0


Why
Zero food needed. Rats are apparently on a diet.

8. Very large values (overflow paranoia test)

Input

r = 100000
unit = 100000
arr = {1000000000, 1000000000}


Expected Output

2


Why
Still fits in int per problem statement.
If this breaks, Java isn’t the issue.

9. All houses have zero food

Input

r = 1
unit = 1
arr = {0, 0, 0, 0}


Expected Output

0


Why
Hope is not food.

10. Mixed zeros and positives

Input

r = 5
unit = 2
arr = {0, 0, 10, 0}


Expected Output

3


Why
Zeros don’t matter, count still matters.

11. Exact match in the middle

Input

r = 5
unit = 2
arr = {3, 3, 4, 1}


Expected Output

3


Why
3 + 3 + 4 = 10. Stop immediately. No sightseeing.

12. Large array, small requirement (performance sanity)

Input

r = 1
unit = 1
arr = {1, 0, 0, 0, 0, ...}


Expected Output

1


Why
Early exit. Confirms O(n) behavior is efficient.

 */