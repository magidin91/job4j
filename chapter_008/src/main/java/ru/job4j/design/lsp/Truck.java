package ru.job4j.design.lsp;

import org.jetbrains.annotations.NotNull;

public abstract class Truck implements Auto {
    private final int size;
    private String numberPlate;

    public Truck(int size, @NotNull String numberPlate) {
        this.size = size;
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
