package com.java.DSAQuestions;

import java.util.*;

public class FirstNonRepeating {
    public static String firstNonRepeatingChar(String A) {

        // a b a b d c
        // a a b # d d


        // Approach-1 (Using Count array)
        // TC=O(n), SC=O(n)
//        String res="";
//        int[] count_freq = new int[26];
//        Queue<Character> q = new LinkedList<>();

        /*for (int i = 0; i < A.length(); i++) {
            int char_freq = A.charAt(i)-'a';

            count_freq[char_freq]++;
            q.add(A.charAt(i));

            while(!q.isEmpty() && count_freq[q.peek()-'a']>1){
                q.remove();
            }

            if(q.isEmpty())
                res+="#";
            else
                res+=q.peek();
        }*/


        // Better
        /*for (int i = 0; i < A.length(); i++) {

            int char_freq = A.charAt(i)-'a';
            // repeated char
            if(count_freq[char_freq] >= 1){
                count_freq[char_freq]++;

                while(!q.isEmpty() && count_freq[q.peek()-'a']>1){
                    q.remove();
                }

                if(q.isEmpty())
                    res+="#";
                else
                    res+=q.peek();
            }
            // non repeated char
            else {
                count_freq[char_freq]++;
                q.add(A.charAt(i));

                while(count_freq[q.element()-'a']>1){
                    q.remove();
                }

                res+=q.peek();
            }
        }

        return res;

         */


        // Approach-2(Using HashMap)
        // ArrayList
    /*    List<Character> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (char ch: A.toCharArray()) {
            // any new character encountered first time
            if (!map.containsKey(ch)) {
                list.add(ch);
                map.put(ch, 1);
            }
            else {
                //any repeated character encountered
                int index = list.indexOf(ch);

                // for any repeated character encountered more than twice the
                // index will be -1
                if (index != -1)
                    list.remove(index);
            }

            if(list.isEmpty())
                res.append("#");
            else
                res.append(list.get(0));
        }

        return res.toString();*/

        // Queue
//        Time Complexity: O(26 * n)
//        Auxiliary Space: O(n)
        Queue<Character> q = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(!map.containsKey(ch)){
                q.add(ch);
            }
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(!q.isEmpty() && map.get(q.peek()) > 1){
                q.remove();
            }

            if(q.isEmpty())
                res.append("#");
            else
                res.append(q.element());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String A = "ababdc";
        System.out.println(firstNonRepeatingChar(A));
    }
}
