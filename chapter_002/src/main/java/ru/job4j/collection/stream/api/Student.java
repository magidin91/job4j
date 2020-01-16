package ru.job4j.collection.stream.api;

import java.util.Objects;

public class Student {
    private int score;
    private String lastName;

    public int getScore() {
        return score;
    }

    public String getLastName() {
        return lastName;
    }

    public Student(int score) {
        if (score < 0 || score > 100) {
            score = 0;
        }
        this.score = score;
    }

    public Student(int score, String lastName) {
        if (score < 0 || score > 100) {
            score = 0;
        }
        if (lastName == null) {
            lastName = "Unknown";
        }
        this.score = score;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score &&
                lastName.equals(student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
