package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Chat {
    private static final String STOP = "стоп";
    private static final String EXIT = "закончить";
    private static final String CONTINUE = "продолжить";
    private final String pathChatAnswers;
    private final String pathChatLog;
    private Input source;

    public Chat(Input input, String pathChatAnswers, String pathChatLog) {
        this.source = input;
        this.pathChatAnswers = pathChatAnswers;
        this.pathChatLog = pathChatLog;
    }

    public void go() {
        try (PrintWriter out = new PrintWriter(new File(pathChatLog));
             BufferedReader in = new BufferedReader(new FileReader(pathChatAnswers))) {

            String input;
            boolean check = true;
            Random random = new Random();
            List<String> answers = in.lines().collect(Collectors.toList());
            int size = answers.size();

            System.out.println("Привет, это консольный чат, введи своё сообщение");
            while (!EXIT.equals((input = source.getQuestion()))) {
                out.println(input);

                if (STOP.equals(input)) {
                    check = false;
                }
                if (CONTINUE.equals(input)) {
                    check = true;
                }
                if (check) {
                    String answer = answers.get(random.nextInt(size));
                    System.out.println(answer);
                    out.println(answer);
                }
            }
            out.println(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
