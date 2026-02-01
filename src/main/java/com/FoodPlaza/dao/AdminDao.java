package com.FoodPlaza.dao;

import com.FoodPlaza.pojo.Admin;

public interface AdminDao {

	boolean login(String adminname, String adminpassword);

	boolean addAdmin(Admin admin);

	Admin getAdminByName(String adminName);

	boolean customerlogin(String emailId, String custpassword);

	boolean changeCustomerPass(String emailId, String newPassword);

	boolean changeAdminPass(String adminname, String adminNewPassword);
}
