package ru.job4j.design.lsp;

public class Audi implements Auto {
    private final Auto autoData;

    public Audi(Auto autoData) {
        this.autoData = autoData;
    }

    public int getSize() {
        return autoData.getSize();
    }

    public String getNumberPlate() {

        return autoData.getNumberPlate();
    }

    public void setNumberPlate(String numberPlate) {
        this.autoData.setNumberPlate(numberPlate);
    }
}
