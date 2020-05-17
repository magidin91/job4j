package ru.job4j.lsp.storage;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.DAYS;

public abstract class Food {
    private String name;
    private final LocalDate createDate;
    private final LocalDate expireDate;
    private double price;
    private int discount;

    public Food(String name, LocalDate createDate, LocalDate expireDate, double price) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    /**
     * Counts a spent part of the shelf life.
     */
    public double getShelfLifePercentConsumption() {
        long shelfLifeConsumption = DAYS.between(getCreateDate(), LocalDate.now());
        long shelfLife = DAYS.between(getCreateDate(), getExpireDate());
        return shelfLifeConsumption * 100.00 / shelfLife;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    @Override
    public String toString() {
        return "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + ", price=" + price
                + ", discount=" + discount + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expireDate, food.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expireDate);
    }
}
