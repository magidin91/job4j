package ru.job4j.lsp;

import java.util.List;

public interface Storage {
    /**
     * Add food to the storage
     */
    boolean add(Food food);

    /**
     * Returns list of food with specific name (for example "bread", "milk" etc..)
     */
    List<Food> getFood(String name);
}
