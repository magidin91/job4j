package ru.job4j.design.lsp;

import java.util.HashMap;

public class Parking implements IParking {
    private int carPlaces;
    private int truckPlaces;
    /**
     * Stores parked car and truck with numberPlate as a key
     */
    private final HashMap<String, Auto> carMap = new HashMap<>();
    /**
     * Stores parked truck with numberPlate as a key
     */
    private final HashMap<String, Auto> truckMap = new HashMap<>();

    public Parking(int carPlaces, int truckPlaces) {
        this.carPlaces = carPlaces;
        this.truckPlaces = truckPlaces;
    }

    public boolean place(Auto auto) {
        boolean rsl = false;
        int size = auto.getSize();
        if (size == 1) {
            rsl = placeCar(auto);
        } else if (size > 1) {
            rsl = placeTruck(auto, size);
        }
        return rsl;
    }

    private boolean placeCar(Auto auto) {
        boolean rsl = false;
        if (carPlaces > 0) {
            carPlaces--;
            carMap.put(auto.getNumberPlate(), auto);
            rsl = true;
        }
        return rsl;
    }

    private boolean placeTruck(Auto auto, int size) {
        boolean rsl = false;
        if (truckPlaces > 0) {
            truckPlaces--;
            truckMap.put(auto.getNumberPlate(), auto);
            rsl = true;
        } else if (carPlaces > size) {
            carPlaces = carPlaces - size;
            carMap.put(auto.getNumberPlate(), auto);
            rsl = true;
        }
        return rsl;
    }

    public boolean remove(Auto auto) {
        boolean rsl = false;
        if (carMap.remove(auto.getNumberPlate()) != null) {
            carPlaces = carPlaces + auto.getSize();
            rsl = true;
        } else if (truckMap.remove(auto.getNumberPlate()) != null) {
            truckPlaces = truckPlaces + auto.getSize();
            rsl = true;
        }
        return rsl;
    }
}
