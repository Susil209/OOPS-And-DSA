package com.java.DSAQuestions.Stack;


import java.util.Stack;

public class InfixToPostfix {

    // without parenthesis
    public static String infixToPostfixWithoutParenthesis(String exp) {

        // e.g -  "a+b*c-d/e"
        // o.p -  "abc*+de/-"

        // create an empty stack
        Stack<Character> st = new Stack<>();

        // create postfix result
        String postfixExp = "";

        for(char c: exp.toCharArray()) {
            //If the scanned character is an operand, add it to postfix.
            if(isOperand(c)) {
                postfixExp += c;
            } // else if an operator is scanned
            else {
                // check the precedence

                // if prec of scanned operator > prec of stack top, then push
                // else pop the char from stack and add them to postfix
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    postfixExp += st.pop();
                }
                st.push(c);
            }
        }

        // pop all the operators from the stack
        while(!st.isEmpty()) {
            postfixExp += st.pop();
        }

        return postfixExp;
    }

    // with parenthesis (Approach-1)
    // TC=O(n), SC=O(n)
    public static String infixToPostfixWithParenthesis(String exp) {

        //(Approach-1) :

        /*
        Stack<Character> st = new Stack<>();
        StringBuilder postfixExp = new StringBuilder();

        for(char c: exp.toCharArray()) {
            if(isOperand(c)) {
                postfixExp.append(c);
            }
            //If the scanned character is an ‘(‘, push it to the stack.
            else if (c == '(') {
                st.push(c);
            }
            // If the scanned character is an ‘)’, pop and add to the postfix from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {
                while(!st.isEmpty() && st.peek() != '('){
                    postfixExp.append(st.pop());
                }
                st.pop(); // pop out (, but don't add it in the postfix
            }
            // else if an operator is scanned
            else {
                // check the precedence and associativity

                // if prec of scanned operator > prec of stack top, then push
                // else pop the char from stack and add them to postfix
                while(!st.isEmpty() && precedence(c) <= precedence(st.peek()) && associativity(c) == 'L') {
                    postfixExp.append(st.pop());
                }
                st.push(c);
            }
        }

        // pop all the operators from the stack
        while(!st.isEmpty()) {
            postfixExp.append(st.pop());
        }

        return postfixExp.toString();

         */





        // ---------------------------------------------------

        // Approach-2 :

        Stack<Character> st = new Stack<>();
        StringBuilder postfixExp = new StringBuilder();

        for(char c: exp.toCharArray()) {
            if(isOperand(c)) {
                postfixExp.append(c);
            }
            // else if an operator is scanned
            else {
                if (st.isEmpty() || outPrecedence(c) > inPrecedence(st.peek())){
                    st.push(c);
                } else if (outPrecedence(c) == inPrecedence(st.peek())) {
                    st.pop();
                }else {
                    postfixExp.append(st.pop());
                }
            }
        }

        // pop all the operators from the stack
        while(!st.isEmpty() && st.peek() != '(') {
            postfixExp.append(st.pop());
        }

        return postfixExp.toString();


    }

     /*
        sym  | out stack  | in stack
             | precedence | precedence
        ----------------------------------
        +, - |     1      |    2
        *, / |     3      |    4
           ^ |     6      |    5
           ( |     7      |    0
           ) |     0      |    ?
        ----------------------------------
     */

    private static int outPrecedence(char x){
        if (x == '+' || x == '-'){
            return 1;
        } else if (x == '*' || x == '/'){
            return 3;
        } else if (x == '^'){
            return 6;
        } else if (x == '('){
            return 7;
        } else if (x == ')'){
            return 0;
        }
        return -1;
    }

    private static int inPrecedence(char x){
        if (x == '+' || x == '-'){
            return 2;
        } else if (x == '*' || x == '/'){
            return 4;
        } else if (x == '^'){
            return 5;
        } else if (x == '('){
            return 0;
        }
        return -1;
    }

    // check if char is operand
    private static boolean isOperand(char ch) {
//        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(' || ch == ')') {
//            return false;
//        } else{
//            return true;
//        }
        // or

        return ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '^' && ch != '(' && ch != ')';
    }

    /*
        sym  | precedence | associativity
        ----------------------------------
        +, - |     1      |   L - R
        *, / |     2      |   L - R
           ^ |     3      |   R - L
        ----------------------------------
     */

    // check operators precedence
    private static int precedence(char ch) {
        if(ch == '^') return 3;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return 0; // for all other cases
    }

    //check operators associativity
    private static char associativity(char ch) {
        if(ch == '^'){
            return 'R';
        }

        // Default to left-associative
        return 'L';
    }

    public static void main(String[] args) {
//        String res = InfixToPostfix.infixToPostfixWithoutParenthesis("a+b*c-d/e");
//        System.out.println(res); // abc*+de/-

        String res = InfixToPostfix.infixToPostfixWithParenthesis("((a+b)*c)-d^e^f");
//        String res1 = InfixToPostfix.infixToPostfixWithParenthesis("(7^l^1-(8*d/i))");
        System.out.println(res);
    }
}

