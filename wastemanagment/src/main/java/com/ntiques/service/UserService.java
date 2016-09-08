  package com.ntiques.service;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  import org.springframework.transaction.annotation.Transactional;
  import com.ntiques.dao.UserDaoImpl;
import com.ntiques.model.User;



  @Service
  @Transactional
public class UserService {
	  
	  @Autowired
	  UserDaoImpl userdao;

	
	  public void saveOrUpdate(User user){
			userdao.saveOrUpdate(user);
		}
		

}
