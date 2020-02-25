package ru.job4j.io;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    File file6;

    @Before
    public void creatFolderStructure() throws IOException {
        File folder1 = folder.newFolder("Folder1");
        file1 = folder.newFile("1.txt");
        file2 = new File(folder1.getAbsolutePath(), "2.txt");
        file2.createNewFile();
        file3 = new File(folder1.getAbsolutePath(), "3.txt");
        file3.createNewFile();
        file4 = new File(folder1.getAbsolutePath(), "1.rtf");
        file4.createNewFile();
        File folder2 = new File(folder1.getAbsolutePath(), "Folder2");
        folder2.mkdir();
        file5 = new File(folder2.getAbsolutePath(), "4.txt");
        file5.createNewFile();
        file6 = new File(folder2.getAbsolutePath(), "2.rtf");
        file6.createNewFile();
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Ignore
    @Test
    public void searchTxt() throws IOException {
        List<String> exts = new ArrayList<>();
        exts.add("txt");
        List<File> files = List.of(file1, file2, file3, file5);
        assertTrue(new Search().files(folder.getRoot().getAbsolutePath(), exts).containsAll(files));
    }

    @Ignore
    @Test
    public void searchRtf() throws IOException {
        List<String> exts = new ArrayList<>();
        exts.add("rtf");
        List<File> files = List.of(file4, file6);
        assertTrue(new Search().files(folder.getRoot().getAbsolutePath(), exts).containsAll(files));
    }

    @Test
    public void searchRtfAndTxt() throws IOException {
        List<String> exts = new ArrayList<>();
        exts.add("rtf");
        exts.add("txt");
        List<File> files = List.of(file1, file4, file2, file3, file6, file5);
        new Search().files(folder.getRoot().getAbsolutePath(), exts);
        assertTrue(new Search().files(folder.getRoot().getAbsolutePath(), exts).containsAll(files));
    }
}