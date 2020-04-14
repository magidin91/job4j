package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReportJSONTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportJSON engine = new ReportJSON(store);
        StringJoiner expect = new StringJoiner(LN,
                "{" + LN,
                LN + "}");
        expect.add("\"name\": \"" + worker.getName() + "\"")
                    .add("\"hired\": \"" + worker.getHired() + "\"")
                    .add("\"fired\": \"" + worker.getFired() + "\"")
                    .add("\"salary\": " + worker.getSalary());
       assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}