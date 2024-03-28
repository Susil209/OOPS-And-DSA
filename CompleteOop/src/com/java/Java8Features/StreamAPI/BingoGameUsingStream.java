package com.java.Java8Features.StreamAPI;

// BINGO game
/*
    There is a container of balls.
    Each ball is identified with B,I,N,G,O and followed by number.
    Ball B will have a number from 1 to 15, I will have 16 to 30 and so on.
    Someone will draw a ball from container and read the number.
    Every player will have five by five cards, with some randomly generated number.
    The first column has B numbers , second column has I number and so on.
    One win by first person to match numbers in row,column or diagonally.

example : BINGO card

        1  27 33 48 75
        8  19 45 56 61
        3  18 __ 49 69
        15 26 41 53 66
        2  21 37 46 65

 */


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BingoGameUsingStream {
    public static void main(String[] args) {
        // create a Collection of all 75 bingo numbers (B-15,I-15.N-15,G-15,O-15)

        List<String> bingoPool = new ArrayList<>(75);

        int start = 1;
        for (char c : "BINGO".toCharArray()) { //  c in {B,I,N,G,O}
            for (int i = start; i < (start + 15); i++) {
                bingoPool.add("" + c + i); // "" is added to convert int to string
//                System.out.println("" + c + i);
            }
            start += 15; // after every 15 iteration
        }

        //shuffle the pool and take first 15 from shuffled list
        Collections.shuffle(bingoPool);
        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-------------------------------------");

        // create a separate sublist of 15 elements
        List<String> firstOnes = new ArrayList<>(bingoPool.subList(0, 15)); // new copy needed to not modify the original list
        firstOnes.sort(Comparator.naturalOrder()); // sorting the sublist in DNSO

        // update the sorted list with char-number Ex: G-59, N-39
        firstOnes.replaceAll((s) -> {
            // update for G and O

            // if the string starts from G or O
            if (s.indexOf("G") == 0 || s.indexOf("O") == 0) {
                // updated = G + "-" + 79
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n-----------------------------------------");


        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-------------------------------------");

        // doing the exact operation by using stream
        bingoPool.stream() // convert list to stream
                .limit(15) // take 15 elements
                .filter(s -> s.indexOf("G") == 0 || s.indexOf("O") == 0) // do filter out only G and O
                .map(s -> s.charAt(0) + "-" + s.substring(1)) // update them by char - number
                .sorted()// Default natural sorting
                .forEach(s -> System.out.print(s + " ")); // print each item

        // or

        var tempStream = bingoPool.stream() // convert list to stream
                .limit(15) // take 15 elements
                .filter(s -> s.indexOf("G") == 0 || s.indexOf("O") == 0) // do filter out only G and O
                .map(s -> s.charAt(0) + "-" + s.substring(1)) // update them by char - number
                .sorted();// Default natural sorting

        tempStream.forEach(s -> System.out.println(s + " "));
        System.out.println("\n-----------------------------------------");

        // note that stream does not affect the original source(here list)

        // tempStream.forEach(s -> System.out.println(s.toLowerCase())); // you can't invoke a stream after once terminal operation invoked

        // Stream sources

        //1. From a Collection(List,Set,Map,Collection) via the stream() and parallelStream() methods;

        //2. Array of objects to stream
        String[] arr = {"One", "Two", "Three"};
        Arrays.stream(arr)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        //or

        var firstStream = Arrays.stream(arr)
                .sorted(Comparator.reverseOrder());


        //3. From static factory methods on the stream classes.
        //  Stream.of(Object[])
        Stream.of("Four", "Five", "Six")
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // or

        var secondStream = Stream.of("Four", "Five", "Six")
                .map(String::toUpperCase);

        System.out.println("\n--------------------------------------");
        // concat ()
        Stream.concat(secondStream, firstStream)
                .forEach(System.out::println);

        System.out.println("-----------------------------------");


        // Map to show each letter range
        Map<Character, int[]> myMap = new LinkedHashMap<>(); // preserve the order

        int bingoIndex = 1;
        for (Character c : "BINGO".toCharArray()) {
            int[] num = new int[15];
            int lebel = bingoIndex;
            Arrays.setAll(num, i -> i + lebel);
            myMap.put(c, num);
            bingoIndex += 15;
        }

        myMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " has range:" + e.getValue()[0] + " - "
                        + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        // Infinite stream

        // generate
        Random random = new Random();
        Stream.generate(() -> random.nextInt(10)).limit(10).forEach(s -> System.out.print(s + " "));

        System.out.println();
        // iterate
        IntStream.iterate(1, n -> n * 2)
                .limit(10)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("------------------------------------");
        // first 20 prime numbers
        System.out.println("first 20 prime numbers: ");
        IntStream.iterate(1, n -> n + 1)
                .filter(BingoGameUsingStream::isPrime) // we first get all primes from 1
                .limit(20) // set limit up to 20
                .forEach(s -> System.out.print(s + " "));

        System.out.println();

        // get primes under 100
        System.out.println("prime numbers under 100: ");
        IntStream.iterate(1, n -> n + 1)
                .limit(100) // we first set the limit under 100
                .filter(BingoGameUsingStream::isPrime) // then get the primes
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        //However iterate method overrides to have the finite value
        IntStream.iterate(1, n -> n < 100, n -> n + 1) // here the second parameter is Predicate
                .filter(BingoGameUsingStream::isPrime)
                .forEach(s -> System.out.print(s + " "));

        // range
        System.out.println();
        IntStream.range(1,100) // [include: 1,exclude: 100)
                .filter(BingoGameUsingStream::isPrime)
                .forEach(s -> System.out.print(s + " "));

        IntStream.rangeClosed(1,100) // [include: 1,include: 100]
                .filter(BingoGameUsingStream::isPrime)
                .forEach(s -> System.out.print(s + " "));
    }

    public static boolean isPrime(int number) {
        if (number <= 2) return number == 2;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
