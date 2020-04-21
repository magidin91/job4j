package ru.job4j.lsp;

import java.time.LocalDate;

public class ControlQuality {
    private Distributer distributer;

    public ControlQuality(Distributer distributor) {
        this.distributer = distributor;
    }

    public void distribute(Food food) {
        distributer.distribute(food);
    }

    public Distributer getDistributer() {
        return distributer;
    }

    public static void main(String[] args) {
        new ControlQuality(new MapDistributor()).distribute(new Bread("bread", LocalDate.now(), LocalDate.of(2020, 04, 29), 120));
    }
}
