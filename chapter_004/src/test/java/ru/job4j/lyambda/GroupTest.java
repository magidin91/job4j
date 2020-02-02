package ru.job4j.lyambda;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
    @Test
    public void getSection() {
        Map<String, Set<String>> rsl = Group.sections(List.of(new Student("Ivan", Set.of("Run", "Boxing")), new Student("Andrei", Set.of("Run", "Boxing", "Chess")),
                new Student("Alexei", Set.of("Run", "Chess"))));
        assertThat(rsl.get("Chess"), is(Set.of("Andrei", "Alexei")));
    }

}