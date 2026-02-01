package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.pojo.Order;
import com.FoodPlaza.utility.DBConnection;



public class Order_Dao_impl {

	double Totalbill=0;


	public boolean placeOrder(String emailId) {
		Connection con =DBConnection.getDbConnection();
//		LocalDateTime dt = LocalDateTime.now();
		LocalDate localDate = LocalDate.now();
		Date sqlDate = Date.valueOf(localDate);
//		DateTimeFormatter  format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		String formattedDateTime=dt.format(format);



		Totalbill= calculateBill(emailId);
		String sql="insert into order_ctol18 (orderDate,totalBill,emailId,orderStatus) values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setDate(1,dt.toLocalDate());


			ps.setDate(1, sqlDate);
			ps.setDouble(2,Totalbill);
			ps.setString(3,emailId);
			ps.setString(4,"Processing..");


			int i=ps.executeUpdate();

			if(i>0) {

				new Cart_Dao_impl().clearCartByEmail(emailId);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private double calculateBill(String emailId) {
		Connection con =DBConnection.getDbConnection();
		String sql ="select totalPrice from cart_ctol18 where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,emailId);

			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Totalbill+=rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Totalbill;
	}


	public List<Order> showOrderByEmailId(String emailId) {
		Order order =null;
		List<Order> orderList = new ArrayList<>();
		Connection con =DBConnection.getDbConnection();
		String sql = "select * from order_ctol18 where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,emailId);

			ResultSet rs=ps.executeQuery();

			if(rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setOrderDate(rs.getDate(2));
				order.setTotalBill(rs.getDouble(3));
				order.setEmailId(emailId);
				order.setOrderStatus(rs.getString(5));
				orderList.add(order);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}


	public List<Order> showAllOrders() {
		Connection con =DBConnection.getDbConnection();
		String sql = "select * from order_ctol18";
		List<Order> li = new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getDate(2));
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				li.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return li;
	}


	public boolean changeOrderStatus(String orderStatus, int orderId) {
		Connection con =DBConnection.getDbConnection();
		String sql = "update order_ctol18 set orderStatus=? where orderId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,orderStatus);
			ps.setInt(2,orderId);

			int i=ps.executeUpdate();
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

	public boolean deleteOrder(int orderId) {
		Connection con =DBConnection.getDbConnection();
		String sql="delete from order_ctol18 where orderId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,orderId);

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


	public List<Order> showMyOrderHistery(String emailId) {
		Connection con =DBConnection.getDbConnection();
		List<Order> li = new ArrayList<>();
		String sql="select * from order_ctol18 where emailId=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,emailId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Order o =new Order();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getDate(2));
				o.setTotalBill(rs.getDouble(3));
				o.setEmailId(rs.getString(4));
				o.setOrderStatus(rs.getString(5));
				li.add(o);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}
	public void updateOrdersToDeliveredAfterOneHour() {
	    Connection con = DBConnection.getDbConnection();
	    String sql = "UPDATE order_ctol18 SET orderStatus = 'Delivered' " +
	                 "WHERE orderStatus = 'Processing' AND TIMESTAMPDIFF(MINUTE, orderTime, NOW()) >= 60";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}



