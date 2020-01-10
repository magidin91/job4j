package ru.job4j.ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Пример использования нескольких блоков catch
 */
public class MultiCatch {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));

            System.out.println(366 / 0);
            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {

            System.out.println("Ошибка! Файл не найден!");

        } catch (ArithmeticException e) {

            System.out.println("Ошибка! Деление на 0!");

        }
    }
}
