package com.java.Java8Features.PredefinedFI.Consumer;

import java.util.function.Consumer;

public class ConsumerChaining {
    public static void main(String[] args) {

        Consumer<Movie> c1 = m -> System.out.println("Movie " + m.name + " is released.");
        Consumer<Movie> c2 = m -> System.out.println("Movie " + m.name + " is " + m.result);
        Consumer<Movie> c3 = m -> System.out.println("Movie " + m.name + " is stored in db.");

        c1.andThen(c2).andThen(c3).accept(new Movie("Bahubali", "ATBB"));

    }

    static class Movie {
        String name;
        String result;

        public Movie(String name, String result) {
            this.name = name;
            this.result = result;
        }
    }
}
