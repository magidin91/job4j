package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String make() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n")
                .append("+  +\n")
                .append("+  +\n")
                .append("++++");
        return pic.toString();
    }
}
