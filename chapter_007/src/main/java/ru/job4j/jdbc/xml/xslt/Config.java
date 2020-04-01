package ru.job4j.jdbc.xml.xslt;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();
    {
        init();
    }

    /**
     * Метод загружает пропертис
     */
    private void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Метод возвращает проперти, соответствующее ключу
     */
    public String get(String key) {
        return this.values.getProperty(key);
    }
}