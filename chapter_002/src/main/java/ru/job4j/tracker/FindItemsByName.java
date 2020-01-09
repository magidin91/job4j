package ru.job4j.tracker;

public class FindItemsByName implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        for (Item element : tracker.findByName(name)) { //выводим элементы
            System.out.println(element);
        }
        return true;
    }
}
