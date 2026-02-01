package com.FoodPlaza.pojo;

public class Food {

	private int foodid;
	private String foodname;
	private String foodtype;
	private String foodcategory;
	private double foodprice;

	public Food() {}

	public Food(int foodid, String foodname, String foodtype, String foodcategory, double foodprice) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.foodtype = foodtype;
		this.foodcategory = foodcategory;
		this.foodprice = foodprice;
	}

	public int getFoodid() {
		return foodid;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}

	public String getFoodcategory() {
		return foodcategory;
	}

	public void setFoodcategory(String foodcategory) {
		this.foodcategory = foodcategory;
	}

	public double getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}


	@Override
	public String toString() {
	    return "Food ID: " + foodid +
	           ", Name: " + foodname +
	           ", Type: " + foodtype +
	           ", Category: " + foodcategory +
	           ", Price:" + foodprice;

	}





}

