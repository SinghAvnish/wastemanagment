package com.ntiques.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Supplier")


public class Supplier implements Serializable
{

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @NotEmpty(message="Name is Complulsary")
	private String name;
    @NotEmpty(message="Address is compulsary")
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString()
	{
		
		return "{id : '" + id + "'," + "name : '" + name + "'," + "address :'" + address +"'}";
	}
	
}