package com.java.DSAQuestions.Stack;

import java.util.Stack;

public class evaluationOfPostfix {

    // TC=O(n), SC=O(n)

    private static int evaluateNumber(int x1,int x2,char c) {

        return switch (c) {
            case '+' -> x1 + x2;
            case '-' -> x1 - x2;
            case '*' -> x1 * x2;
            case '/' -> x1 / x2;
            default -> 0;
        };
    }

    //Function to evaluate a postfix expression.
    public static int evaluatePostfix(String S)
    {
        Stack<Integer> st = new Stack<>();
        int x1,x2;

        for(char c: S.toCharArray()) {
            if(Character.isDigit(c)) {
                st.push(c - '0'); // ascii(c) - ascii('0') , ascii('0')=48
            }else {
                x2 = st.pop();
                x1 = st.pop();

                int ans = evaluateNumber(x1,x2,c);
                st.push(ans);
            }
        }

        return st.peek();
    }

    public static int postfixEvalMultiDigit(String s) {
        // "100 200 + 2 / 5 * 7 +"

        //Time Complexity: O(N)
        //Auxiliary Space: O(N)
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c =s.charAt(i);

            if (c == ' ') continue;
            else if(Character.isDigit(c)) {
                int num=0;

                while(Character.isDigit(c)) {
                    num = num*10 + (c-'0');
                    i++;
                    c = s.charAt(i);
                }
                i--;

                st.push(num);
            }

            else {
                int val2 = st.pop();
                int val1 = st.pop();

                int ans = evaluateNumber(val1,val2,c);
                st.push(ans);
            }
        }

        return st.peek();
    }

    public static void main(String[] args) {
        int ans = evaluatePostfix("35*62/+4-");
        System.out.println(ans); // 14

        int ans1 = postfixEvalMultiDigit("100 200 + 2 / 5 * 7 +");
        System.out.println(ans1);
    }
}
