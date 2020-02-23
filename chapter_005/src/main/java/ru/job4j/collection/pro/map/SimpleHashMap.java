package ru.job4j.collection.pro.map;

import org.jetbrains.annotations.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private Node<K, V>[] tab;
    private int size;
    private int n; //длина массива
    private static final float LOAD_FACTOR = 0.75f;
    private int modCount;
    /**
     * Количество элементов, при котором удваиваем длину массива
     */
    int threshold;

    public SimpleHashMap() {
        this.tab = new Node[DEFAULT_INITIAL_CAPACITY];
        n = DEFAULT_INITIAL_CAPACITY;
        threshold = (int) (n * LOAD_FACTOR);
    }

    /**
     * @param capacity должен быть 2^n.
     */
    public SimpleHashMap(int capacity) {
        this.tab = new Node[capacity];
        n = capacity;
        threshold = (int) (n * LOAD_FACTOR);
    }

    public boolean insert(K key, V value) {
        int hash = hash(key);
        resize();
        int i = forIndex(hash);

        if (tab[i] == null) {
            Node<K, V> node = new Node<K, V>(key, value, hash);
            tab[i] = node;
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int i = forIndex(hash(key));
        V value = null;
        Node<K, V> node = tab[i];
        if (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) { //проверяем тот ли ключ, лежит в ноде из ячейки
                value = node.value;
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean rsl = false;
        int i = forIndex(hash(key));
        Node<K, V> node = tab[i];
        if (node != null) {
            if ((key == null && node.key == null) || (key != null && key.equals(node.key))) {
                tab[i] = null;
                rsl = true;
                size--;
                modCount++;
            }
        }
        return rsl;
    }

    private void resize() {
        if (size == threshold) {
            Node<K, V>[] oldTab = tab;
            tab = new Node[n << 1];
            n = n << 1;
            threshold = threshold << 1;
            for (Node node : oldTab) {
                if (node != null) {
                    tab[forIndex(node.hash)] = node;
                }
            }
        }
    }

    private int forIndex(int hash) {
        return (n - 1) & hash;
    }

    static final int hash(Object key) {
        int rsl;
        if (key == null) {
            rsl = 0;
        } else {
            int h = key.hashCode();
            rsl = h ^ (h >>> 16);
        }
        return rsl;
    }

    @NotNull
    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor != n;
            }

            @Override
            public Node<K, V> next() throws NoSuchElementException, ConcurrentModificationException {
                checkForComodification();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return tab[cursor++];
            }

            private final void checkForComodification() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    static class Node<K, V> {
        final K key;
        V value;
        final int hash;

        Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
