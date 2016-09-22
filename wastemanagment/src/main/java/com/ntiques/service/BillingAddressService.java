package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.BillingAddressDaoImpl;
import com.ntiques.model.BillingAddress;

@Service
@Transactional
public class BillingAddressService {
	@Autowired (required=true)
	BillingAddressDaoImpl BillingAddressDao;
		
		public void saveOrUpdate(BillingAddress billingAddress)
		{
			BillingAddressDao.saveOrUpdate(billingAddress);
		}
		
		public BillingAddress getBillingAddress(int BillingAddressId)
		{
			return BillingAddressDao.getBillingAddress(BillingAddressId);
		
		}

		public void deleteBillingAddress(int BillingAddressId)
		{
			
			 BillingAddressDao.deleteBillingAddress(BillingAddressId);
			
			
		}
}
