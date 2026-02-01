package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.pojo.Contactus;
import com.FoodPlaza.utility.DBConnection;

public class Contactus_Dao_impl implements ContactusDao {


	@Override
	public boolean addContact(Contactus c) {
		Connection con = DBConnection.getDbConnection();
		 String sql = "INSERT INTO contactus (custname, contact, custemailId, message, custAddress) VALUES (?, ?, ?, ?, ?)";
		 PreparedStatement ps= null;
		 try {
			ps = con.prepareStatement (sql);
			    ps.setString(1, c.getCustname());
	            ps.setString(2, c.getContact());
	            ps.setString(3, c.getCustemailId());
	            ps.setString(4, c.getMessage());
	            ps.setString(5, c.getCustAddress());

	            int i = ps.executeUpdate();
	            if(i>0) {
	            	return true;
	            }else {
	            	return false;
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Contactus> getAllContacts() {
		  List<Contactus> contactList = new ArrayList<>();
		  Connection con = DBConnection.getDbConnection();
		  String sql="select  * from contactus";
		  PreparedStatement ps= null;
		  try {
			ps = con.prepareStatement (sql);


			ResultSet rs = ps.executeQuery();

			 while (rs.next()) {
	                Contactus c = new Contactus();
	                c.setCustname(rs.getString("custname"));
	                c.setContact(rs.getString("contact"));
	                c.setCustemailId(rs.getString("custemailId"));
	                c.setMessage(rs.getString("message"));
	                c.setCustAddress(rs.getString("custAddress"));
	                contactList.add(c);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contactList;
	}


}
