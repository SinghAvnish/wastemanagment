package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.CartItemDaoImpl;
import com.ntiques.dao.CategoryDaoImpl;
import com.ntiques.model.CartItem;
import com.ntiques.model.Category;
import com.ntiques.model.Product;

	@Service
	@Transactional
	public class CartItemService {
		@Autowired
	CartItemDaoImpl CartItemDao;
		public List<CartItem> list()
		{
			return CartItemDao.list();
		}
		public void saveOrUpdate(CartItem cartitem)
		{
			CartItemDao.saveOrUpdate(cartitem);
		}
		
		
	}
