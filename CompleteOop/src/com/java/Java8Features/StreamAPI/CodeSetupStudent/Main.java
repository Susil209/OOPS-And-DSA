package com.java.Java8Features.StreamAPI.CodeSetupStudent;

import com.java.Java8Features.PredefinedFI.Predicate.PredicateEx1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

//        Student tim = new Student("AU", 2019, 30, "M",
//                true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        //generating 10 random students
//        var Students = Stream.generate(() -> Student.getRandomStudent(jmc,pymc))
//                .limit(10);
////                .forEach(System.out::println);
//
//        Students.forEach(System.out::println);

        // No of male and female students

        // create an array of Student
        Student[] students = new Student[100];
        Arrays.setAll(students, s -> Student.getRandomStudent(jmc, pymc));

        var maleStudents = Arrays.stream(students)
                .filter(s -> s.getGender().equals("M")).count();

        // this creates the random set of student each time differently
//        var maleStudents = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
//                .limit(100)
//                .filter(s -> s.getGender().equals("M"))
//                .count();

        System.out.println("No of male students = " + maleStudents);
        var femaleStudents = 100 - maleStudents;
        System.out.println("No of female students = " + femaleStudents);


        // Using list of

        for (String gender : List.of("M", "F", "U")) {
            var myStudents = Arrays.stream(students)
                    .filter(s -> s.getGender().equals(gender));
            System.out.println("No of " + gender + " students = " + myStudents.count());
        }

        // no of students whose ages <30 ,  between 30 and 60, over 60

//        var ageLessThan30 = Arrays.stream(students)
//                .filter(s -> s.getAge() < 30);
//        System.out.println("No of students age less than 30 = "+ageLessThan30.count());

        List<Predicate<Student>> list = List.of(s -> s.getAge() < 30, s -> s.getAge() >= 30 && s.getAge() < 60);

        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            var myStudents = Arrays.stream(students).filter(list.get(i));
            long cnt = myStudents.count();
            total += cnt;
            System.out.printf("No of students (%s) = %d%n", i == 0 ? " <30 " : " >=30 and < 60 ", cnt);
        }

        System.out.println("No of students >=60  = " + (students.length - total));

        // use summaryStatistics on students age
        var ageStream = Arrays.stream(students).mapToInt(Student::getAgeEnrolled);
        System.out.println("Stats for enrolled age = " + ageStream.summaryStatistics());

        var currentAgeStream = Arrays.stream(students).mapToInt(Student::getAge);
        System.out.println("Stats for current enrolled age = " + currentAgeStream.summaryStatistics());

        //what countries are students from? print distinct list
        var countryStream = Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct();
        countryStream.forEach(s -> System.out.println("Country code = " + s));

        //Are there students still active , that have enrolled more than 7 years?
        System.out.println();
        boolean longTerm = Arrays.stream(students)
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12));

        System.out.println("long term students ? " + longTerm);

        long longTermStudents = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .count();

        System.out.println("no of long term students ? " + longTermStudents);

        //select 5 students from above and print their information
        Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .forEach(System.out::println);

        System.out.println();
        // reduction operations
        // toList() - return type List<T> immutable list

        List<Student> longTimeLearners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toList();

        longTimeLearners.forEach(System.out::println);

        // toArray()
        var longTimeLearnersArray = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toArray();

        var longTimeLearnersStudentArray = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toArray(Student[]::new);

        //collect()
        var Learners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) && (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList());

        Collections.shuffle(Learners);

        // Note: There is difference between Stream.toList() and Stream.collect(Collectors.toList())
        // we can do mutable reduction operation using collect() method.


    }
}
