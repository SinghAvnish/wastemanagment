package com.ntiques.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntiques.model.Cart;
import com.ntiques.model.CartItem;
import com.ntiques.model.User;

@Repository
public class CartDaoImpl implements CartDao 
{
	
	public CartDaoImpl() {

	}
	@Autowired
	private SessionFactory sessionFactory;


	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
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