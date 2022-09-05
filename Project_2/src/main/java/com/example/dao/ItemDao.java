package com.example.dao;

import java.util.List;

import com.example.models.Item;

public interface ItemDao {

	//CREATE	
	void createItem(Item i);
	
	//READ
	Item getItemById(int id );
	
	List<Item> getAllItems();
	
	Item getItemByName(String itemName);
	
	//UPDATE
	void updateItem(Item p);
	
	//DELETE
	void deleteItem(Item p);
	
}
