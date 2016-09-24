package com.ntiques.handler;

import org.springframework.stereotype.Component;

import com.ntiques.model.User;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;



@Component
public class Demo 
{
	
	public User initFlow()
	{
		return new User();
	}
	
	String status = "success";
	public String validateDetails(User user,MessageContext messageContext){
		String status = "success";
		if(user.getUsername().isEmpty())
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"username").defaultText("UserName cannot be Empty").build());
			status = "failure";
		}
		
	
	if(user.getEnabled()==null)
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"enabled").defaultText("enabled cannot be Empty").build());
		status = "failure";
	}
	if(user.getRole()==null)
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"role").defaultText("Role cannot be Empty").build());
		status = "failure";
	}
	if(user.getPassword().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"password").defaultText("Password cannot be Empty").build());
		status = "failure";
	}
	if(user.getGender().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"gender").defaultText("Gender cannot be Empty").build());
		status = "failure";
	}
	
	if(user.getEmail().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"email").defaultText("Email cannot be Empty").build());
		status = "failure";
	}
	if(user.getBuildingName().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"buildingName").defaultText("Building Name cannot be Empty").build());
		status = "failure";
	}
	if(user.getFlatNo().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"flatNo").defaultText("Flat NO cannot be Empty").build());
		status = "failure";
	}
	if(user.getStreet().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"street").defaultText("Street cannot be Empty").build());
		status = "failure";
	}
	if(user.getCity().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"city").defaultText("City cannot be Empty").build());
		status = "failure";
	}
	if(user.getState().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"state").defaultText("State Name cannot be Empty").build());
		status = "failure";
	}
	if(user.getCountry().isEmpty())
	{
		messageContext.addMessage(new MessageBuilder().error().source(
				"country").defaultText("Country Name cannot be Empty").build());
		status = "failure";
	}
	return status;
	
	
}
}
