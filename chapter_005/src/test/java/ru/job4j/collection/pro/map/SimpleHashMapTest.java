package ru.job4j.collection.pro.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {


    @Test
    public void insert2Equal2Get1() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("a", 100);
        simpleHashMap.insert("a", 200);
        assertThat(simpleHashMap.get("a"), is(100));
    }

    @Test
    public void insert2Get2() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("a", 100);
        simpleHashMap.insert("b", 200);
        assertThat(simpleHashMap.get("a"), is(100));
        assertThat(simpleHashMap.get("b"), is(200));
    }

    @Test
    public void insertAndResize() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        for (int i = 0; i != 100; i++) {
            String key = "a" + i;
            simpleHashMap.insert(key, i);
        }
        assertThat(simpleHashMap.get("a18"), is(18));
    }

    @Test
    public void insert2Delete2() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("a", 100);
        simpleHashMap.insert("b", 200);
        simpleHashMap.insert("c", 300);
        assertThat(simpleHashMap.get("b"), is(200));
        assertThat(simpleHashMap.get("c"), is(300));
        simpleHashMap.delete("b");
        simpleHashMap.delete("c");
        assertNull(simpleHashMap.get("b"));
        assertNull(simpleHashMap.get("c"));
    }

    @Test
    public void iterator16TrueLastFalse() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        var iterator = simpleHashMap.iterator();
        for (int i = 0; i != 16; i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElementException() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        var iterator = simpleHashMap.iterator();
        for (int i = 0; i != 16; i++) {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void iteratorModificationException() {
        SimpleHashMap<String, Integer> simpleHashMap = new SimpleHashMap<>();
        var iterator = simpleHashMap.iterator();
        simpleHashMap.insert("c", 300);
        iterator.next();
    }
}