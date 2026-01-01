package com.java.AccentureCodingRound;

import java.util.Scanner;

public class BinaryStringOperation {
    /*
Problem Description:
The Binary number system only uses two digits, 0 and 1 and number system can be
called binary string. You are required to implement the following function:

Int OperationsBinaryString(char* str);

The function accepts a string str as its argument.
The string str consists of binary digits separated with an alphabet as follows:

– A denotes AND operation
– B denotes OR operation
– C denotes XOR Operation
You are required to calculate the result of the string str,
scanning the string to right, taking one operation at a time, and return the same.

Note:

– No order of priorities of operations is required
– Length of str is odd
– If str is NULL or None (in case of Python), return -1

Input:
str: 1C0C1C1A0B1

Output:
1

Explanation:
The alphabets in str when expanded becomes “1 XOR 0 XOR 1 XOR 1 AND 0 OR 1,”
a result of the expression becomes 1, hence 1 is returned.

Sample Input:
0C1A1B1C1C1B0A0

Output:
0

*/
    private static int OperationsBinaryString(String str) {

        // TC = O(n), SC = O(1)
        // str: 1C0C1C1A0B1

        //edge cases
        if(str == null || str.isEmpty()) return -1;

        int result = str.charAt(0) - '0'; //1

        // iterate from 1st index
        for (int i = 1; i < str.length(); i+=2) {
            char operators = str.charAt(i); // C, A , B
            int nextDigit = str.charAt(i+1) - '0';

            // checking for numbers other than 0 and 1(hidden case)
            if (nextDigit != 0 && nextDigit != 1) return -1;

            if(operators == 'A'){ // AND operation
                result = result & nextDigit;
            }else if (operators == 'B') { // OR operation
                result = result | nextDigit;
            }else if (operators == 'C') { // XOR operation
                result = result ^ nextDigit;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(OperationsBinaryString(str));
        sc.close();
    }


}
