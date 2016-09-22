package com.ntiques.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.CartDao;
import com.ntiques.model.Cart;
import com.ntiques.model.OrderedItems;

@Repository("CartDao")
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(Cart cart) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	}

	

	

	public Cart getById(int userId) 
	{
		Session session=sessionFactory.openSession();
		Criteria c = session.createCriteria(Cart.class);
		c.add(Restrictions.eq("userId", userId));
		@SuppressWarnings("unchecked")
		List<Cart> cart = c.list();
		session.flush();
		return cart.get(0);	
			
		}
		
		}	

