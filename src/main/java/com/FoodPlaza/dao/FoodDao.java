package com.FoodPlaza.dao;

import java.util.List;

import com.FoodPlaza.pojo.Food;

public interface FoodDao {

	public boolean addFood(Food food);
	public List<Food> getAllFood();
	public boolean updateFood(int foodId,Food food);
	public boolean deleteFood(int foodId);
	public Food searchFood(int foodid);
	public Food getfoodbyid(int foodid);

}
