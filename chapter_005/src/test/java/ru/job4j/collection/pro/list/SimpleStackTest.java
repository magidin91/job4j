package ru.job4j.collection.pro.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    @Test
    public void pushAndPoll() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void poll0Size() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.poll();
    }
}