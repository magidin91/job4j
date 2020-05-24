package ru.job4j.jdbc.xml.xslt;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StoreXMLTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Ignore
    @Test
    public void saveListAndRead() {
        File f;
        List<Entry> list = List.of(new Entry(1), new Entry(2), new Entry(3));
        StringBuilder rsl = new StringBuilder();
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<entries>"
                + "    <entry>"
                + "        <field>1</field>"
                + "    </entry>"
                + "    <entry>"
                + "        <field>2</field>"
                + "    </entry>"
                + "    <entry>"
                + "        <field>3</field>"
                + "    </entry>"
                + "</entries>";
        try {
            f = folder.newFile("xmlCode.xml");
            new StoreXML(f).save(list);
            try (BufferedReader in = new BufferedReader(new FileReader(f))) {
                in.lines().forEach(rsl::append);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(rsl.toString(), is(expected));
    }
}