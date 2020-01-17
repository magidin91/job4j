package ru.job4j.collection.stream.api;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(50, "Ivanov"),
                new Student(60, "Petrov"), new Student(50, "Nikitin"));
        Map<String, Student> mapStudents = students.stream().distinct().collect(Collectors.toMap(Student::getLastName, student -> student));
        System.out.println(mapStudents);
    }

}
