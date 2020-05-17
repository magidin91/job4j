package ru.job4j.lsp;

public class Warehouse extends MapStorage {
    @Override
    public String toString() {
        return "Warehouse: " + getStorage();
    }

    @Override
    public boolean distribute(Food food) {
        boolean rsl = false;
        double shelfLifeConsumption = food.getShelfLifePercentConsumption();
        if (shelfLifeConsumption >= 0 && shelfLifeConsumption < 25) {
            getExistingOrCreateFoodList(food).add(food);
            rsl = true;
        }
        return rsl;
    }
}
