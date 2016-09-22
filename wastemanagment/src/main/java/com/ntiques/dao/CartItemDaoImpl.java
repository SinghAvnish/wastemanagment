package com.ntiques.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntiques.model.CartItem;



@Repository
public class CartItemDaoImpl implements CartItemDao
{
	
@Autowired (required=true)
	private SessionFactory sessionFactory;


	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
		
		
		public void saveOrUpdate(CartItem cartItem)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		}

		

		
		public void delete(int cartitemid) 
		{
			CartItem CartItemToDelete = new CartItem();
			CartItemToDelete.setCartitemid(cartitemid);
			sessionFactory.getCurrentSession().delete(CartItemToDelete);

		}

	
		
		public CartItem getCartItem(int cartitemid) 
		{
			
			String hql = "from CartItem where cartitemid=" + "'"+ cartitemid +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<CartItem> listCartItem = (List<CartItem>) query.list();
			
			if (listCartItem != null && !listCartItem.isEmpty()) {
				return listCartItem.get(0);
			}
			
			return null;
		}
		
		
		
		public List<CartItem> listCartItems()
		{
			
			@SuppressWarnings("unchecked")
			List<CartItem> listCartItem = (List<CartItem>) 
			          sessionFactory.getCurrentSession()
					.createCriteria(CartItem.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return listCartItem;
		}
		
		
		public List<CartItem> getCartItemsByUserId(int userId)
		{
			
			@SuppressWarnings("unchecked")
			List<CartItem> listCartItem = (List<CartItem>) 
			          sessionFactory.getCurrentSession()
					.createCriteria(CartItem.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return listCartItem;
		}


		




		
		
		
	}

	

