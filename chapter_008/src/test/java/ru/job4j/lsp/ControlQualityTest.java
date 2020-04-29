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
    public void distributeInWarehouseAndGet() {
        ControlQuality controlQuality = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        controlQuality.distribute(bread);
        assertThat(controlQuality.getStorages().get(0).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShopAndGet() {
        ControlQuality listDistributor = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        listDistributor.distribute(bread);
        assertThat(listDistributor.getStorages().get(1).getFood(bread.getName()).get(0), is(bread));
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
    public void distributeInTrashAndGet() {
        ControlQuality listDistributor = new ControlQuality(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        listDistributor.distribute(bread);
        assertThat(listDistributor.getStorages().get(2).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void addOneStorage() {
        ControlQuality listDistributor = new ControlQuality(Collections.emptyList());
        listDistributor.addStorage(new Warehouse());
        assertEquals(1, listDistributor.getStorages().size());
    }
}