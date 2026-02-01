package com.FoodPlaza.pojo;

public class Feedback {

	private int feedbackid ;
	private String custname;
	private String custContactNo;
	private String custemailId;
	private String feedback;
	private String foodTaste;
	private String serviceReview;
	
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustContactNo() {
		return custContactNo;
	}
	public void setCustContactNo(String custContactNo) {
		this.custContactNo = custContactNo;
	}
	public String getCustemailId() {
		return custemailId;
	}
	public void setCustemailId(String custemailId) {
		this.custemailId = custemailId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getFoodTaste() {
		return foodTaste;
	}
	public void setFoodTaste(String foodTaste) {
		this.foodTaste = foodTaste;
	}
	public String getServiceReview() {
		return serviceReview;
	}
	public void setServiceReview(String serviceReview) {
		this.serviceReview = serviceReview;
	}
	public int getFeedbackid() {
		return feedbackid;
	}
	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}


}
