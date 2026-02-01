package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.pojo.Cart;
import com.FoodPlaza.pojo.Food;
import com.FoodPlaza.utility.DBConnection;



public class Cart_Dao_impl implements CartDao {

	Food f= new Food();



	@Override
	public boolean addToCart(Cart cart) {
		Connection con = DBConnection.getDbConnection();
		String sql="insert into cart_ctol18 (foodId , foodPrice , foodQuantity , totalPrice , emailId , foodName) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			Food f = new Food_Dao_impl().searchFood(cart.getFoodId());
			ps.setInt(1, cart.getFoodId());
			ps.setDouble(2, f.getFoodprice());
			ps.setInt(3, cart.getFoodquantity());
			double Totalprice = f.getFoodprice() * cart.getFoodquantity();
			ps.setDouble(4, Totalprice);
			ps.setString(5, cart.getEmailId());
			ps.setString(6, f.getFoodname());

			int i= ps.executeUpdate();
		   return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Cart> showCartList(String emailId) {
		Connection con = DBConnection.getDbConnection();
		List<Cart> list = new ArrayList<>();
		String sql="select * from cart_ctol18 where emailId=? ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,emailId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Cart c = new Cart();
				c.setFoodId(rs.getInt(1));
				c.setCartId(rs.getInt(2));
				c.setFoodprice(rs.getDouble(3));
				c.setFoodquantity(rs.getInt(4));
				c.setTotalprice(rs.getDouble(5));
				c.setEmailId(rs.getString(6));
				c.setFoodname(rs.getString(7));
				list.add(c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public Cart searchCartById(int cartId) {
		Cart c =null;
		Connection con = DBConnection.getDbConnection();
		String sql="Select * from cart_ctol18 where cartId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,cartId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				c= new Cart();
				c.setCartId(rs.getInt("CartId:"));
				c.setFoodId(rs.getInt("FoodId:"));
				c.setFoodprice(rs.getDouble("FoodPrice:"));
				c.setFoodquantity(rs.getInt("FoodQuantity:"));
				c.setTotalprice(rs.getDouble("Totalprice:"));
				c.setEmailId(rs.getString("EmailId:"));
				c.setFoodname(rs.getString("FoodName:"));


			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}


	@Override
	public boolean deleteItemFromCart(int cartId) {
		Connection con = DBConnection.getDbConnection();
		String sql="delete from cart_ctol18 where cartId=?";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,cartId);
				int rs= ps.executeUpdate();
				   return rs>0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}


	@Override
	public boolean updateQuntity(int cartid, int fquantity) {
		Connection con = DBConnection.getDbConnection();
		 String sql = "UPDATE cart_ctol18 SET foodQuantity=?, totalPrice=foodPrice*? WHERE cartId=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, fquantity);
	            ps.setInt(2, fquantity);
	            ps.setInt(3, cartid);

	            return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean clearCartByEmail(String email) {
		  Connection con = DBConnection.getDbConnection();
		  String sql = "delete from cart_ctol18 where emailId= ?";
          try {
			PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, email);
	            ps.executeUpdate();
	            System.out.println("Cart cleared for " + email);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}


