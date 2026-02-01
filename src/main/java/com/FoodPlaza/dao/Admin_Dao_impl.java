package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.FoodPlaza.pojo.Admin;
import com.FoodPlaza.utility.DBConnection;



public class Admin_Dao_impl implements AdminDao{

	public static void main(String[] args) {


	}


	@Override
	public boolean login(String adminname, String adminpassword) {
		Connection con = DBConnection.getDbConnection();
		String sql= "select * from admin_ctol18 where adminName=? and adminPassword=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, adminname);
			ps.setString(2, adminpassword);

			ResultSet rs= ps.executeQuery();
			return rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean addAdmin(Admin admin) {
		Connection con = DBConnection.getDbConnection();
		String sql = "insert into admin_ctol18 (adminname,adminpassword) values(?,?) ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getAdminname());
			ps.setString(2, admin.getAdminpassword());

			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public Admin getAdminByName(String adminName) {
		Admin admin =null;
		Connection con = DBConnection.getDbConnection();
		String sql = "select * from admin_ctol18 where adminname=? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,adminName);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				admin = new Admin();
				admin.setAdminname(rs.getString("adminname"));
				admin.setAdminpassword(rs.getString("adminpassword"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return admin;
	}


	@Override
	public boolean customerlogin(String emailId, String custpassword) {
		Connection con = DBConnection.getDbConnection();
		String sql="select * from customer_ctol18 where emailId=? and custPassword=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,emailId);
			ps.setString(2,custpassword);
			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
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
	public boolean changeCustomerPass(String emailId, String newPassword) {
		Connection con = DBConnection.getDbConnection();
		String  sql ="update customer_ctol18 set custPassword=? where emailId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,newPassword);
			ps.setString(2,emailId);

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
	public boolean changeAdminPass(String adminname, String adminNewPassword) {
		Connection con = DBConnection.getDbConnection();
		String sql="update admin_ctol18 set adminPassword=? where adminName=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,adminNewPassword);
			ps.setString(2,adminname);

			int i= ps.executeUpdate();
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

}


