package com.FoodPlaza.dao;

import java.util.List;

import com.FoodPlaza.pojo.Cart;

public interface CartDao {

	boolean addToCart(Cart cart);
	List<Cart>showCartList(String emailId);
	Cart searchCartById(int cartId);
	boolean deleteItemFromCart(int cartId);
	boolean updateQuntity(int cartId,int fquantity);
	boolean  clearCartByEmail(String email);
}
