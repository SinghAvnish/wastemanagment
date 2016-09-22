package com.ntiques.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.ShippingAddressDao;
import com.ntiques.model.ShippingAddress;

@Repository("shippingAddressDAO")
public class ShippingAddressDaoImpl implements ShippingAddressDao {

	@Autowired
	SessionFactory sessionFactory;

	public ShippingAddressDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
@Transactional
	public void saveOrUpdate(ShippingAddress shippingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);

	}

@Transactional
	public void deleteShippingAddress(int shippingAddressId) {
	ShippingAddress shippingAddressToDelete = new ShippingAddress();
	shippingAddressToDelete.setShippingAddressId(shippingAddressId);
	sessionFactory.getCurrentSession().delete(shippingAddressToDelete);

	}

@Transactional
	public ShippingAddress getShippingAddress(int shippingAddressId) {
		
		return sessionFactory.getCurrentSession().get(ShippingAddress.class, shippingAddressId);
	}

}

