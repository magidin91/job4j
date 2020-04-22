package ru.job4j.design.lsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {
    private IParking parking = new Parking();
    private Auto auto = new Car();

    @Test
    public void placeExist() {
        assertTrue(parking.place(auto));
    }

    @Test
    public void placeNotExist() {
        assertFalse(parking.place(auto));
    }

    @Test
    public void autoExistAndRemove() {
        assertTrue(parking.remove(auto));
    }

    @Test
    public void autoNotExistAndNotRemove() {
        assertFalse(parking.remove(auto));
    }
}