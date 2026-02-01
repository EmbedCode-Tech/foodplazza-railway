package com.FoodPlaza.dao;

import java.util.List;

import com.FoodPlaza.pojo.Feedback;

public interface FeedbackDao {

	boolean addFeedback(Feedback f);
	List<Feedback> getAllFeedback();
}
