package com.java.AccentureCodingRound;

import java.util.Scanner;

public class PasswordChecker {
    /*
    Problem statement:
You are given a function.
Int CheckPassword(char str[], int n);
The function accepts string str of size n as an argument.
Implement the function which returns 1 if given string str is valid password else 0.
Str is a valid password if it satisfies the below conditions.

– At least 4 characters
– At least one numeric digit
– At Least one Capital Letter
– Must not have space or slash (/)
– Starting character must not be a number

Assumption:
Input string will not be empty.

Example:

Input 1:
aA1_67
Input 2:
a987 abC012

Output 1:
1
Output 2:
0

*/

    private static int checkPassword(String str, int length) {
    //– At least 4 characters
    //– At least one numeric digit
    //– At Least one Capital Letter
    //– Must not have space or slash (/)
    //– Starting character must not be a number

        // base case
        if(str == null || length < 4) return 0;

        // Starting character must not be a number
        if(Character.isDigit(str.charAt(0))) return 0;

        boolean hasUppercase = false, hasNumValue = false;
        for (int i=0; i<length; i++){
            char ch = str.charAt(i);

            // nullify the space and slash first
            if(ch == ' ' || ch == '/'){
                return 0;
            }

            // check for only existence of uppercase and numeric value

            if(Character.isDigit(ch)){
                hasNumValue = true;
            } else if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
        }

        if(hasUppercase && hasNumValue)
            return 1;

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Password: ");
        String str = sc.nextLine();

        System.out.println (checkPassword (str, str.length()));
        sc.close();
    }


}

/*
   TEST CASES
   Valid minimal password
aA1b


Output

1

2️⃣ Less than 4 characters
aA1


Output

0

3️⃣ Starts with digit
1Aa_


Output

0

4️⃣ No uppercase letter
a1bcdef


Output

0

5️⃣ No numeric digit
aAbcdef


Output

0

6️⃣ Contains space
aA1 bc


Output

0

7️⃣ Contains slash
aA1/bc


Output

0

8️⃣ Special characters allowed
aA1_@#


Output

1

9️⃣ Uppercase only, no digit
ABCDef


Output

0

🔟 Exactly 4 characters, all rules satisfied
Zx9_


Output

Valid minimal password
aA1b


Output

1

2️⃣ Less than 4 characters
aA1


Output

0

3️⃣ Starts with digit
1Aa_


Output

0

4️⃣ No uppercase letter
a1bcdef


Output

0

5️⃣ No numeric digit
aAbcdef


Output

0

6️⃣ Contains space
aA1 bc


Output

0

7️⃣ Contains slash
aA1/bc


Output

0

8️⃣ Special characters allowed
aA1_@#


Output

1

9️⃣ Uppercase only, no digit
ABCDef


Output

0

🔟 Exactly 4 characters, all rules satisfied
Zx9_


Output

1

 */