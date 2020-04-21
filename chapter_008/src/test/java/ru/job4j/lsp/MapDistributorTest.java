package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MapDistributorTest {
    private MapDistributor mapDistributor = new MapDistributor();
    private LocalDate now = LocalDate.now();

    @Test
    public void putInWarehouseAndGet() {
        Food bread = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        mapDistributor.distribute(bread);
        assertThat(mapDistributor.getStorageMap().get("Warehouse").getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void putInShopAndGet() {
        Food bread = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        mapDistributor.distribute(bread);
        assertThat(mapDistributor.getStorageMap().get("Shop").getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void putInTrashAndGet() {
        Food bread = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        mapDistributor.distribute(bread);
        assertThat(mapDistributor.getStorageMap().get("Trash").getFood(bread.getName()).get(0), is(bread));
    }
}