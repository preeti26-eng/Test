package com.itc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itc.bean.Card;
import com.itc.bean.Item;
import com.itc.bean.Order;

import com.itc.service.ShoppingService;



@Controller
public class ShoppingController {
	@Autowired
	private ShoppingService service;
	
//	@RequestMapping(value="/login")
//	public String Login(Model model) {
//		System.out.println("Login");
//		Login login = new Login();
//		model.addAttribute("login",login);
//		return "login";
//	}
	
//	@RequestMapping(value="/doLogin")
//	public int doLogin(Model model) {
//		System.out.println("Login complete");
//		Login login = new Login();
//		model.addAttribute("login",login);
//		return 0;
//		
//	}
	
	@RequestMapping(value="/proceed")
		public String showItems(Model model) {
		System.out.println("Proceed");
		List<Item> itemList = service.getItems();
		model.addAttribute("ilist", itemList);
		model.addAttribute("sitem", new Item());
		return "display";
	}
	@RequestMapping(value="/placeOrder")
	public String placeOrder(@ModelAttribute(value="sitem") Item item,  Model model){
		Item itm = service.getItem(item);
		System.out.println("Item from db:" +itm);
		if(itm!=null) {
			Card card = new Card();
			card.setItemId(item.getId());
			model.addAttribute("citem", card);
		}else {
			
		}
		return "order";
	}
	@RequestMapping(value="/buyItem")
	public String buyItem(@RequestParam("quantity")int quant,@ModelAttribute(value="citem")@Valid Card card, BindingResult bResult, Model model) {
		System.out.println("Card: " +card);
		if (bResult.hasErrors()) {
			return "card_fail";
		}
		Order order = service.buyItem(card,quant);
		System.out.println("Order " +order);
		if(order==null) {
			model.addAttribute("err", "card validation failed");
			return "fail";
		}
		model.addAttribute("oitem",order);
		return "success";
	}
}