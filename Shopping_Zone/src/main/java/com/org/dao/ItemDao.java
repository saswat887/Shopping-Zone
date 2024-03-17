package com.org.dao;

import java.util.List;

import com.org.dto.Item;

public interface ItemDao {
	void saveAndUpdateItem(Item item);
	Item fetchItemById(int id);
	List<Item> fetchAllItems();
	void deleteItems(int id);
	void stockLeft(int id);
	

}
