package ru.job4j.collection.pro.list;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteFirst() {
        list.delete();
        assertThat(list.get(0), is(2));
    }

    @Test
    public void whenDeleteFirstSizeDecrease() {
        list.delete();
        assertThat(list.getSize(), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenSize0DeleteFirst() {
        list = new SimpleArrayList<>();
        list.delete();
    }

    @Test
    public void next3Times() {
        Iterator<Integer> it = list.iterator();
        it.next();
        it.next();
        assertThat(it.next(), is(1));
    }

    @Test
    public void hasNext() {
        Iterator<Integer> it = list.iterator();
        it.hasNext();
        it.next();
        it.next();
        assertTrue(it.hasNext());
    }
}