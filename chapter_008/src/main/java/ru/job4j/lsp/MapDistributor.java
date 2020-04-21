package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MapDistributor implements Distributer {
    private Map<String, Storage> storageMap = new HashMap<>(Map.of("Trash", new Trash(),
            "Warehouse", new Warehouse(), "Shop", new Shop()));

    @Override
    public void distribute(Food food) {
        double percent = LocalDate.now().until(food.getCreateDate()).getDays() * 100.00 / food.getExpireDate().until(food.getCreateDate()).getDays();
        if (percent < 25) {
            storageMap.get("Warehouse").add(food);
        } else if (percent > 25 && percent < 75) {
            storageMap.get("Shop").add(food);
        } else if (percent > 75 && percent < 100) {
            food.setDiscount(30);
            food.setPrice(food.getPrice() * (1 - food.getDiscount()) / 100.00);
            storageMap.get("Shop").add(food);
        } else {
            storageMap.get("Trash").add(food);
        }
    }

    public Map<String, Storage> getStorageMap() {
        return storageMap;
    }

    public static void main(String[] args) {
        MapDistributor xxx = new MapDistributor();
        xxx.distribute(new Bread("bread", LocalDate.now(), LocalDate.of(2020, 04, 29), 120));
        xxx.distribute(new Bread("bread", LocalDate.now(), LocalDate.of(2020, 04, 30), 121));
        System.out.println(xxx.storageMap);
    }
}
