package com.ntiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntiques.dao.OrderDetailDaoImpl;
import com.ntiques.dao.OrderedItemsDaoImpl;
import com.ntiques.model.OrderDetail;
import com.ntiques.model.OrderedItems;


@Service
@Transactional
public class OrderedItemsService {

	@Autowired(required=true)
	OrderedItemsDaoImpl OrderedItemsDao;
		
		public void saveOrUpdate(OrderedItems OrderItems)
		{
			OrderedItemsDao.saveOrUpdate(OrderItems);
		}
		
		
		public void delete(int orderItemId)
		{
			
			OrderedItemsDao.delete(orderItemId);
			
			
		}

		public List<OrderedItems> list()
		{
			return OrderedItemsDao.listOrderedItems();
		}

}
