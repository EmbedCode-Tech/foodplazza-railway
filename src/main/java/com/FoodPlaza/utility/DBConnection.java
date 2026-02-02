package com.FoodPlaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
        "jdbc:mysql://gondola.proxy.rlwy.net:45849/FoodPlaza"
        + "?useSSL=false"
        + "&allowPublicKeyRetrieval=true"
        + "&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "DbMPsauaeqoyfHoLVyGfNbSJfLDZpiPd";

    public static Connection getDbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ DB CONNECTED");
            return con;
        } catch (Exception e) {
            System.out.println("❌ DB CONNECTION FAILED");
            e.printStackTrace();
            return null;
        }
    }
}
