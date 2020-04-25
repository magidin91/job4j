package ru.job4j.design.isp;

import java.util.List;

public interface ParentActionMenuItem extends ActionMenuItem {
    List<ParentActionMenuItem> getChildren();
}