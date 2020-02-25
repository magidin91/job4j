package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    /**
     * Правило TemporaryFolder позволяет создавать файлы и папки,
     * которые гарантированно будут удалены после завершения метода тестирования (независимо от того, пройден он или нет)
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void check() {
        String target = "./data/unavailable.csv";
        new Analizy().unavailable("./data/server.log", target);
        try (BufferedReader read = new BufferedReader(new FileReader(target))
        ) {
            assertThat(read.readLine(), is("10:57:01;10:59:01"));
            assertThat(read.readLine(), is("11:01:02;11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Тест с использованием каталога временных файлов.
     * После запуска теста файлы созданные через правило TemporaryFolder будут удалены.
     */
    @Test
    public void checkUseTemporaryFolder() throws IOException {
        File source = folder.newFile("source.txt"); //создаем временные файлы
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("300 10:57:01");
            out.println();
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:00:02");
            out.println("400 11:01:02");
            out.println("200 11:02:02");
        }
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath()); //вызываем метод, получая
        // путь до временных файлов
        try (BufferedReader read = new BufferedReader(new FileReader(target)) //читаем из целевого временного файла
        ) {
            assertThat(read.readLine(), is("10:58:01;10:59:01"));
            assertThat(read.readLine(), is("11:00:02;11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}