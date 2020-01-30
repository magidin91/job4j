package ru.job4j.collection.pro;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> inIterator;

            {
                if (it.hasNext()) {
                    inIterator = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                while (it.hasNext() && !inIterator.hasNext()) { //если есть, устанавливаем внешний непустой итератор
                    inIterator = it.next();
                }
                if (inIterator != null) { //проверяем случай, когда нет ни одного Iterator<Integer>
                    rsl = inIterator.hasNext();
                }
                return rsl;
            }

            @Override
            public Integer next() {
                if (!hasNext()) { //вызов hasNext сам сдвигает внешний итератор, если внутренние закончились
                    throw new NoSuchElementException();
                }
                return inIterator.next();
            }
        };
    }
}
