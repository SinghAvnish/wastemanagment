package com.ntiques.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.OrderedItemsDao;
import com.ntiques.model.OrderDetail;
import com.ntiques.model.OrderedItems;

@Repository("OrderedItemsDao")
public class OrderedItemsDaoImpl implements OrderedItemsDao {

	@Autowired
	SessionFactory sessionFactory;

	public OrderedItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(OrderedItems orderedItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderedItems);

	}

	@Transactional
	public void delete(int orderedItemId) {
		OrderedItems orderedItemsTodelete = new OrderedItems();
		orderedItemsTodelete.setOrderedItemId(orderedItemId);
		sessionFactory.getCurrentSession().delete(orderedItemsTodelete);

	}

/*	@Transactional
	public List<OrderedItems> listOrderedItems() {
		String hql="from OrderedItems";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderedItems> listOfOrderedItems = query.getResultList();
		return listOfOrderedItems;
	}
	*/
	public List<OrderedItems> listOrderedItems()
	{
		
		@SuppressWarnings("unchecked")
		List<OrderedItems> listOrderedItems = (List<OrderedItems>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(OrderedItems.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listOrderedItems;
	}

}
