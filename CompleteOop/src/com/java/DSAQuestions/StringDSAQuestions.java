package com.java.DSAQuestions;

import java.util.*;

public class StringDSAQuestions {

    void toggleCase(char[] name, int size) {
        for (int i = 0; i < size; i++) {
            //if uppercase convert to lower
            if (name[i] >= 65 && name[i] <= 90) {
                name[i] += 32;
            }

            //if lowercase convert to upper
            else if (name[i] >= 97 && name[i] <= 122) {
                name[i] -= 32;
            }
        }
    }

    void findVowelsAndConsonants(String s) {
        int countVowels = 0, countConsonants = 0;

        // replace all space character with no space
        String newString = s.replaceAll(" ", "");

        // convert string to character array
        char[] ch = newString.toCharArray();

        for (int i = 0; i < newString.length(); i++) {
            // count vowels
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' ||
                    ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
                countVowels++;
            } else {
                countConsonants++;
            }
        }

        System.out.println("Number of vowels " + countVowels + " and consonants " + countConsonants);
    }

    int countWords(String s) {
        int count = 0;

        // convert string to character array
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == ' ') count++;
        }

        return count + 1;
    }

    boolean isValid(String s) {
        // convert string to character array
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (!(ch[i] >= 65 && ch[i] <= 90) && !(ch[i] >= 97 && ch[i] <= 122) && !(ch[i] >= 48 && ch[i] <= 57)) {
                return false;
            }
        }

        return true;
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }


    int compare(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = str1.charAt(i);
            int str2_ch = str2.charAt(i);

            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }

        // Edge case for strings like
        // String 1="Geeks" and String 2="Geeksforgeeks"
        if (l1 != l2) {
            return l1 - l2;
        }

        // If none of the above conditions is true,
        // it implies both the strings are equal
        else {
            return 0;
        }
    }

    boolean isPalindrome(char[] s) {

        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s[i])) i++;
            else if (!Character.isLetterOrDigit(s[j])) j--;
            else {
                if (Character.toLowerCase(s[i++]) != Character.toLowerCase(s[j--]))
                    return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(String s) {

        //Approach-1
        //Using StringBuilder
        // TC = O(n) , SC=O(n)
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            //Check if charAt(i) is between 'A' to 'Z' then convert it to lower case and add it to ans
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                ans.append(Character.toLowerCase(s.charAt(i)));
            }

            //Check if charAt(i) is between 'a' to 'z' then add it to ans
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                ans.append(s.charAt(i));
            }

            //Check if charAt(i) is between '1' to '9' then add it to ans
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ans.append(s.charAt(i));
            }
        }

        //Now Reverse the ans string
        StringBuilder ans2 = new StringBuilder();
        for (int i = 0; i < ans.length(); i++) {
            ans2.insert(0, ans.charAt(i));
        }

        //after reversing check if ans is equal to ans2 then it is a palindrome string
        return ans.toString().contentEquals(ans2);


        // Approach-2
        // TC: O(n) , SC: O(1)
        /*
        int i=0;
        int j=s.length()-1;

        while(i<=j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) i++;
            else if(!Character.isLetterOrDigit(s.charAt(j))) j--;
            else{
                if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))
                    return false;
            }
        }

        return true;
         */


        //Approach-3
        //using regex - TC=O(n) , SC=O(1)
        /*
        String s1 = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int i=0;
        int j=s1.length()-1;
        while(i<j){
            if(s1.charAt(i++)!=s1.charAt(j--)) return false;
        }
        return true;

         */
    }


    // Given a string s, return true if the s can be palindrome
    // after deleting at most one character from it.
    /*
        Example 1:

        Input: s = "aba"
        Output: true

        Example 2:
        Input: s = "abca"
        Output: true
        Explanation: You could delete the character 'c'.

        Example 3:
        Input: s = "abc"
        Output: false

    */

    //https://leetcode.com/problems/valid-palindrome-ii/

    // TC=O(n) , SC=O(1)

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalin(s, i + 1, j) || isPalin(s, i, j - 1);
            } else {
                i++;
                j--;
            }
        }

        return true;

    }

    public boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    void findDuplicates(String s) {
        // Approach-1 (Using third variable)
        // TC=O(n) , SC=O(1)
        // Works only for consecutive duplicates

        /*
        char lastDuplicate='\0';

        for (int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)!=lastDuplicate){
                System.out.print(s.charAt(i));
                lastDuplicate=s.charAt(i);
            }
        }

         */

        // Approach-2 : TC=O(n^2), SC=O(1)

        /*
        char duplicateCounter = '\0';

        for (int i = 0; i < s.length(); i++) {
            for (int j=i+1; j<s.length() ;j++){
                if(s.charAt(i)==s.charAt(j) && s.charAt(i)!=duplicateCounter){
                    System.out.println(s.charAt(i));
                    duplicateCounter=s.charAt(i);
                }
            }
        }

         */

        // Approach-3 : HashTable
        // TC=O(n) , SC=O(n)

        /*
        int[] H = new int[26];

        for (int i = 0; i < s.length(); i++) {
            H[s.charAt(i)-97] +=1;
        }

        for (int i = 0; i < 26; i++) {
            if(H[i]>1){
                System.out.println((char) ((char) i+97));
            }
        }

         */


        // Approach-4 : Using Map
        // TC=O(n) , SC=O(k) k=size of map

        /*
        HashMap<Character,Integer> mp = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(mp.containsKey(s.charAt(i))){
                mp.put(s.charAt(i), mp.get(s.charAt(i))+1);
            }else{
                //increase the count of characters by 1
                mp.put(s.charAt(i),1);
            }
        }

        //iterating through the unordered map
        for(Map.Entry<Character,Integer> it : mp.entrySet()){
            //if the count of characters is greater than 1 then duplicate found
            if(it.getValue() > 1){
                System.out.println(it.getKey()+ ", count = " + it.getValue());
            }
        }
         */


        // Approach-5 : Sorting
        // TC=O(N*logN), where n is the length of the string
        // SC=O(1), if you observe we did not use any extra space


        /*
        int len = s.length();

        // Sorting the string
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);

        // Loop through the sorted string to find duplicates
        for (int i = 0; i < len; i++) {
            int count = 1;

            // Counting the occurrences of each character
            while (i < len - 1
                    && sortedStr.charAt(i)
                    == sortedStr.charAt(i + 1)) {
                count++;
                i++;
            }

            // Printing the duplicate character and its
            // count
            if (count > 1) {
                System.out.println(sortedStr.charAt(i)
                        + ", count = " + count);
            }

        }
         */

        // Approach-6 : Bitwise Operation
        // TC=O(n) , SC=O(1)

        long H = 0, X = 0;

        //maintaining which all are included already as duplicate
        long I = 0;

        char[] ch = s.toCharArray();

        for (char c : ch) {
            X = 1;
            X = X << (c - 97);
//            System.out.println(X);

            if ((X & H) > 0) {
                if ((X & I) == 0) {
                    System.out.println("Duplicate is " + c);
                    I = I | X;
                }
            } else {
                H = X | H;
            }
        }

    }

    // Sorting the string
    String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    boolean isAnagram(String s1, String s2) {

        // Approach-1 : Use sorting
        // Time Complexity: O(n*log n) , Space Complexity: O(1)

        /*
        // when both of the strings have different lengths
        if (s1.length() != s2.length())
            return false;

        // Sorting the string
       s1 = sortString(s1);
       s2 = sortString(s2);

        for (int i=0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)) {
                    return false;
                }
        }
        return true;


         */

        // Approach-2 : Hashtable
        // Time Complexity: O(n) , Space Complexity: O(1)

        /*
        // when both of the strings have different lengths
        if (s1.length() != s2.length())
            return false;
        
        int[] H = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            H[s1.charAt(i)-97] += 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            H[s2.charAt(i) - 97] -= 1;
        }

        for (int i = 0; i < 26; i++)
        {
            if (H[i] != 0)
                return false;
        }
        return true;


         */


        //Approach-3: Hash Table (using Map)
//        Time Complexity: O(N)
//        Auxiliary Space: O(N), Hashmap uses an extra space


        // Check if length of both strings is same or not
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a HashMap containing Character as Key and
        // Integer as Value. We will be storing character as
        // Key and count of character as Value.
        Map<Character, Integer> mp = new HashMap<>();

        for (char x : s1.toCharArray()) {
            // Check if HashMap already contain current
            // character or not
            if (mp.containsKey(x)) {
                // If contains increase count by 1 for that
                // character
                mp.put(x, mp.get(x) + 1);
            } else {
                // else put that character in map and set
                // count to 1 as character is encountered
                // first time
                mp.put(x, 1);
            }
        }

        for (char x : s2.toCharArray()) {
            // Check if current character already exists in
            // HashMap/map
            if (mp.containsKey(x)) {
                // If contains reduce count of that
                // character by 1 to indicate that current
                // character has been already counted as
                // idea here is to check if in last count of
                // all characters in last is zero which
                // means all characters in String a are
                // present in String b.
                mp.put(x, mp.get(x) - 1);
            } else {
                return false;
            }
        }

        // Check if any character has non-zero frequency
        for (int val : mp.values()) {
            if (val != 0) {
                return false;
            }
        }

        return true;


    }


    // Reverse Words in a String
    public String reverseWords(String s) {

        // Approach-1 : (Using Stack)
        // Time Complexity: O(N)
        // Auxiliary Space: O(N)

        /*
        Stack<String> st = new Stack<>();
        StringBuilder tempStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == ' '){
                st.push(tempStr.toString());
                tempStr = new StringBuilder();
            }
            else{
                tempStr.append(s.charAt(i));
            }
        }

        // Last word remaining,add it to stack
        st.push(tempStr.toString());

        String ans = "";

        while (st.size() != 1){
            ans += st.peek() + " ";
            st.pop();
        }

        ans += st.peek();
        return ans;


         */


        // Approach-2 : (Using Vector)
        // Time Complexity: O(N)
        // Auxiliary Space: O(N)

        /*
        Vector<String> v = new Vector<>();
        StringBuilder tempStr = new StringBuilder();

        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == ' '){
                v.addElement(tempStr.toString());
                tempStr = new StringBuilder();
            }
            else{
                tempStr.append(s.charAt(i));
            }
        }

        // Last word remaining,add it to stack
        v.addElement(tempStr.toString());

        String ans = "";

        for(int i=v.size()-1; i>=0; i--){
            ans += v.get(i) + " ";
        }

        return ans;
         */


        //Note: The above code doesn’t handle the cases when the
        // string starts with space.


        // Approach-3 : Two pointer solution
        // Time Complexity: O(N)
        // Auxiliary Space: O(1)

        if (s == null) return null;

        char[] ch = s.toCharArray();
        int n = ch.length;

        // step 1. reverse the whole string
        reverse(ch, 0, n - 1);
        // step 2. reverse each word
        reverseEachWord(ch, n);
        // step 3. clean up spaces
        return cleanSpaces(ch, n);

    }

    // step 2. reverse each word
    private void reverseEachWord(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            // make i and j equal
            // (j might be ahead as it might have seen a word before)
            while (i < j || (i < n && a[i] == ' ')) {
                i++; // skip spaces
            }

            //make j and i equal (i might be ahead as it found few spaces)
            while (j < i || (j < n && a[j] != ' ')) {
                j++;  // skip non spaces
            }

            // reverse the word
            reverse(a, i, j - 1);
        }
    }


    // step 1. reverse the whole string
    private void reverse(char[] a, int i, int j) {
        // swap a[i] and a[j]
        while (i < j) {
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;
        }
    }

    // step 3. clean up spaces
    private String cleanSpaces(char[] c, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && c[j] == ' ') j++; // skip spaces
            while (j < n && c[j] != ' ') {
                c[i++] = c[j++];           // shift characters
            }

            while (j < n && c[j] == ' ') j++;  // skip spaces
            if (j < n) c[i++] = ' '; // // keep only one space between two words
        }

        // return the substring
        return new String(c).substring(0, i);
    }


    // Next smaller Palindrome

    // Problem statement
    // You are given a number 'N' in the form of a string 'S',
    // which is a palindrome. You need to find the greatest number
    // strictly less than 'N' which is also a palindrome.

    /*
    Note:
    1. A palindrome is a word, number, phrase, or another sequence of characters
       that reads the same backward as forward, such as madam, racecar, 1234321,etc.
    2. The numerical value of the given string S will be greater than 0.
    3. A single-digit number is also considered a palindrome.
    4. The answer number should not contain any leading zeros,
       except for the case when the answer is 0.
    5. Note that the length of the string is nothing but the number
       of digits in N.

     */

    // https://www.codingninjas.com/studio/problems/next-smaller-palindrome_841362?ieSlug=infosys-interview-experience-by-tarandeep-singh-off-campus-apr-2021&ieCompany=infosys
    public String nextSmallerPalindrome(String s) {

        if (s.charAt(0) == 1) return "0";
        if (s.length() == 1) {
            char ch = (char) ((s.charAt(0) - 1));
            return String.valueOf(ch);
        }

        int n = s.length();
        int mid = n / 2;
        char[] c = s.toCharArray();

        for (int i = mid; i < n; i++) {
            int temp = c[i] - '0';
            if (temp != 0) {
                c[i] = c[n - 1 - i] = (char) ((temp - 1) + '0');
                break;
            } else {
                c[i] = c[n - 1 - i] = '9';
            }
        }

        if (c[0] == '0') {
            c[0] = '9';
            return new String(c).substring(0, n - 1);
        }
        return new String(c);
    }


    public char getMaxOccuringChar(String s) {
        //Approach-1 (Hashtable)
        // TC=O(n), SC=O(1)

        /*
        char[] c = s.toCharArray();
        int[] H = new int[26];
        int n = c.length;

        for (char value : c) {
            H[value - 'a']++;
        }

        int max = Integer.MIN_VALUE, ans=0;

        for(int i=0;i<26;i++){
            if(H[i]>max){
                ans=i;
                max=H[i];
            }
        }

        return (char) (ans+'a');

         */


        //Approach-2 (Using Map)
        // TC=O(n) + O(log*n) , SC=O(n)

        HashMap<Character, Integer> mp = new HashMap<>();

        // to check count of answer character is less or greater
        // than another elements count
        int max = Integer.MIN_VALUE;
        char ans = 0;

        for (int i = 0; i < s.length(); i++) {  // O(n)
            if (mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);
            } else {
                //increase the count of characters by 1
                mp.put(s.charAt(i), 1);
            }
        }


        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        Collections.sort(list); // O(log*n)
        System.out.println(list);

        for (Character character : list) { // O(n)
            if (mp.get(character) > max) {
                max = mp.get(character);
                ans = character;
            }
        }

        return ans;

    }

    /*
    Problem Statement : You are given a string of words. Replace all the
    spaces with "@40".
     */

    public StringBuilder replaceSpaces(StringBuilder str) {
        // Approach-1 : (Using extra string)
        /*
	        Time Complexity : O(N)
	        Space Complexity : O(N)

	        Where 'N' is size of string of words.
        */

        /*

        // To store result.
        StringBuilder res = new StringBuilder();

        // Variable to store length.
        int len = str.length();

        // Iterate the length of the string.
        for (int i = 0; i < len; i++) {
            // Add "@40" in place of space.
            if (str.charAt(i) == ' ') {
                res.append("@40");
            }
            // Add character to result.
            else {
                res.append(str.charAt(i));
            }
        }
        // Return result.
        return res;

         */


        //Approach-2: (Inplace)
        /*
	        Time Complexity : O(N)
	        Space Complexity : O(1)

	        Where 'N' is size of string of words.
        */

        int spaceCount = 0;

        // Count Number of Spaces.
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        // Store thr current length of the string in a variable.
        int len = str.length();
        // Find the new length.
        int newLength = len + (spaceCount * 2);
        // Resize the current string.
        str.append(" ".repeat(Math.max(0, newLength - len)));

        // Index to end of string.
        int index = newLength - 1;

        // Fill string from end.
        for (int k = len - 1; k >= 0; k--) {
            if (str.charAt(k) == ' ') {
                str.setCharAt(index, '0');
                str.setCharAt(index - 1, '4');
                str.setCharAt(index - 2, '@');
                index = index - 3;
            } else {
                str.setCharAt(index, str.charAt(k));
                index--;
            }
        }

        // Return string.
        return str;
    }


    // Remove all occurrences of substring
    // https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/

    public String removeOccurrences(String s, String part) {

        //Approach-1: (Using Stack)
        // TC = O(n*m) , SC=O(n)

        /*

        Stack<Character> st = new Stack<>();
        int n = s.length(), m = part.length();


//          Traverse through the string from 0th index and push the corresponding
//          character in the stack until stack size is not equal part size


        for (int i = 0; i < n; i++) {
            // push each element in the stack
            st.push(s.charAt(i));
            if(st.size() >= m){
                String ans = "";

//                    When stack size is equal part size then traverse through
//                    part from last character and check if it is equal to the
//                    stack top character if it is equal then pop from stack
//                    and check for next character


                for(int j = m-1; j>=0 ;j--){
                    char ch = part.charAt(j);


//                      If stack top is not equal part character then
//                      we have to fill the stack again so the inner loop
//                      will do that


                    if(ch!=st.peek()){
                        for(int k=0; k<ans.length(); k++){
                            st.push(ans.charAt(k));
                        }
                        break;
                    }else {
                        ans = st.peek() + ans;
                        st.pop();
                    }
                }
            }
        }


//            your stack will remain with the string characters as a result of
//            removal of all substring Now you will make your string using
//            stringBuilder from stack


        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }

        sb.reverse();
        return sb.toString();

        */


        // Approach-2: (Using String)
        // TC = O(n*m), SC=O(1)
        /*
        StringBuilder ans = new StringBuilder();
        int n=s.length(), m=part.length();
        for (int i=0; i<n; i++){
            ans.append(s.charAt(i));
            if(ans.length() >= m &&
                    ans.substring(ans.length()-m).equals(part)){
                ans.setLength(ans.length() - m);
            }
        }
        return ans.toString();

         */


        //Approach-3: Using indexOf()
        // TC = O(n^2), SC=O(1)

        // The java.lang.String.indexOf(String str) method returns
        // the index within this string of the first occurrence of the
        // specified substring. if it does not occur as a substring, -1 is returned.

        int n = s.length(), m = part.length();
        int index = s.indexOf(part);

        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + m);
            n = s.length();
            index = s.indexOf(part);
        }

        return s;
    }


    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/


    public String removeDuplicates(String s) {
        // Approach-1: (Using Stack)
        // TC:O(n) , SC:O(n)

        /*
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(!st.isEmpty()){
                if(st.peek() == s.charAt(i)){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
         */

        // Approach-2: Use string as Stack
        // TC: O(n) , SC:O(1)
        /*
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!sb.isEmpty() && sb.charAt(sb.length()-1) == c){
                // If last character in StringBuilder is same as
                // the current character, then
                // remove the last character from StringBuilder
                sb.setLength(sb.length()-1);
                // or
                // delete the duplicate character
                // sb.deleteCharAt(c);
            }else {
                sb.append(c);
            }
        }

        return sb.toString();

         */

        // Approach -3: Using two pointers
        // TC:O(n), SC:O(1)

        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }


    // https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

    public String removeDuplicates(String s, int k) {
        return "a";
    }


    void printArray(char[] name, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(name[i]);
        }
    }


    //Remove Outermost Parentheses
    //https://leetcode.com/problems/remove-outermost-parentheses/description/
    public static String removeOuterParentheses(String s) {

        //Brute force (Approach-1)
        /*
        String res = "";

        // Stores the count of
        // opened parentheses
        int count = 0;

        // Traverse the string
        for (int c = 0;
             c < S.length(); c++)
        {
            // If opening parentheses is
            // encountered and their
            // count exceeds 0
            if (S.charAt(c) == '(' &&
                    count++ > 0)

                // Include the character
                res += S.charAt(c);

            // If closing parentheses is
            // encountered and their
            // count is less than count
            // of opening parentheses
            if (S.charAt(c) == ')' &&
                    count-- > 1)

                // Include the character
                res += S.charAt(c);
        }


        // Return the resultant string
        return res;
    */

        // Approach-2 (Using stack)
        // TC=O(N) , SC = O(N)
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (!st.isEmpty()) {
                    str.append(c);
                }
                st.push(c);

            } else if (c == ')') {
                st.pop();
                if (!st.isEmpty()) {
                    str.append(c);
                }

            }
        }
        return str.toString();


        //Approach-3 (Optimal)
        // TC=O(N) , SC=O(1)

//        int openCount = 0;
//        int closeCount = 0;
//        StringBuilder result = new StringBuilder();
//        int start = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '(') {
//                openCount++;
//            } else if (c == ')') {
//                closeCount++;
//            }
//
//            if (openCount == closeCount) {
//                result.append(s, start + 1, i);
//                openCount = 0;
//                closeCount = 0;
//                start = i + 1;
//            }
//        }
////      // return the output string(result)
//        return result.toString();

    }


    //Largest Odd Number in String
    //https://leetcode.com/problems/largest-odd-number-in-string/description/
    public static String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            if ((int) (num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    //    Longest Common Prefix
    //https://leetcode.com/problems/longest-common-prefix/description/
    public static String longestCommonPrefix(String[] strs) {

        // Approach-1: (word by word comparison)
        // TC=O(N*M) , SC=O(M)

        /*
        int n = strs.length;
        String prefix = strs[0];

        for (int i = 1; i < n; i++) {
            prefix = commonPrefixUtil(prefix,strs[i]);
        }
        
        return prefix;

         */

        // Approach-2 (Character by char comparison)
        // TC=O(N*M) , SC=O(M)

        /*
        int n = strs.length;
        int minLen = findMinLen(strs,n);

        StringBuilder res = new StringBuilder();
        char currChar;

        for (int i = 0; i < minLen; i++) {
            // Current character (must be same
            // in all strings to be a part of
            // result)
            currChar = strs[0].charAt(i);

            for(int j=1;j<n; j++){
                if (strs[j].charAt(i) != currChar){
                    return res.toString();
                }

            }

            res.append(currChar);  // Append to result
        }

        return "";

         */


        //Approach-3
        // TC=O(n), SC=O(1)

        /*
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;

         */

        //Approach-4: (Divide and Conquer)
        // TC=O(N*M), SC=O(M*logN)

        /*
        int n = strs.length;
        return commonPrefix(strs, 0, n - 1);

         */


        // Approach-5(Binary search)
        //Time Complexity : O(NM log M)
//        The recurrence relation is T(M) = T(M/2) + O(MN), where
//
//        N = Number of strings
//        M = Length of the largest string
//        So we can say that the time complexity is O(NM log M)


//       Auxiliary Space: To store the longest prefix string we are allocating space which is O(N)
//       where, N = length of the largest string among all the strings

        /*
        int n = strs.length;
        int index = findMinLen(strs, n);
        StringBuilder resPrefix = new StringBuilder();

// We will do an in-place binary search on the
        // first string of the array in the range 0 to
        // index
        int low = 0, high = index;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (containsPrefix(strs, n, strs[0], low, mid)) {
                // If all the strings in the input array
                // contains this prefix then append this
                // substring to our answer
                resPrefix.append(strs[0], low, mid + 1);
                low = mid + 1; // And then go for the right part
            } else {  // Go for the left part
                high = mid - 1;
            }
        }

        return resPrefix.toString();

         */


        // Approach-6(using sorting)
        // TC=O(n*log(n)+m)
        // SC=O(1)
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        int n = strs.length;
        String first = strs[0];
        String last = strs[n - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }

        return !ans.isEmpty() ? ans.toString() : "-1";
    }

    public static boolean containsPrefix(String[] arr, int n, String str, int start, int end) {
        for (int i = 0; i < n; i++) {
            for (int j = start; j <= end; j++) {
                if (arr[i].charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static String commonPrefix(String[] arr, int low, int high) {
        if (low == high)
            return arr[low];

        if (high > low) {
            int mid = low + (high - low) / 2;

            String s1 = commonPrefix(arr, low, mid);
            String s2 = commonPrefix(arr, mid + 1, high);

            if (s1 != null && s2 != null) {
                return commonPrefixUtil(s1, s2);
            }
        }

        return null;
    }


    public static int findMinLen(String[] arr, int n) {
        int min = arr[0].length();
        for (int i = 1; i < n; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }

        return min;
    }

    public static String commonPrefixUtil(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result.append(str1.charAt(i));
        }

        return !result.isEmpty() ? result.toString() : "";
    }

    // Isomorphic String
    // https://leetcode.com/problems/isomorphic-strings/description/
    public static boolean isIsomorphic(String s, String t) {
        // Approach-1 (Using hashmap)
        // TC=O(n), SC=O(1)
        Map<Character, Character> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr_s = s.charAt(i);
            char curr_t = t.charAt(i);
            if ((mp.containsKey(curr_s) && mp.get(curr_s) != curr_t) ||
                    (!mp.containsKey(curr_s) && mp.containsValue(curr_t))) {
                return false;
            }

            mp.put(curr_s, curr_t);

        }

        return true;
    }

    //Rotate String
    //Time Complexity: O(N^2), where N is the length of A.
    // For each rotation s, we check up to N elements in A and B.

    //Space Complexity: O(1). We only use pointers to elements of A and B.
    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.isEmpty())
            return true;

        search:
        for (int s = 0; s < A.length(); ++s) {
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt((s + i) % A.length()) != B.charAt(i))
                    continue search;
            }
            return true;
        }
        return false;
    }

    // Sort characters by frequency
    //https://leetcode.com/problems/sort-characters-by-frequency/description/

    public static String frequencySort(String str) {

        // Approach-1(Using hashmap)
        // TC = O( n*log(n) + n^2) , SC = O(n)
        /*
        int n = str.length();

        Map<Character, Integer> mp = new HashMap<>();
        StringBuilder res = new StringBuilder();

        // Count the frequency of each character in the input string
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(str.charAt(i))) {
                mp.put(str.charAt(i), mp.get(str.charAt(i)) + 1);
            } else {
                mp.put(str.charAt(i), 1);
            }
        }

        // Sort the dictionary by value (frequency) in
        // descending order
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(mp.entrySet());

        Collections.sort(sortedList,new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (Objects.equals(o1.getValue(), o2.getValue()))
                        ? o2.getKey() - o1.getKey() : o2.getValue() - o1.getValue();

            }
        });

        for (Map.Entry<Character, Integer> entry : sortedList) {
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }

        return res.toString();

         */


        //Approach-2 (Using Priority Queue)
        // TC = O(n*log(n)), SC = O(n)
        /*
        Map<Character, Integer> mp = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()); // this custom constructor set the priority in desc order

        // Mapping the char with the frequency
        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c,0) + 1);
        }

        // Pushing the char with frequencies in the priority queue
        pq.addAll(mp.entrySet());

        StringBuilder res = new StringBuilder();

        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> entrySet = pq.poll();

            int freq = entrySet.getValue();
            char ch = entrySet.getKey();

            while(freq > 0){
                res.append(ch);
                freq--;
            }
        }

        return  res.toString();

         */


        //Approach-3(Bucket sort)
        //TC = O(n) , SC=O(n)
        Map<Character, Integer> mp = new HashMap<>();

        for (char c : str.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new List[str.length() + 1];

        mp.keySet().forEach(
                key -> {
                    if (bucket[mp.get(key)] == null) {
                        bucket[mp.get(key)] = new ArrayList<>();
                    }
                    bucket[mp.get(key)].add(key);
                }
        );

        // System.out.println(mp); //{r=1, t=1, e=2}

        //   0      1      2    3     4
        // System.out.println(Arrays.toString(bucket)); // [null, [r, t], [e], null, null]

        StringBuilder res = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char ch : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        res.append(ch);
                    }
                }
            }
        }

        return res.toString();
    }

    //  Count With K Different Characters
    // https://www.codingninjas.com/studio/problems/count-with-k-different-characters_1214627?leftPanelTabValue=PROBLEM&count=25&page=11&search=&sort_entity=order&sort_order=ASC&attempt_status=NOT_ATTEMPTED
    public static int countSubStrings(String str, int k) {
        // Approach-1(Brute Force)
        /*
            Time Complexity: O(N ^ 3)
            Space complexity: O(N)

            Where N denotes the length of the given string.
        */


        /*
        int count = 0;

        // All possible substrings.
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length() + 1; j++) {
                String sub = str.substring(i, j);

                // Map for counting distinct chars.
                HashMap<Character, Integer> map = new HashMap<>();
                for (int l = 0; l < sub.length(); l++) {
                    // If char is already present update value.
                    if (map.containsKey(sub.charAt(l))) {
                        map.put(sub.charAt(l), map.get(sub.charAt(l)) + 1);
                    } else {
                        // Else put the new key.
                        map.put(sub.charAt(l), 1);
                    }
                }
                // If distinct chars are equal to K increment count.
                if (map.size() == k)
                    count++;
            }
        }
        return count;

         */


        // Approach-2(Optimized)
        /*
            Time Complexity: O(N ^ 2)
            Space complexity: O(1)

            Where N denotes the length of the given string.
        */


        /*
        int result = 0;

        // Array to store count of characters.
        int[] count = new int[26];

        // All substrings.
        for (int i = 0; i < str.length(); i++) {
            int distinctChars = 0;

            // Initializing count array with zero for every iteration.
            Arrays.fill(count, 0);

            for (int j = i; j < str.length(); j++) {
                int index = count[str.charAt(j) - 'a'];
                if (index == 0) {
                    distinctChars++;
                }

                // Increment count of current character.
                index++;

                if (distinctChars == k) {
                    result++;
                }

                if(distinctChars > k) break;
            }
        }

        return result;

         */


        //Approach-3(Linear)
        /*
            Time Complexity: O(N)
            Space complexity: O(1)

            Where N denotes the length of the given string.
        */

        // Calculating for at most k and at most k-1 distinct chars.
        int ans = helper(str, k) - helper(str, k - 1);
        return ans;
    }

    public static int helper(String str, int k) {

        int i = 0, j = 0, currCount = 0;
        int result = 0;

        // Array to store count of characters.
        int[] count = new int[26];

        while (j < str.length()) {
            // Index for current character.
            int index = str.charAt(j) - 'a';

            // Increment count for the current character.
            count[index]++;

            if (count[index] == 1) {
                currCount++;
            }

            // Decrement count and increase ith pointer.
            while (currCount > k) {
                count[str.charAt(i) - 'a']--;
                if (count[str.charAt(i) - 'a'] == 0) {
                    currCount--;
                }

                i++;
            }

            // Total substrings.
            result += (j - i + 1);
            j++;
        }
        return result;
    }

    public static String longestPalindrome(String s) {
        //Approach-1(Brute force)
        //Time complexity : O(n^3), Space complexity : O(1).

        /*
        int n = s.length();
        int max_len=1;
        String max_palindrome_str = s.substring(0,1);

        for(int i=0; i<n ;i++) {
            for(int j=i+max_len; j<=n ;j++){
                if(j-i > max_len && isPalindromeString(s.substring(i,j))){
                    max_len = j-i;
                    max_palindrome_str = s.substring(i,j);
                }
            }
        }

        return max_palindrome_str;
         */

        // Approach-2(Expand around center)
        // TC: O(n^2) , SC: O(1)


        if (s.length() <= 1) return s;

        String max_str = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expand_from_center(s, i, i);
            String even = expand_from_center(s, i, i + 1);

            if(odd.length() > max_str.length()){
                max_str = odd;
            }

            if (even.length() > max_str.length()){
                max_str = even;
            }
        }

        return max_str;
    }

    private static String expand_from_center(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    private static boolean isPalindromeString(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        char[] name = {'j','a','v','a','T','U','T'};
//        System.out.println("Length of the string "+ name.length);


        StringDSAQuestions s = new StringDSAQuestions();

//        s.reverseString(name);
//        s.printArray(name, name.leng//Longest Common Prefixth);


//        s.toggleCase(name, name.length);
//        s.printArray(name, name.length);

//        String st = "how are you";
//        System.out.println(st);

//        s.findVowelsAndConsonants(st);
//        System.out.println("Number of words are "+ s.countWords(st));

//        String s1 = "demo@1221";
//        if(s.isValid(s1)){
//            System.out.println("Valid string");
//        }else {
//            System.out.println("Not valid string");
//        }

//        String s1 = "hello";
//        String s2 = "Hello";

//        System.out.println(s.compare(s1,s2));
//        if(s.compare(s1,s2)==0) System.out.println("s1 = s2");
//        if(s.compare(s1,s2)>0) System.out.println("s1 > s2");
//        if(s.compare(s1,s2)<0) System.out.println("s1 < s2");


//        System.out.println((int)s1.charAt(0));
//        System.out.println(s1.equals(s2));
//        System.out.println(Objects.equals(s1,s2));
//        System.out.println(s1.compareTo(s2));

//        char[] c ={'m','a','d','a'};
//        System.out.println(s.isPalindrome(c));

//        String s3 = "A man, a plan, a canal: Panama";
//        System.out.println(s.isPalindrome(s3));


//        String s1 = "findingsss";
//        s.findDuplicates(s1); // i n


//        String s1 = "decimal";
//        String s2 = "medical";
//        System.out.println(s.isAnagram(s1,s2));


//        String s1 = "    I like      Java     ";
//        System.out.println(s.reverseWords(s1));

//        String s1 = "12321";
//        System.out.println(s.nextSmallerPalindrome(s1));


//        String s1 = "testsample";
//        System.out.println(s.getMaxOccuringChar(s1));

//        StringBuilder str = new StringBuilder("Hello World");
//        System.out.println(s.replaceSpaces(str));


        // Q. Remove all occurrences of substring

//        String s1 = "daabcbaabcbc", part = "abc";
//        String ans = s.removeOccurrences(s1,part);
//        System.out.println(ans);

        // Q. Remove all adjacent duplicated

//        String s1 = "abbaca";
//        String ans = s.removeDuplicates(s1);
//        System.out.println(ans);


        // Q. Remove Outer parentheses

//        String str = "(()())(())";
//        System.out.println(removeOuterParentheses(str));

        //Q .Largest Odd Number in String
//        String str = "42163";
//        System.out.println(largestOddNumber(str));

        //Q. Longest Common Prefix
//        String[] strs = {"flower", "flow", "flight"};
//        System.out.println(longestCommonPrefix(strs));

        //Q. Isomorphic String
//        System.out.println(isIsomorphic("foo","baa"));

        //Q. Rotate string
//        System.out.println(rotateString("bbbacddceeb", "ceebbbbacdd"));

        //Q. Sort characters by frequency
//        System.out.println(frequencySort("tree"));

        // Q. Count With K Different Characters
//        String str = "aacfssa";
//        System.out.println(countSubStrings(str,3));

        //Q. Longest Palindrome
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
}
