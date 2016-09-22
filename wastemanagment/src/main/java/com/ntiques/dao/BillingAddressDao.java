package com.ntiques.dao;


import com.ntiques.model.BillingAddress;

public interface BillingAddressDao 
{
	void saveOrUpdate(BillingAddress billingAddress);

	void deleteBillingAddress(int billingAddressId);

	BillingAddress getBillingAddress(int billingAddressId);
	
}
