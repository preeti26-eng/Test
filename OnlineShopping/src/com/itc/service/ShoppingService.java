package com.itc.service;

import java.util.List;

import com.itc.bean.Card;
import com.itc.bean.Item;
import com.itc.bean.Order;

public interface ShoppingService {

	List<Item> getItems();

	Item getItem(Item item);

	

	Order buyItem(Card card,int quant);

}
