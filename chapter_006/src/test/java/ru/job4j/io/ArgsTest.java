package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.Assert.assertTrue;

public class ArgsTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * Создаем архив, исключаем txt,  проверяем имена файлов в нём
     */
    @Ignore
    @Test
    public void checkZip() throws IOException {
        File fileZip = folder.newFile("archive.zip");
        System.out.println(fileZip.getAbsolutePath() + "\\");
        Args packer = new Args("-d", ".\\src\\main\\java\\ru\\job4j", "-e", "*.txt", "-o",
                fileZip.getAbsolutePath());
        packer.split();
        Zip zip = new Zip();
        System.out.println(packer.directory + " " + packer.exeptions + " " + packer.output);
        zip.pack(zip.seekBy(packer.directory, packer.exeptions), new File(packer.output));
        List<String> fileNames = new ArrayList<>();
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(fileZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                fileNames.add(name);
                System.out.printf("File name: %s \n", name);
                zin.closeEntry();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertTrue(fileNames.containsAll(List.of("io\\Abuse.java", "io\\Analizy.java", "io\\Args.java",
                "io\\Config.java", "io\\Search.java", "io\\Zip.java",
                "socket\\ClientOracle.java", "socket\\ServerOracle.java")));
    }
}

