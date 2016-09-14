package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.Product;


	public interface ProductDao
	{
	public void saveOrUpdate(Product product);

	public void delete(int id);

	public Product get(int id);
	
	public Product getView(int id);


	public Product getByName(String name);



	public List<Product> list();
	}


