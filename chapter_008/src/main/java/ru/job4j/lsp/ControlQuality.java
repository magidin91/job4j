package ru.job4j.lsp;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Storage> listStorage;

    public ControlQuality(@NotNull List<Storage> storageList) {
        this.listStorage = new ArrayList<>(storageList);
    }

    public void distribute(Food food) {
        for (Storage storage : listStorage) {
            if (storage.distribute(food)) {
                break;
            }
        }
    }

    public boolean addStorage(@NotNull Storage storage) {
        return listStorage.add(storage);
    }

    public List<Storage> getStorages() {
        return listStorage;
    }

    @Override
    public String toString() {
        return "Storages:" + listStorage;
    }
}
