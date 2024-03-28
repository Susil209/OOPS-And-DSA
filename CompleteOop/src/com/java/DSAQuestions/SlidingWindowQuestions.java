package com.java.DSAQuestions;


import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

// DSA question:

//Find Cool String:
//-------------------------------------
// Problem Description:
// Given a string s, we want to find and return the number of “cool” substrings of length four.
// A “cool” substring is one where all characters appear only once.
//
// Note : if all substrings occur multiple times everytime it appears should be added to the
// total number of cool substring.
//
// example : input :  s = "abcdcfc"
//           output : 1
// Explanation : we can get 4 substrings of length 4, and they are
//              "abcd", "bcdc" , "cdcf" , "dcfc". Out of all only one cool substring
//              in which every character is unique is "abcd". so output is 1.



public class SlidingWindowQuestions {

    // Approach: 1
    //1. Initialize a dictionary (or an array) to keep track of character frequencies within
    //   a sliding window of size four.
    //2. Slide the window through the string s.
    //3. For each window, check if all characters have a frequency of 1.
    //   If so, increment the count of “cool” substrings.
    //4 .Continue sliding the window until the end of the string.

//    Time Complexity: O(n) (linear time)
//    Space Complexity: O(1) (constant space)

//    Time Complexity:
//    ---------------------
//1.  The algorithm slides a window of size 4 through the input string s.
//2.    For each window, it checks if all characters appear only once.
//3.    Since the window size is fixed (4), the time complexity is O(n), where n is the length of the input string.
//4.    The algorithm iterates through the string once, and the operations within the window are constant time.
//5.    Therefore, the overall time complexity is linear with respect to the input size.
//
//    Space Complexity:
//      --------------------
//    The algorithm uses a dictionary (or map) to keep track of character frequencies within the sliding window.
//    The dictionary stores at most 4 characters (since the window size is 4).
//    Hence, the space complexity is O(1) (constant space).
//    The additional memory used by the algorithm does not depend on the input size.



    /*
    public static boolean isCool(String substring) {
        // Check if all characters in the substring appear only once
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : substring.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            if (charCount.get(c) > 1) {
                return false;
            }
        }
        return true;
    }

    public static int countCoolSubstrings(String s) {
        int n = s.length();
        int coolCount = 0;

        // Slide the window of size 4
        for (int i = 0; i <= n - 4; i++) {
            String substring = s.substring(i, i + 4);
            if (isCool(substring)) {
                coolCount++;
            }
        }

        return coolCount;
    }

     */



    /*
    Alternative Approach: Sliding Window with HashSet
    ----------------------------------------------------
        Sliding Window:
        ----------------------
        1. Instead of checking all substrings of length four, we can slide a window of size four through the string.
        2. Initialize two pointers, left and right, to represent the window boundaries.
        3. Maintain a HashSet to keep track of characters within the window.


        Sliding Window Process:
        -----------------------------
        1. Initially, add the first four characters to the HashSet.
        2. For each subsequent position, slide the window by moving right to the right.
        3. When adding a new character to the window:
            3.1. If it’s already in the HashSet, remove the character at left from the HashSet and increment left.
            3.2. Otherwise, add the new character to the HashSet.
        4. Check if the size of the HashSet is 4 (indicating all unique characters).
             If yes, increment the count of “cool” substrings.


        Example:

        Consider the input string "abcdcfc":
        Initially, the window contains "abcd".
        Slide the window to "bcdf".
        Slide again to "cdfc".
        The window contains all unique characters, so we have one “cool” substring.



        //    Time Complexity: O(n) (linear time)
        //    Space Complexity: O(1) (constant space)

 Time Complexity
        1. Initialization:
            We initialize the window by adding the first four characters to a HashSet.
            This operation takes constant time, i.e., O(1).


        2. Sliding the Window:
            We slide the window from left to right through the string.
            For each position, we either add a new character to the HashSet or remove an old character.
            The sliding process iterates through the entire string once.
            Each addition or removal operation on the HashSet takes constant time, i.e., O(1).

        3. Total Operations:
            The total number of operations (additions and removals) for sliding the window
                is proportional to the length of the input string, which is n.
            Therefore, the overall time complexity is O(n).


Space Complexity
        1. HashSet:
            We use a HashSet to keep track of characters within the sliding window.
            The maximum size of the HashSet is 4 (since the window size is fixed at 4).
            Therefore, the space required for the HashSet is O(1) (constant space).

        2. Additional Variables:
            We use a few additional variables such as pointers (left and right) and temporary character variables (newChar and oldChar).
            These variables do not depend on the input size and occupy constant space.
            Hence, their contribution to space complexity is also O(1).

        3. Total Space Complexity:
            The overall space complexity of the sliding window approach is O(1) (constant space).
            It does not grow with the input size and remains efficient.
     */

    public static int countCoolSubstrings(String s) {
        int n = s.length();
        int coolCount = 0;
        HashSet<Character> window = new HashSet<>();

        // Initialize the window
        for (int i = 0; i < 4; i++) {
            window.add(s.charAt(i));
        }

        // Slide the window
        for (int left = 0, right = 4; right < n; right++) {
            char newChar = s.charAt(right);
            char oldChar = s.charAt(left);

            if (window.contains(newChar)) {
                window.remove(oldChar);
                left++;
            } else {
                window.add(newChar);
            }

            if (window.size() == 4) {
                coolCount++;
            }
        }

        return coolCount;
    }

    public static void main(String[] args) {
        String s = "abcdcfc";
        System.out.println(countCoolSubstrings(s)); // Output: 1
    }

}
