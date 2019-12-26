package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void calc() {
        Factorial one = new Factorial();
        int result = one.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void calcZero() {
        Factorial one = new Factorial();
        int result = one.calc(0);
        assertThat(result, is(1));
    }
}
