package com.ntiques.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntiques.model.Category;
import com.ntiques.model.Product;
import com.ntiques.model.SubCategory;


@Repository
public class ProductDaoImpl implements ProductDao {
	public ProductDaoImpl() {

	}
	@Autowired
	private SessionFactory sessionFactory;


	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<Product> list() {
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) 
		          sessionFactory.getCurrentSession()
				.createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listProduct;
	}
	public void saveOrUpdate(Product product) 
	{
		
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	public void delete(int id) {
		Product productToDelete = new Product();	
		productToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(productToDelete);
	}


	
	public Product get(int id) {
		
		String hql = "from Product where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		
		return null;
	}
	
     public Product getView(int id) {
		
		String hql = "from Product where id=" + "'"+ id +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		
		
		return null;
	}
	
     
     public Product productdisplay(int id) {
 		
 		String hql = "from Product where id=" + "'"+ id +"'";
 		Query query = sessionFactory.getCurrentSession().createQuery(hql);
 		
 		return null;
 	}
 	
	
	public Product getByName(String name) {
		
		String hql = "from subcategory where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		
		}
		
		return null;
	}
	

}
