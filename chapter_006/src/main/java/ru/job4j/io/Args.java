package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Args {
    private String[] args;
    public String directory;
    public List<String> exeptions = new ArrayList<>();
    public String output;
    private boolean checkDirectory = true;
    private boolean checkExeptions = true;
    private boolean checkOutput = true;

    public Args(String... args) {
        this.args = args;
    }

    /**
     * Создаем архив в соответствие заданными аргументами
     */
    public static void main(String[] args) {
        Args packer = new Args(args);
        packer.split();
        Zip zip = new Zip();
        System.out.println(packer.directory + " " + packer.exeptions + " " + packer.output);
        zip.pack(zip.seekBy(packer.directory, packer.exeptions), new File(packer.output));
    }

    /**
     * Метод присваивает полям значения дирктории, исключений и пути к зипу исходя из переданных аргументов в методе main
     */
    public void split() {
        for (int index = 0; index < args.length; index++) {
            String arg = args[index];
            if (arg.matches("-\\w")) {
                if (checkDirectory && "-d".equals(arg)) {
                    this.directory = args[++index];
                    checkDirectory = false;
                } else if (checkExeptions && "-e".equals(arg)) {
                    while (++index < args.length && args[index].startsWith("*")) {
                        this.exeptions.add(args[index].substring(1));
                    }
                    index--;
                    checkExeptions = false;
                } else if (checkOutput && "-o".equals(arg)) {
                    this.output = args[++index];
                    checkOutput = false;
                }
            }
        }
    }
}