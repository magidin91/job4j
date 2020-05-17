package ru.job4j.ocp;

import org.junit.Test;
import ru.job4j.srp.Employee;
import ru.job4j.srp.MemStore;

import java.util.Calendar;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportXMLTest {
    private static final String LN = System.lineSeparator();

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportXML engine = new ReportXML(store);
        StringJoiner expect = new StringJoiner(LN,
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                        + LN + "<emploees>" + LN,
                LN + "</emploees>");
        expect.add("<name>" + worker.getName() + "</name>")
                .add("<hired>" + worker.getHired() + "</hired>")
                .add("<fired>" + worker.getFired() + "</fired>")
                .add("<salary>" + worker.getSalary() + "</salary>")
                .add(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}