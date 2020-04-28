package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapStorage implements Storage {
    private final Map<String, List<Food>> storage = new HashMap<>();

    @Override
    public abstract boolean add(Food food);

    public  List<Food> getFood(String name) {
        return  storage.get(name);
    }

    public Map<String, List<Food>> getStorage() {
        return storage;
    }

    /**
     * Returns list of this food if it exists or create it and returns.
     */
    public List<Food> getExistingOrCreateFoodList(Food food) {
        Map<String, List<Food>> storage = getStorage();
        String foodName = food.getName();
        List<Food> foodList = storage.get(foodName);
        if (foodList == null) {
            foodList = new ArrayList<>();
            storage.put(foodName, foodList);
        }
        return foodList;
    }
}
