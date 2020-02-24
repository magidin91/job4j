package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    private boolean check = false;

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))
        ) {
            read.lines().filter(line -> !line.isEmpty()).forEach(line -> printToFile(out, line));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет, с какого типа начинается строка, и печает в целевой файл диапазоны
     */
    private void printToFile(PrintWriter out, String line) {
        if ((line.startsWith("500") || line.startsWith("400")) && !check) {
            out.print(line.substring(4) + ";");
            check = true;
        } else if (check && (line.startsWith("200") || line.startsWith("300"))) {
            out.println(line.substring(4));
            check = false;
        }
    }
}