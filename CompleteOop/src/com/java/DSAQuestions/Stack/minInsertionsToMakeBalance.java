package com.java.DSAQuestions.Stack;

import java.util.Stack;

//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/
public class minInsertionsToMakeBalance {
    public static int minInsertions(String s) {
        // (  ( ))   (   ))      )) -> balanced
        // 1  2  2    3   3       1

        // (  ))  (   (  ))        )))
        // 1   1   2  3  3          2


        // Approach-1: With Stack
        // TC=O(n), SC=O(n)

        /*
        Stack<Character> st = new Stack<>();
        int ans=0;

        for (int i = 0; i < s.length(); i++) {
            // Push all open brackets
            if(s.charAt(i) == '(') {
                st.push(s.charAt(i));
            }
            // For 1st close bracket ")"
            else {
                //if stack is not empty,then it means,it contains a (,so check next character
                if(!st.isEmpty()) { // means "(" is present
                    //if next character is also ) then it is already balanced i.e , ( )) => pop out (
                    if(i+1<s.length() && s.charAt(i + 1) == ')') { // 2nd close present "))"
                        st.pop();
                        i++; // move next
                    }
                    //else one ) should be added so ans++
                    else { // 2nd close not present
                        //  you face single closing ')' add 1 to the answer
                        //  and consider it as '))'
                        ans++;
                        st.pop();
                    }
                }
                //if in case stack is empty,check next character
                else { // means "(" not present that is stack is empty

                    //if next character is ),then you need to add one ( for balancing,so ans++
                    if(i+1<s.length() && s.charAt(i + 1) == ')') { // 2nd close present ))
                        //you have )) with empty stack, add 1 to the answer
                        ans++;
                        i++; // move 1 step
                    }
                    //if next character is not ),then you need to add one ( and one ) for balancing,so ans+=2
                    else { // 2nd close not present
                        ans = ans+2;
                    }
                }
            }
        }

        // after finishing you have x opening remaining in the stack, add 2x to the answer.
        return ans + 2*st.size();

         */


        // Approach-2 (Without stack)

        // TC = O(n), SC = O(1)

                int neededRight = 0;  // Increment by 2 for each '('.
                int missingLeft = 0;  // Increment by 1 for each missing '('.
                int missingRight = 0; // Increment by 1 for each missing ')'.

                for (final char c : s.toCharArray())
                    if (c == '(') {

                        // Previous sequence of close was invalid. For example "..()(..."

                        if (neededRight % 2 != 0) {
                            // e.g. "()(..."
                            ++missingRight; // so we have to add one closing bracket to make it valid
                            --neededRight; // Need not track the last invalid close now
                        }

                        // for current open bracket, need two closing brackets
                        neededRight += 2;
                    } else {
                        --neededRight;
                        if (neededRight < 0) { // c == ')'
                            // // We are here because we see an invalid close.
                            // For example ")..." or "())).."
                            ++missingLeft;

                            // we added an open brace and we need one more close for this new open bracket
                            // note the close_needed was decremented by 1, so adding 2 will effectively make
                            // it +1 in this round
                            neededRight += 2;
                        }
                    }

                return neededRight + missingLeft + missingRight;



    }

    public static void main(String[] args) {
        int ans = minInsertionsToMakeBalance.minInsertions("(()))"); // 1
//        int ans = minInsertionsToMakeBalance.minInsertions("))())(");
        System.out.println(ans);
    }
}
