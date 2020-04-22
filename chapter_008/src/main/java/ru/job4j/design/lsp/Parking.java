package ru.job4j.design.lsp;

public class Parking implements IParking {

    public boolean place(Auto auto) {
        return true;
    }

    public boolean remove(Auto auto) {
        return true;
    }
}
