package ru.job4j.srp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Class represents a report for HR
 */
public class ReportForHR implements Report {
    private Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {

        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        List<Employee> employees = store.findBy(filter);
        employees.sort(Collections.reverseOrder(Comparator.comparingDouble(Employee::getSalary)));
        for (Employee employee : employees) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
