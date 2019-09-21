package com.itc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.bean.Card;
import com.itc.bean.Item;
import com.itc.bean.Order;
import com.itc.dao.ShoppingDao;
@Transactional
@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private ShoppingDao sDao;
	@Autowired
	private CardService cardService;
	@Override
	public List<Item> getItems() {
		return sDao.getItems();
	}
	@Override
	public Item getItem(Item item) {
		return sDao.getItem(item);
	}
	@Override
	public Order buyItem(Card card,int quant) {
		boolean cardValid = cardService.validateCard(card);
		if(cardValid) {
			return sDao.buyItem(card,quant);
		}
		// TODO Auto-generated method stub
		return null;
	}

}
