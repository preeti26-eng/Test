package com.itc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.itc.bean.Card;
@Transactional
@Service
public class CardService {

	public boolean validateCard(Card card) {
		boolean valid=false;
		valid = true;
		return valid;
	}

}
