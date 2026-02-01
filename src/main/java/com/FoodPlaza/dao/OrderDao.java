package com.FoodPlaza.dao;

import java.util.List;

import com.FoodPlaza.pojo.Order;

public interface OrderDao {

	boolean placeOrder(String emailId);
	Order showOrderByEmailId(String emailId);
    public List<Order> showAllOrders();
	boolean changeOrderStatus(String orderStatus,int orderId);
	boolean deleteOrder(int orderId);
	List<Order> showMyOrderHistery(String emailId);
	boolean updateOrdersToDeliveredAfterOneHour();
}
