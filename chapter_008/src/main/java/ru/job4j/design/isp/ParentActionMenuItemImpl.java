package ru.job4j.design.isp;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ParentActionMenuItemImpl implements ParentActionMenuItem {
    private final String name;
    private final List<ParentActionMenuItem> children;
    private final MenuAction action;

    public ParentActionMenuItemImpl(String name, List<ParentActionMenuItem> children) {
        this.name = name;
        this.action = () -> {
        };
        this.children = children;

    }

    public ParentActionMenuItemImpl(String name, @NotNull MenuAction action, List<ParentActionMenuItem> items) {
        this.name = name;
        this.action = action;
        this.children = items;
    }

    @Override
    public void executeAction() {
        action.act();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<ParentActionMenuItem> getChildren() {
        return children;
    }
}
