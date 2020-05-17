package ru.job4j.lsp;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Storage> storages;

    public ControlQuality(@NotNull List<Storage> storageList) {
        this.storages = new ArrayList<>(storageList);
    }

    public void distribute(Food food) {
        for (Storage storage : storages) {
            if (storage.distribute(food)) {
                break;
            }
        }
    }

    public boolean addStorage(@NotNull Storage storage) {
        return storages.add(storage);
    }

    @Override
    public String toString() {
        return "Storages:" + storages;
    }
}
