package com.FoodPlaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;
public static Connection getDbConnection() {
    try {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String pass = System.getenv("DB_PASSWORD");

        System.out.println("DB_URL = " + url);
        System.out.println("DB_USER = " + user);
        System.out.println("DB_PASSWORD = " + (pass != null));

        if (url == null || user == null || pass == null) {
            throw new RuntimeException("ENV VARIABLES ARE NULL");
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        System.out.println("✅ DATABASE CONNECTED SUCCESSFULLY");

    } catch (Exception e) {
        e.printStackTrace();
    }
    return con;
}

}
