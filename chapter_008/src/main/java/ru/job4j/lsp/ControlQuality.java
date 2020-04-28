package ru.job4j.lsp;

public class ControlQuality {
    private final Distributer distributer;

    public ControlQuality(Distributer distributor) {
        this.distributer = distributor;
    }

    public void distribute(Food food) {
        distributer.distribute(food);
    }
}
