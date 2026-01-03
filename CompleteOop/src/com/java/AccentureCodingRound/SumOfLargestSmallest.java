package com.java.AccentureCodingRound;

import java.util.Scanner;

public class SumOfLargestSmallest {
    /*
    Problem Statement:
    You are required to implement the following Function

def LargeSmallSum(arr)

The function accepts an integers arr of size ’length’ as its arguments you are required to
return the sum of second largest  element from the even positions and
 second smallest from the odd position of given ‘arr’

Assumption:

All array elements are unique
Treat the 0th position as even

NOTE

Return 0 if array is empty
Return 0, if array length is 3 or less than 3
Example

Input

arr:3 2 1 7 5 4

Output

7

Explanation

Second largest among even position elements(1 3 5) is 3
Second smallest among odd position element is 4
Thus output is 3+4 = 7
Sample Input

arr:1 8 0 2 3 5 6

Sample Output

8

     */

    private static int largeSmallSum(int[] arr) {

        // TC = O(n), SC = O(1)
        if(arr == null || arr.length <= 3) return 0;

        int highestEven = Integer.MIN_VALUE;
        int secondHighestEven = Integer.MIN_VALUE;
        int smallestOdd = Integer.MAX_VALUE;
        int secondSmallestOdd = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            // checking for even index
            if(i % 2 == 0){
                if(arr[i] > highestEven){
                    // update second-highest first, then change the highest value
                    secondHighestEven = highestEven;
                    highestEven = arr[i];
                }
                // case where element from the remaining array is not highest,
                // it won't change the highest value that means manually check with the 2nd highest
                else if(arr[i] > secondHighestEven){
                    secondHighestEven = arr[i];
                }
            }
            // checking for odd index
            else{
                if(arr[i] < smallestOdd){
                    secondSmallestOdd = smallestOdd;
                    smallestOdd = arr[i];
                }else if(arr[i] < secondSmallestOdd){
                    secondSmallestOdd = arr[i];
                }

            }
        }
        // Safety check
        if (secondHighestEven == Integer.MIN_VALUE ||
                secondSmallestOdd == Integer.MAX_VALUE)
            return 0;

        return secondHighestEven + secondSmallestOdd;

        // alternate approach
        /*
        Separate even-index and odd-index values

        Sort them

        Pick required elements

        private static int largeSmallSum(int[] arr) {

            if (arr == null || arr.length <= 3)
                return 0;

            ArrayList<Integer> even = new ArrayList<>();
            ArrayList<Integer> odd = new ArrayList<>();

            for (int i = 0; i < arr.length; i++) {
                if (i % 2 == 0)
                    even.add(arr[i]);
                else
                    odd.add(arr[i]);
            }

            if (even.size() < 2 || odd.size() < 2)
                return 0;

            Collections.sort(even);
            Collections.sort(odd);

            int secondLargestEven = even.get(even.size() - 2);
            int secondSmallestOdd = odd.get(1);

            return secondLargestEven + secondSmallestOdd;
        }


         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt ();

        System.out.println("Enter arr: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt ();

        System.out.println("Sum is: ");
        System.out.println (largeSmallSum (arr));
        sc.close();
    }


}
