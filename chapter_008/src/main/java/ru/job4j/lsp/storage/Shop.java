package ru.job4j.lsp.storage;

public class Shop extends MapStorage {
    @Override
    public String toString() {
        return "Shop: " + getStorage();
    }

    @Override
    public boolean distribute(Food food) {
        boolean rsl = false;
        double shelfLifeConsumption = food.getShelfLifePercentConsumption();
        if (shelfLifeConsumption >= 25 && shelfLifeConsumption < 100) {
            setDiscountAndPrice(food, shelfLifeConsumption);
            getExistingOrCreateFoodList(food).add(food);
            rsl = true;
        }
        return rsl;
    }

    private void setDiscountAndPrice(Food food, double shelfLifeConsumption) {
        if (shelfLifeConsumption > 75) {
            food.setDiscount(30);
            food.setPrice(food.getPrice() * (100 - food.getDiscount()) / 100.00);
        }
    }
}
