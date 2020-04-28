package ru.job4j.lsp;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListDistributor implements Distributer {
    private final List<Storage> listStorage;

    public ListDistributor(@NotNull List<Storage> storageList) {
        this.listStorage = new ArrayList<>(storageList);
    }

    @Override
    public void distribute(Food food) {
        for (Storage storage : listStorage) {
            if (storage.add(food)) {
                break;
            }
        }
    }

    public boolean addStorage(Storage storage) {
        return listStorage.add(storage);
    }

    public List<Storage> getListStorage() {
        return listStorage;
    }

    @Override
    public String toString() {
        return "ListDistributor:" + listStorage;
    }
}
