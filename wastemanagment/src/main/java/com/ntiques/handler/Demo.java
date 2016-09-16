package com.ntiques.handler;

import org.springframework.stereotype.Component;


import com.ntiques.model.User;

@Component
public class Demo 
{
	
	public User initFlow()
	{
		return new User();
	}

}
