package ru.job4j.other.lyambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function= new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        Diapason function= new Diapason();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x,2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFunctionThenLinearResults() {
        Diapason function= new Diapason();
        List<Double> result = function.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(Math.log(5), Math.log(6), Math.log(7));
        assertThat(result, is(expected));
    }
}