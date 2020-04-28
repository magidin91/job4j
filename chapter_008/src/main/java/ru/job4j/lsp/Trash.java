package ru.job4j.lsp;

public class Trash extends MapStorage {
    @Override
    public String toString() {
        return "Trash: " + getStorage();
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        double shelfLifeConsumption = food.getShelfLifePercentConsumption();
        if (shelfLifeConsumption > 100) {
            getExistingOrCreateFoodList(food).add(food);
            rsl = true;
        }
        return rsl;
    }
}
