package com.java.Java8Features.StreamAPI.CodeSetupStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainOptional {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        //generate List<Student>
        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(1000)
                .collect(Collectors.toList());

        // passing null
        Optional<Student> o1 = getStudent(null, "first");
        System.out.println("Empty = " + o1.isEmpty() + ", Present = " + o1.isPresent());
        System.out.println(o1);

        // get the element
//        if (o1.isPresent()){
//            System.out.println(o1.get());
//        }

        // or
        // if value is not present it will do nothing.
        o1.ifPresent(System.out::println);

        //If a value is present, performs the given action with the value, otherwise performs the given empty-based action.
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("---- Empty ---"));


        // passing empty list
        Optional<Student> o2 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty = " + o2.isEmpty() + ", Present = " + o2.isPresent());
        System.out.println(o2);


        //passing students list
        Optional<Student> o3 = getStudent(students, "first");
        System.out.println("Empty = " + o3.isEmpty() + ", Present = " + o3.isPresent());
        System.out.println(o3);

        System.out.println("--------------------------------------");

        // get the student id if present else return null

        // 1. get the student if present or return null
        //Student firstStudent = o3.isPresent() ? o3.get() : null;

        //or
        //Student firstStudent = o3.orElse(null); // Return the value if present, otherwise return other.
                                                      // other can be any default value

        // here the return type is another Student(dummy)
         //Student firstStudent = o3.orElse(getDummyStudent(jmc));

        // or
        // Return the value if present, otherwise invoke other and
        // return the result of that invocation.
        Student firstStudent = o3.orElseGet(() -> getDummyStudent(jmc));

        // 2. get the student id

        //long firstStudentId = (firstStudent == null) ? -1 : firstStudent.getStudentId();
        long firstStudentId = firstStudent.getStudentId();
        System.out.println("First Student id = "+firstStudentId);

        //add a null student and passing students list
//        students.add(0,null);
        Optional<Student> o4 = getStudent(students, "first");
        System.out.println("Empty = " + o4.isEmpty() + ", Present = " + o4.isPresent());
        System.out.println(o4);


        // List of countries
        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(",",l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(System.out::println, () -> System.out.println("Missing FR"));

    }

    private static Optional<Student> getStudent(List<Student> list, String type) {
        if (list == null || list.size() == 0) {
            return Optional.empty();
        } else if (type.equals("first")) {
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size() - 1));
        } else {
            return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
        }
    }

    private static Student getDummyStudent(Course... courses){
        System.out.println("Getting the dummy student");
        return new Student("IN",1,1,"M",true,courses);
    }
}
