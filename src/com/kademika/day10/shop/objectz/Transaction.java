package com.kademika.day10.shop.objectz;

import java.text.SimpleDateFormat;

public class Transaction {

	private int number;
	private int dayOfWeek;
	private String date;
	private String customer;
	private String buyingItem;
    private String comment;
	private int price;
	private int quantity;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Transaction() {
	}

	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getBuyingItem() {
		return buyingItem;
	}

	public void setBuyingItem(String buyingItem) {
		this.buyingItem = buyingItem;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return this.getNumber() + ". " + this.getDate() + " - "+ this.getCustomer() + " - "
				+ this.getBuyingItem() + " - $" + this.getPrice() + " - qty. " + this.getQuantity();
	}

}
