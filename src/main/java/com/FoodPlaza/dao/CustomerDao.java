package com.FoodPlaza.dao;

import java.util.List;

import com.FoodPlaza.pojo.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer cust);
	public Customer getCustomerByEmail(String email);
	public List<Customer> getAllCustomer();
	boolean updateCustomer(String email,Customer Cust);
	boolean deleteCustomer(String email);
}
