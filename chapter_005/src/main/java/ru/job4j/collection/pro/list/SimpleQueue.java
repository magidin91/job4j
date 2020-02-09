package ru.job4j.collection.pro.list;

/**
 * Очередь на двух стеках
 * Описывается FIFO - first input first output.
 */

public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> queue = new SimpleStack<>();

    /**
     * Добавляет элемент в стэк в начало
     */
    public void push(T value) {
        stack.push(value);
    }

    /**
     * Помещает элементы из стека в обратном порядке и удаляет первый добавленный элемент (FIFO)
     */
    public T poll() {
        if (queue.getSize()==0) {
            int size = stack.getSize();
            for (int i = 0; i < size; i++) {
                queue.push((stack.poll()));
            }
        }
       return queue.poll();
    }
}
