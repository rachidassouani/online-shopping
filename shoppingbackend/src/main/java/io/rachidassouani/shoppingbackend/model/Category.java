package io.rachidassouani.shoppingbackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String code;
	private String name;
	private String description;
	
	@Column(name = "image_url")
	private String imageURL;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	public Category() {
		this.code = "CTR" + UUID.randomUUID().toString().substring(20).toUpperCase();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
