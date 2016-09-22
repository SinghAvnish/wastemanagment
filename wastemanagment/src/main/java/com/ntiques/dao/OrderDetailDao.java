package com.ntiques.dao;

import java.util.List;

import com.ntiques.model.OrderDetail;

public interface OrderDetailDao 
{

	void saveOrUpdate(OrderDetail orderDetail);

	void delete(int orderDetailId);

	List<OrderDetail> listOrderDetails();

}

