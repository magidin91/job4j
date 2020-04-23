package ru.job4j.design.lsp;

/**
 * Provides Parking of autos
 */
public interface IParking {
    /**
     * Method returns true if place for this auto is enough
     */
    boolean place(Auto auto);

    /**
     * Method returns true if there is this auto in this Parking
     */
    boolean remove(Auto auto);
}
