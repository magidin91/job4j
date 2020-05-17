package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void distributeInWarehouse() {
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertThat(warehouse.getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShop() {
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), shop, new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertThat(shop.getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShopAndMakeDiscount() {
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), shop, new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(90), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertEquals(30, shop.getFood(bread.getName()).get(0).getDiscount());
    }

    @Test
    public void distributeInTrash() {
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), trash));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        controlQuality.distribute(bread);
        assertThat(trash.getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void addStorageWarehouseAndDistributeInWarehouse() {
        ControlQuality controlQuality = new ControlQuality(Collections.emptyList());
        Warehouse warehouse = new Warehouse();
        controlQuality.addStorage(warehouse);
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertThat(warehouse.getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeAndResort() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse, shop, trash));
        LocalDate now = LocalDate.now();
        Food breadInWarehouse = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        controlQuality.distribute(breadInWarehouse);
        Food breadInShop = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        controlQuality.distribute(breadInShop);
        Food breadInTrash = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        controlQuality.distribute(breadInTrash);
        controlQuality.resort();
        assertThat(warehouse.getFood(breadInWarehouse.getName()).get(0), is(breadInWarehouse));
        assertThat(shop.getFood(breadInShop.getName()).get(0), is(breadInShop));
        assertThat(trash.getFood(breadInTrash.getName()).get(0), is(breadInTrash));
    }
}