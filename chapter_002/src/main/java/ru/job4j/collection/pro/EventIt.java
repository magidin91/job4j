package ru.job4j.collection.pro;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt implements Iterator<Integer> {
    private final int[] values;
    private int index = 0;

    public EventIt(int[] values) {
        this.values = values;
    }

    private void whileCondition() {
        while ((index < values.length) && (values[index] % 2 != 0)) {
            index++;
        }
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        int startIndex = index;
        whileCondition();
        if (index < values.length) {
            rsl = true;
        }
        index = startIndex;
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        whileCondition();
        return values[index++];
    }
}
