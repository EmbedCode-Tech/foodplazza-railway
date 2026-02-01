package com.FoodPlaza.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection con=null;

	public static Connection getDbConnection() {
		String url ="jdbc:mysql://gondola.proxy.rlwy.net:45849/mysql";
		String user = "root";
		String password = "DbMPsauaeqoyfHoLVyGfNbSJfLDZpiPd";


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con =DriverManager.getConnection(url , user , password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;


	}

}
