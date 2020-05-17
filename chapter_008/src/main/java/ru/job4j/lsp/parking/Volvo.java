package ru.job4j.lsp.parking;

public class Volvo implements Auto {
    private final Auto autoData;

    public Volvo(Auto autoData) {
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
