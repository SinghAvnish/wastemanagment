package com.ntiques.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntiques.model.User;


@Repository
public class UserDaoImpl implements UserDao {
	public UserDaoImpl() {

	}
	@Autowired
	private SessionFactory sessionFactory;


	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

}