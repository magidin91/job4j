package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * Class represents a report for accountants
 */
public class ReportForAcc implements Report {
    private Store store;

    public ReportForAcc(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append("$").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
