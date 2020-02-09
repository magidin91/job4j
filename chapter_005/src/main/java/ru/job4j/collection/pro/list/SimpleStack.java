package ru.job4j.collection.pro.list;

public class SimpleStack<T> {
    private SimpleArrayList<T> simpleArrayList = new SimpleArrayList<>();

    /**
     * Вставляет элемент в начало
     */
    public void push(T value) {
        simpleArrayList.add(value);
    }
    /**
     * Возвращает последний вставленный элемент (начало) и удаляет его
     */
    public T poll() {
        return simpleArrayList.delete();
    }
    public int getSize() {
        return simpleArrayList.getSize();
    }
}
