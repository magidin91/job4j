package ru.job4j.memory;

public class MemoryAnalysis {

    public void create(int number) {
        info();
        for (int i = 0; i < number; i++) {
            new User(String.valueOf(i), String.valueOf(2 * i), i);
        }
    }

    public void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println(String.format("usedMemory: %d", (runtime.totalMemory() - runtime.freeMemory()) / mb));
        System.out.println(String.format("freeMemory: %d", runtime.freeMemory() / mb));
        System.out.println(String.format("totalMemory: %d", runtime.totalMemory() / mb));
        System.out.println(String.format("maxMemory: %d", runtime.maxMemory() / mb));
    }

    public static void main(String[] args) {
        new MemoryAnalysis().create(10000);
    }
}
