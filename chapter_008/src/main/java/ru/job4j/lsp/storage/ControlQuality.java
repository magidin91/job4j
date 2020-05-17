package ru.job4j.lsp.storage;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Storage> storages;

    public ControlQuality(@NotNull List<Storage> storageList) {
        this.storages = new ArrayList<>(storageList);
    }

    public void distribute(@NotNull Food food) {
        for (Storage storage : storages) {
            if (storage.distribute(food)) {
                break;
            }
        }
    }

    /**
     * Redistributes food in all storages
     */
    public void resort() {
        for (Storage storage : storages) {
            for (Food food : storage.getAllFood()) {
                storage.resetStorage();
                storage.distribute(food);
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
