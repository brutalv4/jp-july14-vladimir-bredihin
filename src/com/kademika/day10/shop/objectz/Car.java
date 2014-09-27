package com.kademika.day10.shop.objectz;


public class Car {

	private String id;
	private String manufacturer;
	private String modelName;
	private int horsePowerAmount;
	private int wheelDrive;
	private int modelYear;
	private BodyType bodyType;
	private Color exteriorColor;
	private Color interiorColor;
	private int price;

	public Car() {
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public Color getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(Color exteriorColor) {
		this.exteriorColor = exteriorColor;
	}

	public Color getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(Color interiorColor) {
		this.interiorColor = interiorColor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printDetailedInfo(Car car) {
		System.out.println("Manufacturer: " + this.getManufacturer());
		System.out.println("Model: " + this.getModelName());
		System.out.println("Made year: " + this.getModelYear());
		System.out.println("Body type: " + this.getBodyType());
		System.out.println("Exterior color: " + this.getExteriorColor());
		System.out.println("Interior color: " + this.getInteriorColor());
	}

	@Override
	public String toString() {
		String resultString = modelYear + " "
				+ this.getManufacturer() + " " + this.getModelName();
		return resultString;
	}

	public int getHorsePowerAmount() {
		return horsePowerAmount;
	}

	public void setHorsePowerAmount(int horsePowerAmount) {
		this.horsePowerAmount = horsePowerAmount;
	}

	public int getWheelDrive() {
		return wheelDrive;
	}

	public void setWheelDrive(int wheelDrive) {
		this.wheelDrive = wheelDrive;
	}

	public String getCatNum() {
		return "#" + id;
	}

	public void setCatNum(String catNum) {
		this.id = catNum;
	}
}
