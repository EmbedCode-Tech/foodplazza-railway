package com.FoodPlaza.pojo;

import java.util.Date;

public class Order {


	private int orderId;
	private Date orderDate;
	private double totalBill;
	private String emailId;
	private String orderStatus;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalBill=" + totalBill + ", emailId="
				+ emailId + ", orderStatus=" + orderStatus + "]";
	}

	public Order() {}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(int orderId, Date orderDate, double totalBill, String emailId) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalBill = totalBill;
		this.emailId = emailId;

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


}


