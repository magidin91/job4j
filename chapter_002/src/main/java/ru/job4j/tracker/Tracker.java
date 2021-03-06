package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    public void replace(String id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items.set(indexOf(id), item);
        } else {
            System.out.println("String id doesn't exist");
        }
    }

    public void delete(String id) {
        if (indexOf(id) != -1) {
            items.remove(indexOf(id));
        } else {
            System.out.println("String id doesn't exist");
        }
    }

    public ArrayList<Item> findAll() {
        ArrayList<Item> itemsWithoutNull = new ArrayList<>();
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNull.add(item);
            }
        }
        return itemsWithoutNull;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsEqualByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsEqualByName.add(item);
            }
        }
        return itemsEqualByName;
    }

    public Item findById(String id) {
        if (indexOf(id) != -1) {
            return items.get(indexOf(id));
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
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}