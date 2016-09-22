package com.ntiques.dao;



	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.ntiques.dao.BillingAddressDao;
	import com.ntiques.model.BillingAddress;

	@Repository("BillingAddressDao")
	public class BillingAddressDaoImpl implements BillingAddressDao {

		@Autowired (required=true)
		SessionFactory sessionFactory;

		public BillingAddressDaoImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory = sessionFactory;
		}

		@Transactional
		public void saveOrUpdate(BillingAddress billingAddress) {
			sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);

		}

		@Transactional
		public void deleteBillingAddress(int billingAddressId) 
		{
			BillingAddress billingAddressToDelete = new BillingAddress();
			billingAddressToDelete.setBillingAddressId(billingAddressId);
			sessionFactory.getCurrentSession().delete(billingAddressToDelete);

		}

		@Transactional
		public BillingAddress getBillingAddress(int billingAddressId)
		{
			return sessionFactory.getCurrentSession().get(BillingAddress.class, billingAddressId);
		}

	}


