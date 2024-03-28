package com.java.Java8Features.PredefinedFI.Consumer;

//display movie information

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

class Movie{
    String name;
    String hero;
    String heroin;

    public Movie(String name, String hero, String heroin) {
        this.name = name;
        this.hero = hero;
        this.heroin = heroin;
    }

}


public class ConsumerEx1 {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<>();
        populate(list);

        Consumer<Movie> movieInfo = m -> {
            System.out.println("Movie name: " +m.name);
            System.out.println("Hero name: "+ m.hero);
            System.out.println("Heroin name: "+m.heroin);
            System.out.println("-----------------------");
            System.out.println();
        };

        for (Movie m:
             list) {
            movieInfo.accept(m);
        }

    }


    static void populate(ArrayList<Movie> l) {
        l.add(new Movie("Pathan","SRK","Deepika"));
        l.add(new Movie("Jawan","SRK","Nayantaraa"));
        l.add(new Movie("RRR","NTR Jr","Alia"));
        l.add(new Movie("Lagaan","Amir","Pushapa"));
        l.add(new Movie("3 Idiots","Amir","Kareena"));
    }
}
