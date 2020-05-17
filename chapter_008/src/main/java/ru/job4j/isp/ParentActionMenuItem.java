package ru.job4j.isp;

import java.util.List;

public interface ParentActionMenuItem extends ActionMenuItem {
    List<ParentActionMenuItem> getChildren();
}