package com.model;

public class Tag {
	
	public Tag(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
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
}
