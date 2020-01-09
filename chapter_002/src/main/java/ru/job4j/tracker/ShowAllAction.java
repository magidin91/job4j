package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter name: ");
        for (Item element : tracker.findAll()) { //выводим элементы
            System.out.println(element);
        }
        return true;
    }
}
