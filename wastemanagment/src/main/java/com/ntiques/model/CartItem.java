package com.ntiques.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItem implements Serializable

{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartitemid;
	private int cartid;
	private int prodid;
	@NotEmpty(message="Product Name cannot be empty")
	private String prodname;
	@NotNull		
	private int price;
	@NotNull
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name="cartid",insertable=false,updatable=false,nullable=false)
	Cart cart;
	
	@ManyToOne
	@JoinColumn(name="prodid",insertable=false,updatable=false,nullable=false)
	Product product;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

	
	public String toString()
	{
		
		return "{cartitemid : '" + cartitemid + "'," + "cartid : '" + cartid +"', "+"prodid : '" + prodid + "'," + "prodname :'" + prodname + "'," + "price:'" + price + "',"+"quantity :'" + quantity + "',}";
	}
}
