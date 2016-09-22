package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ntiques.dao.OrderDetailDaoImpl;
import com.ntiques.model.OrderDetail;

public class OrderDetailService {
	@Autowired()
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
