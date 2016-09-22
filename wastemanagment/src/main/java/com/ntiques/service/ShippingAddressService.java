package com.ntiques.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ntiques.dao.BillingAddressDaoImpl;
import com.ntiques.dao.ShippingAddressDaoImpl;
import com.ntiques.model.BillingAddress;
import com.ntiques.model.ShippingAddress;

public class ShippingAddressService {

	@Autowired()
	ShippingAddressDaoImpl ShippingAddressDao;
		
		public void saveOrUpdate(ShippingAddress ShippingAddress)
		{
			ShippingAddressDao.saveOrUpdate(ShippingAddress);
		}
		
		public ShippingAddress getShippingAddress(int ShippingAddressId)
		{
			return ShippingAddressDao.getShippingAddress(ShippingAddressId);
		
		}

		public void deleteShippingAddress(int ShippingAddressId)
		{
			
			 ShippingAddressDao.deleteShippingAddress(ShippingAddressId);
			
			
		}

}
