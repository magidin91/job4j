package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void add() {
        Counter one = new Counter();
        int result = one.add(1, 4);
        assertThat(result, is(6));
    }
}
