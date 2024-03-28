package com.java.DSAQuestions.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        // (,),[,],{,} -> valid
        // edge cases -> ([)] , [)(]

        // TC = O(n), SC = O(n)
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            // opening bracket we will push it into the stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // If the stack is empty, there is no matching opening bracket,
                // so return false
                if (st.isEmpty()) return false;

                // Otherwise, get the top of the stack and check if it's
                // the matching opening bracket
                char topEle = st.peek();
                if ((ch == ')' && topEle == '(') || (ch == '}' && topEle == '{') || (ch == ']' && topEle == '[')){
                    st.pop();
                }else { // the brackets don't match, so return false
                    return false;
                }

            }
        }

        // finally check if all brackets find their matching then stack is empty
        // If not and there is still element at the end of the for loop
        // return false as there is no matching

        return st.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(ValidParenthesis.isValid("{[])")); // false
        System.out.println(ValidParenthesis.isValid("{[]}")); // true
    }
}


