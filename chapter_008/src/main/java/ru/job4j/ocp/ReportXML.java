package ru.job4j.ocp;

import ru.job4j.srp.Employee;
import ru.job4j.srp.Store;

import java.util.StringJoiner;
import java.util.function.Predicate;

public class ReportXML {
    private static final String LN = System.lineSeparator();
    private Store store;

    public ReportXML(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringJoiner xml = new StringJoiner(LN,
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                        + LN + "<emploees>" + LN,
                LN + "</emploees>");
        for (Employee employee : store.findBy(filter)) {
            xml.add("<name>" + employee.getName() + "</name>")
                    .add("<hired>" + employee.getHired() + "</hired>")
                    .add("<fired>" + employee.getFired() + "</fired>")
                    .add("<salary>" + employee.getSalary() + "</salary>")
                    .add(System.lineSeparator());
        }
        return xml.toString();
    }
}