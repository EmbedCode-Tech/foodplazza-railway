package com.FoodPlaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getDbConnection() {
        try {
            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String db   = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db
                    + "?useSSL=false"
                    + "&allowPublicKeyRetrieval=true"
                    + "&serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("✅ DB CONNECTED TO RAILWAY");
            return con;

        } catch (Exception e) {
            System.out.println("❌ DB CONNECTION FAILED (RAILWAY)");
            e.printStackTrace();
            return null;
        }
    }
}
