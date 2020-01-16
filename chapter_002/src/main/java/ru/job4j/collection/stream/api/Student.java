package ru.job4j.collection.stream.api;

import java.util.Objects;

public class Student {
    private int score;

    public int getScore() {
        return score;
    }

    public Student(int score) {
        if (score < 0 || score > 100) {
            score = 0;
        }
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
