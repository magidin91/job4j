package ru.job4j.collection.pro.set;

import org.jetbrains.annotations.NotNull;
import ru.job4j.collection.pro.list.DynamicArray;

import java.util.Iterator;

/**
 * Аналог коллекции Set на базе массива
 */

public class SimpleSet<E> implements Iterable<E> {
    private final DynamicArray<E> dynamicArray;

    public SimpleSet() {
        this.dynamicArray = new DynamicArray<>();
    }

    /**
     * Метод добавляет элемент, если он осутствует в массиве-контейнере
     */
    public void add(E e) {
        for (E element : dynamicArray) {
            if (e == element) {
                return;
            }
        }
        dynamicArray.add(e);
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return dynamicArray.iterator();
    }
}
