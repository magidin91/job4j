package ru.job4j.collection;

import java.util.Comparator;

/**
 * Собственный метод сортировки строк
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int length = left.length();
        if (left.length() > right.length()) {
            length = right.length();
            rsl = 1;
        } else if (left.length() < right.length()) {
            rsl = -1;
        }
        for (int i = 0; i < length; i++) {
            if (left.charAt(i) > right.charAt(i)) {
                return 1;
            }
            if (left.charAt(i) < right.charAt(i)) {
                return -1;
            }
        }
        return rsl;
    }
}