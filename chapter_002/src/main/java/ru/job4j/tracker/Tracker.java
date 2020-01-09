package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }

    public void replace(String id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items[indexOf(id)] = item;
        } else {
            System.out.println("String id doesn't exist");
        }
    }

    public void delete(String id) {
        if (indexOf(id) != -1) {
            System.arraycopy(items, indexOf(id) + 1, items, indexOf(id), position - indexOf(id));
            items[position] = null;
            position--;
        } else {
            System.out.println("String id doesn't exist");
        }
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] itemsEqualByName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index].getName().equals(key)) {
                itemsEqualByName[size] = items[index];
                size++;
            }
        }
        itemsEqualByName = Arrays.copyOf(itemsEqualByName, size);
        return itemsEqualByName;
    }

    public Item findById(String id) {
        if (indexOf(id) != -1) {
            return items[indexOf(id)];
        } else {
            System.out.println("String id doesn't exist");
            return null;
        }
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}