package com.ntiques.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;


import org.springframework.stereotype.Component;

@Component
@Entity
public class SubCategory {
	@Id
	private String id;
	private String cat_id;
	private String name;
	private String desc;
	
	
	@ManyToOne
	@JoinColumn(name="cat_id", insertable=false, updatable=false, nullable=false)
	private Category category;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCat_id() {
		return cat_id;
	}
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
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
		
		return "{id : '" + id + "'," + "cat_id : '" + cat_id +"', " + "name :'" + name + "'," + "desc :'" + desc +"'}";
	}
	

}
