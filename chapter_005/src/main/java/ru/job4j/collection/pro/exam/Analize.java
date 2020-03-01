package ru.job4j.collection.pro.exam;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(@NotNull List<User> previous, @NotNull List<User> current) {
        int changed = 0;
        int deleted = 0;
        Map<Integer, String> curr = current.stream().collect(Collectors.toMap(user -> user.id, user -> user.name));
        for (User prevUser : previous) {
            String value = curr.get(prevUser.id);
            if (value == null) {
                deleted++;
            } else if (!value.equals(prevUser.name)) {
                changed++;
            }
        }
        int added = current.size() - previous.size() + deleted;
        return createInfo(added, changed, deleted);
    }

    private Info createInfo(int added, int changed, int deleted) {
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