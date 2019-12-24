package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {
    @Test
    public void whenFirstMax() {
        int result = SqMax.max(4, 3, 2,1);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(3, 4, 2,1);
        assertThat(result, is(4));
    }

    @Test
    public void whenThirdMax() {
        int result = SqMax.max(2, 3, 4,1);
        assertThat(result, is(4));
    }
    @Test
    public void whenFortgMax() {
        int result = SqMax.max(1, 3, 2,4);
        assertThat(result, is(4));
    }
}
