package com.java.Collection;

//How to Initialize a Java List – List of String Initialization in Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListInitialize {

    /*In Java, there are different ways to initialize a list:

    1. Using the ArrayList constructor.
    2. Using the add() method.
    3. Using the Arrays.asList() method.
    4. Using the Stream.of() method.

    */

    public static void main(String[] args) {

//        1. Using the ArrayList constructor.

       /* // create an array of integers
        Integer[] array = {1, 2, 3, 4, 5};

        // create a list from the array
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));

        // print the list
        System.out.println(list); // [1, 2, 3, 4, 5]*/

//        2. Using the add() method.

        /*// create a new ArrayList
        List<String> myList = new ArrayList<>();

        // add elements to the list using the add() method
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // print the contents of the list
        System.out.println(myList);*/


//        3. Using the Arrays.asList() method.
        /*String[] fruits = {"apple", "banana", "orange"};
        List<String> fruitList = Arrays.asList(fruits);

        System.out.println(fruitList);*/



//        4. Using the Stream.of() method.

        List<String> myList = Stream.of("Apple", "Banana", "Cherry", "Date").toList();

        System.out.println(myList);
    }
}
