package com.dxctraining.item.dao;

import com.dxctraining.item.entites.Item;

public interface IItemDao {
	Item add(Item item);
	Item findItemById(int id);
		 void remove(int id);
}
