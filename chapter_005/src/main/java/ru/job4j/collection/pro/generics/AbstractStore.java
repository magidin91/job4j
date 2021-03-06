package ru.job4j.collection.pro.generics;

import java.util.NoSuchElementException;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> simpleArray;

    public AbstractStore(int size) {
        this.simpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) throws ArrayIndexOutOfBoundsException {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = getId(id);
        if (index == -1) {
            return false;
        }
        simpleArray.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = getId(id);
        if (index == -1) {
            return false;
        }
        simpleArray.remove(index);
        return true;
    }

    @Override
    public T findById(String id) throws NoSuchElementException {
        int index = getId(id);
        if (index == -1) {
            throw new NoSuchElementException(" Element by id: " + id + " not found");
        }
        return simpleArray.get(index);
    }

    public int getId(String id) {
        int index = 0;
        for (T element : simpleArray) {
            if (element != null && element.getId().equals(id)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
