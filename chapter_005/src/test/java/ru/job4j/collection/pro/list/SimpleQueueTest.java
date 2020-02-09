package ru.job4j.collection.pro.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    @Test
    public void pushAndPoll() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
    }

    @Test
    public void push1AndPoll1() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        assertThat(simpleQueue.poll(), is(1));
    }

    @Test
    public void pushAndPollAndPushAndPoll() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        simpleQueue.poll();
        simpleQueue.push(4);
        simpleQueue.push(5);
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.poll(), is(4));
        assertThat(simpleQueue.poll(), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void poll0Size() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.poll();
    }
}