package com.itc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.itc.bean.Card;
import com.itc.bean.Item;
import com.itc.bean.Order;

@Transactional
@Repository
public class ShoppingDaoImpl implements ShoppingDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Item> getItems() {
		List<Item> itemList = new ArrayList<>();
		// itemList.add(new Item());
		String qry = "select itm from Item itm";
		try {
			TypedQuery<Item> query = em.createQuery(qry, Item.class);
			itemList = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error fteching data");
		}
		return itemList;
	}

	@Override
	public Item getItem(Item item) {
		Item itm = em.find(Item.class, item.getId());
		return itm;
	}

	@Override
	public Order buyItem(Card card, int quant) {
		Order order = new Order();
		Item itm = em.find(Item.class, card.getItemId());
		itm.setQuantity(itm.getQuantity()-quant);
		em.merge(itm);
		System.out.println("Item :" + itm);
		order.setCustName(card.getName());
		order.setItemId(itm.getId());
		order.setPurchaseDate(new Date());
		order.setQuantity(card.getQuantity());
		order.setCustMobile(card.getMobile());
		em.persist(order);
		System.out.println("Order: " + order);
		return order;
	}

	
}
