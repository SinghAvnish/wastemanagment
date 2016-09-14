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
import com.ntiques.model.Product;
import com.ntiques.model.SubCategory;
import com.ntiques.model.User;



@Repository
public class UserDaoImpl implements UserDao {
	public UserDaoImpl() {

	}
	@Autowired
	private SessionFactory sessionFactory;


	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
 public void saveOrUpdate(User user){
	  Session session =sessionFactory.getCurrentSession();
	  Cart cart=new Cart();
	  
	    cart.setUserId(user.getUserId());
		session.saveOrUpdate(cart);
		
		user.setCartid(cart.getCartId());
		session.saveOrUpdate(user);
		cart.setUserId(user.getUserId());
		session.saveOrUpdate(cart);
		session.flush();
		
 }

 
 		public User getById(int userId) 
 		{
		Session session=sessionFactory.openSession();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("userId", userId));
		@SuppressWarnings("unchecked")
		List<User> user = c.list();
		session.flush();
		return user.get(0);	
 		}
 		
 		
			
 
 		public User getByName(String username) 
 		{
 			Session session=sessionFactory.openSession();
 			Criteria c = session.createCriteria(User.class);
 			c.add(Restrictions.eq("username", username));
 			@SuppressWarnings("unchecked")
 			List<User> user = c.list();
 			session.flush();
 			return user.get(0);	
		
 		}
 		
 		public User getByUserName(String username) {
 			
 			String hql = "from User where username=" + "'"+ username +"'";
 			Query query = sessionFactory.getCurrentSession().createQuery(hql);
 			
 			@SuppressWarnings("unchecked")
 			List<User> listProduct = (List<User>) query.list();
 			
 			if (listProduct != null && !listProduct.isEmpty()) {
 				return listProduct.get(0);
 			}
 			
 			return null;
 		}
 		
 		

	
		
}