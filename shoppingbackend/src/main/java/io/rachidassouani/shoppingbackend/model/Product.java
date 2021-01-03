package io.rachidassouani.shoppingbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	@NotBlank(message = "please enter the product name!")
	private String name;
	@NotBlank(message = "please enter the brand name!")
	private String brand;

	@JsonIgnore
	@NotBlank(message = "please enter the product description!")
	private String description;

	@Min(value=1, message = "the price cannot be less than 1")
	private double price;
	private int quantity;

	@JsonIgnore
	@Column(name = "is_active")
	private boolean active;

	private int purchases;
	private int views;

	@JsonIgnore
	@Column(name = "category_id")
	private long categoryId;

	@JsonIgnore
	@Column(name = "supplier_id")
	private long supplierId;

	public Product() {
		this.code = "PRD" + UUID.randomUUID().toString().substring(20).toUpperCase();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + ", active=" + active + ", purchases="
				+ purchases + ", views=" + views + ", categoryId=" + categoryId + ", supplierId=" + supplierId + "]";
	}

	

}
