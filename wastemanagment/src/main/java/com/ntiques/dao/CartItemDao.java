package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.CartItem;

public interface CartItemDao
{
	
	void saveOrUpdate(CartItem cartItem);

	void delete(int cartitemid);

	CartItem getCartItem(int cartitemid);

	List<CartItem> getCartItemsByUserId(int userId);
	
	List<CartItem> getCartItemsByUser(int cartid);
	
	List<CartItem> listCartItems();

}
