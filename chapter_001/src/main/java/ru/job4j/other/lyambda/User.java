package ru.job4j.other.lyambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class User {

    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class UserSort {
    static ArrayList<User> userList = new ArrayList<>();

    public static void main(String[] args) {
        User user1 = new User("a", 30);
        User user2 = new User("b", 20);
        User user3 = new User("c", 10);

        userList.addAll(Arrays.asList(user3, user2, user1));
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(userList);
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(userList);

    }
}