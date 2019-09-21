package com.itc.dao;

import java.util.List;

import com.itc.bean.Card;
import com.itc.bean.Item;
import com.itc.bean.Order;

public interface ShoppingDao {

	List<Item> getItems();

	

	Item getItem(Item item);



	Order buyItem(Card card,int quant);

}
