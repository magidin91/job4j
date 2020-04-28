package ru.job4j.design.lsp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void carPlaceExist() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        assertTrue(parking.place(car));
    }

    @Test
    public void truckPlaceExist() {
        IParking parking = new Parking(2, 1);
        Auto truck = new Volvo(new TruckData(2, "BB111B"));
        assertTrue(parking.place(truck));
    }

    @Test
    public void carPlaceEnoughForTruck() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        Auto truck = new Volvo(new TruckData(2, "BB111B"));
        parking.place(car);
        assertTrue(parking.place(truck));
    }

    @Test
    public void carPlaceNotExist() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        parking.place(car);
        parking.place(car);
        assertFalse(parking.place(car));
    }

    @Test
    public void truckPlaceNotExist() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        Auto truck = new Volvo(new TruckData(2, "BB111B"));
        parking.place(truck);
        parking.place(car);
        assertFalse(parking.place(truck));
    }

    @Test
    public void autoExistAndRemove() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        parking.place(car);
        assertTrue(parking.remove(car));
    }

    @Test
    public void autoNotExistAndNotRemove() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        assertFalse(parking.remove(car));
    }

    @Test
    public void carRemoveAndParking() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        parking.place(car);
        parking.place(car);
        parking.remove(car);
        assertTrue(parking.place(car));
    }

    @Test
    public void truckRemoveAndParking() {
        IParking parking = new Parking(2, 1);
        Auto car = new Audi(new CarData("AA123A"));
        Auto truck = new Volvo(new TruckData(2, "BB111B"));
        parking.place(truck);
        parking.place(car);
        parking.remove(truck);
        assertTrue(parking.place(truck));
    }
}