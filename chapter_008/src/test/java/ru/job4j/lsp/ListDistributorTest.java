package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ListDistributorTest {

    @Test
    public void distributeInWarehouseAndGet() {
        ListDistributor listDistributor = new ListDistributor(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(1), now.plusDays(10), 120);
        listDistributor.distribute(bread);
        assertThat(listDistributor.getListStorage().get(0).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShopAndGet() {
        ListDistributor listDistributor = new ListDistributor(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.plusDays(10), 120);
        listDistributor.distribute(bread);
        assertThat(listDistributor.getListStorage().get(1).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void distributeInShopAndMakeDiscount() {
        ListDistributor listDistributor = new ListDistributor(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(90), now.plusDays(10), 120);
        listDistributor.distribute(bread);
        assertEquals(30, listDistributor.getListStorage().get(1).getFood(bread.getName()).get(0).getDiscount());
    }

    @Test
    public void distributeInTrashAndGet() {
        ListDistributor listDistributor = new ListDistributor(List.of(new Warehouse(), new Shop(), new Trash()));
        LocalDate now = LocalDate.now();
        Food bread = new Bread("bread", now.minusDays(10), now.minusDays(1), 120);
        listDistributor.distribute(bread);
        assertThat(listDistributor.getListStorage().get(2).getFood(bread.getName()).get(0), is(bread));
    }

    @Test
    public void addOneStorage() {
        ListDistributor listDistributor = new ListDistributor(Collections.emptyList());
        listDistributor.addStorage(new Warehouse());
        assertEquals(1, listDistributor.getListStorage().size());
    }
}