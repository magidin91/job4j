package ru.job4j.collection.pro.list;

import org.jetbrains.annotations.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс SimpleArrayList.
 */
public class SimpleArrayList<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modCount = 0;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }

    /**
     * Реализовать метод удаления первого элемента в списке.
     */
    public E delete() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> deleted = this.first;
        this.first = first.next;
        deleted.next = null;
        this.size--;
        return deleted.data;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int cursor;
            private int expectedModCount = modCount;
            private Node<E> next = first;
            private Node<E> lastReturned;

            @Override
            public boolean hasNext() {
                return cursor != SimpleArrayList.this.size;
            }

            @Override
            public E next() {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturned = next;
                next = next.next;
                cursor++;
                return lastReturned.data;
            }

            final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
