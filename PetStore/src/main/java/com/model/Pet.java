package com.model;

public class Pet {
	public Pet(int id, String name, String photo, int categoryid, int tagid, String status) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.category = categoryid;
		this.tag = tagid;
		this.status = status;
	}
	public Pet() {
		
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private int id;
	private String name;
	private String photo;
	private int category;
	private int tag;
	private String status;
}


