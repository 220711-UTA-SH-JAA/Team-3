package com.example.dao;

import java.util.List;

import com.example.models.Item;

public interface ItemDao {
	
	List<Item> getAllItems();
	
	Item getItemByName(String itemName);
	
}
