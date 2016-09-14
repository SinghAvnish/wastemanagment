package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.CartItem;
import com.ntiques.model.Category;
import com.ntiques.model.Product;

import java.util.List;


public interface CartItemDao
{
public void saveOrUpdate(CartItem cartitem);


public List<CartItem> list();
}
