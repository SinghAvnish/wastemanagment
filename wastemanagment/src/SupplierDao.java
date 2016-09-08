package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.Supplier;

public interface SupplierDao {
	
	public List<Supplier> list();
	
	public void saveOrUpdate(Supplier supplier);

}
