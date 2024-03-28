package com.java.Java8Features.PredefinedFI.Predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        // check for even numbers

        /*
        Predicate<Integer> p = i -> i%2==0; // returns boolean value
        System.out.println(p.test(5)); // false
        System.out.println(p.test(10)); // true

         */

        // check for string length > 5

        /*
        List<String> arr = Arrays.asList("Susil", "Nayak" ,"Bikash" ,"Baibhab");

        Predicate<String> p = s -> s.length() > 5;

        for (String s: arr) {
            if(p.test(s)){
                System.out.println(s);
            }
        }

         */


        //check for username and password

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter user name:");
        String username = sc.next();

        System.out.println("Enter password:");
        String password = sc.next();

        User user = new User(username,password);

        // multiple conditions check
        Predicate<User> p = u -> u.username.equals("Susil") && u.password.equals("pass");

        if (p.test(user)){
            System.out.println("Valid username and password.");
        }else {
            System.out.println("Invalid username and password.");
        }



    }
}


class User{
    String username;
    String password;

    User(String username, String password){
        this.username = username;
        this.password = password;
    }
}