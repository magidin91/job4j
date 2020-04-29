package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapStorage implements Storage {
    private Map<String, List<Food>> storage = new HashMap<>();

    @Override
    public abstract boolean distribute(Food food);

    @Override
    public List<Food> getFood(String name) {
        return storage.get(name);
    }

    @Override
    public List<Food> getAllFood() {
        List<Food> allFood = new ArrayList<>();
        for (List<Food> product : storage.values()) {
            allFood.addAll(product);
        }
        return allFood;
    }

    public void resetStorage() {
        storage = new HashMap<>();
    }

    public Map<String, List<Food>> getStorage() {
        return storage;
    }


    /**
     * Returns list of this food if it exists or create it and returns.
     */
    public List<Food> getExistingOrCreateFoodList(Food food) {
        String foodName = food.getName();
        List<Food> foodList = storage.get(foodName);
        if (foodList == null) {
            foodList = new ArrayList<>();
            storage.put(foodName, foodList);
        }
        return foodList;
    }
}
