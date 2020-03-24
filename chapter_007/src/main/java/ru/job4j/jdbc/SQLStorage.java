package ru.job4j.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class SQLStorage {
    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_from_z";
        String username = "postgres";
        String password = "password";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("insert into users (login, password,create_date) values (?, ?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "userJavanew");
            st.setString(1, "parolnew");
            st.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
           st.executeUpdate();
          ResultSet generatedKeys = st.getGeneratedKeys();
           if (generatedKeys.next()) {
               System.out.println(generatedKeys.getInt(1));
           }
//            PreparedStatement st = conn.prepareStatement("SELECT*FROM users as u WHERE u.id in (?,?)");
//            st.setInt(1, 2);
//            st.setInt(2, 3);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                System.out.println(String.format("%s %s", rs.getString("login"),
//                        rs.getTimestamp("create_date")));
//
//            }
//            rs.close();
//            st.close();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
}

