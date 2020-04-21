package ru.job4j.lsp;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Food {
    private String name;
    private LocalDate createDate;
    private LocalDate expireDate;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0
                && discount == food.discount
                && Objects.equals(name, food.name)
                && Objects.equals(createDate, food.createDate)
                && Objects.equals(expireDate, food.expireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expireDate, price, discount);
    }

    @Override
    public String toString() {
        return "name='" + name + '\''
                + ", createDate=" + createDate
                + ", expireDate=" + expireDate
                + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
