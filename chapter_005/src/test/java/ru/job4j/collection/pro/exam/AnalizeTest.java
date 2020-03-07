package ru.job4j.collection.pro.exam;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    private List<Analize.User> previous;
    private List<Analize.User> current;
    private Analize.User u1;
    private Analize.User u2;
    private Analize.User u3;
    private Analize.User u4;
    private Analize.User u5;
    private Analize analize = new Analize();

    @Before
    public void addPrevious() {
        u1 = new Analize.User();
        u1.name = "u1";
        u1.id = 1;
        u2 = new Analize.User();
        u2.name = "u2";
        u2.id = 2;
        u3 = new Analize.User();
        u3.name = "u3";
        u3.id = 3;
        u4 = new Analize.User();
        u4.name = "u4";
        u4.id = 4;
        u5 = new Analize.User();
        u5.name = "u5";
        u5.id = 5;
        previous = List.of(u1, u2, u3, u4, u5);
    }

    @Test
    public void delete2() {
        current = List.of(u1, u2, u5);
        assertThat(analize.diff(previous, current).deleted, is(2));
    }

    @Test
    public void add1() {
        Analize.User u6 = new Analize.User();
        u6.id = 6;
        u6.name = "u6";
        current = List.of(u1, u2, u3, u4, u5, u6);
        assertThat(analize.diff(previous, current).added, is(1));
    }

    @Test
    public void changed1() {
        Analize.User u5Changed = new Analize.User();
        u5Changed.id = 5;
        u5Changed.name = "u5Changed";
        current = List.of(u1, u2, u3, u4, u5Changed);
        assertThat(analize.diff(previous, current).changed, is(1));
    }

    @Test
    public void changed1Add1Delete2() {
        Analize.User u6 = new Analize.User();
        u6.id = 6;
        u6.name = "u6";
        Analize.User u5Changed = new Analize.User();
        u5Changed.id = 5;
        u5Changed.name = "u5Changed";
        current = List.of(u1, u2, u3, u5Changed, u6); // u4 - deleted, u5 - changed, u6added
        assertThat(analize.diff(previous, current).changed, is(1));
        assertThat(analize.diff(previous, current).added, is(1));
        assertThat(analize.diff(previous, current).deleted, is(1));
    }
}