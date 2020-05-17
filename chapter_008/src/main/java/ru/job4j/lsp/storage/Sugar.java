package ru.job4j.lsp.storage;

import java.time.LocalDate;

public class Sugar extends Food {
    public Sugar(String name, LocalDate createDate, LocalDate expireDate, double price) {
        super(name, createDate, expireDate, price);
    }
}
