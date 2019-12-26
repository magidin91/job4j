package ru.job4j.converter;


public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int in = 140;
        int expected = 2;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);

        int in2 = 120;
        int expected2 = 2;
        int out2 = rubleToDollar(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("120 rubles are 2. Test result : " + passed2);

        int in3 = 2;
        int expected3 = 140;
        int out3 = euroToRuble(in3);
        boolean passed3 = expected3 == out3;
        System.out.println("2 euro are 140. Test result : " + passed3);

        int in4 = 2;
        int expected4 = 120;
        int out4 = dollarToRuble(in4);
        boolean passed4 = expected4 == out4;
        System.out.println("2 dollars are 120. Test result : " + passed4);
    }
}



