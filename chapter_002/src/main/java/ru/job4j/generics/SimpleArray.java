package ru.job4j.generics;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] vals;
    private int ind;

    public SimpleArray(int lenghth) {
        vals = new Object[lenghth];
    }

    public void add(T model) throws ArrayIndexOutOfBoundsException {
        vals[ind++] = model;
    }

    public void set(int index, T model) {
        if (index >= vals.length || index < 0) {
            System.out.println("ВЫ ввели неверный индекс");
            return;
        }
        vals[index] = model;
    }

    public T get(int index) {
        return (T) (index < vals.length && index >= 0 ? vals[index] : null);
    }

    public void remove(int index) {
        if (index >= vals.length || index < 0) {
            System.out.println("ВЫ ввели неверный индекс");
            return;
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
        return (Iterator<T>) Arrays.asList(this.vals).iterator();
    }
}

