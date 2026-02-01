package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.pojo.Food;
import com.FoodPlaza.utility.DBConnection;


public class Food_Dao_impl implements FoodDao{


	@Override
	public boolean addFood(Food food) {
		Connection con = DBConnection.getDbConnection();
		String sql="insert into food_ctol18(foodName ,foodType ,foodCategory ,foodPrice) values(?,?,?,?)";
		PreparedStatement ps= null;
		try {
			ps = con.prepareStatement (sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.setString(1, food.getFoodname());
			ps.setString(2, food.getFoodtype());
			ps.setString(3, food.getFoodcategory());
			ps.setDouble(4, food.getFoodprice());

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
	public List<Food> getAllFood() {
	Connection con = DBConnection.getDbConnection();
	String sql = "select * from food_ctol18";
	List<Food> li = new ArrayList<>();
	try {

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();


		while(rs.next()) {
			Food f = new Food();
			f.setFoodid(rs.getInt(1));
			f.setFoodname(rs.getString(2));
			f.setFoodtype(rs.getString(3));
			f.setFoodcategory(rs.getString(4));
			f.setFoodprice(rs.getDouble(5));
			li.add(f);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


		return li;
	}


	@Override
	public boolean updateFood(int foodId,Food food) {
		Connection con = DBConnection.getDbConnection();
		String sql = "update food_ctol18 set foodName = ?, foodType = ?, foodCategory = ?, foodPrice = ? where foodId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, food.getFoodname());
			ps.setString(2, food.getFoodtype());
			ps.setString(3, food.getFoodcategory());
			ps.setDouble(4, food.getFoodprice());
			ps.setInt(5,foodId);

			int result = ps.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		Connection con = DBConnection.getDbConnection();
		String sql = "Delete from food_ctol18 where foodId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,foodId);
			int result = ps.executeUpdate();

			return result > 0;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}


	@Override
	public Food searchFood(int foodId) {
		Food food = null;
		Connection con = DBConnection.getDbConnection();
		String sql = "select * from food_ctol18 where foodId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,foodId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				food =new Food();

				food.setFoodid(rs.getInt("foodId"));
				food.setFoodname(rs.getString("foodName"));
				food.setFoodtype(rs.getString("foodType"));
				food.setFoodcategory(rs.getString("foodCategory"));
				food.setFoodprice(rs.getDouble("foodPrice"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return food;
	}


	@Override
	public Food getfoodbyid(int foodid) {
		Food food = null;
		Connection con = DBConnection.getDbConnection();
		String sql = "select * from food_ctol18 where foodId=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			 ps.setInt(1, foodid);

			  ResultSet rs = ps.executeQuery();
			  if (rs.next()) {
				 food =new Food();
		            food = new Food();
		            food.setFoodid(rs.getInt("foodId"));
		            food.setFoodname(rs.getString("foodName"));
		            food.setFoodtype(rs.getString("foodType"));
		            food.setFoodcategory(rs.getString("foodCategory"));
		            food.setFoodprice(rs.getDouble("foodPrice"));
		        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}






}


