package com.FoodPlaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.pojo.Feedback;
import com.FoodPlaza.utility.DBConnection;

public class Feedback_Dao_impl implements FeedbackDao{

	@Override
	public boolean addFeedback(Feedback f) {
		Connection con = DBConnection.getDbConnection();
        String sql = "insert into feedback (custname, custContactNo, custemailId, feedback, foodTaste, serviceReview) values (?, ?, ?, ?, ?, ?)";
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			  ps.setString(1, f.getCustname());
	            ps.setString(2, f.getCustContactNo());
	            ps.setString(3, f.getCustemailId());
	            ps.setString(4, f.getFeedback());
	            ps.setString(5, f.getFoodTaste());
	            ps.setString(6, f.getServiceReview());

	            int rs = ps.executeUpdate();
	            if(rs>0){
	            	return true;
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		 List<Feedback> feedbackList = new ArrayList<>();
		Connection con = DBConnection.getDbConnection();
		 String sql = "select * from  feedback";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

		   while(rs.next()) {
				 Feedback fb = new Feedback();
	                fb.setFeedbackid(rs.getInt("feedback_id"));
	                fb.setCustname(rs.getString("custname"));
	                fb.setCustContactNo(rs.getString("custContactNo"));
	                fb.setCustemailId(rs.getString("custemailId"));
	                fb.setFeedback(rs.getString("feedback"));
	                fb.setFoodTaste(rs.getString("foodTaste"));
	                fb.setServiceReview(rs.getString("serviceReview"));
	                feedbackList.add(fb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return feedbackList;
	}

}
