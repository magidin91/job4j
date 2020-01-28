package ru.job4j.collection.pro;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator<Integer> {
    private final int[][] values;
    private int i = 0;
    private int j = 0;

    public JaggedArrayIterator(int[][] values) {
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        return (i < values.length) && (j < values[i].length);
    }

    @Override
    public Integer next() {
        int rsl = values[i][j];
        if (j < values[i].length - 1) {
            j++;
        } else {
            j = 0;
            i++;
        }
        return rsl;
    }
}
