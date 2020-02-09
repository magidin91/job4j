package ru.job4j.collection.pro.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> array;

    @Before
    public void addElements() {
        array = new DynamicArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
    }

    @Test
    public void addAndGetMoreInitialLenghth() {
        array.add(11);
        assertThat(array.get(10), is(11));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void GetArrayIndexOutOfBoundsException() {
        array.get(100);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void IteratorModificationException() {
        Iterator<Integer> it = array.iterator();
        array.add(11);
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void NextNoSuchElementException() {
        Iterator<Integer> it = array.iterator();
        for (int i = 0; i != 11; i++) {
            it.next();
        }
    }
}