package com.ntiques.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntiques.model.CartItem;
import com.ntiques.model.Category;
import com.ntiques.model.Product;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	
	public CartItemDaoImpl() {

	}
	@Autowired
	private SessionFactory sessionFactory;


	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public List<CartItem> list()
	{
		
		@SuppressWarnings("unchecked")
		List<CartItem> listCartItem = (List<CartItem>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(CartItem.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listCartItem;
	}
	
	public void saveOrUpdate(CartItem cartitem) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cartitem);
	}
	
	
}
