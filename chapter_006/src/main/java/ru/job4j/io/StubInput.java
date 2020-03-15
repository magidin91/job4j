package ru.job4j.io;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String getQuestion() {
        return answers[position++];
    }
}