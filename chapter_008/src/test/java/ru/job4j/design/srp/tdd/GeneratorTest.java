package ru.job4j.design.srp.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class GeneratorTest {
    private final Generator generator = (template, args) -> null;
    private final String template = "I am a ${name}, Who are ${subject}?";

    @Test(expected = IllegalStateException.class)
    public void getTemplateKeysMoreMapKeys() throws Exception {
        Map<String, String> args = Map.of("name", "John");
        generator.produce(template, args);
    }

    @Test(expected = IllegalStateException.class)
    public void getTemplateKeysMoreAppropriateMapKeys() throws Exception {
        Map<String, String> args = Map.of("name", "John", "OBJECT", "you");
        generator.produce(template, args);
    }

    @Test(expected = IllegalStateException.class)
    public void getMapExtraKeys() throws Exception {
        Map<String, String> args = Map.of("name", "John", "subject", "you", "name2", "John2");
        generator.produce(template, args);
    }

    @Test
    public void getAppropriateKeys() throws Exception {
        Map<String, String> args = Map.of("name", "John", "subject", "you");
        String exp = "I am a John, Who are you?";
        assertThat(generator.produce(template, args), is(exp));
    }
}