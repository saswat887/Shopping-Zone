package com.org.dao;

import java.util.List;

import com.org.dto.Item;
import com.org.dto.Product;

public interface ProductDao {
	void saveAndUpdateProduct(Product product);
	Product fetchProductById(int id);
	List<Product> fetchAllProduct();
	void deletePersonById(int id);
}
