package com.example.service;

import java.util.List;

import com.example.dao.ItemDao;
import com.example.models.Item;

public class ItemService {
	
	private ItemDao itemDao;
	public ItemService(ItemDao itemDao){
			this.itemDao = itemDao;
	}
	
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}
	
	public Item getItemByName(String name) {
		return itemDao.getItemByName(name);
	}

}
