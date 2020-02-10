package ru.job4j.collection.pro.list;

import org.jetbrains.annotations.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DynamicArray<E> implements Iterable<E> {
    private Object[] vals = new Object[10];
    private int ind;
    private int modCount;

    public void add(E value) {
        if (ind == vals.length) {
            Object[] oldVals = vals;
            vals = new Object[oldVals.length + 10];
            System.arraycopy(oldVals, 0, vals, 0, oldVals.length);
        }
        vals[ind++] = value;
        modCount++;
    }

    /**
     * @throws IndexOutOfBoundsException if the {@code index} is out of bounds
     */
    E get(int index) {
        Objects.checkIndex(index, ind);
        return (E) vals[index];
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            int cursor;

            @Override
            public boolean hasNext() {
                return cursor != vals.length;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) vals[cursor++];
            }

            final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
