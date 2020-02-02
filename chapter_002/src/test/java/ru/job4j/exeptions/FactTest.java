package ru.job4j.exeptions;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenLess1() {
        new Fact().calc(-1);
    }

}