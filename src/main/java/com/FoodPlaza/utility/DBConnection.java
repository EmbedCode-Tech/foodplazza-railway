package com.FoodPlaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getDbConnection() {
        try {
            if (con == null || con.isClosed()) {

                String url = System.getenv("DB_URL");
                String user = System.getenv("DB_USER");
                String pass = System.getenv("DB_PASSWORD");

                if (url == null || user == null || pass == null) {
                    throw new RuntimeException("Database environment variables not set");
                }

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
