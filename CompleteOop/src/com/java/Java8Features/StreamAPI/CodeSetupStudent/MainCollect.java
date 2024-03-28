package com.java.Java8Features.StreamAPI.CodeSetupStudent;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        //generate List<Student>
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(1000)
                .toList();

        // Set of australian students
        Set<Student> australianStudents = students.stream()
                .filter(s -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());

        System.out.println("No of australian students = " + australianStudents.size());

        // no of students age < 30
        Set<Student> underThirty = students.stream()
                .filter(s -> s.getAge() < 30)
                .collect(Collectors.toSet());

        System.out.println("No of students having age < 30 = " + underThirty.size());

        // get the ids of aussie students whose age < 30 in sorted order (asc)

        // without stream
        Set<Student> youngAussie1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussie1.addAll(australianStudents);
        youngAussie1.retainAll(underThirty);
        youngAussie1.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        //using stream
        Set<Student> youngAussie2 = students.stream()
                .filter(s -> s.getAge() < 30)
                .filter(s -> s.getCountryCode().equals("AU"))
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll);

        youngAussie2.forEach(s -> System.out.print(s.getStudentId() + " "));

        // Two variants of collect
        // .collect(Collector collector)
        // .collect(Supplier supplier,BiConsumer accumulator,BiConsumer combiner)

        System.out.println();
        // reduce
        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("Country list = " + countryList);


    }
}
