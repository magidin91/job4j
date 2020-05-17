package ru.job4j.isp;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Menu implements IMenu {
    private final List<ParentActionMenuItem> items;
    private final Consumer<String> output;
    private final Supplier<String> input;
    private final Map<String, ParentActionMenuItem> allItems = new HashMap<>();


    public Menu(List<ParentActionMenuItem> items, Consumer<String> output, Supplier<String> input) {
        this.items = items;
        this.output = output;
        this.input = input;
    }

    public void activateMenu() {
        boolean run = true;
        while (run) {
            show(items);
            output.accept("====To finish enter \"exit\"====");
            output.accept("====Select menu item====");
            String answer = input.get();
            ParentActionMenuItem item = allItems.get(answer);
            if (item != null) {
                item.executeAction();
            } else if ("exit".equals(answer.toLowerCase())) {
                output.accept("====Bye====");
                run = false;
            } else {
                output.accept("====INCORRECT MENU ITEM!!!SELECT VALID ITEM====");
            }
        }
    }

    private void show(List<ParentActionMenuItem> items) {
        for (ParentActionMenuItem item : items) {
            if (item == null) {
                continue;
            }
            output.accept(item.getName());
            allItems.put(item.getName(), item);
            List<ParentActionMenuItem> innerItems = item.getChildren();
            if (innerItems != null) {
                show(innerItems);
            }
        }
    }

    /**
     * The example of the menu for visualization.
     */
    public static void main(String[] args) {
        ParentActionMenuItemImpl item11 = new ParentActionMenuItemImpl("1.1", () -> System.out.println("it's working"),
                List.of(new ParentActionMenuItemImpl("1.1.1", () -> System.out.println("it's working"), null),
                        new ParentActionMenuItemImpl("1.1.2", () -> System.out.println("it's working"), null)));
        ParentActionMenuItemImpl item12 = new ParentActionMenuItemImpl("1.2", () -> System.out.println("it's working"),
                List.of(new ParentActionMenuItemImpl("1.2.1", null), new ParentActionMenuItemImpl("1.2.2", null)));
        ParentActionMenuItemImpl item1 = new ParentActionMenuItemImpl("1.", List.of(item11, item12));
        ParentActionMenuItemImpl item21 = new ParentActionMenuItemImpl("2.1",
                List.of(new ParentActionMenuItemImpl("2.1.1", null), new ParentActionMenuItemImpl("2.1.2", null)));
        ParentActionMenuItemImpl item22 = new ParentActionMenuItemImpl("2.2", List.of(new ParentActionMenuItemImpl("2.2.1", null),
                new ParentActionMenuItemImpl("2.2.2", null)));
        ParentActionMenuItemImpl item2 = new ParentActionMenuItemImpl("2.", Arrays.asList(item21, item22));

        new Menu(List.of(item1, item2), System.out::println, () -> new Scanner(System.in).nextLine()).activateMenu();
    }
}
