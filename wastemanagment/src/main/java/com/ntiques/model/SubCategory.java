package com.ntiques.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
public class SubCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
	private int cat_id;
	@NotNull
	@NotEmpty(message="Name is compulsary")
	private String name;
	@NotEmpty(message="Description is compulsary")
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
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
