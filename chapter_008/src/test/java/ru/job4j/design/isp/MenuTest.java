package ru.job4j.design.isp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MenuTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenSelectExit() {
        ParentActionMenuItemImpl item11 = new ParentActionMenuItemImpl("1.1",
                List.of(new ParentActionMenuItemImpl("1.1.1", null),
                        new ParentActionMenuItemImpl("1.1.2", null)));
        ParentActionMenuItemImpl item1 = new ParentActionMenuItemImpl("1.", List.of(item11));

        new Menu(List.of(item1), System.out::println, () -> "exit").activateMenu();
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("1.")
                .add("1.1")
                .add("1.1.1")
                .add("1.1.2")
                .add("====To finish enter \"exit\"====")
                .add("====Select menu item====")
                .add("====Bye====")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whenSelectItemWithAction() {
        ParentActionMenuItemImpl item11 = new ParentActionMenuItemImpl("1.1",
                () -> System.out.println("it's working"),
                List.of(new ParentActionMenuItemImpl("1.1.1", null),
                        new ParentActionMenuItemImpl("1.1.2", null)));
        ParentActionMenuItemImpl item1 = new ParentActionMenuItemImpl("1.", List.of(item11));

        new Menu(List.of(item1), System.out::println, new StubInput(List.of("1.1", "exit"))
        ).activateMenu();
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("1.")
                .add("1.1")
                .add("1.1.1")
                .add("1.1.2")
                .add("====To finish enter \"exit\"====")
                .add("====Select menu item====")
                .add("it's working")
                .add("1.")
                .add("1.1")
                .add("1.1.1")
                .add("1.1.2")
                .add("====To finish enter \"exit\"====")
                .add("====Select menu item====")
                .add("====Bye====")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }
}