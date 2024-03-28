package com.java.DSAQuestions.Stack;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPrefix {

    // Reverse the letters of the word
    static String reverse(String str, int start, int end)
    {
        char[] str1 = str.toCharArray();

        // Temporary variable to store character
        char temp;
        while (start < end) {
            // Swapping the first and last character
            temp = str1[start];
            str1[start] = str1[end];
            str1[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str1);
    }


    // Function to convert infix to prefix notation
    public static String inToPre(String s) {

        // reverse infix
        String infix1 = reverse(s, 0, s.length() - 1);
        char[] infix = infix1.toCharArray();

        int l = infix.length;

        // Replace ( with ) and vice versa
        for (int i = 0; i < l; i++) {

            if (infix[i] == '(') {
                infix[i] = ')';
            }
            else if (infix[i] == ')') {
                infix[i] = '(';
            }
        }

        String prefix = infixToPostfix(Arrays.toString(infix));

        prefix = reverse(prefix,0,l-1);

        return prefix;
    }

    private static String infixToPostfix(String s) {
        String infix = '(' + s + ')';

        Stack<Character> st = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (char c: infix.toCharArray()) {
            if (isOperand(c)) {
                output.append(c);
            }
            else if (c == '(') {
                st.push(c);
            }
            else if (c == ')') {
                while(!st.isEmpty() && st.peek() != '('){
                    output.append(st.pop());
                }
                st.pop(); // pop out (, but don't add it in the postfix
            }
            else {
                while(!st.isEmpty() && precedence(c) < precedence(st.peek()) && associativity(c) == 'L') {
                    output.append(st.pop());
                }
                st.push(c);
            }
        }

        while(!st.isEmpty()) {
            output.append(st.pop());
        }


        return output.toString();
    }

    private static boolean isOperand(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(' || ch == ')') {
            return false;
        } else{
            return true;
        }
    }

    private static int precedence(char ch) {
        if(ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return 0; // for all other cases
    }

    private static char associativity(char ch) {
        if(ch == '^'){
            return 'R';
        }

        // Default to left-associative
        return 'L';
    }



    public static void main(String[] args) {
        String s = "x+y*z/w+u";

        System.out.print(inToPre(s));
    }
}
