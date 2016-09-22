package com.ntiques.dao;

import java.util.List;



import com.ntiques.model.Cart;
import com.ntiques.model.OrderedItems;

public interface CartDao
{
	public Cart getById(int id);

	void saveOrUpdate(Cart cart);
	
	
	
}
