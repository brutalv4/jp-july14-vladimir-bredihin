package com.kademika.day10.shop.objectz;


public class Customer {

	private String id;
	private String fullName;
	private String birthDate;
	private CustomerCategory category;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public CustomerCategory getCategory() {
		return category;
	}

	public void setCategory(CustomerCategory category) {
		this.category = category;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.getFullName();
	}

}
