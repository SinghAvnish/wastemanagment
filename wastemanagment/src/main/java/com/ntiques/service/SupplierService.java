package com.ntiques.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.ntiques.dao.SupplierDaoImp;
import com.ntiques.model.Supplier;

@Service
@Transactional
public class SupplierService {

	@Autowired
	SupplierDaoImp SupplierDao;
		public List<Supplier> list(){
			return SupplierDao.list();
		}
		public void saveOrUpdate(Supplier supplier){
			SupplierDao.saveOrUpdate(supplier);
		}
			
		public void delete(int id) {
			SupplierDao.delete(id);
			
		}
		public Supplier get(int id){
			return SupplierDao.get(id);
		}
		
		public Supplier getByName(String name){
			return SupplierDao.getByName(name);
		}
		
		

}
