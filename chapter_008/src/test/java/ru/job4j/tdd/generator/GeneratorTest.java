package ru.job4j.tdd.generator;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
public class GeneratorTest {

    @Test(expected = IllegalStateException.class)
    public void whenTemplateKeysMoreMapKeys() throws Exception {
        Generator generator = (template, args) -> null;
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "John");
        generator.produce(template, args);
    }

    @Test(expected = IllegalStateException.class)
    public void whenMapKeysNotAppropriateTemplateKeys() throws Exception {
        Generator generator = (template, args) -> null;
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "John", "NotSuchKeys", "you");
        generator.produce(template, args);
    }

    @Test(expected = IllegalStateException.class)
    public void whenMapKeysMoreTemplateKeys() throws Exception {
        Generator generator = (template, args) -> null;
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "John", "subject", "you", "name2", "John2");
        generator.produce(template, args);
    }

    @Test
    public void whenAppropriateKeys() throws Exception {
        Generator generator = (template, args) -> null;
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "John", "subject", "you");
        String exp = "I am a John, Who are you?";
        assertThat(generator.produce(template, args), is(exp));
    }
}