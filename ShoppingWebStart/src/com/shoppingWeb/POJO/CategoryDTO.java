package com.shoppingWeb.POJO;

public class CategoryDTO {
	
	private  int id = 0;
	private String name;
	private String brand;

	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public  void setId(int id) {
		this.id = id;
	}

	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
