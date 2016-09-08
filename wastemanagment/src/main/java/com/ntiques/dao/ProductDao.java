package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.Product;


	public interface ProductDao
	{
	public void saveOrUpdate(Product product);

	public void delete(String id);

	public Product get(String id);
	
	public Product getView(String id);


	public Product getByName(String name);



	public List<Product> list();
	}


