package com.ntiques.model;

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

import org.springframework.stereotype.Component;

@Component
@Entity

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
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

	public String getId()
	{
		return id;
	}
	public void setId(String id) {
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
