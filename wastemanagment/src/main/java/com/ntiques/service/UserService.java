  package com.ntiques.service;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  import org.springframework.transaction.annotation.Transactional;
  import com.ntiques.dao.UserDaoImpl;
import com.ntiques.model.SubCategory;
import com.ntiques.model.User;



  @Service
  @Transactional
public class UserService {
	  
	  @Autowired
	  UserDaoImpl userdao;

	
	  public void saveOrUpdate(User user)
	  {
			userdao.saveOrUpdate(user);
	  }
		
	  public User getByUserName(String username) 
		{
		  return userdao.getByUserName(username);
		}
		
	  public User getByName(String username) {
		  return userdao.getByName(username);
	  }
	  
	  public int user_id(String username) {
		  return userdao.getByName(username).getUserId();
	  }
	  
	  public User getById(int userid) 
	  {
		  return userdao.getById(userid);
	  }

	  public String User(String username)
		{
			return userdao.getByName(username).getUsername();
		}
}
