package ru.job4j.exeptions;

public class Division {
    public static void main(String[] args) {
        try {
            System.out.println("Делим число на ноль");
            System.out.println(366 / 0); //в этой строчке кода будет выброшено исключение

            System.out.println("Этот");
            System.out.println("код");
            System.out.println("не");
            System.out.println("будет");
            System.out.println("выполнен!");

        } catch (ArithmeticException e) {
            System.out.println("Программа перепрыгнула в блок catch!");
            System.out.println("Ошибка! Нельзя делить на ноль!");
            e.printStackTrace();

        }
    }
}
