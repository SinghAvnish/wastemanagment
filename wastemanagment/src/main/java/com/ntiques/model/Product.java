package com.ntiques.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
@Entity
public class Product {
	@Id
	private String id;
	private String sub_id;
	private String supplier_id;
	@NotEmpty(message="Name is compulsory")
	private String name;
	@NotEmpty(message="Description is compulsory")
	private String desc;
	
	private int qty;
    @Transient
	private MultipartFile image;
	
	private int price;
	@ManyToOne
	@JoinColumn(name="sub_id", insertable=false, updatable=false, nullable=false)
	SubCategory subcategory;
	@ManyToOne
	@JoinColumn(name="supplier_id", insertable=false, updatable=false, nullable=false)
	Supplier supplier;

		
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSub_id() {
		return sub_id;
	}


	public void setSub_id(String sub_id) {
		this.sub_id = sub_id;
	}


	public String getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
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


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
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


