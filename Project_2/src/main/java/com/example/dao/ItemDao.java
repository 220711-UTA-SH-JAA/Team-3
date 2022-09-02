package com.example.dao;

import java.util.List;

import com.example.models.Item;

public interface ItemDao {

	//CREATE	
	void createItem(Item i);
	
	//READ
	Item selectItemById(int id );
	
	List<Item> readAllItems();
	
	Item selectItemByName(String itemName);
	
	//UPDATE
	void updateItem(Item p);
	
	//DELETE
	void deleteItem(Item p);
	
}
