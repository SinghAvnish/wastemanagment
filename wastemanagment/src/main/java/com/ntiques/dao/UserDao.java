package com.ntiques.dao;

import com.ntiques.model.Cart;
import com.ntiques.model.User;


public interface UserDao
{
public void saveOrUpdate(User user);

public User getById(int userid);


public User getByName(String username);

}
