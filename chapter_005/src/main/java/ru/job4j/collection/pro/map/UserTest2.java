package ru.job4j.collection.pro.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest2 {
    public static void main(String[] args) {
        User first = new User("Ivan", 3, new GregorianCalendar(1991, Calendar.AUGUST, 21));
        User second = new User("Ivan", 3, new GregorianCalendar(1991, Calendar.AUGUST, 21));
        Map<User, Object> users = new HashMap<>();
        users.put(first, new Object());
        users.put(second, new Object());
        System.out.println(users);
    }
}
