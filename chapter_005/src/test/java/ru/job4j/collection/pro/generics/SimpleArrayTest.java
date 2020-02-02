package ru.job4j.collection.pro.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void remove() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(2);
        assertNull(array.get(2));
    }

    @Test
    public void iterator() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        Iterator<Integer> it = array.iterator();
        it.hasNext();
        it.next();
        assertThat(it.next(), is(2));
    }
}