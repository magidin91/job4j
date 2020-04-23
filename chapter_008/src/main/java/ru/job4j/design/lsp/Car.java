package ru.job4j.design.lsp;

import org.jetbrains.annotations.NotNull;

public abstract class Car implements Auto {
    private final int size = 1;
    private String numberPlate;

    public Car(@NotNull String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
