package ru.job4j.collection.pro.exam;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Analize {

    public Info diff(@NotNull List<User> previous, @NotNull List<User> current) {
        int changed = 0;
        int common = 0;
        for (User prevUser : previous) {
            for (User currUser : current) {
                if (prevUser.id == currUser.id) {
                    if (prevUser.name.equals(currUser.name)) {
                        common++;
                    } else {
                        changed++;
                    }
                }
            }
        }
        int deleted = previous.size() - common - changed;
        int added = current.size() - previous.size() + deleted;
        return createInfo(added, changed, deleted);
    }

    public Info createInfo(int added, int changed, int deleted) {
        Info info = new Info();
        info.added = added;
        info.changed = changed;
        info.deleted = deleted;
        return info;
    }

    public static class User {
        int id;
        String name;
    }

    public static class Info {
        int added;
        int changed;
        int deleted;
    }
}