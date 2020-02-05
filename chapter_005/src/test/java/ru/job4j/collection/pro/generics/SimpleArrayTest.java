package ru.job4j.collection.pro.generics;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test
    public void checkAdd() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("ss");
        simpleArray.add("bb");
        String[] expected = new String[]{"ss", "bb"};
        String[] actual = new String[2];
        actual[0] = simpleArray.get(0);
        actual[1] = simpleArray.get(1);
        assertThat(actual, is(expected));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddArrayIndexOutOfBounds3to2() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("ss");
        simpleArray.add("bb");
        simpleArray.add("sss");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddArrayIndexOutOfBounds() {
        SimpleArray<String> simpleArray = new SimpleArray<>(0);
        simpleArray.add("ss");
        simpleArray.add("bb");
        simpleArray.add("sss");
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenArrayIndexOutOfBounds() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.set(5, "ss");
    }

    @Test
    public void whenAddARemoveOne() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("ss");
        simpleArray.remove(0);
        assertNull(simpleArray.get(0));
    }

    @Test
    public void whenAddRemoveOne() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("ss");
        simpleArray.add("aa");
        simpleArray.add("ff");
        simpleArray.remove(1);
        String expected = "rr";
        simpleArray.add(expected);
        assertThat(simpleArray.get(2), is(expected));
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator3Next2lenghth() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("ss");
        simpleArray.add("bb");
        Iterator<String> iterator = simpleArray.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}