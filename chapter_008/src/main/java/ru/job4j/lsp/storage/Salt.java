package ru.job4j.lsp.storage;

import java.time.LocalDate;

public class Salt extends Food {
    public Salt(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
    }
}
