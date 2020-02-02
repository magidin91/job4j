package ru.job4j.exeptions;

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(-1);
    }

    public int calc(int n) {
        int rsl = 1;
        if (n < 1) {
            throw new IllegalArgumentException("Параметр факториала должен быть больше нуля");
        }
        for (int index = 1; index != n; index++) {
            rsl += index;
        }
        return rsl;
    }
}