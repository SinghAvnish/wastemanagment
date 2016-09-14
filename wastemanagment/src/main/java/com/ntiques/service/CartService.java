package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.CartDaoImpl;
import com.ntiques.model.Cart;
import com.ntiques.model.Product;



	@Service
	@Transactional
	public class CartService {
	@Autowired
	CartDaoImpl CartDao;
		
		
		

		public Cart getById(int userId){
			return CartDao.getById(userId);
		
		}
		
		  public int Cart(int userid)
			{
				return CartDao.getById(userid).getCartId();
			}
		

	}
