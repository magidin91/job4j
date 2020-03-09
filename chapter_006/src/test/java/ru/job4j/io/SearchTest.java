package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

public class SearchTest {
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    File file6;
    File file7;

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
        file7 = new File(folder2.getAbsolutePath(), "1.png");
        file7.createNewFile();
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void searchTxt() {
        Predicate<File> predicate = file -> file.getName().endsWith("txt");
        List<File> files = List.of(file1, file2, file3, file5);
        assertTrue(new Search().files(folder.getRoot().getAbsolutePath(), predicate).containsAll(files));
    }

    @Test
    public void searchRtf() {
        Predicate<File> predicate = file -> file.getName().endsWith("rtf");
        List<File> files = List.of(file4, file6);
        assertTrue(new Search().files(folder.getRoot().getAbsolutePath(), predicate).containsAll(files));
    }

    @Test
    public void searchAllFiles() {
        Predicate<File> predicate = File::isFile;
        List<File> files = List.of(file1, file2, file3, file4, file5, file6, file7);
        assertTrue(new Search().files(folder.getRoot().getAbsolutePath(), predicate).containsAll(files));
    }

    @Test
    public void searchRtfAndTxt() {
        List<File> files = List.of(file1, file2, file3, file4, file5, file6);
        List<String> exts = List.of("rtf", "txt");
        Search search = new Search();
        assertTrue(search.files(folder.getRoot().getAbsolutePath(),
                search.getPredicateWithList(exts)).containsAll(files));
    }
}