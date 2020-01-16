package ru.job4j.collection.stream.api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void distribute10C() {
        List<Student> rsl = new School().collect(
                Arrays.asList(new Student(10), new Student(60), new Student(80)),
                student -> student.getScore() < 50);
        List<Student> exp = Arrays.asList(new Student(10));
        assertThat(rsl, is(exp));
    }

    @Test
    public void distribute10B() {
        List<Student> rsl = new School().collect(
                Arrays.asList(new Student(10), new Student(60), new Student(80)),
                student -> student.getScore() >= 50 && student.getScore() <= 70);
        List<Student> exp = Arrays.asList(new Student(60));
        assertThat(rsl, is(exp));
    }

    @Test
    public void distribute10A() {
        List<Student> rsl = new School().collect(
                Arrays.asList(new Student(10), new Student(60), new Student(80)),
                student -> student.getScore() > 70);
        List<Student> exp = Arrays.asList(new Student(80));
        assertThat(rsl, is(exp));
    }
}