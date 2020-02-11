package ru.job4j.collection.pro.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        Iterator<Integer> it = simpleSet.iterator();
        assertThat(it.next(), is(1));
    }

    @Test
    public void addDublicate() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator<Integer> it = simpleSet.iterator();
        it.next();
        assertNull(it.next());
    }
}