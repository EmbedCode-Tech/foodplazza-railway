package com.FoodPlaza.dao;
import java.util.List;

import com.FoodPlaza.pojo.Contactus;



public interface ContactusDao {

	boolean addContact(Contactus c);
	List<Contactus> getAllContacts();

}
