package ru.job4j.srp;

import java.util.StringJoiner;
import java.util.function.Predicate;

/**
 *  Class represents a report for developers
 */
public class ReportForDev implements Report {
    private static final String LN = System.lineSeparator();
    private Store store;

    public ReportForDev(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        StringJoiner html = new StringJoiner(LN,
                "<!DOCTYPE html>"
                        + LN + "<html>"
                        + LN + "<head>" + LN + "<meta charset=\"UTF-8\">"
                        + LN + "<title>Information</title>"
                        + LN + "</head>"
                        + LN + "<body>"
                        + LN + "<emploees>" + LN,
                LN + "</emploees>"
                        + LN + "</body>"
                        + LN + "</html>");
        for (Employee employee : store.findBy(filter)) {
            html.add("<name>" + employee.getName() + "</name>")
                    .add("<hired>" + employee.getHired() + "</hired>")
                    .add("<fired>" + employee.getFired() + "</fired>")
                    .add("<salary>" + employee.getSalary() + "</salary>")
                    .add(System.lineSeparator());
        }
        return html.toString();
    }
}

