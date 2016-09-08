package com.ntiques.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntiques.dao.ProductDaoImpl;

import com.ntiques.model.Product;



@Service
@Transactional
public class ProductService {

	@Autowired
	ProductDaoImpl ProductDao;
	
		public List<Product> list(){
			return ProductDao.list();
		}
		
		public void saveOrUpdate(Product product){
			ProductDao.saveOrUpdate(product);
		}
			
		public void delete(String id) {
			ProductDao.delete(id);
			
		}
		public Product get(String id){
			return ProductDao.get(id);
		
		}
		
		public Product getView(String id){
			return ProductDao.getView(id);
		}
		
		public Product getByName(String name)
		{
			return ProductDao.getByName(name);
		}


}
