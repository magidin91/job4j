package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Ivan")
        );
        assertThat(
                config.value("name2"),
                is("Andrei")
        );
    }

   @Test
    public void whenPairWithComment() {
        Config config = new Config("./data/app.properties");
        config.load();
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }
}