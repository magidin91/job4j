package ru.job4j.srp;

import java.util.function.Predicate;

public interface Report {
    /**
     * Returns a report on received employees
     */
    String generate(Predicate<Employee> filter);
}
