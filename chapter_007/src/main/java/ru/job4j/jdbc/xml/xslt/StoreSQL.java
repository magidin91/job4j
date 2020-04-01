package ru.job4j.jdbc.xml.xslt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
        init();
    }

    /**
     * Метод устанавливает соединение с БД (SQLite)
     */
    public void init() {
        try {
            connect = DriverManager.getConnection(config.get("url"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создает таблицу, если она еще не создана, удаляет все записи и вносит N новых записей
     */
    public void generate(int size) {
        try {
            connect.setAutoCommit(false);
            try (Statement st1 = connect.createStatement()) {
                st1.addBatch("CREATE TABLE IF NOT EXISTS entry (field integer)");
                st1.addBatch("Delete from entry");
                st1.executeBatch();
            }
            try (PreparedStatement st2 = connect.prepareStatement("insert into entry values (?)")) {
                for (int i = 1; i <= size; i++) {
                    st2.setInt(1, i);
                    st2.addBatch();
                }
                st2.executeBatch();
                connect.commit();
            }
        } catch (SQLException e) {
            System.out.println("SQLException. Executing rollback");
            try {
                connect.rollback(); // в случае SQLException, возвращаем БД к исходному состоянию
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connect.setAutoCommit(true); //возвращаем режим автоматического коммита
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод возвращает список ентрис из БД
     */
    public List<Entry> load() {
        List<Entry> entries = new ArrayList<>();
        Entry element;
        try (Statement st = connect.createStatement()) {
            try (ResultSet rs = st.executeQuery("select* from entry")) {
                while (rs.next()) {
                    element = new Entry(rs.getInt("field"));
                    entries.add(element);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}