package ru.job4j.io;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Eleven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 11;
        while (number > 0) {
            System.out.println("Игрок, возьмите спички");
            int select = Integer.valueOf(input.nextLine());
            if (select >= 1 && select <= 3) {
                System.out.println("Игрок игрок взял " + select + " спичек");
                number = number - select;
            } else {
                System.out.println("Возьмите 1,2 или 3 спички!!!");
            }
        }
        System.out.println("Игра окончена, вы победитель!");
    }
}
