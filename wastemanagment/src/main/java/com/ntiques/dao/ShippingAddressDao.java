package com.ntiques.dao;


import com.ntiques.model.ShippingAddress;

public interface ShippingAddressDao {

	void saveOrUpdate(ShippingAddress shippingAddress);
	
	void deleteShippingAddress(int shippingAddressId);
	
	ShippingAddress getShippingAddress(int shippingAddressId);
}

