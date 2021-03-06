package com.ntiques.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.OrderDetailDao;
import com.ntiques.model.CartItem;
import com.ntiques.model.OrderDetail;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	SessionFactory sessionFactory;

	public OrderDetailDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	public void saveOrUpdate(OrderDetail orderDetail) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);

	}

	
	public void delete(int orderDetailId) {
		OrderDetail orderDetailTodelete = new OrderDetail();
		orderDetailTodelete.setOrderDetailId(orderDetailId);

	}

	
	public List<OrderDetail> listOrderDetails()
	{
		
		@SuppressWarnings("unchecked")
		List<OrderDetail> listOrderDetails = (List<OrderDetail>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(OrderDetail.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listOrderDetails;
	}

	
}
