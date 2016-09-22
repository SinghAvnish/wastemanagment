package com.ntiques.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.model.BillingAddress;
import com.ntiques.model.CartItem;
import com.ntiques.model.Category;
import com.ntiques.model.Product;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	
	
	public CartItemDaoImpl() {

	}
	@Autowired (required=true)
	private SessionFactory sessionFactory;


	public CartItemDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
		
		@Transactional
		public void saveOrUpdate(CartItem cartItem)
		{
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
		}

		

		@Transactional
		public void delete(int cartitemid) 
		{
			CartItem CartItemToDelete = new CartItem();
			CartItemToDelete.setCartitemid(cartitemid);
			sessionFactory.getCurrentSession().delete(CartItemToDelete);

		}

	
		@Transactional
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
		
		
		@Transactional
		public List<CartItem> listCartItems()
		{
			
			@SuppressWarnings("unchecked")
			List<CartItem> listCartItem = (List<CartItem>) 
			          sessionFactory.getCurrentSession()
					.createCriteria(CartItem.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return listCartItem;
		}
		
		@Transactional
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

	

