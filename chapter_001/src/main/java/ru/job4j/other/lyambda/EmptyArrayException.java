package ru.job4j.other.lyambda;

class EmptyArrayException extends Exception {
    EmptyArrayException() {
        super("Maccив пуст");
    }

    static void addZZZ() {
        System.out.println("yes");
    }

    public static void main(String[] args) {
        EmptyArrayException a = new EmptyArrayException();


    }
}