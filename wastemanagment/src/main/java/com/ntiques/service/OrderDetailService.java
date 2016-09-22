package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.OrderDetailDaoImpl;
import com.ntiques.model.OrderDetail;

@Service
@Transactional
public class OrderDetailService 
{
	@Autowired(required=true)
	
	OrderDetailDaoImpl OrderDetailDao;
		
		public void saveOrUpdate(OrderDetail OrderDetail)
		{
			OrderDetailDao.saveOrUpdate(OrderDetail);
		}
		
		
		public void delete(int orderDetailId)
		{
			
			 OrderDetailDao.delete(orderDetailId);
			
			
		}

		public List<OrderDetail> list()
		{
			return OrderDetailDao.listOrderDetails();
		}

}
