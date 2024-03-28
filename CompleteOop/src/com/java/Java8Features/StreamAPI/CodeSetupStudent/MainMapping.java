package com.java.Java8Features.StreamAPI.CodeSetupStudent;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class MainMapping {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cg = new Course("CG", "Creating games in Java");

        List<Student> students = IntStream.rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        // groupingBy(Function classifier)
        var mappedStudent = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode));
        mappedStudent.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("----------------------------------");
        // groupingBy(Function classifier, Collector downstream)
        int minAge = 21;
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode, filtering(s -> s.getAge() <= minAge, toList())));

        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        //partitioningBy(Predicate predicate)
        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));

        System.out.println("Experienced students = " + experienced.get(true).size());

        // partitioningBy(Predicate, Collector downstream)
        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));

        System.out.println("Experienced students = " + expCount.get(true));

        var experiencedAnsActiveCount = students.stream()
                .collect(partitioningBy(s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0
                        , counting()));

        System.out.println("Experienced and active students = " + experiencedAnsActiveCount.get(true));

        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode, groupingBy(Student::getGender)));

        multiLevel.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println("\t" + k1 + " " + v1.size());
            });
        });

    }
}
