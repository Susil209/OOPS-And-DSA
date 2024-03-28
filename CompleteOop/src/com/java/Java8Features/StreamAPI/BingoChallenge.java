package com.java.Java8Features.StreamAPI;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BingoChallenge {

    private static int counter = 0;

    public static void main(String[] args) {

        int start = 1;
        // iterate
        var Bstream = Stream.iterate(start, n -> n <= 15, n -> n + 1)
                .map(i -> "B-" + i);

//        Bstream.forEach(s -> System.out.print(s + " "));

        System.out.println();
        start += 15;
        // iterate
        var Istream = Stream.iterate(start, n -> n + 1)
                .limit(15)
                .map(i -> "I-" + i);

//        Istream.forEach(s -> System.out.print(s + " "));
        // range
//        var Istream = IntStream.range(16,31)
//                .mapToObj(i -> "I-"+i);
//
//        Istream.forEach(s -> System.out.print(s+ " "));

        System.out.println();

        // using Array
        start += 15;
        int newStart = start;
        String[] num = new String[15];

        Arrays.setAll(num, n -> "N-" + (n + newStart));

        //or

//        for (int i = 0; i < 15 ; i++) {
//            num[i] = "N-"+(i+start);
//        }

        //System.out.println(Arrays.toString(num));
        var Nstream = Arrays.stream(num);
//        Nstream.forEach(s -> System.out.print(s + " "));

        System.out.println();
        start += 15;

        //using Stream.of
        var Gstream = Stream.of("G-46", "G-47", "G-48", "G-49", "G-50", "G-51", "G-52", "G-53", "G-54", "G-55", "G-56", "G-57", "G-58", "G-59", "G-60");

//        Gstream.forEach(s -> System.out.print(s+" "));

        System.out.println();
        start += 15;
        int oStart = start;
        // using generate
        var Ostream = Stream.generate(BingoChallenge::getCounter)
                .limit(15)
                .map(i -> "O-" + (i + oStart));

//        Ostream.forEach(s -> System.out.print(s+" "));

        var concat1 = Stream.concat(Bstream, Istream);
        var concat2 = Stream.concat(Nstream, Gstream);
        var concat3 = Stream.concat(concat1,concat2);
        var finalConcat = Stream.concat(concat3,Ostream);

        finalConcat.forEach(System.out::println);


    }

    private static int getCounter() {
        return counter++;
    }
}
