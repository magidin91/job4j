package ru.job4j.design.isp;

import java.util.List;
import java.util.function.Supplier;

/**
 * It.s stub for test, it replaces console input.
 */
public class StubInput implements Supplier<String> {
    private final List<String> list;
    private int i = 0;

    public StubInput(List<String> list) {
        this.list = list;
    }

    public String get() {
        return list.get(i++);
    }
}
