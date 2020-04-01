package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChatTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void goAndGet() throws IOException {
        String[] answersOfUser = {"юзерпривет", "стоп", "юзерда", "продолжить", "закончить"};
        String source = "./src/main/resources/answers_for_chat.txt";
        File destination = folder.newFile("chatlog.txt");
        new Chat(new StubInput(answersOfUser), source, destination.getAbsolutePath()).go();
        try (BufferedReader in = new BufferedReader(new FileReader(destination))){
            List<String> list = in.lines().collect(Collectors.toList());
            assertThat(list.get(0), is("юзерпривет"));
            assertTrue(list.get(1).length() > 0);
            assertThat(list.get(2), is("стоп"));
            assertThat(list.get(3), is("юзерда"));
            assertThat(list.get(4), is("продолжить"));
            assertTrue(list.get(5).length() > 0);
            assertThat(list.get(6), is("закончить"));
            assertThat(list.size(), is(7));
        }

    }
}
