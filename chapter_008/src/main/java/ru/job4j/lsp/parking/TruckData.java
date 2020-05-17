package ru.job4j.lsp.parking;

import org.jetbrains.annotations.NotNull;

public class TruckData implements Auto {
    private final int size;
    private String numberPlate;

    public TruckData(int size, @NotNull String numberPlate) {
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
