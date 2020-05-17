package ru.job4j.lsp.storage;

import java.util.List;

public interface Storage {
    /**
     * Add food to the storage
     */
    boolean distribute(Food food);

    /**
     * Returns list of food with specific name (for example "bread", "milk" etc..)
     */
    List<Food> getFood(String name);

    /**
     * Returns list of all food  in storage
     */
    List<Food> getAllFood();
}
