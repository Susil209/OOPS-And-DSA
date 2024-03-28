package com.java.DSAQuestions.Stack;


import java.util.Stack;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
public class AddMinToMakeValidParenthesis {

    /*
    A parentheses string is valid if and only if:

        It is the empty string,
        It can be written as AB (A concatenated with B),
         where A and B are valid strings, or
        It can be written as (A), where A is a valid string.
        You are given a parentheses string s.
        In one move, you can insert a parenthesis at any position of the string.

    For example, if s = "()))", you can insert an opening parenthesis
    to be "(()))" or a closing parenthesis to be "())))".


    -> Return the minimum number of moves required to make s valid.
     */


    public static int minAddToMakeValid(String s) {
        // Approach-1 : Using Stack
        /*
         * Time Complexity: O(N), where NN is the length of S.
         * Space Complexity: O(N). worst case stack might be size of input.
         */


        /*
        Stack<Character> st = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            }else {
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }

        return st.size();

         */



        // Approach-2: Without Stack
        /*
         * 1.
         * "())"
         * S.charAt(0):::(
         * bal:1 ans:0
         * bal:1 ans:0
         * S.charAt(1):::)
         * bal:0 ans:0
         * bal:0 ans:0
         * S.charAt(2):::)
         * bal:-1 ans:0
         * bal:0 ans:1
         *
         * 2.
         * "((("
         * S.charAt(0):::(
         * bal:1 ans:0
         * bal:1 ans:0
         * S.charAt(1):::(
         * bal:2 ans:0
         * bal:2 ans:0
         * S.charAt(2):::(
         * bal:3 ans:0
         * bal:3 ans:0
         *
         * 3.
         * "()))(("
         * S.charAt(0):::(
         * bal:1 ans:0
         * bal:1 ans:0
         * S.charAt(1):::)
         * bal:0 ans:0
         * bal:0 ans:0
         * S.charAt(2):::)
         * bal:-1 ans:0
         * bal:0 ans:1
         * S.charAt(3):::)
         * bal:-1 ans:1
         * bal:0 ans:2
         * S.charAt(4):::(
         * bal:1 ans:2
         * bal:1 ans:2
         * S.charAt(5):::(
         * bal:2 ans:2
         * bal:2 ans:2
         *
         * Complex Cases: "()))(("
         *
         *
         * Time Complexity: O(N), where N is the length of S.
         * Space Complexity: O(1).
         */

        int ans = 0, bal = 0;
        for (int i = 0; i < s.length(); i++) {
            // System.out.println("S.charAt("+i+"):::"+ S.charAt(i));
            if (s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }
            // System.out.println("bal:"+bal + " ans:"+ans);
            if (bal == -1) {
                bal++;
                ans++;
            }
            // System.out.println("bal:"+bal + " ans:"+ans);
        }

        return bal + ans;


    }

    public static void main(String[] args) {
//        int ans = AddMinToMakeValidParenthesis.minAddToMakeValid("())"); // 1
        int ans = AddMinToMakeValidParenthesis.minAddToMakeValid("((("); // 3
        System.out.println(ans);
    }
}
