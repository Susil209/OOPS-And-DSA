package com.java.Java8Features.StreamAPI.CodeSetupStudent;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainChallenge {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cg = new Course("CG", "Creating games in Java");

//        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pymc,jmc))
//                .limit(5000)
//                .toList();

        //or

//        List<Student> students = Stream.iterate(0,s -> s<=5000, s -> s+1)
//                .map(s -> Student.getRandomStudent(jmc,pymc))
//                .toList();

        //or

        List<Student> students = IntStream.rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

//        students.forEach(System.out::println);

        // average percentage completed for all students in java masterclass
        double totalPercent = students.stream()
                .map(s -> s.getPercentComplete("JMC"))
                .reduce(0.0, Double::sum);

        System.out.println("Total = " + totalPercent);

        double averagePercent = totalPercent / students.size();
        System.out.printf("Average percent =  %.2f%% %n", averagePercent);

        // multiplying it by 1.25 to get collection of students(list or set).
        // these are the students who completed three-quarter  of the avg percentage.

        int topPercent = (int) (1.25 * averagePercent);
        System.out.printf("TopPercent = %d%% %n", topPercent);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .toList();

        System.out.println("hard workers = " + hardWorkers.size());


        // sort the longest enrolled students who are still active, as you are going to
        // offer new course demo to 10 of these
        Comparator<Student> longestEnrolled = Comparator.comparing(Student::getYearEnrolled);

        List<Student> addNewCourse = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longestEnrolled)
                .limit(10)
                .toList(); // this is immutable

        // add new course
        addNewCourse.forEach(s -> {
            s.addCourse(cg);
            System.out.print(s.getStudentId() + " ");
        });

        System.out.println();

        // we can take Collectors.toList method if we want to  make a modifiable list
        // the same code can be written as

        Comparator<Student> uniqueStudent = longestEnrolled.thenComparing(Student::getStudentId);
        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0)
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longestEnrolled)
                .limit(10)
//                .collect(Collectors.toList()) // this is mutable
//                .collect(Collectors.toSet())
                .collect(() -> new TreeSet<>(uniqueStudent), TreeSet::add, TreeSet::addAll)
                .forEach(s -> {
                    s.addCourse(cg);
                    System.out.print(s.getStudentId() + " ");
                });

        // Note: in the tree set as a comparator we need unique elements after sorting by year of enroll in line84


    }
}
