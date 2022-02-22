package com.example.business;

public class User_Book {
	private int id;
	private int userID;
	private String title;
	private int price;
	private int quantity;
	
	public User_Book(int id, int userID, String title, int price, int quantity) {
		super();
		this.id = id;
		this.userID = userID;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
}
