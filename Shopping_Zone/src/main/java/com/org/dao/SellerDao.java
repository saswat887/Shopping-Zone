package com.org.dao;

import com.org.dto.Seller;
import com.org.dto.User;

public interface SellerDao {
	void saveSeller(Seller seller);
	Seller fetchSellerByEmailAndPassword(String email,String password);
	Seller fetchSellerById(int id);
}
