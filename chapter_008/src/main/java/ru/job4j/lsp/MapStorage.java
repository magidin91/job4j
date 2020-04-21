package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapStorage implements Storage {

    private Map<String, List<Food>> storage = new HashMap<>();

    public MapStorage() {
    }

    public MapStorage(Map<String, List<Food>> storage) {
        this.storage = storage;
    }

    @Override
    public void add(Food food) {
        String name = food.getName();
        List<Food> list = storage.computeIfAbsent(name, k -> new ArrayList<>());
        list.add(food);
    }

    public  List<Food> getFood(String name) {
        return  storage.get(name);
    }

    public Map<String, List<Food>> getStorage() {
        return storage;
    }
}
