package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public interface Store {

    /**
     * Returns a List of element by predicat from storage
     */
    List<Employee> findBy(Predicate<Employee> filter);
}