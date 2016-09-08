package com.ntiques.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntiques.dao.SubCategoryDaoImpl;
import com.ntiques.model.SubCategory;

@Service
@Transactional
public class SubCategoryService {

	@Autowired
	SubCategoryDaoImpl SubCategoryDao;
	
	
		public List<SubCategory> list(){
			return SubCategoryDao.list();
		}
		public void saveOrUpdate(SubCategory subcategory){
			SubCategoryDao.saveOrUpdate(subcategory);
		}
			
		public void delete(String id) {
			SubCategoryDao.delete(id);
			
		}
		public SubCategory get(String id){
			return SubCategoryDao.get(id);
		}
		
		public SubCategory getByName(String name){
			return SubCategoryDao.getByName(name);
		}
		
		

}
