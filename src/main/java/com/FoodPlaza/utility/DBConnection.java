package com.FoodPlaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getDbConnection() {
        try {
            if (con == null || con.isClosed()) {

                String url = "jdbc:mysql://gondola.proxy.rlwy.net:45849/mysql"
                           + "?useSSL=false"
                           + "&allowPublicKeyRetrieval=true"
                           + "&serverTimezone=UTC";

                String user = "root";
                String password = "DbMPsauaeqoyfHoLVyGfNbSJfLDZpiPd";

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
