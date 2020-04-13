package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportForDevTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportForDev engine = new ReportForDev(store);
        StringJoiner expect = new StringJoiner(LN,
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
        expect.add("<name>" + worker.getName() + "</name>")
                .add("<hired>" + worker.getHired() + "</hired>")
                .add("<fired>" + worker.getFired() + "</fired>")
                .add("<salary>" + worker.getSalary() + "</salary>")
                .add(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}