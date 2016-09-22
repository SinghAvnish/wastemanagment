package com.ntiques.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Cart implements Serializable
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int userId;
	private double grandTotal;
	private int noOfProducts;
	@ElementCollection
	@OneToMany(mappedBy="cart", fetch = FetchType.EAGER)
   /* private Set<CartItem> cartItem;			
	*/
	@OneToOne(mappedBy="cart",cascade=CascadeType.ALL)
	@JoinColumn(name="userId",insertable=false,updatable=false,nullable=false)
	private User user;
	
	public int getCartId() {
		return cartId;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getNoOfProducts() {
		return noOfProducts;
	}
	
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	
	public void setCartId(int cartId) 
	{
		this.cartId = cartId;
	}
/*	public Set<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}*/
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
