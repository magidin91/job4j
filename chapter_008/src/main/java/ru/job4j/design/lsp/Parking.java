package ru.job4j.design.lsp;

public class Parking {
    int carPlaces;
    int truckPlaces;

    public Parking(int carPlace, int truckPlace) {
        this.carPlaces = carPlace;
        this.truckPlaces = truckPlace;
    }

    public boolean place(Auto auto) {
        return true;
    }

    public void remove(Auto auto) {

    }
}
