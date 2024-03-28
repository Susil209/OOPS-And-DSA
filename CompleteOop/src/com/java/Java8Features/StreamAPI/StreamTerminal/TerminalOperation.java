package com.java.Java8Features.StreamAPI.StreamTerminal;

import com.java.introduction.A;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TerminalOperation {
    public static void main(String[] args) {
        var summary =
                IntStream.iterate(0, i -> i <= 1000, i -> i + 10)
                        .summaryStatistics();

        System.out.println("Result = " + summary);

        var leapYearSummary = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();

        System.out.println("Leap year data = " + leapYearSummary);

        Seat[] seat = new Seat[100];
        Arrays.setAll(seat, i -> new Seat((char) ('A' + i / 10),i % 10 + 1));
//        Arrays.asList(seat).forEach(System.out::println);

        long reservationCount = Arrays.stream(seat)
                .filter(Seat::isReserved)
                .count();
        System.out.println("Reservation count = "+reservationCount);

        boolean hasBooking = Arrays.stream(seat)
                .anyMatch(Seat::isReserved);
        System.out.println("hasBooking = "+ hasBooking);

        boolean fullyBooked = Arrays.stream(seat)
                .allMatch(Seat::isReserved);
        System.out.println("fullyBooked = "+ fullyBooked);

        boolean eventWashedOut = Arrays.stream(seat)
                .noneMatch(Seat::isReserved);
        System.out.println("eventWashedOut = "+ eventWashedOut);


    }
}
