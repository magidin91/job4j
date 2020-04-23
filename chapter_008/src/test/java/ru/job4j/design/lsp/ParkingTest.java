package ru.job4j.design.lsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {
    private final IParking parking = new Parking(2, 1);
    private final Auto car = new Audi("AA123A");
    private final Auto truck = new Volvo(2, "BB111B");

    @Test
    public void carPlaceExist() {
        assertTrue(parking.place(car));
    }

    @Test
    public void truckPlaceExist() {
        assertTrue(parking.place(truck));
    }

    @Test
    public void carPlaceEnoughForTruck() {
        parking.place(car);
        assertTrue(parking.place(truck));
    }

    @Test
    public void carPlaceNotExist() {
        parking.place(car);
        parking.place(car);
        assertFalse(parking.place(car));
    }

    @Test
    public void truckPlaceNotExist() {
        parking.place(truck);
        parking.place(car);
        assertFalse(parking.place(truck));
    }

    @Test
    public void autoExistAndRemove() {
        parking.place(car);
        assertTrue(parking.remove(car));
    }

    @Test
    public void autoNotExistAndNotRemove() {
        assertFalse(parking.remove(car));
    }

    @Test
    public void carRemoveAndParking() {
        parking.place(car);
        parking.place(car);
        parking.remove(car);
        assertTrue(parking.place(car));
    }

    @Test
    public void truckRemoveAndParking() {
        parking.place(truck);
        parking.place(car);
        parking.remove(truck);
        assertTrue(parking.place(truck));
    }
}