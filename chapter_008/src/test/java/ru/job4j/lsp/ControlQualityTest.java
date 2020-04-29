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
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertThat(controlQuality.getStorages().get(0).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShop() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertThat(controlQuality.getStorages().get(1).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShopAndMakeDiscount() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(90), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertEquals(30, controlQuality.getStorages().get(1).getFood(bread.getName()).get(0).getDiscount());
    }

    @Test
    public void distributeInTrash() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        controlQuality.distribute(bread);
        assertThat(controlQuality.getStorages().get(2).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void addOneStorage() {
        ControlQuality controlQuality = new ControlQuality(Collections.emptyList());
        controlQuality.addStorage(new Warehouse());
        assertEquals(1, controlQuality.getStorages().size());
    }

    @Test
    public void distributeAndResort() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food breadInWarehouse = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        controlQuality.distribute(breadInWarehouse);
        Food breadInShop = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        controlQuality.distribute(breadInShop);
        Food breadInTrash = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        controlQuality.distribute(breadInTrash);
        controlQuality.resort();
        assertThat(controlQuality.getStorages().get(0).getFood(breadInWarehouse.getName()).get(0), is(breadInWarehouse));
        assertThat(controlQuality.getStorages().get(1).getFood(breadInShop.getName()).get(0), is(breadInShop));
        assertThat(controlQuality.getStorages().get(2).getFood(breadInTrash.getName()).get(0), is(breadInTrash));
    }
}