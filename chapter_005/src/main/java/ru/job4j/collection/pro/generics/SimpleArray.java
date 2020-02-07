package ru.job4j.collection.pro.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] vals;
    private int ind;

    public SimpleArray(int lenghth) {
        vals = new Object[lenghth];
    }

    public void add(T model) throws ArrayIndexOutOfBoundsException {
        vals[ind++] = model;
    }

    public void set(int index, T model) throws ArrayIndexOutOfBoundsException {
        if (index >= ind || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ВЫ ввели неверный индекс");
        }
        vals[index] = model;
    }

    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= ind || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ВЫ ввели неверный индекс");
        }
        return (T) vals[index];
    }

    public void remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= ind || index < 0) {
            throw new ArrayIndexOutOfBoundsException("ВЫ ввели неверный индекс");
        }
        if (index != vals.length - 1) {
            System.arraycopy(vals, index + 1, vals, index, vals.length - index - 1);
        }
        vals[vals.length - 1] = null;
        ind--;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < vals.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) vals[index++];
            }
        };
    }
}

