package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.CartItemDaoImpl;
import com.ntiques.model.CartItem;

	@Service
	@Transactional
	public class CartItemService 
	{
		@Autowired (required=true)
		CartItemDaoImpl CartItemDao;
		
		public List<CartItem> listCartItems()
		{
			return CartItemDao.listCartItems();
		}
		
		public List<CartItem> getCartItemsByUserId(int userId)
		{
			return CartItemDao.getCartItemsByUserId(userId);
		}
		
		
		public void saveOrUpdate(CartItem cartitem)
		{
			CartItemDao.saveOrUpdate(cartitem);
		}
		
		public CartItem getCartItem(int cartitemid)
		{
			return CartItemDao.getCartItem(cartitemid);
		
		}
		
		public void delete(int cartitemid)
		{
			
			CartItemDao.delete(cartitemid);
			
			
		}
		
		

		
		

		

		
	}
