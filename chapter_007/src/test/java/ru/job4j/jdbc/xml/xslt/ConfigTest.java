package ru.job4j.jdbc.xml.xslt;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void initAndGetProperty() {
        assertThat(new Config().get("url"), is("jdbc:sqlite:chapter_007/src/main/resources/test.db"));
    }
}