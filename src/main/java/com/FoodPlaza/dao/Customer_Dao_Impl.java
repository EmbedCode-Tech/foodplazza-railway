package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.pojo.Customer;
import com.FoodPlaza.utility.DBConnection;

public class Customer_Dao_Impl implements CustomerDao{



	@Override
	public boolean addCustomer(Customer cust) {

		Connection con = DBConnection.getDbConnection();
		if(con==null) {
			 System.out.println("Connection is not successful");
			 return false;
		}
		String sql = "insert into customer_ctol18 (custname , emailId, custPassword, custAddress,custContactNo, custLocation) values(?,?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ps.setString(1, cust.getCustname());
			ps.setString(2, cust.getEmailId());
			ps.setString(3, cust.getCustPassword());
			ps.setString(4, cust.getCustAddress());
			ps.setString(5, cust.getCustContactNo());
			ps.setString(6, cust.getCustLocation());

			int i = ps.executeUpdate();

			if(i>0) {
				return true;
			} else {
				return false;
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return false;
	}




	@Override
	public Customer getCustomerByEmail(String email) {
		Connection con = DBConnection.getDbConnection();
		String sql = "select * from customer_ctol18 where emailId=?";
		Customer cust = null;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				cust = new Customer();
				cust.setCustname(rs.getString(1));
				cust.setEmailId(rs.getString(2));
				cust.setCustPassword(rs.getString(3));
				cust.setCustAddress(rs.getString(4));
				cust.setCustContactNo(rs.getString(5));
				cust.setCustLocation(rs.getString(6));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return cust;
	}


	@Override
	public List<Customer> getAllCustomer() {
		Connection con = DBConnection.getDbConnection();
		String sql = "select * from customer_ctol18";
		List<Customer> list = new ArrayList<>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Customer cust = new Customer();
				cust = new Customer();
				cust.setCustname(rs.getString(1));
				cust.setEmailId(rs.getString(2));
				cust.setCustPassword(rs.getString(3));
				cust.setCustAddress(rs.getString(4));
				cust.setCustContactNo(rs.getString(5));
				cust.setCustLocation(rs.getString(6));
				list.add(cust);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return list;
	}



	@Override
	public boolean updateCustomer(String email,Customer Cust) {
		Connection con = DBConnection.getDbConnection();
		String sql = "update  customer_ctol18 set custName =?, custAddress=?, custPassword=?, custcontactno=?, custLocation=?  where emailId=? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, Cust.getCustname());
			ps.setString(2, Cust.getCustAddress());
			ps.setString(3, Cust.getCustPassword());
			ps.setString(4, Cust.getCustContactNo());
			ps.setString(5, Cust.getCustLocation());
			ps.setString(6,email);


			int result =  ps.executeUpdate();
			return result>0;



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public boolean deleteCustomer(String email) {
		Connection con = DBConnection.getDbConnection();
		String sql = "delete from customer_ctol18 where emailId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,email);

			int result= ps.executeUpdate();
			return result>0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}












}






