package ru.job4j.tdd.cinema;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class CinemaTest {
    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Ignore
    @Test
    public void buyNotExistedPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, -1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void buyNotExistedDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(-2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void buyNotExistedAccount() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(-2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(null, 1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void buyBoughtBySomeoneTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, -1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void buyBoughtByYouTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, -1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Collections.singletonList(new Session3D())));
    }

    @Ignore
    @Test
    public void notFindRelevantSessions() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> false);
        assertThat(sessions, is(Collections.emptyList()));
    }
}

