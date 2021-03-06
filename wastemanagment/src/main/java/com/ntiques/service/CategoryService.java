package com.ntiques.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntiques.dao.CategoryDaoImpl;
import com.ntiques.model.Category;



@Service
@Transactional
public class CategoryService {
	@Autowired
	
CategoryDaoImpl categoryDAO;
	public List<Category> list(){
		return categoryDAO.list();
	}
	public void saveOrUpdate(Category category){
		categoryDAO.saveOrUpdate(category);
	}
		
	public void delete(int id) {
		categoryDAO.delete(id);
		
	}
	public Category get(int id){
		return categoryDAO.get(id);
	}
	
	public Category getByName(String name){
		return categoryDAO.getByName(name);
	}

}

