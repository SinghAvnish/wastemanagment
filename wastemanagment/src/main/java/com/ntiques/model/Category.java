package com.ntiques.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Category implements Serializable
{
	 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
	private int id;
	 @NotEmpty(message="Name is Compulsary")
	private String name;
	 @NotEmpty(message="Description is mandatory")
	private String desc;
	
@ElementCollection
@OneToMany(mappedBy ="category",fetch =FetchType.EAGER)

private Set <SubCategory>subcategory;

public Set<SubCategory> getSubcategory()
{
	return subcategory;
}
public void setSubcategory(Set<SubCategory> subcategory) 
{
	this.subcategory = subcategory;
}

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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString()
	{
		
		return "{id : '" + id + "'," + "name : '" + name + "'," + "desc :'" + desc +"'}";
	}
	

}
