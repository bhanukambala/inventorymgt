package com.dxctraining.item.service;

import com.dxctraining.item.entites.Item;

public interface IItemService {
	Item add(Item item);
	Item findItemById(int id);
		 void remove(int id);

}
