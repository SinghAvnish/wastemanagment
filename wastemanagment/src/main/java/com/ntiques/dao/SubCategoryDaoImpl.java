package com.ntiques.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntiques.model.SubCategory;
import com.ntiques.model.SubCategory;
@Repository
public class SubCategoryDaoImpl implements SubCategoryDao{
	public SubCategoryDaoImpl() {
	}

	@Autowired
	private SessionFactory sessionFactory;


	public SubCategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<SubCategory> list() {
		
		@SuppressWarnings("unchecked")
		List<SubCategory> listSubCategory = (List<SubCategory>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(SubCategory.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listSubCategory;
	}
	public  void saveOrUpdate(SubCategory subcategory) {
		
			sessionFactory.getCurrentSession().saveOrUpdate(subcategory);
	}
	

	public void delete(String id) {
		SubCategory SubCategoryToDelete = new SubCategory();
		SubCategoryToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(SubCategoryToDelete);
	}


	
	public SubCategory get(String id) {
		
		//select *from Sub Category where id='101'
		String hql = "from SubCategory where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<SubCategory> listSubCategory = (List<SubCategory>) query.list();
		
		if (listSubCategory != null && !listSubCategory.isEmpty()) {
			return listSubCategory.get(0);
		}
		
		return null;
	}
	public SubCategory getByName(String name) {
		// select *from Category where name=''
		String hql ="from SubCategory where name =" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<SubCategory> listSubCategory = (List<SubCategory>) query.list();
		
		if (listSubCategory != null && !listSubCategory.isEmpty()) {
			return listSubCategory.get(0);
		}
		
		return null;
	}
}
