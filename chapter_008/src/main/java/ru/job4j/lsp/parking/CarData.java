package ru.job4j.lsp.parking;

import org.jetbrains.annotations.NotNull;

public class CarData implements Auto {
    private String numberPlate;

    public CarData(@NotNull String numberPlate) {
        this.numberPlate = numberPlate;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
