package com.ntiques.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.BillingAddressDaoImpl;
import com.ntiques.dao.ShippingAddressDaoImpl;
import com.ntiques.model.BillingAddress;
import com.ntiques.model.ShippingAddress;

@Service
@Transactional
public class ShippingAddressService {

	@Autowired(required=true)
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
