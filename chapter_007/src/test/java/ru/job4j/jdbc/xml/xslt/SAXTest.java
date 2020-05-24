package ru.job4j.jdbc.xml.xslt;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SAXTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void createXMLConvertXSLTPParseSAX() {
        File source;
        File dest;
        List<Entry> list = List.of(new Entry(1), new Entry(2), new Entry(3));
        File scheme = new File("./src/main/resources/schema.xsl");

        try {
            source = folder.newFile("xmlCode.xml");
            dest = folder.newFile("dest.xml");
            new StoreXML(source).save(list);
            new ConvertXSQT().convert(source, dest, scheme);
            SAX sax = new SAX();
            sax.parse(dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(SAX.sum, is(6));
    }
}