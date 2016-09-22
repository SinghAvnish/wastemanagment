package com.ntiques.dao;


import java.util.List;

import com.ntiques.model.OrderedItems;

public interface OrderedItemsDao{

	void saveOrUpdate(OrderedItems orderedItems );
	
	void delete(int orderedItemId);
	
	List<OrderedItems> listOrderedItems();
}

