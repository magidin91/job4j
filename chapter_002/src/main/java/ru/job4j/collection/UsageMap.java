package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("222@yandex.ru", "Ivan Ivanov");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("parsentev@yandex.ru", "Not Petr Arsentev");
        System.out.println(map);
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
        map.remove("parsentev@yandex.ru");
        for (Map.Entry<String, String> entry : map.entrySet()) { // метод entrySet() вернет коллекцию java.util.Set состоящую из объектов Map.Entry,
            // у которых есть метод
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}