package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }
    @Test
    public void whenMax2To1() {
        int result = Max.max(2, 1);
        assertThat(result, is(2));
    }
    @Test
    public void whenBothMax() {
        int result = Max.max(2, 2);
        assertThat(result, is(2));
    }
}