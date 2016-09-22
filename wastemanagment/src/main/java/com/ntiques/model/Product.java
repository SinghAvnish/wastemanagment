package com.ntiques.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
@Entity

public class Product implements Serializable
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private int sub_id;
	private int supplier_id;
	@NotEmpty(message="Name is compulsory")
	private String name;
	
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}


	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}


	@NotEmpty(message="Description is compulsory")
	private String desc;
	@NotNull
	private int qty;
   
	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	@Transient
	private MultipartFile image;
	@NotNull(message="price is compulsary")
	private int price;
	
	@ManyToOne
	@JoinColumn(name="sub_id", insertable=false, updatable=false, nullable=false)
	SubCategory subcategory;
	@ManyToOne
	@JoinColumn(name="supplier_id", insertable=false, updatable=false, nullable=false)
	Supplier supplier;

		
	

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public int getSub_id() {
		return sub_id;
	}


	public int getSupplier_id() {
		return supplier_id;
	}


	

	

	
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
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



	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}





	public SubCategory getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public String toString()
	{
		
		return "{id : '" + id + "'," + "sub_id : '" + sub_id +"', "+"supplier_id : '" + supplier_id + "'," + "name :'" + name + "'," + "desc :'" + desc + "',"+"qty :'," + qty +  "'," + "price :'" + price + "'," + "image :'resources/images/" +id + ".jpg'}";
	}
}


