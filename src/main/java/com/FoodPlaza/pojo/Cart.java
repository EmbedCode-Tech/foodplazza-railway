package com.FoodPlaza.pojo;

public class Cart {


	private int foodId;
	private int cartId;
	private double foodprice;
	private int foodquantity;
	private double totalprice;
	private String emailId;
	private String foodname;


	public Cart() {}


	public Cart(int foodId, int cartId, double foodprice, int foodquantity, double totalprice, String emailId,
			String foodname) {
		super();
		this.foodId = foodId;
		this.cartId = cartId;
		this.foodprice = foodprice;
		this.foodquantity = foodquantity;
		this.totalprice = totalprice;
		this.emailId = emailId;
		this.foodname = foodname;
	}


	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public double getFoodprice() {
		return foodprice;
	}


	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}


	public int getFoodquantity() {
		return foodquantity;
	}


	public void setFoodquantity(int foodquantity) {
		this.foodquantity = foodquantity;
	}


	public double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getFoodname() {
		return foodname;
	}


	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}


	@Override
	public String toString() {
		return "Cart [foodId=" + foodId + ", cartId=" + cartId + ", foodprice=" + foodprice + ", foodquantity="
				+ foodquantity + ", totalprice=" + totalprice + ", emailId=" + emailId + ", foodname=" + foodname + "]";
	}



}


