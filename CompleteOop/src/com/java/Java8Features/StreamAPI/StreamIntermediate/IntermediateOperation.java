package com.java.Java8Features.StreamAPI.StreamIntermediate;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperation {
    public static void main(String[] args) {

        // A = 63, z = 122

        IntStream.iterate('A', i -> i <= (int) 'z', i -> i + 1) // it takes symbols + alphabets
                .filter(Character::isAlphabetic) // take only alphabets
                .skip(5) // skip first 5
                .distinct() // no duplicates
                .forEach(s -> System.out.printf("%c ", s));

        System.out.println();
        // get seat marker and price
        int maxSeats = 100;
        int seatInRow = 10;

        var stream =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) ('A' + i / seatInRow),
                                i % seatInRow + 1))
                        .skip(5)
                        .limit(10)
                        .peek(s -> System.out.println("-->"+s))
                        .sorted(Comparator.comparing(Seat::price)
                                .thenComparing(Seat::toString));

//                        .mapToDouble(Seat::price)
//                        .mapToObj("%.2f"::formatted);
        //or
//                        .boxed()
//                        .map("%2f"::formatted);

        stream.forEach(System.out::println);

        // note: for mapping from primitive stream(DoubleStream) to
        // reference stream (Stream<Double>) we can use
        // mapToObj() or boxed()
    }
}
