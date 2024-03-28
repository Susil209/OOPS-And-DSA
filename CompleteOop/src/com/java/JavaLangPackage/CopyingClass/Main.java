package com.java.JavaLangPackage.CopyingClass;

import java.util.Arrays;

record Person(String name, String dob, Person[] kids) {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", kids=" + Arrays.toString(kids) +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Person joe = new Person("Joe", "01/01/1990", null);
        Person james = new Person("James", "03/02/1993", null);
        Person john = new Person("John", "10/08/1964",
                new Person[]{joe, james});
        Person jerry = new Person("Jerry", "01/07/1996", null);
        Person jane = new Person("Jane", "19/10/1970",
                new Person[]{james, jerry});


        Person[] persons = {joe, james, john,jerry,jane};

        // deep copy
        Person[] personsCopy = new Person[5];

        for (int i = 0; i < persons.length; i++) {
            Person current = persons[i];
            var kids = current.kids();
            personsCopy[i] = new Person(current.name(), current.dob(), current.kids());
        }

        System.out.println(persons[4]); // kids = james,Jerry
        System.out.println(personsCopy[4]); // kids = james, jerry

        var janeKids = personsCopy[4].kids();
        janeKids[1] = joe;

        // Here we can see in both cases (original and copy) there is change.
        //
        System.out.println("-----------------------------");
        System.out.println(persons[4]); // kids = James, Joe
        System.out.println(personsCopy[4]); // kids = James, Joe


        // shallow copy
        /*
        Person[] personsCopy = Arrays.copyOf(persons, persons.length);

        // due to shallow cpy both array fields point to same reference
        for (int i = 0; i < persons.length; i++) {
            // to check references
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal references" + persons[i]);
            }
        }


        var janeKids = personsCopy[4].kids();
        janeKids[1] = joe;
        // the shallow copy the reference from original array
        // so there will be a change. This is the side effect of mutable array.

        System.out.println("-------------------------------");
        for (int i = 0; i < persons.length; i++) {
            // to check references
            if (persons[i] == personsCopy[i]) {
                System.out.println("Equal references" + persons[i]);
            }
        }

         */
    }
}
