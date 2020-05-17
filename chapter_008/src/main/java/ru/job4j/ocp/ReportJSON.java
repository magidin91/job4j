package ru.job4j.ocp;

import ru.job4j.srp.Employee;
import ru.job4j.srp.Store;

import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportJSON {
    private static final String LN = System.lineSeparator();
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringJoiner json = new StringJoiner(LN,
                "{" + LN,
                LN + "}");
        for (Employee employee : store.findBy(filter)) {
            json.add("\"name\": \"" + employee.getName() + "\"")
                    .add("\"hired\": \"" + employee.getHired() + "\"")
                    .add("\"fired\": \"" + employee.getFired() + "\"")
                    .add("\"salary\": " + employee.getSalary());
        }
        return json.toString();
    }
}